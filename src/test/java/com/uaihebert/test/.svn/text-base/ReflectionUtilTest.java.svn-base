package com.uaihebert.test;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
import com.uaihebert.model.test.Car;
import com.uaihebert.model.test.Song;
import com.uaihebert.util.ReflectionUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReflectionUtilTest {
    protected static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void createPersistenceUnit() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("QueryTesterEclipseLink");
//            entityManagerFactory = CodeGenerator.createEntityManagerFactoryForEclipseLink();
//            entityManagerFactory = CodeGenerator.createEntityManagerFactoryForOpenJPA();
        }

        CodeGenerator.generateData(entityManagerFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorWithUnknownAttributeOnEquals() {
        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.andEquals("invalidName", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorWithUnknownAttributeOnGreaterOrLessMethods() {
        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.andGreaterThan("invalidName", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorOnrRefectionUtilWithNullClass() {
        ReflectionUtil.isBigDecimal(null, "invalidName");
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorOnrRefectionUtilWithNullParameter() {
        ReflectionUtil.isBigDecimal(Integer.class, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorOnrRefectionUtilWithEmptyParameter() {
        // trick the cobertura
        new ReflectionUtil(){};
        ReflectionUtil.isBigDecimal(Integer.class, "          ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorOnrRefectionUtilWithInvalidParameter() {
        ReflectionUtil.isCalendar(Integer.class, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isExceptionHappeningIfFieldIsNotFound() {
        ReflectionUtil.isBigDecimal(Car.class, "weight");
        ReflectionUtil.isBigDecimal(Car.class, "asd");
    }

    @Test
    public void isTestingAcceptableListTypeCorrectly() {
        assertTrue(ReflectionUtil.isAcceptableCollection(Set.class));
        assertTrue(ReflectionUtil.isAcceptableCollection(List.class));
        assertTrue(ReflectionUtil.isAcceptableCollection(Collection.class));
        assertFalse(ReflectionUtil.isAcceptableCollection(Object.class));
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}