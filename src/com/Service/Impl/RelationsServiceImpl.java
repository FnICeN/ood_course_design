package com.Service.Impl;

import com.DAO.BaseDAO;
import com.DAO.Impl.RelationsDAOImpl;
import com.DAO.RelationsDAO;
import com.Service.RelationsService;
import com.pojo.Relations;

import java.util.List;

public class RelationsServiceImpl extends BaseDAO<Relations> implements RelationsService {
    private RelationsDAO rdi = new RelationsDAOImpl();
    @Override
    public String getRelationsByContent(String content) {
        List<Relations> relationsList = rdi.getRelations("select * from relation where content=?", content);
        StringBuilder sb = new StringBuilder();
        sb.append("：");
        for(Relations r : relationsList){
            sb.append(r.getRela());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public Relations getRelationObjByRela(String rela) {
        return rdi.getRelationObjByRelation(rela);
    }

    @Override
    public boolean addRelationsBySpeakContent(String content, String[] relations) {
        for(String rela : relations) {
            Relations r = new Relations();
            r.setContent(content);
            r.setRela(rela);
            if(!rdi.addRelation(r))
                return false;
        }
        System.out.println("别名添加成功");
        return true;
    }

    @Override
    public boolean delRelationsByContent(String content) {
        return rdi.delRelation(content);
    }
}
