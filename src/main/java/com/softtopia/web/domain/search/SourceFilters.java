package com.softtopia.web.domain.search;

/**
 * softtopia-web
 * File Created by jordi on 25/10/16.
 */
public class SourceFilters {
    Long count;
    String Source;
    Long id;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
