package com.uaihebert.model;

import java.util.List;

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
public class EasyCTOImp<T> implements EasyCriteria<T> {

    private final QueryConfigurations configurations = new QueryConfigurations();

    //@Override
    public List<T> getResultList() {
        throw new IllegalStateException("Hello, I am a Criteria Transfer Object (CTO) Only. I do not have an entity manager do run the query. \n" +
                " To use a CTO correctly there is an other method in the EasyCriteriaFactory: \n" +
                " EasyCriteriaFactory.createQueryCriteria(EntityManager , Class<T>, EasyCriteria)");
    }

    //@Override
    public T getSingleResult() {
        throw new IllegalStateException("Hello, I am a Criteria Transfer Object (CTO) Only. I do not have an entity manager do run the query. \n" +
                " To use a CTO correctly there is an other method in the EasyCriteriaFactory: \n" +
                " EasyCriteriaFactory.createQueryCriteria(EntityManager , Class<T>, EasyCriteria)");
    }

    public EasyCriteria<T> andEquals(String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(null, attributeName, value, EasyConditionType.EQ, false));
        return this;
    }

    public EasyCriteria<T> andEquals(boolean toLowerCase, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(null, attributeName, value, EasyConditionType.EQ, toLowerCase));
        return this;
    }

    public EasyCriteria<T> orEquals(String attributeName, Object... values) {
        configurations.getOrEqualsIndex().add(EasyOrEqualsIndex.newInstance (-1, attributeName, true, values));
        return this;
    }

    public EasyCriteria<T> orEquals(boolean toLowerCase, String attributeName, Object... values) {
        configurations.getOrEqualsIndex().add(EasyOrEqualsIndex.newInstance (toLowerCase, -1, attributeName, true, values));
        return this;
    }

    public EasyCriteria<T> orEquals(int index, String attributeName, Object... values) {
        configurations.getOrEqualsIndex().add(EasyOrEqualsIndex.newInstance (index, attributeName, true, values));
        return this;
    }

    public EasyCriteria<T> orEquals(boolean toLowerCase, int index, String attributeName, Object... values) {
        configurations.getOrEqualsIndex().add(EasyOrEqualsIndex.newInstance (toLowerCase, index, attributeName, true, values));
        return this;
    }

    public EasyCriteria<T> andNotEquals(String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(null, attributeName, value, EasyConditionType.NE, false));
        return this;
    }

    public EasyCriteria<T> andNotEquals(boolean toLowerCase, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(null, attributeName, value, EasyConditionType.NE, toLowerCase));
        return this;
    }

    public EasyCriteria<T> orNotEquals(String attributeName, Object... values) {
        configurations.getOrEqualsIndex().add(EasyOrEqualsIndex.newInstance (-1, attributeName, false, values));
        return this;
    }

    public EasyCriteria<T> orNotEquals(boolean toLowerCase, String attributeName, Object... values) {
        configurations.getOrEqualsIndex().add(EasyOrEqualsIndex.newInstance (toLowerCase, -1, attributeName, false, values));
        return this;
    }

    public EasyCriteria<T> andGreaterThan(String attributeName, Object value) {
        configurations.andGreaterThan(false, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andGreaterThan(boolean toLowerCase, String attributeName, Object value) {
        configurations.andGreaterThan(toLowerCase, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andGreaterOrEqualTo(String attributeName, Object value) {
        configurations.andGreaterOrEqualTo(false, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andGreaterOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
        configurations.andGreaterOrEqualTo(toLowerCase, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andLessThan(String attributeName, Object value) {
        configurations.andLessThan(false, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andLessThan(boolean toLowerCase, String attributeName, Object value) {
        configurations.andLessThan(toLowerCase, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andLessOrEqualTo(String attributeName, Object value) {
        configurations.andLessOrEqualTo(false, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andLessOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
        configurations.andLessOrEqualTo(toLowerCase, attributeName, value);
        return this;
    }

    public EasyCriteria<T> innerJoin(String joinName) {
        configurations.getInnerJoins().add(joinName);
        return this;
    }

    public EasyCriteria<T> leftJoin(String joinName) {
        configurations.getLeftJoins().add(joinName);
        return this;
    }

    public EasyCriteria<T> innerJoinFetch(String joinName) {
        configurations.getInnerJoinsFetch().add(joinName);
        return this;
    }

    
    public EasyCriteria<T> leftJoinFetch(String joinName) {
        configurations.getLeftJoinsFetch().add(joinName);
        return this;
    }

    public EasyCriteria<T> setDistinctTrue() {
        configurations.setDistinctTrue();
        return this;
    }

    public EasyCriteria<T> andBetween(String attributeName, Object valueA, Object valueB) {
        configurations.andBetween(attributeName, valueA, valueB);
        return this;
    }

    public EasyCriteria<T> andBetween(boolean toLowerCase, String attributeName, Object valueA, Object valueB) {
        configurations.andBetween(toLowerCase, attributeName, valueA, valueB);
        return this;
    }

    public EasyCriteria<T> andIsNull(String attributeName) {
        configurations.andIsNull(attributeName);
        return this;
    }

    public EasyCriteria<T> andIsNotNull(String attributeName) {
        configurations.andIsNotNull(attributeName);
        return this;
    }

    public EasyCriteria<T> andCollectionIsEmpty(String collectionName) {
        configurations.andCollectionIsEmpty(collectionName);
        return this;
    }

    public EasyCriteria<T> andCollectionIsNotEmpty(String collectionName) {
        configurations.andCollectionIsNotEmpty(collectionName);
        return this;
    }

    public EasyCriteria<T> andStringLike(String attributeName, String value) {
        configurations.andStringLike(false, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andStringLike(boolean toLowerCase, String attributeName, String value) {
        configurations.andStringLike(toLowerCase, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andStringNotLike(String attributeName, String value) {
        configurations.andStringNotLike(false, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andStringNotLike(boolean toLowerCase, String attributeName, String value) {
        configurations.andStringNotLike(toLowerCase, attributeName, value);
        return this;
    }

    public EasyCriteria<T> andStringIn(String attributeName, List<String> values) {
        configurations.andStringIn(false,attributeName, values);
        return this;
    }

    public EasyCriteria<T> andStringIn(boolean toLowerCase, String attributeName, List<String> values) {
        configurations.andStringIn(toLowerCase, attributeName, values);
        return this;
    }

    public EasyCriteria<T> andStringNotIn(String attributeName, List<String> values) {
        configurations.andStringNotIn(false, attributeName, values);
        return this;
    }

    public EasyCriteria<T> andStringNotIn(boolean toLowerCase, String attributeName, List<String> values) {
        configurations.andStringNotIn(toLowerCase, attributeName, values);
        return this;
    }

    public EasyCriteria<T> orderByAsc(String attributeName) {
        configurations.orderByAsc(attributeName);
        return this;
    }

    public EasyCriteria<T> orderByDesc(String attributeName) {
        configurations.orderByDesc(attributeName);
        return this;
    }

    public EasyCriteria<T> setFirstResult(int firstResult) {
        configurations.setFirstResult(firstResult);
        return this;
    }

    public EasyCriteria<T> setMaxResults(int maxResults) {
        configurations.setMaxResults(maxResults);
        return this;
    }

    public EasyCriteria<T> andJoinEquals(String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.EQ, false));
        return this;
    }

    public EasyCriteria<T> andJoinEquals(boolean toLowerCase, String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.EQ, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinNotEquals(String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.NE, false));
        return this;
    }

    public EasyCriteria<T> andJoinNotEquals(boolean toLowerCase, String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.NE, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinGreaterThan(String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.GT, false));
        return this;
    }

    public EasyCriteria<T> andJoinGreaterThan(boolean toLowerCase, String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.GT, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinGreaterOrEqualTo(String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.GE, false));
        return this;
    }

    public EasyCriteria<T> andJoinGreaterOrEqualTo(boolean toLowerCase, String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.GE, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinLessThan(String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.LT, false));
        return this;
    }

    public EasyCriteria<T> andJoinLessThan(boolean toLowerCase, String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.LT, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinLessOrEqualTo(String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.LE, false));
        return this;
    }

    public EasyCriteria<T> andJoinLessOrEqualTo(boolean toLowerCase, String joinName, String attributeName, Object value) {
        configurations.getEasyAttributes().add(EasyAttribute.newInstance(joinName, attributeName, value, EasyConditionType.LE, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinBetween(String joinName, String attributeName, Object valueA, Object valueB) {
        configurations.getJoinsBetween().add(JoinBetween.newInstance(joinName, attributeName, valueA, valueB, false));
        return this;
    }

    public EasyCriteria<T> andJoinBetween(boolean toLowerCase, String joinName, String attributeName, Object valueA, Object valueB) {
        configurations.getJoinsBetween().add(JoinBetween.newInstance(joinName, attributeName, valueA, valueB, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinAttributeIsNull(String joinName, String attributeName) {
        configurations.getJoinsNull().add(new JoinIsNull(joinName, attributeName, true));
        return this;
    }

    public EasyCriteria<T> andJoinAttributeIsNotNull(String joinName, String attributeName) {
        configurations.getJoinsNull().add(new JoinIsNull(joinName, attributeName, false));
        return this;
    }

    public EasyCriteria<T> andJoinListIsEmpty(String joinName, String listName) {
        configurations.getJoinsEmpty().add(new JoinIsEmpty(joinName, listName, true, CollectionType.LIST));
        return this;
    }

    public EasyCriteria<T> andJoinCollectionIsEmpty(String joinName, String collectionName) {
        configurations.getJoinsEmpty().add(new JoinIsEmpty(joinName, collectionName, true, CollectionType.COLLECTION));
        return this;
    }

    public EasyCriteria<T> andJoinSetIsEmpty(String joinName, String setName) {
        configurations.getJoinsEmpty().add(new JoinIsEmpty(joinName, setName, true, CollectionType.SET));
        return this;
    }

    public EasyCriteria<T> andJoinListIsNotEmpty(String joinName, String listName) {
        configurations.getJoinsEmpty().add(new JoinIsEmpty(joinName, listName, false, CollectionType.LIST));
        return this;
    }

    public EasyCriteria<T> andJoinCollectionIsNotEmpty(String joinName, String collectionName) {
        configurations.getJoinsEmpty().add(new JoinIsEmpty(joinName, collectionName, false, CollectionType.COLLECTION));
        return this;
    }

    public EasyCriteria<T> andJoinSetIsNotEmpty(String joinName, String setName) {
        configurations.getJoinsEmpty().add(new JoinIsEmpty(joinName, setName, false, CollectionType.SET));
        return this;
    }

    public EasyCriteria<T> andJoinStringLike(String joinName, String attributeName, String value) {
        configurations.getJoinsStringLike().add(EasyJoinStringLike.newInstance(joinName, attributeName, value, true, false));
        return this;
    }

    public EasyCriteria<T> andJoinStringLike(boolean toLowerCase, String joinName, String attributeName, String value) {
        configurations.getJoinsStringLike().add(EasyJoinStringLike.newInstance(joinName, attributeName, value, true, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinStringNotLike(String joinName, String attributeName, String value) {
        configurations.getJoinsStringLike().add(EasyJoinStringLike.newInstance(joinName, attributeName, value, false, false));
        return this;
    }

    public EasyCriteria<T> andJoinStringNotLike(boolean toLowerCase, String joinName, String attributeName, String value) {
        configurations.getJoinsStringLike().add(EasyJoinStringLike.newInstance(joinName, attributeName, value, false, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinStringIn(String joinName, String attributeName, List<String> values) {
        configurations.getJoinsStringIn().add(EasyJoinStringIn.newInstance(joinName, attributeName, values, true, false));
        return this;
    }

    public EasyCriteria<T> andJoinStringIn(boolean toLowerCase, String joinName, String attributeName, List<String> values) {
        configurations.getJoinsStringIn().add(EasyJoinStringIn.newInstance(joinName, attributeName, values, true, toLowerCase));
        return this;
    }

    public EasyCriteria<T> andJoinStringNotIn(String joinName, String attributeName, List<String> values) {
        configurations.getJoinsStringIn().add(EasyJoinStringIn.newInstance(joinName, attributeName, values, false, false));
        return this;
    }

    public EasyCriteria<T> andJoinStringNotIn(boolean toLowerCase, String joinName, String attributeName, List<String> values) {
        configurations.getJoinsStringIn().add(EasyJoinStringIn.newInstance(joinName, attributeName, values, false, toLowerCase));
        return this;
    }

    public EasyCriteria<T> addAndSeparatedByOr(int index, String attributeName, Object value) {
        configurations.getAndWithOrs().add(EasyAndWithOr.newInstance(index, attributeName, value, false));
        return this;
    }

    public EasyCriteria<T> addAndSeparatedByOr(boolean toLowerCase, int index, String attributeName, Object value) {
        configurations.getAndWithOrs().add(EasyAndWithOr.newInstance(index, attributeName, value, toLowerCase));
        return this;
    }

    //@Override
    public Long count() {
        throw new IllegalStateException("Hello, I am a Criteria Transfer Object (CTO) Only. I do not have an entity manager do run the query. \n" +
                " To use a CTO correctly there is an other method in the EasyCriteriaFactory: \n" +
                " EasyCriteriaFactory.createQueryCriteria(EntityManager , Class<T>, EasyCriteria)");
    }

    public QueryConfigurations getConfigurations() {
        return configurations;
    }
    
    public EasyCriteria<T> clear() {
		// TODO Auto-generated method stub
		return null;
	}
}