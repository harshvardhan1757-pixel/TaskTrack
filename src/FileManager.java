import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_PATH =
        "../data/assignments.txt";
    // Save Assignments

    public void saveAssignments(
            ArrayList<Assignment> assignments) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE_PATH));

            for (Assignment assignment : assignments) {

                writer.write(
                        assignment.toFileString());

                writer.newLine();
            }

            writer.close();

            System.out.println(
                    "Assignments saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving assignments.");
        }
    }

    // Load Assignments

    public ArrayList<Assignment> loadAssignments() {

        ArrayList<Assignment> assignments =
                new ArrayList<>();

        try {

            File file = new File(FILE_PATH);

            if (!file.exists()) {
                return assignments;
            }

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH));

            String line;

            while ((line = reader.readLine())
                    != null) {

                String[] data =
                        line.split(",");

                if (data.length == 7) {

                    Assignment assignment =
                            new Assignment(
                                    data[0], // ID
                                    data[1], // Title
                                    data[2], // Subject
                                    data[3], // Description
                                    data[4], // Deadline
                                    data[5], // Priority
                                    data[6]  // Status
                            );

                    assignments.add(assignment);
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Error loading assignments.");
        }

        return assignments;
    }
}