package cm.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cm.model.User;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<User> users = new ArrayList<>();
        users.add(new User(1, "despacitovv@gmail.com", "123456789", "Tran Tien Phuc", "211/2004"));
        users.add(new User(2, "example@gmail.com", "987654321", "Nguyen Van A", "01/01/2000"));
        users.add(new User(3, "test@gmail.com", "abcdefg", "Le Thi B", "02/02/2001"));

        try (FileWriter writer = new FileWriter("user.json")) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
            resp.getWriter().append("Lỗi khi ghi file JSON");
            return; 
        }

        resp.getWriter().append("Đã thêm file JSON");
    }
}
