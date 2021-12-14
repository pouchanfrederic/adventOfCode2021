import java.io.*;
import java.util.ArrayList;

public class adventOfCode2 {

    public static void main(String[] args) throws IOException {
        int valeur, depth = 0, horizontal = 0, aim = 0;
        String direction, ligne;
        FileInputStream fstream = new FileInputStream("C:\\Users\\FRED\\Documents\\Développement\\adventOfCode\\src\\Data\\data2.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((ligne = br.readLine()) != null)   {
                int intermediaire = 0;
                String[] tableau = ligne.split(" ");
                direction = tableau[0];
                valeur = Integer.parseInt(tableau[1]);
                if(direction.equals("up")){
                    aim-=valeur;
                }
                if(direction.equals("forward")){
                    horizontal+=valeur;
                    intermediaire = valeur*aim;
                    depth+=intermediaire;
                }
                if(direction.equals("down")){
                    aim += valeur;
                }
        }
        int tutu = depth*horizontal;
        System.out.println(tutu);
    }
}
