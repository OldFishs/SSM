package com.xxx.service;

import com.xxx.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.pojo.vo.PortalVo;
import com.xxx.utils.Result;

/**
* @author 彭生
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-11-02 14:24:31
*/
public interface HeadlineService extends IService<Headline> {

    Result findNewspage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);

    Result publish(Headline headline);

    Result updateData(Headline headline);
}
