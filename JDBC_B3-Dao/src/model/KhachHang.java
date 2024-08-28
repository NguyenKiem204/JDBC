package model;

import java.sql.Date;

public class KhachHang {
    private int Id;
    private String HoVaTen;
    private Date NgaySinh;
    private String DiaChi;

    public KhachHang() {
    }

    public KhachHang(int id, String hoVaTen, Date ngaySinh, String diaChi) {
        Id = id;
        HoVaTen = hoVaTen;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setHoVaTen(String hoVaTen) {
        HoVaTen = hoVaTen;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getId() {
        return Id;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }
}
