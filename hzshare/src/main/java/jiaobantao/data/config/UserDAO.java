package jiaobantao.data.config;

import jiaobantao.data.model.User;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by hu on 2017/12/14.
 */
public interface UserDAO {
    public User getUser(long userId);
    public void addUser(User user);
}
