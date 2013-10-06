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

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.uaihebert.factory.EasyCriteriaFactory;

import java.util.List;

public class EasyCriteriaImp<T> implements EasyCriteria<T> {
    
	private BasicQueryElements<T> basicQueryElements;
    private int firstResult;
    private int maxResults;


    public EasyCriteriaImp<T> clear() {
        Class<T> entityClass = basicQueryElements.getEasyCriteriaBuilder().getEntityClass();
        
        EntityManager entityManager = basicQueryElements.getEasyCriteriaBuilder().getEntityManager();
        
        this.setBasicQueryElements((BasicQueryElements<T>) EasyCriteriaFactory.createBasicElement(entityManager, entityClass));
        return this;
    }
    
    
    
	public void setBasicQueryElements(BasicQueryElements<T> basicQueryElements) {
		this.basicQueryElements = basicQueryElements;
	}



	public EasyCriteriaImp(BasicQueryElements<T> basicQueryElements) {
        this.basicQueryElements = basicQueryElements;
    }

    public List<T> getResultList() {
        configureParameters();

        TypedQuery<T> query = basicQueryElements.getTypedQuery();

        if (firstResult > 0) {
            query.setFirstResult(firstResult);
        }

        if (maxResults > 0) {
            query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    private void configureParameters() {
        EasyCTOImp easyCTO = basicQueryElements.getEasyCTO();

        if(easyCTO == null){
            return;
        }

        for(String joinName : easyCTO.getConfigurations().getInnerJoins()){
            innerJoin(joinName);
        }

        for(String joinName : easyCTO.getConfigurations().getLeftJoins()){
            leftJoin(joinName);
        }

        for(String joinName : easyCTO.getConfigurations().getLeftJoinsFetch()){
            leftJoinFetch(joinName);
        }

        if(easyCTO.getConfigurations().isDistinctQuery()){
            setDistinctTrue();
        }

        List<WhereCondition> andGreaterThan = easyCTO.getConfigurations().getAndGreaterThan();

        for(WhereCondition greaterThan : andGreaterThan){
            andGreaterThan(greaterThan.isToLowerCase(), greaterThan.getAttributeName(), greaterThan.getValue());
        }

        List<WhereCondition> andGreaterOrEqualTo = easyCTO.getConfigurations().getAndGreaterOrEqualTo();

        for(WhereCondition greaterOrEqualTo : andGreaterOrEqualTo){
            andGreaterOrEqualTo(greaterOrEqualTo.isToLowerCase(), greaterOrEqualTo.getAttributeName(), greaterOrEqualTo.getValue());
        }

        List<WhereCondition> andLessThan = easyCTO.getConfigurations().getAndLessThan();

        for(WhereCondition lessThan : andLessThan){
            andLessThan(lessThan.isToLowerCase(), lessThan.getAttributeName(), lessThan.getValue());
        }

        List<WhereCondition> andLessOrEqualTo = easyCTO.getConfigurations().getAndLessOrEqualTo();

        for(WhereCondition condition : andLessOrEqualTo){
            andLessOrEqualTo(condition.isToLowerCase(), condition.getAttributeName(), condition.getValue());
        }

        for(Between between : easyCTO.getConfigurations().getAndBetween()){
            andBetween(between.isToLowerCase(), between.getAttributeName(), between.getValueA(), between.getValueB());
        }

        for(String attributeName : easyCTO.getConfigurations().getAndIsNull()){
            andIsNull(attributeName);
        }

        for(String attributeName : easyCTO.getConfigurations().getAndIsNotNull()){
            andIsNotNull(attributeName);
        }

        for(String attributeName : easyCTO.getConfigurations().getCollectionIsEmpty()){
            andCollectionIsEmpty(attributeName);
        }

        for(String attributeName : easyCTO.getConfigurations().getCollectionIsNotEmpty()){
            andCollectionIsNotEmpty(attributeName);
        }

        List<EasyJoinStringLike> joinsStringLike = easyCTO.getConfigurations().getJoinsStringLike();

        for(EasyJoinStringLike like : joinsStringLike){
            if(!like.hasJoin()){
                if(like.isLike()){
                    andStringLike(like.isToLowerCase(), like.getAttributeName(), like.getValue());
                } else{
                    andStringNotLike(like.isToLowerCase(), like.getAttributeName(), like.getValue());
                }
            }
        }

        List<EasyJoinStringIn> joinsStringIn = easyCTO.getConfigurations().getJoinsStringIn();

        for (EasyJoinStringIn stringIn : joinsStringIn){
            if(stringIn.hasJoin()){
                continue;
            }

            if(stringIn.isIn()){
                andStringIn(stringIn.isToLowerCase(), stringIn.getAttributeName(), stringIn.getValues());
            } else{
                andStringNotIn(stringIn.isToLowerCase(), stringIn.getAttributeName(), stringIn.getValues());
            }
        }

        for(String attributeName : easyCTO.getConfigurations().getOrderByAsc()){
            orderByAsc(attributeName);
        }

        for(String attributeName : easyCTO.getConfigurations().getOrderByDesc()){
            orderByDesc(attributeName);
        }

        for(String joinName : easyCTO.getConfigurations().getInnerJoinsFetch()){
            innerJoinFetch(joinName);
        }

        for (EasyAttribute join : easyCTO.getConfigurations().getEasyAttributes()){

            if(EasyConditionType.EQ.equals(join.getType())){
                if(join.getJoinName() == null){
                    andEquals(join.isToLowerCase(), join.getAttributeName(), join.getValue());
                } else{
                    andJoinEquals(join.getJoinName(), join.getAttributeName(), join.getValue());
                }

                continue;
            }

            if(EasyConditionType.NE.equals(join.getType())){
                if(join.getJoinName() == null){
                    andNotEquals(join.isToLowerCase(), join.getAttributeName(), join.getValue());
                } else{
                    andJoinNotEquals(join.isToLowerCase(), join.getJoinName(), join.getAttributeName(), join.getValue());
                }

                continue;
            }

            if(EasyConditionType.GT.equals(join.getType())){
                andJoinGreaterThan(join.isToLowerCase(), join.getJoinName(), join.getAttributeName(), join.getValue());
                continue;
            }

            if(EasyConditionType.GE.equals(join.getType())){
                andJoinGreaterOrEqualTo(join.isToLowerCase(), join.getJoinName(), join.getAttributeName(), join.getValue());
                continue;
            }

            if(EasyConditionType.LT.equals(join.getType())){
                andJoinLessThan(join.isToLowerCase(), join.getJoinName(), join.getAttributeName(), join.getValue());
                continue;
            }

            if(EasyConditionType.LE.equals(join.getType())){
                andJoinLessOrEqualTo(join.isToLowerCase(), join.getJoinName(), join.getAttributeName(), join.getValue());
                continue;
            }

            throw new IllegalArgumentException("the type passed is not valid. Tell us what you kind of attribute are you passing as parameter: contato@uaihebert.com");
        }

        for(JoinBetween between : easyCTO.getConfigurations().getJoinsBetween()){
            andJoinBetween(between.isToLowerCase(), between.getJoinName(), between.getAttributeName(), between.getValueA(), between.getValueB());
        }

        for(JoinIsNull joinIsNull : easyCTO.getConfigurations().getJoinsNull()){
            if(joinIsNull.isNull()){
                andJoinAttributeIsNull(joinIsNull.getJoinName(), joinIsNull.getAttributeName());
            } else{
                andJoinAttributeIsNotNull(joinIsNull.getJoinName(), joinIsNull.getAttributeName());
            }
        }

        for(JoinIsEmpty joinIsEmpty : easyCTO.getConfigurations().getJoinsEmpty()){
            if(joinIsEmpty.isEmpty()){
                switch (joinIsEmpty.getType()){
                    case COLLECTION :
                        andJoinCollectionIsEmpty(joinIsEmpty.getJoinName(), joinIsEmpty.getAttributeName());
                        break;
                    case LIST:
                        andJoinListIsEmpty(joinIsEmpty.getJoinName(), joinIsEmpty.getAttributeName());
                        break;
                    case SET:
                        andJoinSetIsEmpty(joinIsEmpty.getJoinName(), joinIsEmpty.getAttributeName());
                        break;
                }
            } else{
                switch (joinIsEmpty.getType()){
                    case COLLECTION :
                        andJoinCollectionIsNotEmpty(joinIsEmpty.getJoinName(), joinIsEmpty.getAttributeName());
                        break;
                    case LIST:
                        andJoinListIsNotEmpty(joinIsEmpty.getJoinName(), joinIsEmpty.getAttributeName());
                        break;
                    case SET:
                        andJoinSetIsNotEmpty(joinIsEmpty.getJoinName(), joinIsEmpty.getAttributeName());
                        break;
                }
            }
        }

        for(EasyJoinStringLike like : easyCTO.getConfigurations().getJoinsStringLike()){
            if(!like.hasJoin()){
                continue;
            }

            if(like.isLike()){
                andJoinStringLike(like.isToLowerCase(), like.getJoinName(), like.getAttributeName(), like.getValue());
            } else{
                andJoinStringNotLike(like.isToLowerCase(), like.getJoinName(), like.getAttributeName(), like.getValue());
            }
        }

        for(EasyJoinStringIn stringIn : easyCTO.getConfigurations().getJoinsStringIn()){
            if(!stringIn.hasJoin()){
                continue;
            }

            if(stringIn.isIn()){
                andJoinStringIn(stringIn.isToLowerCase(), stringIn.getJoinName(), stringIn.getAttributeName(), stringIn.getValues());
            } else{
                andJoinStringNotIn(stringIn.isToLowerCase(), stringIn.getJoinName(), stringIn.getAttributeName(), stringIn.getValues());
            }
        }

        if(easyCTO.getConfigurations().getFirstResult() > 0){
            setFirstResult(easyCTO.getConfigurations().getFirstResult());
        }

        if(easyCTO.getConfigurations().getMaxResults() > 0){
            setMaxResults(easyCTO.getConfigurations().getMaxResults());
        }

        for(EasyAndWithOr and : easyCTO.getConfigurations().getAndWithOrs()){
            addAndSeparatedByOr(and.isToLowerCase(), and.getIndex(), and.getAttributeName(), and.getValue());
        }

        for(EasyOrEqualsIndex orIndex : easyCTO.getConfigurations().getOrEqualsIndex()){
            if(orIndex.getIndex() >= 0){
                orEquals(orIndex.isToLowerCase(), orIndex.getIndex(), orIndex.getAttributeName(), orIndex.getValues());
            } else{
                if(orIndex.isEquals()){
                    orEquals(orIndex.isToLowerCase(), orIndex.getAttributeName(), orIndex.getValues());
                } else{
                    orNotEquals(orIndex.isToLowerCase(), orIndex.getAttributeName(), orIndex.getValues());
                }
            }
        }

        basicQueryElements.releaseEasyCTO();
    }

    public T getSingleResult() {
        configureParameters();

        TypedQuery<T> query = basicQueryElements.getTypedQuery();

        return query.getSingleResult();
    }

    public EasyCriteriaImp<T> andEquals(String attributeName, Object value) {
        basicQueryElements.andEquals(attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andEquals(boolean toLowerCase, String attributeName, Object value) {
        basicQueryElements.andEquals(attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andNotEquals(String attributeName, Object value) {
        basicQueryElements.andNotEquals(attributeName, false, value);
        return this;
    }

    public EasyCriteria<T> andNotEquals(boolean toLowerCase, String attributeName, Object value) {
        basicQueryElements.andNotEquals(attributeName, toLowerCase, value);
        return this;
    }

    public EasyCriteria<T> orNotEquals(String attributeName, Object... values) {
        basicQueryElements.orNotEquals(false, attributeName, values);
        return this;
    }

    public EasyCriteria<T> orNotEquals(boolean toLowerCase, String attributeName, Object... values) {
        basicQueryElements.orNotEquals(toLowerCase, attributeName, values);
        return this;
    }

    public EasyCriteria<T> andGreaterThan(String attributeName, Object value){
        basicQueryElements.andGreaterThan(attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andGreaterThan(boolean toLowerCase, String attributeName, Object value){
        basicQueryElements.andGreaterThan(attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andGreaterOrEqualTo(String attributeName, Object value) {
        basicQueryElements.andGreaterOrEqualTo(attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andGreaterOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
        basicQueryElements.andGreaterOrEqualTo(attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andLessThan(String attributeName, Object value) {
        basicQueryElements.andLessThan(attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andLessThan(boolean toLowerCase, String attributeName, Object value) {
        basicQueryElements.andLessThan(attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andLessOrEqualTo(String attributeName, Object value) {
        basicQueryElements.andLessOrEqualTo(attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andLessOrEqualTo(boolean toLowerCase, String attributeName, Object value) {
        basicQueryElements.andLessOrEqualTo(attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> innerJoin(String joinName) {
        basicQueryElements.innerJoin(joinName);
        return this;
    }

    public EasyCriteria<T> setDistinctTrue() {
        basicQueryElements.setDistinctTrue();
        return this;
    }

    public EasyCriteria<T> leftJoin(String joinName) {
        basicQueryElements.leftJoin(joinName);
        return this;
    }

    public EasyCriteria<T> innerJoinFetch(String joinName) {
        basicQueryElements.innerJoinFetch(joinName);
        return this;
    }

    public EasyCriteria<T> leftJoinFetch(String joinName) {
        basicQueryElements.leftJoinFetch(joinName);
        return this;
    }

    public EasyCriteria<T> andBetween(String attributeName, Object valueA, Object valueB){
        basicQueryElements.andBetween(attributeName, valueA, valueB, false);
        return this;
    }

    public EasyCriteria<T> andBetween(boolean toLowerCase, String attributeName, Object valueA, Object valueB){
        basicQueryElements.andBetween(attributeName, valueA, valueB, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andIsNull(String attributeName) {
        basicQueryElements.andIsNull(attributeName, true);
        return this;
    }

    public EasyCriteria<T> andIsNotNull(String attributeName) {
        basicQueryElements.andIsNull(attributeName, false);
        return this;
    }

    public EasyCriteria<T> andCollectionIsEmpty(String collectionName) {
        basicQueryElements.andCollectionIsEmpty(collectionName, true);
        return this;
    }

    public EasyCriteria<T> andCollectionIsNotEmpty(String collectionName) {
        basicQueryElements.andCollectionIsEmpty(collectionName, false);
        return this;
    }

    public EasyCriteria<T> andStringLike(String attributeName, String value) {
        basicQueryElements.andStringLike(attributeName, value, false, true);
        return this;
    }

    public EasyCriteria<T> andStringLike(boolean toLowerCase, String attributeName, String value) {
        basicQueryElements.andStringLike(attributeName, value, toLowerCase, true);
        return this;
    }

    public EasyCriteria<T> andStringNotLike(String attributeName, String value) {
        basicQueryElements.andStringLike(attributeName, value, false, false);
        return this;
    }

    public EasyCriteria<T> andStringNotLike(boolean toLowerCase, String attributeName, String value) {
        basicQueryElements.andStringLike(attributeName, value, toLowerCase, false);
        return this;
    }

    public EasyCriteria<T> andStringIn(String attributeName, List<String> values) {
        basicQueryElements.andStringIn(attributeName, values, false, true);
        return this;
    }

    public EasyCriteria<T> andStringIn(boolean toLowerCase, String attributeName, List<String> values) {
        basicQueryElements.andStringIn(attributeName, values, toLowerCase, true);
        return this;
    }

    public EasyCriteria<T> andStringNotIn(String attributeName, List<String> values) {
        basicQueryElements.andStringIn(attributeName, values, false, false);
        return this;
    }

    public EasyCriteria<T> andStringNotIn(boolean toLowerCase, String attributeName, List<String> values) {
        basicQueryElements.andStringIn(attributeName, values, toLowerCase, false);
        return this;
    }

    public EasyCriteria<T> orderByAsc(String attributeName) {
        basicQueryElements.orderByAsc(attributeName);
        return this;
    }

    public EasyCriteria<T> orderByDesc(String attributeName) {
        basicQueryElements.orderByDesc(attributeName);
        return this;
    }

    public EasyCriteria<T> setFirstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    public EasyCriteria<T> setMaxResults(int maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    public EasyCriteria<T> andJoinEquals(String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinEquals(joinName, attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andJoinEquals(boolean toLowerCase, String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinEquals(joinName, attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andJoinNotEquals(String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinNotEquals(joinName, attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andJoinNotEquals(boolean toLowerCase, String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinNotEquals(joinName, attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andJoinGreaterThan(String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinGreaterThan(joinName, attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andJoinGreaterThan(boolean toLowerCase, String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinGreaterThan(joinName, attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andJoinGreaterOrEqualTo(String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinGreaterOrEqualTo(joinName, attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andJoinGreaterOrEqualTo(boolean toLowerCase, String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinGreaterOrEqualTo(joinName, attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andJoinLessThan(String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinLessThan(joinName, attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andJoinLessThan(boolean toLowerCase, String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinLessThan(joinName, attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andJoinLessOrEqualTo(String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinLessOrEqualTo(joinName, attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> andJoinLessOrEqualTo(boolean toLowerCase, String joinName, String attributeName, Object value) {
        basicQueryElements.andJoinLessOrEqualTo(joinName, attributeName, value, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andJoinBetween(String joinName, String attributeName, Object valueA, Object valueB){
        basicQueryElements.andJoinBetween(joinName, attributeName, valueA, valueB, false);
        return this;
    }

    public EasyCriteria<T> andJoinBetween(boolean toLowerCase, String joinName, String attributeName, Object valueA, Object valueB){
        basicQueryElements.andJoinBetween(joinName, attributeName, valueA, valueB, toLowerCase);
        return this;
    }

    public EasyCriteria<T> andJoinAttributeIsNull(String joinName, String attributeName) {
        basicQueryElements.andJoinAttributeIsNull(joinName, attributeName);
        return this;
    }

    public EasyCriteria<T> andJoinAttributeIsNotNull(String joinName, String attributeName) {
        basicQueryElements.andJoinAttributeIsNotNull(joinName, attributeName);
        return this;
    }

    public EasyCriteria<T> andJoinListIsEmpty(String joinName, String listName) {
        basicQueryElements.andJoinCollectionIsEmpty(joinName, listName, true);
        return this;
    }

    public EasyCriteria<T> andJoinCollectionIsEmpty(String joinName, String collectionName) {
        basicQueryElements.andJoinCollectionIsEmpty(joinName, collectionName, true);
        return this;
    }

    
    public EasyCriteria<T> andJoinCollectionIsNotEmpty(String joinName, String collectionName) {
        basicQueryElements.andJoinCollectionIsEmpty(joinName, collectionName, false);
        return this;
    }
    
    public EasyCriteria<T> andJoinStringLike(String joinName, String attributeName, String value) {
        basicQueryElements.andJoinStringLike(joinName, attributeName, value, false, true);
        return this;
    }

    public EasyCriteria<T> andJoinStringLike(boolean toLowerCase, String joinName, String attributeName, String value) {
        basicQueryElements.andJoinStringLike(joinName, attributeName, value, toLowerCase, true);
        return this;
    }

    public EasyCriteria<T> andJoinSetIsEmpty(String joinName, String setName) {
        basicQueryElements.andJoinCollectionIsEmpty(joinName, setName, true);
        return this;
    }

    public EasyCriteria<T> andJoinListIsNotEmpty(String joinName, String listName) {
        basicQueryElements.andJoinCollectionIsEmpty(joinName, listName, false);
        return this;
    }

    public EasyCriteria<T> andJoinSetIsNotEmpty(String joinName, String setName) {
        basicQueryElements.andJoinCollectionIsEmpty(joinName, setName, false);
        return this;
    }

    public EasyCriteria<T> andJoinStringNotLike(String joinName, String attributeName, String value) {
        basicQueryElements.andJoinStringLike(joinName, attributeName, value, false, false);
        return this;
    }

    public EasyCriteria<T> andJoinStringNotLike(boolean toLowerCase, String joinName, String attributeName, String value) {
        basicQueryElements.andJoinStringLike(joinName, attributeName, value, toLowerCase, false);
        return this;
    }

    public EasyCriteria<T> andJoinStringIn(String joinName, String attributeName, List<String> values) {
        basicQueryElements.andJoinStringIn(joinName, attributeName, values, false, true);
        return this;
    }

    public EasyCriteria<T> andJoinStringIn(boolean toLowerCase, String joinName, String attributeName, List<String> values) {
        basicQueryElements.andJoinStringIn(joinName, attributeName, values, toLowerCase, true);
        return this;
    }

    public EasyCriteria<T> andJoinStringNotIn(String joinName, String attributeName, List<String> values) {
        basicQueryElements.andJoinStringIn(joinName, attributeName, values, false, false);
        return this;
    }

    public EasyCriteria<T> andJoinStringNotIn(boolean toLowerCase, String joinName, String attributeName, List<String> values) {
        basicQueryElements.andJoinStringIn(joinName, attributeName, values, toLowerCase, false);
        return this;
    }

    public EasyCriteria<T> orEquals(String attributeName, Object... values) {
        basicQueryElements.orEquals(false, attributeName, values);
        return this;
    }

    public EasyCriteria<T> orEquals(boolean toLowerCase, String attributeName, Object... values) {
        basicQueryElements.orEquals(toLowerCase, attributeName, values);
        return this;
    }

    public EasyCriteria<T> orEquals(int index, String attributeName, Object... values) {
        basicQueryElements.orEquals(index, false, attributeName, values);
        return this;
    }

    public EasyCriteria<T> orEquals(boolean toLowerCase, int index, String attributeName, Object... values) {
        basicQueryElements.orEquals(index, toLowerCase, attributeName, values);
        return this;
    }

    public EasyCriteria<T> addAndSeparatedByOr(int index, String attributeName, Object value){
        basicQueryElements.addAndSeparatedByOr(index, attributeName, value, false);
        return this;
    }

    public EasyCriteria<T> addAndSeparatedByOr(boolean toLowerCase, int index, String attributeName, Object value){
        basicQueryElements.addAndSeparatedByOr(index, attributeName, value, toLowerCase);
        return this;
    }

    public Long count() {
        configureParameters();

        TypedQuery<Long> countTypedQuery = basicQueryElements.getCountTypedQuery();

        return countTypedQuery.getSingleResult();
    }
}