package com.rwr.utils;

import java.util.Collection;

/**
 * Created by haswell on 11/5/15.
 */
public interface IPageWrapper<T> {
    int getRowsCount();

    void setRowsCount(int rowsCount);

    int getTotalPages();

    int getMaxRecordsPerPage();

    void setMaxRecordsPerPage(int maxRecordsPerPage);

    void setTotalPages(int totalPages);

    Collection<T> getCollection();

    void setCollection(Collection<T> collection);
}
