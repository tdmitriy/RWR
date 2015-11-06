package com.rwr.utils;

import com.rwr.controller.RwrManagementRestController;
import com.rwr.exception.RwrBadRequestException;
import com.rwr.utils.Pageable.*;

public class PageValidator {

    private static final String ORDER_BY_ID = "id";
    private static final String ORDER_BY_FIRST_NAME = "first";
    private static final String ORDER_BY_LAST_NAME = "last";
    private static final String ORDER_BY_DATE_OF_ADDITION = "date_of_addition";

    private PageValidator() {
    }

    public static Pageable getValidatedPageable(Integer page, String orderBy, String sortBy) {
        Pageable pageable;
        if (page == null) {
            pageable = new Pageable(RwrManagementRestController.DEFAULT_START_PAGE,
                    RwrManagementRestController.MAX_RECORDS_PER_PAGE);
        } else {
            if (orderBy == null && sortBy == null)
                pageable = new Pageable(page, RwrManagementRestController.MAX_RECORDS_PER_PAGE);
            else pageable = getOrderedAndSortedPageable(page, orderBy, sortBy);
        }
        return pageable;
    }

    private static Pageable getOrderedAndSortedPageable(Integer page, String orderBy, String sortBy) {
        Pageable pageable;
        if (orderBy == null || sortBy == null) {
            throw new RwrBadRequestException("Parameters 'order_by' and 'sort_by' must be set.");
        } else {
            pageable = getParsedPageable(page, orderBy, sortBy);
        }
        return pageable;
    }

    private static Pageable getParsedPageable(Integer page, String orderBy, String sortBy) {
        Pageable pageable = new Pageable();
        pageable.setCurrentPage(page);
        pageable.setMaxRecordsPerPage(RwrManagementRestController.MAX_RECORDS_PER_PAGE);
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
