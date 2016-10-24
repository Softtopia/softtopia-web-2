package com.softtopia.web.service;

import com.softtopia.web.SofttopiawebApp;
import com.softtopia.web.domain.search.CodeSearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

/**
 * softtopia-web
 * File Created by jordi on 25/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SofttopiawebApp.class)
//@WebAppConfiguration
//@IntegrationTest
public class CodeSearchServiceTest {

    @Autowired
    CodeSearchService service;


    @Test
    public void testSearch() throws Exception {
        CodeSearchResult result = service.search("@RunWith");
        Assert.notNull(result);
    }
}
