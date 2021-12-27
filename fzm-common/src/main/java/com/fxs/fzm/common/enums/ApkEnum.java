package com.fxs.fzm.common.enums;

/**
 * Titile:
 * Description:
 * Copyright: Copyright (c) 2019/9/10
 * Campany:北京福富软件技术股份有限公司福州分公司
 *
 * @author wuzhiming
 **/
public enum ApkEnum {
    APK(MediaEnum.APK, "APK");
    private MediaEnum type;
    private String typeName;

    private ApkEnum(MediaEnum type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    /**
     * 判断是否包含该类型
     * @param typeName
     * @return
     */
    public static boolean validate(String typeName) {
        ApkEnum[] arr = ApkEnum.values();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getTypeName().equals(typeName.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
