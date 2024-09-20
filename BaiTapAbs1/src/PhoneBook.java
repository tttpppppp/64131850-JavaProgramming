import java.util.ArrayList;

public class PhoneBook extends Phone {
    ArrayList<PhoneBw> danhSachDienThoai = new ArrayList<>();

    @Override
    void chenSoDienThoai(String ten, String soDienThoai) {
        for (PhoneBw muc : danhSachDienThoai) {
            if (muc.getTen().equals(ten)) {
                String soDienThoaiMoi = muc.getSoDienThoai() + ":" + soDienThoai;
                muc.setSoDienThoai(soDienThoaiMoi);
                return;
            }
        }
        PhoneBw p = new PhoneBw(ten, soDienThoai);
        danhSachDienThoai.add(p);
    }

    @Override
    void xoaSoDienThoai(String ten) {
        danhSachDienThoai.removeIf(muc -> muc.getTen().equals(ten));
    }

    @Override
    void capNhatSoDienThoai(String ten, String soDienThoaiMoi) {
        for (PhoneBw muc : danhSachDienThoai) {
            if (muc.getTen().equals(ten)) {
                muc.setSoDienThoai(soDienThoaiMoi);
                return;
            }
        }
        System.out.println("Không tìm thấy tên.");
    }

    @Override
    void timKiemSoDienThoai(String ten) {
        for (PhoneBw muc : danhSachDienThoai) {
            if (muc.getTen().equals(ten)) {
                System.out.println("Tìm thấy: " + muc.getTen() + " - " + muc.getSoDienThoai());
                return;
            }
        }
        System.out.println("Không tìm thấy tên.");
    }
    public void danhSachDienThoai(){
        for (PhoneBw muc : danhSachDienThoai) {
            System.out.println(muc.getTen() + " - " + muc.getSoDienThoai());
        }
    }
}
