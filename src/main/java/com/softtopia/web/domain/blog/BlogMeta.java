package com.softtopia.web.domain.blog;

import org.joda.time.DateTime;

import java.util.List;

/**
 * softtopia-web
 * File Created by jordi on 12/10/16.
 */
public class BlogMeta {
    String title;
    String imagePath;
    String description;
    String tags;
    String keywords;
    String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDate() {
        return date;
    }

    public DateTime getDateTime() {
        return DateTime.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
