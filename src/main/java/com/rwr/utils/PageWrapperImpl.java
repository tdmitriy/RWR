package com.rwr.utils;

import java.util.Collection;

public class PageWrapperImpl<T> implements IPageWrapper<T> {
    private int rowsCount;
    private int maxRecordsPerPage;
    private int totalPages;
    private boolean nextPage;
    private boolean prevPage;
    private boolean lastPage;
    private Collection<T> collection;

    public PageWrapperImpl() {
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
    public boolean getNextPage() {
        return nextPage;
    }

    @Override
    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    public boolean getPrevPage() {
        return prevPage;
    }

    @Override
    public void setPrevPage(boolean prevPage) {
        this.prevPage = prevPage;
    }

    @Override
    public boolean getLastPage() {
        return lastPage;
    }

    @Override
    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
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
