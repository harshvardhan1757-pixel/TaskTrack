import java.util.ArrayList;

public class SearchManager {

    // Search by Title

    public void searchByTitle(
            ArrayList<Assignment> assignments,
            String title) {

        boolean found = false;

        System.out.println("\n========== SEARCH BY TITLE ==========");

        for (Assignment assignment : assignments) {

            if (assignment.getTitle()
                    .toLowerCase()
                    .contains(title.toLowerCase())) {

                System.out.println(assignment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching assignments found.");
        }
    }

    // Search by Subject

    public void searchBySubject(
            ArrayList<Assignment> assignments,
            String subject) {

        boolean found = false;

        System.out.println("\n========== SEARCH BY SUBJECT ==========");

        for (Assignment assignment : assignments) {

            if (assignment.getSubject()
                    .equalsIgnoreCase(subject)) {

                System.out.println(assignment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching assignments found.");
        }
    }

    // Filter by Priority

    public void filterByPriority(
            ArrayList<Assignment> assignments,
            String priority) {

        boolean found = false;

        System.out.println("\n========== FILTER BY PRIORITY ==========");

        for (Assignment assignment : assignments) {

            if (assignment.getPriority()
                    .equalsIgnoreCase(priority)) {

                System.out.println(assignment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching assignments found.");
        }
    }

    // Filter by Status

    public void filterByStatus(
            ArrayList<Assignment> assignments,
            String status) {

        boolean found = false;

        System.out.println("\n========== FILTER BY STATUS ==========");

        for (Assignment assignment : assignments) {

            if (assignment.getStatus()
                    .equalsIgnoreCase(status)) {

                System.out.println(assignment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching assignments found.");
        }
    }
}