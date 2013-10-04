package com.uaihebert.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
public abstract class AbstractTest {

    private static final String PU_OPENJPA = "QueryTesterOpenJPA";
    private static final String PU_HIBERNATE = "QueryTesterHibernate";
    private static final String PU_ECLIPSELINK = "QueryTesterEclipseLink";

    protected static void createEntityManagerFactoryForHibernate() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU_HIBERNATE);
    }

    protected static void createEntityManagerFactoryForEclipseLink() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU_ECLIPSELINK);
    }

    protected static void createEntityManagerFactoryForOpenJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU_OPENJPA);
    }

    @BeforeClass
    public static void createPersistenceUnit() {
        if (getEntityManagerFactory() == null) {
                createEntityManagerFactoryForHibernate();
//            createEntityManagerFactoryForEclipseLink();
//            createEntityManagerFactoryForOpenJPA();
        }

        generateData();
    }

    @AfterClass
    public static void closePersistenceUnit() {
        if(getEntityManagerFactory().isOpen()){
            getEntityManagerFactory().close();
        }

        entityManagerFactory = null;
    }

    protected static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    protected static void generateData() {
        if(!getEntityManagerFactory().isOpen()){
            createEntityManagerFactoryForHibernate();
        }

        CodeGenerator.generateData(getEntityManagerFactory());
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if(entityManagerFactory != null){
            return entityManagerFactory;
        }

        return null;
    }

    @Before
    public void beforeTest() {
        if(entityManager == null){
            entityManager = getEntityManagerFactory().createEntityManager();
        }
    }

    @After
    public void finishTest() {
        entityManager.close();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected boolean isEclipseLink() {
        return getEntityManager().toString().contains("eclipse");
    }

    protected boolean isOpenJPA() {
        return getEntityManager().toString().contains("openjpa");
    }
}