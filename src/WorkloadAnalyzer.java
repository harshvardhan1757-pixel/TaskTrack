import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class WorkloadAnalyzer {

    public void analyze(ArrayList<Assignment> assignments) {

        int total = assignments.size();

        int pending = 0;
        int completed = 0;
        int overdue = 0;
        int dueSoon = 0;
        int highPriority = 0;

        LocalDate today = LocalDate.now();

        for (Assignment assignment : assignments) {

            // Completed

            if (assignment.getStatus()
                    .equalsIgnoreCase("COMPLETED")) {

                completed++;
            }

            // Pending

            if (assignment.getStatus()
                    .equalsIgnoreCase("PENDING")) {

                pending++;
            }

            // High Priority

            if (assignment.getPriority()
                    .equalsIgnoreCase("HIGH")) {

                highPriority++;
            }

            // Deadline Analysis

            try {

                LocalDate deadline =
                        LocalDate.parse(
                                assignment.getDeadline());

                long days =
                        ChronoUnit.DAYS.between(
                                today,
                                deadline);

                // Overdue

                if (days < 0
                        && !assignment.getStatus()
                        .equalsIgnoreCase("COMPLETED")) {

                    overdue++;
                }

                // Due Soon (within 3 days)

                if (days >= 0
                        && days <= 3
                        && !assignment.getStatus()
                        .equalsIgnoreCase("COMPLETED")) {

                    dueSoon++;
                }

            } catch (Exception e) {

                System.out.println(
                        "Invalid date format in assignment: "
                                + assignment.getId());
            }
        }

        double completionRate = 0;

        if (total > 0) {

            completionRate =
                    ((double) completed / total) * 100;
        }

        String workloadLevel;

        if (pending >= 10) {

            workloadLevel = "HEAVY";

        } else if (pending >= 5) {

            workloadLevel = "MODERATE";

        } else {

            workloadLevel = "LIGHT";
        }

        // Print Analysis Report

        System.out.println("\n================================");
        System.out.println("      WORKLOAD ANALYSIS");
        System.out.println("================================");

        System.out.println("Total Assignments : " + total);
        System.out.println("Pending           : " + pending);
        System.out.println("Completed         : " + completed);
        System.out.println("Overdue           : " + overdue);
        System.out.println("Due Soon          : " + dueSoon);
        System.out.println("High Priority     : " + highPriority);

        System.out.printf(
                "Completion Rate   : %.2f%%\n",
                completionRate);

        System.out.println(
                "Workload Level    : "
                        + workloadLevel);

        System.out.println("================================");
    }
}