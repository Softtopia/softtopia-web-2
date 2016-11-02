package com.softtopia.web.web.rest;

import ch.qos.logback.classic.LoggerContext;
import com.codahale.metrics.annotation.Timed;
import com.softtopia.web.domain.blog.BlogDescriptor;
import com.softtopia.web.domain.blog.IdBlogDescriptor;
import com.softtopia.web.service.BlogResourcesService;
import com.softtopia.web.web.rest.dto.LoggerDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * softtopia-web
 * File Created by jordi on 12/10/16.
 */
@RestController
@RequestMapping("/api")
public class BlogResource {


    @Autowired
    BlogResourcesService service;


    @RequestMapping(value = "/blogs",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<IdBlogDescriptor> getList() throws IOException {
        return service.getBlogDescriptors().values();
    }

    @RequestMapping(value = "/blogs/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public String get(@PathVariable String id) throws IOException {
        //TODO: Control exceptions.
        return service.getBlogSourceString(id);
    }


}


