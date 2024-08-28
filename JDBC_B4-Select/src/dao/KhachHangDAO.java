package dao;

import model.KhachHang;

import java.util.ArrayList;

public class KhachHangDAO implements  DAOInterface<KhachHang>{
    public static KhachHangDAO getInstance(){
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int update(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int delete(KhachHang khachHang) {
        return 0;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        return null;
    }

    @Override
    public KhachHang selectById(KhachHang khachHang) {
        return null;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String condition) {
        return null;
    }
}
