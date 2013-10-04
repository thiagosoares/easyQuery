package com.uaihebert.model;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.Calendar;
import java.util.Date;

public enum EasyConditionType {
    EQ,
    NE,
    GT, STRING_GREATER_THAN, CALENDAR_GREATER_THAN, DATE_GREATER_THAN,
    GE, STRING_GREATER_OR_EQUAL_TO, CALENDAR_GREATER_OR_EQUAL_TO, DATE_GREATER_OR_EQUAL_TO,
    LT, STRING_LESS_THAN, CALENDAR_LESS_THAN, DATE_LESS_THAN,
    LE, STRING_LESS_OR_EQUAL_TO, CALENDAR_LESS_OR_EQUAL_TO, DATE_LESS_OR_EQUAL_TO,
    BETWEEN, STRING_BETWEEN, DATE_BETWEEN, CALENDAR_BETWEEN,
    IS_NULL, IS_NOT_NULL,
    LIST_IS_EMPTY, LIST_IS_NOT_EMPTY, SET_IS_EMPTY, SET_IS_NOT_EMPTY, COLLECTION_IS_EMPTY, COLLECTION_IS_NOT_EMPTY,
    STRING_LIKE, STRING_NOT_LIKE,
    STRING_IN;

    public Predicate extractCondition(CriteriaBuilder criteriaBuilder, Expression expression, Object value) {
        if(EQ.equals(this)){
            return PredicateCreator.equal(criteriaBuilder, expression, value);
        }

        if(GT.equals(this)){
            return PredicateCreator.gtCondition(criteriaBuilder, expression, value);
        }

        if(STRING_GREATER_THAN.equals(this)){
            return PredicateCreator.stringGreaterThanCondition(criteriaBuilder, expression, value.toString());
        }

        if(CALENDAR_GREATER_THAN.equals(this)){
            return PredicateCreator.calendarGreaterThanCondition(criteriaBuilder, (Expression<Calendar>) expression, (Calendar) value);
        }

        if(DATE_GREATER_THAN.equals(this)){
            return PredicateCreator.dateGreaterThanCondition(criteriaBuilder, (Expression<Date>) expression, (Date) value);
        }

        if(GE.equals(this)){
            return PredicateCreator.geCondition(criteriaBuilder, expression, value);
        }

        if(STRING_GREATER_OR_EQUAL_TO.equals(this)){
            return PredicateCreator.stringGreaterOrEqualToCondition(criteriaBuilder, expression, value.toString());
        }

        if(CALENDAR_GREATER_OR_EQUAL_TO.equals(this)){
            return PredicateCreator.calendarGreaterOrEqualToCondition(criteriaBuilder, (Expression<Calendar>) expression, (Calendar) value);
        }

        if(DATE_GREATER_OR_EQUAL_TO.equals(this)){
            return PredicateCreator.dateGreaterOrEqualToCondition(criteriaBuilder, (Expression<Date>) expression, (Date) value);
        }

        if(LT.equals(this)){
            return PredicateCreator.ltCondition(criteriaBuilder, expression, value);
        }

        if(STRING_LESS_THAN.equals(this)){
            return PredicateCreator.stringLessThanCondition(criteriaBuilder, expression, value.toString());
        }

        if(CALENDAR_LESS_THAN.equals(this)){
            return PredicateCreator.calendarLessThanCondition(criteriaBuilder, (Expression<Calendar>) expression, (Calendar) value);
        }

        if(DATE_LESS_THAN.equals(this)){
            return PredicateCreator.dateLessThanCondition(criteriaBuilder, (Expression<Date>) expression, (Date) value);
        }

        if(LE.equals(this)){
            return PredicateCreator.leCondition(criteriaBuilder, expression, value);
        }

        if(STRING_LESS_OR_EQUAL_TO.equals(this)){
            return PredicateCreator.stringLessOrEqualToCondition(criteriaBuilder, expression, value.toString());
        }

        if(CALENDAR_LESS_OR_EQUAL_TO.equals(this)){
            return PredicateCreator.calendarLessOrEqualToCondition(criteriaBuilder, (Expression<Calendar>) expression, (Calendar) value);
        }

        if(DATE_LESS_OR_EQUAL_TO.equals(this)){
            return PredicateCreator.dateLessOrEqualToCondition(criteriaBuilder, (Expression<Date>) expression, (Date) value);
        }

        if(BETWEEN.equals(this)){
            Object[] values = (Object[]) value;
            return PredicateCreator.between(criteriaBuilder, expression, (Number) values[0], (Number) values[1]);
        }

        if(STRING_BETWEEN.equals(this)){
            Object[] values = (Object[]) value;
            return PredicateCreator.stringBetween(criteriaBuilder, expression, values[0].toString(), values[1].toString());
        }

        if(CALENDAR_BETWEEN.equals(this)){
            Object[] values = (Object[]) value;
            return PredicateCreator.calendarBetween(criteriaBuilder, (Expression<Calendar>) expression, (Calendar) values[0], (Calendar) values[1]);
        }

        if(DATE_BETWEEN.equals(this)){
            Object[] values = (Object[]) value;
            return PredicateCreator.dateBetween(criteriaBuilder, (Expression<Date>) expression, (Date) values[0], (Date) values[1]);
        }

        if(IS_NULL.equals(this)){
            return PredicateCreator.isNull(criteriaBuilder, expression);
        }

        if(IS_NOT_NULL.equals(this)){
            return PredicateCreator.isNotNull(criteriaBuilder, expression);
        }

        if(LIST_IS_EMPTY.equals(this)){
            return PredicateCreator.listIsEmpty(criteriaBuilder, expression);
        }

        if(LIST_IS_NOT_EMPTY.equals(this)){
            return PredicateCreator.listIsNotEmpty(criteriaBuilder, expression);
        }

        if(SET_IS_EMPTY.equals(this)){
            return PredicateCreator.setIsEmpty(criteriaBuilder, expression);
        }

        if(SET_IS_NOT_EMPTY.equals(this)){
            return PredicateCreator.setIsNotEmpty(criteriaBuilder, expression);
        }

        if(COLLECTION_IS_EMPTY.equals(this)){
            return PredicateCreator.collectionIsEmpty(criteriaBuilder, expression);
        }

        if(COLLECTION_IS_NOT_EMPTY.equals(this)){
            return PredicateCreator.collectionIsNotEmpty(criteriaBuilder, expression);
        }

        if(STRING_LIKE.equals(this)){
            return PredicateCreator.stringLike(criteriaBuilder, expression, value.toString());
        }

        if(STRING_NOT_LIKE.equals(this)){
            return PredicateCreator.stringNotLike(criteriaBuilder, expression, value.toString());
        }

        return PredicateCreator.stringIn(expression, value); // STRING_IN
    }

    public Predicate extractNotCondition(CriteriaBuilder criteriaBuilder, Predicate predicate) {
        return criteriaBuilder.not(predicate);
    }
}
