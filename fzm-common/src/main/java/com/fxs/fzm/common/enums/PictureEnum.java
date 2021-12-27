package com.fxs.fzm.common.enums;

/**
 * Title:
 * Description:
 * Copyright: Copyright(c) 2019/7/15 0015
 * company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: xfh
 */
public enum PictureEnum {

    JPG(MediaEnum.PICTURE, "JPG"),
    JPEG(MediaEnum.PICTURE, "JPEG"),
    PNG(MediaEnum.PICTURE, "PNG"),
    BMP(MediaEnum.PICTURE, "BMP"),
    GIF(MediaEnum.PICTURE, "GIF");

    private MediaEnum type;
    private String typeName;

    private PictureEnum(MediaEnum type, String typeName) {
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
        PictureEnum[] arr = PictureEnum.values();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getTypeName().equals(typeName.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
