package natmo2

import com.vividsolutions.jts.geom.Point
class Teste {
	
	Double latitude
	Double longitude

	Point p
	
    static constraints = {
		p nullable:true
    }
	
	def beforeInsert() {
		this.p = JtsService.createPoint(this.latitude, this.longitude)
		println this.p
	}
	
	def beforeUpdate() {
		//this.ponto = JtsService.createPoint(this.latitude, this.longitude)
		println this.p
	}
	
	
	static mapping = {
		p collumn: "Geometry" 
	}
}
