package com.hexun.baseproject.vo;
/**
 * 获取列表请求参数bean
 * @author zhoudong
 *
 */
public class ItemListRequestVO {
	/**
	 * 搜索关键字
	 */
	private String q;
	/**
	 * 宝贝所在地
	 */
	private String itemloc;
	/**
	 * 排序
	 */
	private String sort;
	/**
	 * 是不是天猫，默认是false，为true的时候，只显示天猫
	 */
	private boolean isTmall;
	/**
	 * 页号
	 */
	private long pageNo;
	/**
	 * 页大小
	 */
	private long pageSize;
	/**
	 * 是否是海外商品
	 */
	private boolean isOverseas;
	/**
	 * 价格下限
	 */
	private long startPrice;
	/**
	 * 价格上限
	 */
	private long endPrice;
	
	/**
	 * 类型
	 */
	private int type;
	/**
	 * url
	 */
	public static final String URL = "http://gw.api.taobao.com/router/rest";
	/**
	 * appkey
	 */
	public static final String APPKEY = "23271271";
	/**
	 * secret
	 */
	public static final String SECRET = "657e60d240d51ff5129c4875547ac51e";
	
	//排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi）
	/**
	 * 排序，降序
	 */
	public static final String SORT_DES = "_des";
	/**
	 * 排序，升序
	 */
	public static final String SORT_ASC = "_asc";
	/**
	 * 排序，销量
	 */
	public static final String SORT_SALES = "total_sales";
	/**
	 * 排序，淘客佣金比率
	 */
	public static final String SORT_RATE = "tk_rate";
	/**
	 * 排序，累计推广量
	 */
	public static final String SORT_TK_SALES = "tk_total_sales";
	/**
	 * 排序，总支出佣金
	 */
	public static final String SORT_TK_COMMI = "tk_total_commi";
	
	
	
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getItemloc() {
		return itemloc;
	}
	public void setItemloc(String itemloc) {
		this.itemloc = itemloc;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public boolean getIsTmall() {
		return isTmall;
	}
	public void setIsTmall(boolean isTmall) {
		this.isTmall = isTmall;
	}
	public long getPageNo() {
		return pageNo;
	}
	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public boolean getIsOverseas() {
		return isOverseas;
	}
	public void setIsOverseas(boolean isOverseas) {
		this.isOverseas = isOverseas;
	}
	public long getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(long startPrice) {
		this.startPrice = startPrice;
	}
	public long getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(long endPrice) {
		this.endPrice = endPrice;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ItemListRequestVO(String q, String itemloc, String sort,
			boolean isTmall, long pageNo, long pageSize, boolean isOverseas,
			long startPrice, long endPrice) {
		super();
		this.q = q;
		this.itemloc = itemloc;
		this.sort = sort;
		this.isTmall = isTmall;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.isOverseas = isOverseas;
		this.startPrice = startPrice;
		this.endPrice = endPrice;
	}
	public ItemListRequestVO() {
		super();
	}
	
	public ItemListRequestVO(String q, String sort,
			boolean isTmall, long pageNo, long pageSize,
			long startPrice, long endPrice) {
		super();
		this.q = q;
		this.sort = sort;
		this.isTmall = isTmall;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.startPrice = startPrice;
		this.endPrice = endPrice;
	}
}
