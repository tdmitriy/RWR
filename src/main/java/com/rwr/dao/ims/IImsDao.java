package com.rwr.dao.ims;

import com.rwr.dao.base.IBaseDao;
import com.rwr.entity.ims.ImsType;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public interface IImsDao extends IBaseDao<ImsType> {
    ImsType getByName(String typeName);
}
