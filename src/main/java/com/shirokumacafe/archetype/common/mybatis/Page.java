package com.shirokumacafe.archetype.common.mybatis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 * @author lim
 */
public class Page<T> {

    private int results=0;

    private List<T> rows=new ArrayList<T>();

    private int start;

    private int limit;

    private Boolean hasError;

    private String error;

    public Page(){

    }

    public Page(int start, int limit){
        this.start=start;
        this.limit=limit;
    }

    public RowBounds createRowBounds(){
        RowBounds rowBounds=new RowBounds(start,limit);
        return  rowBounds;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public void setError(String error) {
        this.error = error;
    }

    @JsonIgnore
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @JsonIgnore
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
