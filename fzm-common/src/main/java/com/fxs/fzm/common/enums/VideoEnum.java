package com.fxs.fzm.common.enums;

/**
 * Title:
 * Description: 视频类型
 * Copyright: Copyright(c) 2019/7/15 0015
 * company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: xfh
 */
public enum VideoEnum {
    MP4(MediaEnum.VIDEO, "MP4"),
    AVI(MediaEnum.VIDEO, "AVI"),
    RMVB(MediaEnum.VIDEO, "RMVB"),
    MKV(MediaEnum.VIDEO, "MKV"),
    WMV(MediaEnum.VIDEO, "WMV"),
    FLV(MediaEnum.VIDEO, "FLV"),
    GP3(MediaEnum.VIDEO, "3GP"),
    RM(MediaEnum.VIDEO, "RM");

    private MediaEnum type;
    private String typeName;

    private VideoEnum(MediaEnum type, String typeName) {
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
        VideoEnum[] arr = VideoEnum.values();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getTypeName().equals(typeName.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
