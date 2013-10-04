package com.uaihebert.model;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

class PredicateGroup {
    private final List<Predicate> andPredicates = new ArrayList<Predicate>();
    private final List<Predicate> orPredicates = new ArrayList<Predicate>();

    public void addAndPredicate(Predicate predicate) {
        andPredicates.add(predicate);
    }

    public void addOrPredicate(Predicate predicate) {
        orPredicates.add(predicate);
    }

    public List<Predicate> getAndPredicates() {
        return andPredicates;
    }

    public List<Predicate> getOrPredicates() {
        return orPredicates;
    }
}
