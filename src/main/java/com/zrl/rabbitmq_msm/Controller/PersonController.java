package com.zrl.rabbitmq_msm.Controller;

import com.zrl.rabbitmq_msm.Service.imp.PersonImp;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *@autho  zhengruilong
 *@date 2020-03-16
 */
@RestController
@Api(value = "测试短信发送")
public class PersonController {

     @Autowired
      PersonImp personImp;


//     @ApiImplicitParams({
//        @ApiImplicitParam(name = "id",value = "用户id")
//     })
    @ApiOperation(value = "获取tel",notes = "获取电话")
     @PostMapping(value = "/getTel/{tel}")
    public void getTelToPublish(@PathVariable(name = "tel") String  tel ){

           if(!(tel.equals(""))){
                   personImp.getTelToPublish(Long.parseLong(tel));

           }

    }



    //测试app
     private static     Map map=new HashMap();
    @PostMapping(value = "/login")
    public Map applogin(@RequestBody AppUser appUser ){

        System.out.println(appUser);
        if (appUser.getUsername().equals("zrl")&&appUser.getUserpass().equals("123456")) {
            map.put("success", true);
            map.put("message", "成功");
        }else {
            map.put("success", false);
            map.put("message", "失败");
        }
        return  map;
    }

}
