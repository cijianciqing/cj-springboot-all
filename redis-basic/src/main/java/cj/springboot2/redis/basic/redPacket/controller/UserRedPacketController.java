package cj.springboot2.redis.basic.redPacket.controller;


import cj.springboot2.redis.basic.redPacket.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

	@Autowired
	private UserRedPacketService userRedPacketService ;



	@RequestMapping(value = "/grapRedPacketByRedis")
	public Map<String, Object> grapRedPacketByRedis(Long redPacketId, Long userId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Long result = userRedPacketService.grapRedPacketByRedis(redPacketId, userId);
		String message ;
		if (result <= 0 ){
			message = "库存清空了";
		}else{
			message = "抢到红包了";
		}
		resultMap.put("message", message);
		return resultMap;
	}

}
