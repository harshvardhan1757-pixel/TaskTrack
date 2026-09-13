import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        AssignmentManager manager = new AssignmentManager();

        SearchManager searchManager = new SearchManager();
        DeadlineManager deadlineManager = new DeadlineManager();
        WorkloadAnalyzer analyzer = new WorkloadAnalyzer();
        ReportGenerator reportGenerator = new ReportGenerator();
        FileManager fileManager = new FileManager();

        while (true) {

            System.out.println("\n================================");
            System.out.println("    TASKTRACK MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Assignment");
            System.out.println("2. View Assignments");
            System.out.println("3. Update Assignment");
            System.out.println("4. Delete Assignment");
            System.out.println("5. Mark Assignment Completed");
            System.out.println("6. Search Assignment");
            System.out.println("7. Deadline Tracker");
            System.out.println("8. Workload Analysis");
            System.out.println("9. Generate Report");
            System.out.println("10. Save Data");
            System.out.println("11. Exit");

            System.out.print("\nEnter Choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Assignment ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();

                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter Deadline (YYYY-MM-DD): ");
                    String deadline = scanner.nextLine();

                    System.out.print("Enter Priority (HIGH/MEDIUM/LOW): ");
                    String priority = scanner.nextLine();

                    Assignment assignment = new Assignment(
                            id,
                            title,
                            subject,
                            description,
                            deadline,
                            priority,
                            "PENDING"
                    );

                    manager.addAssignment(assignment);

                    System.out.println("Assignment Added Successfully!");
                    break;

                case 2:

                    manager.viewAssignments();
                    break;

                case 3:

                    System.out.print("Enter Assignment ID: ");
                    String updateId = scanner.nextLine();

                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("New Subject: ");
                    String newSubject = scanner.nextLine();

                    System.out.print("New Description: ");
                    String newDescription = scanner.nextLine();

                    System.out.print("New Deadline: ");
                    String newDeadline = scanner.nextLine();

                    System.out.print("New Priority: ");
                    String newPriority = scanner.nextLine();

                    boolean updated =
                            manager.updateAssignment(
                                    updateId,
                                    newTitle,
                                    newSubject,
                                    newDescription,
                                    newDeadline,
                                    newPriority
                            );

                    if (updated)
                        System.out.println("Assignment Updated!");
                    else
                        System.out.println("Assignment Not Found!");

                    break;

                case 4:

                    System.out.print("Enter Assignment ID: ");
                    String deleteId = scanner.nextLine();

                    if (manager.deleteAssignment(deleteId))
                        System.out.println("Assignment Deleted!");
                    else
                        System.out.println("Assignment Not Found!");

                    break;

                case 5:

                    System.out.print("Enter Assignment ID: ");
                    String completeId = scanner.nextLine();

                    if (manager.markCompleted(completeId))
                        System.out.println("Assignment Marked Completed!");
                    else
                        System.out.println("Assignment Not Found!");

                    break;

                case 6:

                    System.out.println("\n1. Search By Title");
                    System.out.println("2. Search By Subject");
                    System.out.println("3. Filter By Priority");
                    System.out.println("4. Filter By Status");

                    System.out.print("Choice: ");

                    int searchChoice =
                            Integer.parseInt(scanner.nextLine());

                    switch (searchChoice) {

                        case 1:

                            System.out.print("Enter Title: ");
                            String searchTitle =
                                    scanner.nextLine();

                            searchManager.searchByTitle(
                                    manager.getAssignments(),
                                    searchTitle
                            );
                            break;

                        case 2:

                            System.out.print("Enter Subject: ");
                            String searchSubject =
                                    scanner.nextLine();

                            searchManager.searchBySubject(
                                    manager.getAssignments(),
                                    searchSubject
                            );
                            break;

                        case 3:

                            System.out.print("Enter Priority: ");
                            String priorityFilter =
                                    scanner.nextLine();

                            searchManager.filterByPriority(
                                    manager.getAssignments(),
                                    priorityFilter
                            );
                            break;

                        case 4:

                            System.out.print("Enter Status: ");
                            String statusFilter =
                                    scanner.nextLine();

                            searchManager.filterByStatus(
                                    manager.getAssignments(),
                                    statusFilter
                            );
                            break;
                    }

                    break;

                case 7:

                    System.out.println("\n1. Show Overdue");
                    System.out.println("2. Show Due Soon");
                    System.out.println("3. Show Upcoming");
                    System.out.println("4. Sort By Deadline");

                    System.out.print("Choice: ");

                    int deadlineChoice =
                            Integer.parseInt(scanner.nextLine());

                    switch (deadlineChoice) {

                        case 1:
                            deadlineManager.showOverdue(
                                    manager.getAssignments());
                            break;

                        case 2:
                            deadlineManager.showDueSoon(
                                    manager.getAssignments());
                            break;

                        case 3:
                            deadlineManager.showUpcoming(
                                    manager.getAssignments());
                            break;

                        case 4:
                            deadlineManager.sortByDeadline(
                                    manager.getAssignments());
                            break;
                    }

                    break;

                case 8:

                    analyzer.analyze(
                            manager.getAssignments()
                    );

                    break;

                case 9:

                    reportGenerator.generateReport(
                            manager.getAssignments()
                    );

                    break;

                case 10:

                    fileManager.saveAssignments(
                            manager.getAssignments()
                    );

                    break;

                case 11:

                    System.out.println(
                            "Thank You For Using TaskTrack!");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}