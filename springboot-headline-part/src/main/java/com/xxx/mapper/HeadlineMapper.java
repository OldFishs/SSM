package com.xxx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxx.pojo.Headline;
import com.xxx.pojo.vo.PortalVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author 彭生
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-11-02 14:24:31
* @Entity com.xxx.domain.Headlinepojo
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    IPage<Map> selectPageMap(IPage iPage,@Param("portalVo")PortalVo portalVo);

    Map selectDetailMap(Integer hid);
}




