import java.util.Scanner;

public class Hexadecimal {
    private static Scanner sc = new Scanner(System.in);
    public Hexadecimal(String hexa_first, String hexa_second) {
        menuList(hexa_first, hexa_second);
    }

    void menuList(String hexa_first, String hexa_second) {
        System.out.println("\n1. Add\n2. Substract\n3. Multiply\n4.Divide\n5. Is Hexa values are equal?\n6. Is First Hexa values is greater?\n7. Is Second Hexa values is greater?");
        System.out.print("Enter your choice : ");
        switch (sc.nextInt()) {
            case 1:
                add(hexa_first, hexa_second);
                break;
            case 2:
                sub(hexa_first, hexa_second);
                break;
            case 3:
                mul(hexa_first, hexa_second);
                break;
            case 4:
                div(hexa_first, hexa_second);
                break;
            case 5:
                isHexaEqual(hexa_first, hexa_second);
                break;
            case 6:
                isHexaFirstGreater(hexa_first, hexa_second);
                break;
            case 7:
                isHexaSecondGreater(hexa_first, hexa_second);
                break;
            default:
                System.out.print("There is no such choice");
        }
    }

    int hexaToDecimal(String hexaValue) { //converting hexadecimal value to decimal value
        return Integer.parseInt(hexaValue, 16);
    }

    String decimalToHexa(int decimalValue) { //converting decimal value to hexadecimal value
        return Integer.toHexString(decimalValue);
    }

    void add(String first_hexa_value, String second_hexa_value) { //adding to hexadecimal value
        int first_value = hexaToDecimal(first_hexa_value);
        int second_value = hexaToDecimal(second_hexa_value);
        int result = first_value + second_value;
        String result_hexa = decimalToHexa(result);
        display(result_hexa);
    }

    void sub(String first_hexa_value, String second_hexa_value) { //subtracting to hexadecimal value
        int first_value = hexaToDecimal(first_hexa_value);
        int second_value = hexaToDecimal(second_hexa_value);
        int result = first_value - second_value;
        String result_hexa = decimalToHexa(result);
        display(result_hexa);
    }

    void mul(String first_hexa_value, String second_hexa_value) { //multiplying to hexadecimal value
        int first_value = hexaToDecimal(first_hexa_value);
        int second_value = hexaToDecimal(second_hexa_value);
        int result = first_value * second_value;
        String result_hexa = decimalToHexa(result);
        display(result_hexa);
    }

    void div(String first_hexa_value, String second_hexa_value) { //divide to hexadecimal value
        int first_value = hexaToDecimal(first_hexa_value);
        int second_value = hexaToDecimal(second_hexa_value);
        int result = first_value / second_value;
        String result_hexa = decimalToHexa(result);
        display(result_hexa);
    }

    void isHexaEqual(String first_hexa_value, String second_hexa_value) { //check whether two hexadecimal values are equal or not
        if (first_hexa_value.compareTo(second_hexa_value) == 0) {
            displayBoolean(true);
        } else {
            displayBoolean(false);
        }
    }

    void isHexaFirstGreater(String first_hexa_value, String second_hexa_value) { //check whether first hexadecimal is greater or not
        if (first_hexa_value.compareTo(second_hexa_value) > 0) {
            displayBoolean(true);
        } else {
            displayBoolean(false);
        }
    }

    void isHexaSecondGreater(String first_hexa_value, String second_hexa_value) { //check whether second hexadecimal is greater or not
        if (first_hexa_value.compareTo(second_hexa_value) < 0) {
            displayBoolean(true);
        } else {
            displayBoolean(false);
        }
    }

    void display(String result) { //display operation result such as add,sub,divide,multiply
        System.out.println("Result : " + result);
        
    }

    void displayBoolean(boolean result) { //display boolean result
        System.out.print("Result : " + result);
    }

    public static void main(String ard[]) {
        System.out.print("Enter first hexa number : ");
        String hex_value_first = sc.next();
        System.out.print("Enter second hexa number : ");
        String hex_value_second = sc.next();
        new Hexadecimal(hex_value_first, hex_value_second);

    }
}