package org.kamisama.ui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kamisama.cfg.model.JwebapDef;
import org.kamisama.cfg.model.PluginDefRef;
import org.kamisama.cfg.persist.PersistManager;
import org.kamisama.core.RuntimeContext;
import org.kamisama.startup.Startup;
import org.kamisama.ui.controler.TemplateActionSupport;
import org.kamisama.ui.template.Context;

/**
 * plugin表单界面action
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.6
 * @date  2008-11-28
 */
public class PluginFormAction  extends TemplateActionSupport {

	
	/**
	 * 初始化上下文的信息
	 */
	public void process(HttpServletRequest request, HttpServletResponse response, Context context) throws Exception {
		String errMsg=request.getParameter("errMsg");
		if(errMsg==null){
			errMsg=(String)request.getAttribute("errMsg");
		}
		String pluginName=request.getParameter("pluginName");
		if(pluginName==null){
			pluginName=(String)request.getAttribute("pluginName");
		}
		String path=request.getParameter("path");
		if(path==null){
			path=(String)request.getAttribute("path");
		}
		
		if(errMsg!=null){
			context.put("errMsg", errMsg);
		}
		if(errMsg!=null){
			context.put("pluginName", pluginName);
		}
		if(errMsg!=null){
			context.put("path", path);
		}
		
	}
}
