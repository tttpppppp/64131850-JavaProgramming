import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một số nguyên: ");
        int so = scanner.nextInt();

        String ketQua = (so % 2 == 0) ? "số chẵn" : "số lẻ";

        System.out.println(so + " là " + ketQua + ".");
    }
}