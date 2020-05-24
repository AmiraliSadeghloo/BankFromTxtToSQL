import java.io.*;
import java.util.Scanner;

class Filee {
    int whole[][] = new int[3][100];
    int j;

    Filee() {
        //       String read;
        int id, i;
        int passs = 0;
        String namee = "";
        int[][] sep_data = new int[100][3];
        j = 0;
        try {
            File mytxt = new File("C:\\Users\\AmirAli\\Desktop\\Bankdatatxt.txt");
            Scanner reader = new Scanner(mytxt);
            while (reader.hasNext()) {
                String read = reader.nextLine();
                String[] sep_string = read.split(" ");
                for (int k = 0; k < 3; k++) {
                    whole[k][j] = Integer.parseInt(sep_string[k]);
                    // System.out.println(whole[k][j]);
                }
                j++;
            }
        } catch (Exception e) {
            // System.out.println(e);
        }
        for (int u = 0; u < j; u++) {
            for (int oo = 0; oo < 3; oo++) {
                System.out.println(whole[oo][u]);
            }
        }
    }

    public int[][] whole_getter() {
        return whole;
    }

    public int getJ() {
        return j;
    }
}
