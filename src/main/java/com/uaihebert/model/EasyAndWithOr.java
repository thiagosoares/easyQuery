package com.uaihebert.model;

public class EasyAndWithOr {
    private int index;
    private String attributeName;
    private Object value;
    private boolean toLowerCase;

    public static EasyAndWithOr newInstance(int index, String attributeName, Object value, boolean toLowerCase) {
        EasyAndWithOr easyAndWithOr = new EasyAndWithOr();
        easyAndWithOr.index = index;
        easyAndWithOr.attributeName = attributeName;
        easyAndWithOr.value = value;
        easyAndWithOr.toLowerCase = toLowerCase;
        return easyAndWithOr;
    }

    public int getIndex() {
        return index;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public Object getValue() {
        return value;
    }

    public boolean isToLowerCase() {
        return toLowerCase;
    }
}