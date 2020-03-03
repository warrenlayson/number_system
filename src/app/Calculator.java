package app;

/**
 * Calculator
 */
public class Calculator {

    static int add(int num1, int num2, int base) {
        int[] sum = new int[20];
        int remainder = 0, result = 0, i = 0;

        while (num1 != 0 || num2 != 0) {
            int x = num1 % 10;
            int y = num2 % 10;

            sum[i++] = (x + y + remainder) % base;
            remainder = (x + y + remainder) / base;
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

    static int subtract(int num1, int num2, int base) {
        int[] difference = new int[20];
        int carry = 0, result = 0, i = 0;
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

    static int multiply(int num1, int num2, int base) {
        int result = 0, factor = 1, x;

        while (num2 != 0) {
            // for binary
            if (base == 2) {
                x = num2 % 10;
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

    static String divide(int num1, int num2, int base) {

        int quotient = num1 / num2;
        int remainder = num1 % num2;

        return quotient + "." + remainder;
    }

    static String addHexa(String num1, String num2) {
        String result = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int remainder = 0, sum;
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
            int tmp = i;
            i = j;
            j = tmp;
        }

        if (i == j) {
            while (i >= 0 || j >= 0) {
                int x = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
                int y = Data.HEXA_DIGITS.indexOf(num2.charAt(j));

                sum = (x + y + remainder) % 16;
                remainder = (x + y + remainder) / 16;

                result = Data.DIGITS[sum] + result;
                i--;
                j--;
            }

        } else if (i > j) {
            while (j >= 0) {
                int x = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
                int y = Data.HEXA_DIGITS.indexOf(num2.charAt(j));

                sum = (x + y + remainder) % 16;
                remainder = (x + y + remainder) / 16;

                result = Data.DIGITS[sum] + result;
                i--;
                j--;
            }
            while (i >= 0) {
                int x = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
                sum = (x + remainder) % 16;
                remainder = (x + remainder) / 16;

                result = Data.DIGITS[sum] + result;
                i--;
            }
        }

        if (remainder != 0) {
            result = Data.DIGITS[remainder] + result;
        }
        return result;
    }

    static String subtractHexa(String num1, String num2, int base) {
        String result = "", digits = "0123456789ABCDEF";
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0, difference;
        while (i >= 0 || j >= 0) {
            int x = digits.indexOf(num1.charAt(i)) - carry;
            int y = digits.indexOf(num2.charAt(j));

            if (x < y) {
                x += base;
                carry = 1;
            } else {
                carry = 0;
            }

            difference = x - y;
            result = Data.DIGITS[difference] + result;
            i--;
            j--;
        }
        return result;
    }

    static String multiplyHexa(String num1, String num2) {
        String result = "";
        String result2 = "0";
        int j = num2.length() - 1;
        int counter = 0;
        int remainder = 0;

        while (j >= 0) {
            int x = Data.HEXA_DIGITS.indexOf(num2.charAt(j));
            int i = num1.length() - 1;
            while (i >= 0) {
                int y = Data.HEXA_DIGITS.indexOf(num1.charAt(i));

                int product = (x * y + remainder) % 16;
                remainder = (x * y + remainder) / 16;

                result = Data.DIGITS[product] + result;
                i--;
            }

            if (remainder != 0) {
                result = Data.DIGITS[remainder] + result;
            }
            result2 = addHexa(result, result2);
            result = "";
            result = pad(result, counter);
            j--;
            counter++;
        }
        return result2;
    }

    static String pad(String x, int counter) {
        for (int i = counter; i >= 0; i--) {
            x = "0" + x;
        }

        return x;
    }
}