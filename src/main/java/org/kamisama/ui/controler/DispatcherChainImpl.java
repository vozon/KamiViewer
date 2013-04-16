package org.kamisama.ui.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ַ�����������ͨ���༶�ַ���������ϸ���ַ�����ְ�𣬴����Լ��ܴ����URL��
 * ͬʱҲΪ������������� �ṩ�ֶ�
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date Dec 2, 2007
 */
public class DispatcherChainImpl implements DispatcherChain {

	private List dispatchers = new ArrayList();
	int pos=0;
	
	/**
	 * �����¼�dispatcher����
	 * @throws Exception 
	 */
	public void doChain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(pos<dispatchers.size()){
			Dispatcher dispatcher=(Dispatcher)dispatchers.get(pos++);
			dispatcher.dispatch(request, response, this);
		}
	}

	protected void addDispatcher(Dispatcher dispatcher) {
		dispatchers.add(dispatcher);
	}
}
