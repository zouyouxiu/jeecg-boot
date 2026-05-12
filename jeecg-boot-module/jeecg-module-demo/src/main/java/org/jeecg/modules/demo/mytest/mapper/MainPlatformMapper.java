package org.jeecg.modules.demo.mytest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.mytest.entity.MainPlatform;

import java.util.List;

@Mapper
public interface MainPlatformMapper {
    List<MainPlatform> selectByType(@Param("type") Integer type);
    MainPlatform selectById(@Param("id") Long id);
}