package org.kamisama.ui.controler;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kamisama.cfg.model.ActionDef;
import org.kamisama.ui.template.Context;
import org.kamisama.ui.template.EngineFactory;
import org.kamisama.ui.template.Template;
import org.kamisama.ui.template.TemplateEngine;

/**
 * ģ�洦��Action
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2007-12-18
 */
public abstract class TemplateActionSupport extends Action {

	public void process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TemplateEngine engine = EngineFactory
				.getEngine(EngineFactory.COMMON_TEMPLATE);

		Writer out = response.getWriter();

		Context templateContext = null;

		ActionDef config = getActionContext()
				.getActionDefinition();
		String templateName = config.getTemplate();
		Template template = null;
		if (templateName != null && !"".equals(templateName)) {
			template = engine.getTemplate(templateName);
			templateContext = engine.createContext(out);
		}
		/**
		 * ģ�洦��
		 * 
		 */
		process(request,response,templateContext);
		/**
		 * ģ��չ��
		 */
		if (template != null) {
			template.merge(templateContext);
		}
	}

	/**
	 * ����ģ�洦���Action��ʵ�ָ÷���
	 * 
	 * @param request
	 * @param response
	 * @param context
	 * @throws Exception
	 */
	public abstract void process(HttpServletRequest request,
			HttpServletResponse response, Context context) throws Exception;

}
