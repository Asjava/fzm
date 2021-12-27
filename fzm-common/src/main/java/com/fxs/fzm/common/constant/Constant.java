package com.fxs.fzm.common.constant;

public class Constant {
    public final static String PAGE_NUM = "pageNum";   //当前页码
    public final static String PAGE_SIZE = "pageSize";   //当前页显示总数
    public final static String TOTAL = "total"; //返回前端分页的总条数
    public final static String ROWS = "rows";   //返回前端分页的行数
    public final static String LIMIT = "limit"; //数据库中查询的数量
    public final static String START = "start"; //数据库中分页查询的开始值d
    public final static Integer PAGE_SIZE_VALUE = 20;   //如果pageSize没值，则默认初始化为20
    public final static Integer PAGE_NUM_VALUE = 1;   //如果pageNum没值，则默认初始化为1
    public final static String ENCODE_MODE = "UTF-8";
    public final static String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    public final static String LOGIN_USER = "loginUser";
    /****返回前端的基本参数设置****/
    public final static String RESULT_MSG = "msg";  //返回前端的消息提示
    public final static String RESULT_CODE = "code"; //返回前端成功失败的标识符
    public final static String RESULT_DATA = "data"; //返回前端存放数据的key
    public final static Integer RESULT_CODE_FAILURE = 0; //返回前端失败，如success:0
    public final static Integer RESULT_CODE_SUCCESS = 1; //返回前端成功，如success:1
    public final static Integer RESULT_CODE_NO_LONGIN = 2; //返回前端成功，如success:1
    public final static String RESULT_MSG_UPDATE_SUCCESS = "更新成功"; //返回前端更新成功提示
    public final static String RESULT_MSG_UPDATE_FAILURE = "更新失败"; //返回前端更新失败提示
    public final static String RESULT_MSG_ADD_SUCCESS = "新增成功"; //返回前端新增成功提示
    public final static String RESULT_MSG_ADD_FAILURE = "新增失败"; //返回前端新增失败提示
    public final static String RESULT_MSG_QUERY_SUCCESS = "查询成功"; //返回前端查询成功提示
    public final static String RESULT_MSG_QUERY_FAILURE = "查询失败"; //返回前端查询失败提示
    public final static String RESULT_MSG_DELETE_SUCCESS = "删除成功";
    public final static String RESULT_MSG_DELETE_FAILURE = "删除失败";
    public final static String RESULT_MSG_NO_PERMIT = "权限不足";

    /****前端的资源申请****/
    public final static String PARAM_KEY_TOKEN = "token";
    public final static String TOKEN_SECRET_KEY = "1234567891234567";   //AES算法，必须16位

    /****生成登录token的key****/
    public final static String TOKEN_KEY_UID = "uid";
    public final static String TOKEN_KEY_LOGIN_NAME = "loginName";
    public final static String TOKEN_KEY_EXPIRE = "expire";
    public final static String TOKEN_KEY_SIGNATURE = "signature";

    /*个人素材默认收藏文件夹*/
    public final static String USER_FOLDER_DEFALUT_NAME = "收藏夹";
    public final static String ORG_FOLDER_DEFALUT_NAME = "分享";

    /*redis数据*/
    public final static String REDIS_KEY_DEPT_PID_MAP = "deptPidMap";
    public final static String REDIS_KEY_DEPT_ID_MAP = "deptIdMap";
    public final static String REDIS_KEY_SHIELD_WORDS = "redisShieldWords";
    /*存Redis 3天的秒数*/
    public final static long REDIS_TIME_OUT_THREE_DAYS = 259200L;
    /*存Redis 60000毫秒数*/
    public final static long REDIS_TIME_OUT_ONE_SECOND = 60000L;

    /****一些字典的主键ID****/
    public final static Long DICT_TOKEN_EXPIRE_VALID_PERIOD = 1L; //登录有效时长，单位分钟
    public final static Long DICT_PUBLISH_START_CONTENT = 2L; //直播间起始默认互动内容
    public final static Long DICT_PUBLISH_END_CONTENT = 3L; //直播间结束默认互动内容
    public final static String DICT_FUFU_DOC_FROM = "fufu_docFrom"; //福富融媒体中心
    public final static Long IS_TOP_PID = 0L; //最上级父类PID

    /****平台主系统UID****/
    public final static String mainSystemUid = "cm-cms-server";

    /****发送邮件的账号 不带后缀****/
    public final static String SEND_CODE_HALF_EMAIL_USERNAME = "962693482";
    /****发送邮件的账号 不带后缀****/
    public final static String SEND_CODE_ALL_EMAIL_USERNAME = "962693482@qq.com";
    /****发送邮件的授权密码****/
    public final static String SEND_CODE_EMAIL_PASSWORD = "ymhmjobihlxibeba";
    /****发送邮件服务器  qq****/
    public final static String SEND_CODE_EMAIL_HOST = "smtp.qq.com";
    /****发送邮件服务器端口  qq****/
    public final static String SEND_CODE_EMAIL_PORT = "465";
    /****发送邮件验证码有效时间  1小时****/
    public final static int SEND_CODE_ABLE_TIME = 1000 * 60 * 60;
    /****发送邮件注册码  ****/
    public final static String EMAIL_SEND_REGIST_CODE = "EMAIL_SEND_REGIST_CODE";
    /****发送邮件重置码  ****/
    public final static String EMAIL_SEND_RESET_CODE = "EMAIL_SEND_RESET_CODE";
    /****发送绑定邮件验证码  ****/
    public final static String EMAIL_SEND_UPDATE_CODE = "EMAIL_SEND_UPDATE_CODE";
    /****发送解绑邮件验证码  ****/
    public final static String EMAIL_SEND_LOCK_CODE = "EMAIL_SEND_LOCK_CODE";
    /****邮箱验证格式  ****/
    public final static String EMAIL_REGEX = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    /*****  超时时间 ********/
    public final static Integer HTTP_OUT_TIME = 1000 * 40;
    /*****密码正则 "密码由6-21字母和数字组成，不能是纯数字或纯英文" *****/
    public final static String REGEX_PSD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
    /*****手机号正则 *****/
    public final static String REGEX_PHONE = "(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8}";

    /***邮件验证码状态：1使用0未使用****/
    public static class EmailStatus {
        public final static Integer STATUS_O = 0;
        public final static Integer STATUS_1 = 1;
    }

    /***邮件验证码类型：0：注册邮件验证码;1:重置邮件验证码;2:绑定邮箱验证码。3:解绑邮箱验证码****/
    public static class EmailType {
        public final static Integer TYPE_O = 0;
        public final static Integer TYPE_1 = 1;
        public final static Integer TYPE_2 = 2;
        public final static Integer TYPE_3 = 3;
    }

    /****删除状态：1是0否****/
    public static class DeleteStatus {
        public final static Integer YES = 1;
        public final static Integer NO = 0;
    }

    /****显示状态：1是0否****/
    public static class IsShow {
        public final static Integer YES = 1;
        public final static Integer NO = 0;
    }

    /****显示状态：1是0否****/
    public static class PackingStatus {
        public final static Integer ONPACKING = 0;
        public final static Integer FINISH = 2;
        public final static Integer ONLINE = 3;
        public final static Integer FAIL = 3;
    }

    /****固定状态：1是0否****/
    public static class IsFixed {
        public final static Integer YES = 1;
        public final static Integer NO = 0;
    }

    /****栏目状态：0：隐藏栏目，1：我的栏目****/
    public static class IsDisplay {
        public final static Integer YES = 1;
        public final static Integer NO = 0;
    }

    /****资源ID****/
    public static class TypeId {
        public final static Integer MENU = 0;
        public final static Integer MENU_TYPE = 1;
    }

    /****启动状态****/
    public static class OpenStatus {
        public final static Integer CLOSE = 0;
        public final static Integer OPEN = 1;
    }

    /****勾选状态****/
    public static class CheckStatus {
        public final static Boolean NO = false;
        public final static Boolean YES = true;
    }

    /****状态****/
    public static class Status {
        public final static Integer NO = 0;
        public final static Integer YES = 1;
    }

    /****必填contentId,积分规则名****/
    public static class contentName {
        public final static String SUBJECT = "200810174212695986";
        public final static String VIDEO = "200810174217758481";
    }

    /****用户状态****/
    public static class UserRole {
        public final static Integer COM_USER = 0;
        public final static Integer SUPER_ADMIN = 1;
    }

    /****文件类型****/
    public static class FileType {
        public final static Integer IMAGE_TEXT = 0; // 图文
        public final static Integer PICTURE = 1; // 图片
        public final static Integer VIDEO = 2; // 视频
        public final static Integer AUDIO = 3; // 音频
    }

    /****稿件状态****/
    public static class SubjectStatus {
        public final static Integer EDITING = 0; // 编辑中
        public final static Integer AUDIT = 1; // 待审核
        public final static Integer SUBJECT_RECYCLE = 2; // 稿件回收站
        public final static Integer AUDIT_FAILED = 3; // 审核不通过
        public final static Integer AUDIT_APPROVAL = 4; // 审核通过
        public final static Integer PUBLISHED = 5; // 已发布
        public final static Integer PUBLISH_RECYCLE = 6; // 稿件回收站
    }

    public static class LiveStatus {
        public final static Integer NOT_LIVE = 0; // 未直播
        public final static Integer ON_LIVE = 1; // 直播中
        public final static Integer END_LIVE = 2; // 直播结束
    }

    /****稿件状态****/
    public static class AfficheStatus {
        public final static Integer EDITING = 0; // 编辑中
        public final static Integer AUDIT = 1; // 待审核
        public final static Integer AUDIT_APPROVAL = 2; // 待发布
        public final static Integer PUBLISHED = 3; // 已发布
        public final static Integer AUDIT_FAILED = 4; // 不通过
        public final static Integer RECALL = 5; // 撤回
    }

    /****是否顶置****/
    public static class isTopStatus {
        public final static Integer NOTOP = 0; // 不顶置
        public final static Integer TOP = 1; // 顶置
    }

    /****是否更新****/
    public static class isUpdate {
        public final static Integer NOUPDATE = 0; // 不更新
        public final static Integer UPDATE = 1; // 更新
    }

    /****更新状态****/
    public static class versionType {
        public final static Long DEBUG = 1L; // 开发版
        public final static Long BETA = 2L; // 测试版
        public final static Long RELEASE = 3L; // 正式版
    }

    /****打包状态****/
    public static class packStatus {
        public final static Integer NOPACK = 0; // 未打包
        public final static Integer PACKSUCCESS = 1; // 打包成功
        public final static Integer PACKFAIL = 2; // 打包成功
    }

    /**** 通知状态 ****/
    public static class NoticeStatus {
        public final static Integer EDITING = 0; // 编辑中
        public final static Integer AUDIT = 1; // 待审核
        public final static Integer REDYPUBLISH = 2; // 待发布
        public final static Integer PUBLISHED = 3; // 已发布
        public final static Integer AUDIT_FAILED = 4; // 不通过
        public final static Integer WITHDRAW = 5; // 撤回
    }

    /*** 爆料状态 ****/
    public static class DiscloseStatus {
        public final static Integer AUDIT = 0; // 待审核
        public final static Integer AUDIT_APPROVAL = 1; // 审核通过
        public final static Integer AUDIT_FAILED = 2; // 不通过
        public final static Integer RECEIVE = 3;//已处理
    }

    /*** 用户消息类别 ***/
    public static class AppMessageType {
        public final static Long SYSTEM = 0L; // 0：系统
        public final static Long NOTICE = 1L; // 1：通知
        public final static Long DISCLOSE = 2L; // 2：爆料
        public final static Long FEEDBACK = 3L; // 3：意见反馈
        public final static Long COMMENT = 4L; // 4：评论
        public final static Long SNAPSHOTCOMMENT = 5L; // 5：随手拍评论
        public final static Long ASK = 6L; // 6：有事问
        public final static Long LAW = 7L; // 7: 法律咨询
        public final static Long SOCIALCOMMENT = 9L;//圈子评论
    }

    /**
     * 用户消息
     **/
    public static class AppMessageContent {
        public final static String DISCLOSE_AUDIT_APPROVAL = "你的爆料已采纳，感谢你的支持。"; // 爆料审核通过
        public final static String DISCLOSE_AUDIT_FAILED = "很遗憾，你的爆料未采纳，期待你下一次更精彩的爆料。";// 爆料审核不通过
        public final static String DISCLOSE_ADD_APPROVAL = "留言成功，审核后可查看。";// 爆料新增成功
        public final static String NEW_COMMENT = "你有最新评论回复，快去看看吧。"; //有回复评论
        public final static String NEW_FEEDBACK = "你的意见反馈我们已收到，感谢你的支持，我们会继续努力。"; //意见反馈新增
        public final static String COMMENT_AUDIT_FAILED = "很遗憾，您的评论有敏感词汇不予以公开，期待您下次的精彩评论。";//评论审核不通过
        public final static String SNAPSHOT_AUDIT_APPROVAL = "你的随手拍已采纳，感谢你的支持。"; // 随手拍审核通过
        public final static String SNAPSHOT_AUDIT_FAILED = "很遗憾，你的随手拍未采纳，期待你下一次更精彩的爆料。";// 随手拍审核不通过
        public final static String NEW_SNAPSHOTCOMMENT = "你有最新随手拍的评论回复，快去看看吧。"; //随手拍有回复评论
        public final static String SNAPSHOTCOMMENT_AUDIT_FAILED = "很遗憾，您的随手拍评论有敏感词汇不予以公开，期待您下次的精彩评论。";//随手拍评论审核不通过
        public final static String ASK_AUDIT_APPROVAL = "你的有事问已采纳，感谢你的支持。"; // 有事问审核通过
        public final static String ASK_AUDIT_FAILED = "很遗憾，你的有事问未采纳，期待你下一次的提问。";// 有事问审核不通过
        public final static String NEW_ASKCOMMENT = "你有最新有事问的评论回复，快去看看吧。"; //有事问有回复评论
        public final static String ASKCOMMENT_AUDIT_FAILED = "很遗憾，您的有事问评论有敏感词汇不予以公开，期待您下次的精彩评论。";//有事问评论审核不通过
        public final static String LAW_AUDIT_APPROVAL = "你的法律咨询已收到，感谢你的支持。"; // 法律咨询审核通过
        public final static String LAW_AUDIT_FAILED = "很遗憾，你的法律咨询未采纳，期待你下一次的咨询。";// 有事问审核不通过
    }

    /**
     * 短信模版
     **/
    public static class SmsTemplate {
        //验证码
        public final static String CODE = "1";
    }

    /**
     * 启动页类型
     **/
    public static class StatupPageType {
        // 启动页
        public final static Integer TYPE_0 = 0;
        // 广告页
        public final static Integer TYPE_1 = 1;
        // 产品介绍页
        public final static Integer TYPE_2 = 2;
    }

    public static class TaskLockName {
        /**
         * 定时查询天气
         */
        public static final String APP_WEATHER_TASK = "APP_WEATHER_TASK";

    }

    /**
     * 请求前缀
     **/
    public final static String REQUEST_PREFIX = "/api/v1";
    /**
     * 字典表中图片服务地址
     **/
    public final static String  DICT_IMG_SERVICE_URL = "img_service_url";
    /**
     * 字典表中图片服务地址
     **/
    public final static String  DICT_NEWDETAIL = "newsDetail";
    /**
     * 字典表中头像默认code
     **/
    public final static String DICT_DEFAULT_AVATAR = "default_avatar";
    /**
     * 稿件的转义字符
     **/
    public final static String REGEX_IMG_SERVICE_URL = "$img_service_url$";
    /**
     * 字典表中图片服务地址
     **/
    public final static String DICT_START_PAGE_URL = "start_page_url";
    /**
     * 机构默认路径
     **/
    public final static String DEFAULT_LOGO_URL = "/static/layout/logo.png";

    /**
     * 图片请求前缀
     **/
    public final static String PICTURE = "picture";
    /**
     * 专题默认图片
     **/
    public final static String SPECIAL_DEFAULT_IMG_URL = REGEX_IMG_SERVICE_URL + "picture/201910/img/1910243125.png";

    /****表名****/
    public static class Tables {
        public final static String TBL_CMS_SUBJECT = "tbl_cms_subject";
    }


    /****组件类型 0：栏目，1：轮播，2：消息，3：板块，4：专题，5：新闻， 6:三图新闻，15：广告，17：小视频，18：横板，19：路由，20：活动****/
    public static class ModuleType {
        public final static Integer NAVBAR = 0;
        public final static Integer CAROUSEL = 1;
        public final static Integer NOTICE = 2;
        public final static Integer PLATE = 3;
        public final static Integer SPECIAL = 4;
        public final static Integer SUBJECT = 5;
        public final static Integer NEWSUBJECT = 6;
        public final static Integer ADVERTISEMENT = 15;
        public final static Integer TINYRVIDEO = 17;
        public final static Integer HORIZONTAL = 18;
        public final static Integer ROUTE = 19;
        public final static Integer INTERACTIVE = 20;
    }

    public static class UI {
        public final static String CODE_001 = "CAROUSEL-001";
        public final static String CODE_002 = "CAROUSEL-002";
        public final static String CODE_003 = "CAROUSEL-003";
        public final static String CODE_004 = "CAROUSEL-004";
        public final static String CODE_005 = "CAROUSEL-005";
        public final static String CODE_006 = "CAROUSEL-006";
        public final static String CODE_007 = "CAROUSEL-007";
        public final static String CODE_008 = "CAROUSEL-008";
        public final static String CODE_009 = "CAROUSEL-009";
    }

    public static class UIId {
        public final static Long CAROUSEL_001 = 1L;
        public final static Long CAROUSEL_002 = 2L;
        public final static Long CAROUSEL_003 = 3L;
        public final static Long CAROUSEL_004 = 4L;
        public final static Long CAROUSEL_005 = 5L;
        public final static Long CAROUSEL_006 = 6L;
        public final static Long CAROUSEL_007 = 7L;
        public final static Long CAROUSEL_008 = 8L;
        public final static Long CAROUSEL_009 = 9L;

    }

    public static class ImgSuffixType {
        public final static String JPG = "jpg";
        public final static String PNG = "png";
    }

    public static class CpName {
        /**
         * 数据库name
         */
        public static final String YUN_SHI = "云视";
        /**
         * 红色联盟CP名字
         */
        public static final String RED_CP_NAME = "红色联盟";
        /**
         * 红色联盟CP名字
         */
        public static final String RED_CP_NAME_8010 = "红色联盟8010";

        /**
         * 红色联盟CP名字
         */
        public static final String RED_CP_NAME_8040 = "红色联盟8040";
    }

    public static class IsRun {
        //红色联盟
        public static final Integer IS_RUN_3 = 3;
        //云视
        public static final Integer IS_RUN_2 = 2;
        //新华网rss
        public static final Integer IS_RUN_4 = 4;

    }

    public static class TVAndRadioMenuDay {
        public static final int PASSDAY = 9;
        public static final int DAY = 3;
    }

    // 供校验的表头样式
    public static class checkExcelIsRight {
        // 电视频道
        public static final String[] TELEVISION_SHEET_HEAD = {"名称", "连接"};
        public static final String[] TELEVISION_SHEET_HEAD_OTHER = {"name", "url"};
        //  电视节目
        public static final String[] TELEVISION_MENU_SHEET_HEAD = {"名称", "播放时间"};
        public static final String[] TELEVISION_MENU_SHEET_HEAD_OTHER = {"name", "menuTime"};
        // 广播频道
        public static final String[] RADIO_SHEET_HEAD = {"名称", "连接", "频道"};
        public static final String[] RADIO_SHEET_HEAD_OTHER = {"name", "url", "radioChannel"};
        // 广播节目
        public static final String[] RADIO_MENU_SHEET_HEAD = {"名称", "播放时间"};
        public static final String[] RADIO_MENU_SHEET_HEAD_OTHER = {"name", "menuDate"};
        //电视历史节目
        public static final String[] TELEVISION_HISTROY_SHEET_HEAD = {"标题", "连接", "节目名", "历史时间"};
        public static final String[] TELEVISION_HISTROY_SHEET_HEAD_OTHER = {"title", "url", "menuName", "histroyTime"};
        //电视默认节目
        public static final String[] TELEVISION_DEFAULT_SHEET_HEAD = {"节目名", "周数", "播放时间"};
        public static final String[] TELEVISION_DEFAULT_SHEET_HEAD_OTHER = {"name", "week", "menuTime"};
        //广播默认节目
        public static final String[] RADIO_DEFAULT_SHEET_HEAD = {"节目名", "周数", "播放时间"};
        public static final String[] RADIO_DEFAULT_SHEET_HEAD_OTHER = {"name", "week", "menuTime"};
    }

    // 储存空间
    public static class storageSpace {
        //
        public final static String default_space = "10G";
        public final static String warn_percen = "90";
        public final static Integer TYPE_0 = 0;
        public final static Integer TYPE_1 = 1;
        public final static Integer TYPE_2 = 2;

    }

    /*** 随手拍状态 ****/
    public static class SnapshotStatus {
        public final static Integer AUDIT = 0; // 待审核
        public final static Integer AUDIT_APPROVAL = 1; // 审核通过
        public final static Integer AUDIT_FAILED = 2; // 不通过

        public final static String APPROVAL = "APPROVAL"; // 点赞
        public final static String VIEW = "VIEW"; // 浏览
        public final static String SHARE = "SHARE"; // 分享

    }


    /*** 有事问状态 ****/
    public static class AskStatus {
        public final static Integer AUDIT = 0; // 待审核
        public final static Integer AUDIT_APPROVAL = 1; // 审核通过
        public final static Integer AUDIT_FAILED = 4; // 不通过
        public final static Integer RECEIVE = 5;//已处理

        public final static String CZSC = "czsc"; // 浏览
        public final static String VIEW = "VIEW"; // 浏览
        public final static Long type_0 = 0L; //
        public final static Long type_1 = 1L; //
        public final static String name = "官方回复"; // 浏览

    }

    /*** 法律咨询状态 ****/
    public static class ConsultLawStatus {
        public final static Integer AUDIT = 0; // 待审核
        public final static Integer AUDIT_APPROVAL = 1; // 审核通过
        public final static Integer AUDIT_FAILED = 2; // 不通过
        public final static Integer RECEIVE = 3;//已处理

        public final static String VIEW = "VIEW"; // 浏览
        public final static Long TYPE_0 = 0L; //
        public final static Long TYPE_1 = 1L; //
        public final static String NAME = "官方回复"; // 浏览
    }


    // 地震 url
    public static class earthquakeURL {
        /**
         * 预警回放
         */
        public final static String EARLY_WARN_URL = "http://218.5.2.111:9088/earthquakeWarn/earthQuake/list.json?pageSize=500";
        public final static String EARLY_WARN_CHANNEL_NAME = "预警回放";
        /**
         * 地震速报
         */
        public final static String BULLETIN_URL = "http://218.5.2.111:9088/earthquakeWarn/bulletin/list.json?pageSize=500";
        public final static String BULLETIN_CHANNEL_NAME = "地震速报";

    }

    // 系统设置
    public static class OrgSetting {
        // 屏蔽词设置
        public static class SWords {
            public final static String SWORDS = "swords";
            public final static Integer SWORDS_TYPE_0 = 0;
            public final static Integer SWORDS_TYPE_1 = 1;
        }
    }


    // 系统设置
    public static class ChannelModuleIsFixed {
        public final static Integer ISFIXED_NO = 0;
        public final static Integer ISFIXED_YES = 1;
        // UI组件是否固定
        public final static Integer FIXED_1 = 1;
        public final static Integer FIXED_2 = 2;
        public final static Integer FIXED_3 = 3;
        public final static Integer FIXED_9 = 9;
    }

    // 导出标头
    public static class ExportExcel {
        // 访问统计表
        public static final String[] ACCESSSTATISTICS_TITLE = {"日期","当日访问量","未注册用户","已注册用户","累计访问总数","涨幅"};
        public static final String[] ACCESSSTATISTICS_KEY = {"loginTime","daily","noRegist","registNum","allNum","zf"};
        // 稿件汇总表
        public static final String[] SUBJECTSUMMARY_TITLE = {"账号","姓名","图文","阅读量","视频","阅读量","图集","阅读量","总稿件数","总阅读量"};
        public static final String[] SUBJECTSUMMARY_KEY = {"loginName","userName","titleCount","titleCountRead","videoCount","videoCountRead","phoneCount","phoneCountRead","allCount","allCountRead"};
        // 稿件通过率表
        public static final String[] SUBJECTPASS_TITLE = {"账号","姓名","稿件数","通过审核数","通过审核率","发布数","发布率"};
        public static final String[] SUBJECTPASS_KEY = {"loginName","userName","allCount","subjectPass","subjectPoint","publishCount","publishPoint"};
        // 栏目统计表 总体结果
        public static final String[] SUBJECTCHANNEL_TITLE = {"栏目名称","标签名称","文章总数","阅读量","转发量","点赞量","评论量","收藏量"};
        public static final String[] SUBJECTCHANNEL_KEY = {"name","labelName","subjectNum","viewNum","shareNum","approvalNum","commentNum","collectionNum"};
        // 注册用户新增表
        public static final String[] REGISTERUSER_TITLE = {"日期","新增用户","装机量","累计注册用户数","涨幅"};
        public static final String[] REGISTERUSER_KEY = {"sj","xz","zjl","lj","zf"};
        // 日活表
        public static final String[] DAILYCALENDAR_TITLE = {"日期","日活","涨幅"};
        public static final String[] DAILYCALENDAR_KEY = {"loginTime","daily","zf"};
        // 手机型号表
        public static final String[] PHONEMODEL_TITLE = {"手机型号","数量","全部数量","百分比"};
        public static final String[] PHONEMODEL_KEY = {"sjxh","num","totalNum","bfb"};
        // app启动表
        public static final String[] APPSTART_TITLE = {"日期","当日启动量","未注册用户","已注册用户","累计启动总数","涨幅"};
        public static final String[] APPSTART_KEY = {"loginTime","daily","noRegist","registNum","allNum","zf"};
        // 视频播放表
        public static final String[] VIDEO_TITLE = {"日期","当日播放","累计播放总数","涨幅"};
        public static final String[] VIDEO_KEY = {"loginTime","daily","allNum","zf"};
        //栏目稿件阅读量表
        public static final String[] CHANNELSUB_TITLE = {"栏目","稿件阅读数"};
        public static final String[] CHANNELSUB_KEY = {"memo","num"};

        //栏目稿件留存率表
        public static final String[] APPUSERETENTION_TITLE = {"序号","日期","新增用户","第1天","第1天","第2天","第2天","第3天","第3天","第7天","第7天","第30天","第30天"};
        public static final String[] APPUSERETENTION_TITLE2 = {"序号","日期","新增用户","留存量","留存率","留存量","留存率","留存量","留存率","留存量","留存率","留存量","留存率"};
        public static final String[] APPUSERETENTION_KEY = {"loginTime","firstDay","firstDay","firstDayRetention","secondDay","secondDayRetention","thirdDay","thirdDayRetention","seventhDay","seventhDayRetention","thirtiethDay","thirtiethDayRetention"};

        // 用户积分历史表
        public static final String[] USER_SCORE_HISTORY_TITLE = {"用户手机号码", "时间", "操作", "获得积分", "累计积分"};
        public static final String[] USER_SCORE_HISTORY_KEY = {"mobile", "createTime", "operate", "score", "allScore"};
        public static final Integer[] USER_SCORE_HISTORY_WIDTH = {16, 19, 19, 15, 15};

        // 栏目统计表 详细表单
        public static final String[] SUBJECTCHANNEL_TITLE_DETAIL = {"栏目名称","标题名称 ","发布时间","转载时间","文章来源","文章类型","记者名称","阅读量"};
        public static final String[] SUBJECTCHANNEL_KEY_DETAIL = {"strLName","title","createTime","originalTime","docFrom","type","author","viewNum"};

    }

    /****党建资源类型****/
    public static class ResourceType {
        public final static Integer SUBJECT = 1; // 稿件
        public final static Integer COURSE = 2; // 课程
    }

    /*** 法律咨询状态 ****/
    public static class SplitImg {
        public final static String ffmpegResolutionRatio = "1326x1200"; // 分辨率ffmpeg
        public final static String ResolutionRatio = "1326*1200"; // 分辨率素材库
    }

    /****生成美特思登录mToken的key****/
    public final static String MTOKEN_KEY_LOGIN_NAME = "meitesi";
    public final static String MTOKEN_KEY_SIGNATURE = "signature";
    /**
     * 电信疫情私钥
     */
    public final static String DIANX_XIN_YI_QING_APPSECRET = "032a5e12-9a6c-44c8-9dc3-13178bbae936";

    //===============自定义迁移常量==================

    /** 默认版本号 **/
    public final static String DEFAULT_VERSION = "1.0.0.0";

    /** 默认版本号 **/
    public final static Integer THREADPOOL_NUM = 10;

    /** file_server请求前缀 **/
    public final static String FILE_SERVER = "file_server";

    /**  历史版本保留数   **/
    public final static String OLD_VERSION_NUM_CODE = "old_version_num";

    /** 频道默认显示条数 **/
    public final static Integer SCREEN_DEFAULT_SHOW_NUM = 5;

    /****消息内容类型 1：稿件，2：消息****/
    public static class NoticeType {
        public final static Integer SUBJECT = 1;
        public final static Integer NOTICE = 2;
    }

    public static class VersionChannel {
        public final static Long ANDROID = 0L;
        public final static Long IOS = 2L;
    }

    /****数据类型 1：版本，2：模板，3：草稿箱****/
    public static class CustomResourceType {
        public final static Integer VERSION = 1;
        public final static Integer TEMPLATE = 2;
        public final static Integer DRAFT = 3;
    }

    /****专题类型 0：内链，1：外链，2：稿件列表, 4:****/
    public static class UrlType {
        public final static Integer PAGE = 0;
        public final static Integer OUTURL = 1;
        public final static Integer SUBJECT = 2;
        public final static Integer ORG = 4;
    }

    /****组件类型 SUBJECT_003:大图****/
    public static class ModuleStyleCode {
        //左图右文
        public final static String SUBJECT_001 = "SUBJECT_001";
        public final static String SUBJECT_003 = "SUBJECT_003";
        public final static String SUBJECT_005 = "SUBJECT_005";
        public final static String SUBJECT_006 = "SUBJECT_006";
        public final static String SUBJECT_007 = "SUBJECT_007";
        public final static String SUBJECT_008 = "SUBJECT_008";
        public final static String SUBJECT_009 = "SUBJECT_009";
        // 小视频横屏滚动样式
        public final static String TINYVIDEO_003 = "TINYVIDEO_003";
    }
    /****组件类型 SUBJECT_003:大图****/
    public static class ModuleStyleId {
        //无图简介
        public final static String SUBJECT_009 = "51";
    }

    /****公用状态****/
    public static class PublicStatus {
        public final static Integer STATUS_0 = 0;
        public final static Integer STATUS_1 = 1;
        public final static Integer STATUS_2 = 2;
        public final static Integer STATUS_3 = 3;
        public final static Integer STATUS_4 = 4;
        public final static Integer STATUS_5 = 5;
        public final static Integer STATUS_6 = 6;
        public final static Integer STATUS_7 = 7;
    }

    /****公用状态****/
    public static class DateType {
        public final static Integer YYYY_MM_DD_HH_MM_SS = 0;
        public final static Integer YYYY_MM_DD = 1;
        public final static Integer HH_MM_SS= 2;
        public final static Integer YYYY_MM_DD_HH_MM = 3;
    }

    public static class GerenType{
        //旧生产 稿件标识
        public final static Integer geren_0 = 0;
        //新生产 稿件标识
        public final static Integer geren_1 = 1;
    }

    public static class isFixedType{
        // 不固定
        public final static Integer isFixed_0 = 0;
        // 固定
        public final static Integer isFixed_1 = 1;
    }

    public static class AppUserRole{
        //旧生产 稿件标识
        public final static Integer BLACK = 0;
        //新生产 稿件标识
        public final static Integer WHITE = 2;
    }

    /**
     * 稿件封面默认地址
     */
    public final static String DEFAULT_SUBJECT_COVER = "subject_cover";
    /**
     * 分享阅读量
     */
    public final static String SHARE_READ = "share_read";

    public static class showLocal{
        // 否
        public final static Integer showLocal_0 = 0;
        // 是
        public final static Integer showLocal_1 = 1;
    }

    /**
     * 活动类型
     */
    public static class InteractiveType{
        // 投票
        public final static Integer VOTE = 1;
        // 抽奖
        public final static Integer TURNTABLE = 2;
        // 报名
        public final static Integer SIGN = 3;
        // 活动报名
        public final static Integer ACTSIGN = 4;
    }
}
