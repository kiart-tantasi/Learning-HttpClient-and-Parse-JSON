package com.example.learninghttpclient.jackson;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;

public class ArticleJsonAnySetter {
    public String title;
    public HashMap<String, Object> map = new HashMap<>();

    @JsonAnySetter
    public void setMap(String key, Object value) {
        map.put(key,value);
    }


}
