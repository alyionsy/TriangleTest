package by.bsu.company.triangle;

import by.bsu.company.triangle.valid.TriangleValidator;
import by.bsu.company.triangle.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestTriangleValidator {
    static Stream<Arguments> intArrayProviderPositive() {
        return Stream.of(
                Arguments.of((Object) new int[]{3, 4, 5}),
                Arguments.of((Object) new int[]{6, 7, 10}),
                Arguments.of((Object) new int[]{10, 25, 30})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderPositive")
    public void triangleValidatorTestPositive(int[] sides) throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> intArrayProviderNegative() {
        return Stream.of(
                Arguments.of((Object) new int[]{3, 4, 9}),
                Arguments.of((Object) new int[]{6, 7, 1}),
                Arguments.of((Object) new int[]{10, 20, 33})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderNegative")
    public void triangleValidatorTestNegative(int[] sides) throws TriangleException {
        Assertions.assertFalse(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> intArrayProviderEquals() {
        return Stream.of(
                Arguments.of((Object) new int[]{3, 4, 7}),
                Arguments.of((Object) new int[]{9, 5, 14}),
                Arguments.of((Object) new int[]{10, 20, 30})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderEquals")
    public void triangleValidatorTestEquals(int[] sides) throws TriangleException {
        Assertions.assertFalse(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> intArrayProviderZero() {
        return Stream.of(
                Arguments.of((Object) new int[]{0, 4, 7}),
                Arguments.of((Object) new int[]{1, 0, 13}),
                Arguments.of((Object) new int[]{2, 3, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderZero")
    public void triangleValidatorTestZero(int[] sides) {
        Assertions.assertThrows(TriangleException.class, () -> {
            TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]);
        });
    }

    static Stream<Arguments> intArrayProviderZeros() {
        return Stream.of(
                Arguments.of((Object) new int[]{0, 0, 7}),
                Arguments.of((Object) new int[]{0, 5, 0}),
                Arguments.of((Object) new int[]{1, 0, 0}),
                Arguments.of((Object) new int[]{0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderZeros")
    public void triangleValidatorTestZeros(int[] sides) {
        Assertions.assertThrows(TriangleException.class, () -> {
            TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]);
        });
    }

    static Stream<Arguments> intArrayProviderNegativeNumber() {
        return Stream.of(
                Arguments.of((Object) new int[]{-5, 4, 7}),
                Arguments.of((Object) new int[]{6, -9, 13}),
                Arguments.of((Object) new int[]{3, 4, -5})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderNegativeNumber")
    public void triangleValidatorTestNegativeNumber(int[] sides) {
        Assertions.assertThrows(TriangleException.class, () -> {
            TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]);
        });
    }

    static Stream<Arguments> intArrayProviderNegativeNumbers() {
        return Stream.of(
                Arguments.of((Object) new int[]{-5, -4, 7}),
                Arguments.of((Object) new int[]{6, -9, -13}),
                Arguments.of((Object) new int[]{-3, 4, -5}),
                Arguments.of((Object) new int[]{-12, -5, -13})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderNegativeNumbers")
    public void triangleValidatorTestNegativeNumbers(int[] sides) {
        Assertions.assertThrows(TriangleException.class, () -> {
            TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]);
        });
    }

    static Stream<Arguments> intArrayProviderIsosceles() {
        return Stream.of(
                Arguments.of((Object) new int[]{5, 4, 4}),
                Arguments.of((Object) new int[]{9, 9, 7}),
                Arguments.of((Object) new int[]{20, 20, 10})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderIsosceles")
    public void triangleValidatorTestIsosceles(int[] sides) throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> intArrayProviderEquilateral() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 1}),
                Arguments.of((Object) new int[]{13, 13, 13}),
                Arguments.of((Object) new int[]{50, 50, 50})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderEquilateral")
    public void triangleValidatorTestEquilateral(int[] sides) throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }

    static Stream<Arguments> intArrayProviderRight() {
        return Stream.of(
                Arguments.of((Object) new int[]{3, 4, 5}),
                Arguments.of((Object) new int[]{5, 13, 12}),
                Arguments.of((Object) new int[]{33, 56, 65})
        );
    }

    @ParameterizedTest
    @MethodSource("intArrayProviderRight")
    public void triangleValidatorTestRight(int[] sides) throws TriangleException {
        Assertions.assertTrue(TriangleValidator.isTriangleCorrect(sides[0], sides[1], sides[2]));
    }
}
