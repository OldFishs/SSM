package com.xxx.controller;


import com.xxx.pojo.vo.PortalVo;
import com.xxx.service.HeadlineService;
import com.xxx.service.TypeService;
import com.xxx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("portal")
public class PortalController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;

    @GetMapping("findAllTypes")
    public Result findAllTypes(){
        Result result = typeService.findAllTypes();
        return result;
    }

    @PostMapping("findNewsPage")
    public Result findNewspages(@RequestBody PortalVo portalVo){
        Result result = headlineService.findNewspage(portalVo);
        return result;
    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(Integer hid) {

        Result result = headlineService.showHeadlineDetail(hid);
        return result;
    }

    @PostMapping("removeByHid")
    public Result removeByHid(Integer hid) {
        headlineService.removeById(hid);
        return Result.ok(null);

    }
}
