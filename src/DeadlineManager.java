import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;

public class DeadlineManager {

    // Show overdue assignments

    public void showOverdue(ArrayList<Assignment> assignments) {

        LocalDate today = LocalDate.now();

        System.out.println("\n========== OVERDUE ASSIGNMENTS ==========");

        boolean found = false;

        for (Assignment a : assignments) {

            LocalDate deadline =
                    LocalDate.parse(a.getDeadline());

            if (deadline.isBefore(today)
                    && !a.getStatus().equalsIgnoreCase("COMPLETED")) {

                System.out.println(a);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No overdue assignments.");
        }
    }

    // Show assignments due within next 3 days

    public void showDueSoon(ArrayList<Assignment> assignments) {

        LocalDate today = LocalDate.now();

        System.out.println("\n========== DUE SOON ==========");

        boolean found = false;

        for (Assignment a : assignments) {

            LocalDate deadline =
                    LocalDate.parse(a.getDeadline());

            long days =
                    ChronoUnit.DAYS.between(today, deadline);

            if (days >= 0
                    && days <= 3
                    && !a.getStatus().equalsIgnoreCase("COMPLETED")) {

                System.out.println(a);
                System.out.println("Remaining Days: " + days);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No assignments due soon.");
        }
    }

    // Show upcoming assignments

    public void showUpcoming(ArrayList<Assignment> assignments) {

        LocalDate today = LocalDate.now();

        System.out.println("\n========== UPCOMING ASSIGNMENTS ==========");

        boolean found = false;

        for (Assignment a : assignments) {

            LocalDate deadline =
                    LocalDate.parse(a.getDeadline());

            long days =
                    ChronoUnit.DAYS.between(today, deadline);

            if (days > 3
                    && !a.getStatus().equalsIgnoreCase("COMPLETED")) {

                System.out.println(a);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No upcoming assignments.");
        }
    }

    // Calculate remaining days

    public long getRemainingDays(Assignment assignment) {

        LocalDate today = LocalDate.now();

        LocalDate deadline =
                LocalDate.parse(assignment.getDeadline());

        return ChronoUnit.DAYS.between(today, deadline);
    }

    // Sort by deadline

    public void sortByDeadline(ArrayList<Assignment> assignments) {

        assignments.sort(
                Comparator.comparing(
                        assignment ->
                                LocalDate.parse(
                                        assignment.getDeadline()
                                )
                )
        );

        System.out.println("\n========== SORTED BY DEADLINE ==========");

        for (Assignment a : assignments) {
            System.out.println(a);
        }
    }
}