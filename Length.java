package Lab9;
/**
 * 
 * @author Warisara
 *
 */
public enum Length {
	/**
	 * create object of each unit that contain name and value inside the object
	 */
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
	 * 
	 * @param name is name of unit 
	 * @param value is standard value in term of meter unit
	 */
	private Length (String name , double value){
		this.name = name ;
		this.value = value ;
	}
	
	/**
	 * 
	 * @return standard value in term of meter unit
	 */
	public double getValue(){
		return value ;
	}
	
	/**
	 * 
	 * @return name of the unit 
	 */
	public String toString(){
		return name ;
	}
	
	
}
