package com.rwr.controller;

import com.rwr.service.IRwrManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dmitriy on 03.11.2015.
 */

@RestController
@RequestMapping("/seeker/service")
public class RwrManagementRestController {

    private static final Logger log = LoggerFactory.getLogger(RwrManagementRestController.class);

    @Autowired
    private IRwrManagementService rwrService;

    @RequestMapping(value = "/save")
    public void saveOrUpdateSeeker() {

    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {

    }
}
