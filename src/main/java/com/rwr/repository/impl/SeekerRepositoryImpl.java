package com.rwr.repository.impl;

import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SeekerSkill;
import com.rwr.repository.ISeekerRepository;
import com.rwr.repository.base.BaseRepositoryImpl;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.Pageable;
import com.rwr.utils.Pageable.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by Dmitriy on 04.11.2015.
 */
@Repository
public class SeekerRepositoryImpl extends BaseRepositoryImpl<Seeker> implements ISeekerRepository {

    @Autowired
    private IPageWrapper<Seeker> pageWrapper;

    @SuppressWarnings({"JpaQlInspection", "unchecked"})
    @Override
    public IPageWrapper<Seeker> getSeekerPageable(Pageable pageable) {
        String sort;
        SortingType sortingType = pageable.getSortingType();
        OrderingType orderingType = pageable.getOrderingType();

        if (sortingType == null || orderingType == null) {
            orderingQueryLogic(pageable);
        } else {
            sort = pageable.getSortingType().toString();
            orderingQueryLogic(pageable, sort);
        }
        return pageWrapper;
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public Integer getSeekerRowCount() {
        Query query = getEntityManager().createQuery("SELECT COUNT(s.id) FROM com.rwr.entity.seeker.Seeker s");
        int count = query.getFirstResult();
        return query.getFirstResult();
    }

    @Override
    public void saveOrUpdate(Seeker entity) {
        for (SeekerSkill skill : entity.getSeekerSkills()) {
            skill.setSkillsOwner(entity);
        }
        super.saveOrUpdate(entity);
    }

    @SuppressWarnings("JpaQlInspection")
    private void orderingQueryLogic(Pageable pageable) {
        Query query = getEntityManager().createQuery("SELECT s FROM Seeker s", Seeker.class);
        initPageWrapperLogic(query, pageable);
    }


    private void orderingQueryLogic(Pageable pageable, String sortType) {
        Query query = null;
        switch (pageable.getOrderingType()) {
            case ORDER_BY_FIRST_NAME:
                query = getEntityManager()
                        .createQuery("SELECT s FROM Seeker s ORDER BY s.firstName " + sortType, Seeker.class);
                break;
            case ORDER_BY_LAST_NAME:
                query = getEntityManager()
                        .createQuery("SELECT s FROM Seeker s ORDER BY s.lastName " + sortType, Seeker.class);
                break;
            case ORDER_BY_DATE_OF_ADDITION:
                query = getEntityManager()
                        .createQuery("SELECT s FROM Seeker s ORDER BY s.dateOfAddition " + sortType, Seeker.class);
                break;
        }
        initPageWrapperLogic(query, pageable);
    }

    @SuppressWarnings("unchecked")
    private void initPageWrapperLogic(Query query, Pageable pageable) {
        int currentPage = pageable.getCurrentPage() - 1;
        int rowsCount = getSeekerRowCount();
        int maxRecordsPerPage = pageable.getMaxRecordsPerPage();
        int totalPages = (rowsCount / maxRecordsPerPage) + 1;

        query.setFirstResult(currentPage * maxRecordsPerPage);
        query.setMaxResults(maxRecordsPerPage);

        pageWrapper.setMaxRecordsPerPage(maxRecordsPerPage);
        pageWrapper.setRowsCount(rowsCount);
        pageWrapper.setTotalPages(totalPages);
        pageWrapper.setCollection(query.getResultList());
    }
}
