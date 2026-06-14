import java.sql.*;

public class Ex33_JDBCTransaction {

    static void transfer(Connection conn, int from, int to, double amt) throws SQLException {
        conn.setAutoCommit(false);
        try {
            PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            debit.setDouble(1, amt);
            debit.setInt(2, from);
            debit.executeUpdate();

            PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            credit.setDouble(1, amt);
            credit.setInt(2, to);
            credit.executeUpdate();

            conn.commit();
            System.out.println("Transfer of " + amt + " from account " + from + " to " + to + " successful.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transfer failed. Rolled back. Reason: " + e.getMessage());
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, name TEXT, balance REAL)");
            st.execute("INSERT OR REPLACE INTO accounts VALUES (1, 'Alice', 1000)");
            st.execute("INSERT OR REPLACE INTO accounts VALUES (2, 'Bob', 500)");

            transfer(conn, 1, 2, 200);

            ResultSet rs = st.executeQuery("SELECT * FROM accounts");
            while (rs.next())
                System.out.println(rs.getString("name") + ": $" + rs.getDouble("balance"));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
