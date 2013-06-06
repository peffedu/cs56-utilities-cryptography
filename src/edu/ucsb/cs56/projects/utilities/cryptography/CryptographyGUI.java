package edu.ucsb.cs56.projects.utilities.cryptography;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
   A class to implement the Cryptography GUI.
   @author Callum Steele
   @author Miranda Aperghis
   @version Project CS56, S13, 06/05/2013
*/

public class CryptographyGUI
{
    
    ShiftCipher shiftCipher = null;
    AffineCipher affineCipher = null;
    VigenereCipher vigenereCipher = null;
    String inputText = null;

    JFrame frame;
    JButton shift, vigenere, affine;
    JPanel buttonPanel;
    JTextField input;
    JLabel output;

    /** Calls the function to create the GUI.
	@param args Default arguments sent to main.
     */
    public static void main (String[] args) {
	CryptographyGUI cryptoGUI = new CryptographyGUI();

	cryptoGUI.go();
    }

    /** Function that populates and creates the GUI.
     */
    public void go () {
	shiftCipher = new ShiftCipher();
	affineCipher = new AffineCipher();
	vigenereCipher = new VigenereCipher();

	frame = new JFrame();
	frame.setSize(300,180);
	frame.setTitle("Cryptography Interface");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);

	buttonPanel = new JPanel();

        shift = new JButton("Shift Cipher");
	shift.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    inputText = input.getText();
		    System.out.println("Shift button pressed: " + inputText);
		}
	    });
	affine = new JButton("Affine Cipher");
	affine.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.out.println("Affine button pressed.");
		}
	    });
	vigenere = new JButton("Vigenere Cipher");
	vigenere.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.out.println("Vigenere button pressed.");
		}
	    });

	buttonPanel.add(shift);
	buttonPanel.add(affine);
	buttonPanel.add(vigenere);

	frame.getContentPane().add(BorderLayout.CENTER, buttonPanel);

	input = new JTextField();
	output = new JLabel();

	frame.getContentPane().add(BorderLayout.NORTH, input);
	frame.getContentPane().add(BorderLayout.SOUTH, output);

	//frame.add(component);
	frame.setVisible(true);
    }

}
