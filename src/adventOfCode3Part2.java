import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class adventOfCode3Part2 {

    public static void main(String[] args) throws IOException {

        String ligne = "";
        int[] gammaRate = new int[12]; // Most common bit (ça doit donner 10110)
        int[] epsilonRate = new int[12]; // second most common bit (ça doit donner 01001)
        // Puis faut le transforcer en décilal et multiplier le résultat pour avoir
        // powerConsumption
        // int powerConsumption = gammaRate * epsilonRate;
        // int nombreDeZero = 0, nombreDeUn = 0;
        int[] nombreDeZero = new int[12]; // A changer à 12 pour le vrai tableau
        int[] nombreDeUn = new int[12]; // A changer en 12
        ArrayList<String> tableauDeNombre = new ArrayList<>();

        FileInputStream fstream = new FileInputStream("src/Data/date3.txt");
        // FileInputStream fstream = new
        // FileInputStream("C:\\Users\\FRED\\Documents\\Développement\\adventOfCode\\src\\Data\\data2.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        while ((ligne = br.readLine()) != null) {
            tableauDeNombre.add(ligne);
        }
        int index = 0;
        for (int i = 0; i < tableauDeNombre.size(); i++) {
            for (int y = 0; y < tableauDeNombre.get(i).length(); y++) {
                if (Character.getNumericValue(tableauDeNombre.get(i).charAt(y)) == 1)
                    // System.out.println("Un : " + tableauDeNombre.get(i).charAt(y));
                    nombreDeUn[y] += 1;
                else
                    nombreDeZero[y] += 1;
                // System.out.println("Zero : " + tableauDeNombre.get(i).charAt(y));
                // System.out.println(tableauDeNombre.get(i));
            }
        }
        for (int z = 0; z < nombreDeUn.length; z++) {
            if (nombreDeUn[z] > nombreDeZero[z]) {
                gammaRate[z] = 1;
                epsilonRate[z] = 0;
            } else {
                gammaRate[z] = 0;
                epsilonRate[z] = 1;
            }
        }
        var epsilonRateInteger = ToString(epsilonRate);
        var gammaRateInteger = ToString(gammaRate);
        var decimalEpsilonRate = Integer.parseInt(epsilonRateInteger, 2);
        var decimalGammaRate = Integer.parseInt(gammaRateInteger, 2);
        System.out.println(decimalEpsilonRate * decimalGammaRate);

    }

    public static String ToString(int[] ar) {

        return Arrays.toString(ar).replace("[", "")
                                    .replace("]", "")
                                    .replace(" ", "")
                                    .replace(",", "");
    }

}
