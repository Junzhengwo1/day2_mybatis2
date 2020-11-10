package com.kou.dao.impl;

import com.kou.dao.IUserDao;
import com.kou.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author JIAJUN KOU
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users=session.selectList("com.kou.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {

    }

    public User findById(Integer userId) {
        return null;
    }

    public List<User> findByUsername(String name) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
