package com.DAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Exceptions.DAOException;
import com.Utils.ConnUtil;

//此类目的是提供一个以方法为基础的SQL语句执行通道
public class BaseDAO<T> {
    private Connection connection = null;
    private Class superClass;
    private PreparedStatement ps;

    public BaseDAO() {
        //genericType其实是BaseDAO的Class
        Type genericType = getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        Type actualType = actualTypeArguments[0];
        try {
            superClass = Class.forName(actualType.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO出错，检查泛型设置");
        }


    }

    private boolean isDefaultType(String typeName) {
        return "java.lang.String".equals(typeName)
                || "java.lang.Integer".equals(typeName)
                || "java.util.Date".equals(typeName)
                || "java.sql.Date".equals(typeName);
    }

    private boolean isNotDefaultType(String typeName) {
        return !isDefaultType(typeName);
    }

    private void setParams(PreparedStatement ps, Object... params) throws SQLException {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++)
                ps.setObject(i + 1, params[i]);
        }
    }

    private void setValues(Object Obj, String name, Object value) {
        Field field = null;  //通过提供的属性名，拿到传入的目标对象的内部属性
        try {
            field = Obj.getClass().getDeclaredField(name);
            String typeName = field.getType().getName();   //获取该署名类型名称，看是不是自己写的类
            if (isNotDefaultType(typeName)) {  //是自己写的类
                //创建一个此类实例
                value = Class.forName(typeName).getDeclaredConstructor().newInstance();
            }
            //将对象赋值给属性
            field.setAccessible(true);
            field.set(Obj,value);
        } catch (NoSuchFieldException | ClassNotFoundException | InvocationTargetException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException e) {
            throw new DAOException("BaseDAO的setValues出错");
        }

    }

    public int update(String query, Object... params){
        connection = ConnUtil.getConn();
        try{
            ps = connection.prepareStatement(query);
            setParams(ps, params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO更新数据相关操作失败");
        }

    }

    public T getOneObj(String query, Object... params) {
        connection = ConnUtil.getConn();
        ResultSet resultSet;
        try {
            ps = connection.prepareStatement(query);
            setParams(ps, params);
            resultSet = ps.executeQuery();   //获取结果

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();  //得到MetaData，用于得到列数和获取列名
            int len = resultSetMetaData.getColumnCount();

            if (resultSet.next()) {
                T Obj = (T) superClass.getConstructor().newInstance();   //实例化一个T
                for(int i=0;i<len;i++) {
                    //往T里塞值
                    setValues(Obj,resultSetMetaData.getColumnName(i+1),resultSet.getObject(i+1));
                }
                return Obj;
            }
        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                 InstantiationException e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO获取单对象失败");
        }
        return null;
    }
    public List<T> getSeriesObj(String query, Object... params) {
        connection = ConnUtil.getConn();
        ResultSet resultSet;
        List<T> res = new ArrayList<T>();
        try {
            ps = connection.prepareStatement(query);
            setParams(ps,params);
            resultSet = ps.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();  //得到MetaData，用于得到列数和获取列名
            int len = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                T Obj = (T) superClass.getConstructor().newInstance();   //实例化一个T
                for(int i=0;i<len;i++) {
                    //往T里塞值
                    setValues(Obj,resultSetMetaData.getColumnName(i+1),resultSet.getObject(i+1));
                }
                res.add(Obj);
            }
        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO获取多对象失败");
        }
        return res;
    }

}
