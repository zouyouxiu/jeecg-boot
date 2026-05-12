package org.jeecg.modules.demo.mytest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.mytest.entity.SubPlatform;

import java.util.List;

@Mapper
public interface SubPlatformMapper {
    List<SubPlatform> selectByType(@Param("type") Integer type);
    List<SubPlatform> selectBatchIds(@Param("ids") List<Long> ids);
}
