package com.hdquan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.hdquan.util.MyBatisUtil;
@WebFilter("/show")
public class OpenSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
 
    }
 
    public void doFilter1(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //创建SqlSession并在当前线程中共享
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
 
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            //回滚事务
            sqlSession.rollback();
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } finally {
            //关闭当前线程共享SqlSession
            MyBatisUtil.closeSqlSession();
        }
    }
 
    @Override
    public void destroy() {
 
    }

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}