/*
 * Copyright 2012 uaiHebert Solucoes em Informatica
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
package com.uaihebert.factory;

import com.uaihebert.model.*;

import javax.persistence.EntityManager;

/**
 * @author uaiHebert.com
 *
 * Class that will create an instance of the EasyCriteria
 */
public abstract class EasyCriteriaFactory {

    private static <T> BasicQueryElements<T> createBasicElement(EntityManager entityManager, Class<T> entityClass, EasyCriteria easyCTO) {
        if(easyCTO != null &&  !(easyCTO instanceof EasyCTOImp)){
            throw new IllegalArgumentException("I should be receiving an object like that?" + easyCTO);
        }

        EasyCTOImp easyCTOConverted = (EasyCTOImp) easyCTO;

        EasyCriteriaBuilder<T> easyCriteriaBuilder = new EasyCriteriaBuilder(entityManager, entityClass);

        return new BasicQueryElements<T>(easyCriteriaBuilder, easyCTOConverted);
    }

    public static <T> BasicQueryElements<T> createBasicElement(EntityManager entityManager, Class<T> entityClass) {
        return createBasicElement(entityManager, entityClass, null);
    }

    /**
     * Creates a new instance of the EasyCriteria that
     * will generate a TypedQuery.
     *
     * @param entityManager Entity Manager implementation
     * @param entityClass The class to be queried
     * @return a EasyCriteria instance.
     */
    public static <T> EasyCriteria<T> createQueryCriteria(EntityManager entityManager, Class<T> entityClass) {
        BasicQueryElements<T> basicQueryElements = createBasicElement(entityManager, entityClass);

        return new EasyCriteriaImp<T>(basicQueryElements);
    }

    /**
     * Method that will create an instance of EasyCriteria, but using the parameters
     *   of a view Criteria Transfer Object.
     *
     * With the returned instance it is possible to fire the query.
     *
     * @param entityManager Entity Manager implementation
     * @param entityClass The class to be queried
     * @return a EasyCriteria instance.
     * */
    public static <T> EasyCriteria<T> createQueryCriteria(EntityManager entityManager, Class<T> entityClass, EasyCriteria easyCTO) {
        BasicQueryElements<T> basicQueryElements = createBasicElement(entityManager, entityClass, easyCTO);

        return new EasyCriteriaImp<T>(basicQueryElements);
    }

    public static <T> EasyCriteria<T> createEasyCTO() {
        return new EasyCTOImp<T>();
    }
}