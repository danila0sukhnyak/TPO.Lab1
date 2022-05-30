package task1;

import static java.lang.Float.NaN;

public final class Sin {
    final static double PRECISION = 0.01;

    private Sin() {}

    private static double sinTailor( double val, int n) throws StackOverflowError {
        int sign = (n % 2 == 0) ? 1 : -1;

        return sign * Math.pow(val, 2 * n + 1) / factorial(2 * n + 1);
    }

    public static double sin(double val) {
        if (val > Math.PI || val < -Math.PI) {
            return NaN;
        }
        double result = 0;
        double current = 10;
        double prev = 0;
        int n = 0;
        while (Math.abs(prev - current) >= PRECISION) {
            prev = current;
            current = sinTailor(val, n);
            result += current;
            n++;
        }
        return result;
    }

    private static int factorial(int val) {
        if (val <= 1)
            return 1;
        else
            return val * (factorial(val - 1));
    }
}