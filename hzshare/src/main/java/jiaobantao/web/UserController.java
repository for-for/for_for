package jiaobantao.web;

import jiaobantao.data.config.UserDAO;
import jiaobantao.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class UserController {
    private static final String template = "hello %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    UserDAO userDAO;
    

    @RequestMapping(value = "/user", method = { RequestMethod.GET, RequestMethod.POST })
    public void register(
            @RequestParam("user_id") long userId,
                    @RequestParam("username") String username,
                    @RequestParam("password") String password,
                    @RequestParam("email") String email) {
        System.out.format("come in");

        User user = new User(userId, username, password, email);
        userDAO.addUser(user);
        return ;
    }
}


