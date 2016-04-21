
public class UnitConverter {
	public double convert( double amount , Length fromUnit , Length toUnit ){
		double standradValue = amount * fromUnit.getValue() ;
		return standradValue * toUnit.getValue();
	}
	public Length[] getUnit(){
		return Length.values();
	}
}
