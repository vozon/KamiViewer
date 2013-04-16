package org.kamisama.ui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.kamisama.cfg.model.JwebapDef;
import org.kamisama.cfg.persist.PersistManager;
import org.kamisama.core.RuntimeContext;
import org.kamisama.startup.Startup;
import org.kamisama.ui.controler.JSONActionSupport;

/**
 * ���ص�ǰ�����plugin����
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.6
 * @date  2008-11-25
 */
public class PluginListAction  extends JSONActionSupport {

	/**
	 * �������в����plugin
	 */
	public JSONObject processJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RuntimeContext context=Startup.getRuntimeContext();
		PersistManager jwebapDefManager=context.getJwebapDefManager();
		JwebapDef def=jwebapDefManager.get();
		
		JSONObject json = new JSONObject();
		json.put("plugins", def.getPluginDefs());
		return json;
		
	}
}
