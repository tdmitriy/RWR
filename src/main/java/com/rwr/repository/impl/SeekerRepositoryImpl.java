package com.rwr.repository.impl;

import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SeekerSkill;
import com.rwr.exception.RwrResourceNotFoundException;
import com.rwr.repository.ISeekerRepository;
import com.rwr.repository.base.BaseRepositoryImpl;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.Pageable;
import com.rwr.utils.Pageable.OrderingType;
import com.rwr.utils.Pageable.SortingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class SeekerRepositoryImpl extends BaseRepositoryImpl<Seeker> implements ISeekerRepository {

    @Autowired
    private IPageWrapper<Seeker> pageWrapper;

    @SuppressWarnings({"JpaQlInspection"})
    @Override
    public IPageWrapper<Seeker> getSeekerPageable(Pageable pageable) throws RwrResourceNotFoundException {
        Query query = getEntityManager().createQuery("SELECT s FROM Seeker s", Seeker.class);
        initPageWrapperLogic(query, pageable);
        return pageWrapper;
    }

    @Override
    public IPageWrapper<Seeker> getSeekerSortedPageable(Pageable pageable) throws RwrResourceNotFoundException {
        SortingType sortingType = pageable.getSortingType();
        OrderingType orderingType = pageable.getOrderingType();
        Query query = null;
        switch (orderingType) {
            case ORDER_BY_ID:
                query = getEntityManager()
                        .createQuery("SELECT s FROM Seeker s ORDER BY s.id " + sortingType.toString(), Seeker.class);
                break;
            case ORDER_BY_FIRST_NAME:
                query = getEntityManager()
                        .createQuery("SELECT s FROM Seeker s ORDER BY s.firstName " + sortingType.toString(), Seeker.class);
                break;
            case ORDER_BY_LAST_NAME:
                query = getEntityManager()
                        .createQuery("SELECT s FROM Seeker s ORDER BY s.lastName " + sortingType.toString(), Seeker.class);
                break;
            case ORDER_BY_DATE_OF_ADDITION:
                query = getEntityManager()
                        .createQuery("SELECT s FROM Seeker s ORDER BY s.dateOfAddition " + sortingType.toString(), Seeker.class);
                break;
        }
        initPageWrapperLogic(query, pageable);
        return null;
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public Long getSeekerRowCount() {
        Query query = getEntityManager().createQuery("SELECT COUNT(s.id) FROM Seeker s");
        return (Long) query.getSingleResult();
    }

    @Override
    public void saveOrUpdate(Seeker entity) {
        entity.getContacts().setContactsOwner(entity);
        for (SeekerSkill skill : entity.getSeekerSkills()) {
            if (skill.getSkillsOwner() == null)
                skill.setSkillsOwner(entity);
        }
        super.saveOrUpdate(entity);
    }

    @SuppressWarnings("unchecked")
    private void initPageWrapperLogic(Query query, Pageable pageable) {
        int currentPage = pageable.getCurrentPage();
        int rowsCount = getSeekerRowCount().intValue();
        int maxRecordsPerPage = pageable.getMaxRecordsPerPage();
        int totalPages = (int) Math.ceil((double) rowsCount / maxRecordsPerPage);

        if (currentPage <= 0 || currentPage > totalPages)
            throw new RwrResourceNotFoundException("Page not found.");

        query.setFirstResult((currentPage - 1) * maxRecordsPerPage);
        query.setMaxResults(maxRecordsPerPage);

        pageWrapper.setMaxRecordsPerPage(maxRecordsPerPage);
        pageWrapper.setRowsCount(rowsCount);
        pageWrapper.setTotalPages(totalPages);
        pageWrapper.setNextPage(currentPage < totalPages);
        pageWrapper.setPrevPage(currentPage != 1);
        pageWrapper.setLastPage(currentPage == totalPages);
        pageWrapper.setCollection(query.getResultList());
    }
}
