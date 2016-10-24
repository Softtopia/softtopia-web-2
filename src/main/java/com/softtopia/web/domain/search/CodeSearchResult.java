package com.softtopia.web.domain.search;

import java.util.Collection;

/**
 * softtopia-web
 * File Created by jordi on 25/10/16.
 */
public class CodeSearchResult {
    String matchTerm;
    Integer previousPage;
    String searchTerm;
    String query;
    Integer total;
    Integer page;
    Integer nextPage;
    Collection<LanguageFilter> languageFilters;
    Collection<SourceFilters> sourceFilters;
    Collection<Result> results;

    public String getMatchTerm() {
        return matchTerm;
    }

    public void setMatchTerm(String matchTerm) {
        this.matchTerm = matchTerm;
    }

    public Integer getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Integer previousPage) {
        this.previousPage = previousPage;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Collection<LanguageFilter> getLanguageFilters() {
        return languageFilters;
    }

    public void setLanguageFilters(Collection<LanguageFilter> languageFilters) {
        this.languageFilters = languageFilters;
    }

    public Collection<SourceFilters> getSourceFilters() {
        return sourceFilters;
    }

    public void setSourceFilters(Collection<SourceFilters> sourceFilters) {
        this.sourceFilters = sourceFilters;
    }

    public Collection<Result> getResults() {
        return results;
    }

    public void setResults(Collection<Result> results) {
        this.results = results;
    }
}
