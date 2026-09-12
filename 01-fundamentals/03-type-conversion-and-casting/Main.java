public class Main {
    public static void main(String[] args) {

        // Widening
        int number = 42;
        double numberDouble = number;

        System.out.println("Original: " + number);
        System.out.println("Converted: " + numberDouble);

        // Narrowing
        double value = 19.99;
        int valueInt = (int) value;

        System.out.println("Original: " + value);
        System.out.println("Converted: " + valueInt);

        // Division
        int a = 10;
        int b = 3;

        int integerDivision = a / b;
        double decimalDivision = (double) a / b;

        System.out.println("Integer Division: " + integerDivision);
        System.out.println("Decimal Division: " + decimalDivision);

        // Overflow
        int maxInt = Integer.MAX_VALUE;
        int overflowedInt = maxInt + 1;

        System.out.println("Max Int: " + maxInt);
        System.out.println("Overflowed Int: " + overflowedInt);
    }
}