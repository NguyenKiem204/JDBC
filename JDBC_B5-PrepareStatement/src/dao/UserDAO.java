package dao;

import database.JDBCUntil;
import model.Sach;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User> {
    public static UserDAO getInstance() {
        return new UserDAO();
    }

    /**
     * try-with-resources trong Java tự động đóng được các tài nguyên như Connection,
     * PreparedStatement, ResultSet nhờ vào việc các tài nguyên này triển khai (implement) giao diện AutoCloseable.
     * Khi khối lệnh kết thúc, phương thức `close()` sẽ được gọi tự động cho `connection` và `ps`.
     * [User] do user là một từ khóa nằm trong SQL nên cần có cặp dấu []
     *
     * @param user
     * @return number row effected
     */
    @Override
    public int insert(User user) {
        int numberRow = 0;
        String sql = "INSERT INTO [User](UserName, Password, FullName) VALUES (?, ?, ?)";
        System.out.println(sql);
        try (Connection connection = JDBCUntil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setNString(3, user.getFullName());

            numberRow = ps.executeUpdate();
            System.out.println("(" + numberRow + " row(s) affected)");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numberRow;
    }

    @Override
    public int update(User user) {
        int numberRow = 0;
        String sql = "UPDATE [User]"
                + " SET Password = '" + user.getPassword()
                + "', FullName = N'" + user.getFullName() + "'"
                + " WHERE UserName = ?";
        System.out.println(sql);
        try (Connection connection = JDBCUntil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getUserName());
            numberRow = ps.executeUpdate();
            System.out.println("(" + numberRow + " row(s) affected)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numberRow;
    }

    @Override
    public int delete(User user) {
        int numberRow = 0;
        String sql = "DELETE [User] WHERE UserName = ?";
        System.out.println(sql);
        try (Connection connection = JDBCUntil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getUserName());
            numberRow = ps.executeUpdate();
            System.out.println("(" + numberRow + " row(s) affected)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numberRow;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> listUser = new ArrayList<>();
        String sql = "SELECT * FROM [User]";
        System.out.println(sql);
        try (Connection connection = JDBCUntil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String UserName = rs.getString("username");
                String Password = rs.getString("password");
                String FullName = rs.getString("fullname");
                User user = new User(UserName, Password, FullName);
                listUser.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUser;
    }

    @Override
    public User selectById(User user) {
        String sql = "SELECT * FROM [User] WHERE UserName = ?";
        System.out.println(sql);
        User userReturn = null;
        try (Connection connection = JDBCUntil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getUserName());
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String UserName = rs.getString("username");
                    String Password = rs.getString("password");
                    String FullName = rs.getNString("fullname");
                    userReturn = new User(UserName, Password, FullName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userReturn;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        return null;
    }
}
