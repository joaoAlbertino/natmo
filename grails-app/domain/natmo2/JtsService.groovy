package natmo2

import com.vividsolutions.jts.geom.Coordinate
import com.vividsolutions.jts.geom.GeometryFactory
import com.vividsolutions.jts.geom.Point

class JtsService {

	static transactional = false

	static Point createPoint(Double lat, Double lng) {

		if (!lat || !lng) {
			println "Cannot create point with data provided -> lat: ${lat} - lng: ${lng}"
			return null
		}

		try {
			def gf = new GeometryFactory()

			def coord = new Coordinate(lat, lng)

			return gf.createPoint(coord)

		} catch (Exception ex) {

			println  "Could not create a point!", ex

		}
	}
}