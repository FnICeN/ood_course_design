package com.pojo;

public class Speaks {
    private String content;
    private String origin;
    private String origin_mean;
    private String now_mean;
    private String using;
    private String sentence;

    public Speaks() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin_mean() {
        return origin_mean;
    }

    public void setOrigin_mean(String origin_mean) {
        this.origin_mean = origin_mean;
    }

    public String getNow_mean() {
        return now_mean;
    }

    public void setNow_mean(String now_mean) {
        this.now_mean = now_mean;
    }

    public String getUsing() {
        return using;
    }

    public void setUsing(String using) {
        this.using = using;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String[] getFields() {
        return new String[]{content, origin, origin_mean, now_mean, using, sentence};
    }

    @Override
    public String toString() {
        return "Speaks{" +
                "content='" + content + '\'' +
                ", origin='" + origin + '\'' +
                ", origin_mean='" + origin_mean + '\'' +
                ", now_mean='" + now_mean + '\'' +
                ", using='" + using + '\'' +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
