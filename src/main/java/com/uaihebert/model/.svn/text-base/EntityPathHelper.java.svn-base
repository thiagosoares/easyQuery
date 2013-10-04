package com.uaihebert.model;

public abstract class EntityPathHelper {
    /**
     * Returns path without attribute and last dot
     *
     * @param paths path to be extracted
     * @param getLastAttribute show bring the last item of the path
     * @return joins path only
     */
    static String extractJoinsPathIfNeeded(String paths[], boolean getLastAttribute) {
        String path = createPathFromArrayOfPaths(paths);
        return extractJoinsPathIfNeeded(path, getLastAttribute);
    }
    /**
     * Returns path without attribute and last dot
     *
     * @param path path to be extracted
     * @param getLastAttribute show bring the last item of the path
     * @return joins path only
     */
    static String extractJoinsPathIfNeeded(String path, boolean getLastAttribute) {
        String[] paths = extractPaths(path);

        if(paths.length == 1){
            return paths[0];
        }

        String fullPath = "";

        int length = getLastAttribute ? paths.length : (paths.length - 1);

        for (int i = 0; i < length; i++) {
            if("null".equals(paths[i])){
                break;
            }
            fullPath += paths[i] + ".";
        }

        return fullPath.substring(0, fullPath.length() - 1);
    }

    static String createPathFromArrayOfPaths(String[] paths){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < (paths.length); i++) {
            builder.append(paths[i] + ".");
        }

        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    static String extractAttributeFromJoins(String path) {
        String[] paths = path.split("\\.");
        return paths[paths.length - 1];
    }

    public static boolean hasMultipleJoins(String path) {
        return path.split("\\.").length > 1;
    }

    public static String[] extractPaths(String path) {
        return path.split("\\.");
    }
}