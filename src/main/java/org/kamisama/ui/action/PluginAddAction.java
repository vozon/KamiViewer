package org.kamisama.ui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kamisama.cfg.model.JwebapDef;
import org.kamisama.cfg.model.PluginDefRef;
import org.kamisama.cfg.persist.PersistManager;
import org.kamisama.core.RuntimeContext;
import org.kamisama.startup.Startup;
import org.kamisama.ui.controler.Action;

/**
 * plugin����action
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.6
 * @date  2008-11-28
 */
public class PluginAddAction  extends Action {

	/**
	 * ����plugin���ұ���jwebap.xml
	 */
	public void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pluginName=request.getParameter("pluginName");
		String path=request.getParameter("path");
		
		if(pluginName==null || pluginName.trim().equals("")){
			showErr("pluginName is empty.",request,response);
			return;
		}
		
		if(path==null || path.trim().equals("")){
			showErr("path is empty.",request,response);
			return;
		}
		
		request.setAttribute("pluginName", pluginName);
		request.setAttribute("path", path);
		
		PluginDefRef plugin=new PluginDefRef();
		plugin.setName(pluginName);
		plugin.setRef(path);
		
		RuntimeContext context=Startup.getRuntimeContext();
		PersistManager jwebapDefManager=context.getJwebapDefManager();
		//���»�ȡһ���µ�jwebap���ö��壬����ȥʹ��jwebap����ʵ���е����ö��󣬱��ֶ����õ��޸Ĳ�Ӱ�����л���
		JwebapDef def=jwebapDefManager.get();
		def.addPluginDef(plugin);
		
		jwebapDefManager.save(def);
		
		redirect(request,response);
	}

	/**
	 * ת��
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.sendRedirect("../plugins");
	}
	
	/**
	 * ��ʾ������Ϣ
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void showErr(String errMsg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("errMsg", errMsg);
		request.getRequestDispatcher("new").forward(request, response);
		
	}
}
