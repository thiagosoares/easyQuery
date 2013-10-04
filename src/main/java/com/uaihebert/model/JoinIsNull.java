package com.uaihebert.model;

public class JoinIsNull {
    private final String joinName;
    private final String attributeName;
    private final boolean isNull;

    public JoinIsNull(String joinName, String attributeName, boolean isNull) {
        this.joinName = joinName;
        this.attributeName = attributeName;
        this.isNull = isNull;
    }

    public String getJoinName() {
        return joinName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public boolean isNull() {
        return isNull;
    }
}