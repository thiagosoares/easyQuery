package com.uaihebert.util;

import com.uaihebert.model.EntityPathHelper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public abstract class ReflectionUtil {

    private static final Logger LOG = Logger.getLogger("EasyCriteria");

    private static String getAttributeType(Class<?> entityClass, String attributeName) {
        if (attributeName == null || attributeName.isEmpty()) {
            throw new IllegalArgumentException("attributeName parameter cannot be null");
        }

        Field currentField = null;

        try {
            String[] paths = EntityPathHelper.extractPaths(attributeName);

            Class currentClass = entityClass;

            for(int i = 0; i < paths.length; i++){
                try{
                    Field foundField = currentClass.getDeclaredField(paths[i]);
                    if((i + 1) < paths.length){
                        currentClass = foundField.getType();

                        if(currentClass.equals(List.class) || currentClass.equals(Set.class) || currentClass.equals(Collection.class)){
                            Type genericType = foundField.getGenericType();

                            ParameterizedType aType = (ParameterizedType) genericType;
                            Type[] fieldArgTypes = aType.getActualTypeArguments();
                            currentClass = (Class) fieldArgTypes[0];
                        }
                    } else{
                        currentField = foundField;
                    }
                } catch (Exception e){
                    throw e;
                }
            }

        } catch (Exception e) {
            LOG.severe("We could not find the parameter: " + attributeName);
        }

        if(currentField != null){
            return currentField.getType().getCanonicalName();
        }

        throw new IllegalArgumentException("We could not find the parameter: " + attributeName + " in the given class: " + entityClass);
    }

    public static boolean isDouble(Class<?> entityClass, String attributeName) {
        final String attributeType = getAttributeType(entityClass, attributeName);

        return attributeType.toLowerCase().contains("double");
    }

    public static <T> boolean isFloat(Class<T> entityClass, String attributeName) {
        final String attributeType = getAttributeType(entityClass, attributeName);

        return attributeType.toLowerCase().contains("float");
    }

    public static <T> boolean isLong(Class<T> entityClass, String attributeName) {
        final String attributeType = getAttributeType(entityClass, attributeName);

        return attributeType.toLowerCase().contains("long");
    }

    public static <T> boolean isInteger(Class<T> entityClass, String attributeName) {
        final String attributeType = getAttributeType(entityClass, attributeName);

        return attributeType.toLowerCase().contains("integer") || attributeType.toLowerCase().equals("int");
    }

    public static <T> boolean isString(Class<T> entityClass, String attributeName) {
        final String attributeType = getAttributeType(entityClass, attributeName);

        return attributeType.toLowerCase().contains("string");
    }

    public static <T> boolean isDate(Class<T> entityClass, String attributeName) {
        final String attributeType = getAttributeType(entityClass, attributeName);

        return attributeType.toLowerCase().contains("util.date");
    }

    public static <T> boolean isCalendar(Class<T> entityClass, String attributeName) {
        final String attributeType = getAttributeType(entityClass, attributeName);

        return attributeType.toLowerCase().contains("calendar");
    }

    public static <T> boolean isList(Class<T> entityClass, String collectionName) {
        final String attributeType = getAttributeType(entityClass, collectionName);

        return attributeType.toLowerCase().contains("list");
    }

    public static <T> boolean isSet(Class<T> entityClass, String collectionName) {
        final String attributeType = getAttributeType(entityClass, collectionName);

        return attributeType.toLowerCase().contains("set");
    }

    public static <T> boolean isCollection(Class<T> entityClass, String collectionName) {
        final String attributeType = getAttributeType(entityClass, collectionName);

        return attributeType.toLowerCase().contains("collection");
    }

    public static <T> boolean isBigDecimal(Class<T> entityClass, String collectionName) {
        final String attributeType = getAttributeType(entityClass, collectionName);

        return attributeType.toLowerCase().contains("bigdecimal");
    }

    public static boolean isAcceptableCollection(Class<?> javaType) {
        return javaType.getCanonicalName().toLowerCase().contains("list") || javaType.getCanonicalName().toLowerCase().contains("set") || javaType.getCanonicalName().toLowerCase().contains("collection");
    }

    public static <T> boolean isNumber(Class<T> entityClass, String attributeName) {
        return isDouble(entityClass, attributeName) || isBigDecimal(entityClass, attributeName) || isFloat(entityClass, attributeName) || isInteger(entityClass, attributeName) || isLong(entityClass, attributeName);
    }
}