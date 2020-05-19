package by.bsu.company.triangle.valid;

import by.bsu.company.triangle.exception.TriangleException;

public class TriangleValidator {
    public static boolean isTriangleCorrect(double a, double b, double c) throws TriangleException {
        if (a > 0 && b > 0 && c > 0 ) {
            return a < b + c && b < a + c && c < a + b;
        }
        else {
            throw new TriangleException("Zero and negative values aren't allowed here.");
        }
    }
}
