public abstract class Phone {
    protected String ten;  // 'ten' means 'name' in Vietnamese
    protected String soDienThoai;  // 'soDienThoai' means 'phone'

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

    abstract void chenSoDienThoai(String ten, String soDienThoai);  // Insert
    abstract void xoaSoDienThoai(String ten);  // Remove
    abstract void capNhatSoDienThoai(String ten, String soDienThoaiMoi);  // Update
    abstract void timKiemSoDienThoai(String ten);  // Search
}
