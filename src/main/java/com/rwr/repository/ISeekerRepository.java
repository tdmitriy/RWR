package com.rwr.repository;


import com.rwr.entity.seeker.Seeker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Dmitriy on 29.10.2015.
 */
@SuppressWarnings("JpaQlInspection")
public interface ISeekerRepository extends JpaRepository<Seeker, Integer> {
    @Query("SELECT s FROM com.rwr.entity.seeker.Seeker s")
    Page<Seeker> findAllPages(Pageable pageable);

    @Query("SELECT COUNT(s.id) FROM com.rwr.entity.seeker.Seeker s")
    Long getSeekerCount();
}
