package com.rwr.controller;

import com.rwr.entity.seeker.Seeker;
import com.rwr.service.IRwrManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/page1", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    @ResponseBody
    public Page<Seeker> getPage1() {
        Page<Seeker> page = rwrService.getAllPages(new PageRequest(0, 1));
        return page;
    }

    @RequestMapping(value = "/page2", method = RequestMethod.GET)
    @ResponseBody
    public Page<Seeker> getPage2() {
        Page<Seeker> page = rwrService.getAllPages(new PageRequest(1, 5));
        return page;
    }
}
