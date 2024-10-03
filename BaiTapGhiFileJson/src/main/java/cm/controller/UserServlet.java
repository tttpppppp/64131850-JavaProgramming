package cm.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import cm.model.User;

@WebServlet(name = "userServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new GsonBuilder().create();
        List<User> users;
        try (BufferedReader reader = new BufferedReader(new FileReader("user.json"))) {
            users = gson.fromJson(reader, new TypeToken<List<User>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            resp.getWriter().append("Lỗi khi đọc file JSON");
            return;
        }
        resp.setContentType("application/json");
        resp.getWriter().append(gson.toJson(users)); 
    }
}
