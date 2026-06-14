import java.sql.*;

public class Ex31_JDBCConnect {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:school.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, grade TEXT)");
            stmt.execute("INSERT OR IGNORE INTO students VALUES (1, 'Alice', 'A')");
            stmt.execute("INSERT OR IGNORE INTO students VALUES (2, 'Bob', 'B')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("ID | Name  | Grade");
            System.out.println("---|-------|------");
            while (rs.next())
                System.out.println(rs.getInt("id") + "  | " + rs.getString("name") + " | " + rs.getString("grade"));
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }
}
