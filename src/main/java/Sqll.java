import java.sql.*;

class Sqll {
    int[][] dbr;

    Sqll(int[][] dbr, int j) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "passwords");
            Statement st = con.createStatement();
            String create;
            create = "CREATE DATABASE banksystem;";
            st.executeUpdate(create);
            create = "use banksystemm;";
            st.executeUpdate(create);

            create = "CREATE TABLE bank(user_id INT(3), password INT(4), balance INT(10));";
            st.executeUpdate(create);

            this.dbr = dbr;
            for (int i = 0; i < j; i++) {
                int a = dbr[0][i];
                int b = dbr[1][i];
                int c = dbr[2][i];
                create = "INSERT INTO bank VALUES(" + a + "," + b + "," + c + ");";
                st.executeUpdate(create);

            }
            create = "SELECT * FROM bank; ";
            st.executeQuery(create);
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void login(int m, int n) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost", "root", "passwords");
        Statement st1 = con1.createStatement();
        String createe = "use banksystemm;";
        st1.executeUpdate(createe);
        ResultSet rs = st1.executeQuery("select * from bank WHERE user_id=" + m + " AND password=" + n + ";");
        rs.next();
        System.out.println(rs.getInt("balance"));
        rs.close();
        st1.close();
        con1.close();
    }

    public void register(int m, int n, int p) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost", "root", "passwords");
        Statement st1 = con1.createStatement();
        String createe = "use banksystemm;";
        st1.executeUpdate(createe);
        createe = "INSERT INTO bank VALUES (" + m + " , " + n + " , " + p + ");";
        st1.executeUpdate(createe);
        createe = "SELECT * FROM bank WHERE user_id =" + m + ";";
        ResultSet rs = st1.executeQuery(createe);
        rs.next();
        System.out.println("user id " + rs.getInt("user_id") + " is registered into database.");
        rs.close();
        st1.close();
        con1.close();
    }

}
