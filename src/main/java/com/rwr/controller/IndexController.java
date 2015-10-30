package com.rwr.controller;

import com.rwr.entity.seeker.Seeker;
import com.rwr.service.ISeekerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by haswell on 29.10.15.
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    private static final String INDEX_PAGE = "index";

    @Autowired
    private ISeekerService seekerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage() {
        Seeker seeker = seekerService.getById(1);
        if(seeker != null) log.info(seeker.toString());
        return INDEX_PAGE;
    }
}
