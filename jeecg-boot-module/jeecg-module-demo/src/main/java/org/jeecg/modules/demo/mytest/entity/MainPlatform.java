package org.jeecg.modules.demo.mytest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainPlatform {
    private Long id;        // 主键ID
    private String name;    // 平台名称
    private String code;    // 平台编码
    private Integer type;   // 平台类型: 1-潜水艇, 2-飞机
}
