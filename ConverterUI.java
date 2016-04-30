package Lab9;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is GUI of converter that show two block for input the value and choose the unit by using combo box
 * In this program we can choose side of box that input the number and convert to another box and 
 * it has clear button for clear any data
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
	 * Constructor of ConverterUI
	 * @param uc is unit converter
	 */
	public ConverterUI(UnitConverter uc) {
		// set initial value
		this.unitconverter = uc;
		this.setTitle("Distance Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();

	}
	
	/**
	 * This method will set JFrame to be visible and set size to cannot change
	 */
	public void run() {
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * create initial component of the window
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
	
	/**
	 * This class is action listener of left to right button that will set left-to-right button are selected
	 * @author Warisara
	 */
	class LeftToRightButtonListener implements ActionListener {
		/**
		 * This method is action of left-to-right button
		 * @param e was not used
		 */
		public void actionPerformed(ActionEvent e) {
			rightToLeftButton.setSelected(false);
			inputLeft = true;
		}
	}

	/**
	 * This class is action listener of right to left button that will set left-to-right button are selected
	 * @author Warisara
	 */
	class RightToLeftButtonListener implements ActionListener {
		/**
		 * This method is action of right-to-left button
		 * @param e was not used
		 */
		public void actionPerformed(ActionEvent e) {
			leftToRightButton.setSelected(false);
			inputLeft = false;
		}
	}

	/**
	 * This class is action listener of clear button that will clear any data or set default
	 * @author Warisara
	 */
	class ClearButtonListener implements ActionListener {
		/**
		 * This method is action of clear button
		 * @param e was not used
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
	
	/**
	 * This class is action listener of convert button that will convert from the unit that user choose and input value
	 * to another unit
	 * 
	 * @author Warisara
	 * 
	 */
	class ConvertButtonListener implements ActionListener {
		/**
		 * This method is action of convert button
		 * @param e was not used
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
						result = unitconverter.convert(value, (Unit) firstUnit.getSelectedItem(),
								(Unit) secondUnit.getSelectedItem());
						secondInputField.setText(String.format("%.4f", result));
					} else {
						result = unitconverter.convert(value, (Unit) secondUnit.getSelectedItem(),
								(Unit) firstUnit.getSelectedItem());
						firstInputField.setText(String.format("%.4f", result));
					}
				} catch (NumberFormatException exception) {
					// show message block
					JOptionPane.showMessageDialog(new JDialog(), "The value is invalid. Please input number again.");
					exception.getMessage();
				}
			}
		}
	}
	
}
