package org.kamisama.ui.controler;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kamisama.util.FactorySetter;

/**
 * Jwebap Web Console Servlet
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date Nov 30, 2007
 */
public class JwebapServlet extends HttpServlet {
	private static final long serialVersionUID = -2296515916109018921L;

	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * jwebap ��ͼ������,��������ͼ��������ͳһ������,Ȼ�������ַ���dispatcher���д���
	 * 
	 * @see Dispatcher
	 * @see DispatcherChain
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DispatcherFactory factory = FactorySetter.getDispatcherFactory();
		DispatcherChain chain = factory.createDispatcherChain(request);
		try {
			chain.doChain(request, response);
		} catch (Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
	}
}
