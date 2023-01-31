package com.Service;

import com.pojo.Relations;

public interface RelationsService {
    String getRelationsByContent(String content);
    Relations getRelationObjByRela(String rela);
    boolean addRelationsBySpeakContent(String content, String[] relations);
    boolean delRelationsByContent(String content);
}
