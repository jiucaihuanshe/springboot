package com.jt.cart.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

public class BasePojo implements Serializable{
	private static final long serialVersionUID = -8630995789194982979L;
	//自动填充公共字段
	//fill：字段填充标记 FieldFill.INSERT插入填充字段
	@TableField(value="created",fill=FieldFill.INSERT)
	private Date created;
	//FieldFill.INSERT_UPDATE插入和更新填充字段
	@TableField(value="updated",fill=FieldFill.INSERT_UPDATE)
	private Date updated;
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
