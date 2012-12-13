package com.shirokumacafe.archetype.common.entity;

import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;


public class Page<T> {
    private int total=0;
    private List<T> root=new ArrayList<T>();
    private int offset;
    private int limit;

    public Page(int offset,int limit){
        this.offset=offset;
        this.limit=limit;
    }

    public RowBounds createRowBounds(){
        RowBounds rowBounds=new RowBounds(offset,limit);
        return  rowBounds;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRoot() {
        return root;
    }

    public void setRoot(List<T> root) {
        this.root = root;
    }
}
