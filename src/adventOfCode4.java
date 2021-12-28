import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class adventOfCode4{

    public static void main(String[] args) throws IOException {

        FileInputStream fstream = new FileInputStream("src/Data/data4.txt");
        // FileInputStream("C:\\Users\\FRED\\Documents\\Développement\\adventOfCode\\src\\Data\\data2.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String ligne = "";
        int[] tableauDeNombre = new int[100];
        String nombresBingo = br.readLine();
        nombresBingo = RemoveUselessChar(nombresBingo);
        System.out.println(nombresBingo);
        // while ((ligne = br.readLine()) != null) {
        //     tableauDeNombre.add(ligne);
        // }
    }

    public static String ToString(int[] ar) {
        return Arrays.toString(ar).replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .replace(",", "");
    }

    public static String RemoveUselessChar(String data) {
        return data.replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .replace(",", "");
    }
}