package Lab9;
/**
 * This class is main function Of converter that will calculate the value and return it
 * @author Warisara
 *
 */
public class UnitConverter {
	/**
	 * This method will calculate the value of the unit to another unit by change the value to standard value
	 * and multiply with real value. Finally, return the result of calculation
	 * 
	 * @param amount is value that we input
	 * @param fromUnit is a unit of value that we input
	 * @param toUnit is a unit of value that we want to convert 
	 * @return the value of converting
	 */
	public double convert( double amount , Unit fromUnit , Unit toUnit ){
		double standardValue = amount * fromUnit.getValue() ;
		return standardValue / toUnit.getValue();
	}
	
	/**
	 * This method will return array of unit that called this method
	 * @return Array of unit which use enum to create an object
	 */
	public Unit[] getUnit(){
		return Length.values();
	}
}
