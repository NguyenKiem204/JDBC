package dao;

import database.JDBCUntil;
import model.Sach;

import java.sql.*;
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
        ArrayList<Sach> listSach = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM Sach";
            System.out.println(sql);
//        kết quả của câu lệnh select ra sẽ được lưu vào ResultSet
            ResultSet rs = st.executeQuery(sql);
//        Xử lý kết quả select ra và add vào trong array
            while (rs.next()) {
                String id = rs.getString("Id");
                String tensach = rs.getString("TenSach");
                double giaBan = rs.getDouble("GiaBan");
                int namXuatBan = rs.getInt("NamXuatBan");
                Sach sach = new Sach(id, tensach, giaBan, namXuatBan);
                listSach.add(sach);
            }
            JDBCUntil.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSach;
    }

    @Override
    public Sach selectById(Sach sach) {
        Sach sachStore = null;
        try {
            Connection connection = JDBCUntil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM Sach WHERE Id = '" + sach.getId() + "'";
            System.out.println(sql);
//        kết quả của câu lệnh select ra sẽ được lưu vào ResultSet
            ResultSet rs = st.executeQuery(sql);
//        Xử lý kết quả select ra và add vào trong array
            while (rs.next()) {
                String id = rs.getString("Id");
                String tensach = rs.getString("TenSach");
                double giaBan = rs.getDouble("GiaBan");
                int namXuatBan = rs.getInt("NamXuatBan");
                sachStore = new Sach(id, tensach, giaBan, namXuatBan);
            }
            JDBCUntil.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sachStore;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> listSach = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM Sach WHERE "+condition;
            System.out.println(sql);
//        kết quả của câu lệnh select ra sẽ được lưu vào ResultSet
            ResultSet rs = st.executeQuery(sql);
//        Xử lý kết quả select ra và add vào trong array
            while (rs.next()) {
                String id = rs.getString("Id");
                String tensach = rs.getString("TenSach");
                double giaBan = rs.getDouble("GiaBan");
                int namXuatBan = rs.getInt("NamXuatBan");
                Sach sach = new Sach(id, tensach, giaBan, namXuatBan);
                listSach.add(sach);
            }
            JDBCUntil.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSach;
    }
}
