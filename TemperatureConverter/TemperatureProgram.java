//Name: Jose Cantres
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JRadioButton;
	import javax.swing.JTextField;
	import javax.swing.ButtonGroup;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	
public class TemperatureProgram {   
	private JFrame frame;  													                // JFrame variable
	protected static JTextField dInput; 												    // Input box for the degrees
	static JTextField dOutput;
    private JLabel label, label2, label3, label4, space, space2, space3, space4, space5, space6; // JLabel variables
    protected JRadioButton celcius;     													// JComboBox variable
	protected JRadioButton celcius2;
	protected JRadioButton fahrenheit;
	protected JRadioButton fahrenheit2;
	protected JRadioButton kelvin;
	protected JRadioButton kelvin2;												   			// JPanel variable
    private String celciusstr = "Celcius      ";											//String variables
    private String fahrenheitstr = "Fahrenheit";
    private String kelvinstr = "Kelvin         ";
    final static char cDegree  = '\u2103';
    final static char fDegree = '\u2109';
    final static char kDegree = '\u212a';
    
	TemperatureProgram(){   
		  //JLabel
	      label = new JLabel("Input",JLabel.CENTER);		 //Creates and sets the Jlabel "Input" in the center
	      label2 = new JLabel("Input Scale");				 //Creates JLabel "Input Scale"
	      label3 = new JLabel("Output Scale");				 //Creates JLabel "Output Scale"
	      label4 = new JLabel("Output");					 //Creates JLabel "Output"
	      space = new JLabel("Long Enough");				 //These are just invisible JLabels for alignment
	      space2 = new JLabel("Space Heros");
	      space3 = new JLabel("Some MoreSpacePlease");
	      space4 = new JLabel("Some More Space");
	      space5 = new JLabel("Some More Space");
	      space6 = new JLabel("Some More Space");
	      
	      //JTextField
	      dInput = new JTextField();					   //Creates a JTextField "dInput"
	      dOutput = new JTextField();					   //Creates a JTextField "dInput"
	      dInput.setPreferredSize(new Dimension(75,20));   //Set the size of the JTextField Input
	      dOutput.setPreferredSize(new Dimension(75,20));  //Set the size of the JTextField Output
	    
	      //JFrame
	      frame = new JFrame(); 						   //Creates JFrame
	      frame.setLayout(new FlowLayout());			   //Creates Layout 
	      frame.setSize(300,225);  						   //Sets Size of the frame
	      frame.setVisible(true);						   //Makes the frame visible
	      
	      
	      //JRadioButtons  
	      celcius = new JRadioButton(celciusstr);
	      celcius.setSelected(true);
	      
	      celcius2 = new JRadioButton(celciusstr);
	      celcius.setSelected(true);
	      
	      fahrenheit = new JRadioButton(fahrenheitstr);
	      fahrenheit.setSelected(true);
	      
	      fahrenheit2 = new JRadioButton(fahrenheitstr);
	      fahrenheit2.setSelected(true);
	      
	      kelvin = new JRadioButton(kelvinstr);
	      kelvin.setSelected(true);
	      
	      kelvin2 = new JRadioButton(kelvinstr);
	      kelvin2.setSelected(true);
	      
	      //Grouping the first buttons
	      ButtonGroup bg = new ButtonGroup();             //Creates Buttongroup
	      bg.add(celcius);								  //adds the buttons to the group
	      bg.add(fahrenheit);
	      bg.add(kelvin);
	      
	      //Grouping the second buttons
	      ButtonGroup bg2 = new ButtonGroup();			  //Creates another Buttongroup for the second buttons
	      bg2.add(celcius2);
	      bg2.add(fahrenheit2);
	      bg2.add(kelvin2);
	      
	      //Giving spaces in FlowLayout between input
	      frame.add(space);
	      space.setForeground(Color.WHITE); 			  //Setting text color to white so it's not visible ;)
	      frame.add(label,BorderLayout.NORTH);  		  //Moves the Jlabel to the top
	      frame.add(dInput, BorderLayout.EAST);			  //Moves the JTextField to the right of label
	      frame.add(space2);
	      space2.setForeground(Color.WHITE);              //Setting text color to white so it's not visible ;)
	      
	      //Label 2 (Input Scale)
	      frame.add(label2);							  //Adding Input Scale to the frame
	      
	      //Space between Input and Output Scale
	      frame.add(space3);
	      space3.setForeground(Color.WHITE);			  //Setting text color to white so it's not visible ;)
	      
	      //Label 3 (Output Scale)				
	      frame.add(label3);							  //Adding Output Scale to the frame
	      
	      //Adding JButton (Celcius)
	      frame.add(celcius);
	      frame.add(space4);
	      space4.setForeground(Color.WHITE);
	      frame.add(celcius2);
	      //celcius.setHorizontalAlignment(SwingConstants.LEFT);
	
	      //Adding Jbutton (Fahrenheit)
	      frame.add(fahrenheit);
	      frame.add(space5);
	      space5.setForeground(Color.WHITE);
	      frame.add(fahrenheit2);
	      
	      //AddingJButton (Kelvin)
	      frame.add(kelvin);
	      frame.add(space6);
	      space6.setForeground(Color.WHITE);
	      frame.add(kelvin2);
	      
	      //Label4 (Output)
	      frame.add(label4);
	      frame.add(dOutput, BorderLayout.EAST);

class RadioListener implements ActionListener {  
	
public void actionPerformed(ActionEvent e) {
System.out.print("The Button was pressed: ");

//Use enter to get conversions

String enterCommand = e.getActionCommand();
if(enterCommand.equals("Enter")) {
//If any of the buttons are selected and the JTextfield in Input is empty then sets the output JTextField to No Input
if ((celcius.isSelected() || celcius2.isSelected() || fahrenheit.isSelected() || fahrenheit2.isSelected() 
	|| kelvin.isSelected() || kelvin2.isSelected()) && dInput.getText().equals("")) {
	dOutput.setText("No Input"); 
}

//If both Celcius buttons are selected then output the result which is the same as what the user input in the input JTextField
else if (celcius.isSelected() && celcius2.isSelected()) {
   System.out.println("both celcius were pressed.");
   double celciusInput;
   
   celciusInput = Double.parseDouble(dInput.getText());
   dOutput.setText(String.format("%.2f" + cDegree, celciusInput));
	}
//If input Celcius button and output Fahrenheit button is selected then call method celciusToFahrenheit which displays
//the conversion in the output JTextField
else if (celcius.isSelected() && fahrenheit2.isSelected()) {
	System.out.println("both celcius and fahrenheit were pressed.");
	Methods.celciusToFahrenheit();
	    }
//If input Celcius button and output Kelvin button is selected then call method celciusToKelvin which displays
//the conversion in the output JTextField
else if (celcius.isSelected() && kelvin2.isSelected()) {
	System.out.println("both celcius and kelvin were pressed.");
	Methods.celciusToKelvin();
}
//If input Fahrenheit button and output Celcius button is selected then call method fahrenheitToCelcius which displays
//the conversion in the output JTextField
else if (fahrenheit.isSelected() && celcius2.isSelected()) {
	System.out.println("both fahrenheit and celcius were pressed.");
	Methods.fahrenheitToCelcius();
	}
//If both Fahrenheit button is selected then output the result which is the same as what the user input in the input JTextField
else if (fahrenheit.isSelected() && fahrenheit2.isSelected()) {
	System.out.println("both fahrenheit were pressed.");
	double fToFInput;
	
	fToFInput = Double.parseDouble(dInput.getText());
	dOutput.setText(String.format("%.2f" + fDegree, fToFInput));
	}
//If input Fahrenheit button and output Kelvin button is selected then call method fahrenheitToKelvin which displays
//the conversion in the output JTextField
else if (fahrenheit.isSelected() && kelvin2.isSelected()) {
	System.out.println("both fahrenheit and kelvin were pressed.");
	Methods.fahrenheitToKelvin();
	}
//If input Kelvin button and output Celcius button is selected then call method kelvinToCelcius which displays
//the conversion in the output JTextField
else if (kelvin.isSelected() && celcius2.isSelected()) {
	System.out.println("both kelvin and celcius were pressed.");
	Methods.kelvinToCelcius();
	}
//If input Kelvin button and output Fahrenheit button is selected then call method kelvinToFahrenheit which displays
//the conversion in the output JTextField
else if (kelvin.isSelected() && fahrenheit2.isSelected()) {
	System.out.println("both kelvin and fahrenheit were pressed.");
	Methods.kelvinToFahrenheit();
	}
//If both Kelvin button is selected then output the result which is the same as what the user input in the input JTextField
else if (kelvin.isSelected() && kelvin2.isSelected()) {
	System.out.println("both kelvin were pressed.");
	double kelvinInput;
	   
	kelvinInput = Double.parseDouble(dInput.getText());
	dOutput.setText(String.format("%.2f" + kDegree, kelvinInput));
		}
	}

//Click buttons for conversion

else {
//If any of the buttons are selected and the JTextfield in Input is empty then sets the output JTextField to No Input
if ((celcius.isSelected() || celcius2.isSelected() || fahrenheit.isSelected() || fahrenheit2.isSelected() 
		|| kelvin.isSelected() || kelvin2.isSelected()) && dInput.getText().equals("")) {
		dOutput.setText("No Input"); 
	}

	//If both Celcius buttons are selected then output the result which is the same as what the user input in the input JTextField
	else if (celcius.isSelected() && celcius2.isSelected()) {
	   System.out.println("both celcius were pressed.");
	   double celciusInput;
	   
	   celciusInput = Double.parseDouble(dInput.getText());
	   dOutput.setText(String.format("%.2f" + cDegree, celciusInput));
		}
	//If input Celcius button and output Fahrenheit button is selected then call method celciusToFahrenheit which displays
	//the conversion in the output JTextField
	else if (celcius.isSelected() && fahrenheit2.isSelected()) {
		System.out.println("both celcius and fahrenheit were pressed.");
		Methods.celciusToFahrenheit();
		    }
	//If input Celcius button and output Kelvin button is selected then call method celciusToKelvin which displays
	//the conversion in the output JTextField
	else if (celcius.isSelected() && kelvin2.isSelected()) {
		System.out.println("both celcius and kelvin were pressed.");
		Methods.celciusToKelvin();
	}
	//If input Fahrenheit button and output Celcius button is selected then call method fahrenheitToCelcius which displays
	//the conversion in the output JTextField
	else if (fahrenheit.isSelected() && celcius2.isSelected()) {
		System.out.println("both fahrenheit and celcius were pressed.");
		Methods.fahrenheitToCelcius();
		}
	//If both Fahrenheit button is selected then output the result which is the same as what the user input in the input JTextField
	else if (fahrenheit.isSelected() && fahrenheit2.isSelected()) {
		System.out.println("both fahrenheit were pressed.");
		double fToFInput;
		
		fToFInput = Double.parseDouble(dInput.getText());
		dOutput.setText(String.format("%.2f" + fDegree, fToFInput));
		}
	//If input Fahrenheit button and output Kelvin button is selected then call method fahrenheitToKelvin which displays
	//the conversion in the output JTextField
	else if (fahrenheit.isSelected() && kelvin2.isSelected()) {
		System.out.println("both fahrenheit and kelvin were pressed.");
		Methods.fahrenheitToKelvin();
		}
	//If input Kelvin button and output Celcius button is selected then call method kelvinToCelcius which displays
	//the conversion in the output JTextField
	else if (kelvin.isSelected() && celcius2.isSelected()) {
		System.out.println("both kelvin and celcius were pressed.");
		Methods.kelvinToCelcius();
		}
	//If input Kelvin button and output Fahrenheit button is selected then call method kelvinToFahrenheit which displays
	//the conversion in the output JTextField
	else if (kelvin.isSelected() && fahrenheit2.isSelected()) {
		System.out.println("both kelvin and fahrenheit were pressed.");
		Methods.kelvinToFahrenheit();
		}
	//If both Kelvin button is selected then output the result which is the same as what the user input in the input JTextField
	else if (kelvin.isSelected() && kelvin2.isSelected()) {
		System.out.println("both kelvin were pressed.");
		double kelvinInput;
		   
		kelvinInput = Double.parseDouble(dInput.getText());
		dOutput.setText(String.format("%.2f" + kDegree, kelvinInput));
			}

		}
	}
}
	    RadioListener Listener = new RadioListener();
	      celcius.addActionListener(Listener);
	      celcius2.addActionListener(Listener);
	      fahrenheit.addActionListener(Listener);
	      fahrenheit2.addActionListener(Listener);
	      kelvin.addActionListener(Listener);
	      kelvin2.addActionListener(Listener);
	      dInput.setActionCommand("Enter");
	      dInput.addActionListener(Listener);
	}
	public static void main(String[] args) {  
	    new TemperatureProgram();     
	}	
}  

