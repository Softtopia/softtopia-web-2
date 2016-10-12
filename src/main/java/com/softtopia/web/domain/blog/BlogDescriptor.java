package com.softtopia.web.domain.blog;

/**
 * softtopia-web
 * File Created by jordi on 12/10/16.
 */
public class BlogDescriptor {
    BlogSource source;
    BlogMeta meta;

    public BlogSource getSource() {
        return source;
    }

    public void setSource(BlogSource source) {
        this.source = source;
    }

    public BlogMeta getMeta() {
        return meta;
    }

    public void setMeta(BlogMeta meta) {
        this.meta = meta;
    }
}
