package com.Service;

import com.pojo.Relations;

public interface RelationsService {
    String getRelationsByContent(String content);
    boolean addRelationsBySpeakContent(String content, String[] relations);
    boolean delRelationsByContent(String content);
}
