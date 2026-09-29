package org.jeecg.modules.demo.quyumubiao.entity;

import org.locationtech.jts.geom.*;

import java.util.List;

public class ZoneBuilder {

    private final GeometryFactory factory = new GeometryFactory();

    public Polygon build(List<double[]> points) {

        Coordinate[] coords = new Coordinate[points.size() + 1];

        for (int i = 0; i < points.size(); i++) {
            coords[i] = new Coordinate(points.get(i)[0], points.get(i)[1]);
        }

        coords[points.size()] = coords[0]; // 闭合

        LinearRing ring = factory.createLinearRing(coords);
        return factory.createPolygon(ring);
    }
}