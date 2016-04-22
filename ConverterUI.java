package Lab9;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Warisara
 *
 */
public class ConverterUI extends JFrame {
	
	// attributes for graphical component
	private JButton convertButton;
	private JButton clearButton;
	private JTextField firstInputField;
	private JTextField secondInputField;
	private JComboBox firstUnit;
	private JComboBox secondUnit;
	private JLabel equalSign;
	private UnitConverter unitconverter;
	private JRadioButton leftToRightButton;
	private JRadioButton rightToLeftButton;
	private boolean inputLeft;
	
	/**
	 * 
	 * @param uc is unit converter
	 */
	public ConverterUI(UnitConverter uc) {
		this.unitconverter = uc;
		this.setTitle("Distance Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();

	}
	
	// set JFrame to be visible and set size to cannot change
	public void run() {
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * initialize component in the window
	 */
	private void initComponent() {
		// create element components 
		firstInputField = new JTextField(10);
		secondInputField = new JTextField(10);
		firstUnit = new JComboBox(unitconverter.getUnit());
		secondUnit = new JComboBox(unitconverter.getUnit());
		convertButton = new JButton("Convert!");
		clearButton = new JButton("Clear");
		equalSign = new JLabel(" = ");
		leftToRightButton = new JRadioButton("Left>Right");
		rightToLeftButton = new JRadioButton("Right>Left");
		inputLeft = true;
		leftToRightButton.setSelected(true);

		// set bounds and layout of this window
		this.setBounds(70, 70, 640, 100);
		this.setLayout(new FlowLayout());
		
		// add component to the window
		this.add(firstInputField);
		this.add(firstUnit);
		this.add(equalSign);
		this.add(secondInputField);
		this.add(secondUnit);
		this.add(convertButton);
		this.add(clearButton);
		this.add(leftToRightButton);
		this.add(rightToLeftButton);

		// create action listener of each action
		ActionListener convertButtonAction = new ConvertButtonListener();
		ActionListener clearButtonAction = new ClearButtonListener();
		ActionListener leftToRightButtonAction = new LeftToRightButtonListener();
		ActionListener rightToLeftButtonAction = new RightToLeftButtonListener();

		
		// add action listener into the button
		convertButton.addActionListener(convertButtonAction);
		firstInputField.addActionListener(convertButtonAction);
		secondInputField.addActionListener(convertButtonAction);
		clearButton.addActionListener(clearButtonAction);
		leftToRightButton.addActionListener(leftToRightButtonAction);
		rightToLeftButton.addActionListener(rightToLeftButtonAction);

	}
	
	
	// create class for each action listener
	class LeftToRightButtonListener implements ActionListener {
		/**
		 * @param e is event of action listener
		 */
		public void actionPerformed(ActionEvent e) {
			rightToLeftButton.setSelected(false);
			inputLeft = true;
		}
	}

	class RightToLeftButtonListener implements ActionListener {
		/**
		 * @param e is event of action listener 
		 */
		public void actionPerformed(ActionEvent e) {
			leftToRightButton.setSelected(false);
			inputLeft = false;
		}
	}

	class ClearButtonListener implements ActionListener {
		/**
		 * @param e is event of action listener
		 */
		public void actionPerformed(ActionEvent e) {
			firstInputField.setText("");
			secondInputField.setText("");
			firstUnit.setSelectedIndex(0);
			secondUnit.setSelectedIndex(0);
			leftToRightButton.setSelected(true);
			rightToLeftButton.setSelected(false);

		}
	}

	class ConvertButtonListener implements ActionListener {
		/**
		 * @param e is event of action listener
		 */
		public void actionPerformed(ActionEvent e) {
			String inputValue ;
			double result ;
			// check user choose Left>Right or Right>Left Button and get the value
			if (inputLeft)
				inputValue = firstInputField.getText().trim();
			else
				inputValue = secondInputField.getText().trim();

			if (inputValue.length() > 0) {
				//throw exception when input value isn't number or value is alphabet
				try {
					double value = Double.valueOf( inputValue );
					// check user choose Left>Right or Right>Left and set text to another text field
					if (inputLeft) {
						result = unitconverter.convert(value, (Length) firstUnit.getSelectedItem(),
								(Length) secondUnit.getSelectedItem());
						secondInputField.setText(String.format("%.4f", result));
					} else {
						result = unitconverter.convert(value, (Length) secondUnit.getSelectedItem(),
								(Length) firstUnit.getSelectedItem());
						firstInputField.setText(String.format("%.4f", result));
					}
				} catch (NumberFormatException exception) {
					exception.getMessage();
				}
			}
		}
	}
	
	
	
	/**
	 * Main class for run the program
	 * @param args
	 */
	public static void main(String[] args) {
		UnitConverter unit = new UnitConverter();
		ConverterUI converterUI = new ConverterUI(unit);
		converterUI.run();
	}

}
