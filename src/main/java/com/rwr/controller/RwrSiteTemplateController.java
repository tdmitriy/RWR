package com.rwr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RwrSiteTemplateController {
    private static final String SITE_TEMPLATE_PAGE = "siteTemplate";
    private static final String TABLE_MANAGEMENT_PAGE = "view/seekerTableManagementView";
    private static final String SEEKER_MANAGEMENT_PAGE = "view/seekerSaveManagementView";


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSiteTemplate() {
        return SITE_TEMPLATE_PAGE;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showTableManagementView() {
        return TABLE_MANAGEMENT_PAGE;
    }

    @RequestMapping(value = "/management", method = RequestMethod.GET)
    public String showAddNewSeekerView() {
        return SEEKER_MANAGEMENT_PAGE;
    }

}
