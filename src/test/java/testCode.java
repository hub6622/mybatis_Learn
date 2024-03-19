import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class testCode {

    @Test
    public void deleteUserByIdList() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List idList=new ArrayList();
        idList.add(21);
        idList.add(22);
        idList.add(23);
        mapper.deleteUserByIdList(idList);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findByCondition() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setGender("男");
        user.setAddr("温州");
        List<User> users=mapper.findByCondition(user);
        for (User u:users
             ) {
            System.out.println(u);
        }
        sqlSession.commit();
    }

    @Test
    public void updateUserByMap() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map=new HashMap();
        map.put("id",1);
        map.put("username","xiaojun");
        map.put("addr","fawfwa");
        map.put("gender","S");
        mapper.updateUserByMap(map);
        sqlSession.commit();
    }


    @Test
    public void deleteUserById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(18);
        sqlSession.commit();
        List<User> users = mapper.getUserList();
        for (User user:users){
            System.out.println(user);
        }

    }
    @Test
    public void updateUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(20);//从网页获取用户输入的信息
        user.setUsername("原神高手");
        user.setPassword("555666");
        user.setGender("男");
        user.setAddr("California");
        mapper.updateUserById(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void insertUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("wbd");
        user.setPassword("123");
        user.setGender("男");
        user.setAddr("California");
        mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user:userList) {
            System.out.println(user);
        }
    }
}
