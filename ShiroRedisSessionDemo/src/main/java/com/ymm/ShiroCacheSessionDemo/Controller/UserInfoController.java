package com.ymm.ShiroCacheSessionDemo.Controller;

import com.ymm.ShiroCacheSessionDemo.Service.ItemObjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by James on 7/31/2017.
 */
@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    private ItemObjectService itemObjectService;

    @RequestMapping(value = {"/userList", "/"})
    public String userList(){
        System.out.println(itemObjectService.findByItemId(1L).toString());
        return "userInfo";
    }

    @RequestMapping(value = "/userAdd")
    @RequiresPermissions(value = "userInfo:add")
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    @RequestMapping(value = "/userDel")
    @RequiresPermissions(value = "userInfo:delete")
    public String userInfoDel(){
        return "userInfoDel";
    }
}
