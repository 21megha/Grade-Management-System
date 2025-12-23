public class GradeCalculator {

    public static double calculateAverage(double[] marks) {
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.length;
    }

    public static char calculateGrade(double average) {
        if (average >= 80) return 'A';
        else if (average >= 70) return 'B';
        else if (average >= 60) return 'C';
        else if (average >= 50) return 'D';
        else return 'F';
    }
}

