package org.jeecg.modules.demo.mytest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.mytest.entity.MainSubMapping;

import java.util.List;

@Mapper
public interface MainSubMappingMapper {
    List<Long> getSubIdsByMainId(@Param("mainId") Long mainId);
    void deleteByMainId(@Param("mainId") Long mainId);
    void insertMappings(@Param("mappings") List<MainSubMapping> mappings);
}
