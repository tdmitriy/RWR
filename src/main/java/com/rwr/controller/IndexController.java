package com.rwr.controller;

import com.rwr.service.IRwrManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by haswell on 29.10.15.
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    private static final String INDEX_PAGE = "index";

    @Autowired
    private IRwrManagementService rwrService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage() {
        return INDEX_PAGE;
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save() {
        return INDEX_PAGE;
    }

    @RequestMapping(value = "/addPhone", method = RequestMethod.GET)
    public String addPhone() {
        return INDEX_PAGE;
    }
}
