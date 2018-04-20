package com.shanghui.meixian.http.bean;

public class PersonBean {
    private String name;
    private String pinyin;

    public PersonBean() {
    }

    public PersonBean(String name, String pinyin) {
        this.name = name;
        this.pinyin = pinyin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
