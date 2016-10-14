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
import java.util.List;

/**
 * softtopia-web
 * File Created by jordi on 11/10/16.
 */

@Service
public class BlogResourcesService {

    private ArrayList<IdBlogDescriptor> blogDescriptors = null;

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

    public List<IdBlogDescriptor> getBlogDescriptors() throws IOException {
        if (blogDescriptors == null) {
            blogDescriptors = new ArrayList<>();
            Integer currentId = 1;
            for (Resource file : blogDescriptorFiles) {
                String fileString = getStringFromInputStream(file.getInputStream());
                YamlReader reader = new YamlReader(fileString);
                BlogDescriptor newDescriptor = reader.read(BlogDescriptor.class);
                blogDescriptors.add(new IdBlogDescriptor(currentId.toString(), newDescriptor));
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
        List<IdBlogDescriptor> descriptors = getBlogDescriptors();
        //TODO: Check exceptions here.
        return descriptors.get(Integer.valueOf(blogDescriptorId) - 1);
    }

    public String getBlogSourceString(String blogDescriptorId) throws IOException {
        return getBlogSourceString(descriptorById(blogDescriptorId));
    }


}
