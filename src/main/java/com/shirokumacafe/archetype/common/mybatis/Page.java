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

    private int total=0;

    private List<T> root=new ArrayList<T>();

    private int offset;

    private int limit;

    public Page(int offset, int limit){
        this.offset=offset;
        this.limit=limit;
    }

    public RowBounds createRowBounds(){
        RowBounds rowBounds=new RowBounds(offset,limit);
        return  rowBounds;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    @JsonProperty("rows")
    public List<T> getRoot() {
        return root;
    }

    public void setRoot(List<T> root) {
        this.root = root;
    }

    @JsonIgnore
    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @JsonIgnore
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
