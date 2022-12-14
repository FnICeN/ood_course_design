package com.DAO;

import com.pojo.Speaks;

import java.util.List;

public interface SpeaksDAO {
    boolean addSpeak(Speaks speak);
    boolean delSpeak(String content);
    boolean reviseSpeak(String origin, String origin_mean, String now_mean, String using, String sentence, String content);
    Speaks getSpeak(String content);
    List<Speaks> getSpeaks(String query, Object... params);
}
