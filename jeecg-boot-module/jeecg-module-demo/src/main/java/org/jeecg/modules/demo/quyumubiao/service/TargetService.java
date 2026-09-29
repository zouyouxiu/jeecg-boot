package org.jeecg.modules.demo.quyumubiao.service;

import org.jeecg.modules.demo.quyumubiao.entity.Target;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TargetService {


    private final GeometryFactory factory = new GeometryFactory();

    /**
     * 返回命中目标（在区域内）
     */
    public List<Target> filter(List<Target> targets, Polygon zone) {

        List<Target> result = new ArrayList<>();

        for (Target t : targets) {

            Point p = factory.createPoint(new Coordinate(t.lon, t.lat));

            if (zone.contains(p)) {
                result.add(t);
            }
        }

        return result;
    }

}
