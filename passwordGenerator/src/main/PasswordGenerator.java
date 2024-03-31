package main;

import java.io.IOException;
import java.lang.String;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public final class PasswordGenerator {
	static final String LOWER = "qwertyuiopasdfghjklzxcvbnm";
	static final String UPPER = "QWERTYUIOPASDFGHJKLZXCVBNM";
	static final String PUNCTUATION = "+=_-,<.>/?;:'!@#$%^&*()";
	static final String DIGITS = "1234567890";
	
	
	private static String BuildString( boolean low, boolean upp, boolean punct, boolean dig ) {
		StringBuilder buildStr = new StringBuilder();
		if( low == upp == punct == dig == false ) {
			return " ";	
		}
		else {
			if(low) {
				buildStr.append(LOWER);
			}
			if(upp) {
				buildStr.append(UPPER);
			}
			if(punct) {
				buildStr.append(PUNCTUATION);
			}
			if(dig) {
				buildStr.append(DIGITS);
			}
			
			return buildStr.toString();
		}
	}
	
	public static void main( String[] args ) throws IOException 
	{
		int lengthPas;
		Scanner IN = new Scanner( System.in );
		lengthPas = IN.nextInt(); //length of password
		IN.close();
		String randomStr = null;
		try {
			randomStr = BuildString(true, true, true, true);
		} catch (Exception e) {
			System.out.println("ERROR");;
		}
		char[] strOut = new char[ lengthPas ]; 
		
		for(int i =0; i < lengthPas; i++) {
			strOut[i] = randomStr.charAt(ThreadLocalRandom.current().nextInt( 0, randomStr.length() + 1 ));
		}
		
		System.out.println( strOut );
	}
	
}
