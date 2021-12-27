package com.fxs.fzm.common.utils;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtil {
    public static String parseString(Object object) {
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

    public static long parselong(Object object) {
        long ret = 0;
        if(null != object) {
            try {
                ret = Long.parseLong(object.toString());
            } catch(Exception ex) {
                ret = 0;
            }
        }
        return ret;
    }

    public static Integer parseInteger(Object object) {
        Integer obj = null;
        if(null != object) {
            try {
                obj = Integer.parseInt(object.toString());
            } catch(Exception ex) {
                obj = null;
            }
        }
        return obj;
    }
    public static Integer parseInteger(Object object,int defaultValue) {
        Integer obj = null;
        if(null != object) {
            try {
                obj = Integer.parseInt(object.toString());
            } catch(Exception ex) {
                obj = defaultValue;
            }
        }else{
            obj = defaultValue;
        }
        return obj;
    }

    public static int parseInt(Object object) {
        int obj = 0;
        if(null != object) {
            try {
                obj = Integer.parseInt(object.toString());
            } catch(Exception ex) {
                obj = 0;
            }
        }
        return obj;
    }

    public static Double parseDouble(Object object) {
        Double obj = null;
        if(null != object) {
            try {
                obj = Double.parseDouble(object.toString());
            } catch(Exception ex) {
                obj = null;
            }
        }
        return obj;
    }

    public static double parseDoubleValue(Object object) {
        double obj = 0;
        if(null != object) {
            try {
                obj = Double.parseDouble(object.toString());
            } catch(Exception ex) {
                obj = 0.0d;
            }
        }
        return obj;
    }

    public static Float parseFloat(Object object) {
        Float obj = null;
        if(null != object) {
            try {
                obj = Float.parseFloat(object.toString());
            } catch(Exception ex) {
                obj = null;
            }
        }
        return obj;
    }

    public static Float parseFloatValue(Object object) {
        Float obj = 0.0f;
        if(null != object) {
            try {
                obj = Float.parseFloat(object.toString());
            } catch(Exception ex) {
                obj = 0.0f;
            }
        }
        return obj;
    }

    /**
     * 在max和min之间获取一个随机数
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max) {
        int num = 0;
        try {
            Random random = new Random();
            num = random.nextInt(max)%(max-min+1) + min;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return num;
    }



    public static String format(double number) {
        DecimalFormat df=(DecimalFormat) DecimalFormat.getInstance();
        df.setMaximumFractionDigits(2);
        return df.format(number);
    }

    public static boolean isNumeric(String str) {
        if(StringUtils.isEmpty(str)){
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 获取集合里面的类的对象中某个字段用分隔符组合成字符串
     * 只支持简单类型的属�?，不支持复杂类型的属�?
     * @param list 对象集合
     * @param key 对象的字段名，要获取的�?对应的字�?
     * @param sperator 分隔�?
     * @return
     * @throws Exception
     */
    public static String parseString(List<? extends Object> list, String key, String sperator, Integer cutLen) throws RuntimeException {
        String results = "";
        try {
            if(null == cutLen) {
                cutLen = 1;
            }
            if(null != key && !"".equals(key.trim()) && 0 < key.trim().length()) {
                String firstLetter = key.substring(0, 1);
                String remainLetter = key.substring(1, key.length());
                String methodName = firstLetter.toUpperCase()+remainLetter;
                if(null != list) {
                    Iterator<? extends Object> iter = list.iterator();
                    Object obj = null;
                    String getMethod = "";
                    Method method = null;
                    Object value = null;
                    Field field = null;
                    while(iter.hasNext()) {
                        obj = iter.next();
                        try {
                            field = obj.getClass().getDeclaredField(key);
                        } catch(Exception ex) {
                            Class superCls = obj.getClass().getSuperclass();
                            field = superCls.getDeclaredField(key);
                        }
                        if(null != field) {
                            String name = field.getName();
                            if(null != name && !"".equals(name.trim()) && name.trim().equals(key.trim())) {
                                if(field.getType() == Boolean.TYPE) {
                                    getMethod = "is"+methodName;
                                } else {
                                    getMethod = "get"+methodName;
                                }
                                method = obj.getClass().getMethod(getMethod, new Class[] {});
                                value = method.invoke(obj, new Object[] {});
                                if(null != value) {
                                    results += value.toString()+sperator;
                                }
                            }
                        }
                    }
                }
            }
            if(null != results && !"".equals(results.trim()) && 0 < results.length()) {
                results = results.substring(0, results.length() - cutLen);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public static String parseString(List<? extends Object> list, String key, String sperator) throws RuntimeException {
        return ParseUtil.parseString(list, key, sperator, null);
    }

    /**
     * 将字符串集合转换成Long类型的集�?
     * @param string
     * @return
     */
    public static List<Long> parseStringToLongList(String string, String sperator) {
        List<Long> newList = new ArrayList<Long>();
        try {
            Long obj = null;
            String[] arr = string.split(sperator);
            for(String str : arr) {
                if(null != str && !"".equals(str.trim())) {
                    try {
                        obj = Long.parseLong(str.trim());
                        newList.add(obj);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return newList;
    }

    public static String parseLongListToString(Collection<Long> list, String sperator) {
        String results = "";
        try {
            if(null != list) {
                Iterator<Long> iter = list.iterator();
                Long obj = null;
                while(iter.hasNext()) {
                    obj = iter.next();
                    results += String.valueOf(obj);
                    if(iter.hasNext()) {
                        results += sperator;
                    }
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public static String parseIntegerListToString(List<Integer> list, String sperator) {
        String results = "";
        try {
            if(null != list) {
                Iterator<Integer> iter = list.iterator();
                Integer obj = null;
                while(iter.hasNext()) {
                    obj = iter.next();
                    results += String.valueOf(obj);
                    if(iter.hasNext()) {
                        results += sperator;
                    }
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    /**
     * 将list转化成map，�?过propertyName参数在list存放的对象中对应的类属�?的属性�?作为map的key
     * @param list �?��转换的对象集�?
     * @param propertyName 通过该�?在list存放的对象中取出的属性�?作为map的key
     * @return
     */
    public static Map<Object, Object> parseListToMap(List<? extends Object> list, String propertyName) {
        Map<Object, Object> map = new HashMap<Object, Object> ();
        if(null != list) {
            Iterator<? extends Object> iter = list.iterator();
            Object object = null;
            Object key = null;
            while(iter.hasNext()) {
                object = iter.next();
                if(null != object) {
                    key = BeanUtil.getValue(object, propertyName);
                    map.put(key, object);
                }
            }
        }
        return map;
    }

    /**
     * 将list转化成map，�?过propertyName参数在list存放的对象中对应的类属�?的属性�?作为map的key
     * @param list �?��转换的对象集�?
     * @param propertyName 通过该�?在list存放的对象中取出的属性�?作为map的key
     * @return
     */
    public static Map<? extends Object, ? extends Object> parseListToMap2(List<? extends Object> list, String propertyName) {
        Map<Object, Object> map = new HashMap<Object, Object> ();
        if(null != list) {
            Iterator<? extends Object> iter = list.iterator();
            Object object = null;
            Object key = null;
            while(iter.hasNext()) {
                object = iter.next();
                if(null != object) {
                    key = BeanUtil.getValue(object, propertyName);
                    map.put(key, object);
                }
            }
        }
        return map;
    }

    public static Long parseLong(Object obj) {
        if(null != obj) {
            if(obj instanceof Long) {
                return (Long) obj;
            }
            try {
                return Long.parseLong(obj.toString());
            } catch(Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * 将前端富文本编辑器的水印内容去除
     * @param content
     * @return
     */
    public static String filterFroalaEditor(String content) {
        if(StringUtils.isEmpty(content)) {
            return "";
        }
        String pattern = "Powered by.*<a.*>.*Froala Editor</a>";
        String replaceWord = "";
        Pattern p  = Pattern.compile(pattern);
        Matcher matcher = p.matcher(content);
        content = matcher.replaceAll(replaceWord);
        return content;
    }
}
