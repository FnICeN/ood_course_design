package com.DAO.Impl;

import com.DAO.BaseDAO;
import com.DAO.SpeaksDAO;
import com.Exceptions.DAOException;
import com.pojo.Speaks;

import java.util.List;

public class SpeaksDAOImpl extends BaseDAO<Speaks> implements SpeaksDAO {
    @Override
    public boolean addSpeak(Speaks speak) {
        try {
            int res = super.update("insert into cyberspeak values(?,?,?,?,?,?)", speak.getContent(), speak.getOrigin(), speak.getOrigin_mean(), speak.getNow_mean(), speak.getUsing(), speak.getSentence());
            System.out.println("添加完成，" + res + "行受影响");
        }catch(DAOException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delSpeak(String content) {
        try{
            int res = super.update("delete from cyberspeak where content=?", content);
            System.out.println("删除完成，" + res + "行受影响");
        }catch (DAOException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean reviseSpeak(String origin, String origin_mean, String now_mean, String using, String sentence, String content) {
        try{
            System.out.println(origin);
            int res = super.update("update cyberspeak set origin=?,origin_mean=?,now_mean=?,`using`=?,sentence=? where content=?",
                    origin, origin_mean, now_mean, using, sentence, content);
            System.out.println("修改完成，" + res + "行受影响");
        }catch (DAOException e){
            return false;
        }
        return true;
    }

    @Override
    public Speaks getSpeak(String content) {
        return super.getOneObj("select * from cyberspeak where content=?", content);
    }

    @Override
    public List<Speaks> getSpeaks(String query, Object... params) {
        return super.getSeriesObj(query, params);
    }
}
