package app;

import java.util.Scanner;

/**
 * Menu
 */
public class Menu {
    Scanner scan;

    private enum NumberSystems {
        BINARY, NONARY, OCTAL, DECIMAL, HEXADECIMAL
    };

    private enum Operations {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION,
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
        String n1;
        String n2;
        String result;
        switch (numberSystem) {
            case BINARY:
                System.out.println(operations + " OF " + numberSystem);
                System.out.print("\nFirst Binary Number: ");
                n1 = scan.next();
                System.out.print("Second Binary Number: ");
                n2 = scan.next();
                result = operate(operations, n1, n2, 2);
                System.out.println("Result: " + result);
                break;
            case OCTAL:
                System.out.println(operations + " OF " + numberSystem);
                System.out.print("\nFirst Octal Number: ");
                n1 = scan.next();
                System.out.print("Second Octal Number: ");
                n2 = scan.next();
                result = operate(operations, n1, n2, 8);
                System.out.println("Result: " + result);
                break;
            case NONARY:
                System.out.println(operations + " OF " + numberSystem);
                System.out.print("\nFirst Nonary Number: ");
                n1 = scan.next();
                System.out.print("Second Nonary Number: ");
                n2 = scan.next();
                result = operate(operations, n1, n2, 9);
                System.out.println("Result: " + result);
                break;
            case HEXADECIMAL:
                System.out.println(operations + " OF " + numberSystem);
                System.out.print("\nFirst Hexadecimal Number: ");
                n1 = scan.next().toUpperCase();
                System.out.print("Second Hexadecimal Number: ");
                n2 = scan.next().toUpperCase();
                result = operate(operations, n1, n2, 16);
                System.out.println("Result: " + result);
                break;
            default:
                break;
        }
    }

    String operate(Operations operations, String num1, String num2, int base) {
        String result = "";
        switch (operations) {
            case ADDITION:
                result = Calculator.add(num1, num2, base);
                break;
            case SUBTRACTION:
                result = Calculator.subtract(num1, num2, base);
                break;
            case MULTIPLICATION:
                result = Calculator.multiply(num1, num2, base);
                break;
            case DIVISION:
                result = Calculator.divide(num1, num2, base);
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

    void conversionsMenu(NumberSystems numberSystem) {
        System.out.print(
                "\tCONVERSIONS\n1. TO DECIMAL\n2. TO OCTAL\n3. TO BINARY\n4. TO HEXA\n5. TO NONARY\n6. MAIN MENU\n7. EXIT\nENTER YOUR CHOICE: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                convertScreen(numberSystem, NumberSystems.DECIMAL);
                break;
            case 2:
                convertScreen(numberSystem, NumberSystems.OCTAL);
                break;
            case 3:
                convertScreen(numberSystem, NumberSystems.BINARY);
                break;
            case 4:
                convertScreen(numberSystem, NumberSystems.HEXADECIMAL);
                break;
            case 5:
                convertScreen(numberSystem, NumberSystems.NONARY);
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

    void convertScreen(NumberSystems numberSystem, NumberSystems conversion) {
        String num;
        String result;
        switch (numberSystem) {
            case BINARY:
                System.out.println("CONVERSION OF " + numberSystem + " TO " + conversion + "\n");
                System.out.print("Enter binary number: ");
                num = scan.next();
                result = convert(conversion, num, 2);
                System.out.println("Result: " + result);
                break;
            case NONARY:
                System.out.println("CONVERSION OF " + numberSystem + " TO " + conversion + "\n");
                System.out.print("Enter nonary number: ");
                num = scan.next();
                result = convert(conversion, num, 9);
                System.out.println("Result: " + result);
                break;
            case OCTAL:
                System.out.println("CONVERSION OF " + numberSystem + " TO " + conversion + "\n");
                System.out.print("Enter octal number: ");
                num = scan.next();
                result = convert(conversion, num, 8);
                System.out.println("Result: " + result);
                break;
            case HEXADECIMAL:
                System.out.println("CONVERSION OF " + numberSystem + " TO " + conversion + "\n");
                System.out.print("Enter hexadecimal number: ");
                String hexa = scan.next().toUpperCase();
                result = convert(conversion, hexa, 16);
                System.out.println("Result: " + result);
                break;
            default:
                break;
        }
    }

    String convert(NumberSystems numberSystem, String num, int base) {
        String result = "";
        switch (numberSystem) {
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
}