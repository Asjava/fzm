package com.fxs.fzm.common.cache.redis;

import org.springframework.util.StringUtils;

public class RedisKeyUtil {
    public static String NAMESPACE_SEPARATOR = "::";
    public static String DATA_SEPARATOR = "_";

    public static String getPrefixKey(Class cls, String... keys) {
        String prefix = cls.getSimpleName()+NAMESPACE_SEPARATOR;
        if(null != keys) {
            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                if (!StringUtils.isEmpty(key)) {
                    prefix += key + NAMESPACE_SEPARATOR;
                }
            }
        }
        return prefix;
    }

    public static String getValueKey(Object ...keys) {
        String valueKey = "";
        if(null != keys) {
            for (int i = 0; i < keys.length; i++) {
                String key = parseString(keys[i]);
                if (!StringUtils.isEmpty(key)) {
                    valueKey += key;
                }
                if(i + 1 < keys.length) {
                    valueKey += DATA_SEPARATOR;
                }
            }
        }
        return valueKey;
    }



    private static String parseString(Object object) {
        if(null == object) {
            return "";
        } else {
            if(object instanceof String) {
                return object.toString();
            } else if(object instanceof Long || object instanceof Integer
                    || object instanceof Double || object instanceof Float) {
                return String.valueOf(object);
            } else {
                return object.toString();
            }
        }
    }
}
