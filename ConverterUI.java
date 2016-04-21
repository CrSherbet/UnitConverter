import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterUI extends JFrame {
	private JButton convertButton ;
	private JButton clearButton ;
	private JTextField firstInputField ;
	private JTextField secondInputField ;
	private JComboBox firstUnit ;
	private JComboBox secondUnit ;
	private JLabel equalSign;
	private UnitConverter unitconverter ;
	private JRadioButton leftToRightButton ;
	private JRadioButton rightToLeftButton ;
	private boolean inputLeft ;
	
	
	public ConverterUI ( UnitConverter uc ){
		this.unitconverter = uc ;
		this.setTitle("Distance Converter");
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		initComponent();
		
	}
	
	public void run(){
		
		setResizable(false);
		setVisible(true);
	}
	
	private void initComponent(){
		
		firstInputField = new JTextField( 10 );
		secondInputField = new JTextField( 10 );
		secondInputField.setEditable( false);
		firstUnit = new JComboBox( unitconverter.getUnit());
		secondUnit = new JComboBox( unitconverter.getUnit());
		convertButton = new JButton( "Convert!" );
		clearButton =  new JButton( "Clear");
		equalSign = new JLabel( " = " );
		leftToRightButton = new JRadioButton ( "Left>Right" );
		rightToLeftButton = new JRadioButton ( "Right>Left" );
		inputLeft = true ;
		leftToRightButton.setSelected(true);
		
		this.setBounds( 70 , 70, 640, 100 );
		this.setLayout( new FlowLayout() );
		this.add( firstInputField );
		this.add( firstUnit );
		this.add( equalSign );
		this.add( secondInputField );
		this.add( secondUnit );
		this.add( convertButton );
		this.add( clearButton );
		this.add( leftToRightButton );
		this.add( rightToLeftButton );
		
		
		ActionListener convertButtonAction = new ConvertButtonListener();
		ActionListener clearButtonAction = new ClearButtonListener();
		ActionListener leftToRightButtonAction = new LeftToRightButtonListener();
		ActionListener rightToLeftButtonAction = new RightToLeftButtonListener();
		
		
		convertButton.addActionListener(convertButtonAction);
		firstInputField.addActionListener(convertButtonAction);
		clearButton.addActionListener(clearButtonAction);
		leftToRightButton.addActionListener(leftToRightButtonAction);
		rightToLeftButton.addActionListener(rightToLeftButtonAction);
		
		
	}
	class LeftToRightButtonListener implements ActionListener{
		public void actionPerformed( ActionEvent e){
			secondInputField.setEditable(false);
			firstInputField.setEditable(true);
			rightToLeftButton.setSelected(false);
			inputLeft = true ;
		}
	}
	
	class RightToLeftButtonListener implements ActionListener{
		public void actionPerformed( ActionEvent e){
			firstInputField.setEditable(false);
			secondInputField.setEditable(true);
			leftToRightButton.setSelected(false);
			inputLeft = false ;
		}
	}
	
	class ClearButtonListener implements ActionListener{
		public void actionPerformed( ActionEvent e){
			firstInputField.setText("");
			secondInputField.setText("");
			firstUnit.setSelectedIndex(0);
			secondUnit.setSelectedIndex(0);
		}
	}
	
	class ConvertButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent e){
			String s ;
			if (inputLeft)
				s = firstInputField.getText().trim();
			else
				s = secondInputField.getText().trim();
			
			if(s.length() > 0) {
				double value = Double.valueOf( s );
				double result = unitconverter.convert(value, (Length)firstUnit.getSelectedItem(), (Length)secondUnit.getSelectedItem());
				secondInputField.setText(String.format("%.4f", result));
			}
		}
	}
	
	
	
}
