package app;

/**
 * Data
 */
public class Data {
    static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    static final String HEXA_DIGITS = "0123456789ABCDEF";
}

// String result = "";
// int i = num1.length() - 1;
// int j = num2.length() - 1;
// int remainder = 0, sum;
// if (num1.length() < num2.length()) {
// String temp = num1;
// num1 = num2;
// num2 = temp;
// int tmp = i;
// i = j;
// j = tmp;
// }
// if (i == j) {
// while (i >= 0 || j >= 0) {
// int x = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
// int y = Data.HEXA_DIGITS.indexOf(num2.charAt(j));

// sum = (x + y + remainder) % 16;
// remainder = (x + y + remainder) / 16;

// result = Data.DIGITS[sum] + result;
// i--;
// j--;
// }
// } else if (i > j) {
// while (j >= 0) {
// int x = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
// int y = Data.HEXA_DIGITS.indexOf(num2.charAt(j));

// sum = (x + y + remainder) % 16;
// remainder = (x + y + remainder) / 16;

// result = Data.DIGITS[sum] + result;
// i--;
// j--;
// }
// while (i >= 0) {
// int x = Data.HEXA_DIGITS.indexOf(num1.charAt(i));
// sum = (x + remainder) % 16;
// remainder = (x + remainder) / 16;

// result = Data.DIGITS[sum] + result;
// i--;
// }
// }

// if (remainder != 0) {
// result = Data.DIGITS[remainder] + result;
// }
// return result;

// String result = "";
// String result2 = "0";
// int j = num2.length() - 1;
// int counter = 0;
// int remainder = 0;

// while (j >= 0) {
// int x = Data.HEXA_DIGITS.indexOf(num2.charAt(j));
// int i = num1.length() - 1;
// while (i >= 0) {
// int y = Data.HEXA_DIGITS.indexOf(num1.charAt(i));

// int product = (x * y + remainder) % 16;
// remainder = (x * y + remainder) / 16;

// result = Data.DIGITS[product] + result;
// i--;
// }

// if (remainder != 0) {
// result = Data.DIGITS[remainder] + result;
// }
// result2 = addHexa(result, result2);
// result = "";
// result = pad(result, counter);
// j--;
// counter++;
// }
// return result2;