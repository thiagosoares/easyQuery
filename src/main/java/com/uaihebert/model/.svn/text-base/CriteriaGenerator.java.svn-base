package com.uaihebert.model;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class CriteriaGenerator<T> {
    private final EasyCriteriaBuilder<T> easyCriteriaBuilder;

    public CriteriaGenerator(EasyCriteriaBuilder<T> easyCriteriaBuilder) {
        this.easyCriteriaBuilder = easyCriteriaBuilder;
    }

    private Path getPath(String path, boolean pathForCount) {
        if(EntityPathHelper.hasMultipleJoins(path)){
            return getJoinPath(path, pathForCount);
        }

        return easyCriteriaBuilder.getPath(path, pathForCount);
    }

    private void isJoinCreated(String joinName) {
        if (easyCriteriaBuilder.joinsAreEmpty()) {
            throw new IllegalStateException("Did you add any kind of join? You should call easyCriteria.join() method before adding any kind of join parameter.");
        }

        if (!easyCriteriaBuilder.hasJoin(joinName)) {
            throw new IllegalStateException("Ops, we could not find your Join. You should call easyCriteria.join() method before adding any kind of join parameter. \n " +
                    "e.g.: Be careful that a list named nickNames is not equal to nicknames");
        }
    }

    private Path getJoinPath(String joinPath, boolean pathForCount) {
        String pathWithoutAttribute = EntityPathHelper.extractJoinsPathIfNeeded(joinPath, false);

        isJoinCreated(pathWithoutAttribute);

        String attributeWithoutPath = EntityPathHelper.extractAttributeFromJoins(joinPath);

        if(easyCriteriaBuilder.isJoinFetch(pathWithoutAttribute)){
            Path fetch = (Path) easyCriteriaBuilder.getFetch(pathWithoutAttribute, pathForCount);
            return fetch.get(attributeWithoutPath);
        }

        Join join = easyCriteriaBuilder.getJoin(pathWithoutAttribute, pathForCount);

        return join.get(attributeWithoutPath);
    }

    private Expression<String> lowerPath(String attributeName, boolean pathForCount) {
        Path objectPath = getPath(attributeName, pathForCount);
        return easyCriteriaBuilder.lower(objectPath, pathForCount);
    }

    private void validateString(Object value){
        if(!(value instanceof String)){
            throw new IllegalArgumentException("LowerCase can only be used with String");
        }
    }

    private Object lowerString(Object value, EasyConditionType type) {
        if(EasyConditionType.STRING_BETWEEN.equals(type)){
            Object[] values = (Object[]) value;

            validateString(values[0]);
            validateString(values[1]);

            values[0] = values[0].toString().toLowerCase();
            values[1] = values[1].toString().toLowerCase();

            return  values;
        }

        if(EasyConditionType.STRING_IN.equals(type)){
            List<String> values = (List<String>) value;
            List<String> result = new ArrayList<String>();

            for(String stringValue : values){
                result.add(stringValue.toLowerCase());
            }

            return result;
        }

        validateString(value);

        return value.toString().toLowerCase();
    }

    Predicate createAndCondition(String paths, Object value, boolean toLowerCase, EasyConditionType type, boolean pathToCount) {
        Expression<String> loweredPath = null;
        Path path = null;

        if(toLowerCase){
            value = lowerString(value, type);

            loweredPath = lowerPath(paths, pathToCount);
        } else {
            path = getPath(paths, pathToCount);
        }

        if(toLowerCase){
            return type.extractCondition(easyCriteriaBuilder.getCriteriaBuilder(pathToCount), loweredPath, value);
        }

        return type.extractCondition(easyCriteriaBuilder.getCriteriaBuilder(pathToCount), path, value);
    }

    Predicate createAndNotCondition(String path, Object value, boolean toLowerCase, EasyConditionType type, boolean pathToCount) {
        Predicate andCondition = createAndCondition(path, value, toLowerCase, type, pathToCount);
        return type.extractNotCondition(easyCriteriaBuilder.getCriteriaBuilder(pathToCount), andCondition);
    }

    void createJoin(String joinName, JoinType joinType, boolean toFetch, boolean pathToCount) {

        Root mainRoot = easyCriteriaBuilder.getRoot(pathToCount);

        String[] allPaths = EntityPathHelper.extractPaths(joinName);
        String[] createdPaths = new String[allPaths.length];
        String lastPath = "";

        for(int i = 0; i < allPaths.length; i++){
            createdPaths[i] = allPaths[i];
            boolean isFirstItemOfPath = i == 0;
            String currentPath = EntityPathHelper.extractJoinsPathIfNeeded(createdPaths, !isFirstItemOfPath);

            Join join = null;
            Fetch fetch = null;

            if(isFirstItemOfPath){
                if(toFetch){
                    fetch = mainRoot.fetch(currentPath, joinType);
                } else{
                    join = mainRoot.join(currentPath, joinType);
                }

            } else {
                if(toFetch){
                    Fetch createdJoin = easyCriteriaBuilder.getFetch(lastPath, pathToCount);
                    fetch = createdJoin.fetch(createdPaths[i], joinType);
                } else{
                    Join createdJoin = easyCriteriaBuilder.getJoin(lastPath, pathToCount);
                    join = createdJoin.join(createdPaths[i], joinType);
                }
            }

            lastPath = currentPath;

            if(join != null){
                easyCriteriaBuilder.putJoin(currentPath, join, pathToCount);
            } else{
                easyCriteriaBuilder.putFetch(currentPath, fetch, pathToCount);
            }
        }
    }

    Order orderByASC(String attributeName) {
        // it is not needed ordering to count
        return easyCriteriaBuilder.getCriteriaBuilder(false).asc(getPath(attributeName, false));
    }

    Order orderByDESC(String attributeName) {
        // it is not needed ordering to count
        return easyCriteriaBuilder.getCriteriaBuilder(false).desc(getPath(attributeName, false));
    }

    public Predicate or(Predicate[] orPredicates, boolean pathToCount) {
        return easyCriteriaBuilder.getCriteriaBuilder(pathToCount).or(orPredicates);
    }
}