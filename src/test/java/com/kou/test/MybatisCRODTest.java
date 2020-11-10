package com.kou.test;

import com.kou.dao.IUserDao;
import com.kou.dao.impl.UserDaoImpl;
import com.kou.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 * @author JIAJUN KOU
 * 测试类
 */

public class MybatisCRODTest {

    private InputStream in;

    private IUserDao userDao;
    //执行初始化的操作
    @Before
    public void init() throws Exception{
        //1.读取配置文件，是为了加载信息。
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);


        //4.使用SqlSession创建Dao接口的代理对象
        userDao=new UserDaoImpl(factory);

    }

    @After
    public void destroy() throws Exception{

        in.close();
    }

    @Test
    public void testFindAll() throws Exception{

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }



}
