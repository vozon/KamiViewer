package org.kamisama.ui.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Jwebap Web Console ����ַ��� �����Լ��ܹ������URL���󣬲��ܴ���ĵ���Dispatcher.doChain
 * 
 * @link DispatcherChain
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date Nov 30, 2007
 */
public interface Dispatcher {

	public void dispatch(HttpServletRequest request,
			HttpServletResponse response, DispatcherChain chain)
			throws Exception;
	
	public void ini(DispatcherContext context);
	
	public DispatcherContext getContext();

}
