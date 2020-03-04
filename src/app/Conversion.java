package app;

/**
 * Conversion
 */
public class Conversion {
    /**
     * Convert any number system to decimal by providing the @param base 2 - BINARY,
     * 8 - OCTAL, 9 - NONARY,,
     * 
     * @param num
     * @param base
     * @return int result
     */
    static int toDec(int num, int base) {
        int result = 0, counter = 0;
        while (num > 0) {
            result += (num % 10) * Math.pow(base, counter);
            counter++;
            num /= 10;
        }
        return result;
    }

    static int hexaToDec(String hexa) {
        int result = 0, ctr = 0;

        for (int i = hexa.length() - 1; i >= 0; i--) {
            int c = Data.HEXA_DIGITS.indexOf(hexa.charAt(i));

            result += c * Math.pow(16, ctr);
            ctr++;
        }

        return result;
    }

    /**
     * Convert decimal number to the base provided 2 - BINARY, 8 - OCTAL, 9 -
     * NONARY, 16 - HEXADECIMAL
     * 
     * @param num
     * @param base
     * @return String result
     */
    static String toBase(int num, int base) {
        String result = "";
        while (num > 0) {
            result = Data.DIGITS[num % base] + result;
            num /= base;
        }
        return result;
    }

    static String toHexa(int num) {
        String result = "";
        while (num != 0) {
            result = Data.DIGITS[num % 16] + result;
            num /= 16;
        }

        return result;
    }
}