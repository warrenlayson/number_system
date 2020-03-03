package app;

/**
 * Conversion
 */
public class Conversion {
    static int toDec(int num, int base) {
        int result = 0, counter = 0;

        while (num > 0) {
            result += (num % 10) * Math.pow(base, counter);
            counter++;
            num /= 10;
        }

        return result;
    }

    static String toBin(int num) {
        String result = "";

        while (num > 0) {
            result = Data.DIGITS[num % 2] + result;
            num /= 2;
        }

        return result;
    }

    static String toOctal(int num) {
        String result = "";

        while (num > 0) {
            result = Data.DIGITS[num % 8] + result;
            num /= 8;
        }
        return result;
    }

    static String toHexa(int num) {
        String result = "";

        while (num > 0) {
            result = Data.DIGITS[num % 16] + result;
            num /= 16;
        }

        return result;
    }

    static String toNona(int num) {
        String result = "";
        while (num > 0) {
            result = Data.DIGITS[num % 16] + result;
            num /= 16;
        }

        return result;
    }
}