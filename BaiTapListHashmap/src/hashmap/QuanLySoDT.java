package hashmap;

import java.util.HashMap;

public class QuanLySoDT {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Alice", "123456789");
        map.put("Bob", "987654321");
        System.out.println("Số điện thoại của Alice: " + map.get("Alice"));
        if (map.containsKey("Bob")) {
            System.out.println("Số điện thoại của Bob: " + map.get("Bob"));
        }
        map.remove("Alice");
        System.out.println("Các khóa trong map: " + map.keySet());
        System.out.println("Số lượng phần tử trong map: " + map.size());
        map.clear();
        System.out.println("Map sau khi xóa: " + map);
    }
}
