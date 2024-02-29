package KIEM_TRA_28_10_CA_13H_CO_VAN_ANH;
import java.util.*;
import java.io.*;
class SachHoc {
    protected String ten, nxb, ma;
    protected double gia;
    private static int cnt = 1;
    public SachHoc(String ten, String nxb, double gia) {
        this.ten = ten;
        this.nxb = nxb;
        this.gia = gia;
        this.ma = String.format("%02d", cnt);
        cnt++;
    }
    public void setMa() {
    }
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.nxb + " ";
    }
}
class SachThamKhao extends SachHoc {
    private boolean type;
    private String loai;
    public SachThamKhao(String ten, String nxb, boolean type, double gia) {
        super(ten, nxb, gia);
        this.type = type;
        if (this.type == true) {
            this.loai = "co ban";
            this.gia = this.gia * 110.0 / 100;
        } else {
            this.loai = "nang cao";
            this.gia = this.gia * 115.0 / 100;
        }
        String tmp = "";
        String []a = this.nxb.trim().split("\\s+");
        for(String x: a) tmp+=Character.toUpperCase(x.charAt(0));
        this.ma = tmp + this.ma;
    }
    @Override
    public String toString() {
        return super.toString() + this.loai + " " + String.format("%.0f", this.gia);
    }
}
class SachGiaoKhoa extends SachHoc {
    private int lop, tap;
    private boolean type;
    private String loai;
    public SachGiaoKhoa(String ten, String nxb, int lop, int tap, boolean type, double gia) {
        super(ten, nxb, gia);
        this.lop = lop;
        this.tap = tap;
        this.type = type;
        if (this.lop >= 1 && this.lop <= 5) {
            this.gia = this.gia * 90.0 / 100;
        } else if (this.lop >= 6 && this.lop <= 9) {
            this.gia = this.gia * 95.0 / 100;
        }
        if (this.type == true) {
            this.loai = "bai tap";
            this.gia = this.gia * 105.0 / 100;
        } else {
            this.loai = "ly thuyet";
        }
        this.ma = "SGK" + (this.lop + "") + (this.tap + "") + this.ma;
    }
    @Override
    public String toString() {
        return super.toString()+ this.lop + " " + this.tap + " " + this.loai + " " + String.format("%.0f", this.gia);
    }
}
public class BAI_TOAN_QUAN_LY_SACH {
    public static void main(String[] args) {
        SachThamKhao k=new SachThamKhao("toan lop 5","giao duc", true, 50);
        k.setMa();
        System.out.println(k);
        SachGiaoKhoa g=new SachGiaoKhoa("tieng Viet", "dong nai", 4, 1, false, 80);
        g.setMa();
        System.out.println(g);
    }
}
