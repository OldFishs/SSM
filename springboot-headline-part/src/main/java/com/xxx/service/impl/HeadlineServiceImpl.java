package com.xxx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.mapper.HeadlineMapper;
import com.xxx.pojo.Headline;
import com.xxx.pojo.vo.PortalVo;
import com.xxx.service.HeadlineService;
import com.xxx.utils.JwtHelper;
import com.xxx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @author 彭生
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-11-02 14:24:31
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

    @Autowired
    private HeadlineMapper headlineMapper;

    @Autowired
    private JwtHelper jwtHelper;

    //首页数据查询
    @Override
    public Result findNewspage (PortalVo portalVo) {

        IPage<Map> page = new Page<>(portalVo.getPageNum(),portalVo.getPageSize());
        headlineMapper.selectPageMap(page,portalVo);

        Map data = new HashMap();
        data.put("pageData",page.getRecords());
        data.put("pageNum",page.getCurrent());
        data.put("pageSize",page.getSize());
        data.put("totalPage",page.getPages());
        data.put("totalSize",page.getTotal());

        Map pageInfo = new HashMap();
        pageInfo.put("pageInfo",data);

        return Result.ok(pageInfo);
    }

    //阅读量增加
    @Override
    public Result showHeadlineDetail(Integer hid) {

        Map data = headlineMapper.selectDetailMap(hid);
        Map headlineMap = new HashMap();
        headlineMap.put("headline",data);

        //修改阅读量+1
        Headline headline = new Headline();
        headline.setHid(hid);
        headline.setVersion((Integer) data.get("version"));
        //阅读量+1
        headline.setPageViews((Integer) data.get("pageViews") + 1);
        headlineMapper.updateById(headline);

        return Result.ok(headline);

    }

    //发布头条
    @Override
    public Result publish(Headline headline) {
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());

        headlineMapper.insert(headline);

        return Result.ok(null);
    }

    @Override
    public Result updateData(Headline headline) {

        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();

        headline.setVersion(version);
        headline.setUpdateTime(new Date());

        headlineMapper.updateById(headline);

        return Result.ok(null);
    }
}




