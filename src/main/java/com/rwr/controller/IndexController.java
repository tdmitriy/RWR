package com.rwr.controller;

import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage() {
        return INDEX_PAGE;
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save() {
        Seeker seeker = new Seeker();
        SeekerPhone phone = new SeekerPhone("12345");
        SeekerEmail email = new SeekerEmail("test@lala.com");

        Set<SeekerPhone> phones = new HashSet<>();
        Set<SeekerEmail> emails = new HashSet<>();
        phones.add(phone);
        emails.add(email);

        seeker.setFirstName("testFname");
        seeker.setLastName("testLname");
        seeker.setDateOfAddition(new Date());
        seeker.setDateOfInterview(new Date());

        SeekerContacts seekerSeekerContacts = new SeekerContacts(phones, emails, seeker);

        seekerService.saveOrUpdate(seeker);
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
