package com.yiyong.framework.core.orm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 与具体ORM实现无关的分页参数及查询结果封装.
 * 
 * @param <T> Page中记录的类型.
 * 
 */
public class Page<T> implements java.io.Serializable{
	

	private static final long serialVersionUID = -4667706355835339724L;
	//-- 公共变量 --//
	public static final int 	DEFAULT_PAGE_SIZE = 10;
	public static final int 	DEFAULT_FIRST_NO = 1;
	public static final int 	DEFAULT_NUM_COUNT = 4;
	public static final int 	DEFAULT_PAGE_NO = 1;
	public static final int 	DEFAULT_START = 0;
	public static final long 	DEFAULT_TOTAL_COUNT = 0;
	public static final String 	DEFAULT_SORT_COLUMN = "id";
	public static final String 	ASC = "asc";
	public static final String 	DESC = "desc";
	
	private int 	firstNo = DEFAULT_FIRST_NO;			//首页 页号
	private int 	lastNo;								//末页 页号
	private int 	pageCount;							//总页数
	private int 	pageSize = DEFAULT_PAGE_SIZE; 		//每页的记录数
	private int 	pageNo = DEFAULT_PAGE_NO;			//当前页号
	private long 	totalCount; 						//总记录数
	private List<T> result = new ArrayList<T>();		//当前页中存放的记录
	private String	sortColumn = DEFAULT_SORT_COLUMN;	//排序列
	private String	sortType = DESC;					//排序类型
	
	//-- 分页查询参数 --//
	protected String orderBy = null;
	protected String order = null;
	//-- 返回结果 --//

	/**
	 * 构造方法，只构造空页.
	 */
	public Page() {
		this(DEFAULT_PAGE_NO, DEFAULT_TOTAL_COUNT, DEFAULT_PAGE_SIZE, new ArrayList<T>());
	}

	/**
	 * 默认构造方法.
	 * @param targetNo	 当前页
	 * @param start	 本页数据在数据库中的起始位置
	 * @param totalCount 数据库中总记录条数
	 * @param pageSize  本页容量
	 * @param data	  本页包含的数据
	 */
	public Page(int pageNo,  long totalCount, int pageSize, List<T> result) {
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.result = result;
		this.pageCount = (int) Math.ceil((double)this.totalCount/this.pageSize);
		this.pageNo = Math.min(this.pageNo, pageCount);
		this.pageNo = Math.max(1, this.pageNo);
		this.lastNo = this.pageCount;
	}


	/**
	 * 获得排序字段,无默认值. 多个排序字段时用','分隔.
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * 设置排序字段,多个排序字段时用','分隔.
	 */
	public void setOrderBy(final String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * 获得排序方向, 无默认值.
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 设置排序方式向.
	 * 
	 * @param order 可选值为desc或asc,多个排序字段时用','分隔.
	 */
	public void setOrder(final String order) {
		if (order == null)
			return ;
		String lowcaseOrder = StringUtils.lowerCase(order);

		//检查order字符串的合法值
		String[] orders = StringUtils.split(lowcaseOrder, ',');
		for (String orderStr : orders) {
			if (!StringUtils.equals(DESC, orderStr) && !StringUtils.equals(ASC, orderStr)) {
				throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
			}
		}

		this.order = lowcaseOrder;
	}

	/**
	 * 是否已设置排序字段,无默认值.
	 */
	public boolean isOrderBySetted() {
		return (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order));
	}
	
	/**
	 * 获取任一页第一条数据在数据集的位置.
	 *
	 * @param pageNo   从1开始的页号
	 * @param pageSize 每页记录条数
	 * @return 该页第一条数据
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}
	
	/**
	 * 设置page对象内的内容
	 * @param page
	 * @param start
	 * @param totalCount
	 * @param data
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setPageValue(Page page, int start, long totalCount, List result) {
		int pageNo = page.getPageNo();
		int pageSize = page.getPageSize();
		int pageCount = (int) Math.ceil((double)totalCount/pageSize);
		pageNo = Math.min(pageNo, pageCount);
		pageNo = Math.max(1, pageNo);
		int lastNo = pageCount;
		page.setPageNo(pageNo);
		page.setPageCount(pageCount);
		page.setLastNo(lastNo);
		page.setTotalCount(totalCount);
		page.setResult(result);
		return;
	}
	
	public List<T> getResult() {
		return result;
	}

	public void setResult(final List<T> result) {
		this.result = result;
	}

	public int getFirstNo() {
		return firstNo;
	}

	public void setFirstNo(int firstNo) {
		this.firstNo = firstNo;
	}

	public int getLastNo() {
		return lastNo;
	}

	public void setLastNo(int lastNo) {
		this.lastNo = lastNo;
	}


	public int getPageCount() {
		return pageCount==0?1:pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
