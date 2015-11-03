package com.rwr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by haswell on 29.10.15.
 */

@Controller
public class SiteTemplateController {
    private static final Logger log = LoggerFactory.getLogger(SiteTemplateController.class);

    private static final String INDEX_PAGE = "index";
    private static final String SITE_TEMPLATE_PAGE = "siteTemplate";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSiteTemplate() {
        return SITE_TEMPLATE_PAGE;
    }
}
