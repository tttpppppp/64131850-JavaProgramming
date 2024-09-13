import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double canNang = 0, chieuCao = 0;
        do {
            try {
                System.out.print("Nhập cân nặng (kg) (> 0): ");
                canNang = Double.parseDouble(scanner.nextLine());
                if (canNang <= 0) {
                    System.out.println("Cân nặng phải lớn hơn 0. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ.");
            }
        } while (canNang <= 0);

        do {
            try {
                System.out.print("Nhập chiều cao (m) (> 0): ");
                chieuCao = Double.parseDouble(scanner.nextLine());

                if (chieuCao <= 0) {
                    System.out.println("Chiều cao phải lớn hơn 0. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ.");
            }
        } while (chieuCao <= 0);


        double bmi = canNang / (chieuCao * chieuCao);


        System.out.printf("Chỉ số BMI của bạn là: %.2f%n", bmi);

        if (bmi < 18.5) {
            System.out.println("Tình trạng: Gầy");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Tình trạng: Bình thường");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("Tình trạng: Thừa cân");
        } else {
            System.out.println("Tình trạng: Béo phì");
        }
    }
}