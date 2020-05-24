import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ClassNotFoundException, InputMismatchException {

        Filee test = new Filee();
        int[][] i = test.whole_getter();
        int j = test.getJ();
        Sqll mysql = new Sqll(i, j);
        System.out.println("what do u want to do?");
        System.out.println("Enter 1 for login, 2 for registry");
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        if (q == 1) {
            System.out.println("Enter ID and Password");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            mysql.login(u, v);
        }
        if (q == 2) {
            System.out.println("Enter id,pass, balance");
            int id = scanner.nextInt();
            int pass = scanner.nextInt();
            int balance = scanner.nextInt();
            mysql.register(id, pass, balance);
        }



    }
}
