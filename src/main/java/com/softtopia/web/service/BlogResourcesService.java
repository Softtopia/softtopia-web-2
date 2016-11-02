package com.softtopia.web.service;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.softtopia.web.domain.blog.BlogDescriptor;
import com.softtopia.web.domain.blog.IdBlogDescriptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * softtopia-web
 * File Created by jordi on 11/10/16.
 */

@Service
public class BlogResourcesService {

    private Map<String, IdBlogDescriptor> blogDescriptors = null;

    @Value("classpath*:**/blogs/*.md")
    private Resource[] blogFiles;

    @Value("classpath*:**/blogs/*.yaml")
    private Resource[] blogDescriptorFiles;

    // convert InputStream to String
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        try {

            bufferedReader = new BufferedReader(new InputStreamReader(is));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public Map<String, IdBlogDescriptor> getBlogDescriptors() throws IOException {
        if (blogDescriptors == null) {
            blogDescriptors = new HashMap<String,IdBlogDescriptor>();
            Integer currentId = 1;
            for (Resource file : blogDescriptorFiles) {
                String fileString = getStringFromInputStream(file.getInputStream());
                YamlReader reader = new YamlReader(fileString);

                BlogDescriptor newDescriptor = reader.read(BlogDescriptor.class);
                String blogId = file.getFilename().replace(".yaml", "");
                blogDescriptors.put(blogId, new IdBlogDescriptor(blogId, newDescriptor));
                currentId++;
            }
        }
        return blogDescriptors;
    }

    public String getBlogSourceString(IdBlogDescriptor blogDescriptor) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(blogDescriptor.getSource().getUrl(), String.class);
    }

    private IdBlogDescriptor descriptorById(String blogDescriptorId) throws IOException {
        Map<String,IdBlogDescriptor> descriptors = getBlogDescriptors();
        //TODO: Check exceptions here.And check if id is found.
        return descriptors.get(blogDescriptorId);
    }

    public String getBlogSourceString(String blogDescriptorId) throws IOException {
        return getBlogSourceString(descriptorById(blogDescriptorId));
    }


}
