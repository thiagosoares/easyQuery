package com.uaihebert.model;

public class EasyOrEqualsIndex {
    private int index;
    private String attributeName;
    private Object[] values;
    private boolean equals;
    private boolean toLowerCase;

    private EasyOrEqualsIndex(){

    }

    public static EasyOrEqualsIndex newInstance(int index, String attributeName, boolean equals, Object[] values) {
        return newInstance(false, index, attributeName, equals, values);
    }

    public static EasyOrEqualsIndex newInstance(boolean toLowerCase, int index, String attributeName, boolean equals, Object[] values) {
        EasyOrEqualsIndex equalsIndex = new EasyOrEqualsIndex();
        equalsIndex.index = index;
        equalsIndex.attributeName = attributeName;
        equalsIndex.equals = equals;
        equalsIndex.values = values;
        equalsIndex.toLowerCase = toLowerCase;
        return equalsIndex;
    }

    public int getIndex() {
        return index;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public Object[] getValues() {
        return values;
    }

    public boolean isEquals() {
        return equals;
    }

    public boolean isToLowerCase() {
        return toLowerCase;
    }
}