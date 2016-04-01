import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by user on 2016-03-25.
 */
public class UserDaoTest {

    @Test
    public void get() throws SQLException, ClassNotFoundException {
//        UserDao userDao = new UserDao(new SimpleConnectionMaker());
        UserDao userDao = new DaoFactory().getUserDao();

        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException  {
        User user = new User();

        String name = "허윤호";
        String password = "1234";

        user.setName(name);
        user.setPassword(password);
        UserDao userDao = new DaoFactory().getUserDao();

        Long id = userDao.add(user);
        User resultSet = userDao.get(id);

        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

}
