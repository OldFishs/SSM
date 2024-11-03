package com.xxx.controller;


import com.xxx.pojo.Headline;
import com.xxx.service.HeadlineService;
import com.xxx.utils.JwtHelper;
import com.xxx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("headline")
@CrossOrigin
public class HeadLineController {

    @Autowired
    private HeadlineService headlineService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline,@RequestHeader String token){
        int userId = jwtHelper.getUserId(token).intValue();
        headline.setPublisher(userId);
        Result result = headlineService.publish(headline);
        return result;
    }

    @PostMapping("findHeadlineByPage")
    public Result findHeadlineByHid(Integer hid){
        Headline headline = headlineService.getById(hid);
        Map data = new HashMap();
        data.put("headline", headline);
        return Result.ok(data);
    }

    @PostMapping("update")
    public Result update(@RequestBody Headline headline){
        Result result = headlineService.updateData(headline);
        return result;
    }
}
