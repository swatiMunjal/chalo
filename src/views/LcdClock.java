package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.fazecast.jSerialComm.SerialPort;

public class LcdClock {
	
	static SerialPort chosenPort;

	public static void main(String[] args) {
		//SerialPort serialPort;
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
		
		PrintWriter output = new PrintWriter(serialPort.getOutputStream());
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			String line = null;// Reading from System.in
			while(true){
				System.out.println("Enter a number: ");
				line = reader.readLine();
				if(line == null || line.length() < 1){
					System.exit(0);
					break;
				}
				output.print(line);
				//once finished
				output.flush(); 				
			}
			reader.close();
		}
		catch(Exception e){
			//try {Thread.sleep(100); } catch(Exception e) {break;}
			e.printStackTrace();
		}
					
	}

}