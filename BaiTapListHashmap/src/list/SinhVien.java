package list;

public class SinhVien {
    private String mssv;
    private String hoTen;
    private int age;
    private double gpa;

    public SinhVien(String mssv, String hoTen, int age, double gpa) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.age = age;
        this.gpa = gpa;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "hoTen='" + hoTen + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }
}
