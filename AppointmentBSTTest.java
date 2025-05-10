import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentBSTTest {

    @Test
    void testAddAppointment() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment p1 = new PatientAppointment(1, "Test Patient", "09:00");
        bst.addAppointment(p1);
        assertNotNull(bst.getRoot(), "Root should not be null after adding one appointment");
    }

    @Test
    void testPreventDuplicateTimes() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment a1  = new PatientAppointment(1, "Alice", "09:00");
        PatientAppointment dup = new PatientAppointment(2, "Alice‑Dup", "09:00");

        bst.addAppointment(a1);
        bst.addAppointment(dup);

        // since "09:00" was inserted twice, no children should exist
        assertNull(bst.getRoot().left,  "Left child must be null on duplicate time");
        assertNull(bst.getRoot().right, "Right child must be null on duplicate time");
    }
}
