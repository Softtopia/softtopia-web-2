package com.softtopia.web.service;

import com.softtopia.web.SofttopiawebApp;
import com.softtopia.web.domain.blog.BlogDescriptor;
import com.softtopia.web.domain.blog.IdBlogDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.inject.Inject;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * softtopia-web
 * File Created by jordi on 12/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SofttopiawebApp.class)
public class BlogResourcesServiceTest {

    @Inject
    BlogResourcesService service;

    @Test
    public void testGetBlogDescriptors() throws Exception {
        service.getBlogDescriptors();
    }

    @Test
    public void testGetBlogSource() throws IOException {
        List<IdBlogDescriptor> descriptors = service.getBlogDescriptors();
        String source = service.getBlogSourceString(descriptors.get(0));
        Assert.isTrue(source.length() > 0);
        //TODO: Assert thad source is markdown.
    }
}
