package com.example.learninghttprequest.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    private String title;
    private Long date;
    private String img;
    private String markdown;
    private String alt;
    private String category;
    private String slug;
    private String desc;

    // setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    // getters

    public String getTitle() {
        return title;
    }

    public Long getDate() {
        return date;
    }

    public String getImg() {
        return img;
    }

    public String getMarkdown() {
        return markdown;
    }

    public String getAlt() {
        return alt;
    }

    public String getCategory() {
        return category;
    }

    public String getSlug() {
        return slug;
    }

    public String getDesc() {
        return desc;
    }

    // toString
    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", img='" + img + '\'' +
                ", markdown='" + markdown + '\'' +
                ", alt='" + alt + '\'' +
                ", category='" + category + '\'' +
                ", slug='" + slug + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
