package com.uaihebert.model;

import java.util.List;

public class EasyJoinStringIn {
    private String joinName;
    private String attributeName;
    private List<String> values;
    private boolean isIn;
    private boolean toLowerCase;

    private EasyJoinStringIn(){}

    public static EasyJoinStringIn newInstance(String joinName, String attributeName, List<String> values, boolean stringIn, boolean toLowerCase) {
        EasyJoinStringIn joinsStringIn = new EasyJoinStringIn();
        joinsStringIn.joinName = joinName;
        joinsStringIn.attributeName = attributeName;
        joinsStringIn.values = values;
        joinsStringIn.isIn = stringIn;
        joinsStringIn.toLowerCase = toLowerCase;
        return joinsStringIn;
    }

    public String getJoinName() {
        return joinName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public List<String> getValues() {
        return values;
    }

    public boolean isToLowerCase() {
        return toLowerCase;
    }

    public boolean isIn() {
        return isIn;
    }

    public boolean hasJoin(){
        return joinName != null;
    }
}