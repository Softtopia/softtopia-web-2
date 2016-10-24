package com.softtopia.web.service;

import com.softtopia.web.domain.search.CodeSearchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Service Class to search for code on the web
 * See also: https://searchcode.com/api/
 */
@Service
public class CodeSearchService {

    RestTemplate restTemplate;

    public CodeSearchService() {
        restTemplate = new RestTemplate();
    }

    public CodeSearchResult search(String query) {
        String searchCodeUrl = "https://searchcode.com/api/codesearch_I/?q=" + query;
        ResponseEntity<CodeSearchResult> response =
            restTemplate.getForEntity(searchCodeUrl, CodeSearchResult.class);

        return response.getBody();
    }

}
