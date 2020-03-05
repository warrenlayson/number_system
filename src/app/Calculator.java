package app;

/**
 * Calculator
 */
public class Calculator {

    /**
     * Add BINARY, OCTAL, NONARY, AND HEXA provided by the base, BINARY - 2, OCTAL -
     * 8, NONARY - 9, HEXA - 16
     * 
     * @param n1
     * @param n2
     * @param base
     * @return result
     */
    static String add(String n1, String n2, int base) {

        String result = "";
        int i = n1.length() - 1, j = n2.length() - 1, sum, rem = 0, x, y;

        while (i >= 0 && j >= 0) {
            x = Data.DIGITS.indexOf(n1.charAt(i));
            y = Data.DIGITS.indexOf(n2.charAt(j));

            sum = (x + y + rem) % base;
            rem = (x + y + rem) / base;
            result = Data.DIGITS.charAt(sum) + result;
            i--;
            j--;
        }
        while (i >= 0) {
            x = Data.DIGITS.indexOf(n1.charAt(i));
            sum = (x + rem) % base;
            rem = (x + rem) / base;
            result = Data.DIGITS.charAt(sum) + result;
            i--;

        }
        while (j >= 0) {
            x = Data.DIGITS.indexOf(n2.charAt(j));
            sum = (x + rem) % base;
            rem = (x + rem) / base;
            result = Data.DIGITS.charAt(sum) + result;
            j--;

        }
        if (rem != 0) {
            result = Data.DIGITS.charAt(rem) + result;
        }

        return result;
    }

    /**
     * Subtract BINARY, OCTAL, NONARY, AND HEXA provided by the base, BINARY - 2,
     * OCTAL - 8, NONARY - 9,AND HEXA - 16
     * 
     * @param n1
     * @param n2
     * @param base
     * @return result
     */
    static String subtract(String n1, String n2, int base) {
        String result = "", radix = "1";
        int carry = 0, diff;

        // Check if num1 < num2, if so use r's
        boolean isNegative = Integer.parseInt(n1, base) < Integer.parseInt(n2, base);

        if (isNegative) {
            // Generate radix 0's
            for (int i = n2.length() - 1; i >= 0; i--) {
                radix += 0;
            }
            // Subtract radix to n2
            int j = radix.length() - 1;
            int k = n2.length() - 1;
            while (k >= 0) {
                int x = Data.DIGITS.indexOf(radix.charAt(j)) - carry;
                int y = Data.DIGITS.indexOf(n2.charAt(k));

                if (x < y) {
                    x += base;
                    carry = 1;
                } else {
                    carry = 0;
                }
                diff = x - y;
                result = Data.DIGITS.charAt(diff) + result;
                k--;
                j--;
            }

            System.out.println(result);

            // Add the 16's complement to n1
            result = add(result, n1, base);

            // Check for overflow and remove
            if (result.length() != n2.length()) {
                result = result.substring(1);
            }

        } else {
            int j = n1.length() - 1;
            int k = n2.length() - 1;
            while (j >= 0 && k >= 0) {
                int x = Data.DIGITS.indexOf(n1.charAt(j)) - carry;
                int y = Data.DIGITS.indexOf(n2.charAt(k));

                if (x < y) {
                    x += base;
                    carry = 1;
                } else {
                    carry = 0;
                }
                diff = x - y;
                result = Data.DIGITS.charAt(diff) + result;
                k--;
                j--;
            }
            while (j >= 0) {
                int x = Data.DIGITS.indexOf(n1.charAt(j)) - carry;
                result = Data.DIGITS.charAt(x) + result;
                j--;
            }
        }

        result = removeLeadingZeroes(result);

        return result;
    }

    private static String removeLeadingZeroes(String result) {
        while (result.indexOf("0") == 0) {
            result = result.substring(1);
        }
        return result;
    }

    /**
     * Multiply BINARY, OCTAL, AND NONARY provided by the base, BINARY - 2, OCTAL -
     * 8, AND NONARY - 9,
     * 
     * @param n1
     * @param n2
     * @param base
     * @return result
     */
    static String multiply(String n1, String n2, int base) {
        String result = "", temp = "";
        int rem = 0, ctr = 0, x, y, i, product;

        for (int j = n2.length() - 1; j >= 0; j--) {
            y = Data.DIGITS.indexOf(n2.charAt(j));
            i = n1.length() - 1;
            for (; i >= 0; i--) {
                x = Data.DIGITS.indexOf(n1.charAt(i));
                product = (x * y + rem) % base;
                rem = (x * y + rem) / base;
                temp = Data.DIGITS.charAt(product) + temp;
                i--;
            }
            if (rem != 0) {
                temp = Data.DIGITS.charAt(rem) + temp;
                rem = 0;
            }
            result = add(result, temp, base);
            temp = "";
            for (int k = ctr; k >= 0; k--) {
                temp += 0;
            }
            ctr++;
        }
        return result;
    }

    /**
     * Divide BINARY, OCTAL, NONARY, and HEXA by base BINARY - 2, OCTAL - 8, NONARY
     * - 9, HEXA - 16
     * 
     * @param n1
     * @param n2
     * @param base
     * @return result
     */
    static String divide(String n1, String n2, int base) {
        int quotient;
        double remainder, decimalPoint, temp;
        String wholeNumber, rem = "";

        quotient = Conversion.toDec(n1, base) / Conversion.toDec(n2, base);
        remainder = (double) Conversion.toDec(n1, base) / Conversion.toDec(n2, base);
        decimalPoint = remainder - quotient;
        wholeNumber = Conversion.toBase(quotient, base);

        while (decimalPoint != 0) {
            temp = decimalPoint * 16;
            decimalPoint = temp - temp;
            rem = Data.DIGITS.charAt((int) decimalPoint) + rem;
        }
        return wholeNumber + "." + rem;
    }
}