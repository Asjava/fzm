package com.fxs.fzm.common.enums;

/**
 * Title:
 * Description: 媒体类型
 * Copyright: Copyright(c) 2019/7/15 0015
 * company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: xfh
 */
public enum MediaEnum {

    PICTURE(0, "picture"), VIDEO(1, "video"), AUDIO(2, "audio")
    ,FILE(3,"file"),APK(4,"apk"),OTHER(5,"other");

    private int type;
    private String folderName;// 文件夹名称

    private MediaEnum(int type, String folderName) {
        this.type = type;
        this.folderName = folderName;
    }

    public int getType() {
        return type;
    }

    public String getFolderName() {
        return folderName;
    }

    public static String getFolderNameByType(Integer type){
        String folderName = "";
        MediaEnum[] mediaEnums = MediaEnum.values();
        for (MediaEnum mediaEnum: mediaEnums) {
            if(mediaEnum.getType()== type){
                folderName = mediaEnum.getFolderName();
            }
        }
        return folderName;
    }

}
