package com.uaihebert.model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyCriteriaBuilder<T> {
    private final Class<T> entityClass;
    private final EntityManager entityManager;

    //***** main query
    private final Root<T> mainRoot;
    private final CriteriaQuery<T> mainCriteriaQuery;
    private final CriteriaBuilder mainCriteriaBuilder;
    private final PredicatesManager mainPredicatesManager = new PredicatesManager();
    private final Map<String, Object> mainJoins = new HashMap<String, Object>();
    //***** main query

    //***** count query
    private final Root<T> countRoot;
    private final CriteriaBuilder countCriteriaBuilder;
    private final CriteriaQuery<Long> countCriteriaQuery;
    private final PredicatesManager countPredicatesManager = new PredicatesManager();
    private final Map<String, Object> countJoins = new HashMap<String, Object>();
    //***** count query

    public EasyCriteriaBuilder(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;

        mainCriteriaBuilder = entityManager.getCriteriaBuilder();
        mainCriteriaQuery = mainCriteriaBuilder.createQuery(entityClass);
        mainRoot = mainCriteriaQuery.from(entityClass);
        mainCriteriaQuery.select(mainRoot);

        countCriteriaBuilder = entityManager.getCriteriaBuilder();
        countCriteriaQuery = countCriteriaBuilder.createQuery(Long.class);
        countRoot = countCriteriaQuery.from(entityClass);
        countCriteriaQuery.select(countCriteriaBuilder.count(countRoot));
    }

    public TypedQuery<T> createMainQuery() {
        setUpParametersIfNeeded(mainCriteriaQuery, mainPredicatesManager, mainCriteriaBuilder);

        return entityManager.createQuery(mainCriteriaQuery);
    }

    public TypedQuery<Long> createCountQuery() {
        if(isOpenJPA()){
            CriteriaBuilder countCriteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> countCriteriaQuery = countCriteriaBuilder.createQuery(Long.class);
            Root<T> countRoot = countCriteriaQuery.from(entityClass);
            countCriteriaQuery.select(countCriteriaBuilder.count(countRoot));

            setUpParametersIfNeeded(countCriteriaQuery, countPredicatesManager, countCriteriaBuilder);
            return entityManager.createQuery(countCriteriaQuery);
        }

        setUpParametersIfNeeded(countCriteriaQuery, countPredicatesManager, countCriteriaBuilder);

        return entityManager.createQuery(countCriteriaQuery);
    }

    private void setUpParametersIfNeeded(CriteriaQuery criteriaQuery, PredicatesManager manager, CriteriaBuilder builder) {
        if (manager.hasValues()) {
            criteriaQuery.where(manager.getAllPredicates(builder));
        }
    }

    public void mainQueryOrderBy(List<Order> orders) {
        mainCriteriaQuery.orderBy(orders);
    }

    public boolean isOpenJPA() {
        return entityManager.toString().contains("openjpa");
    }

    public boolean isHibernate() {
        return entityManager.toString().contains("hibernate");
    }

    public void addAndPredicate(Predicate andPredicate, boolean pathForCount) {
        if (pathForCount) {
            countPredicatesManager.addAndPredicate(andPredicate);
            return;
        }

        mainPredicatesManager.addAndPredicate(andPredicate);
    }

    public void addOrPredicate(Predicate predicate, boolean pathForCount) {
        addOrPredicate(1, predicate, pathForCount);
    }

    public void addOrPredicate(int index, Predicate predicate, boolean pathForCount) {
        if (pathForCount) {
            countPredicatesManager.addOrPredicate(index, predicate);
            return;
        }

        mainPredicatesManager.addOrPredicate(index, predicate);
    }

    public void addAndSeparatedByOr(int index, Predicate predicate, boolean pathForCount) {
        if (pathForCount) {
            countPredicatesManager.addAndSeparatedByOr(index, predicate);
            return;
        }

        mainPredicatesManager.addAndSeparatedByOr(index, predicate);
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }
    
    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setDistinctTrue() {
        mainCriteriaQuery.distinct(true);
        countCriteriaQuery.distinct(true);
    }

    public Path getPath(String path, boolean pathForCount) {
        if (pathForCount) {
            return countRoot.get(path);
        }

        return mainRoot.get(path);
    }

    public Expression<String> lower(Path objectPath, boolean pathForLowerCase) {
        if (pathForLowerCase) {
            countCriteriaBuilder.lower(objectPath);
        }

        return mainCriteriaBuilder.lower(objectPath);
    }

    public CriteriaBuilder getCriteriaBuilder(boolean pathToCount) {
        if (pathToCount) {
            return countCriteriaBuilder;
        }

        return mainCriteriaBuilder;
    }

    public boolean joinsAreEmpty() {
        return mainJoins.isEmpty();
    }

    public boolean hasJoin(String joinName) {
        return mainJoins.containsKey(joinName);
    }

    public Join getJoin(String joinName, boolean pathForCount) {
        if (pathForCount) {
            return (Join) countJoins.get(joinName);
        }

        return (Join) mainJoins.get(joinName);
    }

    public Fetch getFetch(String joinName, boolean pathForCount) {
        if (pathForCount) {
            return (Fetch) countJoins.get(joinName);
        }

        return (Fetch) mainJoins.get(joinName);
    }

    public Root getRoot(boolean pathForCount) {
        if (pathForCount) {
            return countRoot;
        }

        return mainRoot;
    }

    public void putJoin(String currentPath, Join join, boolean pathForCount) {
        if(pathForCount){
            countJoins.put(currentPath, join);
            return;
        }

        mainJoins.put(currentPath, join);
    }

    public void putFetch(String currentPath, Fetch join, boolean pathForCount) {
        if (pathForCount) {
            countJoins.put(currentPath, join);
            return;
        }

        mainJoins.put(currentPath, join);
    }

    public boolean isJoinFetch(String pathWithoutAttribute) {
        Object object = countJoins.get(pathWithoutAttribute);

        return object instanceof Fetch;
    }
    
    
}
