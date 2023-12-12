/* Caitlin Hornbeek
 * Dr. Andrew Steinberg
 * COP3503 Fall 2023
 * Programming Assignment 4
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class SequenceAlignment {
	
	private static Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[] { 'a', 'e', 'i', 'o', 'u' }));
	private static Set<Character> consonants = new HashSet<>(Arrays.asList(new Character[] { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' }));
	
	public int[][] A;
	
	public int sameSymbol = 0;
	public int vowelDiffVow = 1;
	public int consDiffCons = 1;
	public int vowelDiffCons = 3;
	public String str1;
	public String str2;
	
	
	public SequenceAlignment(String string1, String string2) {
		this.str1 = string1;
		this.str2 = string2;
	}
	
	public int alpha(char char1, char char2) {
		if (char1 == char2) {
			return 0;
		} else if(vowels.contains(char1) && vowels.contains(char2)) {
			return vowelDiffVow;
		} else if(consonants.contains(char1) && consonants.contains(char2)) {
			return consDiffCons;
		}
		return vowelDiffCons;
	}
	
	private String boundaries(String sequence){
		return " " + sequence; 
					
	}

	public void computeAlignment(int delta) {
		String new1 = boundaries(str1);
		String new2 = boundaries(str2);
		
		A = new int[new1.length()][new2.length()];
		
		for(int i = 0; i < new1.length(); i++) {
			A[i][0] = i * delta;
		}
		
		for(int j = 0; j < new2.length(); j++) {
			A[0][j] = j * delta;
		}
		
		for(int j = 1; j < new2.length(); j++) {
			for(int i = 1; i < new1.length(); i++) {
				int case1 = alpha(new1.charAt(i), new2.charAt(j)) + A[i - 1][j - 1];
				int case2 = delta + A[i - 1][j];
				int case3 = delta + A[i][j - 1];
				
				if(case1 <= case2 && case1 <= case3) { //Checking minimum
					A[i][j] = case1;
				} else if(case2 <= case1 && case2 <= case3) {
					A[i][j] = case2;
				} else {
					A[i][j] = case3;
				}
			}
		}
		
		
	}
	

	public String getAlignment() {
		String new1 = boundaries(str1);
		String new2 = boundaries(str2);
		String newStr1 = "";
		String newStr2 = "";
		
		int i = new1.length() - 1;
		int j = new2.length() - 1;
		
		//Retrace
		while(i > 0 && j > 0) {
			if(A[i][j] - alpha(new1.charAt(i), new2.charAt(j)) == A[i - 1][j - 1]) { //Case 1
				newStr1 = new1.charAt(i) + newStr1;
				newStr2 = new2.charAt(j) + newStr2;
				i--;
				j--;
			} else if(A[i][j] - 2 == A[i - 1][j]) { 
				newStr1 = new1.charAt(i) + newStr1;
				newStr2 = '-' + newStr2;
				i--;
			} else if(A[i][j] - 2 == A[i][j - 1]) {
				newStr2 = new2.charAt(j) + newStr2;
				newStr1 = '-' + newStr1;
				j--;
			}	
		}
		
		while(i > 0) {
			newStr1 = new1.charAt(i) + newStr1;
			newStr2 = '-' + newStr2;
			i--;
		}
		while(j > 0) {
			newStr2 = new2.charAt(j) + newStr2;
			newStr1 = '-' + newStr1;
			j--;
		}
		
		String alignment = newStr1 + " " + newStr2;
		
		return alignment;
		
		
	}

	
}
