package com.Service;

import com.pojo.Speaks;

import java.util.List;

public interface SpeaksService {
    boolean addSpeak(String content, String origin, String origin_mean, String now_mean, String using, String sentence);
    boolean delSpeakByContent(String content);
    void delSpeakByObj(Speaks speak);
    boolean reviseSpeakByContent(String origin, String origin_mean, String now_mean, String using, String sentence, String content);
    Speaks getSpeakByContent(String content);
    List<Speaks> getAllSpeaks();
}
