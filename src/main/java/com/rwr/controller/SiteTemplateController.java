package com.rwr.controller;

import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SeekerSkill;
import com.rwr.entity.skills.SkillType;
import com.rwr.repository.ISkillsRepository;
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
public class SiteTemplateController {
    private static final Logger log = LoggerFactory.getLogger(SiteTemplateController.class);

    private static final String INDEX_PAGE = "index";
    private static final String SITE_TEMPLATE_PAGE = "siteTemplate";

    @Autowired
    private IRwrManagementService rwrService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return INDEX_PAGE;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String showSiteTemplate() {
        /*Seeker seeker = rwrService.getById(1);
        seeker.getSeekerSkills().add(new SeekerSkill(new SkillType("TestSkill"), 3));
        rwrService.saveOrUpdate(seeker);*/
        rwrService.deleteById(1);
        return INDEX_PAGE;
    }
}
