//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.util.Scanner;

public class UserInput {
    public UserInput() {
    }

    public static void main(String[] args) {
        System.out.print("Please enter an int: ");
        int testInt = getInt();
        System.out.print("The value returned by getInt() is: " + testInt + "\n");
        System.out.print("Please enter an int between 2 an 6: ");
        testInt = getInt(2, 6);
        System.out.print("The value returned by getInt(int min, int max) is: " + testInt + "\n");
    }

    public static String getString() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }

    public static String getString(int min, int max) {
        String newString;
        for(newString = getString(); newString.length() < min || newString.length() > max; newString = getString()) {
            System.out.print("Please enter between " + min + " and " + max + " characters: ");
        }

        return newString;
    }

    public static char getChar() {
        Scanner input = new Scanner(System.in);

        String newString;
        for(newString = input.nextLine(); newString.length() > 1; newString = input.nextLine()) {
            System.out.print("Please enter only 1 character: ");
        }

        char newChar = newString.charAt(0);
        return newChar;
    }

    public static char getChar(char min, char max) {
        char newChar;
        for(newChar = getChar(); newChar < min || newChar > max; newChar = getChar()) {
            System.out.print("Please enter a character between " + min + " and " + max + ": ");
        }

        return newChar;
    }

    public static double getDouble() {
        Scanner input = new Scanner(System.in);
        double aDub = input.nextDouble();
        return aDub;
    }

    public static double getDouble(double min, double max) {
        double newDouble;
        for(newDouble = getDouble(); newDouble < min || newDouble > max; newDouble = getDouble()) {
            System.out.print("Please enter a number between " + min + " and " + max + ": ");
        }

        return newDouble;
    }

    public static int getInt() {
        Scanner input = new Scanner(System.in);
        boolean i = false; //Wrong datatype

        while(true) {
            String userInput = input.nextLine();

            try {
                return Integer.parseInt(userInput);
            } catch (NumberFormatException var4) {
                System.out.println("Please enter a number:");
            }
        }
    }

    public static int getInt(int min, int max) {
        int newInt;
        for(newInt = getInt(); newInt < min || newInt > max; newInt = getInt()) {
            System.out.print("Please enter a number between " + min + " and " + max + ": ");
        }

        return newInt;
    }
}
