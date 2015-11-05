package com.rwr.repository;


import com.rwr.entity.seeker.Seeker;
import com.rwr.exception.RwrResourceNotFoundException;
import com.rwr.repository.base.IBaseRepository;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.Pageable;

/**
 * Created by Dmitriy on 29.10.2015.
 */
@SuppressWarnings("JpaQlInspection")
public interface ISeekerRepository extends IBaseRepository<Seeker> {
    IPageWrapper<Seeker> getSeekerPageable(Pageable pageable) throws RwrResourceNotFoundException;

    Long getSeekerRowCount();
}
