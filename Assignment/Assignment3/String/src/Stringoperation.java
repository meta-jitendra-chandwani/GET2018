public class Stringoperation {

    /*
     * compare the two strings whether they are equal or not
     * @param input strings 1
     * @param input strings 2
     * @return 0 if both strings are not equal
     * @return 1 if both strings are equal 
     */
    int compare(String stringone, String stringtwo) {
        if (stringone.length() != stringtwo.length()) {
            return 0;
        }

        boolean flag = true;
        for (int i = 0; i < stringone.length(); i++) {
            if (stringone.charAt(i) != stringtwo.charAt(i)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            return 1;
        } else {
            return 0;
        }

    }

    /*
     * change the case of given strings Uppercase to Lowercase  vice-versa
     * @param input string
     * @return change the case of input string
     */
    String changeCase(String string) {
        String updatedstring = "";
        for (int i = 0; i < string.length(); i++) {
            char aChar = string.charAt(i);
            if (65 <= aChar && aChar <= 90) {
                updatedstring += (char)((aChar + 32));
            } else if (97 <= aChar && aChar <= 122) {
                updatedstring += (char)((aChar - 32));
            }
        }

        return updatedstring;
    }

    /*
     * reverse the given string
     * @param input string
     * @return reverse of input string
     */
    String reverse(String string) {
        String reversestring = "";

        for (int i = string.length() - 1; i >= 0; i--) {
            reversestring += string.charAt(i);
        }
        return reversestring;
    }

    /*
     * return the longest word in a string
     * @param input string
     * @return the longest word in a string
     */
    String longestWord(String string) {
        String arraystring[] = string.split(" ");
        int max = arraystring[0].length();
        int index = 0;
        for (int i = 1; i < arraystring.length; i++) {
            if (max < arraystring[i].length()) {
                max = arraystring[i].length();
                index = i;
            }
        }

        return arraystring[index];
    }

}