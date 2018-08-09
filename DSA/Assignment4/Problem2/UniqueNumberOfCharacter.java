package Question2;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueNumberOfCharacter {

	int getNumberfCharacter(String givenString) {
		HashMap<String, Integer> mapOfWords = new HashMap<String, Integer>();
		String token[] = givenString.split(" ");
		String temp = "";
		int numberInMap=0;
		int tokenLength = 0;
		int number = 0;
		for (int i = 0; i < token.length; i++) {
			
			numberInMap=0;
			for (int j = 0; j < token[i].length(); j++) {
				tokenLength+=token[i].length();
				if(mapOfWords.containsKey(token[i])){
					number+=0;
				}
				else if(temp.indexOf(token[i].charAt(j)) == -1 ){
		             temp = temp + token[i].charAt(j);
		             numberInMap++;
		             number++;
		             
		         }
			}
		
			mapOfWords.put(token[i], numberInMap);
		
		}
		return number;
	}

	public static void main(String[] arg) {
		UniqueNumberOfCharacter uniqueNumberOfCharacter = new UniqueNumberOfCharacter();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter String :");
		String takeString = input.nextLine();
		System.out.println(uniqueNumberOfCharacter
				.getNumberfCharacter(takeString));

	}
}
