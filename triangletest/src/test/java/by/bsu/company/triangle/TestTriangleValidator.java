package by.bsu.company.triangle;

import by.bsu.company.triangle.valid.TriangleValidator;
import by.bsu.company.triangle.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestTriangleValidator {
    static Stream<Arguments> doubleArrayProviderPositive() {
        return Stream.of(
                Arguments.of((Object) new double[]{3.124, 4.43, 5.346}),
                Arguments.of((Object) new double[]{6.124, 7.34, 10.3552}),
                Arguments.of((Object) new double[]{10.124, 25.346, 30.23}),
                Arguments.of((Object) new double[]{2.193, 2.76, 0.93})
        );
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProviderPositive")
    public void triangleValidatorTestPositive(double[] sides) throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> doubleArrayProviderNegative() {
        return Stream.of(
                Arguments.of((Object) new double[]{3.32, 4.67, 9.124}),
                Arguments.of((Object) new double[]{6.1346, 7.42, 0.35}),
                Arguments.of((Object) new double[]{10.876, 20.124, 33.234})
        );
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProviderNegative")
    public void triangleValidatorTestNegative(double[] sides) throws TriangleException {
        Assertions.assertFalse(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> doubleArrayProviderEquals() {
        return Stream.of(
                Arguments.of((Object) new double[]{3.0, 4.0, 7.0}),
                Arguments.of((Object) new double[]{9.0, 5.0, 14.0}),
                Arguments.of((Object) new double[]{10.0, 20.0, 30.0})
        );
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProviderEquals")
    public void triangleValidatorTestEquals(double[] sides) throws TriangleException {
        Assertions.assertFalse(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> doubleArrayProviderZeros() {
        return Stream.of(
                Arguments.of((Object) new double[]{0, 4.32, 7.12}),
                Arguments.of((Object) new double[]{1.234, 0, 13.0}),
                Arguments.of((Object) new double[]{2.235, 3.895, 0}),
                Arguments.of((Object) new double[]{0, 0, 7.32}),
                Arguments.of((Object) new double[]{0, 5.124, 0}),
                Arguments.of((Object) new double[]{1.5, 0, 0}),
                Arguments.of((Object) new double[]{0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProviderZeros")
    public void triangleValidatorTestZeros(double[] sides) {
        Assertions.assertThrows(TriangleException.class, () -> {
            TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]);
        });
    }

    static Stream<Arguments> doubleArrayProviderNegativeNumber() {
        return Stream.of(
                Arguments.of((Object) new double[]{-5.23, 4.246, 7.53}),
                Arguments.of((Object) new double[]{6.124, -9.135, 13.435}),
                Arguments.of((Object) new double[]{3.12, 4.25, -5.622}),
                Arguments.of((Object) new double[]{-5.436, -4.324, 7.0}),
                Arguments.of((Object) new double[]{6.532, -9.523, -13.21}),
                Arguments.of((Object) new double[]{-3.142, 4.234, -5.346}),
                Arguments.of((Object) new double[]{-12.0, -5.124, -13.346})
        );
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProviderNegativeNumber")
    public void triangleValidatorTestNegativeNumber(double[] sides) {
        Assertions.assertThrows(TriangleException.class, () -> {
            TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]);
        });
    }

    static Stream<Arguments> doubleArrayProviderIsosceles() {
        return Stream.of(
                Arguments.of((Object) new double[]{5.0, 4.2, 4.2}),
                Arguments.of((Object) new double[]{9.76, 9.76, 7.33}),
                Arguments.of((Object) new double[]{20.0, 20.0, 10.235})
        );
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProviderIsosceles")
    public void triangleValidatorTestIsosceles(double[] sides) throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> doubleArrayProviderEquilateral() {
        return Stream.of(
                Arguments.of((Object) new double[]{1.0, 1.0, 1.0}),
                Arguments.of((Object) new double[]{13.155, 13.155, 13.155}),
                Arguments.of((Object) new double[]{50.46, 50.46, 50.46})
        );
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProviderEquilateral")
    public void triangleValidatorTestEquilateral(double[] sides) throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> doubleArrayProviderRight() {
        return Stream.of(
                Arguments.of((Object) new double[]{3.0, 4.0, 5.0}),
                Arguments.of((Object) new double[]{5.0, 13.0, 12.0}),
                Arguments.of((Object) new double[]{33.0, 56.0, 65.0})
        );
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProviderRight")
    public void triangleValidatorTestRight(double[] sides) throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }
}
