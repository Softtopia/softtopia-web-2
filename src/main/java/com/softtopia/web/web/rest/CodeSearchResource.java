package com.softtopia.web.web.rest;

import com.softtopia.web.domain.blog.IdBlogDescriptor;
import com.softtopia.web.domain.search.CodeSearchResult;
import com.softtopia.web.service.CodeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * softtopia-web
 * File Created by jordi on 25/10/16.
 */
@RestController
@RequestMapping("/api")
public class CodeSearchResource {


    @Autowired
    CodeSearchService service;

    @RequestMapping(value = "/code-search",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CodeSearchResult> codeSearch(@RequestParam String q) throws IOException {
        CodeSearchResult result = service.search(q);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
