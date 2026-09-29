package org.jeecg.modules.demo.ctxj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.ctxj.entity.SubTask;

import java.util.List;

/**
 * @Description: 子表
 * @Author: jeecg-boot
 * @Date:   2026-05-28
 * @Version: V1.0
 */
public interface ITSubTaskService extends IService<SubTask> {


    List<String> getConflictList(String mainTaskId);

    List<SubTask> resolveConflicts();

    List<String> saveOrUpdateSubTask(SubTask editTask, boolean b);
}
