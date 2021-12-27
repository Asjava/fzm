package com.fxs.fzm.common.enums;

/**
 * Titile:
 * Description:
 * Copyright: Copyright (c) 2019/9/10
 * Campany:北京福富软件技术股份有限公司福州分公司
 *
 * @author wjb
 **/
public enum OtherEnum {

    ZIP(MediaEnum.OTHER, "ZIP"),
    DOC(MediaEnum.OTHER, "DOC"),
    RAR(MediaEnum.OTHER, "RAR"),
    XLS(MediaEnum.OTHER, "XLS"),
    XLSX(MediaEnum.OTHER, "XLSX"),
    DOCX(MediaEnum.OTHER, "DOCX"),
    PPT(MediaEnum.OTHER, "PPT"),
    PPTX(MediaEnum.OTHER, "PPTX"),
    TXT(MediaEnum.OTHER, "TXT"),
    TAR(MediaEnum.OTHER, "TAR"),
    PDF(MediaEnum.OTHER, "PDF");


    private MediaEnum type;
    private String typeName;

    private OtherEnum(MediaEnum type, String typeName) {
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
        OtherEnum[] arr = OtherEnum.values();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getTypeName().equals(typeName.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
