package com.fxs.fzm.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BeanUtil {
	public static Object copyBean(Object oldObj, Object newObj) {
		Field[] fieldArr = oldObj.getClass().getDeclaredFields();
		for(int i = 0; i < fieldArr.length; i ++) {
			Field field = fieldArr[i];
			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "";
			if(Boolean.TYPE.equals(field.getType())) {
				getMethodName = "is"+firstLetter+fieldName.substring(1);
			} else {
				getMethodName = "get"+firstLetter+fieldName.substring(1);
			}

			String setMethodeName = "set"+firstLetter+fieldName.substring(1);
			try {
				Method getMethod = oldObj.getClass().getMethod(getMethodName, new Class[] {});
				Method setMethod = newObj.getClass().getMethod(setMethodeName, new Class[] {field.getType()});
				Object value = getMethod.invoke(oldObj, new Object[] {});
				setMethod.invoke(newObj, new Object[] {value});
			} catch (NoSuchMethodException e) {
				continue;
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return newObj;
	}

	public static Object updateBean(Object oldObj, Object newObj) throws RuntimeException {
		try {
			Field[] fieldArr = newObj.getClass().getDeclaredFields();
			for(int i = 0; i < fieldArr.length; i ++) {
				Field field = fieldArr[i];
				String fieldName = field.getName();
				String firstLetter = fieldName.substring(0, 1).toUpperCase();
				String getMethodName = "";
				if(Boolean.TYPE.equals(field.getType())) {
					getMethodName = "is"+firstLetter+fieldName.substring(1);
				} else {
					getMethodName = "get"+firstLetter+fieldName.substring(1);
				}
				String setMethodeName = "set"+firstLetter+fieldName.substring(1);
				Method getMethod = newObj.getClass().getMethod(getMethodName, new Class[] {});
				Method setMethod = oldObj.getClass().getMethod(setMethodeName, new Class[] {field.getType()});
				Object value = getMethod.invoke(newObj, new Object[] {});
				if(null != value) {
					setMethod.invoke(oldObj, new Object[] {value});
				}
			}
		} catch(Exception ex) {
			ExceptionUtil.throwRuntimeException(ExceptionUtil.getStackTrace(ex));
		}
		return oldObj;
	}

	/**
	 * 更新实体类对象的集合
	 * 已持久化的对象和临时对象通过key对应的类属�?来获取对象中的属性�?，从而比对两个对象是否为同一条记�?
	 * 如果为同�?��记录，则将已持久化的对象和临时对象调用updateBean方法对对象进行更新，更新后复制给临时对象，存入temps
	 * 更新完对象之后，遍历paramMap中的值，将map中�?过key得到的value赋�?给更新后的对象对应key的属�?
	 * @param persists 已持久化的对象集合，会和temps集合中的对象对比，将temps中对应的对象更新后存入到新的集合中用于返�?
	 * @param temps 临时对象集合，会和persists中的对象对比，更新后存入新的集合中用于返�?
	 * @param key 对应类的属�?名，通过这个对比两个类对象是否为同一个对�?
	 * @param paramMap 要赋值给对象的属性集合，例如主键的id要统�?��置给集合的某个属�?
	 * @return 返回�?��的对象集�?
	 */
	public static List<? extends Object> updateBeans(List<? extends Object> persists, List<? extends Object> temps, String key, Map<String, ? extends Object> paramMap) {
		if(null == persists) {
			persists = new ArrayList<Object> ();
		}
		if(null == temps) {
			temps = new ArrayList<Object> ();
		}
		if(null == paramMap) {
			paramMap = new HashMap<String, Object> ();
		}
		List<Object> newList = new ArrayList<Object> ();
		Map<Object, Object> map = ParseUtil.parseListToMap(persists, "id");
		Iterator<? extends Object> iter = temps.iterator();
		Object object = null;
		Object persist = null;
		Object keyValue = null;
		while(iter.hasNext()) {
			object = iter.next();
			keyValue = BeanUtil.getValue(object, key);
			if(null != map.get(keyValue)) {
				persist = map.get(keyValue);
				if(null != persist) {
					if(persist.getClass().getName().equals(object.getClass().getName())) {
						object = BeanUtil.updateBean(persist, object);
					}
				}
			}
			Set<String> keySet = paramMap.keySet();
			Iterator<String> keyIter = keySet.iterator();
			String mapKey = null;
			while(keyIter.hasNext()) {
				mapKey = keyIter.next();
				BeanUtil.setValue(object, mapKey, paramMap.get(mapKey));
			}
			newList.add(object);
		}
		return newList;
	}

	/**
	 * 更新实体类对象的集合
	 * 已持久化的对象和临时对象通过key对应的类属�?来获取对象中的属性�?，从而比对两个对象是否为同一条记�?
	 * 如果为同�?��记录，则将已持久化的对象和临时对象调用updateBean方法对对象进行更新，更新后复制给临时对象，存入temps
	 * 更新完对象之后，遍历paramMap中的值，将map中�?过key得到的value赋�?给更新后的对象对应key的属�?
	 * @param persists 已持久化的对象集合，会和temps集合中的对象对比，将temps中对应的对象更新后存入到新的集合中用于返�?
	 * @param temps 临时对象集合，会和persists中的对象对比，更新后存入新的集合中用于返�?
	 * @param key 对应类的属�?名，通过这个对比两个类对象是否为同一个对�?
	 * @param paramMap 要赋值给对象的属性集合，例如主键的id要统�?��值给集合对象
	 * @param unSetKeys persists集合中的对象只要属�?在unSetKeys中的，则不对该属性进行更新，或�?只要temps里面的对象的属�?在unSetKeys中，则将该属性从persists中，将对应的属�?值设置到temps对象�?
	 * @return 返回�?��的对象集�?
	 */
	public static List<? extends Object> updateBeans(List<? extends Object> persists, List<? extends Object> temps, String key, Map<String, ? extends Object> paramMap, List<String> unSetKeys) {
		if(null == persists) {
			persists = new ArrayList<Object> ();
		}
		if(null == temps) {
			temps = new ArrayList<Object> ();
		}
		if(null == paramMap) {
			paramMap = new HashMap<String, Object> ();
		}
		List<Object> newList = new ArrayList<Object> ();
		Map<Object, Object> map = ParseUtil.parseListToMap(persists, "id");
		Iterator<? extends Object> iter = temps.iterator();
		Object object = null;
		Object persist = null;
		Object keyValue = null;
		while(iter.hasNext()) {
			object = iter.next();
			keyValue = BeanUtil.getValue(object, key);
			if(null != map.get(keyValue)) {
				persist = map.get(keyValue);
				if(null != persist) {
					if(persist.getClass().getName().equals(object.getClass().getName())) {
						/*
						 * 遍历不需要更新的属�?，将不需要更新的属�?从已经持久化的对象设置到新的对象�?
						 */
						if(null != unSetKeys) {
							Iterator<String> keyIter = unSetKeys.iterator();
							String column = null;
							while(keyIter.hasNext()) {
								column = keyIter.next();
								Object val = BeanUtil.getValue(persist, column);
								BeanUtil.setValue(object, column, val);
							}
						}
						object = BeanUtil.updateBean(persist, object);
					}
				}
			}
			Set<String> keySet = paramMap.keySet();
			Iterator<String> keyIter = keySet.iterator();
			String mapKey = null;
			while(keyIter.hasNext()) {
				mapKey = keyIter.next();
				BeanUtil.setValue(object, mapKey, paramMap.get(mapKey));
			}
			newList.add(object);
		}
		return newList;
	}

	/**
	 * 通过属�?key获取对象里面对应的属性�?
	 * @param object
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static Object getValue(Object object, String key) throws RuntimeException {
		Object value = null;
		try {
			String firstLetter = key.substring(0, 1);
			String remainLetter = key.substring(1, key.length());
			String methodName = firstLetter.toUpperCase()+remainLetter;
			Method method = null;
			String getMethod = "";
			Field field = null;
			try {
				try {
					field = object.getClass().getDeclaredField(key);
				} catch(Exception ex) {
					Class superCls = object.getClass().getSuperclass();
					field = superCls.getDeclaredField(key);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}

			if(null != field) {
				String name = field.getName();
				if(null != name && !"".equals(name.trim()) && name.trim().equals(key.trim())) {
					if(field.getType() == Boolean.TYPE) {
						getMethod = "is"+methodName;
					} else {
						getMethod = "get"+methodName;
					}
					method = object.getClass().getMethod(getMethod, new Class[] {});
					value = method.invoke(object, new Object[] {});
				}
			}
			/*if(null == value) {
				value = new Object();
			}*/
		} catch(Exception ex) {
			ExceptionUtil.throwRuntimeException(ExceptionUtil.getStackTrace(ex));
		}
		return value;
	}

	public static Class getFieldType(Object object, String key) throws RuntimeException {

		Field field = null;
		try {
			try {
				field = object.getClass().getDeclaredField(key);
			} catch(Exception ex) {
				Class superCls = object.getClass().getSuperclass();
				field = superCls.getDeclaredField(key);
			}
		} catch(Exception ex) {
			ExceptionUtil.throwRuntimeException(ExceptionUtil.getStackTrace(ex));
		}
		return field.getType();
	}

	public static Class getFieldType(Class clz, String key) throws RuntimeException {
		Field field = null;
		try {
			try {
				field = clz.getDeclaredField(key);
			} catch(Exception ex) {
				Class superCls = clz.getSuperclass();
				field = superCls.getDeclaredField(key);
			}
		} catch(Exception ex) {
			ExceptionUtil.throwRuntimeException(ExceptionUtil.getStackTrace(ex));
		}
		return field.getType();
	}



	/**
	 * 通过类的属�?名获取�?
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static Object setValue(Object object, String fieldName, Object value) throws RuntimeException {
		try {
			Field field = null;
			try {
				field = object.getClass().getDeclaredField(fieldName);
			} catch(Exception ex) {
				Class superCls = object.getClass().getSuperclass();
				field = superCls.getDeclaredField(fieldName);
			}
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String setMethodName = "set"+firstLetter+fieldName.substring(1);
			Method setMethod = object.getClass().getMethod(setMethodName, new Class[] {field.getType()});
			setMethod.invoke(object, new Object[] {value});
		} catch(Exception ex) {
			ExceptionUtil.throwRuntimeException(ExceptionUtil.getStackTrace(ex));
		}
		return value;
	}

	/**
	 * 设置集合中对象的�?
	 * @param list
	 * @param valueMap 存放集合中对象的属�?名对应的�?
	 * @throws RuntimeException
	 */
	public static void setValueBatch(List<? extends Object> list, Map<String, ? extends Object> valueMap) throws RuntimeException {
		try {
			if(null == list) {
				ExceptionUtil.throwException("Object collection IS NULL");
			}
			if(null == valueMap) {
				valueMap = new HashMap<String, Object> ();
			}
			Iterator<? extends Object> iter = list.iterator();
			Object object = null;
			while(iter.hasNext()) {
				object = iter.next();
				Set<String> keySet = valueMap.keySet();
				Iterator<String> keyIter = keySet.iterator();
				String key = null;
				while(keyIter.hasNext()) {
					key = keyIter.next();
					if(null != valueMap.get(key)) {
						BeanUtil.setValue(object, key, valueMap.get(key));
					}
				}
			}
		} catch(Exception ex) {
			ExceptionUtil.throwRuntimeException(ex);
		}
	}

	public static Object invokeMethod(Object obj, String method, Class<?>[] parameterTypes, Object[] parameters) throws Exception {
		Method m = obj.getClass().getMethod(method, parameterTypes);
		return m.invoke(obj, parameters);
	}

	public static void copyProperties(Object obj, Map<String, ? extends Object> map) {
		Field[] fieldArr = obj.getClass().getDeclaredFields();
		for(int i = 0; i < fieldArr.length; i ++) {
			Field field = fieldArr[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			Object value = map.get(fieldName);
			if(null != value) {
				if(Long.class.equals(fieldType)) {
					value = ParseUtil.parseLong(value);
				} else if(Integer.class.equals(fieldType)) {
					value = ParseUtil.parseInteger(value);
				} else if(Double.class.equals(fieldType)) {
					value = ParseUtil.parseDouble(value);
				} else if(String.class.equals(fieldType)) {
					value = ParseUtil.parseString(value);
				} else if(Float.class.equals(fieldType)) {
					value = ParseUtil.parseFloat(value);
				}
				BeanUtil.setValue(obj, fieldName, value);
			}
		}
	}

	public static boolean isExistField(Object object, String key) {
		Field field = null;
		try {
			try {
				field = object.getClass().getDeclaredField(key);
			} catch(Exception ex) {
				Class superCls = object.getClass().getSuperclass();
				field = superCls.getDeclaredField(key);
			}
		} catch(Exception e) {
		}
		return field != null ? true : false;
	}

	/*
	public static void main(String[] args) {
		List<ReimburseContent> contents = new ArrayList<ReimburseContent> ();
		for(long i = 0; i < 5; i ++) {
			ReimburseContent content = new ReimburseContent();
			content.setId(i);
			content.setContent("abc+"+i);
			contents.add(content);
		}
		for(long i = 0; i < 5; i ++) {
			ReimburseContent content = new ReimburseContent();
			content.setId(i);
			content.setContent("def+"+i);
			contents.add(content);
		}
		System.out.println(BeanUtil.parseString(contents, "id", ","));
	}*/
}
