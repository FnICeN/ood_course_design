package com.pojo;

public class Relations {
    private String content;
    private String rela;

    public Relations() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRela() {
        return rela;
    }

    public void setRela(String rela) {
        this.rela = rela;
    }

    public String[] getFields() {
        return new String[]{content, rela};
    }

    @Override
    public String toString() {
        return "relations{" +
                "content='" + content + '\'' +
                ", rela='" + rela + '\'' +
                '}';
    }
}
