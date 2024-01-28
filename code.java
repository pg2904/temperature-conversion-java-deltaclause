import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConversionGUI extends JFrame implements ActionListener
{
	JPanel Panel_Input = new JPanel(); //  panels
	JPanel Panel_Result = new JPanel();//  panels
	JPanel Panel_Buttons = new JPanel();//  panels
	
	JLabel Label_Fahrenheit = new JLabel("ENTER FAHRENHEIT: ");	//  labels
	JLabel Label_Celsius = new JLabel("CELSIUS: ");	//  labels
	
	JTextField TextField_Fahrenheit = new JTextField(10);	//  text fields
	JTextField TextField_Celsius = new JTextField(10); // make this not editable
	
	JButton Button_Calculate = new JButton("CALCULATE"); 	//  buttons for P_Buttons panel.
	JButton Button_Reset = new JButton("RESET"); 	//  buttons for P_Buttons panel.
	JButton Button_Exit = new JButton("EXIT"); 	//  buttons for P_Buttons panel.
	
	TemperatureConversionGUI()
	{	
		this.setTitle("TEMPERATURE CONVERSION"); 		// title for frame.
		
                this.setSize(325, 200); 		// width and height for frame.
		
		this.setResizable(false); 		// frame not resizable.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		// frame to exit the program when user hits 'X' button at top right.
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 		// Center frame on the screen.
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2); 		// Center frame on the screen.
		
		this.setLayout(new BorderLayout());  		// layout manager for the frame to a BorderLayout.
		
		Panel_Input.setPreferredSize(new Dimension(50, 50)); 		//  preferred dimensions for panels.
		Panel_Result.setPreferredSize(new Dimension(50, 50)); 		//  preferred dimensions for panels.
		Panel_Buttons.setPreferredSize(new Dimension(50, 50)); 		//  preferred dimensions for panels.
		
		Panel_Input.add(Label_Fahrenheit); 		//  content for top  panel
		Panel_Input.add(TextField_Fahrenheit); 		//  content for top  panel
		
		Panel_Result.add(Label_Celsius); 		//  content for middle panel
		Panel_Result.add(TextField_Celsius); 		//  content for middle panel
		
		TextField_Celsius.setEditable(false); 		// text field for Celsius not editable.
		
		Button_Calculate.setBounds(new Rectangle(100, 50));  //  boundaries for buttons and add them to the bottom (buttons) panel.
		Panel_Buttons.add(Button_Calculate); 
		
		Button_Exit.setBounds(new Rectangle(100, 50));
		Panel_Buttons.add(Button_Reset);
		
		Button_Reset.setBounds(new Rectangle(100, 50));
		Panel_Buttons.add(Button_Exit);
		
		this.add(Panel_Input, BorderLayout.NORTH); 		//  panels to frame in north locations respectively of the border layout.
		this.add(Panel_Result, BorderLayout.CENTER);		//  panels to frame in center locations respectively of the border layout.
		this.add(Panel_Buttons, BorderLayout.SOUTH);		//  panels to frame in south locations respectively of the border layout.

		Button_Calculate.addActionListener(this);        //  action listeners for buttons.
		Button_Reset.addActionListener(this); 		//  action listeners for buttons.
	    Button_Exit.addActionListener(this); 	       //  action listeners for buttons.
	    
	 	this.setVisible(true);	    // frame is displayed.
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource(); 		//  object to hold which ActionEvent (button press) was activated.
		
		if (source == Button_Calculate)  		// check which button was pressed and act accordingly.
		{
			
			if (isNumeric(TextField_Fahrenheit.getText())) // The Calculate button was pressed!
			{
				double Temperature_F = Double.parseDouble(TextField_Fahrenheit.getText());
				
				double Temperature_C = (5.0 / 9.0) * (Temperature_F - 32);   //  conversion to Celsius.
				
				String output = String.format("%.3f", Temperature_C); 	//  formatted String for output of the temperature in Celsius with a 2 decimal precision.
				
				TextField_Celsius.setText(output); 		//  Celsius text field to output String.
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "your Fahrenheit entry is not numeric.", "Error", JOptionPane.ERROR_MESSAGE);   // The value inside Fahrenheit text field is NOT numeric!
			}
		}
		else if (source == Button_Reset) 
		{
			TextField_Fahrenheit.setText("");     // The Reset button
			TextField_Celsius.setText(""); 			//  text for all TextFields to empty Strings.
		}
		else 
		{ 
			System.exit(0); // The Exit button 
		}
	}
	
	public static void main(String[] args)
	{
		TemperatureConversionGUI TC = new TemperatureConversionGUI();
	}
	
	public static boolean isNumeric(String str) 
	{
		return str != null && str.matches("[-+]?\\d*\\.?\\d+");
	}
}
