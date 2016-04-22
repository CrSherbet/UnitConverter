package Lab9;
/**
 * 
 * @author Warisara
 *
 */
public class UnitConverter {
	/**
	 * 
	 * @param amount is value that we input
	 * @param fromUnit is a unit of value that we input
	 * @param toUnit is a unit of value that we want to convert 
	 * @return the value of converting
	 */
	public double convert( double amount , Length fromUnit , Length toUnit ){
		double standradValue = amount * fromUnit.getValue() ;
		return standradValue / toUnit.getValue();
	}
	
	/**
	 * 
	 * @return Array of unit which use enum to create an object
	 */
	public Length[] getUnit(){
		return Length.values();
	}
}
