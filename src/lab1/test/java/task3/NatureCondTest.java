package task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NatureCondTest {
    @Test
    @DisplayName("Check NatureCond name")
    public void checkName() {
       assertEquals("Землетрясение", NatureCond.EARTHQUAKE.toString());
       assertEquals("Извержение", NatureCond.ERUPTION.toString());
       assertEquals("Наводнение", NatureCond.FLOOD.toString());
       assertEquals("Ничего", NatureCond.NOTHING.toString());
    }
}
