package com.uaihebert.test;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyAttribute;
import com.uaihebert.model.EasyCTOImp;
import com.uaihebert.model.EasyCriteria;
import com.uaihebert.model.test.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

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
public class EasyCTOTest extends AbstractTest {

    @Test
    public void isCreatingClass() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        assertNotNull(easyCTO);
    }

    @Test
    public void isGettingResultList() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);
        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneAndEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("id", 1);

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);
        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.andEquals("id", 1);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isGettingSingleResult() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("id", 1);

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);
        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.andEquals("id", 1);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getSingleResult().equals(easyCriteria.getSingleResult()));
    }


    @Test
    public void isAddingOneWhereFloatEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("weight", 10f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("weight", 10f);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneOrFloatEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("weight", 10f, 11f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("weight", 10f, 11f);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneWhereDoubleEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("height", 11d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("height", 11d);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneOrDoubleEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("height", 11d, 10d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("height", 11d, 10d);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneWhereLongEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("socialSecurityNumber", 1928371L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("socialSecurityNumber", 1928371L);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneOrLongEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("socialSecurityNumber", 1928371L, 98723487L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("socialSecurityNumber", 1928371L, 98723487L);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneWhereIntegerEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("clothesInCloset", 44);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("clothesInCloset", 44);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneOrIntegerEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("clothesInCloset", 44, 33);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("clothesInCloset", 44, 33);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isWhereNotEqualsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andNotEquals("name", "Anna");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andNotEquals("name", "Anna");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isOrNotEqualsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orNotEquals("name", "Anna", "Mary");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orNotEquals("name", "Anna", "Mary");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingSequentialWhereIntegerEquals() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("shoesInCloset", 10).andEquals("clothesInCloset", 33);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("shoesInCloset", 10).andEquals("clothesInCloset", 33);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneWhereEqualsString() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("name", CodeGenerator.PERSON01_NAME);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("name", CodeGenerator.PERSON01_NAME);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneOrEqualsString() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("name", CodeGenerator.PERSON01_NAME, CodeGenerator.PERSON02_NAME);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("name", CodeGenerator.PERSON01_NAME, CodeGenerator.PERSON02_NAME);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingSequentialWhereEqualsString() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("name", CodeGenerator.PERSON01_NAME).andEquals("nickName", CodeGenerator.PERSON01_NICKNAME);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("name", CodeGenerator.PERSON01_NAME).andEquals("nickName", CodeGenerator.PERSON01_NICKNAME);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneWhereDateEquals() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstJobDate = formatter.parse("1/1/2015");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("firstJobDate", firstJobDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("firstJobDate", firstJobDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneOrDateEquals() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstJobDate = formatter.parse("1/1/2015");
        Date secondJobDate = formatter.parse("1/1/2016");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("firstJobDate", firstJobDate, secondJobDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("firstJobDate", firstJobDate, secondJobDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }


    @Test
    public void isAddingOneWhereCalendarEquals() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(date);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("birthDayDate", dateOfBirth);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("birthDayDate", dateOfBirth);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneOrCalendarEquals() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(date);

        Date date2 = formatter.parse("1/1/2002");
        Calendar dateOfBirth2 = Calendar.getInstance();
        dateOfBirth2.setTime(date2);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("birthDayDate", dateOfBirth, dateOfBirth2);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("birthDayDate", dateOfBirth, dateOfBirth2);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingSequentialWhereDateEquals() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstJobDate = formatter.parse("1/1/2015");
        Date firstSoccerMatchDate = formatter.parse("1/1/2013");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("firstJobDate", firstJobDate).andEquals("firstSoccerMatchDate", firstSoccerMatchDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("firstJobDate", firstJobDate).andEquals("firstSoccerMatchDate", firstSoccerMatchDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingSequentialWhereCalendarEquals() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDay = formatter.parse("1/1/2001");
        Date kissDate = formatter.parse("1/1/2011");

        Calendar birthDayCalendar = Calendar.getInstance();
        birthDayCalendar.setTime(birthDay);

        Calendar firstKiss = Calendar.getInstance();
        firstKiss.setTime(kissDate);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("birthDayDate", birthDayCalendar).andEquals("firstKissDate", firstKiss);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("birthDayDate", birthDayCalendar).andEquals("firstKissDate", firstKiss);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }


    @Test
    public void isAddingOneWhereEqualsBoolean() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("brazilian", true);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("brazilian", true);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingOneOrEqualsBoolean() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("brazilian", true, false);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("brazilian", true, false);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }


    @Test
    public void isAddingSequentialWhereEqualsBoolean() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("brazilian", true).andEquals("japanese", false);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("brazilian", true).andEquals("japanese", false);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingObjectWhereEquals() {
        Address address = new Address();
        address.setId(1);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("address", address);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("address", address);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingObjectOrEquals() {
        Address address = new Address();
        address.setId(1);

        Address address2 = new Address();
        address2.setId(2);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("address", address, address2);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.orEquals("address", address, address2);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAddingSequentialObjectsWhereEquals() {
        Address address = new Address();
        address.setId(1);
        Car car = new Car();
        car.setId(1);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("address", address).andEquals("car", car);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andEquals("address", address).andEquals("car", car);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }


    @Test
    public void isAddingSequentialWhereEquals() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date buildingDate = formatter.parse("1/1/1990");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("id", 2).andEquals("buildingDate", buildingDate).andEquals("isOld", false).andEquals("streetName", "Street B").andEquals("isYellow", true);

        EasyCriteria<Address> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Address.class, easyCTO);

        EasyCriteria<Address> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Address.class);

        easyCriteria.andEquals("id", 2).andEquals("buildingDate", buildingDate).andEquals("isOld", false).andEquals("streetName", "Street B").andEquals("isYellow", true);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDoubleGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterThan("height", 10.50d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andGreaterThan("height", 10.50d);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDoubleGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterOrEqualTo("height", 11.00d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andGreaterOrEqualTo("height", 11.00d);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDoubleLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessThan("height", 11.00d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andLessThan("height", 11.00d);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDoubleLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessOrEqualTo("height", 11.00d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andLessOrEqualTo("height", 11.00d);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isFloatGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterThan("weight", 10.50f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andGreaterThan("weight", 10.50f);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isFloatGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterOrEqualTo("weight", 11.00f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andGreaterOrEqualTo("weight", 11.00f);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isFloatLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessThan("weight", 11.00f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andLessThan("weight", 11.00f);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isFloatLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessOrEqualTo("weight", 10.50f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andLessOrEqualTo("weight", 10.50f);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }


    @Test
    public void isLongGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterThan("totalBooksOwned", 20L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andGreaterThan("totalBooksOwned", 20L);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isLongGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterOrEqualTo("totalBooksOwned", 20L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andGreaterOrEqualTo("totalBooksOwned", 20L);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isLongLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessThan("totalBooksOwned", 30L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andLessThan("totalBooksOwned", 30L);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isLongLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessOrEqualTo("totalBooksOwned", 20L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andLessOrEqualTo("totalBooksOwned", 20L);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isIntegerGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterThan("shoesInCloset", 10);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andGreaterThan("shoesInCloset", 10);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isIntegerGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterOrEqualTo("shoesInCloset", 10);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andGreaterOrEqualTo("shoesInCloset", 10);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isIntegerLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessThan("shoesInCloset", 20);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andLessThan("shoesInCloset", 20);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isIntegerLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessOrEqualTo("shoesInCloset", 20);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andLessOrEqualTo("shoesInCloset", 20);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterThan("name", "John");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andGreaterThan("name", "John");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterOrEqualTo("name", "John");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andGreaterOrEqualTo("name", "John");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessThan("name", "John");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andLessThan("name", "John");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessOrEqualTo("name", "John");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andLessOrEqualTo("name", "John");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDateGreaterThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstJobDate = formatter.parse("01/01/2015");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterThan("firstJobDate", firstJobDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andGreaterThan("firstJobDate", firstJobDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDateGreaterOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstJobDate = formatter.parse("01/01/2015");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterOrEqualTo("firstJobDate", firstJobDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andGreaterOrEqualTo("firstJobDate", firstJobDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDateLessThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstJobDate = formatter.parse("01/01/2015");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessThan("firstJobDate", firstJobDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andLessThan("firstJobDate", firstJobDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDateLessOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date firstJobDate = formatter.parse("01/01/2015");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessOrEqualTo("firstJobDate", firstJobDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andLessOrEqualTo("firstJobDate", firstJobDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }


    @Test
    public void isCalendarGreaterThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar birthDayDate = Calendar.getInstance();
        birthDayDate.setTime(date);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterThan("birthDayDate", birthDayDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andGreaterThan("birthDayDate", birthDayDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isCalendarGreaterOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar birthDayDate = Calendar.getInstance();
        birthDayDate.setTime(date);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterOrEqualTo("birthDayDate", birthDayDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andGreaterOrEqualTo("birthDayDate", birthDayDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isCalendarLessThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar birthDayDate = Calendar.getInstance();
        birthDayDate.setTime(date);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessThan("birthDayDate", birthDayDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andLessThan("birthDayDate", birthDayDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isCalendarLessOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar birthDayDate = Calendar.getInstance();
        birthDayDate.setTime(date);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessOrEqualTo("birthDayDate", birthDayDate);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andLessOrEqualTo("birthDayDate", birthDayDate);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isIntegerBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andBetween("shoesInCloset", 9, 21);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andBetween("shoesInCloset", 9, 21);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isLongBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andBetween("totalBooksOwned", 19L, 31L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        easyCriteria.andBetween("totalBooksOwned", 19L, 31L);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andBetween("name", "A", "L");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andBetween("name", "A", "L");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDateBetweenWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date valueA = formatter.parse("1/1/2014");
        Date valueB = formatter.parse("1/1/2017");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andBetween("firstJobDate", valueA, valueB);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andBetween("firstJobDate", valueA, valueB);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isCalendarBetweenWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateA = formatter.parse("5/5/2000");
        Date dateB = formatter.parse("5/5/2003");
        Calendar valueA = Calendar.getInstance();
        valueA.setTime(dateA);
        Calendar valueB = Calendar.getInstance();
        valueB.setTime(dateB);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andBetween("birthDayDate", valueA, valueB);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andBetween("birthDayDate", valueA, valueB);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDoubleBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andBetween("height", 9.00d, 12.00d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andBetween("height", 9.00d, 12.00d);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isFloatBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andBetween("weight", 9.00f, 12.00f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andBetween("weight", 9.00f, 12.00f);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isNullWorking() {
        EasyCriteria easyCTO1 = EasyCriteriaFactory.createEasyCTO();
        easyCTO1.andIsNull("nickName");

        EasyCriteria<Person> easyViewCTO1 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO1);

        EasyCriteria<Person> personCriteria1 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        personCriteria1.andIsNull("nickName");

        assertTrue(easyViewCTO1.getResultList().size() == personCriteria1.getResultList().size());
        assertTrue(easyViewCTO1.getResultList().containsAll(personCriteria1.getResultList()));

        EasyCriteria<Person> personCriteria2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        personCriteria2.andIsNull("nickName");

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andIsNull("nickName");

        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO2.getResultList().size() == personCriteria2.getResultList().size());
        assertTrue(easyViewCTO2.getResultList().containsAll(personCriteria2.getResultList()));

        EasyCriteria easyCTO3 = EasyCriteriaFactory.createEasyCTO();
        easyCTO3.andIsNull("shoesInCloset");

        EasyCriteria<Person> easyViewCTO3 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO3);

        EasyCriteria<Person> personCriteria3 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        personCriteria3.andIsNull("shoesInCloset");

        assertTrue(easyViewCTO3.getResultList().size() == personCriteria3.getResultList().size());
        assertTrue(easyViewCTO3.getResultList().containsAll(personCriteria3.getResultList()));

        EasyCriteria easyCTO4 = EasyCriteriaFactory.createEasyCTO();
        easyCTO4.andIsNull("car");

        EasyCriteria<Person> easyViewCTO4 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO4);

        EasyCriteria<Person> personCriteria4 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        personCriteria4.andIsNull("car");

        assertTrue(easyViewCTO4.getResultList().size() == personCriteria4.getResultList().size());
        assertTrue(easyViewCTO4.getResultList().containsAll(personCriteria4.getResultList()));
    }

    @Test
    public void isNotNullWorking() {
        EasyCriteria easyCTO1 = EasyCriteriaFactory.createEasyCTO();
        easyCTO1.andIsNotNull("nickName");

        EasyCriteria<Person> easyViewCTO1 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO1);

        EasyCriteria<Person> personCriteria1 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        personCriteria1.andIsNotNull("nickName");

        assertTrue(easyViewCTO1.getResultList().size() == personCriteria1.getResultList().size());
        assertTrue(easyViewCTO1.getResultList().containsAll(personCriteria1.getResultList()));

        EasyCriteria<Person> personCriteria2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        personCriteria2.andIsNotNull("nickName");

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andIsNotNull("nickName");

        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO2.getResultList().size() == personCriteria2.getResultList().size());
        assertTrue(easyViewCTO2.getResultList().containsAll(personCriteria2.getResultList()));

        EasyCriteria easyCTO3 = EasyCriteriaFactory.createEasyCTO();
        easyCTO3.andIsNotNull("shoesInCloset");

        EasyCriteria<Person> easyViewCTO3 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO3);

        EasyCriteria<Person> personCriteria3 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        personCriteria3.andIsNotNull("shoesInCloset");

        assertTrue(easyViewCTO3.getResultList().size() == personCriteria3.getResultList().size());
        assertTrue(easyViewCTO3.getResultList().containsAll(personCriteria3.getResultList()));

        EasyCriteria easyCTO4 = EasyCriteriaFactory.createEasyCTO();
        easyCTO4.andIsNotNull("car");

        EasyCriteria<Person> easyViewCTO4 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO4);

        EasyCriteria<Person> personCriteria4 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        personCriteria4.andIsNotNull("car");

        assertTrue(easyViewCTO4.getResultList().size() == personCriteria4.getResultList().size());
        assertTrue(easyViewCTO4.getResultList().containsAll(personCriteria4.getResultList()));
    }

    @Test
    public void isListIsEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andCollectionIsEmpty("dogs");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andCollectionIsEmpty("dogs");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isCollectionIsEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andCollectionIsEmpty("cats");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andCollectionIsEmpty("cats");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isSetIsEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andCollectionIsEmpty("certifications");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andCollectionIsEmpty("certifications");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isListIsNotEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andCollectionIsNotEmpty("dogs");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andCollectionIsNotEmpty("dogs");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isCollectionIsNotEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andCollectionIsNotEmpty("cats");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andCollectionIsNotEmpty("cats");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isSetIsNotEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andCollectionIsNotEmpty("certifications");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andCollectionIsNotEmpty("certifications");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringLikeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringLike("name", "M%");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andStringLike("name", "M%");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));

        easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringLike("name", "%y");

        easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andStringLike("name", "%y");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringLikeNotWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringNotLike("name", "M%");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andStringNotLike("name", "M%");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));

        easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringNotLike("name", "%y");

        easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andStringNotLike("name", "%y");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringInWorking() {
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Mary");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringIn("name", names);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andStringIn("name", names);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isStringNotInWorking() {
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Mary");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringNotIn("name", names);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.andStringNotIn("name", names);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isOrderByWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orderByAsc("shoesInCloset").orderByDesc("name");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.orderByAsc("shoesInCloset").orderByDesc("name");

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));

        for (int i = 0; i < easyViewCTO.getResultList().size(); i++) {
            assertEquals(easyViewCTO.getResultList().get(i), easyCriteriaResult.get(i));
        }
    }

    @Test
    public void isInnerJoinWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("dogs");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoin("dogs");

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isWhereLeftJoinWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.leftJoin("dogs");
        easyCTO.andJoinEquals("dogs", "name", "Fire");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);

        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.leftJoin("dogs");
        easyCriteria.andJoinEquals("dogs", "name", "Fire");

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isExceptionWithNullJoinTypeNull() {
        EasyCriteria easyCriteria = EasyCriteriaFactory.createEasyCTO();
        EasyCTOImp easyCTO = (EasyCTOImp) easyCriteria;
        easyCTO.getConfigurations().getEasyAttributes().add(EasyAttribute.newInstance(null, null, null, null, false));

        EasyCriteria<Person> queryCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        queryCriteria.getResultList();
    }

    @Test
    public void isWhereInnerJoinFetchWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoinFetch("dogs");
        easyCTO.andJoinEquals("dogs", "name", "Fire");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoinFetch("dogs");
        easyCriteria.andJoinEquals("dogs", "name", "Fire");

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        List<Person> resultList = easyViewCTO.getResultList();

        assertEquals(resultList.size(), easyCriteriaResult.size());

        assertTrue(easyCriteriaResult.containsAll(resultList));
    }

    @Test
    public void isWhereJoinNotEqualsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoinFetch("dogs");
        easyCTO.setDistinctTrue();
        easyCTO.andJoinNotEquals("dogs", "name", "Fire");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoinFetch("dogs");
        easyCriteria.setDistinctTrue();
        easyCriteria.andJoinNotEquals("dogs", "name", "Fire");

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        List<Person> resultList = easyViewCTO.getResultList();
        assertEquals(resultList.size(), easyCriteriaResult.size());

        assertTrue(resultList.containsAll(easyCriteriaResult));
    }

    @Test
    public void isWhereLeftJoinFetchWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoinFetch("dogs");
        easyCTO.andJoinEquals("dogs", "name", "Dark");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoinFetch("dogs");
        easyCriteria.andJoinEquals("dogs", "name", "Dark");

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinIntegerGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterThan("dogs", "toysTotal", 5);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterThan("dogs", "toysTotal", 5);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinIntegerGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterOrEqualTo("dogs", "toysTotal", 5);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterOrEqualTo("dogs", "toysTotal", 5);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinIntegerLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessThan("dogs", "toysTotal", 13);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessThan("dogs", "toysTotal", 13);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }


    @Test
    public void isPaginationWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setFirstResult(1);
        easyCTO.setMaxResults(1);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> personsCTO = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.setFirstResult(1);
        easyCriteria.setMaxResults(1);

        List<Person> persons = easyCriteria.getResultList();
        assertEquals(persons.size(), personsCTO.size());
        assertTrue(persons.containsAll(personsCTO));

        easyCriteria.setFirstResult(2);
        easyCriteria.setMaxResults(1);
        persons = easyCriteria.getResultList();

        easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setFirstResult(2);
        easyCTO.setMaxResults(1);

        easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        personsCTO = easyViewCTO.getResultList();
        assertEquals(persons.size(), personsCTO.size());
        assertTrue(persons.containsAll(personsCTO));
    }

    @Test
    public void isJoinIntegerLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessOrEqualTo("dogs", "toysTotal", 13);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessOrEqualTo("dogs", "toysTotal", 13);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinLongGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterThan("dogs", "fleasTotal", 5L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterThan("dogs", "fleasTotal", 5L);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinLongGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterOrEqualTo("dogs", "fleasTotal", 5L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterOrEqualTo("dogs", "fleasTotal", 5L);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinLongLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessThan("dogs", "fleasTotal", 13L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessThan("dogs", "fleasTotal", 13L);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinLongLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessOrEqualTo("dogs", "fleasTotal", 13L);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessOrEqualTo("dogs", "fleasTotal", 13L);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDoubleGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterThan("dogs", "weight", 5.00d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterThan("dogs", "weight", 5.00d);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDoubleGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterOrEqualTo("dogs", "weight", 5.00d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterOrEqualTo("dogs", "weight", 5.00d);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }


    @Test
    public void isJoinDoubleLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessThan("dogs", "weight", 13.00d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessThan("dogs", "weight", 13.00d);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDoubleLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessOrEqualTo("dogs", "weight", 13.00d);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessOrEqualTo("dogs", "weight", 13.00d);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinFloatGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterThan("dogs", "hairSize", 5.00f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterThan("dogs", "hairSize", 5.00f);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinFloatGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterOrEqualTo("dogs", "hairSize", 5.00f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterOrEqualTo("dogs", "hairSize", 5.00f);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinFloatLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessThan("dogs", "hairSize", 13.00f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessThan("dogs", "hairSize", 13.00f);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinFloatLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessOrEqualTo("dogs", "hairSize", 13.00f);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessOrEqualTo("dogs", "hairSize", 13.00f);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDateGreaterThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth = formatter.parse("19/10/2005");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("dateOfBirth", dateOfBirth);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterThan("dogs", "dateOfBirth", dateOfBirth);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterThan("dogs", "dateOfBirth", dateOfBirth);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDateGreaterOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth = formatter.parse("19/10/2005");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("dateOfBirth", dateOfBirth);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinGreaterOrEqualTo("dogs", "dateOfBirth", dateOfBirth);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinGreaterOrEqualTo("dogs", "dateOfBirth", dateOfBirth);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDateLessThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth = formatter.parse("19/10/2005");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("dateOfBirth", dateOfBirth);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessThan("dogs", "dateOfBirth", dateOfBirth);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessThan("dogs", "dateOfBirth", dateOfBirth);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDateLessOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth = formatter.parse("01/01/2009");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("dateOfBirth", dateOfBirth);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinLessOrEqualTo("dogs", "dateOfBirth", dateOfBirth);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinLessOrEqualTo("dogs", "dateOfBirth", dateOfBirth);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinCalendarGreaterThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(date);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("birthDayDate", dateOfBirth);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinGreaterThan("person", "birthDayDate", dateOfBirth);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinGreaterThan("person", "birthDayDate", dateOfBirth);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinCalendarGreaterOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(date);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("birthDayDate", dateOfBirth);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinGreaterOrEqualTo("person", "birthDayDate", dateOfBirth);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinGreaterOrEqualTo("person", "birthDayDate", dateOfBirth);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinCalendarLessThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(date);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("birthDayDate", dateOfBirth);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinLessThan("person", "birthDayDate", dateOfBirth);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinLessThan("person", "birthDayDate", dateOfBirth);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinCalendarLessOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(date);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("birthDayDate", dateOfBirth);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinLessOrEqualTo("person", "birthDayDate", dateOfBirth);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinLessOrEqualTo("person", "birthDayDate", dateOfBirth);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinStringGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinGreaterThan("person", "name", "Mary");

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinGreaterThan("person", "name", "Mary");

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinStringGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinGreaterOrEqualTo("person", "name", "Mary");

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinGreaterOrEqualTo("person", "name", "Mary");

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinStringLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinLessThan("person", "name", "Mary");

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinLessThan("person", "name", "Mary");

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinStringLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinLessOrEqualTo("person", "name", "Mary");

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinLessOrEqualTo("person", "name", "Mary");

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinIntegerBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinBetween("person", "clothesInCloset", 30, 35);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinBetween("person", "clothesInCloset", 30, 35);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinLongBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinBetween("person", "totalBooksOwned", 19L, 31L);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinBetween("person", "totalBooksOwned", 19L, 31L);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDoubleBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinBetween("person", "height", 9.00d, 12.00d);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinBetween("person", "height", 9.00d, 12.00d);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinFloatBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinBetween("person", "weight", 9.00f, 12.00f);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinBetween("person", "weight", 9.00f, 12.00f);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinStringBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinBetween("person", "name", "A", "L");

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinBetween("person", "name", "A", "L");

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinDateBetweenWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date valueA = formatter.parse("1/1/2008");
        Date valueB = formatter.parse("1/1/2010");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("valueA", valueA);
        parameters.put("valueB", valueB);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        // Workaround for OpenJPA
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("dogs");
        easyCTO.andJoinBetween("dogs", "dateOfBirth", valueA, valueB);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        // Workaround for OpenJPA
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("dogs");
        easyCriteria.andJoinBetween("dogs", "dateOfBirth", valueA, valueB);

        List<Person> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinCalendarBetweenWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateA = formatter.parse("1/1/2000");
        Date dateB = formatter.parse("5/5/2002");
        Calendar valueA = Calendar.getInstance();
        valueA.setTime(dateA);
        Calendar valueB = Calendar.getInstance();
        valueB.setTime(dateB);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("valueA", valueA);
        parameters.put("valueB", valueB);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinBetween("person", "birthDayDate", valueA, valueB);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinBetween("person", "birthDayDate", valueA, valueB);

        List<Dog> easyCriteriaResult = easyCriteria.getResultList();

        assertEquals(easyViewCTO.getResultList().size(), easyCriteriaResult.size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteriaResult));
    }

    @Test
    public void isJoinAttributeNullWorking() {
        EasyCriteria easyCTO1 = EasyCriteriaFactory.createEasyCTO();
        easyCTO1.innerJoin("person");
        easyCTO1.andJoinAttributeIsNull("person", "nickName");

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO1);

        EasyCriteria<Dog> carCriteria1 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        carCriteria1.innerJoin("person");
        carCriteria1.andJoinAttributeIsNull("person", "nickName");

        assertTrue(easyViewCTO.getResultList().size() == carCriteria1.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(carCriteria1.getResultList()));

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinAttributeIsNull("person", "birthDayDate");

        easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        EasyCriteria<Dog> carCriteria2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        carCriteria2.innerJoin("person");
        carCriteria2.andJoinAttributeIsNull("person", "birthDayDate");

        assertTrue(easyViewCTO.getResultList().size() == carCriteria2.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(carCriteria2.getResultList()));

        EasyCriteria easyCTO3 = EasyCriteriaFactory.createEasyCTO();
        easyCTO3.innerJoin("person");
        easyCTO3.andJoinAttributeIsNull("person", "clothesInCloset");

        EasyCriteria<Car> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO3);

        EasyCriteria<Car> carCriteria3 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        carCriteria3.innerJoin("person");
        carCriteria3.andJoinAttributeIsNull("person", "clothesInCloset");

        assertTrue(easyViewCTO2.getResultList().size() == carCriteria3.getResultList().size());
        assertTrue(easyViewCTO2.getResultList().containsAll(carCriteria3.getResultList()));

        EasyCriteria easyCTO4 = EasyCriteriaFactory.createEasyCTO();
        easyCTO4.innerJoin("person");
        easyCTO4.andJoinAttributeIsNull("person", "car");

        easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO4);

        EasyCriteria<Dog> dogCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        dogCriteria.innerJoin("person");
        dogCriteria.andJoinAttributeIsNull("person", "car");

        assertTrue(easyViewCTO.getResultList().size() == dogCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(dogCriteria.getResultList()));
    }

    @Test
    public void isJoinAttributeNotNullWorking() {
        EasyCriteria easyCTO1 = EasyCriteriaFactory.createEasyCTO();
        easyCTO1.innerJoin("person");
        easyCTO1.andJoinAttributeIsNotNull("person", "nickName");

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO1);

        EasyCriteria<Car> carCriteria1 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        carCriteria1.innerJoin("person");
        carCriteria1.andJoinAttributeIsNotNull("person", "nickName");

        assertTrue(easyViewCTO.getResultList().size() == carCriteria1.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(carCriteria1.getResultList()));

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinAttributeIsNotNull("person", "birthDayDate");

        easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO2);

        EasyCriteria<Car> carCriteria2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        carCriteria2.innerJoin("person");
        carCriteria2.andJoinAttributeIsNotNull("person", "birthDayDate");

        assertTrue(easyViewCTO.getResultList().size() == carCriteria2.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(carCriteria2.getResultList()));

        EasyCriteria easyCTO3 = EasyCriteriaFactory.createEasyCTO();
        easyCTO3.innerJoin("person");
        easyCTO3.andJoinAttributeIsNotNull("person", "clothesInCloset");

        EasyCriteria<Car> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO3);

        EasyCriteria<Car> carCriteria3 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        carCriteria3.innerJoin("person");
        carCriteria3.andJoinAttributeIsNotNull("person", "clothesInCloset");

        assertTrue(easyViewCTO2.getResultList().size() == carCriteria3.getResultList().size());
        assertTrue(easyViewCTO2.getResultList().containsAll(carCriteria3.getResultList()));

        EasyCriteria easyCTO4 = EasyCriteriaFactory.createEasyCTO();
        easyCTO4.innerJoin("person");
        easyCTO4.andJoinAttributeIsNotNull("person", "car");

        EasyCriteria<Dog> easyViewCTO3 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO4);

        EasyCriteria<Dog> dogCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        dogCriteria.innerJoin("person");
        dogCriteria.andJoinAttributeIsNotNull("person", "car");

        assertTrue(easyViewCTO3.getResultList().size() == dogCriteria.getResultList().size());
        assertTrue(easyViewCTO3.getResultList().containsAll(dogCriteria.getResultList()));
    }

    @Test
    public void isJoinListIsEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinListIsEmpty("person", "dogs");

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);

        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinListIsEmpty("person", "dogs");

        if (!isEclipseLink()) {
            assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
            assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        }
    }

    @Test
    public void isJoinCollectionIsEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinCollectionIsEmpty("person", "cats");

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);

        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinCollectionIsEmpty("person", "cats");

        if (!isEclipseLink()) {
            assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
            assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        }
    }

    @Test
    public void isJoinSetIsEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinSetIsEmpty("person", "certifications");

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);

        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinSetIsEmpty("person", "certifications");

        if (!isEclipseLink()) {
            assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
            assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        }
    }

    @Test
    public void isJoinListIsNotEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        // Workaround for OpenJPA
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinListIsNotEmpty("person", "dogs");

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);

        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinListIsNotEmpty("person", "dogs");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isJoinCollectionIsNotEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinCollectionIsNotEmpty("person", "cats");

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);

        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinCollectionIsNotEmpty("person", "cats");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isJoinSetIsNotEmptyWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinSetIsNotEmpty("person", "certifications");

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);

        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinSetIsNotEmpty("person", "certifications");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isJoinStringLikeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringLike("person", "name", "M%");

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinStringLike("person", "name", "M%");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));

        easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringLike("person", "name", "M%");

        easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinStringLike("person", "name", "%y");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isJoinStringNotLikeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringNotLike("person", "name", "M%");

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinStringNotLike("person", "name", "M%");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));

        easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringNotLike("person", "name", "M%");

        easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinStringNotLike("person", "name", "%y");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isJoinStringInWorking() {
        List<String> names = new ArrayList<String>();
        names.add("Mary");
        names.add("John");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringIn("person", "name", names);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinStringIn("person", "name", names);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isJoinStringNotInWorking() {
        List<String> names = new ArrayList<String>();
        names.add("Mary");
        names.add("John");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringNotIn("person", "name", names);

        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria<Dog> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class);
        easyCriteria.innerJoin("person");
        easyCriteria.andJoinStringNotIn("person", "name", names);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void addOrWithDecimal() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("weight", new BigDecimal(20), new BigDecimal(30));

        EasyCriteria<Car> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class, easyCTO);

        EasyCriteria<Car> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Car.class);
        easyCriteria.orEquals("weight", new BigDecimal(20), new BigDecimal(30));

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isTwoOrIdsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("id", 1).orEquals("id", 2);

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);

        easyCriteria.orEquals("id", 1).orEquals("id", 2);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isTwoOrAttributesWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("id", 1).orEquals("length", 20);

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.orEquals("id", 1).orEquals("length", 20);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isThreeOrAttributesWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("id", 1).orEquals("length", 40).orEquals("artist", "Group 1 Crew");

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.orEquals("id", 1).orEquals("length", 40).orEquals("artist", "Group 1 Crew");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isThreeOrAttributesWithOneRepeatedWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("id", 1, 2).orEquals("length", 40).orEquals("artist", "Group 1 Crew");

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.orEquals("id", 1, 2).orEquals("length", 40).orEquals("artist", "Group 1 Crew");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isOrAndOneEqualsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("artist", "Red").orEquals("id", 11, 12, 13);

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.andEquals("artist", "Red").orEquals("id", 11, 12, 13);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isOrAndTwoEqualsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("artist", "Red").andEquals("type", SongType.ROCK).orEquals("id", 11, 12, 13);

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);

        easyCriteria.andEquals("artist", "Red").andEquals("type", SongType.ROCK).orEquals("id", 11, 12, 13);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isDifferentOrAndTwoEqualsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals("artist", "Red").andEquals("type", SongType.ROCK).orEquals("id", 12).orEquals("name", "Breath Into Me");

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.andEquals("artist", "Red").andEquals("type", SongType.ROCK).orEquals("id", 12).orEquals("name", "Breath Into Me");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isTwoOrGroupedInsideAndWithIntStringWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("id", "1").orEquals("id", "2").orEquals(2, "name", "Sing Out").orEquals(2, "name", "Alive");

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.orEquals("id", "1").orEquals("id", "2").orEquals(2, "name", "Sing Out").orEquals(2, "name", "Alive");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isTwoOrGroupedInsideAndWithMoreAttributesWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("totalDownloads", 20L).orEquals("weight", 10.00f).orEquals(2, "price", 20.00d).orEquals(2, "type", SongType.PRAISE);

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.orEquals("totalDownloads", 20L).orEquals("weight", 10.00f).orEquals(2, "price", 20.00d).orEquals(2, "type", SongType.PRAISE);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void addAndSeparatedByOr() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.addAndSeparatedByOr(1, "id", 1).addAndSeparatedByOr(1, "name", "Sing Out").addAndSeparatedByOr(2, "id", 2).addAndSeparatedByOr(2, "name", "Alive");

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);
        easyCriteria.addAndSeparatedByOr(1, "id", 1).addAndSeparatedByOr(1, "name", "Sing Out").addAndSeparatedByOr(2, "id", 2).addAndSeparatedByOr(2, "name", "Alive");

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void addAndSeparatedByOrOtherParameters() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.addAndSeparatedByOr(1, "totalDownloads", 20L).addAndSeparatedByOr(1, "price", 20.00d).addAndSeparatedByOr(2, "weight", 10.00f).addAndSeparatedByOr(2, "type", SongType.PRAISE);

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria<Song> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class);

        easyCriteria.addAndSeparatedByOr(1, "totalDownloads", 20L).addAndSeparatedByOr(1, "price", 20.00d).addAndSeparatedByOr(2, "weight", 10.00f).addAndSeparatedByOr(2, "type", SongType.PRAISE);

        assertTrue(easyViewCTO.getResultList().size() == easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAndEqualsLowerCaseWorking() {
        EasyCriteria<Person> criteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        criteria.andEquals("name", CodeGenerator.PERSON01_NAME);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andEquals(true, "name", CodeGenerator.PERSON01_NAME.toLowerCase());

        EasyCriteria<Person> criteriaCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        assertTrue(criteria.getResultList().containsAll(criteriaCTO.getResultList()));
    }

    @Test
    public void isAndNotEqualsLowerCaseWorking() {
        EasyCriteria<Person> criteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        criteria.andNotEquals(true, "name", CodeGenerator.PERSON01_NAME.toLowerCase());

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andNotEquals(true, "name", CodeGenerator.PERSON01_NAME.toLowerCase());

        EasyCriteria<Person> criteriaCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        assertTrue(criteria.getResultList().containsAll(criteriaCTO.getResultList()));
    }

    @Test
    public void isOrEqualsLowerCaseWorking() {
        EasyCriteria<Person> criteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        criteria.orEquals("name", CodeGenerator.PERSON01_NAME);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals(true, "name", CodeGenerator.PERSON01_NAME.toLowerCase());

        EasyCriteria<Person> criteriaCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        assertTrue(criteria.getResultList().containsAll(criteriaCTO.getResultList()));
    }

    @Test
    public void isOrEqualsIndexLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orEquals("id", "1").orEquals("id", "2").orEquals(2, "name", "Sing Out").orEquals(2, "name", "Alive");

        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.orEquals("id", "1").orEquals("id", "2").orEquals(true, 2, "name", "Sing Out".toLowerCase()).orEquals(true, 2, "name", "Alive".toLowerCase());

        EasyCriteria<Song> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isOrNotEqualsLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.orNotEquals("name", "Anna", "Mary");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.orNotEquals(true, "name", "Anna".toLowerCase(), "Mary".toLowerCase());

        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isGreaterThanLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterThan("name", "John");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andGreaterThan(true, "name", "John".toLowerCase());

        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isGreaterOrEqualToLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andGreaterOrEqualTo("name", "John");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andGreaterOrEqualTo(true, "name", "John".toLowerCase());
        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isLessThanLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessThan("name", "John");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andLessThan(true, "name", "John".toLowerCase());

        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);
        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isLessOrEqualToLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andLessOrEqualTo("name", "John");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andLessOrEqualTo(true, "name", "John".toLowerCase());
        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isBetweenLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andBetween("name", "A", "L");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andBetween(true, "name", "A".toLowerCase(), "L".toLowerCase());
        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertFalse(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isLikeLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringLike("name", "M%");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andStringLike(true, "name", "M%".toLowerCase());
        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isLikeNotLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringNotLike("name", "M%");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andStringNotLike(true, "name", "M%".toLowerCase());
        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isInLowerCaseWorking() {
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Mary");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringIn("name", names);
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        names = new ArrayList<String>();
        names.add("John".toLowerCase());
        names.add("Mary".toLowerCase());

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andStringIn(true, "name", names);
        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isNotInLowerCaseWorking() {
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Mary");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.andStringNotIn("name", names);

        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        names = new ArrayList<String>();
        names.add("John".toLowerCase());
        names.add("Mary".toLowerCase());

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.andStringNotIn(true, "name", names);

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);
        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinEqualsLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoinFetch("dogs");
        easyCTO.andJoinEquals("dogs", "name", "Fire");

        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.setDistinctTrue();
        easyCTO2.innerJoinFetch("dogs");
        easyCTO2.andJoinEquals(true, "dogs", "name", "Fire".toLowerCase());

        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);
        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinNotEqualsLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoinFetch("dogs");
        easyCTO.andJoinNotEquals("dogs", "name", "Fire");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.setDistinctTrue();
        easyCTO2.innerJoinFetch("dogs");
        easyCTO2.andJoinNotEquals(true, "dogs", "name", "Fire".toLowerCase());
        EasyCriteria<Person> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinGreaterThanLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinGreaterThan("person", "name", "Mary");
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.setDistinctTrue();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinGreaterThan(true, "person", "name", "Mary".toLowerCase());
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinGreaterOrEqualToLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinGreaterOrEqualTo("person", "name", "Mary");
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.setDistinctTrue();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinGreaterOrEqualTo(true, "person", "name", "Mary".toLowerCase());
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinLessThanLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinLessThan("person", "name", "Mary");
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.setDistinctTrue();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinLessThan(true, "person", "name", "Mary".toLowerCase());
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinLessOrEqualToLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("person");
        easyCTO.andJoinLessOrEqualTo("person", "name", "Mary");
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.setDistinctTrue();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinLessOrEqualTo(true, "person", "name", "Mary".toLowerCase());
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinBetweenLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinBetween("person", "name", "A", "L");
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinBetween(true, "person", "name", "A".toLowerCase(), "L".toLowerCase());
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinLikeLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringLike("person", "name", "M%");
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinStringLike(true, "person", "name", "m%");
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinNotLikeLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringNotLike("person", "name", "M%");
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinStringNotLike(true, "person", "name", "m%");
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinStringInLowerCaseWorking() {
        List<String> names = new ArrayList<String>();
        names.add("Mary");
        names.add("John");
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringIn("person", "name", names);
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        List<String> names2 = new ArrayList<String>();
        names2.add("Mary".toLowerCase());
        names2.add("John".toLowerCase());

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinStringIn(true, "person", "name", names2);
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isJoinStringNotInLowerCaseWorking() {
        List<String> names = new ArrayList<String>();
        names.add("Mary");
        names.add("John");
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("person");
        easyCTO.andJoinStringNotIn("person", "name", names);
        EasyCriteria<Dog> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO);

        List<String> names2 = new ArrayList<String>();
        names2.add("Mary".toLowerCase());
        names2.add("John".toLowerCase());

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.innerJoin("person");
        easyCTO2.andJoinStringNotIn(true, "person", "name", names2);
        EasyCriteria<Dog> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Dog.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void addAndSeparatedByOrLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.addAndSeparatedByOr(1, "id", 1).addAndSeparatedByOr(1, "name", "Sing Out").addAndSeparatedByOr(2, "id", 2).addAndSeparatedByOr(2, "name", "Alive");
        EasyCriteria<Song> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO);

        EasyCriteria easyCTO2 = EasyCriteriaFactory.createEasyCTO();
        easyCTO2.addAndSeparatedByOr(1, "id", 1).addAndSeparatedByOr(true, 1, "name", "Sing Out".toLowerCase()).addAndSeparatedByOr(2, "id", 2).addAndSeparatedByOr(true, 2, "name", "Alive".toLowerCase());
        EasyCriteria<Song> easyViewCTO2 = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Song.class, easyCTO2);

        assertTrue(easyViewCTO.getResultList().containsAll(easyViewCTO2.getResultList()));
    }

    @Test
    public void isMultipleJoin1LevelWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("car.color");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoin("car.color");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoin2LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("car.color.manufacturer");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoin("car.color.manufacturer");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoin3LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("car.color.manufacturer.products");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoin("car.color.manufacturer.products");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoin4LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("car.color.manufacturer.products.nickNames");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoin("car.color.manufacturer.products.nickNames");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinFetch1LevelWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoinFetch("car.color");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoinFetch("car.color");

        List<Person> result = easyCriteria.getResultList();
        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinFetch2LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoinFetch("car.color.manufacturer");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoinFetch("car.color.manufacturer");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));

    }

    @Test
    public void isMultipleJoinFetch3LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoinFetch("car.color.manufacturer.products");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoinFetch("car.color.manufacturer.products");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinFetch4LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoinFetch("car.color.manufacturer.products.nickNames");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoinFetch("car.color.manufacturer.products.nickNames");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoin1LevelWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoin("car.color");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoin("car.color");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoin2LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoin("car.color.manufacturer");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoin("car.color.manufacturer");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoin3LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoin("car.color.manufacturer.products");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoin("car.color.manufacturer.products");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoin4LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.leftJoin("car");
        easyCTO.leftJoin("car.color");
        easyCTO.leftJoin("car.color.manufacturer");
        easyCTO.leftJoin("car.color.manufacturer.products");
        easyCTO.leftJoin("car.color.manufacturer.products.nickNames");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.leftJoin("car");
        easyCriteria.leftJoin("car.color");
        easyCriteria.leftJoin("car.color.manufacturer");
        easyCriteria.leftJoin("car.color.manufacturer.products");
        easyCriteria.leftJoin("car.color.manufacturer.products.nickNames");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleMixedJoin4LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("car");
        easyCTO.leftJoin("car.color");
        easyCTO.leftJoin("car.color.manufacturer");
        easyCTO.leftJoin("car.color.manufacturer.products");
        easyCTO.leftJoin("car.color.manufacturer.products.nickNames");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("car");
        easyCriteria.leftJoin("car.color");
        easyCriteria.leftJoin("car.color.manufacturer");
        easyCriteria.leftJoin("car.color.manufacturer.products");
        easyCriteria.leftJoin("car.color.manufacturer.products.nickNames");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoinFetch1LevelWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoinFetch("car.color");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoinFetch("car.color");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoinFetch2LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoinFetch("car.color.manufacturer");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoinFetch("car.color.manufacturer");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoinFetch3LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoinFetch("car.color.manufacturer.products");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoinFetch("car.color.manufacturer.products");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));

    }

    @Test
    public void isMultipleLeftJoinFetch4LevelsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoinFetch("car.color.manufacturer.products.nickNames");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoinFetch("car.color.manufacturer.products.nickNames");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWhereWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("car.color");
        easyCTO.andEquals("car.color.name", "Red");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoin("car.color");
        easyCriteria.andEquals("car.color.name", "Red");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoinLevel2WhereWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoin("car");
        easyCTO.innerJoin("car.color");
        easyCTO.andEquals("car.color.name", "Red");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoin("car");
        easyCriteria.innerJoin("car.color");
        easyCriteria.andEquals("car.color.name", "Red");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoinLevel3WhereWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoin("car.color.manufacturer");
        easyCTO.andEquals("car.color.manufacturer.name", "Company A");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoin("car.color.manufacturer");
        easyCriteria.andEquals("car.color.manufacturer.name", "Company A");

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleLeftJoinLevel3LowerCaseWhereWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.leftJoin("car.color.manufacturer");
        easyCTO.andEquals(true, "car.color.manufacturer.name", "Company B".toLowerCase());
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.leftJoin("car.color.manufacturer");
        easyCriteria.andEquals(true, "car.color.manufacturer.name", "Company B".toLowerCase());

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }


    @Test
    public void isMultipleLeftJoinLevel1LowerCaseWhereWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("car");
        easyCTO.andEquals(true, "car.name", "Dark Horse".toLowerCase());
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);
        List<Person> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoin("car");
        easyCriteria.andEquals(true, "car.name", "Dark Horse".toLowerCase());

        List<Person> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithEqualsInCollectionsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andEquals("products.nickNames.name", "NickName B");
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andEquals("products.nickNames.name", "NickName B");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithEqualsLowerCaseInCollectionsWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andEquals(true, "products.nickNames.name", "NickName B".toLowerCase());
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andEquals(true, "products.nickNames.name", "NickName B".toLowerCase());

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithIntegerGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterThan("products.nickNames.id", 1);
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterThan("products.nickNames.id", 1);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithIntegerGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterOrEqualTo("products.nickNames.id", 1);
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterOrEqualTo("products.nickNames.id", 1);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithIntegerLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessThan("products.nickNames.id", 2);
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessThan("products.nickNames.id", 2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithIntegerLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessOrEqualTo("products.nickNames.id", 2);
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessOrEqualTo("products.nickNames.id", 2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDoubleGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterThan("products.nickNames.justFloat", 1d);
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterThan("products.nickNames.justFloat", 1d);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDoubleGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterOrEqualTo("products.nickNames.justFloat", 1d);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();


        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterOrEqualTo("products.nickNames.justFloat", 1d);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDoubleLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessThan("products.nickNames.justFloat", 2d);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessThan("products.nickNames.justFloat", 2d);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDoubleLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessOrEqualTo("products.nickNames.justFloat", 2d);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessOrEqualTo("products.nickNames.justFloat", 2d);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithLongGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterThan("products.nickNames.justLong", 1L);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterThan("products.nickNames.justLong", 1L);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithLongGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterOrEqualTo("products.nickNames.justLong", 1L);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterOrEqualTo("products.nickNames.justLong", 1L);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithLongLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessThan("products.nickNames.justLong", 2L);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessThan("products.nickNames.justLong", 2L);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithLongLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessOrEqualTo("products.nickNames.justLong", 2L);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessOrEqualTo("products.nickNames.justLong", 2L);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithFloatGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterThan("products.nickNames.justFloat", 1F);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterThan("products.nickNames.justFloat", 1F);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }


    @Test
    public void isMultipleJoinWithFloatGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterOrEqualTo("products.nickNames.justFloat", 1F);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterOrEqualTo("products.nickNames.justFloat", 1F);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithFloatLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessThan("products.nickNames.justFloat", 2F);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessThan("products.nickNames.justFloat", 2F);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithFloatLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessOrEqualTo("products.nickNames.justFloat", 2F);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessOrEqualTo("products.nickNames.justFloat", 2F);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithBigDecimalGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterThan("products.nickNames.justBigDecimal", new BigDecimal(1));

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterThan("products.nickNames.justBigDecimal", new BigDecimal(1));

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithBigDecimalGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterOrEqualTo("products.nickNames.justBigDecimal", new BigDecimal(1));

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterOrEqualTo("products.nickNames.justBigDecimal", new BigDecimal(1));

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithBigDecimalLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessThan("products.nickNames.justBigDecimal", new BigDecimal(2));

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessThan("products.nickNames.justBigDecimal", new BigDecimal(2));

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithBigDecimalLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessOrEqualTo("products.nickNames.justBigDecimal", new BigDecimal(2));

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessOrEqualTo("products.nickNames.justBigDecimal", new BigDecimal(2));

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDateGreaterThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date justDate = formatter.parse("2/2/2002");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justDate", justDate);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterThan("products.nickNames.justDate", justDate);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterThan("products.nickNames.justDate", justDate);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDateGreaterOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date justDate = formatter.parse("2/2/2002");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justDate", justDate);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterOrEqualTo("products.nickNames.justDate", justDate);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterOrEqualTo("products.nickNames.justDate", justDate);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDateLessThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date justDate = formatter.parse("2/2/2002");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justDate", justDate);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessThan("products.nickNames.justDate", justDate);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessThan("products.nickNames.justDate", justDate);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDateLessOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date justDate = formatter.parse("2/2/2002");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justDate", justDate);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessOrEqualTo("products.nickNames.justDate", justDate);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessOrEqualTo("products.nickNames.justDate", justDate);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithCalendarGreaterThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("2/2/2002");
        Calendar justCalendar = Calendar.getInstance();
        justCalendar.setTime(date);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justCalendar", justCalendar);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterThan("products.nickNames.justCalendar", justCalendar);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterThan("products.nickNames.justCalendar", justCalendar);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }


    @Test
    public void isMultipleJoinWithCalendarGreaterOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("2/2/2002");
        Calendar justCalendar = Calendar.getInstance();
        justCalendar.setTime(date);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justCalendar", justCalendar);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterOrEqualTo("products.nickNames.justCalendar", justCalendar);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterOrEqualTo("products.nickNames.justCalendar", justCalendar);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithCalendarLessThanWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("2/2/2002");
        Calendar justCalendar = Calendar.getInstance();
        justCalendar.setTime(date);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justCalendar", justCalendar);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessThan("products.nickNames.justCalendar", justCalendar);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessThan("products.nickNames.justCalendar", justCalendar);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithCalendarLessOrEqualToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("2/2/2002");
        Calendar justCalendar = Calendar.getInstance();
        justCalendar.setTime(date);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justCalendar", justCalendar);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessOrEqualTo("products.nickNames.justCalendar", justCalendar);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessOrEqualTo("products.nickNames.justCalendar", justCalendar);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringGreaterThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterThan("products.nickNames.name", CodeGenerator.NICKNAME_B_NAME);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterThan("products.nickNames.name", CodeGenerator.NICKNAME_B_NAME);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringGreaterOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andGreaterOrEqualTo("products.nickNames.name", CodeGenerator.NICKNAME_B_NAME);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andGreaterOrEqualTo("products.nickNames.name", CodeGenerator.NICKNAME_B_NAME);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringLessThanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessThan("products.nickNames.name", CodeGenerator.NICKNAME_B_NAME);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessThan("products.nickNames.name", CodeGenerator.NICKNAME_B_NAME);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringLessOrEqualToWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andLessOrEqualTo("products.nickNames.name", CodeGenerator.NICKNAME_B_NAME);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andLessOrEqualTo("products.nickNames.name", CodeGenerator.NICKNAME_B_NAME);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }


    @Test
    public void isMultipleJoinWithEqualsBooleanWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andEquals("products.nickNames.justBoolean", true);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andEquals("products.nickNames.justBoolean", true);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithIntegerBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andBetween("products.nickNames.id", 1, 2);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andBetween("products.nickNames.id", 1, 2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithLongBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andBetween("products.nickNames.justLong", 1, 2);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andBetween("products.nickNames.justLong", 1, 2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDoubleBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andBetween("products.nickNames.justDouble", 1d, 2d);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andBetween("products.nickNames.justDouble", 1d, 2d);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithFloatBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andBetween("products.nickNames.justFloat", 1f, 2f);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andBetween("products.nickNames.justFloat", 1f, 2f);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithBigDecimalBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andBetween("products.nickNames.justBigDecimal", new BigDecimal(1), new BigDecimal(2));

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andBetween("products.nickNames.justBigDecimal", new BigDecimal(1), new BigDecimal(2));

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringBetweenWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andBetween("products.nickNames.name", CodeGenerator.NICKNAME_A_NAME, CodeGenerator.NICKNAME_B_NAME);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andBetween("products.nickNames.name", CodeGenerator.NICKNAME_A_NAME, CodeGenerator.NICKNAME_B_NAME);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }


    @Test
    public void isMultipleJoinWithCalendarBetweenWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar justCalendar = Calendar.getInstance();
        justCalendar.setTime(date);

        Date date2 = formatter.parse("2/2/2002");
        Calendar justCalendar2 = Calendar.getInstance();
        justCalendar2.setTime(date2);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justCalendarA", justCalendar);
        parameters.put("justCalendarB", justCalendar2);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andBetween("products.nickNames.justCalendar", justCalendar, justCalendar2);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andBetween("products.nickNames.justCalendar", justCalendar, justCalendar2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithDateBetweenToWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date justDate = formatter.parse("1/1/2001");
        Date justDate2 = formatter.parse("2/2/2002");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justDateA", justDate);
        parameters.put("justDateB", justDate2);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andBetween("products.nickNames.justDate", justDate, justDate2);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andBetween("products.nickNames.justDate", justDate, justDate2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithIsNullAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andIsNull("products.nickNames.justString");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andIsNull("products.nickNames.justString");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithIsNotNullAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andIsNotNull("products.nickNames.justString");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andIsNotNull("products.nickNames.justString");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithListIsEmptyAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andCollectionIsEmpty("products.nickNames.justList");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andCollectionIsEmpty("products.nickNames.justList");

        List<Manufacturer> result = easyCriteria.getResultList();

        // bug when we do is empty with sjoin
        if (!isEclipseLink()) {
            assertEquals(easyViewCTOList.size(), result.size());
            assertTrue(easyViewCTOList.containsAll(result));
        }
    }

    @Test
    public void isMultipleJoinWithListIsNotEmptyAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andCollectionIsNotEmpty("products.nickNames.justList");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andCollectionIsNotEmpty("products.nickNames.justList");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithSetIsEmptyAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andCollectionIsEmpty("products.nickNames.justSet");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andCollectionIsEmpty("products.nickNames.justSet");

        List<Manufacturer> result = easyCriteria.getResultList();

        // bug when we do is empty with join
        if (!isEclipseLink()) {
            assertEquals(easyViewCTOList.size(), result.size());
            assertTrue(easyViewCTOList.containsAll(result));
        }
    }

    @Test
    public void isMultipleJoinWithSetIsNotEmptyAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andCollectionIsNotEmpty("products.nickNames.justSet");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andCollectionIsNotEmpty("products.nickNames.justSet");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithCollectionIsEmptyAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andCollectionIsEmpty("products.nickNames.justCollection");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andCollectionIsEmpty("products.nickNames.justCollection");

        List<Manufacturer> result = easyCriteria.getResultList();

        // bug when we do is empty with join
        if (!isEclipseLink()) {
            assertEquals(easyViewCTOList.size(), result.size());
            assertTrue(easyViewCTOList.containsAll(result));
        }
    }

    @Test
    public void isMultipleJoinWithCollectionIsNotEmptyAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andCollectionIsNotEmpty("products.nickNames.justCollection");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andCollectionIsNotEmpty("products.nickNames.justCollection");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringLikeAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andStringLike("products.nickNames.name", "% B");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andStringLike("products.nickNames.name", "% B");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringNotLikeAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andStringNotLike("products.nickNames.name", "% B");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andStringNotLike("products.nickNames.name", "% B");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringLikeLowerCaseAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andStringLike(true, "products.nickNames.name", "% B".toLowerCase());

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andStringLike(true, "products.nickNames.name", "% B".toLowerCase());

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringNotLikeLowerCaseAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andStringNotLike(true, "products.nickNames.name", "% B".toLowerCase());

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andStringNotLike(true, "products.nickNames.name", "% B".toLowerCase());

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }


    @Test
    public void isMultipleJoinWithStringInAttributeWorking() {
        List<String> names = new ArrayList<String>();
        names.add("NickName A");
        names.add("NickName B");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andStringIn("products.nickNames.name", names);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andStringIn("products.nickNames.name", names);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringNotInAttributeWorking() {
        List<String> names = new ArrayList<String>();
        names.add("NickName A");
        names.add("NickName B");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andStringNotIn("products.nickNames.name", names);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andStringNotIn("products.nickNames.name", names);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }


    @Test
    public void isMultipleJoinWithStringInLowerCaseAttributeWorking() {
        List<String> names = new ArrayList<String>();
        names.add("NickName A".toLowerCase());
        names.add("NickName B".toLowerCase());

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andStringIn(true, "products.nickNames.name", names);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andStringIn(true, "products.nickNames.name", names);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithStringNotInLowerCaseAttributeWorking() {
        List<String> names = new ArrayList<String>();
        names.add("NickName A");
        names.add("NickName B");

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.andStringNotIn(true, "products.nickNames.name", names);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.andStringNotIn(true, "products.nickNames.name", names);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithCollectionTestIsEmptyAttributeWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("nickNames.justCollection");
        easyCTO.andCollectionIsEmpty("nickNames.justCollection.autoRelationship");

        EasyCriteria<Product> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Product.class, easyCTO);
        List<Product> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Product> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Product.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("nickNames.justCollection");
        easyCriteria.andCollectionIsEmpty("nickNames.justCollection.autoRelationship");

        List<Product> result = easyCriteria.getResultList();

        // bug when we do is empty with join
        if (!isEclipseLink()) {
            assertEquals(easyViewCTOList.size(), result.size());
            assertTrue(easyViewCTOList.containsAll(result));
        }
    }

    @Test
    public void isMultipleJoinWithOrIntegerWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.id", 1, 2);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.id", 1, 2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrLongWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.justLong", 1L, 2L);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.justLong", 1L, 2L);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrDoubleWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.justDouble", 1d, 2d);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.justDouble", 1d, 2d);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrFloatWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.justFloat", 1f, 2f);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.justFloat", 1f, 2f);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrBigDecimalWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.justBigDecimal", new BigDecimal(1), new BigDecimal(2));

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.justBigDecimal", new BigDecimal(1), new BigDecimal(2));

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrStringWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.name", "NickName A", "NickName B");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.name", "NickName A", "NickName B");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }


    @Test
    public void isMultipleJoinWithOrStringLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals(true, "products.nickNames.name", "NickName A".toLowerCase(), "NickName B".toLowerCase());

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals(true, "products.nickNames.name", "NickName A".toLowerCase(), "NickName B".toLowerCase());

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrDateWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date justDate = formatter.parse("1/1/2001");
        Date justDate2 = formatter.parse("2/2/2002");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justDateA", justDate);
        parameters.put("justDateB", justDate2);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.justDate", justDate, justDate2);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.justDate", justDate, justDate2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrCalendarWorking() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar justCalendar = Calendar.getInstance();
        justCalendar.setTime(date);

        Date date2 = formatter.parse("2/2/2002");
        Calendar justCalendar2 = Calendar.getInstance();
        justCalendar2.setTime(date2);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justCalendarA", justCalendar);
        parameters.put("justCalendarB", justCalendar2);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.justCalendar", justCalendar, justCalendar2);

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.justCalendar", justCalendar, justCalendar2);

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrWithAndWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test
    public void isMultipleJoinWithOrWithAndLowerCaseWorking() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(true, 1, "products.nickNames.name", "NickName A".toLowerCase())
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(true, 2, "products.nickNames.name", "NickName B".toLowerCase());

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);
        List<Manufacturer> easyViewCTOList = easyViewCTO.getResultList();

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(true, 1, "products.nickNames.name", "NickName A".toLowerCase())
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(true, 2, "products.nickNames.name", "NickName B".toLowerCase());

        List<Manufacturer> result = easyCriteria.getResultList();

        assertEquals(easyViewCTOList.size(), result.size());
        assertTrue(easyViewCTOList.containsAll(result));
    }

    @Test(expected = IllegalStateException.class)
    public void isCountThrowingException() {
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.count();
    }

    @Test
    public void isAbleToDoTheSameQuerySeveralTimes(){
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");

        assertTrue(easyViewCTO.getResultList().size() > 0);
        assertTrue(easyCriteria.getResultList().size() > 0);

        assertEquals(easyViewCTO.getResultList().size(), easyCriteria.getResultList().size());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
    }

    @Test
    public void isAbleToDoTheSameCountSeveralTimes(){
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");

        assertTrue(easyViewCTO.getResultList().size() > 0);
        assertTrue(easyCriteria.getResultList().size() > 0);

        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertEquals(easyViewCTO.count(), easyCriteria.count());
    }

    @Test
    public void isAbleToDoTheSameQueryAndCountSeveralTimes(){
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.setDistinctTrue();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");

        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.setDistinctTrue();
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");

        assertTrue(easyViewCTO.getResultList().size() > 0);
        assertTrue(easyCriteria.getResultList().size() > 0);

        assertEquals(easyViewCTO.getResultList().size(), easyCriteria.getResultList().size());

        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertEquals(easyViewCTO.count(), easyCriteria.count());
        assertTrue(easyViewCTO.getResultList().containsAll(easyCriteria.getResultList()));
        assertEquals(easyViewCTO.count(), easyCriteria.count());
    }

    @Test
    public void isOrderByWithMultipleJoinWorking01(){
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("dogs");
        easyCTO.orderByAsc("dogs.name");
        EasyCriteria<Person> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class, easyCTO);

        EasyCriteria<Person> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Person.class);
        easyCriteria.innerJoin("dogs");
        easyCriteria.orderByAsc("dogs.name");

        List<Person> result = easyCriteria.getResultList();

        List<Person> resultList = easyViewCTO.getResultList();
        assertEquals(resultList.size(), result.size());

        for (int i = 0; i < resultList.size(); i++) {
            assertEquals(resultList.get(i), result.get(i));
        }
    }

    @Test
    public void isOrderByWithMultipleJoinWorking02(){
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");
        easyCTO.orderByDesc("products.nickNames.name");
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(1, "products.nickNames.name", "NickName A")
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(2, "products.nickNames.name", "NickName B");
        easyCriteria.orderByDesc("products.nickNames.name");

        List<Manufacturer> result = easyCriteria.getResultList();

        List resultList = easyViewCTO.getResultList();
        assertEquals(resultList.size(), result.size());

        for (int i = 0; i < resultList.size(); i++) {
            assertEquals(resultList.get(i), result.get(i));
        }
    }

    @Test
    public void isOrderByWithMultipleJoinWorking03(){
        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(true, 1, "products.nickNames.name", "NickName A".toLowerCase())
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(true, 2, "products.nickNames.name", "NickName B".toLowerCase());
        easyCTO.orderByDesc("products.nickNames.name");
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.addAndSeparatedByOr(1, "products.nickNames.id", 1)
                .addAndSeparatedByOr(true, 1, "products.nickNames.name", "NickName A".toLowerCase())
                .addAndSeparatedByOr(2, "products.nickNames.id", 2)
                .addAndSeparatedByOr(true, 2, "products.nickNames.name", "NickName B".toLowerCase());
        easyCriteria.orderByDesc("products.nickNames.name");

        List<Manufacturer> result = easyCriteria.getResultList();

        List resultList = easyViewCTO.getResultList();
        assertEquals(resultList.size(), result.size());

        for (int i = 0; i < resultList.size(); i++) {
            assertEquals(resultList.get(i), result.get(i));
        }
    }

    @Test
    public void isOrderByWithMultipleJoinWorking04() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("1/1/2001");
        Calendar justCalendar = Calendar.getInstance();
        justCalendar.setTime(date);

        Date date2 = formatter.parse("2/2/2002");
        Calendar justCalendar2 = Calendar.getInstance();
        justCalendar2.setTime(date2);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("justCalendarA", justCalendar);
        parameters.put("justCalendarB", justCalendar2);

        EasyCriteria easyCTO = EasyCriteriaFactory.createEasyCTO();
        easyCTO.innerJoin("products.nickNames");
        easyCTO.orEquals("products.nickNames.justCalendar", justCalendar, justCalendar2);
        easyCTO.orderByDesc("products.nickNames.name");
        EasyCriteria<Manufacturer> easyViewCTO = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class, easyCTO);

        EasyCriteria<Manufacturer> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Manufacturer.class);
        easyCriteria.innerJoin("products.nickNames");
        easyCriteria.orEquals("products.nickNames.justCalendar", justCalendar, justCalendar2);
        easyCriteria.orderByDesc("products.nickNames.name");

        List<Manufacturer> result = easyCriteria.getResultList();

        List resultList = easyViewCTO.getResultList();
        assertEquals(resultList.size(), result.size());

        for (int i = 0; i < resultList.size(); i++) {
            assertEquals(resultList.get(i), result.get(i));
        }
    }
}