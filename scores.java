import java.util.Scanner;

public class ExamProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] courseworkScores = {80, 70, 90, 85, 75};  
        int finalExamScore = 88; 
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");

            System.out.print("Enter your choice (1-3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults(courseworkScores);
                    break;
                case 2:
                    viewExamResults(finalExamScore);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice == 1 || choice == 2) {
                int numAssessments = countCourseworkAssessments(courseworkScores);
                System.out.println("Number of coursework assessments done: " + numAssessments);

                if (!hasDoneTwoThirdsOfCoursework(numAssessments)) {
                    System.out.println("Student has not done 2/3 of coursework. Required to repeat the course.\n");
                } else {
                    System.out.println("Student has done 2/3 of coursework.\n");
                }
            }

        } while (choice != 3);

        scanner.close();
    }

    public static void viewCourseworkResults(int[] courseworkScores) {
        System.out.println("\nCoursework Results:");
        for (int i = 0; i < courseworkScores.length; i++) {
            System.out.println("Assessment " + (i + 1) + ": " + courseworkScores[i]);
        }
        int totalScore = 0;
        for (int score : courseworkScores) {
            totalScore += score;
        }
        System.out.println("Total Coursework Score: " + totalScore + "\n");
    }

    public static void viewExamResults(int finalExamScore) {
        System.out.println("\nFinal Exam Result: " + finalExamScore + "\n");
    }

    public static int countCourseworkAssessments(int[] courseworkScores) {
        int numAssessments = 0;
        for (int score : courseworkScores) {
            numAssessments++;
        }
        return numAssessments;
    }

    public static boolean hasDoneTwoThirdsOfCoursework(int numAssessments) {
        int requiredAssessments = 5; 
        return numAssessments >= (2.0 / 3) * requiredAssessments;
    }
}