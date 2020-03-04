package app;

import java.util.Scanner;

/**
 * Menu
 */
public class Menu {
    Scanner scan;

    private enum NumberSystems {
        BINARY, NONARY, OCTAL, HEXADECIMAL
    };

    private enum Operations {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION,
    }

    private enum Conversions {
        DECIMAL, BINARY, OCTAL, NONARY, HEXADECIMAL,
    }

    Menu(Scanner scan) {
        this.scan = scan;
    }

    void mainMenu() {
        System.out.print("\tMENU\n1. CALCULATOR\n2. CONVERSION\n3. EXIT\nENTER YOUR CHOICE: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                calculatorMenu();
                break;
            case 2:
                conversionMenu();
                break;
            case 3:
                System.out.println("Exiting application...");
                return;
            default:
                break;
        }
    }

    void calculatorMenu() {
        System.out.print(
                "\tCALCULATOR\n1. BINARY\n2. OCTAL\n3. NONARY\n4. HEXADECIMAL\n5. MAIN MENU\nENTER YOUR CHOICE: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                operationMenu(NumberSystems.BINARY);
                break;
            case 2:
                operationMenu(NumberSystems.OCTAL);
                break;
            case 3:
                operationMenu(NumberSystems.NONARY);
                break;
            case 4:
                operationMenu(NumberSystems.HEXADECIMAL);
                break;
            case 5:
                mainMenu();
                break;
            default:
                break;
        }
    }

    void operationMenu(NumberSystems numberSystem) {
        System.out.print(
                "\tOPERATION\n1. ADDITION\n2. SUBTRACTION\n3. MULTIPLICATION\n4. DIVISION\n5. MAIN MENU\n6. EXIT\nENTER YOUR CHOICE: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                operation(numberSystem, Operations.ADDITION);
                break;
            case 2:
                operation(numberSystem, Operations.SUBTRACTION);
                break;
            case 3:
                operation(numberSystem, Operations.MULTIPLICATION);
                break;
            case 4:
                operation(numberSystem, Operations.DIVISION);
                break;
            case 5:
                mainMenu();
                break;
            default:
                break;
        }
    }

    void operation(NumberSystems numberSystem, Operations operations) {
        int num1;
        int num2;
        String result;
        switch (numberSystem) {
            case BINARY:
                System.out.println(operations + " OF " + numberSystem);
                System.out.print("\nFirst Binary Number: ");
                num1 = scan.nextInt();
                System.out.print("Second Binary Number: ");
                num2 = scan.nextInt();
                result = operate(operations, 2, num1, num2);
                System.out.println("Result: " + result);
                break;
            case OCTAL:
                System.out.println(operations + " OF " + numberSystem);
                System.out.print("\nFirst Octal Number: ");
                num1 = scan.nextInt();
                System.out.print("Second Octal Number: ");
                num2 = scan.nextInt();
                result = operate(operations, 8, num1, num2);
                System.out.println("Result: " + result);
                break;
            case NONARY:
                System.out.println(operations + " OF " + numberSystem);
                System.out.print("\nFirst Nonary Number: ");
                num1 = scan.nextInt();
                System.out.print("Second Nonary Number: ");
                num2 = scan.nextInt();
                result = operate(operations, 9, num1, num2);
                System.out.println("Result: " + result);
                break;
            case HEXADECIMAL:
                System.out.println(operations + " OF " + numberSystem);
                System.out.print("\nFirst Hexadecimal Number: ");
                String hexa1 = scan.next().toUpperCase();
                System.out.print("Second Hexadecimal Number: ");
                String hexa2 = scan.next().toUpperCase();
                result = operateHexa(operations, 16, hexa1, hexa2);
                System.out.println("Result: " + result);
                break;
            default:
                break;
        }
    }

    String operate(Operations operations, int base, int num1, int num2) {
        String result = "";
        switch (operations) {
            case ADDITION:
                result = Calculator.add(num1, num2, base) + "";
                break;
            case SUBTRACTION:
                String sign = num1 < num2 ? "-" : "";
                result = sign + Calculator.subtract(num1, num2, base);
                break;
            case MULTIPLICATION:
                result = Calculator.multiply(num1, num2, base) + "";
                break;
            case DIVISION:
                // result = Calculator.divide(num1, num2, base) + "";
                break;
            default:
                break;
        }

        return result;
    }

    String operateHexa(Operations operations, int base, String num1, String num2) {
        String result = "";
        switch (operations) {
            case ADDITION:
                result = Calculator.addHexa(num1, num2);
                break;
            case SUBTRACTION:
                result = Calculator.subtractHexa(num1, num2, base);
                break;
            case MULTIPLICATION:
                result = Calculator.multiplyHexa(num1, num2);
                break;
            default:
                break;
        }

        return result;
    }

    void conversionMenu() {
        System.out.print(
                "\tCONVERSION\n1. BINARY\n2. OCTAL\n3. NONARY\n4. HEXADECIMAL\n5. MAIN MENU\nENTER YOUR CHOICE: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                conversionsMenu(NumberSystems.BINARY);
                break;
            case 2:
                conversionsMenu(NumberSystems.OCTAL);
                break;
            case 3:
                conversionsMenu(NumberSystems.NONARY);
                break;
            case 4:
                conversionsMenu(NumberSystems.HEXADECIMAL);
                break;
            default:
                break;
        }
    }

    void conversionsMenu(NumberSystems numberSystems) {
        System.out.print(
                "\tCONVERSIONS\n1. TO DECIMAL\n2. TO OCTAL\n3. TO BINARY\n4. TO HEXA\n5. TO NONARY\n6. MAIN MENU\n7. EXIT\nENTER YOUR CHOICE: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                convertScreen(numberSystems, Conversions.DECIMAL);
                break;
            case 2:
                convertScreen(numberSystems, Conversions.OCTAL);
                break;
            case 3:
                convertScreen(numberSystems, Conversions.BINARY);
                break;
            case 4:
                convertScreen(numberSystems, Conversions.HEXADECIMAL);
                break;
            case 5:
                convertScreen(numberSystems, Conversions.NONARY);
                break;
            case 6:
                mainMenu();
                break;
            case 7:
                System.out.println("Exiting application...");
                return;
            default:
                break;
        }

    }

    void convertScreen(NumberSystems numberSystems, Conversions conversions) {
        int num;
        String result;
        switch (numberSystems) {
            case BINARY:
                System.out.println("CONVERSION OF " + numberSystems + " TO " + conversions + "\n");
                System.out.print("Enter binary number: ");
                num = scan.nextInt();
                result = convert(conversions, num, 2);
                System.out.println("Result: " + result);
                break;
            case HEXADECIMAL:
                System.out.println("CONVERSION OF " + numberSystems + " TO " + conversions + "\n");
                System.out.print("Enter hexadecimal number: ");
                String hexa = scan.next().toUpperCase();
                result = convertHexa(conversions, hexa, 16);
                System.out.println("Result: " + result);
                break;
            case NONARY:
                System.out.println("CONVERSION OF " + numberSystems + " TO " + conversions + "\n");
                System.out.print("Enter nonary number: ");
                num = scan.nextInt();
                result = convert(conversions, num, 9);
                System.out.println("Result: " + result);
                break;
            case OCTAL:
                System.out.println("CONVERSION OF " + numberSystems + " TO " + conversions + "\n");
                System.out.print("Enter octal number: ");
                num = scan.nextInt();
                result = convert(conversions, num, 2);
                System.out.println("Result: " + result);
                break;
            default:
                break;
        }
    }

    String convert(Conversions conversions, int num, int base) {
        String result = "";
        switch (conversions) {
            case DECIMAL:
                result = Conversion.toDec(num, base) + "";
                break;
            case OCTAL:
                result = Conversion.toBase(Conversion.toDec(num, base), base);
                break;
            case BINARY:
                result = Conversion.toBase(Conversion.toDec(num, base), base);
                break;
            case HEXADECIMAL:
                result = Conversion.toBase(Conversion.toDec(num, base), base);
                break;
            case NONARY:
                result = Conversion.toBase(Conversion.toDec(num, base), base);
                break;
            default:
                break;
        }
        return result;
    }

    String convertHexa(Conversions conversions, String hexa, int base) {
        String result = "";
        switch (conversions) {
            case DECIMAL:
                result = Conversion.hexaToDec(hexa) + "";
                break;
            case OCTAL:
                result = Conversion.toBase(Conversion.hexaToDec(hexa), 8);
                break;
            case BINARY:
                result = Conversion.toBase(Conversion.hexaToDec(hexa), 2);
                break;
            case HEXADECIMAL:
                result = Conversion.toHexa(Conversion.hexaToDec(hexa));
                break;
            case NONARY:
                result = Conversion.toBase(Conversion.hexaToDec(hexa), 9);
                break;
            default:
                break;
        }
        return result;
    }
}