package com.rwr.dao.ims;

import com.rwr.dao.base.BaseDaoImpl;
import com.rwr.entity.ims.ImsType;

import javax.persistence.Query;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class ImsDaoImpl extends BaseDaoImpl<ImsType> implements IImsDao {
    @SuppressWarnings("JpaQlInspection")
    @Override
    public ImsType getByName(String typeName) {
        Query selectQuery = getEntityManager()
                .createQuery("SELECT t FROM ImsType t WHERE t.typeName=:typeName", ImsType.class);
        selectQuery.setParameter("typeName", typeName);
        return (ImsType) selectQuery.getSingleResult();
    }
}
