package com.rwr.utils;

import java.util.Collection;

/**
 * Created by haswell on 11/5/15.
 */
public class PageWrapperImpl<T> implements IPageWrapper<T> {
    private int rowsCount;
    private int maxRecordsPerPage;
    private int totalPages;
    Collection<T> collection;

    public PageWrapperImpl() {
    }

    public PageWrapperImpl(int rowsCount, int maxRecordsPerPage, Collection<T> collection) {
        this.rowsCount = rowsCount;
        this.maxRecordsPerPage = maxRecordsPerPage;
        this.collection = collection;
    }


    @Override
    public int getRowsCount() {
        return rowsCount;
    }

    @Override
    public void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public int getMaxRecordsPerPage() {
        return maxRecordsPerPage;
    }

    @Override
    public void setMaxRecordsPerPage(int maxRecordsPerPage) {
        this.maxRecordsPerPage = maxRecordsPerPage;
    }

    @Override
    public Collection<T> getCollection() {
        return collection;
    }

    @Override
    public void setCollection(Collection<T> collection) {
        this.collection = collection;
    }


}
