package com.fxs.fzm.common.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Map;

public class MapUtils {

    public static Integer getInteger(Map map, Object key, Integer defaultValue ) {
        Integer answer = getInteger( map, key );
        if ( answer == null ) {
            answer = defaultValue;
        }
        return answer;
    }

    public static Integer getInteger(final Map map, final Object key) {
        Number answer = getNumber(map, key);
        if (answer == null) {
            return null;
        } else if (answer instanceof Integer) {
            return (Integer) answer;
        }
        return new Integer(answer.intValue());
    }

    public static Number getNumber(final Map map, final Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                if (answer instanceof Number) {
                    return (Number) answer;

                } else if (answer instanceof String) {
                    try {
                        String text = (String) answer;
                        return NumberFormat.getInstance().parse(text);

                    } catch (ParseException e) {
                        // failure means null is returned
                    }
                }
            }
        }
        return null;
    }
}
