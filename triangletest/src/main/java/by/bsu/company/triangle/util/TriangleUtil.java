package by.bsu.company.triangle.util;

import by.bsu.company.triangle.exception.TriangleException;

public class TriangleUtil {
    public static boolean isTriangleCorrect(int a, int b, int c) throws TriangleException {
        if (a > 0 && b > 0 && c > 0 ) {
            return a < b + c && b < a + c && c < a + b;
        }
        else {
            throw new TriangleException("Zero and negative values aren't allowed here.");
        }
    }
}
