
public class DistanceConverterApp {
	public static void main ( String [] args){
		UnitConverter unit = new UnitConverter();
		ConverterUI converterUI = new ConverterUI( unit );
		converterUI.run();
	}
}
