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
package com.uaihebert.model;


import com.uaihebert.util.ReflectionUtil;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@SuppressWarnings("unchecked")
public class BasicQueryElements<T> {
    private static final String HIBERNATE_BUG_MESSAGE_1022938 = " \n There is a bug opened in the Hibernate Jira. Give a vote to the bug issue, so it will be resolved faster: https://hibernate.onjira.com/browse/HHH-7985 ";
    private static final String OPENJPA_BUG_MESSAGE_2333 = " \n There is a bug opened in the OpenJPA Jira. Give a vote to the bug issue, so it will be resolved faster: https://issues.apache.org/jira/browse/OPENJPA-2333";

    private EasyCTOImp easyCTO;
    private final EasyCriteriaBuilder<T> easyCriteriaBuilder;
    private final List<Order> orders = new ArrayList<Order>();
    private final CriteriaGenerator<T> criteriaGenerator;

    private static final Logger LOG = Logger.getLogger("EasyCriteria");

    public BasicQueryElements(EasyCriteriaBuilder<T> easyCriteriaBuilder, EasyCTOImp easyCTO) {
        super();
        this.easyCriteriaBuilder = easyCriteriaBuilder;
        this.easyCTO = easyCTO;
        this.criteriaGenerator = new CriteriaGenerator<T>(easyCriteriaBuilder);
    }

    
    public EasyCriteriaBuilder<T> getEasyCriteriaBuilder() {
		return easyCriteriaBuilder;
	}


	public TypedQuery<T> getTypedQuery() {
        setUpOrderByIfNeeded();

        return easyCriteriaBuilder.createMainQuery();
    }

    public TypedQuery<Long> getCountTypedQuery(){
        return easyCriteriaBuilder.createCountQuery();
    }

    private void setUpOrderByIfNeeded() {
        if (orders.isEmpty()) {
            return;
        }

        easyCriteriaBuilder.mainQueryOrderBy(orders);
    }

    private boolean isOpenJPA() {
        return easyCriteriaBuilder.isOpenJPA();
    }

    private boolean isHibernate() {
        return easyCriteriaBuilder.isHibernate();
    }

    public EasyCTOImp getEasyCTO() {
        return easyCTO;
    }

    private void addAndPredicate(Predicate andPredicate, boolean pathForCount) {
        easyCriteriaBuilder.addAndPredicate(andPredicate, pathForCount);
    }

    private void addOrPredicate(Predicate predicate, boolean pathForCount) {
        easyCriteriaBuilder.addOrPredicate(predicate, pathForCount);
    }

    private void addOrPredicate(List<Predicate> predicates, boolean pathForCount) {
        addOrPredicate(1, predicates, pathForCount);
    }

    private void addOrPredicate(int index, List<Predicate> predicates, boolean pathForCount) {
        for (Predicate predicate : predicates) {
            easyCriteriaBuilder.addOrPredicate(index, predicate, pathForCount);
        }
    }

    private void addAndSeparatedByOr(int index, Predicate predicate, boolean pathForCount) {
        if (isHibernate()) {
            String errorMessage = "This method is not implemented correctly on Hibernate yet (use Long instead of long). =/" + HIBERNATE_BUG_MESSAGE_1022938;
            LOG.severe(errorMessage);
        }

        easyCriteriaBuilder.addAndSeparatedByOr(index, predicate, pathForCount);
    }

    public void andEquals(String attributeName, Object value, boolean toLowerCase) {
        try {
            andEquals(attributeName, value, toLowerCase, true);
            andEquals(attributeName, value, toLowerCase, false);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("We could not find the parameter: " + attributeName + " in the given class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName(), e);
        }
    }

    private void andEquals(String attributeName, Object value, boolean toLowerCase, boolean pathToCount){
        addAndPredicate(createAndCondition(attributeName, value, toLowerCase, pathToCount), pathToCount);
    }

    private Predicate createAndNotCondition(String attributeName, boolean toLowerCase, Object value, boolean pathForCount) {
        return criteriaGenerator.createAndNotCondition(attributeName, value, toLowerCase, EasyConditionType.EQ, pathForCount);
    }

    private Predicate createAndCondition(String attributeName, Object value, boolean toLowerCase, boolean pathForCount) {
        return criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.EQ, pathForCount);
    }

    public void addAndSeparatedByOr(int index, String attributeName, Object value, boolean toLowerCase) {
        addAndSeparatedByOr(index, attributeName, value, toLowerCase, true);
        addAndSeparatedByOr(index, attributeName, value, toLowerCase, false);
    }

    private void addAndSeparatedByOr(int index, String attributeName, Object value, boolean toLowerCase, boolean pathToCount) {
        addAndSeparatedByOr(index, getEqualPredicateConverted(attributeName, value, toLowerCase, pathToCount), pathToCount);
    }

    public void orEquals(boolean toLowerCase, String attributeName, Object... values) {
        if (isHibernate()) {
            for(Object value : values){
                //if(value instanceof Long){
              if(value.getClass().equals(long.class)){
                    String errorMessage = "This method is not implemented correctly on Hibernate yet (use Long instead of long). =/" + HIBERNATE_BUG_MESSAGE_1022938;
                    LOG.severe(errorMessage);
                    break;
                }
            }
        }

        orEquals(true, toLowerCase, attributeName, values);
        orEquals(false, toLowerCase, attributeName, values);
    }

    private void orEquals(boolean pathToCount, boolean toLowerCase, String attributeName, Object... values) {
        addOrPredicate(extractOrPredicates(attributeName, values, toLowerCase, pathToCount), pathToCount);
    }

    public void orEquals(int index, boolean toLowerCase, String attributeName, Object... values) {
        if (isHibernate()) {
            String errorMessage = "This method is not implemented correctly on Hibernate yet (use Long instead of long). =/" + HIBERNATE_BUG_MESSAGE_1022938;
            LOG.severe(errorMessage);
        }

        addOrPredicate(index, extractOrPredicates(attributeName, values, toLowerCase, true), true);
        addOrPredicate(index, extractOrPredicates(attributeName, values, toLowerCase, false), false);
    }

    private List<Predicate> extractOrPredicates(String attributeName, Object[] values, boolean toLowerCase, boolean pathToCount) {
        List<Predicate> orPredicates = new ArrayList<Predicate>();

        if(values!= null) {
          if(values[0].getClass().isArray()) {
            
            values = (Object[]) values[0];
          
          } else if(values[0] instanceof Collection){
            
            values = ((Collection) values[0]).toArray();
            
          }
        }
        
        for (Object value : values) {
            orPredicates.add(getEqualPredicateConverted(attributeName, value, toLowerCase, pathToCount));
        }

        return orPredicates;
    }

    private Predicate getEqualPredicateConverted(String attributeName, Object value, boolean toLowerCase, boolean pathToCount) {
        // problem with OpenJPA =/
        if (ReflectionUtil.isInteger(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            Integer valueAsInteger = Integer.parseInt(value.toString());
            return createAndCondition(attributeName, valueAsInteger, toLowerCase, pathToCount);
        }

        return createAndCondition(attributeName, value, toLowerCase, pathToCount);
    }

    private Predicate[] extractNotPredicates(boolean toLowerCase, String attributeName, Object[] values, boolean pathToCount) {
        Predicate[] orPredicates = new Predicate[values.length];
        
        if(values!= null) {
          if(values[0].getClass().isArray()) {
            
            values = (Object[]) values[0];
          
          } else if(values[0] instanceof Collection){
            
            values = ((Collection) values[0]).toArray();
            
          }
        }
        
        for (int i = 0; i < values.length; i++) {
            orPredicates[i] = createAndNotCondition(attributeName, toLowerCase, values[i], pathToCount);
        }

        return orPredicates;
    }

    private void andNotEquals(String attributeName, boolean toLowerCase, Object value, boolean pathToCount) {
        addAndPredicate(createAndNotCondition(attributeName, toLowerCase, value, pathToCount), pathToCount);
    }

    public void andNotEquals(String attributeName, boolean toLowerCase, Object value) {
        try {
            andNotEquals(attributeName, toLowerCase, value, true);
            andNotEquals(attributeName, toLowerCase, value, false);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("We could not find the parameter: " + attributeName + " in the given class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName());
        }
    }

    private void orNotEquals(boolean toLowerCase, boolean pathToCount, String attributeName, Object... values) {
        Predicate[] orPredicates = extractNotPredicates(toLowerCase, attributeName, values, pathToCount);

        addOrPredicate(criteriaGenerator.or(orPredicates, pathToCount), pathToCount);
    }

    public void orNotEquals(boolean toLowerCase, String attributeName, Object... values) {
        orNotEquals(toLowerCase, false, attributeName, values);
        orNotEquals(toLowerCase, true, attributeName, values);
    }

    public void andGreaterThan(String attributeName, Object value, boolean toLowerCase) {
        andGreaterThan(attributeName, value, toLowerCase, false);
        andGreaterThan(attributeName, value, toLowerCase, true);
    }

    private void andGreaterThan(String attributeName, Object value, boolean toLowerCase, boolean pathToCount) {
        if(toLowerCase && !(value instanceof String)){
            throw new IllegalArgumentException("LowerCase can only be used with String");
        }

        Predicate condition = null;

        if (ReflectionUtil.isNumber(easyCriteriaBuilder.getEntityClass(), attributeName)){
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.GT, pathToCount);
        }

        if (ReflectionUtil.isString(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.STRING_GREATER_THAN, pathToCount);
        }

        if (ReflectionUtil.isDate(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.DATE_GREATER_THAN, pathToCount);
        }

        if (ReflectionUtil.isCalendar(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.CALENDAR_GREATER_THAN, pathToCount);
        }

        if(condition != null){
            addAndPredicate(condition, pathToCount);
            return;
        }

        throw new IllegalArgumentException("The attributeName: " + attributeName + " was not in the allowed types (int, double, float, long, calendar, date, big decimal). We looked inside the class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName());
    }

    public void andGreaterOrEqualTo(String attributeName, Object value, boolean toLowerCase) {
        andGreaterOrEqualTo(attributeName, value, toLowerCase, true);
        andGreaterOrEqualTo(attributeName, value, toLowerCase, false);
    }

    private void andGreaterOrEqualTo(String attributeName, Object value, boolean toLowerCase, boolean pathToCount) {
        if(toLowerCase && !(value instanceof String)){
            throw new IllegalArgumentException("LowerCase can only be used with String");
        }

        Predicate condition = null;

        if (ReflectionUtil.isNumber(easyCriteriaBuilder.getEntityClass(), attributeName)){
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.GE, pathToCount);
        }

        if (ReflectionUtil.isString(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.STRING_GREATER_OR_EQUAL_TO, pathToCount);
        }

        if (ReflectionUtil.isDate(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.DATE_GREATER_OR_EQUAL_TO, pathToCount);
        }

        if (ReflectionUtil.isCalendar(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.CALENDAR_GREATER_OR_EQUAL_TO, pathToCount);
        }

        if(condition != null){
            addAndPredicate(condition, pathToCount);
            return;
        }

        throw new IllegalArgumentException("The attributeName: " + attributeName + " was not in the allowed types (int, double, float, long, calendar, date, big decimal). We looked inside the class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName());
    }

    public void andLessThan(String attributeName, Object value, boolean toLowerCase) {
        andLessThan(attributeName, value, toLowerCase, true);
        andLessThan(attributeName, value, toLowerCase, false);
    }

    private void andLessThan(String attributeName, Object value, boolean toLowerCase, boolean pathToCount) {
        if(toLowerCase && !(value instanceof String)){
            throw new IllegalArgumentException("LowerCase can only be used with String");
        }

        Predicate condition = null;

        if (ReflectionUtil.isNumber(easyCriteriaBuilder.getEntityClass(), attributeName)){
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.LT, pathToCount);
        }

        if (ReflectionUtil.isString(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.STRING_LESS_THAN, pathToCount);
        }

        if (ReflectionUtil.isDate(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.DATE_LESS_THAN, pathToCount);
        }

        if (ReflectionUtil.isCalendar(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.CALENDAR_LESS_THAN, pathToCount);
        }

        if(condition != null){
            addAndPredicate(condition, pathToCount);
            return;
        }

        throw new IllegalArgumentException("The attributeName: " + attributeName + " was not in the allowed types (int, double, float, long, calendar, date, big decimal). We looked inside the class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName());
    }

    public void andLessOrEqualTo(String attributeName, Object value, boolean toLowerCase) {
        andLessOrEqualTo(attributeName, value, toLowerCase, true);
        andLessOrEqualTo(attributeName, value, toLowerCase, false);
    }

    private void andLessOrEqualTo(String attributeName, Object value, boolean toLowerCase, boolean pathToCount) {
        if(toLowerCase && !(value instanceof String)){
            throw new IllegalArgumentException("LowerCase can only be used with String");
        }

        Predicate condition = null;

        if (ReflectionUtil.isNumber(easyCriteriaBuilder.getEntityClass(), attributeName)){
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.LE, pathToCount);
        }

        if (ReflectionUtil.isString(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.STRING_LESS_OR_EQUAL_TO, pathToCount);
        }

        if (ReflectionUtil.isDate(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.DATE_LESS_OR_EQUAL_TO, pathToCount);
        }

        if (ReflectionUtil.isCalendar(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, EasyConditionType.CALENDAR_LESS_OR_EQUAL_TO, pathToCount);
        }

        if(condition != null){
            addAndPredicate(condition, pathToCount);
            return;
        }

        throw new IllegalArgumentException("The attributeName: " + attributeName + " was not in the allowed types (int, double, float, long, calendar, date, big decimal). We looked inside the class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName());
    }

    public void setDistinctTrue() {
        easyCriteriaBuilder.setDistinctTrue();
    }

    public void innerJoin(String joinName) {
        if (isOpenJPA()) {
            String errorMessage = "This method is not implemented correctly on OpenJPA yet. =/" + OPENJPA_BUG_MESSAGE_2333;
            LOG.severe(errorMessage);
        }

        createJoin(joinName, JoinType.INNER, false, false);
        createJoin(joinName, JoinType.INNER, false, true);
    }

    private void createJoin(String joinName, JoinType joinType, boolean toFetch, boolean pathToCount) {
        try {
            criteriaGenerator.createJoin(joinName, joinType, toFetch, pathToCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("We could not find the join: " + joinName + " in the given class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName());
        }
    }

    public void leftJoin(String joinName) {
        if (isOpenJPA()) {
            String errorMessage = "This method is not implemented correctly on OpenJPA yet. =/" + OPENJPA_BUG_MESSAGE_2333;
            LOG.severe(errorMessage);
        }

        createJoin(joinName, JoinType.LEFT, false, false);
        createJoin(joinName, JoinType.LEFT, false, true);
    }

    public void innerJoinFetch(String joinName) {
        if (isOpenJPA()) {
            String errorMessage = "This method is not implemented correctly on OpenJPA yet. =/" + OPENJPA_BUG_MESSAGE_2333;
            LOG.severe(errorMessage);
        }

        createJoin(joinName, JoinType.INNER, true, true);
        createJoin(joinName, JoinType.INNER, true, false);
    }

    public void leftJoinFetch(String joinName) {
        if (isOpenJPA()) {
            String errorMessage = "This method is not implemented correctly on OpenJPA yet. =/" + OPENJPA_BUG_MESSAGE_2333;
            LOG.severe(errorMessage);
        }

        createJoin(joinName, JoinType.LEFT, true, true);
        createJoin(joinName, JoinType.LEFT, true, false);
    }

    public void andBetween(String attributeName, Object valueA, Object valueB, boolean toLowerCase){
        andBetween(attributeName, valueA, valueB, toLowerCase, false);
        andBetween(attributeName, valueA, valueB, toLowerCase, true);
    }

    private void andBetween(String attributeName, Object valueA, Object valueB, boolean toLowerCase, boolean pathToCount) {
        if(toLowerCase){
            if(!(valueA instanceof String) || !(valueB instanceof String)){
                throw new IllegalArgumentException("LowerCase can only be used with String");
            }
        }

        Object[] values = {valueA, valueB};

        Predicate condition = null;

        if (ReflectionUtil.isNumber(easyCriteriaBuilder.getEntityClass(), attributeName)){
            condition = criteriaGenerator.createAndCondition(attributeName, values, toLowerCase, EasyConditionType.BETWEEN, pathToCount);
        }

        if (ReflectionUtil.isString(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, values, toLowerCase, EasyConditionType.STRING_BETWEEN, pathToCount);
        }

        if (ReflectionUtil.isDate(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, values, toLowerCase, EasyConditionType.DATE_BETWEEN, pathToCount);
        }

        if (ReflectionUtil.isCalendar(easyCriteriaBuilder.getEntityClass(), attributeName)) {
            condition = criteriaGenerator.createAndCondition(attributeName, values, toLowerCase, EasyConditionType.CALENDAR_BETWEEN, pathToCount);
        }

        if(condition != null){
            addAndPredicate(condition, pathToCount);
            return;
        }

        throw new IllegalArgumentException("The attributeName: " + attributeName + " was not in the allowed types (int, double, float, long, calendar, date, big decimal). We looked inside the class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName());
    }

    public void andIsNull(String attributeName, boolean isNull) {
        andIsNull(attributeName, isNull, true);
        andIsNull(attributeName, isNull, false);
    }

    private void andIsNull(String attributeName, boolean isNull, boolean pathToCount) {
        EasyConditionType type = isNull ? EasyConditionType.IS_NULL : EasyConditionType.IS_NOT_NULL;
        addAndPredicate(criteriaGenerator.createAndCondition(attributeName, null, false, type, pathToCount), pathToCount);
    }
    public void andCollectionIsEmpty(String collectionName, boolean isEmpty) {
        andCollectionIsEmpty(collectionName, isEmpty, true);
        andCollectionIsEmpty(collectionName, isEmpty, false);
    }

    private void andCollectionIsEmpty(String collectionName, boolean isEmpty, boolean pathToCount) {
        Predicate condition = null;

        EasyConditionType type;

        if (ReflectionUtil.isList(easyCriteriaBuilder.getEntityClass(), collectionName)) {
            type = isEmpty ? EasyConditionType.LIST_IS_EMPTY : EasyConditionType.LIST_IS_NOT_EMPTY;

            condition = criteriaGenerator.createAndCondition(collectionName, null, false, type, pathToCount);
        }

        if (ReflectionUtil.isSet(easyCriteriaBuilder.getEntityClass(), collectionName)) {
            type = isEmpty ? EasyConditionType.SET_IS_EMPTY : EasyConditionType.SET_IS_NOT_EMPTY;

            condition = criteriaGenerator.createAndCondition(collectionName, null, false, type, pathToCount);
        }

        if (ReflectionUtil.isCollection(easyCriteriaBuilder.getEntityClass(), collectionName)) {
            type = isEmpty ? EasyConditionType.COLLECTION_IS_EMPTY : EasyConditionType.COLLECTION_IS_NOT_EMPTY;

            condition = criteriaGenerator.createAndCondition(collectionName, null, false, type, pathToCount);
        }

        if(condition != null){
            addAndPredicate(condition, pathToCount);
            return;
        }

        throw new IllegalArgumentException("The collection: " + collectionName + " was not in the allowed types (list, collection or set). We looked inside the class: " + easyCriteriaBuilder.getEntityClass().getCanonicalName());
    }

    public void andStringLike(String attributeName, String value, boolean toLowerCase, boolean isLike) {
        andStringLike(attributeName, value, toLowerCase, isLike, false);
        andStringLike(attributeName, value, toLowerCase, isLike, true);
    }

    private void andStringLike(String attributeName, String value, boolean toLowerCase, boolean isLike, boolean pathToCount) {
        EasyConditionType type = isLike ? EasyConditionType.STRING_LIKE : EasyConditionType.STRING_NOT_LIKE;

        addAndPredicate(criteriaGenerator.createAndCondition(attributeName, value, toLowerCase, type, pathToCount), pathToCount);
    }
    public void andStringIn(String attributeName, List<String> values, boolean toLowerCase, boolean isIn) {
        andStringIn(attributeName, values, toLowerCase, isIn, true);
        andStringIn(attributeName, values, toLowerCase, isIn, false);
    }

    private void andStringIn(String attributeName, List<String> values, boolean toLowerCase, boolean isIn, boolean pathToCount) {
        if(isIn){
            addAndPredicate(criteriaGenerator.createAndCondition(attributeName, values, toLowerCase, EasyConditionType.STRING_IN, pathToCount), pathToCount);
        } else{
            addAndPredicate(criteriaGenerator.createAndNotCondition(attributeName, values, toLowerCase, EasyConditionType.STRING_IN, pathToCount), pathToCount);
        }
    }

    public void orderByAsc(String attributeName) {
        orders.add(criteriaGenerator.orderByASC(attributeName));
    }

    public void orderByDesc(String attributeName) {
        orders.add(criteriaGenerator.orderByDESC(attributeName));
    }

    public void andJoinEquals(String joinName, String attributeName, Object value, boolean toLowerCase) {
        String fullPath = joinName + "." + attributeName;
        andEquals(fullPath, value, toLowerCase);
    }

    public void andJoinNotEquals(String joinName, String attributeName, Object value, boolean toLowerCase) {
        String fullPath = joinName + "." + attributeName;
        andNotEquals(fullPath, toLowerCase, value);
    }

    public void andJoinGreaterThan(String joinName, String attributeName, Object value, boolean toLowerCase) {
        String fullPath = joinName + "." + attributeName;
        andGreaterThan(fullPath, value, toLowerCase);
    }

    public void andJoinGreaterOrEqualTo(String joinName, String attributeName, Object value, boolean toLowerCase) {
        String fullPath = joinName + "." + attributeName;
        andGreaterOrEqualTo(fullPath, value, toLowerCase);
    }

    public void andJoinLessThan(String joinName, String attributeName, Object value, boolean toLowerCase) {
        String fullPath = joinName + "." + attributeName;
        andLessThan(fullPath, value, toLowerCase);
    }

    public void andJoinLessOrEqualTo(String joinName, String attributeName, Object value, boolean toLowerCase) {
        String fullPath = joinName + "." + attributeName;
        andLessOrEqualTo(fullPath, value, toLowerCase);
    }

    public void andJoinBetween(String joinName, String attributeName, Object valueA, Object valueB, boolean toLowerCase) {
        String fullPath = joinName + "." + attributeName;
        andBetween(fullPath, valueA, valueB, toLowerCase);
    }

    public void andJoinAttributeIsNull(String joinName, String attributeName) {
        String fullPath = joinName + "." + attributeName;
        andIsNull(fullPath, true);
    }

    public void andJoinAttributeIsNotNull(String joinName, String attributeName) {
        String fullPath = joinName + "." + attributeName;
        andIsNull(fullPath, false);
    }

    public void andJoinCollectionIsEmpty(String joinName, String listName, boolean isEmpty) {
        String fullPath = joinName + "." + listName;
        andCollectionIsEmpty(fullPath, isEmpty);
   }

    public void andJoinStringLike(String joinName, String attributeName, String value, boolean toLowerCase, boolean isLike) {
        String fullPath = joinName + "." + attributeName;
        andStringLike(fullPath, value, toLowerCase, isLike);
    }

    public void andJoinStringIn(String joinName, String attributeName, List<String> values, boolean toLowerCase, boolean isIn) {
        String fullPath = joinName + "." + attributeName;
        andStringIn(fullPath, values, toLowerCase, isIn);
    }

    public void releaseEasyCTO() {
        easyCTO = null;
    }
}