package edu.ucsb.cs56.projects.utilities.cryptography;

/**
   A class to implement the Shift Cipher.
   @author Callum Steele
   @author Miranda Aperghis
   @version Project CS56, S13, 05/29/2013
 */
public class ShiftCipher{
    private int cipherKey;

    /**
       Default no-arg constructor.
    */
    public ShiftCipher(){}

    /**
       One-arg constructor.
       @param cipherKey an integer that is used to encrypt the plaintext
    */
    public ShiftCipher(int cipherKey){
	this.cipherKey = cipherKey;
    }

    /**
       Getter for the cipher key
       @return cipher key integer
    */
    public int getCipherKey(){
	return -42; //STUB
    }

    /** 
	Setter for the cipher key
	@param cipherKey an integer is used to encrypt the plaintext
    */
    public void setCipherKey(int cipherKey){
	this.cipherKey = cipherKey;
    }

    /**
       Encryption algorithm for the shift cipher.
       Takes a word and then shifts the characters by a given number of places through the alphabet, defined by the cipherKey.
       @param word a plaintext word that is to be encrypted
       @return the ciphertext (the encrypted plaintext)
    */
    public String encrypt(String word){
	return "STUB"; //STUB
    }

}
