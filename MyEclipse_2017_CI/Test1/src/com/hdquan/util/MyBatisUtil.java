package com.hdquan.util;
/*
 * 工具类
 */
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal();
 
    static{
        try {
            InputStream is = Resources.getResourceAsStream("Mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 从当前线程共享变量中获取SqlSession
     * @return SqlSession
     */
    public static SqlSession getSqlSession(){
        //判断当前线程中是否有SqlSession
        if(threadLocal.get() == null){
            //创建一个SqlSession并放到当前线程共享变量中
            threadLocal.set(sqlSessionFactory.openSession());
        }
        //从当前线程共享变量中获取SqlSession
        return threadLocal.get();
    }
 
    /**
     * 关闭当前线程共享变量中SqlSession
     */
    public static void closeSqlSession(){
        //从当前线程共享变量中获取SqlSession
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession != null){
            //关闭SqlSession
            sqlSession.close();
        }
        //从当前线程共享变量中移除SqlSession
        threadLocal.set(null);
    }
}