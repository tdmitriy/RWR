package com.rwr.utils;

/**
 * Created by haswell on 11/5/15.
 */
public class Pageable {
    private int maxRecordsPerPage;
    private int currentPage;
    private SortingType sortingType;
    private OrderingType orderingType;

    public Pageable() {
    }

    public Pageable(int currentPage, int maxRecordsPerPage, SortingType sortingType, OrderingType orderingType) {
        this.maxRecordsPerPage = maxRecordsPerPage;
        this.currentPage = currentPage;
        this.sortingType = sortingType;
        this.orderingType = orderingType;
    }

    public Pageable(int currentPage, int maxRecordsPerPage) {
        this.maxRecordsPerPage = maxRecordsPerPage;
        this.currentPage = currentPage;
    }

    public int getMaxRecordsPerPage() {
        return maxRecordsPerPage;
    }

    public void setMaxRecordsPerPage(int maxRecordsPerPage) {
        this.maxRecordsPerPage = maxRecordsPerPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public SortingType getSortingType() {
        return sortingType;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public OrderingType getOrderingType() {
        return orderingType;
    }

    public void setOrderingType(OrderingType orderingType) {
        this.orderingType = orderingType;
    }

    public enum SortingType {
        ASC("ASC"), DESC("DESC");

        private final String typeName;

        SortingType(final String typeName) {
            this.typeName = typeName;
        }

        @Override
        public String toString() {
            return typeName;
        }
    }

    public enum OrderingType {
        ORDER_BY_FIRST_NAME,
        ORDER_BY_LAST_NAME,
        ORDER_BY_DATE_OF_ADDITION
    }
}
