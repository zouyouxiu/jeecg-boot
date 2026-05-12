package org.jeecg.modules.demo.mytest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainSubMapping {
    private Long mainId;   // 主平台ID
    private Long subId;    // 子平台ID
}