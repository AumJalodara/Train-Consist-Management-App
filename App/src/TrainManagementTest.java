import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TrainManagementTest {

    // Regex patterns
    Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
    Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

    // 🔹 VALID CASES

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(trainPattern.matcher("TRN-1234").matches());
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(cargoPattern.matcher("PET-AB").matches());
    }

    // 🔹 INVALID CASES

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(trainPattern.matcher("TRN-12").matches());
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(cargoPattern.matcher("PET-abc").matches());
    }

    // 🔹 EDGE CASES

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(trainPattern.matcher("TRN-123").matches());
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(cargoPattern.matcher("PET-ab").matches());
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(trainPattern.matcher("").matches());
        assertFalse(cargoPattern.matcher("").matches());
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(trainPattern.matcher("TRN-12345").matches());
    }
}
