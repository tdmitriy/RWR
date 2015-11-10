package com.rwr.controller;

import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SeekerSkill;
import com.rwr.entity.skills.SkillType;
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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class RwrSiteTemplateController {
    //private static final Logger log = LoggerFactory.getLogger(RwrSiteTemplateController.class);

    @Autowired
    private IRwrManagementService rwrService;

    private static final String INDEX_PAGE = "index";
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

    @RequestMapping(value = "/test")
    public String test() {
        Seeker seeker = new Seeker();


        SeekerEmail email = new SeekerEmail("Email@test");
        SeekerPhone phone = new SeekerPhone("80123");
        SeekerSkill skill = new SeekerSkill(new SkillType(1), 4);

        Set<SeekerEmail> seekerEmails = new HashSet<>();
        Set<SeekerPhone> seekerPhones = new HashSet<>();
        Set<SeekerSkill> seekerSkills = new HashSet<>();

        seekerEmails.add(email);
        seekerPhones.add(phone);
        seekerSkills.add(skill);

        SeekerContacts seekerContacts = new SeekerContacts();
        seekerContacts.setSeekerPhones(seekerPhones);
        seekerContacts.setSeekerEmails(seekerEmails);
        seekerContacts.setContactsOwner(seeker);

        seeker.setFirstName("fna");
        seeker.setLastName("lna");
        seeker.setDateOfAddition(new Date());
        seeker.setDateOfInterview(new Date());
        seeker.setContacts(seekerContacts);
        seeker.setSeekerSkills(seekerSkills);

        rwrService.saveOrUpdateSeeker(seeker);
        return INDEX_PAGE;
    }

}
