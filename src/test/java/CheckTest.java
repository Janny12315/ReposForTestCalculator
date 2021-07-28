import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;


public class CheckTest {

    Calculator calculatorCommon = new Calculator(10, 3);

    @Test
    public void testPlus() {
        Calculator calculator = new Calculator(5, 8);
        assertEquals(calculator.calculate('+'), 13);
    }

    @Test
    public void testMinus() {
        Calculator calculator = new Calculator(8, 5);
        assertEquals(calculator.calculate('-'), 3);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator(40, 8);
        assertEquals(calculator.calculate('/'), 5);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator(8, 5);
        assertEquals(calculator.calculate('*'), 40);
    }
    @Test
    public void testDegree() {
        Calculator calculator = new Calculator(3, 3);
        assertEquals(calculator.calculate('^'), 27);
    }
    @Test
    public void testRadical() {
        Calculator calculator = new Calculator(256, 4);
        assertEquals(calculator.calculate('q'), 4);
    }

    @Test
    @DisplayName("ввод некорректных данных")
    void testWrongInputInt() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("./src/main/java/resources/DataForTest.txt"));
        assertThrows(InputMismatchException.class, () -> new Calculator(sc.nextInt(), sc.nextInt()));
    }

    @Test
    @DisplayName("инициализируем калькулятор числом, превышающим максимум")
    public void testWrongInputMaxInt() {
        Calculator calculator = new Calculator(Integer.MAX_VALUE + 10, Integer.MIN_VALUE - 2);
        assertFalse(2147483657F == calculator.getParamList().get(0));
        assertFalse(-2147483650F == calculator.getParamList().get(1));
        // при выходе входных данных за рамки диапазона выбранного типа данных инициализируется неверно
    }

    @ParameterizedTest
    @DisplayName("ввод некорректного символа для операций")
    @ValueSource(chars = {'0', '7', 'o', 'd'})
    void testWrongInputChar(char arg) {
        assertEquals(0, calculatorCommon.calculate(arg));
    }

    @Test
    public void testDivideByZero() {
        assertEquals(0, new Calculator(5555, 0).calculate('/'));
    }

    @ParameterizedTest
    @CsvSource({"1222 , -222, 0", "-99999 , 98998,  2001", "99925, -22222 , -76703"})
    void testPlusParam(int arg1, int arg2, int arg3 ) {
        Calculator calculator = new Calculator(arg1, arg2,arg3 );
        assertEquals(1000,calculator.calculate('+'));
    }

    @ParameterizedTest
    @CsvSource({"2 , 9, 0", "8, 3,  2001"})
    void testDegreeParam(int arg1, int arg2, int arg3 ) {
        Calculator calculator = new Calculator(arg1, arg2,arg3 );
        assertEquals(512,calculator.calculate('^'));
    }

    @ParameterizedTest
    @CsvSource({"104976, 4", "324 , 2", "1889568, 5"})
    void testRadicalParam(int arg1, int arg2 ) {
        Calculator calculator = new Calculator(arg1, arg2);
        assertEquals(18,calculator.calculate('q'));
    }
}
