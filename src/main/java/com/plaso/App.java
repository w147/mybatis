package com.plaso;


import com.plaso.bean.Student;
import com.plaso.dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class App {

    private SqlSession sqlSession;

    @Before
    public void start() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void close(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void run(){
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.findById(100);
        System.out.println(student.getName());
    }

}
