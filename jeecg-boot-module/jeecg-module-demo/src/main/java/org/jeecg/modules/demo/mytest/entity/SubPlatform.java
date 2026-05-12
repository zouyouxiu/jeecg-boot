package org.jeecg.modules.demo.mytest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubPlatform {
    private Long id;       // 主键ID
    private String name;   // 子平台名称
    private String code;   // 子平台编码
    private Integer type;  // 子平台类型，用于归属主平台类型（1-潜水艇, 2-飞机）
}
