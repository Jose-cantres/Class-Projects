//Name: Jose Cantres
//Class: CMP326
//Date: 3/22/18
public class Methods {
	public static void celciusToFahrenheit() {
		double ctofInput,fahrenheit;
		
		ctofInput = Double.parseDouble(TemperatureProgram.dInput.getText());
		//Logic for converting Celcius to Fahrenheit
		fahrenheit = ((ctofInput * 9) /5) + 32;
		//Two decimals after the result + degree symbol
		TemperatureProgram.dOutput.setText(String.format("%.2f" + TemperatureProgram.fDegree, fahrenheit)); 
	}
	public static void celciusToKelvin() {
		double ctokInput, kelvin;
		
		ctokInput = Double.parseDouble(TemperatureProgram.dInput.getText());
		kelvin = ctokInput + 273.15;
		TemperatureProgram.dOutput.setText(String.format("%.2f" + TemperatureProgram.kDegree, kelvin));
	}
	public static void fahrenheitToCelcius() {
		double ftocInput, celcius;
		
		ftocInput = Double.parseDouble(TemperatureProgram.dInput.getText());
		celcius = ((ftocInput - 32) * 5) / 9;
		TemperatureProgram.dOutput.setText(String.format("%.2f" + TemperatureProgram.cDegree, celcius ));
	}
	public static void fahrenheitToKelvin() {
		double ftokInput,kelvin;
		
		ftokInput = Double.parseDouble(TemperatureProgram.dInput.getText());
		kelvin = ((ftokInput + 459.67) *5) / 9;
		TemperatureProgram.dOutput.setText(String.format("%.2f" + TemperatureProgram.kDegree, kelvin));
	}
	public static void kelvinToCelcius() {
		double ktocInput,celcius;
		
		ktocInput = Double.parseDouble(TemperatureProgram.dInput.getText());
		celcius = ktocInput - 273.15;
		TemperatureProgram.dOutput.setText(String.format("%.2f" + TemperatureProgram.cDegree, celcius));
	}
	public static void kelvinToFahrenheit() {
		double ktofInput,fahrenheit;
		
		ktofInput = Double.parseDouble(TemperatureProgram.dInput.getText());
		fahrenheit = ((ktofInput * 9) /5) - 459.67;
		TemperatureProgram.dOutput.setText(String.format("%.2f" + TemperatureProgram.fDegree, fahrenheit));
	}
}
