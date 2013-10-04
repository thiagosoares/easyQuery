package com.uaihebert.model;

import java.util.ArrayList;
import java.util.List;

public class QueryConfigurations {
    private boolean distinctQuery;

    private int firstResult;
    private int maxResults;

    private List<WhereCondition> conditions;

    private List<String> orderByAsc;
    private List<String> orderByDesc;

    private List<String> leftJoins;
    private List<String> andIsNull;
    private List<String> innerJoins;
    private List<String> andIsNotNull;
    private List<String> leftJoinsFetch;
    private List<String> innerJoinsFetch;
    private List<JoinIsNull> joinsAreNull;
    private List<String> collectionIsEmpty;
    private List<JoinBetween> joinsBetween;
    private List<JoinIsEmpty> joinsAreEmpty;
    private List<String> collectionIsNotEmpty;
    private List<EasyAndWithOr> andWithOrs;
    private List<EasyAttribute> easyJoinsAttributes;
    private List<EasyJoinStringIn> joinsStringIn;
    private List<EasyOrEqualsIndex> orEqualsIndex;
    private List<EasyJoinStringLike> joinsStringLike;

    private List<Between> andBetween;

    public List<WhereCondition> getAndGreaterOrEqualTo() {
        List<WhereCondition> result = new ArrayList<WhereCondition>();

        for(WhereCondition condition : getConditions()){
            if(condition.isGreaterOrEqualTo()){
                result.add(condition);
            }
        }

        return result;
    }

    public List<WhereCondition> getAndLessThan() {
        List<WhereCondition> result = new ArrayList<WhereCondition>();

        for(WhereCondition condition : getConditions()){
            if(condition.isLessThan()){
                result.add(condition);
            }
        }

        return result;
    }

    public List<WhereCondition> getAndLessOrEqualTo() {
        List<WhereCondition> result = new ArrayList<WhereCondition>();

        for(WhereCondition condition : getConditions()){
            if(condition.isLessOrEqualTo()){
                result.add(condition);
            }
        }

        return result;
    }

    public List<Between> getAndBetween() {
        if(andBetween == null){
            andBetween = new ArrayList<Between>();
        }

        return andBetween;
    }

    public List<String> getAndIsNull() {
        if(andIsNull == null){
            andIsNull = new ArrayList<String>();
        }

        return andIsNull;
    }

    public List<String> getAndIsNotNull() {
        if(andIsNotNull == null){
            andIsNotNull = new ArrayList<String>();
        }

        return andIsNotNull;
    }

    public List<String> getOrderByAsc() {
        if(orderByAsc == null){
            orderByAsc = new ArrayList<String>();
        }

        return orderByAsc;
    }

    public List<String> getOrderByDesc() {
        if(orderByDesc == null){
            orderByDesc = new ArrayList<String>();
        }

        return orderByDesc;
    }

    public List<String> getCollectionIsEmpty() {
        if(collectionIsEmpty == null){
            collectionIsEmpty = new ArrayList<String>();
        }

        return collectionIsEmpty;
    }

    public List<String> getCollectionIsNotEmpty() {
        if(collectionIsNotEmpty == null){
            collectionIsNotEmpty = new ArrayList<String>();
        }

        return collectionIsNotEmpty;
    }

    public void andBetween(String attributeName, Object valueA, Object valueB){
        Between between = new Between(attributeName, valueA, valueB, false);
        getAndBetween().add(between);
    }

    public void andBetween(boolean toLowerCase, String attributeName, Object valueA, Object valueB){
        Between between = new Between(attributeName, valueA, valueB, toLowerCase);
        getAndBetween().add(between);
    }

    public List<WhereCondition> getConditions() {
        if(conditions == null){
            conditions = new ArrayList<WhereCondition>();
        }

        return conditions;
    }

    public void andGreaterThan(boolean toLowerCase, String attributeName, Object value) {
        getConditions().add(new WhereCondition(value, toLowerCase, attributeName, EasyConditionType.GT));
    }

    public void andGreaterOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
        getConditions().add(new WhereCondition(value, toLowerCase, attributeName, EasyConditionType.GE));
    }

    public void andLessThan(boolean toLowerCase, String attributeName, Object value) {
        getConditions().add(new WhereCondition(value, toLowerCase, attributeName, EasyConditionType.LT));
    }

    public void andLessOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
        getConditions().add(new WhereCondition(value, toLowerCase, attributeName, EasyConditionType.LE));
    }

    public void andIsNull(String attributeName) {
        getAndIsNull().add(attributeName);
    }
    public void andIsNotNull(String attributeName) {
        getAndIsNotNull().add(attributeName);
    }

    public void andCollectionIsEmpty(String collectionName) {
        getCollectionIsEmpty().add(collectionName);
    }

    public void andCollectionIsNotEmpty(String collectionName) {
        getCollectionIsNotEmpty().add(collectionName);
    }

    public void andStringLike(boolean toLowerCase, String attributeName, String value) {
        getJoinsStringLike().add(EasyJoinStringLike.newInstance(null, attributeName, value, true, toLowerCase));
    }

    public void andStringNotLike(boolean toLowerCase, String attributeName, String value) {
        getJoinsStringLike().add(EasyJoinStringLike.newInstance(null, attributeName, value, false, toLowerCase));
    }

    public void andStringIn(boolean toLowerCase, String attributeName, List<String> values) {
        getJoinsStringIn().add(EasyJoinStringIn.newInstance(null, attributeName, values, true, toLowerCase));
    }

    public void andStringNotIn(boolean toLowerCase, String attributeName, List<String> values) {
        getJoinsStringIn().add(EasyJoinStringIn.newInstance(null, attributeName, values, false, toLowerCase));
    }

    public void orderByAsc(String attributeName) {
        getOrderByAsc().add(attributeName);
    }

    public void orderByDesc(String attributeName) {
        getOrderByDesc().add(attributeName);
    }

    public List<String> getInnerJoins() {
        if(innerJoins == null){
            innerJoins = new ArrayList<String>();
        }

        return innerJoins;
    }

    public List<String> getInnerJoinsFetch() {
        if(innerJoinsFetch == null){
            innerJoinsFetch = new ArrayList<String>();
        }

        return innerJoinsFetch;
    }

    public List<String> getLeftJoins() {
        if(leftJoins == null){
            leftJoins = new ArrayList<String>();
        }

        return leftJoins;
    }

    public List<String> getLeftJoinsFetch() {
        if(leftJoinsFetch == null){
            leftJoinsFetch = new ArrayList<String>();
        }

        return leftJoinsFetch;
    }

    public boolean isDistinctQuery() {
        return distinctQuery;
    }

    public void setDistinctTrue() {
        this.distinctQuery = true;
    }

    public List<EasyAttribute> getEasyAttributes() {
        if(easyJoinsAttributes == null){
            easyJoinsAttributes = new ArrayList<EasyAttribute>();
        }

        return easyJoinsAttributes;
    }

    public List<JoinBetween> getJoinsBetween() {
        if(joinsBetween == null){
            joinsBetween = new ArrayList<JoinBetween>();
        }

        return joinsBetween;
    }

    public List<JoinIsNull> getJoinsNull() {
        if(joinsAreNull == null){
            joinsAreNull = new ArrayList<JoinIsNull>();
        }

        return joinsAreNull;
    }

    public List<JoinIsEmpty> getJoinsEmpty() {
        if(joinsAreEmpty == null){
            joinsAreEmpty = new ArrayList<JoinIsEmpty>();
        }

        return joinsAreEmpty;
    }

    public List<EasyJoinStringLike> getJoinsStringLike() {
        if(joinsStringLike == null){
            joinsStringLike = new ArrayList<EasyJoinStringLike>();
        }

        return joinsStringLike;
    }

    public List<EasyJoinStringIn> getJoinsStringIn() {
        if(joinsStringIn == null){
            joinsStringIn = new ArrayList<EasyJoinStringIn>();
        }

        return joinsStringIn;
    }

    public List<EasyAndWithOr> getAndWithOrs() {
        if(andWithOrs == null){
            andWithOrs = new ArrayList<EasyAndWithOr>();
        }

        return andWithOrs;
    }

    public List<EasyOrEqualsIndex> getOrEqualsIndex() {
        if(orEqualsIndex == null){
            orEqualsIndex = new ArrayList<EasyOrEqualsIndex>();
        }

        return orEqualsIndex;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public List<WhereCondition> getAndGreaterThan() {
        List<WhereCondition> result = new ArrayList<WhereCondition>();

        for(WhereCondition condition : getConditions()){
            if(condition.isGreaterThan()){
                result.add(condition);
            }
        }

        return result;
    }
}