import java.util.ArrayList;
import java.util.Scanner;



public class GradeManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<StudentGrade> students = new ArrayList<>();

    static String[] subjects = {
            "Mathematics", "Science", "English", "History", "Computer"
    };

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Averages");
            System.out.println("4. Find Top Performers");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> ReportGenerator.displayAllStudents(students, subjects);
                case 3 -> {
                    System.out.println("\n=== STUDENT AVERAGES ===");
                    ReportGenerator.showAverages(students);
                }
                case 4, 5 -> {
                    System.out.println("\n=== PERFORMANCE REPORT ===");
                    ReportGenerator.generatePerformanceReport(students, subjects);
                }
                case 6 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {

        System.out.println("\n=== ADD STUDENT MARKS ===");
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        double[] marks = new double[subjects.length];

        System.out.println("\nEnter marks for 5 subjects (out of 100):");

        for (int i = 0; i < subjects.length; i++) {
            while (true) {
                System.out.print(subjects[i] + ": ");
                double m = sc.nextDouble();

                if (m >= 0 && m <= 100) {
                    marks[i] = m;
                    break;
                } else {
                    System.out.println("❌ Marks must be between 0 and 100!");
                }
            }
        }

        students.add(new StudentGrade(name, marks));
        System.out.println("✅ Student marks added successfully!");
    }
}
