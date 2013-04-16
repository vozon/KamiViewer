package org.kamisama.ui.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����ͼ����Action
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date  2007-12-14
 */
public abstract class Action {
	
	/**
	 * Action ��Ӧ��������
	 */
	private ActionContext actionContext=null;
	
	public void setActionContext(ActionContext context){
		actionContext=context;
	}
	
	public ActionContext getActionContext(){
		return actionContext;
	}
	
	/**
	 * ��ͼ����,�����ͨ��getActionContext()��õ�ǰAction�����ģ�������ǰ�����������
	 * 
	 * @param context
	 * @throws Exception
	 */
	public abstract void process(HttpServletRequest request, HttpServletResponse response)throws Exception;

}
