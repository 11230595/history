package com.hexun.baseproject.queue;

import org.apache.log4j.Logger;


/**
 * @title 修改时间，达到自动排序的目的
 * @author zhoudong
 *
 */
public class AutoChangeTime {
	private static Logger logger = Logger.getLogger(AutoChangeTime.class);
	/**
	 * @title 重新排序，首页产品
	 */
	public void autoChangeTime(){
		logger.info("修改时间，打乱排序方式开始......");
		long startTime = System.currentTimeMillis();
		
		long endTime = System.currentTimeMillis();
		logger.info("修改时间，打乱排序方式结束......共用时---》" + (endTime - startTime));
	};
	
	/**
	 * @title 专区产品
	 */
	public void autoChangeTimeByLink(){
		logger.info("专区商品--》修改时间，打乱排序方式开始......");
		long startTime = System.currentTimeMillis();
		
		long endTime = System.currentTimeMillis();
		logger.info("专区商品--》修改时间，打乱排序方式结束......共用时---》" + (endTime - startTime));
	};
}
