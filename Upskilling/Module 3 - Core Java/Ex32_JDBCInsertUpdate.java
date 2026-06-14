import java.sql.*;

public class Ex32_JDBCInsertUpdate {

    static class StudentDAO {
        Connection conn;
        StudentDAO(Connection c) { this.conn = c; }

        void insert(int id, String name, String grade) throws SQLException {
            PreparedStatement ps = conn.prepareStatement("INSERT OR REPLACE INTO students VALUES (?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, grade);
            ps.executeUpdate();
            System.out.println("Inserted: " + name);
        }

        void update(int id, String newGrade) throws SQLException {
            PreparedStatement ps = conn.prepareStatement("UPDATE students SET grade=? WHERE id=?");
            ps.setString(1, newGrade);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " row(s)");
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:school.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, grade TEXT)");
            StudentDAO dao = new StudentDAO(conn);
            dao.insert(3, "Charlie", "C");
            dao.update(3, "B");
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }
}
