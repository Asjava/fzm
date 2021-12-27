package com.fxs.fzm.common.enums;

/**
 * 错误码枚举类
 * 1开头的代码的为注册
 * 2开头的代码为登录
 */
public enum ErrorCode {
    PLAYER_NON_EXISTENT(0, "用户不存在"),
    GAME_NON_EXISTENT(1, "游戏不存在"),
    GAME_ITEM_IS_EMPTY(2, "商品列表为空"),
    GAME_ITEM_NOT_FOUND(3, "商品未找到"),
    MESSAGE_IS_EMPTY(4, "消息为空"),
    COMMAND_IS_EMPTY(5, "指令为空"),
    UNKNOWN_ERROR(10000, "未知错误"),
    PROCESS_ERROR_EMPTY_RESULT(6, "处理异常，返回数据为空"),
    PROCESS_ERROR_EMPTY_DATA(7, "处理异常，需处理数据为空"),
    PROCESS_ERROR_PARAMETER_MISSING(8, "处理异常，参数缺失"),
    PROCESS_ERROR_PARAMETER_MISSING_PLAYER_ID(9, "处理异常，参数缺失playerId"),
    PROCESS_ERROR_PARAMETER_MISSING_SOCKET_ID(10, "处理异常，参数缺失socketId"),
    COMMON_CHANNEL_CODE_IS_EMPTY(101, "渠道号为空"),
    COMMON_CHANNEL_NON_EXISTENT(102, "渠道不存在"),
    COMMON_PHONE_PATTERN_ERROR(103, "手机号不正确"),
    COMMON_IDENTITY_PATTERN_ERROR(104, "身份证不正确"),
    COMMON_PASSWORD_PATTERN_ERROR(105, "密码不规范"),
    COMMON_GAME_CODE_IS_EMPTY(106, "游戏代码为空"),
    COMMON_EMPTY_ACCOUNT_NAME(107, "账号为空"),
    COMMON_EMPTY_TOKEN(108, "TOKEN为空"),
    COMMON_GAME_ITEM_NON_EXISTENT(109, "商品不存在"),
    COMMON_GAME_ITEM_ID_EMPTY(110, "商品ID为空"),
    REGISTER_PLAYER_EXISTENT(1002, "注册失败，用户已存在"),
    REGISTER_VALID_CODE_ERROR(1003, "验证码错误"),
    LOGIN_EMPTY_PWD_TOKEN(2001, "令牌和密码为空"),
    LOGIN_PWD_TOKEN_ERROR(2002, "令牌或密码错误"),
    ACCOUNT_EMPTY_PASSWORD(3001, "原有密码为空"),
    ACCOUNT_BIND_ERROR_PHONE_BOUND(3002, "手机号已被绑定，请先解绑"),
    VERIFICATION_CODE_SERIAL_NO_EMPTY(4001, "验证码序列号为空"),
    VERIFICATION_CODE_EMPTY_CODE(4002, "验证码为空"),
    VERIFICATION_CODE_ERROR_CODE(4003, "验证码不正确"),
    LOGGER_ERROR_TYPE(5001, "事件类型错误"),
    LOGGER_BODY_EMPTY(5002, "事件包体为空"),
    LOGGER_INFO_EMPTY(5003, "消息包体为空"),
    LOGGER_EVENT_NON_EXISTENT(5004, "事件类型不存在"),
    LOGGER_EVENT_DEVICE_ACTIVE_ERROR(5005, "激活异常"),
    LOGGER_EVENT_USER_ERROR(5006, "用户事件异常"),
    LOGGER_EVENT_PAY_ERROR(5007, "支付事件异常"),
    LOGGER_EVENT_ROLE_LOGIN_TODAY_LOGON(5008, "角色当天已登录"),
    PAY_ORDER_ID_EMPTY(6001, "订单号为空"),
    PAY_DETAIL_NON_EXISTENT(6002, "订单不存在"),

    BEAN_NAME_EMPTY(2301, "名称为空"),
    BEAN_SORT_EMPTY(2302, "序号为空"),
    BEAN_KEY_EMPTY(2303, "选择记录为空"),
    BEAN_MANAGER_EMPTY(2304, "管理员账户为空"),
    BEAN_ORG_EMPTY(2305, "机构为空"),
    BEAN_LOGIN_NAME_EMPTY(2306, "登录名为空"),
    BEAN_PWD_EMPTY(2307, "密码为空"),
    BEAN_DEPT_EMPTY(2308, "部门为空"),
    BEAN_ADMIN_EMPTY(2309, "是否管理员为空"),
    BEAN_MOBILE_EMPTY(2310, "手机号码为空"),
    BEAN_IDNUM_EMPTY(2311, "身份证号码为空"),
    BEAN_SEX_EMPTY(2312, "性别为空"),
    BEAN_AGE_EMPTY(2313, "年龄为空"),
    BEAN_UID_EMPTY(2314, "唯一码为空"),
    BEAN_STATUS_EMPTY(2315, "状态为空"),
    BEAN_IS_DELETE_EMPTY(2316, "是否删除为空"),
    BEAN_JOB_NUM_EMPTY(2317, "工号为空"),
    BEAN_ROLE_EMPTY(2318, "角色为空"),
    BEAN_TYPE_EMPTY(2319, "类型为空"),
    BEAN_SHOW_EMPTY(2320, "是否显示为空"),
    BEAN_URL_EMPTY(2321, "链接为空"),
    BEAN_IS_ORG_EMPTY(2322, "是否机构为空"),
    BEAN_ORIGINAL_NAME_EMPTY(2323, "原始名称为空"),
    BEAN_FILE_PATH_EMPTY(2324, "文件路径为空"),
    BEAN_RESOURCE_EMPTY(2325, "对应资源为空"),
    BEAN_MATERIAL_EMPTY(2326, "素材ID为空"),
    BEAN_FOLDER_EMPTY(2327, "文件夹ID为空"),
    BEAN_USER_EMPTY(2328, "用户ID为空"),

    EXCEPTION_HAVE_CHILD(3301, "下级非空"),
    EXCEPTION_UNDER_USER(3302, "下属人员非空"),
    EXCEPTION_UNDER_DEPT(3303, "下属部门非空"),
    EXCEPTION_EXISTS_LOGIN_NAME(3304, "登录名已存在"),
    EXCEPTION_EXISTS_DEPT_NAME(3305, "部门名称已存在"),
    EXCEPTION_EXISTS_NAME(3306, "名称已存在"),
    EXCEPTION_MOVE_NAME(3307, "偏移量只能为1或-1"),
    EXCEPTION_SHOW_NAME(3308, "是否显示只能为0或1"),
    EXCEPTION_EXISTS_JOB_NUM(3309, "工号已存在"),
    EXCEPTION_EXISTS_ID_CARD(3310, "身份证号码已存在"),
    EXCEPTION_EXISTS_MOBILE(3311, "手机号码已存在"),

    ERROR_PHONE(4301, "请输入正确的手机号码"),
    ERROR_ID_CARD(4302, "请输入正确的身份证号码"),
    ERROR_EMAIL(4302, "请输入正确的email地址"),
    ERROR_NUMBER(4302, "请输入正确的正整数"),

    ERROR_TITLE(4401,"请输入标题"),
    ERROR_CONTENT(4402,"请输入内容"),
    ERROR_TYPE(4403,"请选择状态"),
    ERROR_REQUIRE(4404,"请选择如何发布"),
    ERROR_PLAN_PUBLISH_TIME(4405,"请选择计划发布时间")
    ;
    private String value;
    private int index;
    private ErrorCode(int i, String value) {
        this.index = i;
        this.value = value;
    }

    public static int getByName(String name) {
        int index = -1;
        for(ErrorCode status: ErrorCode.values()) {
            if(status.value.equals(name)) {
                index = status.index;
                break;
            }
        }
        return index;
    }

    public static ErrorCode getByIndex(int index) {
        ErrorCode errorCode = null;
        for(ErrorCode code: ErrorCode.values()) {
            if(code.index == index) {
                errorCode = code;
                break;
            }
        }
        return errorCode;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return value;
    }
}
