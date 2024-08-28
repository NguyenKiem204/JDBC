package dao;

import database.JDBCUntil;
import model.Sach;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach> {
    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach sach) {
        int result = 0;
        try {
            Connection conection = JDBCUntil.getConnection();

            Statement st = conection.createStatement();

            String sql = "INSERT INTO Sach(Id, TenSach, GiaBan, NamXuatBan) " +
                    "VALUES ('" + sach.getId() + "', N'" + sach.getTenSach() + "', '" + sach.getGiaBan() + "', '" + sach.getNamXuatBan() + "')";

            System.out.println("Ban Da Thuc Thi: " + sql);
            result = st.executeUpdate(sql);
            System.out.println("Co " + result + " dong bi thay doi");
            JDBCUntil.close(conection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    /**
     * Phải chú ý khoảng trắng giữa các câu lệnh ví dụ như sau UPDATE Sach phải có khoảng cách
     * trước where cũng phải có
     *
     * @param sach
     * @return
     */
    @Override
    public int update(Sach sach) {
        int result = 0;
        try {
            Connection connection = JDBCUntil.getConnection();
            Statement st = connection.createStatement();
            String sql = "UPDATE Sach" + " SET " + "TenSach = N'" + sach.getTenSach() + "', GiaBan = " + sach.getGiaBan() + ", NamXuatBan = " + sach.getNamXuatBan() + " WHERE Id = '" + sach.getId() + "'";
            result = st.executeUpdate(sql);
            System.out.println("Co " + result + " dong bi thay doi");
            JDBCUntil.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int delete(Sach sach) {
        int result = 0;
        try {
            Connection connection = JDBCUntil.getConnection();
            Statement st = connection.createStatement();
            String sql = "DELETE Sach" +
                    " WHERE Id = '" + sach.getId() + "'";
            result = st.executeUpdate(sql);
            System.out.println("Co " + result + " dong bi thay doi");
            JDBCUntil.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public int deleteById(String Id) {
        int result = 0;
        try {
            Connection connection = JDBCUntil.getConnection();
            Statement st = connection.createStatement();
            String sql = "DELETE Sach" +
                    " WHERE Id = '" + Id + "'";
            result = st.executeUpdate(sql);
            System.out.println("Co " + result + " dong bi thay doi");
            JDBCUntil.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        return null;
    }

    @Override
    public Sach selectById(Sach sach) {
        return null;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        return null;
    }
}
