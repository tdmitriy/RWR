package com.rwr.repository;

import com.rwr.entity.ims.ImsType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitriy on 01.11.2015.
 */

public interface IImsRepository extends JpaRepository<ImsType, Integer> {
}
