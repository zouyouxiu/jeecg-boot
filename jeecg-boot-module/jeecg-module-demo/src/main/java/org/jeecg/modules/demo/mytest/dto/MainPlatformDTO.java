package org.jeecg.modules.demo.mytest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jeecg.modules.demo.mytest.entity.SubPlatform;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainPlatformDTO {
    private Long id;                  // 主平台ID
    private String name;              // 主平台名称
    private String code;              // 主平台编码
    private Integer type;             // 主平台类型
    private List<SubPlatform> subPlatforms; // 子平台列表
}
