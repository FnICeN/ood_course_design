package com.Service.Impl;

import com.DAO.BaseDAO;
import com.DAO.Impl.RelationsDAOImpl;
import com.DAO.Impl.SpeaksDAOImpl;
import com.DAO.RelationsDAO;
import com.DAO.SpeaksDAO;
import com.Service.SpeaksService;
import com.pojo.Speaks;

import java.util.List;

public class SpeaksServiceImpl extends BaseDAO<Speaks> implements SpeaksService {
    private SpeaksDAO sdi = new SpeaksDAOImpl();
    private RelationsDAO rdi = new RelationsDAOImpl();

    @Override
    public boolean addSpeak(String content, String origin, String origin_mean, String now_mean, String using, String sentence) {
        Speaks speak = new Speaks();
        speak.setContent(content);
        speak.setOrigin(origin);
        speak.setOrigin_mean(origin_mean);
        speak.setNow_mean(now_mean);
        speak.setUsing(using);
        speak.setSentence(sentence);
        return sdi.addSpeak(speak);
    }

    @Override
    public boolean delSpeakByContent(String content) {
        return sdi.delSpeak(content);
    }

    @Override
    public void delSpeakByObj(Speaks speak) {
        sdi.delSpeak(speak.getContent());
    }

    @Override
    public boolean reviseSpeakByContent(String origin, String origin_mean, String now_mean, String using, String sentence, String content){
        return sdi.reviseSpeak(origin, origin_mean, now_mean, using, sentence, content);
    }

    @Override
    public Speaks getSpeakByContent(String content) {
        return sdi.getSpeak(content);
    }

    @Override
    public List<Speaks> getAllSpeaks() {
        return sdi.getSpeaks("select * from cyberspeak");
    }
}
