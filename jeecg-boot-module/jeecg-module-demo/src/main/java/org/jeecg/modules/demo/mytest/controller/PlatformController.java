package org.jeecg.modules.demo.mytest.controller;

import org.jeecg.modules.demo.mytest.dto.MainPlatformDTO;
import org.jeecg.modules.demo.mytest.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platforms")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    // 查询指定类型主平台及子平台
    @GetMapping
    public List<MainPlatformDTO> getPlatforms(@RequestParam Integer type) {
        return platformService.getPlatformsByType(type);
    }

    // 更新主平台子平台映射
    @PostMapping("/{mainId}/subs")
    public void saveSubPlatforms(@PathVariable Long mainId,
                                 @RequestParam Integer type,
                                 @RequestBody List<Long> subIds) {
        platformService.updateMapping(mainId, subIds, type);
    }
}
