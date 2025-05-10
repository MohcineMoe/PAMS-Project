public class AppointmentBST {
    private AppointmentNode root;

    public AppointmentBST() {
        root = null;
    }

    public void addAppointment(PatientAppointment appointment) {
        root = insertRec(root, appointment);
    }

    private AppointmentNode insertRec(AppointmentNode node, PatientAppointment appt) {
        // 1) empty spot → insert here
        if (node == null) {
            return new AppointmentNode(appt);
        }

        String newTime  = appt.appointmentTime;
        String nodeTime = node.data.appointmentTime;

        // 2) earlier → go left
        if (newTime.compareTo(nodeTime) < 0) {
            node.left = insertRec(node.left, appt);

        // 3) later → go right
        } else if (newTime.compareTo(nodeTime) > 0) {
            node.right = insertRec(node.right, appt);

        // 4) equal → duplicate, do nothing
        } else {
            System.out.println("⚠️ Duplicate appointment at " + newTime + " not added.");
        }

        return node;
    }

    public void inOrderTraversal(AppointmentNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    public AppointmentNode getRoot() {
        return root;
    }
}