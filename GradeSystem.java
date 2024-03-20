import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class GradeSystem {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        try{
            FileWriter file = new FileWriter("gradeSystem.txt");
            BufferedWriter writer = new BufferedWriter(file);
            System.out.println("Exam Score: ");
            int examScore = scanner.nextInt();

            System.out.println("Assessment Score: ");
            int assessScore = scanner.nextInt();

            System.out.println("Fees paid: ");
            int feesPaid = scanner.nextInt();

            if (examScore >= 25){
                System.out.println("Exam: Passed");
                writer.write("Exam: Passed");
            }else {
                System.out.println("Exam: Failed");
                writer.write("Exam: Failed");
            }
            if (assessScore >= 15){
                System.out.println("Assessment: Passed");
                writer.write("\nAssessment: Passed");
            }
            else{
                System.out.println("Assessment: Failed");
                writer.write("\nAssessment: Failed");
            }
            if (examScore >= 25 && assessScore >=15){
                System.out.println("You passed");
                writer.write("\nYou passed");
                if (feesPaid == 100){
                    System.out.println("You have earned a certificate");
                    writer.write("\nYou have earned a certificate");
                }
                else {
                    System.out.println("Make full payment before you earn a certificate");
                    writer.write("\nMake full payment before you earn a certificate");
                }
            }else if ((examScore == 25 && assessScore == 14) || (examScore == 24 && assessScore == 15)) {
                System.out.println("You have been condoned");
                writer.write("\nYou have been condoned");
                if (feesPaid == 100) {
                    System.out.println("You have earned a certificate:)");
                    writer.write("\nYou have earned a certificate:)");
                } else {
                    System.out.println("Make full payment before you earn a certificate");
                    writer.write("\nMake full payment before you earn a certificate");
                }
            }else{
                System.out.println("You failed");
                writer.write("\nYou failed");
            }
            if (examScore < 25 && assessScore < 15) {
                System.out.println("You have been repeated");
                writer.write("\nYou have been repeated");
                }
            writer.close();
        }catch(InputMismatchException e1){
            System.err.println("Invalid input. Input must be an integer!");
        }catch(IOException e2){
            e2.printStackTrace();
        }
        scanner.close();
    }
}