package org.jeecg.modules.demo.ctxj.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.config.shiro.IgnoreAuth;
import org.jeecg.modules.demo.ctxj.entity.SubTask;
import org.jeecg.modules.demo.ctxj.service.ITMainTaskService;
import org.jeecg.modules.demo.ctxj.service.ITSubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description: 主表
 * @Author: jeecg-boot
 * @Date:   2026-05-28
 * @Version: V1.0
 */
@Tag(name="主表")
@RestController
@RequestMapping("/org/jeecg/modules/demo/ctxj/tMainTask")
@Slf4j
public class TMainTaskController {
	@Autowired
	private ITMainTaskService tMainTaskService;
	@Autowired
	private ITSubTaskService tSubTaskService;

    /**
     * 接口 1：新建子任务
     */
    @PostMapping("/subtask")
    @IgnoreAuth
    public ResponseEntity<List<String>> createSubTask(@RequestBody SubTask newTask) {
        List<String> conflicts = tSubTaskService.saveOrUpdateSubTask(newTask, true);
        return ResponseEntity.ok(conflicts);
    }

    /**
     * 接口 2：修改子任务
     */
    @PutMapping("/subtask")
    @IgnoreAuth
    public ResponseEntity<List<String>> updateSubTask(@RequestBody SubTask editTask) {
        List<String> conflicts = tSubTaskService.saveOrUpdateSubTask(editTask, false);
        return ResponseEntity.ok(conflicts);
    }

    /**
     * 接口 3：一键冲突消解
     */
    @PostMapping("/resolution")
    @IgnoreAuth
    public ResponseEntity<List<SubTask>> resolveConflicts() {
        List<SubTask> resolvedList = tSubTaskService.resolveConflicts();
        return ResponseEntity.ok(resolvedList);
    }

    /**
     * 接口 4：查询当前冲突列表报告
     */
    @GetMapping("/conflict-list/{mainTaskId}")
    @IgnoreAuth
    public ResponseEntity<List<String>> getConflictList(@PathVariable String mainTaskId) {
        return ResponseEntity.ok(tSubTaskService.getConflictList(mainTaskId));
    }
}
