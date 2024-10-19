package com.xxx.ioc_02;

public class UserDao {
    public class UserService {

        private UserDao userDao;

        public UserService(UserDao userDao) {
            this.userDao = userDao;
        }
    }
}