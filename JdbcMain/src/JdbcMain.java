

import oracle.jdbc.OracleDriver;

import java.sql.*;

public class JdbcMain {
    public static void main(String[] args) {
        JdbcMain j = new JdbcMain();
        j.execute();
    }


    Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String url = "jdbc:oracle:thin:@192.168.2.180:1521:xe";
        //string url=jdbc:oracle:thin:@localhost:1521:xe;
        //creating connection
        //Connection connection=DriverManager.getConnection(url,"system","oracle")


        Connection connection = DriverManager.getConnection(url, "system", "oracle");
        //create statement object
        return connection;
    }

    public void execute() {
        addRow();
        fetchAndDisplay();
    }

    public void addRow() {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();
            String sql = "insert into employees(id,name) values(44,'gayathri')";
            int count = statement.executeUpdate(sql);
            System.out.println("no of rows updated" + count);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchAndDisplay() {
        try {
            Connection connection = createConnection();
           // Statement statement = connection.createStatement();
            String sql="select * from employees";
            PreparedStatement statement=connection.prepareStatement(sql);
             // ResultSet resultset=statement.executeQuery("select * from employees");
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                System.out.println("id" + id + ", name" + name);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
