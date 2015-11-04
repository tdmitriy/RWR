package com.rwr.repository;


import com.rwr.entity.seeker.Seeker;
import com.rwr.repository.base.IBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * Created by Dmitriy on 29.10.2015.
 */
@SuppressWarnings("JpaQlInspection")
public interface ISeekerRepository extends IBaseDao<Seeker> {
    Collection<Seeker> getSeekerPageable(Integer pageNumber, Integer maxPageSize);
}
