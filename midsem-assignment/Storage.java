import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Storage {
    public static void main(String[] args) {
        int students = 0;
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Enter the number of Students: ");
            students = input.nextInt();

        } catch(InputMismatchException e){
            
            System.err.println("Invalid input");
            System.exit(0);
        }
        input.nextLine();
        String name;
        ArrayList<String> names = new ArrayList<>();
        String number;
        int[] numbers = new int[students];
        String rating;
        int ratings[] = new int[students];
        int[] freqRatings = new int[7];
        String exitCon = "z";
        System.out.println("At any point in time, press 'z' to close the program:)");
        int countNames = 0;
        int countNumbers = 0;
        for (int i=0; i<students; i++){
            try{
                System.out.print("Name: ");
                name = input.nextLine();
                if (name.equalsIgnoreCase(exitCon)){
                    break;
                }else{
                    names.add(name);
                    countNames++;
                }
                System.out.print("Phone number: ");
                number = input.next();
                if (number.equalsIgnoreCase(exitCon)){
                    break;
                }else{
                    numbers[i] = Integer.parseInt(number);
                    countNumbers++;
                }
                int rate = 0;
                int times = 0;
                while (true){
                    System.out.print("Rating: ");
                    rating = input.next();
                    if (rating.equalsIgnoreCase(exitCon))
                        break;
                    else{
                        rate = Integer.parseInt(rating);
                            if(rate < 1 || rate > 7){
                                System.out.println("Rating must be within 1-7!");
                            }else {
                                break;
                            }
                    } times++;
                    if (times == 3){
                        System.exit(0);
                    }
                }
                input.nextLine();    
                ratings[i] = rate;
        
                switch (ratings[i]) {
                    case 1:
                        freqRatings[0]++;              
                        break;
                    case 2:
                        freqRatings[1]++;
                        break;
                    case 3:
                        freqRatings[2]++;
                        break;
                    case 4:
                        freqRatings[3]++;
                        break;
                    case 5:
                        freqRatings[4]++;
                        break;
                    case 6:
                        freqRatings[5]++;
                        break;
                    case 7:
                        freqRatings[6]++;
                        break;
                    default:
                        break;
                }
            } catch(NumberFormatException e2){
                System.out.println("Input must be an integer!");
                System.exit(0);
            }
        }
        try{
            FileWriter file = new FileWriter("storage.txt");
            BufferedWriter writer = new BufferedWriter(file);
            System.out.println("Number of student names: " + countNames);
            writer.write("Number of student names: " + countNames);
            System.out.println("Number of phone numbers: " + countNumbers);
            writer.write("\nNumber of phone numbers: " + countNumbers);
            System.out.println("Frequency of each holiday ratings: ");
            System.out.println("1: " + freqRatings[0] + "\n2: " + freqRatings[1] + "\n3: " + freqRatings[2] + "\n4: " + freqRatings[3]);
            writer.write("\n1: " + freqRatings[0] + "\n2: " + freqRatings[1] + "\n3: " + freqRatings[2] + "\n4: " + freqRatings[3]);
            System.out.println("5: " + freqRatings[4] + "\n6: " + freqRatings[5] + "\n7: " + freqRatings[6]);
            writer.write("\n5: " + freqRatings[4] + "\n6: " + freqRatings[5] + "\n7: " + freqRatings[6]);
            int[] rateTypes = {1, 2, 3, 4, 5, 6, 7};
            for (int y=0; y<freqRatings.length; y++){
                for (int x=y+1; x<freqRatings.length; x++){
                    if (freqRatings[x] > freqRatings[y]){
                        int tmp = freqRatings[y];
                        freqRatings[y] = freqRatings[x];
                        freqRatings[x] = tmp;
                        int tmpType = rateTypes[y];
                        rateTypes[y] = rateTypes[x];
                        rateTypes[x] = tmpType;
                    }
                }
            }
            System.out.println("Count of ratings in descending order: ");
            writer.write("\nCount of ratings in descending order: ");
            for (int j=0; j<freqRatings.length; j++){
                System.out.println(rateTypes[j] + ": " + freqRatings[j]);
                writer.write("\n" + rateTypes[j] + ": " + freqRatings[j]);
            }
            writer.close();
            
            } catch(IOException e3){
                e3.printStackTrace();
            }
        
        System.out.print("Do you want to search for a student record (yes/no): ");
     	while (true){
        String search = input.next();
        int count = 0;
        if (search.equalsIgnoreCase("yes")){
            System.out.println("At any point in time press z to quit.");
            while (true){
                System.out.println("Enter name to search: ");
                String searchName = input.next();
                if (searchName.equalsIgnoreCase("z")){
                    System.exit(0);
                }
                int index = names.indexOf(searchName);
                if (index == -1){
                    System.out.println("Sorry, name cannot be found.");
                }else{
                System.out.println("Phone number: " + numbers[index] + "\nRating: " + ratings[index]);
                }
            }
        }else if (search.equalsIgnoreCase("no")){
            System.exit(0);;
        }else {
            System.out.println("Invalid input. Input must be 'yes' or 'no'.");
            count++;
            if (count == 3){
            	System.exit(0);
            }
            continue;
            }
        }      
    }
}
    

