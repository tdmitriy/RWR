package com.rwr.utils;

import java.util.Collection;

public interface IPageWrapper<T> {
    int getRowsCount();

    void setRowsCount(int rowsCount);

    int getTotalPages();

    int getMaxRecordsPerPage();

    boolean getNextPage();

    void setNextPage(boolean nextPage);

    boolean getPrevPage();

    void setPrevPage(boolean prevPage);

    boolean getLastPage();

    void setLastPage(boolean lastPage);

    void setMaxRecordsPerPage(int maxRecordsPerPage);

    void setTotalPages(int totalPages);

    Collection<T> getCollection();

    void setCollection(Collection<T> collection);
}
