package com.uaihebert.model;

public class EasyJoinStringLike {
    private String joinName;
    private String attributeName;
    private String value;
    private boolean isLike;
    private boolean toLowerCase;

    private EasyJoinStringLike(){}

    public static EasyJoinStringLike newInstance(String joinName, String attributeName, String value, boolean like, boolean toLowerCase) {
        EasyJoinStringLike joinString = new EasyJoinStringLike();
        joinString.joinName = joinName;
        joinString.attributeName = attributeName;
        joinString.value = value;
        joinString.isLike = like;
        joinString.toLowerCase = toLowerCase;
        return joinString;
    }

    public String getJoinName() {
        return joinName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getValue() {
        return value;
    }

    public boolean isLike() {
        return isLike;
    }

    public boolean hasJoin(){
        return joinName != null;
    }

    public boolean isToLowerCase() {
        return toLowerCase;
    }
}