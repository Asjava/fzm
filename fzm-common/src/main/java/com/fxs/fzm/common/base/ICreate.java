package com.fxs.fzm.common.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:Rick
 * @Date:2019年6月25日
 * @Time:下午9:43:47
 * @Description:设置创建时间
 */
public interface ICreate extends Serializable {

	public Date getCreateTime();

	public void setCreateTime(Date createTime);
}
