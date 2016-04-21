
public enum Length {
	METER("Meter",1.0),
	KILOMETER("Kilometer",1000.0),
	CENTIMETER("Centimeter",0.01),
	MILE("Mile",1609.344),
	FOOT("Foot",0.30480),
	WA("Wa",2.0);
	
	private final String name ;
	private final double value ;
	
	private Length (String name , double value){
		this.name = name ;
		this.value = value ;
	}
	
	private String getName(){
		return name ;
	}
	
	public double getValue(){
		return value ;
	}
	
	public String toString(){
		return name ;
	}
	
	
}
