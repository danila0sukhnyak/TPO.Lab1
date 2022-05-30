package task3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {
    @Test
    @DisplayName("Check Color name")
    public void checkName() {
        assertEquals("Белый", Color.WHITE.toString());
        assertEquals("Черный", Color.BLACK.toString());
    }
}
