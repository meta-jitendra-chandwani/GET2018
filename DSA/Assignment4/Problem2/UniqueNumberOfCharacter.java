package Question2;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueNumberOfCharacter {

	int getNumberfCharacter(String givenString) {
		HashMap<String, Integer> mapOfWords = new HashMap<String, Integer>();
		String token[] = givenString.split(" ");
		String emptyString = "";
		int numberOfUniqueCharacterInMap = 0;
		int countOfUniqueCharacterInString = 0;
		for (int wordPostion = 0; wordPostion < token.length; wordPostion++) {

			numberOfUniqueCharacterInMap = 0;
			for (int characterPosition = 0; characterPosition < token[wordPostion].length(); characterPosition++) {

				if (mapOfWords.containsKey(token[wordPostion])) {
					break;
				} else if (emptyString.indexOf(token[wordPostion].charAt(characterPosition)) == -1) {
					emptyString = emptyString + token[wordPostion].charAt(characterPosition);
					numberOfUniqueCharacterInMap++;
					countOfUniqueCharacterInString++;
				}
			}
			mapOfWords.put(token[wordPostion], numberOfUniqueCharacterInMap);
		}
		return countOfUniqueCharacterInString;
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
