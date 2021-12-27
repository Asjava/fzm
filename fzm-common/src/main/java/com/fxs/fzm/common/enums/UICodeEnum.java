package com.fxs.fzm.common.enums;

/**
 * 标题 cms 平台code对应 自定义 样式code
 * 描述
 * Copyright: Copyright (c) 2020/4/9 16:53
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: KeiVi233
 */
public enum UICodeEnum {
    CODE_1("CAROUSEL-004","SUBJECT_001","左图右文"),
    CODE_2("CAROUSEL-005","SUBJECT_002","三图新闻"),
    CODE_3("CAROUSEL-006","SUBJECT_003","大图"),
    CODE_4("CAROUSEL-007","SUBJECT_004","左文右图"),
    CODE_5("CAROUSEL-008","SUBJECT_005","全文无图"),
    CODE_6("CAROUSEL-001","SUBJECT_006","轮播图"),
    CODE_7("CAROUSEL-002","SUBJECT_007","上下滚动消息"),
    CODE_8("CAROUSEL-010","SUBJECT_008","小视频"),


    ;
    private String UICode;

    private String moduleCode;

    private String UIName;

    UICodeEnum(String UICode,String moduleCode,String UIName){
        this.UICode = UICode;
        this.moduleCode = moduleCode;
        this.UIName = UIName;
    }

    public static String getByUICode(String UICode) {
        String code = null;
        for(UICodeEnum status: UICodeEnum.values()) {
            if(status.UICode.equals(UICode)) {
                code = status.moduleCode;
                break;
            }
        }
        return code;
    }




    public static String getBymoduleCode(String moduleCode) {
        String code = null;
        for(UICodeEnum status: UICodeEnum.values()) {
            if(status.moduleCode.equals(moduleCode)) {
                code = status.UICode;
                break;
            }
        }
        return code;
    }

}
