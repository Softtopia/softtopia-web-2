package com.softtopia.web.domain.blog;

/**
 * softtopia-web
 * File Created by jordi on 12/10/16.
 */
public class IdBlogDescriptor extends BlogDescriptor {

    private String id;

    public IdBlogDescriptor(String id, BlogDescriptor descriptor) {
        super.setMeta(descriptor.getMeta());
        super.setSource(descriptor.getSource());
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
