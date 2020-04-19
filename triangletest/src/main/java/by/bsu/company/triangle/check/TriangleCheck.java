package by.bsu.company.triangle.check;

import by.bsu.company.triangle.exception.TriangleCheckException;

public class TriangleCheck {
    public static boolean checkTriangle(int side1, int side2, int side3) throws TriangleCheckException {
        if (side1 > 0 && side2 > 0 && side3 > 0 ) {
            return side1 < side2 + side3 && side2 < side1 + side3 && side3 < side1 + side2;
        }
        else {
            throw new TriangleCheckException("Zero and negative values aren't allowed here.");
        }
    }
}
