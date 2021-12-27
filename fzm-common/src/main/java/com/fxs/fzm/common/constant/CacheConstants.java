package com.fxs.fzm.common.constant;

/**
 * Title: 缓存key
 * Description:
 * Copyright: Copyright (c) 2019-09-27 16:42:09
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: wj
 */
public class CacheConstants {
    public static final int TIMEOUT_MINUTE = 60;
    public static final int TIMEOUT_HOUR   = 60 * 60;
    public static final int TIMEOUT_DAY   = 24 * 60 * 60;
    public static final int TIMEOUT_MONTH = 31 * 24 * 60 * 60;
    public static final String NAME_SPACE = "::";

    public static final String CACHE_KEY_SEPARATOR = "_";
    public static final String CACHE_DEFAULT_VALUE = "-3";
    public static final String CACHE_DEFAULT_ALL = "all";

    /**
     * 缓存键值
     */
    public static final String Keys(Object... objects) {
        if (objects == null || objects.length <= 0) {
            return null;
        }

        StringBuffer rtn = new StringBuffer();
        for(int i=0;i<objects.length;i++){
            rtn.append(objects[i] == null ? "NULL" :objects[i].toString());
            if(rtn.lastIndexOf(CACHE_KEY_SEPARATOR)!=rtn.length()-CACHE_KEY_SEPARATOR.length()&&rtn.lastIndexOf(NAME_SPACE)!=rtn.length()-NAME_SPACE.length()&&i!=objects.length-1){
                rtn.append(CACHE_KEY_SEPARATOR);
            }
        }
        return rtn.toString();
    }

    /**
     * 缓存key部门uid
     */
    public static final String REDIS_KEY_DEPT_UID = "r_k_d_u" + CacheConstants.NAME_SPACE;
    /**
     * 通知根据orgId缓存
     */
    public static final String REDIS_KEY_APP_NOTICE_ID = "r_k_a_n_i" + CacheConstants.NAME_SPACE;

    /**
     * 启动页根据orgId缓存
     */
    public static final String REDIS_KEY_APP_STARTUP_PAGE_ID = "r_k_a_s_p_i" + CacheConstants.NAME_SPACE;

    /**
     * 板块根据orgId缓存
     */
    public static final String REDIS_KEY_PLATE_ID = "r_k_p_i" + CacheConstants.NAME_SPACE;

    /**
     *  服务根据orgId缓存
     */
    public static final String REDIS_KEY_SERVICE_MANAGE_ID = "r_k_s_m_i" + CacheConstants.NAME_SPACE;

    /**
     * 版本根据orgId缓存
     */
    public static final String REDIS_KEY_VERSION_ID = "r_k_v_i" + CacheConstants.NAME_SPACE;


    /**
     * 根据img_service_url查询字典表value值
     */
    public static final String REDIS_KEY_IMG_CODE = "r_k_img_code" + CacheConstants.NAME_SPACE;

    /**
     * 根据userUid+版本号查询用户初始化显示栏目数据
     */
    public static final String APP_DISPLAY_USER_NAVBAR_VERSION = "app_display_user_navbar_version" + CacheConstants.NAME_SPACE;

    /**
     * 根据deviceUid+版本号查询设备初始化显示栏目数据
     */
    public static final String APP_DISPLAY_DEVICE_NAVBAR_VERSION = "app_display_device_navbar_version" + CacheConstants.NAME_SPACE;

    /**
     * 根据userUid+版本号查询用户初始化隐藏栏目数据
     */
    public static final String APP_HIDE_USER_NAVBAR_VERSION = "app_hide_user_navbar_version" + CacheConstants.NAME_SPACE;

    /**
     * 根据deviceUid+版本号查询设备初始化隐藏栏目数据
     */
    public static final String APP_HIDE_DEVICE_NAVBAR_VERSION = "app_hide_device_navbar_version" + CacheConstants.NAME_SPACE;

    /**
     * 根据userUid+版本号查询当前用户显示版本号
     */
    public static final String APP_DISPLAY_USER_VERSION = "app_display_user_version" + CacheConstants.NAME_SPACE;

    /**
     * 根据deviceUid+版本号查询当前设备显示版本号
     */
    public static final String APP_DISPLAY_DEVICE_VERSION = "app_display_device_version" + CacheConstants.NAME_SPACE;

    /**
     * 根据userUid+版本号查询当前用户隐藏栏目版本号
     */
    public static final String APP_HIDE_USER_VERSION = "app_hide_user_version" + CacheConstants.NAME_SPACE;

    /**
     * 根据deviceUid+版本号查询当前设备隐藏栏目版本号
     */
    public static final String APP_HIDE_DEVICE_VERSION = "app_hide_device_version" + CacheConstants.NAME_SPACE;

    /**
     * 根据score_login_user+token查询当前登录用户
     */
    public static final String SCORE_LOGIN_USER = "score_login_user" + CacheConstants.NAME_SPACE;

}
