package model;

public class Sach {
    private String Id;
    private String TenSach;
    private double GiaBan;
    private int NamXuatBan;

    public Sach() {
    }

    public Sach(String id, String tenSach, double giaBan, int namXuatBan) {
        Id = id;
        TenSach = tenSach;
        GiaBan = giaBan;
        NamXuatBan = namXuatBan;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public void setGiaBan(double giaBan) {
        GiaBan = giaBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        NamXuatBan = namXuatBan;
    }

    public String getId() {
        return Id;
    }

    public String getTenSach() {
        return TenSach;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public int getNamXuatBan() {
        return NamXuatBan;
    }
}
