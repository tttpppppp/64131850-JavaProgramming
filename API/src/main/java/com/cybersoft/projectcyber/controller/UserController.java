package com.cybersoft.projectcyber.controller;



import com.cybersoft.projectcyber.payload.ReponseData;
import com.cybersoft.projectcyber.payload.request.SignUpRequest;
import com.cybersoft.projectcyber.service.LoginService;
import com.cybersoft.projectcyber.service.SignUpService;
import com.cybersoft.projectcyber.service.UserService;
import com.cybersoft.projectcyber.utils.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    LoginService loginService;
    @Autowired
    SignUpService signUpService;
    @Autowired
    UserService userService;
    @Autowired
    JwtHelper jwtHelper;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        boolean isSuccess = loginService.checkloginUser(email, password);
        ReponseData reponseData = new ReponseData();
        if (isSuccess) {
            String token = jwtHelper.generateToken(email);
            reponseData.setData(token);
            reponseData.setMessage("success");
            return new ResponseEntity<>(reponseData , HttpStatus.OK);
        }
        reponseData.setMessage("failed");
        return new ResponseEntity<>(reponseData , HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest sinSignUpRequest) {
        boolean isSuccess = signUpService.signUp(sinSignUpRequest);
        ReponseData reponseData = new ReponseData();
        if (isSuccess) {
            reponseData.setMessage("success");
            return new ResponseEntity<>(reponseData, HttpStatus.OK);
        }
        reponseData.setMessage("failed");
        return new ResponseEntity<>(reponseData, HttpStatus.OK);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser() {
        ReponseData reponseData = new ReponseData();
        if(userService.getAllUsers().size() > 0){
            reponseData.setMessage("success");
            reponseData.setData(userService.getAllUsers());
            return new ResponseEntity<>(reponseData , HttpStatus.OK);
        }
        reponseData.setMessage("None Data");
        return new ResponseEntity<>(reponseData , HttpStatus.OK);
    }
}
