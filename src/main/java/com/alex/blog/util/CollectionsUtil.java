//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alex.blog.util;

import java.util.*;

public class CollectionsUtil {
    public CollectionsUtil() {
    }

    public static Map<?, ?> emptyMap() {
        return Collections.EMPTY_MAP;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean notEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean notEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Object[] objects) {
        return Objects.isNull(objects) ? true : objects.length == 0;
    }

    public static boolean notEmpty(Object[] objects) {
        return !isEmpty(objects);
    }


    public static List<String> copyToList(Collection<String> source) {
        return new ArrayList(source);
    }
}
