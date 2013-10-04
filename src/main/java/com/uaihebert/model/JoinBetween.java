package com.uaihebert.model;

public class JoinBetween {
    private String joinName;
    private String attributeName;
    private Object valueA;
    private Object valueB;
    private boolean toLowerCase;

    private JoinBetween(){}

    public static JoinBetween newInstance(String joinName, String attributeName, Object valueA, Object valueB, boolean toLowerCase) {
        JoinBetween join = new JoinBetween();
        join.joinName = joinName;
        join.attributeName = attributeName;
        join.valueA = valueA;
        join.valueB = valueB;
        join.toLowerCase = toLowerCase;

        return join;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public Object getValueA() {
        return valueA;
    }

    public Object getValueB() {
        return valueB;
    }

    public String getJoinName() {
        return joinName;
    }

    public boolean isToLowerCase() {
        return toLowerCase;
    }
}