package com.rwr.controller;

import com.rwr.entity.seeker.Seeker;
import com.rwr.service.IRwrManagementService;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by haswell on 29.10.15.
 */

@Controller
public class SiteTemplateController {
    private static final Logger log = LoggerFactory.getLogger(SiteTemplateController.class);

    private static final String INDEX_PAGE = "index";
    private static final String SITE_TEMPLATE_PAGE = "siteTemplate";

    @Autowired
    private IRwrManagementService rwrService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return SITE_TEMPLATE_PAGE;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public IPageWrapper<Seeker> showSeekers() {
        Pageable pageable = new Pageable(1, 5, Pageable.SortingType.ASC, Pageable.OrderingType.ORDER_BY_DATE_OF_ADDITION);
        return rwrService.getAllSeekerPageable(pageable);
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String showTest2() {
        return INDEX_PAGE;
    }
}
