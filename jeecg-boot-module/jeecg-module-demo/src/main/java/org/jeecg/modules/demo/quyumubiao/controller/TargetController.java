package org.jeecg.modules.demo.quyumubiao.controller;


import org.jeecg.config.shiro.IgnoreAuth;
import org.jeecg.modules.demo.quyumubiao.entity.Target;
import org.jeecg.modules.demo.quyumubiao.entity.ZoneBuilder;
import org.jeecg.modules.demo.quyumubiao.service.TargetService;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/target")
public class TargetController {

    @Autowired
    private TargetService targetService;

    @GetMapping("/filter")
    @IgnoreAuth
    public Object getPlatforms() {

        // ⚓ 海域
        ZoneBuilder builder = new ZoneBuilder();

        Polygon zone = builder.build(Arrays.asList(
                new double[]{120.0, 30.0},
                new double[]{121.0, 30.0},
                new double[]{121.0, 31.0},
                new double[]{120.0, 31.0}
        ));

        // 🚢 目标
        List<Target> targets = Arrays.asList(
                new Target("A", 120.5, 30.5),
                new Target("B", 122.0, 30.5),
                new Target("C", 120.2, 30.8)
        );


        List<Target> result = targetService.filter(targets, zone);

        System.out.println("命中目标：");

        for (Target t : result) {
            System.out.println(t.id + " in zone");
        }

        return null;
    }
}
