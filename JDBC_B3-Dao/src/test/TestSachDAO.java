package test;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
    public static void main(String[] args) {
        /*
       Sach sach1 = new Sach("DNT111", "Đắc Nhân Tâm", 70000, 2035);
       Sach sach2 = new Sach("NVTL111", "Nhìn về tương lai ", 9800, 2026);
        SachDAO.getInstance().insert(sach1);
        SachDAO.getInstance().insert(sach2);
       for(int i = 0; i<100; i++){
           Sach sach = new Sach("LTJV" + i, "Lập Trình Java", 100+i*2, 2024+i%2);
           SachDAO.getInstance().insert(sach);
        }

        System.out.println("Thành công hai ba bốn");
        */
        Sach sach = new Sach("DNT111", "Đắc Nhân Tâm", 99999, 2035);
        SachDAO.getInstance().update(sach);
//        Xóa bằng cách new một đối tượng
        Sach sach2 = new Sach("LTC", "xxx", 000, 9999);
        SachDAO.getInstance().delete(sach2);
//        Xoa bằng cách truyền vào id
        SachDAO.getInstance().deleteById("LTJV2");

    }


}
