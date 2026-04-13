import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementTest {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment");
                }
                this.cargo = cargo;
            } catch (CargoSafetyException e) {
            } finally {
            }
        }
    }

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");
        assertEquals("Petroleum", b.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.cargo);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Rectangular");
        b1.assignCargo("Petroleum");

        GoodsBogie b2 = new GoodsBogie("Cylindrical");
        b2.assignCargo("Coal");

        assertEquals("Coal", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.cargo);
    }
}
