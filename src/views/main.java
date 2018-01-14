package views;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JSlider;
import com.fazecast.jSerialComm.*;

public class main {

	public static void main(String[] args) {

		//JFrame window = new JFrame();
		//JSlider slider = new JSlider();
		//slider.setMaximum(1023);
		//window.add(slider);
		//window.pack();
		//window.setVisible(true);

		SerialPort[] ports = SerialPort.getCommPorts();
		//System.out.println("Select a port:");
		int i = 1;
		int chosenPort = 1;
		

		SerialPort serialPort = ports[chosenPort - 1];
		if(serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}
		//serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);

		Scanner data = new Scanner(serialPort.getInputStream());
		int value = 0;
		while(data.hasNextLine()){
			System.out.println(data.nextLine());
			//try{value = Integer.parseInt(data.nextLine());}catch(Exception e){}
			//slider.setValue(value);
		}
		System.out.println("Done.");
	}

}