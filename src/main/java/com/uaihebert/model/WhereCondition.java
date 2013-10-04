package com.uaihebert.model;

public class WhereCondition {
    private final Object value;
    private final boolean toLowerCase;
    private final String attributeName;
    private final EasyConditionType type;

    public WhereCondition(Object value, boolean toLowerCase, String attributeName, EasyConditionType type) {
        this.value = value;
        this.toLowerCase = toLowerCase;
        this.attributeName = attributeName;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public boolean isToLowerCase() {
        return toLowerCase;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public boolean isGreaterThan() {
        return EasyConditionType.GT.equals(type);
    }

    public boolean isGreaterOrEqualTo() {
        return EasyConditionType.GE.equals(type);
    }

    public boolean isLessThan() {
        return EasyConditionType.LT.equals(type);
    }

    public boolean isLessOrEqualTo() {
        return EasyConditionType.LE.equals(type);
    }
}