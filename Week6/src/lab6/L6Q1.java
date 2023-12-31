package lab6;

import java.security.SecureRandom;

public class L6Q1 {
	public static boolean isAlphabet(char check) {
		if (check>64 && check<91 || check>96 && check<123) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// ASCII codes
		//char test = 'z';
		//System.out.println((int)test);
		// A = 65 - Z = 90
		// a = 97 - z = 122
		
		SecureRandom random = new SecureRandom();
		char check = (char)random.nextInt(128);
		
		if (isAlphabet(check)) {
			System.out.println("Character ("+check+") is Alphabet");
		} else {
			System.out.println("Character ("+check+") is NOT Alphabet");
		}
		

		
	}

}
