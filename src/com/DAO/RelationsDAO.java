package com.DAO;

import com.pojo.Relations;

import java.util.List;

public interface RelationsDAO {
    boolean addRelation(Relations relation);  //Ҫ���ӵĿ����ж�������Դ����������ַ���
    boolean delRelation(String content);
    List<Relations> getRelations(String query, Object... params);
}