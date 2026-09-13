import java.util.ArrayList;

public class AssignmentManager {

    private ArrayList<Assignment> assignments;

    public AssignmentManager() {
        assignments = new ArrayList<>();
    }

    // Add Assignment

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    // View All Assignments

    public void viewAssignments() {

        if (assignments.isEmpty()) {
            System.out.println("\nNo Assignments Found.");
            return;
        }

        System.out.println("\n==============================================================================================");
        System.out.printf("%-8s %-25s %-20s %-15s %-10s %-10s%n",
                "ID", "TITLE", "SUBJECT", "DEADLINE", "PRIORITY", "STATUS");
        System.out.println("==============================================================================================");

        for (Assignment assignment : assignments) {
            System.out.println(assignment);
        }
    }

    // Find Assignment By ID

    public Assignment findAssignment(String id) {

        for (Assignment assignment : assignments) {

            if (assignment.getId().equalsIgnoreCase(id)) {
                return assignment;
            }
        }

        return null;
    }

    // Update Assignment

    public boolean updateAssignment(
            String id,
            String title,
            String subject,
            String description,
            String deadline,
            String priority) {

        Assignment assignment = findAssignment(id);

        if (assignment == null) {
            return false;
        }

        assignment.setTitle(title);
        assignment.setSubject(subject);
        assignment.setDescription(description);
        assignment.setDeadline(deadline);
        assignment.setPriority(priority);

        return true;
    }

    // Delete Assignment

    public boolean deleteAssignment(String id) {

        Assignment assignment = findAssignment(id);

        if (assignment == null) {
            return false;
        }

        assignments.remove(assignment);
        return true;
    }

    // Mark Assignment Completed

    public boolean markCompleted(String id) {

        Assignment assignment = findAssignment(id);

        if (assignment == null) {
            return false;
        }

        assignment.setStatus("COMPLETED");
        return true;
    }

    // Get Assignment Count

    public int getTotalAssignments() {
        return assignments.size();
    }

    // Get All Assignments

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    // Check if Empty

    public boolean isEmpty() {
        return assignments.isEmpty();
    }
}