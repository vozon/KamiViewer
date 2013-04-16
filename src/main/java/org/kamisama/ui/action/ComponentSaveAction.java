package org.kamisama.ui.action;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kamisama.cfg.model.ComponentDef;
import org.kamisama.cfg.model.JwebapDef;
import org.kamisama.cfg.model.ComponentDef.PropertyEntry;
import org.kamisama.cfg.persist.PersistManager;
import org.kamisama.core.RuntimeContext;
import org.kamisama.startup.Startup;
import org.kamisama.ui.controler.Action;

/**
 * component保存action
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.6
 * @date 2008-11-28
 */
public class ComponentSaveAction extends Action {

	/**
	 * 保存component
	 */
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String componentName=request.getParameter("componentName");
		if(componentName==null){
			componentName=(String)request.getAttribute("componentName");
		}
		RuntimeContext runtimeContext=Startup.getRuntimeContext();
		PersistManager jwebapDefManager=runtimeContext.getJwebapDefManager();
		JwebapDef def=jwebapDefManager.get();
		ComponentDef componentDef=null;
		if(componentName!=null){
			componentDef=def.getComponentDefForUpdate(componentName);
		}
		
		if(componentDef!=null){
			Map params=request.getParameterMap();
			for(Iterator keys=params.keySet().iterator();keys.hasNext();){
				String key =(String)keys.next();
				String value=request.getParameter(key);
				PropertyEntry entry=componentDef.getPropertyEntry(key);
				if(entry!=null){
					entry.setValue(value);
				}
				
			}
			
			jwebapDefManager.save(def);
		}else{
			throw new RuntimeException("component '"+componentName+"' not exists.");
		}
		
		redirect(request,response);
	}

	/**
	 * 转向
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pluginName=request.getParameter("pluginName");
		
		response.sendRedirect("../detail?pluginName="+pluginName);
		
	}
	
}
