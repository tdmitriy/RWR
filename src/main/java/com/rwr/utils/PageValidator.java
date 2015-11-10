package com.rwr.utils;

import com.rwr.exception.RwrBadRequestException;
import com.rwr.utils.Pageable.OrderingType;
import com.rwr.utils.Pageable.SortingType;

public class PageValidator {

    private static final String ORDER_BY_ID = "id";
    private static final String ORDER_BY_FIRST_NAME = "first";
    private static final String ORDER_BY_LAST_NAME = "last";
    private static final String ORDER_BY_DATE_OF_ADDITION = "date_of_addition";

    private PageValidator() {
    }

    public static Pageable getValidatedPageable(Integer page, Integer maxRecords, String orderBy, String sortBy) {
        Pageable pageable = new Pageable();
        pageable.setCurrentPage(page);
        pageable.setMaxRecordsPerPage(maxRecords == null ? PageConstants.DEFAULT_RECORDS_PER_PAGE : maxRecords);
        pageable.setSortingType(sortBy.equals("asc") ? SortingType.ASC : SortingType.DESC);
        switch (orderBy) {
            case ORDER_BY_ID:
                pageable.setOrderingType(OrderingType.ORDER_BY_ID);
                break;
            case ORDER_BY_FIRST_NAME:
                pageable.setOrderingType(OrderingType.ORDER_BY_FIRST_NAME);
                break;
            case ORDER_BY_LAST_NAME:
                pageable.setOrderingType(OrderingType.ORDER_BY_LAST_NAME);
                break;
            case ORDER_BY_DATE_OF_ADDITION:
                pageable.setOrderingType(OrderingType.ORDER_BY_DATE_OF_ADDITION);
                break;
            default:
                throw new RwrBadRequestException("Ordering type format is wrong.");
        }
        return pageable;
    }
}
