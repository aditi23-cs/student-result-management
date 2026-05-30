// To run: javac StudentResult.java then java StudentResult

import java.util.Scanner;

public class StudentResult {

    // Method to calculate grade based on marks
    static String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F (Fail)";
    }

    // Method to calculate result status
    static String calculateResult(double marks) {
        if (marks >= 50) return "Pass";
        else return "Fail";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("     Student Result Management System   ");
        System.out.println("========================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Arrays to store student data
        String[] names = new String[n];
        double[] marks = new double[n];
        String[] grades = new String[n];
        String[] results = new String[n];

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter name: ");
            names[i] = sc.next();
            System.out.print("Enter marks (out of 100): ");
            marks[i] = sc.nextDouble();

            // Validate marks
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid! Enter marks between 0-100: ");
                marks[i] = sc.nextDouble();
            }

            grades[i] = calculateGrade(marks[i]);
            results[i] = calculateResult(marks[i]);
        }

        // Display results
        System.out.println("\n========================================");
        System.out.println("             RESULT SHEET               ");
        System.out.println("========================================");
        System.out.printf("%-15s %-10s %-8s %-10s%n", "Name", "Marks", "Grade", "Result");
        System.out.println("----------------------------------------");

        double total = 0;
        int passCount = 0;

        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %-10.1f %-8s %-10s%n",
                names[i], marks[i], grades[i], results[i]);
            total += marks[i];
            if (results[i].equals("Pass")) passCount++;
        }

        System.out.println("----------------------------------------");
        System.out.printf("Class Average  : %.2f%n", total / n);
        System.out.printf("Total Passed   : %d / %d%n", passCount, n);
        System.out.printf("Total Failed   : %d / %d%n", (n - passCount), n);
        System.out.println("========================================");

        sc.close();
    }
}


// To run: javac StudentResult.java then java StudentResult
// If error, try: javac --release 8 StudentResult.java then java StudentResult