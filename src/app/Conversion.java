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
    static int toDec(String num, int base) {
        int result = 0, ctr = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            result += Data.DIGITS.indexOf(num.charAt(i)) * Math.pow(base, ctr);
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
        while (num != 0) {
            result = Data.DIGITS.charAt(num % base) + result;
            num /= base;
        }
        return result;
    }
}