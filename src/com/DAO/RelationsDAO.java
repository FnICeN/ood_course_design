package com.DAO;

import com.pojo.Relations;

import java.util.List;

public interface RelationsDAO {
    boolean addRelation(Relations relation);  //要添加的可能有多个，所以传入对象而非字符串
    boolean delRelation(String content);
    Relations getRelationObjByRelation(String rela);
    List<Relations> getRelations(String query, Object... params);
}
