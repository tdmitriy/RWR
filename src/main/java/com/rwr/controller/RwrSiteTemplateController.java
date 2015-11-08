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

@Controller
public class RwrSiteTemplateController {
    //private static final Logger log = LoggerFactory.getLogger(RwrSiteTemplateController.class);

    private static final String SITE_TEMPLATE_PAGE = "siteTemplate";
    private static final String TABLE_MANAGEMENT_PAGE = "view/seekerTableManagementView";
    private static final String ADD_NEW_SEEKER_PAGE = "view/seekerSaveManagementView";


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSiteTemplate() {
        return SITE_TEMPLATE_PAGE;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showTableManagementView() {
        return TABLE_MANAGEMENT_PAGE;
    }

    @RequestMapping(value = "/management/add", method = RequestMethod.GET)
    public String showAddNewSeekerView() {
        return ADD_NEW_SEEKER_PAGE;
    }

}
