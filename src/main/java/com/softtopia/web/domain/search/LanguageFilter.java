package com.softtopia.web.domain.search;

/**
 * softtopia-web
 * File Created by jordi on 25/10/16.
 */
public class LanguageFilter {
    Long count;
    Long id;
    String language;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
