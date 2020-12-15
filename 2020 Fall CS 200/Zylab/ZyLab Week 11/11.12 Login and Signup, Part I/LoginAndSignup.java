///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           11.12 Login and Signup Part 1
// Course:          CS 200 Fall 2020
//
// Author:          Shi Kaiwen
// Email:           kshi42@wisc.edu email address
// Lecturer's Name: Marc Renault
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Derived from Laura "Hobbes" Legault, CS 301 Sp 16
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LoginAndSignup {
	
	
	/**
	 * readFromFile method will read from the database file and save all usernames, 
	 * passwords, and keys in the corresponding ArrayLists.If the file cannot open,
    * output error message: <dbName> cannot open!
	 * @param dbName The file name to save all users, passwords, and keys
	 * @param users
	 * @param pwds
	 * @param keys
	 */
	public static void readFromFile(String dbName, ArrayList<String> users, ArrayList<String> pwds, ArrayList<Integer> keys) {
		Scanner scnr = null;
		File file = new File(dbName);
		try{
			scnr = new Scanner(file);
			while(scnr.hasNextLine()){
				String allInfo = scnr.nextLine();
				String [] allInfoFormated = allInfo.split("\t");
				users.add(allInfoFormated[0]);
				pwds.add(allInfoFormated[1]);
				keys.add(Integer.parseInt(allInfoFormated[2]));
			}
		}catch(FileNotFoundException e){
			System.out.println("<dbname> cannot open!");
		}finally{
			if(scnr != null) scnr.close();
		}	
	}

	/**
	 * writeToFile method write the username password and key back to the file
	 * The username and its corresponding encrypted password and key are written in the same line.
	 * Use tab to separate each of them. If the file cannot open,
    * output error message: <fileName> cannot open!
	 * @param fileName
	 * @param users
	 * @param encryptedpwds
	 * @param keys
	 */
	public static void writeToFile(String fileName, ArrayList<String> users, ArrayList<String> encryptedpwds, ArrayList<Integer> keys) {
		PrintWriter ptWriter = null;
		File file = new File(fileName);
		try{
			ptWriter = new PrintWriter(fileName);
			for(int i = 0; i < users.size(); i++){
				ptWriter.print(users.get(i) + "\t");
				ptWriter.print(encryptedpwds.get(i) + "\t");
				ptWriter.println(keys.get(i));
			}
		} catch (FileNotFoundException e) {
			System.out.println("<dbname> cannot open!");
		} finally {
			if (ptWriter != null){
				ptWriter.close();
			}
		}
	}
	/**
	 * Encrypt the password - shift all the character in the password to the right for key position
	 * @param password
	 * @param key
	 * @return an encrypted password 
	 */

	 /*
		change passed by changing each char by adding key;
		use for loop 
		char a = pwd.charAt(i) + Key;
	*/
	public static String pwdEncryption(String password, int key) {
		
		return null;
	}
	
	/**
	 * Decrypt the password - left shift the encrypted password to key position
	 * @param encryptedPassword
	 * @param key
	 * @return the original password
	 */
	public static String pwdDecryption(String encryptedPassword, int key){
		
		return null;
	}
	/**
	 * Check whether the username and password are correct
	 * if the username does not exist, return "Invalid username"
	 * if the username exists but the password is incorrect, return "Invalid password"
	 * if the username exists and password is correct, return "Successful login"
	 * 
	 * @param users ArrayList contains all usernames
	 * @param pwds ArrayList contains all passwords
	 * @param keys ArrayList contains all keys to encrypt and decrypt
	 * @param userName 
	 * @param password
	 * @return String a message to indicate the login result
	 */
	public static String login (ArrayList<String> users, ArrayList<String> pwds, ArrayList<Integer> keys, String userName, String password) {
		
		return null;
	}
 /**
	 * This method is used for signup
	 * If the newUsername already exists, then the signup action fails and return "Invalid username"
	 * Else signup action succeed and add username, encrypted password and the key to the corresponding ArrayList.
    * return "Successful signup"
	 * @param rand Random instance to generate a random key. The key should in range of [1, 20]
	 * @param users ArrayList contains all usernames
	 * @param pwds ArrayList contains all passwords
	 * @param keys ArrayList contains all keys to encrypt and decrypt
	 * @param newUser new username
	 * @param newPwd new password
	 * @return String a message to indicate the signup result
	 */

	 /*
	 check using unique users name: if there already exists, call wrong; 
	 otherwise add username as well as the password and the keys into the database
	 */
	public static String signup(Random rand, ArrayList<String> users, ArrayList<String> pwds, ArrayList<Integer> keys, String newUser, String newPwd) {
		
		return null;
	}
	/**
	 * Determine whether the new username exists
	 * @param newUser
	 * @param users
	 * @return boolean true if the newUser doesn't exist
	 * 				   false if the newUser already exists
	 */
	public static boolean uniqueUser(String newUser, ArrayList<String> users) {
		
		return false;
	}
	
	public static void main(String[] args) {
		ArrayList<String> users = new ArrayList<>();
		ArrayList<String> passwds = new ArrayList<>();
		ArrayList<Integer> keys = new ArrayList<>();
 
		readFromFile("userDB.txt", users, passwds, keys);
		writeToFile("userDB1.txt", users, passwds, keys);
		
	}

}
