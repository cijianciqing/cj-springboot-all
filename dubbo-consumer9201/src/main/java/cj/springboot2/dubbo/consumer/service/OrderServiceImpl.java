package cj.springboot2.dubbo.consumer.service;

import cj.springboot2.dubbo.share.bean.UserAddress;
import cj.springboot2.dubbo.share.service.OrderService;
import cj.springboot2.dubbo.share.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 2）、配置服务提供者
 * <p>
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 *
 * @author lfy
 */
@Component
public class OrderServiceImpl implements OrderService {

//	@Autowired
//	@Reference(loadbalance="random",timeout=1000) //dubbo直连

    //	@Reference(version = "1.0.0", url = "dubbo://localhost:20881")
//	@Reference(version = "1.0.0")
    @Reference(version = "1.0.0")
    UserService userService;

//	@DubboReference(version = "1.0.0", url = "dubbo://172.16.207.221:2181")

//	private UserService userService;

    //	@HystrixCommand(fallbackMethod="hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        // TODO Auto-generated method stub
        System.out.println("用户id：" + userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;
    }


    public List<UserAddress> hello(String userId) {
        // TODO Auto-generated method stub

        return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }


}
