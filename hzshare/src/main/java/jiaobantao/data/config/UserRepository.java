package jiaobantao.data.config;

import jiaobantao.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hu on 2017/12/14.
 */
@Repository
public class UserRepository implements UserDAO {
    private static final String SELECT_USER =
            "select * from users where user_id = ?"; // ?????
    private static final String INSERT_USER =
            "insert into users (user_id, username, password, email) values (?, ?, ?, ?)";
    JdbcOperations jdbcOperations;
    
    @Autowired
    public UserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
    public User getUser(long userId) {
        return jdbcOperations.queryForObject(SELECT_USER, new UserRowMapper(), userId);
    }
    
    public void addUser(User user) {
        jdbcOperations.update(INSERT_USER,
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail());
    }
    
    private class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(
                    resultSet.getLong("user_id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"));
        }
    }
}
