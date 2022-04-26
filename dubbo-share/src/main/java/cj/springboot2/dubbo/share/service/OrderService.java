package cj.springboot2.dubbo.share.service;


import cj.springboot2.dubbo.share.bean.UserAddress;

import java.util.List;

public interface OrderService {
	
	/**
	 * 初始化订单
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);

}
