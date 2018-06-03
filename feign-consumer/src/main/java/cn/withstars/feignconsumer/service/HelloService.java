package cn.withstars.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: withstars
 * Date: 2018-06-02
 * Time: 20:09
 * Mail: withstars@126.com
 */
@Service
@FeignClient("HELLO-SERVICE")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
