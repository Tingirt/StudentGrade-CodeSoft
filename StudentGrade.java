package CodeSoftIntern.GradeCalculator;

import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSubjects;
        do {
            System.out.println("Enter the number of subjects (must be greater than 0):");
            numSubjects = scanner.nextInt();
        } while (numSubjects <= 0);

        int totalMarks = 0;
        final int maxMarksPerSubject = 100;

        for (int i = 1; i <= numSubjects; i++) {
            int marks;
            do {
                System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                marks = scanner.nextInt();
                if (marks < 0 || marks > maxMarksPerSubject) {
                    System.out.println("Marks should be in the range of 0 to 100. Please enter the mark again.");
                }
            } while (marks < 0 || marks > maxMarksPerSubject);

            totalMarks += marks;
        }

        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        String grade = determineGrade(averagePercentage);
        System.out.println("Grade: " + grade);
    }

    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / (numSubjects * 100) * 100;
    }

    public static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 65) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C+";
        } else if (averagePercentage >= 50) {
            return "C";
        } else if (averagePercentage >= 45) {
            return "D";
        } else {
            return "F";
        }
    }
}
