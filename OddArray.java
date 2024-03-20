import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
public class OddArray {
	public static void main(String[] args){
		int[][] oddArray = new int[3][3];
		int sum = 0;
		int N = 0;
		Scanner console = new Scanner(System.in);
		int compare = 0;
		try{
			FileWriter file = new FileWriter("oddArray.txt");
			BufferedWriter writer = new BufferedWriter(file);
			System.out.println("Enter the first 9 odd numbers:");
			for (int i=0; i<oddArray.length; i++){
				for (int x=0; x<oddArray[i].length; x++){
					oddArray[i][x] = console.nextInt();

					//To ensure the user enters the 9 first odd numbers in order
					if (oddArray[0][0] == 1){
						if (i == 0 && x == 0){
							;
						}
						else if(oddArray[i][x] != (compare + 2)){
							System.err.println("It works");
							throw new Exception("Invalid input. Input must be the next odd number!");
						}
						else
							;
					}else{
						throw new Exception("Invalid input. Input must be the first odd number!");
					}
					compare = oddArray[i][x];
				}
			}
			int leadDiagonal = oddArray[0][0] * oddArray[1][1] * oddArray[2][2];
			int trailDiagonal = oddArray[0][2] * oddArray[1][1] * oddArray[2][0];
			int diffDiagonal = trailDiagonal - leadDiagonal;
			oddArray[0][1] = leadDiagonal;
			oddArray[1][1] = diffDiagonal;
			oddArray[2][1] = trailDiagonal;
			for (int i=0; i<oddArray.length; i++){
							for (int x=0; x<oddArray[i].length; x++){
									sum += oddArray[i][x];
									N += 1;
				}
			}
			int average = sum/N;
			int sumDeviation = 0;
			for (int i=0; i<oddArray.length; i++){
				for (int x=0; x<oddArray[i].length; x++){
					sumDeviation += Math.pow((oddArray[i][x] - average), 2);
				}
			}
			double standardDeviation = Math.sqrt((double) sumDeviation/(double) N);
			oddArray[1][0] = (int) average;
			oddArray[1][2] = (int) standardDeviation;

			for (int i=0; i<oddArray.length; i++){
				for (int x=0; x<oddArray[i].length; x++){
					for (int a=i; a<oddArray.length; a++){
						if (a==i){
							for (int b=x+1; b<oddArray[i].length; b++){
								if (oddArray[a][b]>oddArray[i][x]){
									int tmpLow = oddArray[i][x];
									oddArray[i][x] = oddArray[a][b];
									oddArray[a][b] = tmpLow;
								}
							}
						}
						else {
							for (int b=0; b<oddArray[i].length; b++){
								if (oddArray[a][b]>oddArray[i][x]){
									int tmpLow = oddArray[i][x];
									oddArray[i][x] = oddArray[a][b];
									oddArray[a][b] = tmpLow;
								}
							}

						}
					}
				}
			}
			System.out.println(Arrays.deepToString(oddArray));
			writer.write(Arrays.deepToString(oddArray));
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		console.close();
	}
}
