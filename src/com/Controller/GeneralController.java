package com.Controller;

import com.Service.Impl.RelationsServiceImpl;
import com.Service.Impl.SpeaksServiceImpl;
import com.Service.RelationsService;
import com.Service.SpeaksService;
import com.pojo.Relations;
import com.pojo.Speaks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralController {
    RelationsService rsi = new RelationsServiceImpl();
    SpeaksService ssi = new SpeaksServiceImpl();
    public List<Speaks> getAllSpeaks() {
        return ssi.getAllSpeaks();
    }
    public String[] getSpeakArrayByContent(String content) {
        Speaks speak = ssi.getSpeakByContent(content);
        return speak.getFields();
    }
    public String getRelationsByContent(String content) {
        return rsi.getRelationsByContent(content);
    }
    public String[] searchByContentOrRelation(String m) {
        Speaks speak_direct = ssi.getSpeakByContent(m);
        if(speak_direct == null) {
            Relations relation = rsi.getRelationObjByRela(m);
            if(relation != null) {
                Speaks speak_other;
                speak_other = ssi.getSpeakByContent(relation.getContent());
                return speak_other.getFields();
            }
            return null;
        }
        return speak_direct.getFields();
    }
    public boolean addSpeakAndRelation(String content, String origin, String origin_mean, String now_mean, String using, String sentence, String relations) {
        boolean addRelation = true;
        boolean addSpeak = ssi.addSpeak(content, origin, origin_mean, now_mean, using, sentence);
        if(!"".equals(relations) && addSpeak)  //在插入Speak成功的前提下，才能插入相关词
            addRelation = rsi.addRelationsBySpeakContent(content, relations.split(" "));
        return addSpeak && addRelation;
    }
    public boolean deleteSpeakAndRelationsBySelected(String selected) {
        boolean delSpeak = true;
        boolean delRelations = rsi.delRelationsByContent(selected);
        if(delRelations)
            delSpeak = ssi.delSpeakByContent(selected);
        return delRelations && delSpeak;
    }
    public boolean reviseSpeakAndRelationsBySelected(String origin, String origin_mean, String now_mean, String using, String sentence, String relations, String selected) {
        boolean reviseSpeak = ssi.reviseSpeakByContent(origin, origin_mean, now_mean, using, sentence, selected);
        boolean reviseRelations = true;
        if(reviseSpeak) {
            reviseRelations = rsi.delRelationsByContent(selected) &&
                              rsi.addRelationsBySpeakContent(selected, relations.split(" "));
        }
        return reviseSpeak && reviseRelations;

    }
}
