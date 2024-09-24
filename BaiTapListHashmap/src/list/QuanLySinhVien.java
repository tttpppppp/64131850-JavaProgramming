package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien implements ISinhVien{
    Scanner sc = new Scanner(System.in);
    List<SinhVien> danhSachSv = new ArrayList<SinhVien>();
    @Override
    public void themSinhVien() {
        System.out.println("Nhập mã số sinh viên: ");
        String mssv = sc.nextLine();

        System.out.println("Nhập họ và tên: ");
        String ten = sc.nextLine();
        int age = 0;
        while (true) {
            try {
                System.out.println("Nhập tuổi: ");
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ cho tuổi.");
            }
        }

        double gpa = 0.0;
        while (true) {
            try {
                System.out.println("Nhập gpa: ");
                gpa = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ cho GPA.");
            }
        }
        SinhVien sv = new SinhVien(mssv,ten, age, gpa);
        danhSachSv.add(sv);
        System.out.println("Sinh viên đã được thêm thành công: ");
    }

    @Override
    public void xoaSinhVien() {
        boolean isSuccess = false;
        System.out.println("Nhap mssv can xoa");
        String mssv = sc.nextLine();
        for (int i = 0; i < danhSachSv.size(); i++) {
            SinhVien sv = danhSachSv.get(i);
            if (sv.getMssv().equals(mssv)) {
                danhSachSv.remove(i);
                isSuccess = true;
                break;
            }
        }
        if(!isSuccess) {
            System.out.println("Không tìm thấy sinh viên");
        }
    }

    @Override
    public void danhSachSinhVien() {
        for(SinhVien sv : danhSachSv) {
            System.out.println(sv.toString());
        }
    }

    @Override
    public void timKiemSinhVien() {
        System.out.println("Nhập MSSV hoặc tên sinh viên cần tìm:");
        String tuKhoa = sc.nextLine().toLowerCase();
        boolean found = false;
        for (SinhVien sv : danhSachSv) {
            if (sv.getMssv().toLowerCase().contains(tuKhoa) || sv.getHoTen().toLowerCase().contains(tuKhoa)) {
                System.out.println("Tìm thấy sinh viên: " + sv.getMssv() + " - " + sv.getHoTen());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào với thông tin đã nhập.");
        }
    }
}
