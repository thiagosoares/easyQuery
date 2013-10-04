package com.uaihebert.model;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PredicatesManager {
    private final Map<Integer, PredicateGroup> predicates = new HashMap<Integer, PredicateGroup>();
    private final Map<Integer, PredicateGroup> andWithOrPredicates = new HashMap<Integer, PredicateGroup>();

    public void addAndPredicate(Predicate predicate) {
        addAndPredicate(1, predicate);
    }

    public void addAndPredicate(int index, Predicate predicate) {
        PredicateGroup predicateGroup = predicates.get(index);

        if(predicateGroup == null){
            predicateGroup = new PredicateGroup();
            predicates.put(index, predicateGroup);
        }

        predicateGroup.addAndPredicate(predicate);
    }

    public void addOrPredicate(int index, Predicate predicate) {
        PredicateGroup predicateGroup = predicates.get(index);

        if(predicateGroup == null){
            predicateGroup = new PredicateGroup();
            predicates.put(index, predicateGroup);
        }

        predicateGroup.addOrPredicate(predicate);
    }

    public Predicate[] getAllPredicates(CriteriaBuilder criteriaBuilder) {
        List<Predicate> allPredicates = new ArrayList<Predicate>();

        for(PredicateGroup predicateGroup : predicates.values()){
            List<Predicate> andPredicates = predicateGroup.getAndPredicates();

            if(!andPredicates.isEmpty()){
                allPredicates.add(criteriaBuilder.and(andPredicates.toArray(new Predicate[andPredicates.size()])));
            }

            List<Predicate> orPredicates = predicateGroup.getOrPredicates();

            if(!orPredicates.isEmpty()){
                allPredicates.add(criteriaBuilder.or(orPredicates.toArray(new Predicate[orPredicates.size()])));
            }
        }

        if(!andWithOrPredicates.isEmpty()){
            List<Predicate> allAndOrPredicates = new ArrayList<Predicate>();

            for(PredicateGroup predicateGroup : andWithOrPredicates.values()){
                List<Predicate> andPredicates = predicateGroup.getAndPredicates();

                allAndOrPredicates.add(criteriaBuilder.and(andPredicates.toArray(new Predicate[andPredicates.size()])));
            }

            allPredicates.add(criteriaBuilder.or(allAndOrPredicates.toArray(new Predicate[allAndOrPredicates.size()])));
        }

        return allPredicates.toArray(new Predicate[allPredicates.size()]);
    }

    public boolean hasValues() {
        return !predicates.isEmpty() || !andWithOrPredicates.isEmpty();
    }

    public void addAndSeparatedByOr(int index, Predicate predicate) {
        PredicateGroup predicateGroup = andWithOrPredicates.get(index);

        if(predicateGroup == null){
            predicateGroup = new PredicateGroup();
            andWithOrPredicates.put(index, predicateGroup);
        }

        predicateGroup.addAndPredicate(predicate);
    }
}
