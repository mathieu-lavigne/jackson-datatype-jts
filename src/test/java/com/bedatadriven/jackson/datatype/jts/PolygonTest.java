package com.bedatadriven.jackson.datatype.jts;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;

/**
 * Created by mihaildoronin on 11/11/15.
 */
public class PolygonTest extends BaseJtsModuleTest<Polygon> {
    @Override
    protected Class<Polygon> getType() {
        return Polygon.class;
    }

    @Override
    protected String createGeometryAsGeoJson() {
        return "{\"type\":\"Polygon\",\"coordinates\":[[[102.0,2.0],[103.0,2.0],[103.0,3.0],[102.0,3.0],[102.0,2.0]]]}";
    }

    @Override
    protected Polygon createGeometry() {
        LinearRing shell = gf.createLinearRing(new Coordinate[] {
                new Coordinate(102.0, 2.0), new Coordinate(103.0, 2.0),
                new Coordinate(103.0, 3.0), new Coordinate(102.0, 3.0),
                new Coordinate(102.0, 2.0) });
        LinearRing[] holes = new LinearRing[0];
        return gf.createPolygon(shell, holes);
    }

    @Override
    protected String createGeometryAsGeoJsonWithSrid() {
      return "{\"type\":\"Polygon\",\"coordinates\":[[[102.0,2.0],[103.0,2.0],[103.0,3.0],[102.0,3.0],[102.0,2.0]]],\"srid\":2154}";
    }

    @Override
    protected Polygon createGeometryWithSrid() {
      LinearRing shell = gf.createLinearRing(new Coordinate[] {
            new Coordinate(102.0, 2.0), new Coordinate(103.0, 2.0),
            new Coordinate(103.0, 3.0), new Coordinate(102.0, 3.0),
            new Coordinate(102.0, 2.0) });
      LinearRing[] holes = new LinearRing[0];
      Polygon geom = gf.createPolygon(shell, holes);
      geom.setSRID(2154);
      return geom;
    }
}
