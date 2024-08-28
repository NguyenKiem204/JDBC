package test;

import dao.SachDAO;
import model.Sach;

import java.util.ArrayList;

public class TestSachDAO {
    public static void main(String[] args) {
        /*
     System.out.println("-----------------------------SelectAll------------------------------");
     ArrayList<Sach> listSach = SachDAO.getInstance().selectAll();
     for (Sach sach: listSach){
         System.out.println(sach);
     }
     */
        System.out.println("-----------------------------Find  Book By BookId------------------------------");
        Sach sachToFind = new Sach();
        sachToFind.setId("LTJV0");
        Sach SachFound = SachDAO.getInstance().selectById(sachToFind);
        System.out.println(SachFound);

        System.out.println("--------------------------------Find List Book By Conditions--------------------");
        ArrayList<Sach> listSachCondition = new ArrayList<>();
        listSachCondition = SachDAO.getInstance().selectByCondition("NamXuatBan = 2025 AND GiaBan > 290.0");
        for (Sach sach : listSachCondition) {
            System.out.println(sach);
        }
    }


}
