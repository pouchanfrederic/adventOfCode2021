import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class adventOfCode3Part2 {

    public static void main(String[] args) throws IOException {

        String ligne = "";
        int[] gammaRate = new int[12];
        int[] epsilonRate = new int[12];
        int[] nombreDeZero = new int[12];
        int[] nombreDeUn = new int[12];
        ArrayList<String> tableauDeNombre = new ArrayList<>();


        FileInputStream fstream = new FileInputStream("src/Data/date3.txt");
        // FileInputStream("C:\\Users\\FRED\\Documents\\Développement\\adventOfCode\\src\\Data\\data2.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        while ((ligne = br.readLine()) != null) {
            tableauDeNombre.add(ligne);
        }

        for (int i = 0; i < tableauDeNombre.size(); i++) {
            for (int y = 0; y < tableauDeNombre.get(i).length(); y++) {
                if (Character.getNumericValue(tableauDeNombre.get(i).charAt(y)) == 1)
                    nombreDeUn[y] += 1;
                else
                    nombreDeZero[y] += 1;
            }
        }

        ArrayList<String> co2ScrubberRating = new ArrayList<>(tableauDeNombre);
        ArrayList<String> oxygenGeneratorRating = new ArrayList<>(tableauDeNombre);

        //Recherche de la valeur "Oxygen generator rating" -> 3005
        for (int z = 0; z < nombreDeUn.length; z++) {
            var test = mostCommonBitByColumn(oxygenGeneratorRating, z);
            oxygenGeneratorRating = removeFromArray(oxygenGeneratorRating, test, z);
        }

        //Recherche de la valeur "CO2 scrubber rating" -> 1616
        for (int z = 0; z < nombreDeUn.length; z++) {
            var test = lessCommonBitByColumn(co2ScrubberRating, z);
            co2ScrubberRating = removeFromArray(co2ScrubberRating, test, z);
            if(co2ScrubberRating.size() == 1){
                break;
            }
        }
        var test = Integer.parseInt(co2ScrubberRating.get(0), 2);
        var test2 = Integer.parseInt(oxygenGeneratorRating.get(0), 2);
        System.out.println(test * test2);

    }

    public static String ToString(int[] ar) {
        return Arrays.toString(ar).replace("[", "")
                                    .replace("]", "")
                                    .replace(" ", "")
                                    .replace(",", "");
    }

    public static int mostCommonBitByColumn(ArrayList<String> tableau, int column){
        int nombreDeZero = 0, nombreDeUn = 0;
        for (String s : tableau) {
            if (Character.getNumericValue(s.charAt(column)) == 1) {
                nombreDeUn += 1;
            } else {
                nombreDeZero += 1;
            }
        } 
        if (nombreDeUn > nombreDeZero){
            return 1;
        }
        if (nombreDeUn == nombreDeZero){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int lessCommonBitByColumn(ArrayList<String> tableau, int column){
        int nombreDeZero = 0, nombreDeUn = 0;
        for (String s : tableau) {
            if (Character.getNumericValue(s.charAt(column)) == 0) {
                nombreDeUn += 1;
            } else {
                nombreDeZero += 1;
            }
        }
        if (nombreDeUn > nombreDeZero){
            return 1;
        }
        if (nombreDeUn == nombreDeZero){
            return 0;
        }
        else{
            return 0;
        }
    }

    public static ArrayList<String> removeFromArray(ArrayList<String> tableau, int value, int column){
        for (int i = 0; i < tableau.size(); i++) {
            int test = Character.getNumericValue(tableau.get(i).charAt(column));
            if (test == value){
            }
            else{
                tableau.remove(i);
                i-=1;
            }
        }
        return tableau;
    }

}
