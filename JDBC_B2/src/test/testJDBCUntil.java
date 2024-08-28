package test;

import database.JDBCUntil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class testJDBCUntil {
    public static void main(String[] args) {
        try {
//        Buoc 1: Tao ket noi
            Connection connection = JDBCUntil.getConnection();

//        Buoc 2: Tao doi tuong
            Statement st = connection.createStatement();

//        Buoc 3: Thuc thi cau lenh sql
            String sql = "INSERT INTO BilliardsClub (ClubID, ClubName, Address, Hotline)" + "VALUES ('CL008', 'ClubH', 'Ha Noi', '01234564539')";

//        Buoc 4: Kiem tra ket qua
            int check = st.executeUpdate(sql);
            System.out.println("Số dòng thay đổi: " + check);
            if(check>0){
                System.out.println("Thêm dữ liệu thành công");
            }else System.out.println("Thêm dữ liệu không thành");
            System.out.println(connection);

//        Buoc 5:  Ngat ket noi
            JDBCUntil.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
