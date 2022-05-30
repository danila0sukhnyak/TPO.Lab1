package task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaterialTest {
    @Test
    @DisplayName("Check Material name")
    public void checkName() {
        assertEquals("Золотой", Material.GOLD.toString());
        assertEquals("Платиновый", Material.PLATINUM.toString());
        assertEquals("Резиновый", Material.RUBBER.toString());
    }
}