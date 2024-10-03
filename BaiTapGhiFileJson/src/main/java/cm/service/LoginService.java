package cm.service;

import java.util.List;

import cm.model.User;
import cm.respoitory.UserRespository;

public class LoginService {
	UserRespository userRespository = new UserRespository();
	
	public boolean checkLogin(String email , String password) {
		List<User> listUser = userRespository.getEmailAndPassword(email, password);
		return listUser.size() > 0 ? true : false;
	}
}
