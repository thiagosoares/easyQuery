package com.uaihebert.model;

public class JoinIsEmpty {
    private final String joinName;
    private final String attributeName;
    private final boolean isEmpty;
    private final CollectionType type;

    public JoinIsEmpty(String joinName, String attributeName, boolean isEmpty, CollectionType type) {
        this.joinName = joinName;
        this.attributeName = attributeName;
        this.isEmpty = isEmpty;
        this.type = type;
    }

    public String getJoinName() {
        return joinName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public CollectionType getType() {
        return type;
    }
}