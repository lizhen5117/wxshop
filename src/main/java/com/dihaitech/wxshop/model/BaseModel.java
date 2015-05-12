package com.dihaitech.wxshop.model;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 与数据库表有对应关系的Model类的基类
 * 
 * @author qiusen
 * 
 */
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = 6437114463749744698L;

	// 数据库主键
	private Integer id;

	// 分页查询时用的开始记录数
	private Integer start = 0;

	// 分页查询时用的截止记录数
	private Integer end = 30;

	// 当前所在页数
	private Integer pageNo;

	// 每页显示的条目数
	private Integer pageSize = 10;

	/**
	 * 查询个数
	 */
	private Integer count = 10;

	/**
	 * ID拼凑的字符串 1,2,3,4,5 有时会加 where id in ()等
	 */
	private String idStr;

	/**
	 * 排序方式：desc asc
	 */
	private String orderType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setData(Object vo) throws Exception {
		BeanUtils.copyProperties(this, vo);
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

}
