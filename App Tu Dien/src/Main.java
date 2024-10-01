import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String , String> tuDien = new HashMap<>();
        tuDien.put("Hello", "Xin chào");
        tuDien.put("Bye", "Tam Biet");
        tuDien.put("Thank you", "Cảm ơn");
        tuDien.put("Mouse", "Chuột");
        tuDien.put("Computer", "Máy tính");
        tuDien.put("Cake", "Bánh");

        System.out.println("Nhập từ khóa tìm kiếm: ");
        String tuKhoa = sc.nextLine();
        System.out.println("ý nghĩa là: " + tuDien.get(tuKhoa));
    }
}