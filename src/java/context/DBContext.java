package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "Wish";
    private final String portNumber = "1443"; // Đã sửa thành 1443 từ 1433
    private final String instance = ""; // Để trống vì SQL Server của bạn là một instance đơn
    private final String userID = "phuong";
    private final String password = "123";

    public static void main(String[] args) throws Exception {
        try {
            try ( // Thêm mã để kiểm tra kết nối và in thông tin kết nối
                    Connection connection = new DBContext().getConnection()) {
                System.out.println("Connected to database: " + connection.getCatalog());
            }
        } catch (SQLException e) {
            // In thông tin lỗi nếu có
            
        }
    }
}
