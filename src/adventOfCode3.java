import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class adventOfCode3 {

    public static void main(String[] args) throws IOException {

        String ligne = "";
        int gammaRate = 0, epsilonRate = 0;
        int powerConsumption = gammaRate * epsilonRate;
        FileInputStream fstream = new FileInputStream("src/Data/date3.txt");
        // FileInputStream fstream = new FileInputStream("C:\\Users\\FRED\\Documents\\Développement\\adventOfCode\\src\\Data\\data2.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((ligne = br.readLine()) != null)   {
            System.out.println(ligne);
        }
    
    }
}
