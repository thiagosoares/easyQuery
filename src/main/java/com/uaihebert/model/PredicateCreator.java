package com.uaihebert.model;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.*;

public abstract class PredicateCreator {

    public static Predicate equal(CriteriaBuilder criteriaBuilder, Expression expression, Object value) {
        return criteriaBuilder.equal(expression, value);
    }

    public static Predicate gtCondition(CriteriaBuilder criteriaBuilder, Expression<? extends Number> expression, Object value) {
        return criteriaBuilder.gt(expression, (Number) value);
    }

    public static Predicate stringGreaterThanCondition(CriteriaBuilder criteriaBuilder, Expression<String> expression, String value) {
        return criteriaBuilder.greaterThan(expression, value);
    }

    public static Predicate calendarGreaterThanCondition(CriteriaBuilder criteriaBuilder, Expression<Calendar> expression, Calendar value) {
        return criteriaBuilder.greaterThan(expression, value);
    }

    public static Predicate dateGreaterThanCondition(CriteriaBuilder criteriaBuilder, Expression<Date> expression, Date value) {
        return criteriaBuilder.greaterThan(expression, value);
    }

    public static Predicate geCondition(CriteriaBuilder criteriaBuilder, Expression<? extends Number> expression, Object value) {
        return criteriaBuilder.ge(expression, (Number) value);
    }

    public static Predicate stringGreaterOrEqualToCondition(CriteriaBuilder criteriaBuilder, Expression<String> expression, String value) {
        return criteriaBuilder.greaterThanOrEqualTo(expression, value);
    }

    public static Predicate calendarGreaterOrEqualToCondition(CriteriaBuilder criteriaBuilder, Expression<Calendar> expression, Calendar value) {
        return criteriaBuilder.greaterThanOrEqualTo(expression, value);
    }

    public static Predicate dateGreaterOrEqualToCondition(CriteriaBuilder criteriaBuilder, Expression<Date> expression, Date value) {
        return criteriaBuilder.greaterThanOrEqualTo(expression, value);
    }

    public static Predicate ltCondition(CriteriaBuilder criteriaBuilder, Expression<? extends Number> expression, Object value) {
        return criteriaBuilder.lt(expression, (Number) value);
    }

    public static Predicate stringLessThanCondition(CriteriaBuilder criteriaBuilder, Expression<String> expression, String value) {
        return criteriaBuilder.lessThan(expression, value);
    }

    public static Predicate calendarLessThanCondition(CriteriaBuilder criteriaBuilder, Expression<Calendar> expression, Calendar value) {
        return criteriaBuilder.lessThan(expression, value);
    }

    public static Predicate dateLessThanCondition(CriteriaBuilder criteriaBuilder, Expression<Date> expression, Date value) {
        return criteriaBuilder.lessThan(expression, value);
    }

    public static Predicate leCondition(CriteriaBuilder criteriaBuilder, Expression<? extends Number> expression, Object value) {
        return criteriaBuilder.le(expression, (Number) value);
    }

    public static Predicate stringLessOrEqualToCondition(CriteriaBuilder criteriaBuilder, Expression<String> expression, String value) {
        return criteriaBuilder.lessThanOrEqualTo(expression, value);
    }

    public static Predicate calendarLessOrEqualToCondition(CriteriaBuilder criteriaBuilder, Expression<Calendar> expression, Calendar value) {
        return criteriaBuilder.lessThanOrEqualTo(expression, value);
    }

    public static Predicate dateLessOrEqualToCondition(CriteriaBuilder criteriaBuilder, Expression<Date> expression, Date value) {
        return criteriaBuilder.lessThanOrEqualTo(expression, value);
    }

    public static Predicate between(CriteriaBuilder criteriaBuilder, Expression<? extends Number> expression, Number valueA, Number valueB) {
        Predicate predicateA = geCondition(criteriaBuilder, expression, valueA);
        Predicate predicateB = leCondition(criteriaBuilder, expression, valueB);
        return criteriaBuilder.and(predicateA, predicateB);
    }

    public static Predicate stringBetween(CriteriaBuilder criteriaBuilder, Expression<String> expression, String valueA, String valueB) {
        return criteriaBuilder.between(expression, valueA, valueB);
    }

    public static Predicate calendarBetween(CriteriaBuilder criteriaBuilder, Expression<Calendar> expression, Calendar valueA, Calendar valueB) {
        return criteriaBuilder.between(expression, valueA, valueB);
    }

    public static Predicate dateBetween(CriteriaBuilder criteriaBuilder, Expression<Date> expression, Date valueA, Date valueB) {
        return criteriaBuilder.between(expression, valueA, valueB);
    }

    public static Predicate isNull(CriteriaBuilder criteriaBuilder, Expression expression) {
        return criteriaBuilder.isNull(expression);
    }

    public static Predicate isNotNull(CriteriaBuilder criteriaBuilder, Expression expression) {
        return criteriaBuilder.isNotNull(expression);
    }

    public static Predicate listIsEmpty(CriteriaBuilder criteriaBuilder, Expression expression) {
        return criteriaBuilder.isEmpty(expression.as(List.class));
    }

    public static Predicate listIsNotEmpty(CriteriaBuilder criteriaBuilder, Expression expression) {
        return criteriaBuilder.isNotEmpty(expression.as(List.class));
    }

    public static Predicate setIsEmpty(CriteriaBuilder criteriaBuilder, Expression expression) {
        return criteriaBuilder.isEmpty(expression.as(Set.class));
    }

    public static Predicate setIsNotEmpty(CriteriaBuilder criteriaBuilder, Expression expression) {
        return criteriaBuilder.isNotEmpty(expression.as(Set.class));
    }

    public static Predicate collectionIsEmpty(CriteriaBuilder criteriaBuilder, Expression expression) {
        return criteriaBuilder.isEmpty(expression.as(Collection.class));
    }

    public static Predicate collectionIsNotEmpty(CriteriaBuilder criteriaBuilder, Expression expression) {
        return criteriaBuilder.isNotEmpty(expression.as(Collection.class));
    }

    public static Predicate stringLike(CriteriaBuilder criteriaBuilder, Expression<String> expression, String value) {
        return criteriaBuilder.like(expression, value);
    }

    public static Predicate stringNotLike(CriteriaBuilder criteriaBuilder, Expression<String> expression, String value) {
        return criteriaBuilder.notLike(expression, value);
    }

    public static Predicate stringIn(Expression<String> expression, Object value) {
        List<String> values = (List<String>) value;
        return expression.in(values);
    }
}