import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class FinalGrade {
    public static void main(String[] args ) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;
        double max = 0;
        double min = 0;
        double TotalOfAllGrades = 0;
        int numberOfStudents;
        Scanner console = new Scanner(System.in);
        try{
            FileWriter file = new FileWriter("finalGrade.txt");
            BufferedWriter writer = new BufferedWriter(file);
            System.out.print("Number of students : ");
            numberOfStudents = console.nextInt();
            String[][] table = new  String[numberOfStudents][3];
            for (int i = 0; i < numberOfStudents; i++){
                    System.out.print("Enter index number : ");
                    int index = console.nextInt();
                    System.out.print("midsem  : ");
                    int midSem = console.nextInt();
                    System.out.print("Exams : ");
                    int FinalSem = console.nextInt();
                    table[i][0]= String.format("%s", index);
                    double total = (((float)midSem/ 100) * 30) + (((float) FinalSem/ 100) * 70);
                    TotalOfAllGrades += total;
                    table[i][1] = String.format("%s", (int)total);
                    min = Integer.parseInt(table[0][1]);
                    max = Integer.parseInt(table[0][1]);
                    if (total > max) {
                        max = total;
                    }
                    if (total < min) {
                        min = total;
                    }
                char grade;
                if (total >= 70){
                    grade = 'A';
                    countA += 1;
                } else if (total >= 60) {
                    grade = 'B';
                    countB += 1;
                } else if (total >= 50) {
                    grade = 'C';
                    countC += 1;
                } else if (total >= 40) {
                    grade = 'D';
                    countD += 1;
                }else {
                    grade = 'F';
                    countF += 1;
                }
                table[i][2] =String.format("%s", grade);
            }

            System.out.println("Index No. | Final Score | Grade");
            writer.write("Index No. | Final Score | Grade");
            for (int x=0; x < numberOfStudents; x++) {
                System.out.println(table[x][0] + "             " + table[x][1] + "       " + table[x][2]);
                writer.write("\n" + table[x][0] + "             " + table[x][1] + "       " + table[x][2]);
            }
            System.out.println("A : " + countA + "\nB : " + countB + "\nC : " + countC + "\nD : " + countD + "\nF : " + countF);
            writer.write("\nA : " + countA + "\nB : " + countB + "\nC : " + countC + "\nD : " + countD + "\nF : " + countF);
            System.out.println("Average Score = " + TotalOfAllGrades/ numberOfStudents);
            writer.write("\nAverage Score = " + TotalOfAllGrades/ numberOfStudents);
            System.out.println("Maxmimum Score = " + (int) max);
            writer.write("\nMaxmimum Score = " + (int) max);
            System.out.println("Minimum Score = " + (int) min);
            writer.write("Minimum Score = " + (int) min);
            writer.close();
        }catch(NumberFormatException e1){
            System.err.println("Invalid input. Input must be an integer!");
        }catch(IOException e2){
            e2.printStackTrace();
        }
        console.close();
    }
}
