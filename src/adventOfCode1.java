import java.io.*;

public class adventOfCode1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fstream = new FileInputStream("C:\\Users\\FRED\\Documents\\Développement\\adventOfCode\\src\\Data\\data.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String depth;
        int[] depthRecords = new int[2000];
        int numberOfRecords = 1999;
        int compteurIncreased = 0;
        while ((depth = br.readLine()) != null)   {
            depthRecords[numberOfRecords] = Integer.parseInt(depth);
            numberOfRecords-=1;
        }
        for(int i=0; i<depthRecords.length -1; i+=1){

            if(i+3 > 1999) {
                System.out.println("Dans le if" + i);
                break;
            }
            if (isSumHigher(getSum(depthRecords[i], depthRecords[i+1], depthRecords[i+2]), getSum(depthRecords[i+1], depthRecords[i+2], depthRecords[i+3])))
                compteurIncreased+=1;
        }
        System.out.println(compteurIncreased);
    }

    public static int getSum(int numberOne,int numberTwo, int numberThree){
        int sum = 0;
        sum = numberOne + numberTwo + numberThree;
        return sum;
    }

    public static boolean isSumHigher(int sumOne, int sumTwo) {
        return sumOne > sumTwo;
    }
}
