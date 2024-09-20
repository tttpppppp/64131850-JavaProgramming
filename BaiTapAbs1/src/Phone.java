public abstract class Phone {
    protected String ten;
    protected String soDienThoai;

    public Phone() {
    }

    public Phone(String ten, String soDienThoai) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    abstract void chenSoDienThoai(String ten, String soDienThoai);
    abstract void xoaSoDienThoai(String ten);
    abstract void capNhatSoDienThoai(String ten, String soDienThoaiMoi);
    abstract void timKiemSoDienThoai(String ten);
}
