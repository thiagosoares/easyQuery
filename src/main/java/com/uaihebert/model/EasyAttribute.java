package com.uaihebert.model;

public class EasyAttribute {
    private String joinName;
    private String attributeName;
    private Object value;
    private EasyConditionType type;
    private boolean toLowerCase;

    private EasyAttribute(){}

    public static EasyAttribute newInstance(String joinName, String attributeName, Object value, EasyConditionType type, boolean toLowerCase) {
        EasyAttribute attribute = new EasyAttribute();
        attribute.joinName = joinName;
        attribute.attributeName = attributeName;
        attribute.value = value;
        attribute.type = type;
        attribute.toLowerCase = toLowerCase;
        return attribute;
    }

    public String getJoinName() {
        return joinName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public Object getValue() {
        return value;
    }

    public EasyConditionType getType() {
        return type;
    }

    public boolean isToLowerCase() {
        return toLowerCase;
    }
}