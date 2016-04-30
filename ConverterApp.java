package Lab9;

public class ConverterApp {
	/**
	 * Main class for run the program
	 * @param args
	 */
	public static void main(String[] args) {
		// create the object and GUI
		UnitConverter unit = new UnitConverter();
		ConverterUI converterUI = new ConverterUI(unit);
		converterUI.run();
	}

}
