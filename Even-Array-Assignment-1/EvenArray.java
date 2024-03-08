import java.util.Arrays;

public class EvenArray {
    public static void main(String[] args){
        int[] evenArray = new int[10];
        int i;
        int sum = 0;
        int element;
        for (i=0; i<10; i++){
            element = 2 * (i+1);
            sum += element;
            evenArray[i] = element;
        }
        System.out.println(Arrays.toString(evenArray));
        double mean = (double) sum / evenArray.length;
        double sumDeviation = 0;
        for (int j : evenArray) {
            sumDeviation += Math.pow((j - mean), 2);
        }
        double standardDeviation = Math.sqrt(sumDeviation / evenArray.length);
        System.out.println("Standard Deviation = " + standardDeviation);
    }
}