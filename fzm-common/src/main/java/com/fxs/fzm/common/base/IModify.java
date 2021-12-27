package com.fxs.fzm.common.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:Rick
 * @Date:2019年6月25日
 * @Time:上午10:16:34
 * @Description:设置修改信息
 */
public interface IModify extends Serializable {

	public Date getModifyTime();

	public void setModifyTime(Date updateTime);
}
