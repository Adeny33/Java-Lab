import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class Shop{
    public static void main(String[] args){
        String[][] months = {{"JAN", "FEB", "MAR"}, {"APR", "MAY", "JUNE"}, {"JULY", "AUG", "SEP"}, {"OCT", "NOV", "DEC"}};
        String[] quarters = {"Quarter 1", "Quarter 2", "Quarter 3", "Quarter 4"};
        int[][] streetBranch = new int[4][3];
        int[][] mallBranch = new int[4][3];
        int[][] sumMonthlySales = new int[4][3];
        int sumQuarterlySales = 0;
        int streetAnnualSales = 0;
        int mallAnnualSales = 0;
        Scanner input = new Scanner(System.in);

        try{
            FileWriter file = new FileWriter("shop.txt");
            BufferedWriter writer = new BufferedWriter(file);
            System.out.println("Enter the monthly sales for High Street Branch");
            for (int i=0; i<streetBranch.length; i++){
                for (int x=0; x<streetBranch[i].length; x++){
                    System.out.print(months[i][x] + " = ");
                    int sales = input.nextInt();
                    streetAnnualSales += sales;
                    streetBranch[i][x] = sales;
                }
            }
            System.out.println("\nEnter the monthly sales for Mall Branch");
            for (int i=0; i<mallBranch.length; i++){
                for (int x=0; x<mallBranch[i].length; x++){
                    System.out.print(months[i][x] + " = ");
                    int sales = input.nextInt();
                    mallAnnualSales += sales;
                    mallBranch[i][x] = sales;
                }
            }
            System.out.println("\nCombined monthly sales:");
            writer.write("\nCombined monthly sales:");
            for (int i=0; i<sumMonthlySales.length; i++){
                for (int x=0; x<sumMonthlySales[i].length; x++){
                    sumMonthlySales[i][x] = streetBranch[i][x] + mallBranch[i][x];
                    System.out.println(months[i][x] + " = " + sumMonthlySales[i][x]);
                    writer.write("\n" + months[i][x] + " = " + sumMonthlySales[i][x]);
                }
            }
            System.out.println("\nCombined quarterly sales:");
            writer.write("\nCombined quarterly sales:");
            for (int i=0; i<sumMonthlySales.length; i++){
                for (int x=0; x<sumMonthlySales[i].length; x++){
                    sumQuarterlySales += sumMonthlySales[i][x];
                }
                System.out.println(quarters[i] + " = " + sumQuarterlySales);
                writer.write("\n" + quarters[i] + " = " + sumQuarterlySales );
                sumQuarterlySales = 0;
            }
            System.out.println("\nHigh Street Branch annual sales = " + streetAnnualSales);
            System.out.println("\nMall Branch annual sales = " + mallAnnualSales);
            System.out.println("\nTotal annual combined sales = " + (streetAnnualSales + mallAnnualSales));

            writer.write("\nHigh Street Branch annual sales = " + streetAnnualSales);
            writer.write("\nMall Branch annual sales = " + mallAnnualSales);
            writer.write("\nTotal annual combined sales = " + (streetAnnualSales + mallAnnualSales));
            writer.close();
        
        }catch(InputMismatchException e1){
            System.err.println("Input but be an integer!");
        }catch(IOException e){
            e.printStackTrace();
        }
        input.close();
    }
}
