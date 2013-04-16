package org.kamisama.ui.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ַ���������,������ͬdispatch mapping��Dispatcher��ͬһ���������У�
 * ���Դ����Լ��ܹ������URL���󣬲��ܴ���ĵ���doChain
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date  Nov 30, 2007
 */
public interface DispatcherChain {
	
	public void doChain(HttpServletRequest request, HttpServletResponse response)throws Exception;

}
