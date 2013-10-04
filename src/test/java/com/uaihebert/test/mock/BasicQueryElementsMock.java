package com.uaihebert.test.mock;

import com.uaihebert.model.BasicQueryElements;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class BasicQueryElementsMock<T> extends BasicQueryElements<T> {

    public BasicQueryElementsMock(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery, Root<T> mainRoot, EntityManager entityManager, Class<T> entityClass) {
        super(null, null);
    }

    @Override
    public void andGreaterThan(String attributeName, Object value, boolean toLowerCase) {

    }
}
