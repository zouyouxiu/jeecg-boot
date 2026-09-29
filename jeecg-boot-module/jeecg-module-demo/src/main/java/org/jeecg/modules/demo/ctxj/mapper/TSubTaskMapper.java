package org.jeecg.modules.demo.ctxj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.ctxj.entity.SubTask;

import java.util.List;

/**
 * @Description: 子表
 * @Author: jeecg-boot
 * @Date:   2026-05-28
 * @Version: V1.0
 */
public interface TSubTaskMapper extends BaseMapper<SubTask> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<TSubTask>
   */
	public List<SubTask> selectByMainId(@Param("mainId") String mainId);
}
