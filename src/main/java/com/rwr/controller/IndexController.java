package com.rwr.controller;

import com.rwr.dao.contacts.IContactsDao;
import com.rwr.dao.ims.IImsDao;
import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.ImsType;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;
import com.rwr.service.ISeekerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * Created by haswell on 29.10.15.
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    private static final String INDEX_PAGE = "index";

    @Autowired
    private ISeekerService seekerService;

    @Autowired
    private IContactsDao contactsDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage() {
        return INDEX_PAGE;
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save() {
        SeekerPhone phone = new SeekerPhone("000000");
        contactsDao.saveOrUpdatePhone(2, phone);

        return INDEX_PAGE;
    }

    @RequestMapping(value = "/addPhone", method = RequestMethod.GET)
    public String addPhone() {
        Seeker seeker = seekerService.getById(6);
        SeekerPhone phone = new SeekerPhone("0672222");
        seekerService.addPhone(seeker.getId(), phone);
        return INDEX_PAGE;
    }
}
