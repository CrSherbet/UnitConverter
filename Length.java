package Lab9;
/**
 * This class is for length unit that contain the many unit : Meter, Kilometer, Centimeter, Mile, Foot, and wa.
 * It has name and standard value of each unit by using enum for store each unit
 * 
 * @author Warisara
 *
 */
public enum Length implements Unit {
	
	// create object of each unit that contain name and value inside the object
	METER("Meter",1.0),
	KILOMETER("Kilometer",1000.0),
	CENTIMETER("Centimeter",0.01),
	MILE("Mile",1609.344),
	FOOT("Foot",0.30480),
	WA("Wa",2.0);
	
	// attributes for each unit
	private final String name ;
	private final double value ;
	
	/**
	 * Constructor of Length class
	 * @param name is name of unit 
	 * @param value is standard value in term of meter unit
	 */
	private Length (String name , double value){
		this.name = name ;
		this.value = value ;
	}
	
	/**
	 * This method will return value of the unit
	 * @return standard value in term of meter unit
	 */
	public double getValue(){
		return value ;
	}
	
	/**
	 * This method will return name of the unit
	 * @return name is name of unit
	 */
	public String toString(){
		return name ;
	}
}
