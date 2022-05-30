package task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {

    @ParameterizedTest(name = "sin({0})")
    @DisplayName("Check PI dots")
    @ValueSource(doubles = {0, Math.PI/12, Math.PI/8, Math.PI/6, Math.PI/4, Math.PI/3, -Math.PI/12, -Math.PI/8, -Math.PI/6, -Math.PI/4, -Math.PI/3, Math.PI})
    void checkPiDots(double param) {
        assertAll(
                () -> assertEquals(Math.sin(param), Sin.sin(param), 0.015)
        );
    }

    @ParameterizedTest(name = "sin({0}) = {1}")
    @DisplayName("Check table dots")
    @CsvFileSource(resources = "/table.csv", numLinesToSkip = 1, delimiter = ';')
    void checkBetweenDotsMinusPiAndPi(double x, double y) {
        assertAll(
                () -> assertEquals(y, Sin.sin(x), 0.01)
        );
    }

    @ParameterizedTest(name = "sin({0})")
    @DisplayName("Check PI dots")
    @ValueSource(doubles = {2*Math.PI})
    void checkPiNan(double param) {
        assertAll(
                () -> assertEquals(Double.NaN, Sin.sin(param), 0.015)
        );
    }
}
