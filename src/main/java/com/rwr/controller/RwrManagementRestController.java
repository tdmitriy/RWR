package com.rwr.controller;

import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import com.rwr.exception.RwrBadRequestException;
import com.rwr.exception.RwrDaoException;
import com.rwr.exception.RwrJsonResponseException;
import com.rwr.service.IRwrManagementService;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.PageConstants;
import com.rwr.utils.PageValidator;
import com.rwr.utils.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("service/seeker")
public class RwrManagementRestController {
    private static final Logger log = LoggerFactory.getLogger(RwrManagementRestController.class);

    @Autowired
    private IRwrManagementService rwrService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getSeekersPageable", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public IPageWrapper<Seeker> getSeekerPageable(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "max_records", required = false) Integer maxRecords) {

        page = page == null ? PageConstants.DEFAULT_START_PAGE : page;
        maxRecords = maxRecords == null ? PageConstants.DEFAULT_RECORDS_PER_PAGE : maxRecords;

        Pageable pageable = new Pageable(page, maxRecords);

        return rwrService.getSeekerPageable(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getSeekersSortedPageable", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public IPageWrapper<Seeker> getSeekerSortedPageable(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "max_records", required = false) Integer maxRecords,
            @RequestParam(value = "order_by", required = true) String orderBy,
            @RequestParam(value = "sort_by", required = true) String sortBy) {

        Pageable pageable = PageValidator.getValidatedPageable(page, maxRecords, orderBy, sortBy);

        return rwrService.getSeekerPageable(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Seeker getSeekerById(@PathVariable("id") Integer id) {
        if (id != null) {
            Seeker seeker = rwrService.getSeekerById(id);
            if (seeker == null) throw new RwrBadRequestException("Could not find seeker with given id.");
            else return seeker;
        } else {
            throw new RwrBadRequestException("Could not find seeker with nullable id.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdateSeeker(@Valid @RequestBody Seeker seeker, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            for (ObjectError error : bindResult.getAllErrors())
                log.error("BindingResult error: {}", error.getDefaultMessage());
        } else {
            rwrService.saveOrUpdateSeeker(seeker);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        if (id != null) {
            rwrService.delete(id);
        } else {
            throw new RwrBadRequestException("Could not delete seeker with given id.");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getSkillTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<SkillType> getSkillTypes() {
        return rwrService.getSkillTypes();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getImsTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<ImsType> getImsTypes() {
        return rwrService.getImsTypes();
    }


    @ExceptionHandler(RwrDaoException.class)
    @ResponseBody
    public ResponseEntity<RwrJsonResponseException> databaseExceptionHandler(HttpServletRequest req, RwrDaoException ex) {
        log.error("Request: " + req.getRequestURL() + "\nraised " + ex);
        log.error("exception message=" + ex.getMessage());
        RwrJsonResponseException error = new RwrJsonResponseException();
        String errMsg = "A Database problem has occurred";
        error.setErrors(Collections.singletonList(errMsg));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
