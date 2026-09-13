import java.time.LocalDate;

public class InputValidator {

    // Check Empty Input

    public static boolean isEmpty(String input) {

        return input == null || input.trim().isEmpty();
    }

    // Validate Priority

    public static boolean isValidPriority(String priority) {

        return priority.equalsIgnoreCase("HIGH")
                || priority.equalsIgnoreCase("MEDIUM")
                || priority.equalsIgnoreCase("LOW");
    }

    // Validate Status

    public static boolean isValidStatus(String status) {

        return status.equalsIgnoreCase("PENDING")
                || status.equalsIgnoreCase("COMPLETED");
    }

    // Validate Date Format (YYYY-MM-DD)

    public static boolean isValidDate(String date) {

        try {

            LocalDate.parse(date);
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // Validate Assignment ID

    public static boolean isValidId(String id) {

        return !isEmpty(id);
    }

    // Validate Title

    public static boolean isValidTitle(String title) {

        return !isEmpty(title);
    }

    // Validate Subject

    public static boolean isValidSubject(String subject) {

        return !isEmpty(subject);
    }

    // Validate Description

    public static boolean isValidDescription(String description) {

        return !isEmpty(description);
    }
}