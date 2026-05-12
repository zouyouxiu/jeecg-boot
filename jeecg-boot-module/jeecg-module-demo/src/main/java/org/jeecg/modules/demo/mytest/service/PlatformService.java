package org.jeecg.modules.demo.mytest.service;

import org.jeecg.modules.demo.mytest.dto.MainPlatformDTO;
import org.jeecg.modules.demo.mytest.entity.MainPlatform;
import org.jeecg.modules.demo.mytest.entity.MainSubMapping;
import org.jeecg.modules.demo.mytest.entity.SubPlatform;
import org.jeecg.modules.demo.mytest.mapper.MainPlatformMapper;
import org.jeecg.modules.demo.mytest.mapper.MainSubMappingMapper;
import org.jeecg.modules.demo.mytest.mapper.SubPlatformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatformService {

    @Autowired
    private MainPlatformMapper mainPlatformMapper;
    @Autowired
    private SubPlatformMapper subPlatformMapper;
    @Autowired
    private MainSubMappingMapper mappingMapper;

    // 根据 type 获取主平台 + 对应子平台（按 type 隔离）
    public List<MainPlatformDTO> getPlatformsByType(Integer type) {
        List<MainPlatform> mainList = mainPlatformMapper.selectByType(type);

        return mainList.stream().map(main -> {
            List<Long> subIds = mappingMapper.getSubIdsByMainId(main.getId());
            List<SubPlatform> subs = subIds.isEmpty() ? Collections.emptyList() :
                    subPlatformMapper.selectBatchIds(subIds)
                    .stream()
                    .filter(sub -> sub.getType().equals(type)) // 强制 type 匹配
                    .collect(Collectors.toList());
            return new MainPlatformDTO(main.getId(), main.getName(), main.getCode(), main.getType(), subs);
        }).collect(Collectors.toList());
    }

    @Transactional
    public void updateMapping(Long mainId, List<Long> subIds, Integer type) {
        MainPlatform main = mainPlatformMapper.selectById(mainId);
        if(main == null) throw new RuntimeException("主平台不存在");
        if(!main.getType().equals(type)) throw new RuntimeException("主平台类型不匹配");

        // 删除旧映射
        mappingMapper.deleteByMainId(mainId);

        // 过滤子平台类型，避免跨类型绑定
        List<SubPlatform> validSubs = subPlatformMapper.selectBatchIds(subIds)
                .stream()
                .filter(sub -> sub.getType().equals(type))
                .collect(Collectors.toList());

        List<MainSubMapping> list = validSubs.stream()
                .map(sub -> new MainSubMapping(mainId, sub.getId()))
                .collect(Collectors.toList());
        if(!list.isEmpty()) mappingMapper.insertMappings(list);
    }
}
