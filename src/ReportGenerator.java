import java.util.ArrayList;

public class ReportGenerator {

    public void generateReport(ArrayList<Assignment> assignments) {

        int total = assignments.size();
        int completed = 0;
        int pending = 0;

        int high = 0;
        int medium = 0;
        int low = 0;

        for (Assignment assignment : assignments) {

            if (assignment.getStatus()
                    .equalsIgnoreCase("COMPLETED")) {

                completed++;
            } else {
                pending++;
            }

            if (assignment.getPriority()
                    .equalsIgnoreCase("HIGH")) {

                high++;
            } else if (assignment.getPriority()
                    .equalsIgnoreCase("MEDIUM")) {

                medium++;
            } else if (assignment.getPriority()
                    .equalsIgnoreCase("LOW")) {

                low++;
            }
        }

        double completionRate = 0;

        if (total > 0) {
            completionRate =
                    ((double) completed / total) * 100;
        }

        System.out.println("\n========================================");
        System.out.println("          TASKTRACK REPORT");
        System.out.println("========================================");

        System.out.println("\nAcademic Assignment Summary");
        System.out.println("----------------------------------------");

        System.out.println("Total Assignments : " + total);
        System.out.println("Completed         : " + completed);
        System.out.println("Pending           : " + pending);

        System.out.println("\nPriority Distribution");
        System.out.println("----------------------------------------");

        System.out.println("HIGH              : " + high);
        System.out.println("MEDIUM            : " + medium);
        System.out.println("LOW               : " + low);

        System.out.printf(
                "\nCompletion Rate   : %.2f%%\n",
                completionRate);

        System.out.println("\nAssignment Details");
        System.out.println("----------------------------------------");

        if (assignments.isEmpty()) {

            System.out.println("No assignments available.");

        } else {

            for (Assignment assignment : assignments) {
                System.out.println(assignment);
            }
        }

        System.out.println("\n========================================");
    }
}