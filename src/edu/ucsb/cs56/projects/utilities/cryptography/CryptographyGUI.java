package edu.ucsb.cs56.projects.utilities.cryptography;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.BoxLayout;

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
    String plainText = null;
    String cipherText = null;
    int keyA, keyB;
    String key;

    JFrame frame;
    JButton shift, vigenere, affine, mode;
    JPanel buttonPanel, cipherButtonPanel, modeButtonPanel, textFieldPanel, inputTextPanel, inputKeyTextPanel;
    JTextField input, keyInput;
    JLabel output, inputText, inputKeyText;

    boolean encryptMode = true;

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
	frame.setSize(400,180);
	frame.setTitle("Cryptography Interface");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);

	textFieldPanel = new JPanel();
	textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));

	inputTextPanel = new JPanel();
	inputTextPanel.setLayout(new BoxLayout(inputTextPanel, BoxLayout.X_AXIS));
	inputText = new JLabel();
	inputText.setText("Plaintext: ");
	input = new JTextField();
	inputTextPanel.add(inputText);
	inputTextPanel.add(input);

	inputKeyTextPanel = new JPanel();
	inputKeyTextPanel.setLayout(new BoxLayout(inputKeyTextPanel, BoxLayout.X_AXIS));
	inputKeyText = new JLabel();
	inputKeyText.setText("Key(s): ");
	keyInput = new JTextField();
	inputKeyTextPanel.add(inputKeyText);
	inputKeyTextPanel.add(keyInput);

	textFieldPanel.add(inputTextPanel);
	textFieldPanel.add(inputKeyTextPanel);

	cipherButtonPanel = new JPanel();
	cipherButtonPanel.setLayout(new BoxLayout(cipherButtonPanel, BoxLayout.X_AXIS));

        shift = new JButton("Shift Cipher");
	shift.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    plainText = input.getText();

		    keyA = Integer.parseInt(keyInput.getText());
		    shiftCipher.setCipherKey(keyA);
		    
		    if (encryptMode)
			cipherText = shiftCipher.encrypt(plainText);
		    else
			;//cipherText = shiftCipher.decrypt(plainText);
		    
		    output.setText(cipherText);
		}
	    });
	affine = new JButton("Affine Cipher");
	affine.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    plainText = input.getText();

		    key = keyInput.getText();
		    keyA = Integer.parseInt(key.substring(0, key.indexOf(' ')));
		    keyB = Integer.parseInt(key.substring(key.indexOf(' ') + 1));
		    affineCipher.setKeyA(keyA);
		    affineCipher.setKeyB(keyB);
		    
		    if (encryptMode)
			cipherText = affineCipher.encrypt(plainText);
		    else 
			;//cipherText = affineCipher.decrypt(plainText);
		    
		    output.setText(cipherText);
		}
	    });
	vigenere = new JButton("Vigenere Cipher");
	vigenere.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    plainText = input.getText();

		    key = keyInput.getText();
		    vigenereCipher.setCipherKey(key);
		    
		    if (encryptMode)
			cipherText = vigenereCipher.encrypt(plainText);
		    else
			;//cipherText = vigenereCipher.decrypt(plainText);

		    output.setText(cipherText);
		}
	    });

	cipherButtonPanel.add(shift);
	cipherButtonPanel.add(affine);
	cipherButtonPanel.add(vigenere);

	modeButtonPanel = new JPanel();
	mode = new JButton("Switch to decryption");
	mode.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (encryptMode) {
			encryptMode = false;
			mode.setText("Switch to encryption");
		    } else {
			encryptMode = true;
			mode.setText("Switch to decryption");
		    }
		}
	    });

	modeButtonPanel.add(mode);

	buttonPanel = new JPanel();
	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
	buttonPanel.add(cipherButtonPanel);
	buttonPanel.add(modeButtonPanel);

	frame.getContentPane().add(BorderLayout.CENTER, buttonPanel);

	output = new JLabel();

	frame.getContentPane().add(BorderLayout.NORTH, textFieldPanel);
	frame.getContentPane().add(BorderLayout.SOUTH, output);

	frame.setVisible(true);
    }

}
