package com.github.jasonj1102.aesspringbootstarter.utils;


/**
 * @author jie
 * @version 1.0
 * success come from self-discipline
 * @date 2021/4/14 23:01
 */
public class EncryptProperties {
    private final static String DEFAULT_KEY = "yy<<z..ww..j>>ds";
    private String key = DEFAULT_KEY;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
