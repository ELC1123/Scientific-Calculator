package cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cli.Functions;

public class Main {

    // This function checks for a valid double data type input
    public static double getValidDoubleInput(Scanner scanner, String prompt) {
        double num;

        do {
            System.out.print(prompt + "(or type 'exit' to return to menu): "); // Print prompt

            // If input is valid, execute if statement
            // If input is invalid, execute else statement
            if(scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                return num;
            }
            else if(scanner.hasNext("exit")) {
                scanner.next();
                return Double.NaN; 
            }
            else {
                System.out.println("Invalid Input.");
                scanner.next();
            }
        }while(true);
    
    }

    // This function checks for a valid int data type input
    public static int getValidIntInput(Scanner scanner, String prompt) {
        int num;

        do {
            System.out.print(prompt);

            if(scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            }
            else if(scanner.hasNext("exit")) {
                scanner.next();
                return -1; 
            }
            else {
                System.out.println("Invalid Input.");
                scanner.next();
            }
        }while(true);

        return num;
    }

    // This function checks if the input value is NaN
    // This function is used to return to the calculator menu when the user types "exit"
    public static boolean checkExit(double value) {
        return Double.isNaN(value);
    }

    // This function adds an entry to the history log
    // If the history log is over 25 entries long, then the oldest one is deleted
    public static void addToHistory(List<String> history, String entry) {
        if(history.size() >= 25) {
            history.remove(0);
             System.out.println("[...] history truncated");
        }
        history.add(entry);
    }

    public static void main(String[] args) {
        // Create Objects necessary for the program
        Functions func = new Functions();
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();

        // Initialize variables
        double a, b;
        boolean keepRunning = true;
        int choice;

        while(keepRunning) {
            // Display options of the Calculator
            System.out.println("This is a CLI Scientific Calculator (will be upgraded to GUI soon)");
            System.out.println("Calculator Options:\n" + 
                                "[1] Add            [2] Subtract        [3] Multiply\n" +
                                "[4] Divide         [5] Modulo          [6] Factorial\n" +
                                "[7] Sine           [8] Cosine          [9] Tangent\n" +
                                "[10] Logarithm     [11] Exponent       [12] nth Root\n" +
                                "[13] Inverse Sine  [14] Inverse Cosine [15] Inverse Tangent\n" +
                                "[16] Abs. Value\n" +
                                "[17] Deg -> Rad    [18] Rad -> Deg\n" +
                                "[19] C -> F        [20] F -> C\n\n" +
                                "Number Bases Conversions:\n" +
                                "[21] Dec -> Bin    [22] Dec -> Oct     [23] Dec -> Hex\n" +
                                "[24] Bin -> Dec    [25] Oct -> Dec     [26] Hex -> Dec\n" +
                                "[27] Dec -> Bin, Oct, & Dec\n\n" +
                                "History Logs\n" + 
                                "[28] Show History  [29] Clear History\n" + 
                                "[0] Exit");
            
            do {
                // Prompt user to input a number
                System.out.print("Enter the number of the option you want to use: ");

                // If input ins an integer, execute if statement
                // If input is not an integer, execute else statement
                if(scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    
                    // If input is among the choices, execute if statement
                    // If input is not among the choices, execute else statement
                    if(choice >= 0 && choice <= 29) {
                        break;
                    }
                    else {
                        System.out.println("Error! Input is not among the choices. ");
                    }
                }
                else {
                    System.out.println("Error! Input is not an integer. ");
                    scanner.next();
                }
            }while(true);

            // Switch case for Menu Options
            switch (choice) {
                case 0:
                    System.out.println("Thank you! Please use the calculator again!");
                    keepRunning = false;
                    break;
                    
                // Addition case
                case 1:
                    System.out.println("You chose [1] Add");
                    a = getValidDoubleInput(scanner, "Enter 1st Addend: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    b = getValidDoubleInput(scanner, "Enter 2nd Addend: ");
                    if(checkExit(b)) {
                        continue;
                    }

                    double result = func.add(a, b);
                    System.out.println("Sum: " + result);
                    addToHistory(history, "Add: " + a + " + " + b + " = " + result);
                    break;
            
                // Subtraction case
                case 2:
                    System.out.println("You chose [2] Subtract");
                    a = getValidDoubleInput(scanner, "Enter Minuend: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    b = getValidDoubleInput(scanner, "Enter Subtrahend: ");
                    if(checkExit(b)) {
                        continue;
                    }

                    result = func.subtract(a, b);
                    System.out.println("Difference: " + result);
                    addToHistory(history, "Subtract: " + a + " - " + b + " = " + result);
                    break;    

                // Multiplication case
                case 3:
                    System.out.println("You chose [3] Multiply");
                    a = getValidDoubleInput(scanner, "Enter 1st Factor: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    b = getValidDoubleInput(scanner, "Enter 2nd Factor: ");
                    if(checkExit(b)) {
                        continue;
                    }

                    result = func.multiply(a, b);
                    System.out.println("Product: " + result);
                    addToHistory(history, "Multiply: " + a + " * " + b + " = " + result);
                    break;    

                // Division case
                case 4:
                    System.out.println("You chose [4] Divide");
                    do {
                        a = getValidDoubleInput(scanner, "Enter Dividend: ");
                        if(checkExit(a)) {
                            continue;
                        }

                        b = getValidDoubleInput(scanner, "Enter Divisor: ");
                        if(checkExit(b)) {
                            continue;
                        }

                        // Check for divide by 0
                        if(b == 0) {
                            System.out.println("Error! Divide by 0 is not possible.");
                        }
                        else {
                            break;
                        }
                    }while(true);

                    result = func.divide(a, b);
                    System.out.println("Quotient: " + result);
                    addToHistory(history, "Divide: " + a + " / " + b + " = " + result);
                    break;        

                // Modulo Case
                case 5:
                    System.out.println("You chose [5] Modulo");

                    do {
                        a = getValidDoubleInput(scanner, "Enter Dividend: ");
                        if(checkExit(a)) {
                            continue;
                        }

                        b = getValidDoubleInput(scanner, "Enter Divisor: ");
                        if(checkExit(b)) {
                            continue;
                        }

                        // Check for divide by 0
                        if(b == 0) {
                            System.out.println("Error! Divide by 0 is not possible.");
                        }
                        else {
                            break;
                        }
                    }while(true);

                    result = func.modulus(a, b);
                    System.out.println("Modulo (Remainder): " + result);
                    addToHistory(history, "Divide: " + a + " % " + b + " = " + result);
                    break;        

                // Factorial case
                case 6:
                    System.out.println("You chose [6] Factorial");
                    int c = getValidIntInput(scanner, "Enter Number: ");

                    if(c == -1) {
                        continue;
                    }

                    result = func.factorial(c);
                    System.out.println("Result: " + result);
                    addToHistory(history, "Factorial: " + c + "!" + " = " + result);
                    break;        

                // Sine case
                case 7:
                    System.out.println("You chose [7] Sine");
                    a = getValidDoubleInput(scanner, "Enter Angle in Degrees: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    double radA = func.degToRad(a);

                    double result1 = func.sine(a);
                    double result2 = func.sine(radA);
                    System.out.println("Result (in deg): " + String.format("%.6f", result1));
                    System.out.println("Result (in rad): " + String.format("%.6f", result2));
                    addToHistory(history, "Sine (" + a + "°): deg = " +
                        String.format("%.6f", result1) + ", rad = " + String.format("%.6f", result2));
                    break;        

                // Cosine case
                case 8:
                    System.out.println("You chose [8] Cosine");
                    a = getValidDoubleInput(scanner, "Enter Angle in Degrees: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    radA = func.degToRad(a);

                    result1 = func.cosine(a);
                    result2 = func.cosine(radA);
                    System.out.println("Result (in deg): " + String.format("%.6f", result1));
                    System.out.println("Result (in rad): " + String.format("%.6f", result2));
                    addToHistory(history, "Cosine (" + a + "°): deg = " +
                        String.format("%.6f", result1) + ", rad = " + String.format("%.6f", result2));
                    break;        

                // Tangent case
                case 9:
                    System.out.println("You chose [9] Tangent");
                    a = getValidDoubleInput(scanner, "Enter Angle in Degrees: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    radA = func.degToRad(a);

                    result1 = func.tangent(a);
                    result2 = func.tangent(radA);
                    System.out.println("Result (in deg): " + String.format("%.6f", result1));
                    System.out.println("Result (in rad): " + String.format("%.6f", result2));
                    addToHistory(history, "Tangent (" + a + "°): deg = " +
                        String.format("%.6f", result1) + ", rad = " + String.format("%.6f", result2));
                    break;  

                // Logarithm case
                case 10:
                    System.out.println("You chose [10] Logarithm");
                    
                    do {
                        a = getValidDoubleInput(scanner, "Enter Value: ");
                        if(checkExit(a)) {
                            continue;
                        }

                        b = getValidDoubleInput(scanner, "Enter Base: ");
                        if(checkExit(b)) {
                            continue;
                        }
                        
                        // Check if inputs are valid
                        if(a > 0 && b > 1) {
                            break;
                        }
                        else {
                            System.out.println("Error! Invalid Base or Value input.");
                        }
                    }while(true);

                    result = func.logarithm(a, b);
                    
                    if (Double.isNaN(result)) {
                        System.out.println("Error: Logarithm requires value > 0 and base > 1.");
                    } 
                    else {
                        System.out.println("Result: " + String.format("%.6f", result));
                        addToHistory(history, "Logarithm (base " + b + " of " + a + "): Result = " + String.format("%.6f", result));
                    }

                    break;  

                // Exponent case
                case 11:
                    System.out.println("You chose [11] Exponent");
                    a = getValidDoubleInput(scanner, "Enter Base: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    b = getValidDoubleInput(scanner, "Enter Exponent: ");
                    if(checkExit(b)) {
                        continue;
                    }

                    result = func.exponent(a, b);
                    System.out.println("Result: " + result);
                    addToHistory(history, "Exponent: " + a + "^" + b + " = " + result);
                    break;  
                    
                // nth root case
                case 12:
                    System.out.println("You chose [12] nth Root");
                    do {
                        a = getValidDoubleInput(scanner, "Enter Base: ");
                        if(checkExit(a)) {
                            continue;
                        }

                        b = getValidDoubleInput(scanner, "Enter Root: ");
                        if(checkExit(b)) {
                            continue;
                        }

                        if(a < 0 && b % 2 == 0) {
                            System.out.println("Invalid Inputs! Even roots of negative numbers are undefined in real numbers.");
                        }
                        else {
                            break;
                        }
                    }while(true);

                    result = func.nthRoot(a, b);
                    System.out.println("Result: " + String.format("%.6f", result));
                    addToHistory(history, "nth Root (degree " + b + " of " + a + "): result = " +
                        String.format("%.6f", result));
                    break;

                // inverse sine case
                case 13:
                    System.out.println("You chose [13] Inverse Sine");
                    do{
                        a = getValidDoubleInput(scanner, "Enter Angle in degrees: ");
                        if(checkExit(a)) {
                            continue;
                        }
                        if (a < -1 || a > 1) {
                            System.out.println("Error: Input must be between -1 and 1 for inverse sine/cosine.");
                            continue;
                        }
                        else {
                            break;
                        }
                    }while(true);

                    radA = func.degToRad(a);

                    result1 = func.invSine(a);
                    result2 = func.invSine(radA);
                    System.out.println("Result (in deg): " + String.format("%.6f", result1));
                    System.out.println("Result (in rad): " + String.format("%.6f", result2));
                    addToHistory(history, "Inverse Sine (" + a + "°): deg = " +
                        String.format("%.6f", result1) + ", rad = " + String.format("%.6f", result2));
                    break;
                
                // inverse cosine case
                case 14:
                System.out.println("You chose [14] Inverse Cosine");
                    do{
                        a = getValidDoubleInput(scanner, "Enter Angle in degrees: ");
                        if(checkExit(a)) {
                            continue;
                        }
                        if (a < -1 || a > 1) {
                            System.out.println("Error: Input must be between -1 and 1 for inverse sine/cosine.");
                            continue;
                        }
                        else {
                            break;
                        }
                    }while(true);
                    radA = func.degToRad(a);

                    result1 = func.invCosine(a);
                    result2 = func.invCosine(radA);
                    System.out.println("Result (in deg): " + String.format("%.6f", result1));
                    System.out.println("Result (in rad): " + String.format("%.6f", result2));
                    addToHistory(history, "Inverse Cosine (" + a + "°): deg = " +
                        String.format("%.6f", result1) + ", rad = " + String.format("%.6f", result2));
                    break;

                // inverse tangent case
                case 15:
                    System.out.println("You chose [15] Inverse Tangent");
                    a = getValidDoubleInput(scanner, "Enter Angle in degrees: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    radA = func.degToRad(a);

                    result1 = func.invTangent(a);
                    result2 = func.invTangent(radA);
                    System.out.println("Result (in deg): " + String.format("%.6f", result1));
                    System.out.println("Result (in rad): " + String.format("%.6f", result2));
                    addToHistory(history, "Inverse Tangent (" + a + "°): deg = " +
                        String.format("%.6f", result1) + ", rad = " + String.format("%.6f", result2));
                    break;
                
                // absolute value case
                case 16:
                    System.out.println("You chose [16] Absolute Value");
                    a = getValidDoubleInput(scanner, "Enter number: ");
                    if(checkExit(a)) {
                        continue;
                    };

                    result = func.absValue(a);
                    System.out.println("Result: " + result);
                    addToHistory(history, "Absolute Value: |" + a + "| = " + result);
                    break;
                    
                // convert degrees to radians
                case 17:
                    System.out.println("You chose [17] Degrees to Radians");
                    a = getValidDoubleInput(scanner, "Enter Angle in degrees: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    result = func.degToRad(a);
                    System.out.println("Radians: " + String.format("%.6f", result));
                    addToHistory(history, "Degree to Radians: " + a + "deg = " + result + "rad");
                    break;

                // convert radians to degrees    
                case 18:
                    System.out.println("You chose [18] Radians to Degrees");
                    a = getValidDoubleInput(scanner, "Enter Angle in radians: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    result = func.radToDeg(a);
                    System.out.println("Degrees: " + String.format("%.6f", func.radToDeg(a)));
                    addToHistory(history, "Radians to Degrees: " + a + "rad = " + result + "deg");
                    break;

                // C to F
                case 19:
                    System.out.println("You chose [19] Celsius to Fahrenheit");
                    a = getValidDoubleInput(scanner, "Enter Temperature in Celsius: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    result = func.celsiusToFahrenheit(a);
                    System.out.println("Fahrenheit: " + String.format("%.2f", result));
                    addToHistory(history, "Celsius to Fahrenheit: " + a + "C = " + result + "F");
                    break;
                
                // F to C
                case 20:
                    System.out.println("You chose [20] Fahrenheit to Celsius");
                    a = getValidDoubleInput(scanner, "Enter Temperature in Fahrenheit: ");
                    if(checkExit(a)) {
                        continue;
                    }

                    result = func.fahrenheitToCelsius(a);
                    System.out.println("Celsius: " + String.format("%.2f", result));
                    addToHistory(history, "Fahrenheit to Celsius: " + a + "F = " + result + "C");
                    break;

                // decimal to binary
                case 21:
                    System.out.println("You chose [21] Decimal to Binary");
                    int d = getValidIntInput(scanner, "Enter Decimal Number: ");
                    if(d == -1) {
                        continue;
                    }

                    String result3 = func.decToBin(d);
                    System.out.println("Binary: " + result3);
                    addToHistory(history, "Decimal to Binary: " + d + "d = " + result3 + "b");
                    break;

                // decimal to octal
                case 22:
                    System.out.println("You chose [22] Decimal to Octal");
                    d = getValidIntInput(scanner, "Enter Decimal Number: ");
                    if(d == -1) {
                        continue;
                    }

                    result3 = func.decToOct(d);
                    System.out.println("Octal: " + result3);
                    addToHistory(history, "Decimal to Octal: " + d + "d = " + result3 + "o");
                    break;

                // decimal to hex
                case 23:
                    System.out.println("You chose [23] Decimal to Hexadecimal");
                    d = getValidIntInput(scanner, "Enter Decimal Number: ");
                    if(d == -1) {
                        continue;
                    }

                    result3 = func.decToHex(d);
                    System.out.println("Hexadecimal: " + result3);
                    addToHistory(history, "Decimal to Hexadecimal: " + d + "d = " + result3 + "h");
                    break;

                // binary to decimal
                case 24:
                    System.out.println("You chose [24] Binary to Decimal");
                    do {
                        System.out.print("Enter Binary: ");
                        String binary = scanner.next();
                        if(!func.isValidBinary(binary)) {
                            System.out.println("Invalid binary number.");
                            continue;
                        }
                        else {
                            int dec = func.binToDec(binary);
                            System.out.println("Decimal: " + dec);
                            addToHistory(history, "Binary to Decimal: " + binary + "b = " + dec + "d");
                            break;
                        }
                    }while(true);
                    break;

                // octal to decimal
                case 25:
                    System.out.println("You chose [25] Octal to Decimal");
                    do {
                        System.out.print("Enter Octal: ");
                        String octal = scanner.next();
                        if(!func.isValidOctal(octal)) {
                            System.out.println("Invalid octal number.");
                            continue;
                        }
                        else {
                            int dec = func.octToDec(octal);
                            System.out.println("Decimal: " + dec);
                            addToHistory(history, "Octal to Decimal: " + octal + "o = " + dec + "d");
                            break;
                        }
                    }while(true);
                    break;

                // hex to decimal
                case 26:
                    System.out.println("You chose [26] Hexadecimal to Decimal");
                    do {
                        System.out.print("Enter Hex: ");
                        String hex = scanner.next();
                        if(!func.isValidHex(hex)) {
                            System.out.println("Invalid hexadecimal number.");
                            continue;
                        }
                        else {
                            int dec = func.hexToDec(hex);
                            System.out.println("Decimal: " + dec);
                            addToHistory(history, "Hexadecimal to Decimal: " + hex + "h = " + dec + "d");
                            break;
                        }
                    }while(true);
                    break;

                // decimal to binary, octal, and hexadecimal
                case 27:
                    System.out.println("You chose [27] Decimal to Binary, Octal, and Hexadecimal");
                    d = getValidIntInput(scanner, "Enter Decimal Number: ");
                    if(d == -1) {
                        continue;
                    }

                    String bin = func.decToBin(d);
                    String oct = func.decToOct(d);
                    String hex = func.decToHex(d);
                    System.out.println("Base Conversions for " + d + ":");
                    System.out.println("-------------------------------");
                    System.out.println("Binary: " + bin);
                    System.out.println("Octal: " + oct);
                    System.out.println("Hexadecimal: " + hex);
                    addToHistory(history, "Decimal to Binary, Octal, and Hexadecimal: " + d + "d = " + bin + "b, " + oct + "o, " + hex + "h");
                    break;

                // display history logs
                case 28:
                    System.out.println("You chose [28] Display History");
                    if(history.isEmpty()) {
                        System.out.println("No history logs yet.");
                    }
                    else {
                        System.out.println("Calculation History: ");
                        for(String record : history) {
                            System.out.println("- " + record);
                        }
                    }
                    break;

                // clear history logs
                case 29: 
                    System.out.println("You chose [29] Clear History");
                    
                    do {
                        System.out.print("Are you sure you want to clear the history logs? (y/n) ");
                        String confirm = scanner.next().toLowerCase();

                        if(confirm.equals("y")) {
                            history.clear();
                            System.out.println("History successfully cleared.");
                            break;
                        }
                        else if(confirm.equals("n")) {
                            System.out.println("Clear History cancelled.");
                            break;
                        }
                        else {
                            System.out.println("Invalid Input. Please try again.");
                        }
                    }while(true);


                default:
                    break;
            }

            if(keepRunning) {
                System.out.print("\nWould you like to do another calculation? (y/n) ");
                String response = scanner.next().toLowerCase();
                keepRunning = response.equals("y");
                if(!keepRunning) {
                    System.out.println("Thank you! Please use the calculator again!");
                }
            }
        }
        scanner.close();
    }
}