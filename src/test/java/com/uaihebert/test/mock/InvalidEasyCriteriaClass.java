package com.uaihebert.test.mock;

import com.uaihebert.model.EasyCriteria;

import java.util.List;

public class InvalidEasyCriteriaClass<T> implements EasyCriteria<T> {
    
    //@Override
    public List<T> getResultList() {
        return null;
    }

    //@Override
    public T getSingleResult() {
        return null;
    }

    //@Override
    public EasyCriteria<T> andEquals(String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andEquals(boolean toLowerCase, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> orEquals(String attributeName, Object... values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> orEquals(boolean toLowerCase, String attributeName, Object... values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> orEquals(int index, String attributeName, Object... values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> orEquals(boolean toLowerCase, int index, String attributeName, Object... values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andNotEquals(String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andNotEquals(boolean toLowerCase, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> orNotEquals(String attributeName, Object... values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> orNotEquals(boolean toLowerCase, String attributeName, Object... values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andGreaterThan(String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andGreaterThan(boolean toLowerCase, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andGreaterOrEqualTo(String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andGreaterOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andLessThan(String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andLessThan(boolean toLowerCase, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andLessOrEqualTo(String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andLessOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> innerJoin(String joinName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> leftJoin(String joinName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> innerJoinFetch(String joinName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> leftJoinFetch(String joinName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> setDistinctTrue() {
        return null;
    }

    //@Override
    public EasyCriteria<T> andBetween(String attributeName, Object valueA, Object valueB) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andBetween(boolean toLowerCase, String attributeName, Object valueA, Object valueB) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andIsNull(String attributeName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andIsNotNull(String attributeName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andCollectionIsEmpty(String collectionName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andCollectionIsNotEmpty(String collectionName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andStringLike(String attributeName, String value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andStringLike(boolean toLowerCase, String attributeName, String value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andStringNotLike(String attributeName, String value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andStringNotLike(boolean toLowerCase, String attributeName, String value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andStringIn(String attributeName, List<String> values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andStringIn(boolean toLowerCase, String attributeName, List<String> values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andStringNotIn(String attributeName, List<String> values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andStringNotIn(boolean toLowerCase, String attributeName, List<String> values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> orderByAsc(String attributeName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> orderByDesc(String attributeName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> setFirstResult(int firstResult) {
        return null;
    }

    //@Override
    public EasyCriteria<T> setMaxResults(int maxResults) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinEquals(String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinEquals(boolean toLowerCase, String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinNotEquals(String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinNotEquals(boolean toLowerCase, String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinGreaterThan(String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinGreaterThan(boolean toLowerCase, String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinGreaterOrEqualTo(String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinGreaterOrEqualTo(boolean toLowerCase, String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinLessThan(String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinLessThan(boolean toLowerCase, String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinLessOrEqualTo(String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinLessOrEqualTo(boolean toLowerCase, String joinName, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinBetween(String joinName, String attributeName, Object valueA, Object valueB) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinBetween(boolean toLowerCase, String joinName, String attributeName, Object valueA, Object valueB) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinAttributeIsNull(String joinName, String attributeName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinAttributeIsNotNull(String joinName, String attributeName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinListIsEmpty(String joinName, String listName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinCollectionIsEmpty(String joinName, String collectionName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinSetIsEmpty(String joinName, String setName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinListIsNotEmpty(String joinName, String listName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinCollectionIsNotEmpty(String joinName, String collectionName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinSetIsNotEmpty(String joinName, String setName) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinStringLike(String joinName, String attributeName, String value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinStringLike(boolean toLowerCase, String joinName, String attributeName, String value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinStringNotLike(String joinName, String attributeName, String value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinStringNotLike(boolean toLowerCase, String joinName, String attributeName, String value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinStringIn(String joinName, String attributeName, List<String> values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinStringIn(boolean toLowerCase, String joinName, String attributeName, List<String> values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinStringNotIn(String joinName, String attributeName, List<String> values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> andJoinStringNotIn(boolean toLowerCase, String joinName, String attributeName, List<String> values) {
        return null;
    }

    //@Override
    public EasyCriteria<T> addAndSeparatedByOr(int index, String attributeName, Object value) {
        return null;
    }

    //@Override
    public EasyCriteria<T> addAndSeparatedByOr(boolean toLowerCase, int index, String attributeName, Object value) {
        return null;
    }

    //@Override
    public Long count() {
        return null;
    }
}
