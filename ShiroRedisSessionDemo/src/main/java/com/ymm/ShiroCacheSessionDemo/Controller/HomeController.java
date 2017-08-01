package com.ymm.ShiroCacheSessionDemo.Controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by James on 7/31/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        String exception = (String) request.getAttribute("shiroLoginFailure");

        String msg = "";

        if (exception != null){
            if(UnknownAccountException.class.getName().equals(exception)){
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)){
                msg = "密码不正确";
            } else {
                msg = exception;
            }
        }

        map.put("msg", msg);

        return "login";
    }
}
