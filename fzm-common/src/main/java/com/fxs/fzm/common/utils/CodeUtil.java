package com.fxs.fzm.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.Random;

public class CodeUtil {
	public static String getStackTrace(Exception ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

	public static void throwExcep(String msg) throws Exception {
		throw new Exception(msg);
	}

	public static boolean isEmpty(String param) {
		boolean success = true;
		if(null == param || "".equals(param.trim())) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public static boolean isNotEmpty(String param) {
		boolean success = true;
		if(null != param && !"".equals(param.trim())) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public static String parseString(Object object) {
		if(null == object) {
			return "";
		} else {
			return object.toString();
		}
	}

	public static Long parseLong(Object object) {
		Long obj = null;
		if(null != object) {
			try {
				obj = Long.parseLong(object.toString());
			} catch(Exception ex) {
				obj = null;
			}
		}
		return obj;
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

}
