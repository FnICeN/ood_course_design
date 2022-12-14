package com.DAO.Impl;

import com.DAO.BaseDAO;
import com.DAO.RelationsDAO;
import com.Exceptions.DAOException;
import com.pojo.Relations;

import java.util.List;

public class RelationsDAOImpl extends BaseDAO<Relations> implements RelationsDAO {
    @Override
    public boolean addRelation(Relations relation) {
        try{
            int res = super.update("insert into relation values(?,?)", relation.getContent(), relation.getRela());
            System.out.println("添加完成，" + res + "行受影响");
        }catch(DAOException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delRelation(String content) {
        try{
            int res = super.update("delete from relation where content=?", content);
            System.out.println("删除完成，" + res + "行受影响");
        }catch(DAOException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Relations> getRelations(String query, Object... params) {
        return super.getSeriesObj(query, params);
    }
}
