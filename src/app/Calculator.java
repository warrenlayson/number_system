package app;

/**
 * Calculator
 */
public class Calculator {

    /**
     * Add BINARY, OCTAL, AND NONARY provided by the base, BINARY - 2, OCTAL - 8,
     * NONARY - 9
     * 
     * @param num1
     * @param num2
     * @param base
     * @return result
     */
    static int add(int num1, int num2, int base) {
        int[] sum = new int[20];
        int remainder = 0, result = 0, i = 0;

        while (num1 != 0 || num2 != 0) {
            sum[i++] = (num1 % 10 + num2 % 10 + remainder) % base;
            remainder = (num1 % 10 + num2 % 10 + remainder) / base;
            num1 /= 10;
            num2 /= 10;
        }
        if (remainder != 0) {
            sum[i++] = remainder;
            i--;
        }
        while (i >= 0) {
            result = result * 10 + sum[i--];
        }
        return result;
    }

    /**
     * Subtract BINARY, OCTAL, AND NONARY provided by the base, BINARY - 2, OCTAL -
     * 8, AND NONARY - 9,
     * 
     * @param num1
     * @param num2
     * @param base
     * @return result
     */
    static int subtract(int num1, int num2, int base) {
        int[] difference = new int[20];
        int carry = 0, result = 0, i = 0;
        // Swaps the values of num1 and num2 if num1 is less than num2
        if (num1 < num2) {
            int z = num1;
            num1 = num2;
            num2 = z;
        }
        while (num1 != 0 || num2 != 0) {
            int x = num1 % 10 - carry;
            int y = num2 % 10;
            if (x < y) {
                x += base;
                carry = 1;
            } else {
                carry = 0;
            }

            difference[i++] = x - y;
            num1 /= 10;
            num2 /= 10;
        }

        while (i >= 0) {
            result = result * 10 + difference[i--];
        }

        return result;
    }

    /**
     * Multiply BINARY, OCTAL, AND NONARY provided by the base, BINARY - 2, OCTAL -
     * 8, AND NONARY - 9,
     * 
     * @param num1
     * @param num2
     * @param base
     * @return result
     */
    static int multiply(int num1, int num2, int base) {
        int result = 0, factor = 1;
        while (num2 != 0) {
            // for binary
            if (base == 2) {
                int x = num2 % 10;
                if (x == 1) {
                    num1 *= factor;
                    result = add(num1, result, base);
                } else {
                    num1 *= factor;
                }
                factor = 10;

                num2 /= 10;
                // for octal
            } else if (base == 8) {
                result = add(num1, result, base);
                num2 -= 1;
                // for nonary
            } else if (base == 9) {
                result = add(num1, result, base);
                num2 -= 1;
            }
        }
        return result;
    }

    /**
     * Divide BINARY, OCTAL, AND NONARY
     * 
     * @param num1
     * @param num2
     * @return result
     */
    // static String divide(int num1, int num2, int base) {

    // }

    static String addHexa(String num1, String num2) {
        String result = "";
        int i = num1.length() - 1, j = num2.length() - 1, remainder = 0, sum;

        while (i >= 0 && j >= 0) {
            int x = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
            int y = Data.HEXA_DIGITS.indexOf(num2.charAt(j));
            sum = (x + y + remainder) % 16;
            remainder = (x + y + remainder) / 16;
            result = Data.DIGITS[sum] + result;
            i--;
            j--;
        }
        if (i > j) {
            while (i >= 0) {
                int x = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
                sum = (x + remainder) % 16;
                remainder = (x + remainder) / 16;
                result = Data.DIGITS[sum] + result;

                i--;
            }
        } else {
            while (j >= 0) {
                int y = Data.HEXA_DIGITS.indexOf(num2.charAt(j));
                sum = (y + remainder) % 16;
                remainder = (y + remainder) / 16;
                result = Data.DIGITS[sum] + result;

                j--;
            }
        }
        if (remainder != 0) {
            result = Data.DIGITS[remainder] + result;
        }

        return result;
    }

    static String subtractHexa(String hexa1, String hexa2, int base) {
        String result = "", sign = (hexa1.length() < hexa2.length()
                || Data.HEXA_DIGITS.indexOf(hexa1.charAt(0)) < Data.HEXA_DIGITS.indexOf(hexa2.charAt(0))) ? "-" : "";
        int i, j, carry = 0, difference;
        if (hexa1.length() < hexa2.length()) {
            String tmp = hexa1;
            hexa1 = hexa2;
            hexa2 = tmp;
            i = hexa1.length() - 1;
            j = hexa2.length() - 1;
        } else {
            i = hexa1.length() - 1;
            j = hexa2.length() - 1;
        }
        while (i >= 0 && j >= 0) {
            int x = Data.HEXA_DIGITS.indexOf(hexa1.charAt(i)) - carry;
            int y = Data.HEXA_DIGITS.indexOf(hexa2.charAt(j));
            x += (x < y && i != j) ? base : 0;
            carry = (x < y && i != j) ? 1 : 0;
            difference = x - y;
            result = Data.DIGITS[Math.abs(difference)] + result;
            i--;
            j--;
        }
        while (i >= 0) {
            int x = Data.HEXA_DIGITS.indexOf(hexa1.charAt(i)) - carry;
            result = Data.DIGITS[x] + result;
            i--;
        }
        return sign + result;
    }

    static String multiplyHexa(String num1, String num2) {
        String temp = "", result = "0";
        int j = num2.length() - 1, counter = 0, remainder = 0;

        while (j >= 0) {
            int x = Data.HEXA_DIGITS.indexOf(num2.charAt(j));
            int i = num1.length() - 1;
            while (i >= 0) {
                int y = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
                int product = (x * y + remainder) % 16;
                remainder = (x * y + remainder) / 16;
                temp = Data.DIGITS[product] + temp;
                i--;
            }
            if (remainder != 0) {
                temp = Data.DIGITS[remainder] + temp;
            }
            result = addHexa(result, temp);
            temp = "";
            temp = pad(temp, counter);
            j--;
            counter++;
        }

        return result;
    }

    static String pad(String x, int counter) {
        for (int i = counter; i >= 0; i--) {
            x = "0" + x;
        }

        return x;
    }

    static String divideHexa(String hexa1, String hexa2) {
        return "";
    }
}