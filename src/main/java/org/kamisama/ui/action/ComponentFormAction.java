package org.kamisama.ui.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kamisama.cfg.model.ComponentDef;
import org.kamisama.cfg.model.JwebapDef;
import org.kamisama.cfg.persist.PersistManager;
import org.kamisama.core.RuntimeContext;
import org.kamisama.startup.Startup;
import org.kamisama.ui.controler.TemplateActionSupportHelper;
import org.kamisama.ui.template.Context;

/**
 * component表单界面action
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.6
 * @date  2008-11-28
 */
public class ComponentFormAction  extends TemplateActionSupportHelper {

	/**
	 * 展现component参数
	 */
	public void process(Context context) throws Exception {
		String componentName=(String)context.get("componentName");
		
		RuntimeContext runtimeContext=Startup.getRuntimeContext();
		PersistManager jwebapDefManager=runtimeContext.getJwebapDefManager();
		JwebapDef def=jwebapDefManager.get();
		ComponentDef componentDef=null;
		if(componentName!=null){
			componentDef=def.getComponentDef(componentName);
		}
		
		if(componentDef!=null){
			context.put("name", componentDef.getName());
			context.put("class", componentDef.getType());
			Collection params=componentDef.getProperties();
			context.put("params",params);
		}
		
		
	}
}
