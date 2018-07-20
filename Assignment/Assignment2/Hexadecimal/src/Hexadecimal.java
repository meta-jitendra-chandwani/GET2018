import java.util.Scanner;

public class Hexadecimal {
    private static Scanner sc = new Scanner(System.in);
    public Hexadecimal(String hexafirst, String hexasecond) {
        menuList(hexafirst, hexasecond);
    }

    /*
     * for diplaying the menu option
     * @param first hexadecimal input by user
     * @param second hexadecimal input ub user
     */
    void menuList(String hexafirst, String hexasecond) {
        System.out.println("\n1. Add\n2. Substract\n3. Multiply\n4.Divide\n5. Is Hexa values are equal?\n6. Is First Hexa values is greater?\n7. Is Second Hexa values is greater?");
        System.out.print("Enter your choice : ");
        switch (sc.nextInt()) {
            case 1:
                add(hexafirst, hexasecond);
                break;
            case 2:
                sub(hexafirst, hexasecond);
                break;
            case 3:
                mul(hexafirst, hexasecond);
                break;
            case 4:
                div(hexafirst, hexasecond);
                break;
            case 5:
                isHexaEqual(hexafirst, hexasecond);
                break;
            case 6:
                isHexaFirstGreater(hexafirst, hexasecond);
                break;
            case 7:
                isHexaSecondGreater(hexafirst, hexasecond);
                break;
            default:
                System.out.print("There is no such choice");
        }
    }

    /*
     * converting hexadecimal value to decimal value
     * @param hexadecimal value
     * @return decimal value of respective hexadecimal
     */
    int hexaToDecimal(String hexavalue) { //
        return Integer.parseInt(hexavalue, 16);
    }

    /*
     * converting decimal value to hexadecimal value
     * @param  decimal  value
     * @return hexadecimal value of respective decimal
     */
    String decimalToHexa(int decimalvalue) { //converting decimal value to hexadecimal value
        return Integer.toHexString(decimalvalue);
    }

    /*
     * add two hexadecimal number
     * @param first hexadecimal number
     * @param second hexadecimal number
     */
    void add(String firsthexavalue, String secondhexavalue) { //adding to hexadecimal value
        int firstvalue = hexaToDecimal(firsthexavalue);
        int secondvalue = hexaToDecimal(secondhexavalue);
        int result = firstvalue + secondvalue;
        String resulthexa = decimalToHexa(result);
        display(resulthexa);
    }

    /*
     * subtract two hexadecimal number
     * @param first hexadecimal number
     * @param second hexadecimal number
     */
    void sub(String firsthexavalue, String secondhexavalue) { //subtracting to hexadecimal value
        int firstvalue = hexaToDecimal(firsthexavalue);
        int secondvalue = hexaToDecimal(secondhexavalue);
        int result = firstvalue - secondvalue;
        String resulthexa = decimalToHexa(result);
        display(resulthexa);
    }

    /*
     * multiply two hexadecimal number
     * @param first hexadecimal number
     * @param second hexadecimal number
     */
    void mul(String firsthexavalue, String secondhexavalue) { //multiplying to hexadecimal value
        int firstvalue = hexaToDecimal(firsthexavalue);
        int secondvalue = hexaToDecimal(secondhexavalue);
        int result = firstvalue * secondvalue;
        String resulthexa = decimalToHexa(result);
        display(resulthexa);
    }

    /*
     * divide two hexadecimal number
     * @param first hexadecimal number
     * @param second hexadecimal number
     */
    void div(String firsthexavalue, String secondhexavalue) { //divide to hexadecimal value
        int firstvalue = hexaToDecimal(firsthexavalue);
        int secondvalue = hexaToDecimal(secondhexavalue);
        int result = firstvalue / secondvalue;
        String resulthexa = decimalToHexa(result);
        display(resulthexa);
    }

    /*
     * to check whether two hexadecimal number are equal or not
     * @param first hexadecimal number
     * @param second hexadecimal number
     */
    void isHexaEqual(String firsthexavalue, String secondhexavalue) { //check whether two hexadecimal values are equal or not
        if (firsthexavalue.compareTo(secondhexavalue) == 0) {
            displayBoolean(true);
        } else {
            displayBoolean(false);
        }
    }

    /*
     * to check whether first hexadecimal number is greater then second or not
     * @param first hexadecimal number
     * @param second hexadecimal number
     */
    void isHexaFirstGreater(String firsthexavalue, String secondhexavalue) { //check whether first hexadecimal is greater or not
        if (firsthexavalue.compareTo(secondhexavalue) > 0) {
            displayBoolean(true);
        } else {
            displayBoolean(false);
        }
    }

    /*
     * to check whether second hexadecimal number is greater then first or not
     * @param first hexadecimal number
     * @param second hexadecimal number
     */
    void isHexaSecondGreater(String firsthexavalue, String secondhexavalue) { //check whether second hexadecimal is greater or not
        if (firsthexavalue.compareTo(secondhexavalue) < 0) {
            displayBoolean(true);
        } else {
            displayBoolean(false);
        }
    }

    /*
     * display result such as add,sub,divide,multiply
     * @param resulted value after applying operation
     */
    void display(String result) { //display operation result such as add,sub,divide,multiply
        System.out.println("Result : " + result);
        
    }

    /*
     * display boolean result
     * @param resulted value after applying checking
     */
    void displayBoolean(boolean result) { //
        System.out.print("Result : " + result);
    }

    public static void main(String ard[]) {
        System.out.print("Enter first hexa number : ");
        String firsthexavalue = sc.next();
        System.out.print("Enter second hexa number : ");
        String secondhexavalue = sc.next();
        new Hexadecimal(firsthexavalue, secondhexavalue);

    }
}