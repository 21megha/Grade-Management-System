import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReportGenerator {

    public static void displayAllStudents(ArrayList<StudentGrade> students, String[] subjects) {

        System.out.printf("%-20s", "Student Name");
        for (String sub : subjects) {
            System.out.printf("%-12s", sub);
        }
        System.out.printf("%-10s%n", "Average");

        System.out.println("----------------------------------------------------------------------------------------------------");

        for (StudentGrade s : students) {
            System.out.printf("%-20s", s.getName());

            for (double m : s.getMarks()) {
                System.out.printf("%-12.2f", m);
            }

            double avg = GradeCalculator.calculateAverage(s.getMarks());
            System.out.printf("%-10.2f%n", avg);
        }
    }

    public static void showAverages(ArrayList<StudentGrade> students) {
        for (StudentGrade s : students) {
            double avg = GradeCalculator.calculateAverage(s.getMarks());
            char grade = GradeCalculator.calculateGrade(avg);
            System.out.printf("%-15s : Average = %.2f, Grade = %c%n",
                    s.getName(), avg, grade);
        }
    }

    public static void generatePerformanceReport(ArrayList<StudentGrade> students, String[] subjects) {

        System.out.println("\nTotal Students: " + students.size());

        // Subject averages
        System.out.println("\n📊 SUBJECT AVERAGES:");
        for (int i = 0; i < subjects.length; i++) {
            double sum = 0;
            for (StudentGrade s : students) {
                sum += s.getMarks()[i];
            }
            System.out.printf("• %s: %.2f%n", subjects[i], sum / students.size());
        }

        // Top performers
        Collections.sort(students, Comparator.comparingDouble(
                s -> -GradeCalculator.calculateAverage(s.getMarks())));

        System.out.println("\n🏆 TOP PERFORMERS:");
        int rank = 1;
        for (StudentGrade s : students) {
            System.out.printf("%d. %s - Average: %.2f%n",
                    rank++, s.getName(),
                    GradeCalculator.calculateAverage(s.getMarks()));
        }

        // Grade distribution
        int a = 0, b = 0, c = 0, d = 0, f = 0;

        for (StudentGrade s : students) {
            char g = GradeCalculator.calculateGrade(
                    GradeCalculator.calculateAverage(s.getMarks()));
            switch (g) {
                case 'A' -> a++;
                case 'B' -> b++;
                case 'C' -> c++;
                case 'D' -> d++;
                case 'F' -> f++;
            }
        }

        System.out.println("\n📈 GRADE DISTRIBUTION:");
        System.out.println("• A Grade: " + a + " students");
        System.out.println("• B Grade: " + b + " students");
        System.out.println("• C Grade: " + c + " students");
        System.out.println("• D Grade: " + d + " students");
        System.out.println("• F Grade: " + f + " students");
    }
}

