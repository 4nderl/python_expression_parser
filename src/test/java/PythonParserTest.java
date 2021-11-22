import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PythonParserTest {
    PythonParser sut;

    @BeforeEach
    void setUp() {
        sut = new PythonParser();
    }

    @Test
    void MathTestPlus() {
        String out = sut.evaluate("3 + 3");
        int int_out = Integer.parseInt(out.strip());
        assertEquals(int_out, 6);
    }

    @Test
    void MathTestMinus() {
        String out = sut.evaluate("3 - 6");
        int int_out = Integer.parseInt(out.strip());
        assertEquals(int_out, -3);
    }

    @Test
    void ExpressionPlus() {
        sut.addVariable("x", "1");
        sut.addVariable("y", "1");
        String out = sut.evaluate("x + y");
        int int_out = Integer.parseInt(out.strip());
        assertEquals(int_out, 2);
    }

    @Test
    void ExpressionMinus() {
        sut.addVariable("x", "1");
        sut.addVariable("y", "10");
        String out = sut.evaluate("x - y");
        int int_out = Integer.parseInt(out.strip());
        assertEquals(int_out, -9);
    }

    @Test
    void ExpressionMax() {
        sut.addVariable("x", "1");
        sut.addVariable("y", "10");
        String out = sut.evaluate("max(x, y)");
        int int_out = Integer.parseInt(out.strip());
        assertEquals(int_out, 10);
    }

    @Test
    void ExpressionWithQuotes() {
        sut.addVariable("x", "\"1\"");
        sut.addVariable("y", "10");
        String out = sut.evaluate("\"x + y\"");
        int int_out = Integer.parseInt(out.strip());
        assertEquals(int_out, 11);
    }

    @Test
    void ExpressionUnparsable() {
        sut.addVariable("x", "\"1\"");
        try {
            String out = sut.evaluate("\"x + y\"");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
