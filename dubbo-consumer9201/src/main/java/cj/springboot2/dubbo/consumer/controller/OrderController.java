package cj.springboot2.dubbo.consumer.controller;


import cj.springboot2.dubbo.share.bean.UserAddress;
import cj.springboot2.dubbo.share.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dubbo/consumer")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/initOrder")
	public List<UserAddress> initOrder(@RequestParam("uid")String userId) {
		return orderService.initOrder(userId);
	}

}
