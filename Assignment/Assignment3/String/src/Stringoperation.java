public class Stringoperation {

    /*
     * compare the two strings whether they are equal or not
     * @param input strings 1
     * @param input strings 2
     * @return 0 if both strings are not equal
     * @return 1 if both strings are equal 
     */
    int compare(String string_one, String string_two) {
        if (string_one.length() != string_two.length()) {
            return 0;
        }

        boolean flg = true;
        for (int i = 0; i < string_one.length(); i++) {
            if (string_one.charAt(i) != string_two.charAt(i)) {
                flg = false;
                break;
            }
        }

        if (flg) {
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
        String updated_String = "";
        for (int i = 0; i < string.length(); i++) {
            char aChar = string.charAt(i);
            if (65 <= aChar && aChar <= 90) {
                updated_String += (char)((aChar + 32));
            } else if (97 <= aChar && aChar <= 122) {
                updated_String += (char)((aChar - 32));
            }
        }

        return updated_String;
    }

    /*
     * reverse the given string
     * @param input string
     * @return reverse of input string
     */
    String reverse(String string) {
        String reverse_string = "";

        for (int i = string.length() - 1; i >= 0; i--) {
            reverse_string += string.charAt(i);
        }
        return reverse_string;
    }

    /*
     * return the longest word in a string
     * @param input string
     * @return the longest word in a string
     */
    String longestWord(String string) {
        String array_string[] = string.split(" ");
        int max = array_string[0].length();
        int index = 0;
        for (int i = 1; i < array_string.length; i++) {
            if (max < array_string[i].length()) {
                max = array_string[i].length();
                index = i;
            }
        }

        return array_string[index];
    }

}