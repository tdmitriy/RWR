package com.rwr.dao.seeker;

import com.rwr.entity.seeker.Seeker;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Dmitriy on 29.10.2015.
 */
public interface ISeekerDao {
    /*@Select("Select id, first_name, last_name, date_of_addition, date_of_interview from SEEKER")
    @Results(value={
            @Result(column="id", property="id"),
            @Result(column="first_name", property="firstName"),
            @Result(column="last_name", property="lastName"),
            @Result(column="date_of_addition", property="dateOfAddition"),
            @Result(column="date_of_interview", property="dateOfInterview")
    })*/
    List<Seeker> getAll();

    /*@Select("Select id, first_name, last_name, date_of_addition, date_of_interview from SEEKER where id=#{id} limit 1")
    @Results(value={
            @Result(column="id", property="id"),
            @Result(column="first_name", property="firstName"),
            @Result(column="last_name", property="lastName"),
            @Result(column="date_of_addition", property="dateOfAddition"),
            @Result(column="date_of_interview", property="dateOfInterview")
    })*/
    Seeker getById(Integer id);
}
