package cli;

import java.lang.Math;

public class Functions {
    /** 
     *  add Function: Adds two double values and returns the sum.
     * 
     * @param a     the first addend
     * @param b     the second addend
     * 
     * @return      the sum of a and b
    */ 
    public double add(double a, double b) {
        double sum = a + b;
        return sum;
    }

    /**
     * subtract Function: subtracts a double by another double
     * 
     * @param a     minuend
     * @param b     subtrahend
     * 
     * @return      difference of a & b
    */
    public double subtract(double a, double b) {
        double difference = a - b;
        return difference;
    }

    /** 
     * multiply Function: Multiplies two double values and returns the product.
     * 
     * @param a     the first factor
     * @param b     the second factor
     * 
     * @return      the product of a and b
    */ 
    public double multiply(double a, double b) {
        double product = a * b;
        return product;
    }

    /** 
     * divide Function: Divides two double values and returns the quotient.
     * 
     * @param a     dividend
     * @param b     divisor
     * 
     * @return      the quotient of a and b
    */ 
    public double divide(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("Error: Cannot divide by 0.");
        }

        double quotient = a / b;
        return quotient;
    }

    /** 
     * modulus Function: Divides two double values and returns the modulo (remainder).
     * 
     * @param a     dividend
     * @param b     divisor
     * 
     * @return      the modulo (remainder) of a and b
    */ 
    public double modulus(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("Error: Cannot divide by 0.");
        }

        double result = a % b;
        return result;
    }
    
    /** 
     * exponent Function: Computes the power of a base raised to an exponent
     * 
     * @param base          base
     * @param exponent      exponent
     * 
     * @return      the result of base^exponent
    */ 
    public double exponent(double base, double exp) {
        double result = Math.pow(base, exp);
        return result;
    }

    /** 
     * sine Function: Gets the sine of an angle.
     * 
     * @param a     the angle (in deg or rad)
     * 
     * @return      the sine of the angle
    */ 
    public double sine(double a) {
        double result = Math.sin(a);
        return result;
    }

    /** 
     * cosine Function: Gets the cosine of an angle.
     * 
     * @param a     the angle (in deg or rad)
     * 
     * @return      the cosine of the angle
    */ 
    public double cosine(double a) {
        double result = Math.cos(a);
        return result;
    }

    /** 
     * tangent Function: Gets the tangent of an angle.
     * 
     * @param a     the angle (in deg or rad)
     * 
     * @return      the tangent of the angle
    */ 
    public double tangent(double a) {
        double result = Math.tan(a);
        return result;
    }

    /** 
     *  factorial Function: Gets the factorial of a number.
     * 
     * @param a     the number
     * 
     * @return      the factorial of the number
    */ 
    public double factorial(int a) {
        double result;
        if(a < 0) {
            throw new IllegalArgumentException("Error: Factorial is not defined for negative numbers. ");
        }
        else if(a <= 1) {
            result = 1;
        }
        else {
            result = 1;
            for(int i = 2; i <= a; i++) {
                result *= i;
            }
        }

        return result;
    }

    /** 
     *  logarithm Function: Gets the logarithm of a given base and value.
     * 
     * @param value     value
     * @param base      base
     * 
     * @return          the logarithm of value and base
    */ 
    public double logarithm(double value, double base) {
        if(value <= 0 || base <= 1) {
            throw new IllegalArgumentException("Value must be GREATER THAN 0 and Base must be GREATER THAN 1");
        }
        
        double result = Math.log(value) / Math.log(base);
        return result;
    }

    /**
     * degToRad Function: Converts a Degrees value to Radians
     * 
     * @param deg       degree value to be converted
     * 
     * @return          the converted radians value
     */
    public double degToRad(double deg) {
        double result = Math.toRadians(deg);
        return result;
    }

    /**
     * squareRoot Function: Gets the square root of a value
     * 
     * @param base         the number whose nth root is to be computed
     * @param root         the degree of the root
     * 
     * @return          the nth root of base
     */
    public double nthRoot(double base, double root) {
        if(base < 0 && root % 2 == 0) {
            throw new IllegalArgumentException("Even roots of negative numbers are undefined in real numbers.");
        }

        double result = Math.pow(base, 1.0/root);
        return result;
    }

    /**
     * absValue Function: Gets the cube root of a value
     * 
     * @param a         the input value of the user
     * 
     * @return          the absolute value result
     */
    public double absValue(double a) {
        double result = Math.abs(a);
        return result;
    }

    /**
     * invSine Function: Gets the inverse sine of an angle
     * 
     * @param a         the angle
     * 
     * @return          the inverse sine of the angle
     */
    public double invSine(double a) {
        double result = Math.asin(a);
        return result;
    }

    /**
     * invCosine Function: Gets the inverse cosine of an angle
     * 
     * @param a         the angle
     * 
     * @return          the inverse cosine of the angle
     */
    public double invCosine(double a) {
        double result = Math.acos(a);
        return result;
    }

    /**
     * invTangent Function: Gets the inverse tangent of an angle
     * 
     * @param a         the angle
     * 
     * @return          the inverse tangent of the angle
     */
    public double invTangent(double a) {
        double result = Math.atan(a);
        return result;
    }

    /**
     * radToDeg Function: Converts Radians to Degrees
     * 
     * @param rad       radians value to be converted
     * 
     * @return          the converted degree value
     */
    public double radToDeg(double rad) {
        double result = Math.toDegrees(rad);
        return result;
    }

    /**
     * celsiusToFahrenheit Function: Converts Celsius to Fahrenheit
     * 
     * @param celsius       Celsius to be converted
     * 
     * @return          the converted degree value
     */
    public double celsiusToFahrenheit(double celsius) {
        double result = (celsius * 1.8) + 32;
        return result;
    }

    /**
     * fahrenheitToCelsius Function: Converts Fahrenheit to Celsius
     * 
     * @param fahrenheit     Fahrenheit to be converted
     * 
     * @return          the converted celsius value
     */
    public double fahrenheitToCelsius(double fahrenheit) {
        double result = (fahrenheit - 32) * 5/9;
        return result;
    }

    /**
     * decToBin: Converts decimal to binary
     * 
     * @param input     decimal input
     * @return          binary of the input
     */
    public String decToBin(int decimal) {
        String result = Integer.toBinaryString(decimal);
        return result;
    }

    /**
     * decToOct: Converts decimal to octal
     * 
     * @param input     decimal input
     * @return          octal of the input
     */
    public String decToOct(int decimal) {
        String result = Integer.toOctalString(decimal);
        return result;
    }

    /**
     * decToHex: Converts decimal to hex
     * 
     * @param input     decimal input
     * @return          hex of the input
     */
    public String decToHex(int decimal) {
        String result = Integer.toHexString(decimal);
        return result;
    }

    /**
     * binToDec: Converts binary to decimal
     * 
     * @param input     binary input
     * @return          decimal of the input
     */
    public int binToDec(String binary) {
        int result = Integer.parseInt(binary, 2);
        return result;
    }

    /**
     * octToDec: Converts octal to decimal
     * 
     * @param input     octal input
     * @return          decimal of the input
     */
    public int octToDec(String octal) {
        int result = Integer.parseInt(octal, 8);
        return result;
    }

    /**
     * hexToDec: Converts hex to decimal
     * 
     * @param input     hex input
     * @return          decimal of the input
     */
    public int hexToDec(String hex) {
        int result = Integer.parseInt(hex, 16);
        return result;
    }

    /**
     * isValidBinary: checks if the binary input is valid
     * @param input     binary input
     * @return          boolean value if the binary input is valid or not
     */
    public boolean isValidBinary(String input) {
        return input.matches("[01]+");
    }
    
    /**
     * isValidOctal: checks if the octal input is valid
     * @param input     octal input
     * @return          boolean value if the octal input is valid or not
     */
    public boolean isValidOctal(String input) {
        return input.matches("[0-7]+");
    }
    
    /**
     * isValidHex: checks if the hex input is valid
     * @param input     hex input
     * @return          boolean value if the hex input is valid or not
     */
    public boolean isValidHex(String input) {
        return input.matches("[0-9a-fA-F]+");
    }
}
