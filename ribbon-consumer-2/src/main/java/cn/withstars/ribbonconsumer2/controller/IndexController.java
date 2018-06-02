package cn.withstars.ribbonconsumer2.controller;

import cn.withstars.ribbonconsumer2.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: withstars
 * Date: 2018-06-02
 * Time: 18:46
 * Mail: withstars@126.com
 */
@RestController
public class IndexController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String hello(){
        return helloService.hello();
    }


}
