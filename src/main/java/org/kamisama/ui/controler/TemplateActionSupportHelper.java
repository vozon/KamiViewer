package org.kamisama.ui.controler;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kamisama.ui.template.Context;

/**
 * ģ�洦��Action������
 * 
 * �ܹ���request��ȡ�����Լ����ԣ���ʼ����Context�У����㴦��ͬʱʹģ��Action�ӿڸ�������
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2007-12-18
 */
public abstract class TemplateActionSupportHelper extends TemplateActionSupport {

	private static final Log log = LogFactory.getLog(TemplateActionSupportHelper.class);
	
	/**
	 * ����ģ�洦���Action��ʵ�ָ÷���
	 * 
	 * @param request
	 * @param response
	 * @param context
	 * @throws Exception
	 */
	public void process(HttpServletRequest request,
			HttpServletResponse response, Context context) throws Exception {
		putParameters(request, response, context);
		process(context);
	}

	/**
	 * ��ʼ�������Ĳ���
	 * 
	 * @param request
	 * @param response
	 * @param context
	 */
	private void putParameters(HttpServletRequest request,
			HttpServletResponse response, Context context) {
		
		Map params = request.getParameterMap();
		Iterator paramsKeyIt=params.keySet().iterator();
		while (paramsKeyIt.hasNext()) {
			String paramName = (String) paramsKeyIt.next();
			String value = request.getParameter(paramName);
			try {
				context.put(paramName, value);
			} catch (Exception e) {
				//�������Һܿ��գ�CommonTemplate ���ڲ����������淶��飬���������淶�Ƿ�Ӧ�����Բ���ȥ����
				log.warn("param '"+paramName+"' can not initial into Context. error:"+e+" "+e.getMessage());
			}
		}
		
		Enumeration attributeNames = request.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = (String) attributeNames.nextElement();
			Object value = request.getAttribute(attributeName);
			try {
				context.put(attributeName, value);
			} catch (Exception e) {
				//�������Һܿ��գ�CommonTemplate ���ڲ����������淶��飬���������淶�Ƿ�Ӧ�����Բ���ȥ����
				log.warn("attribute '"+attributeName+"' can not initial into Context. error:"+e+" "+e.getMessage());
			}
		}

	}

	/**
	 * ����ģ�洦���Actionʵ�ָ÷���
	 * 
	 * @param request
	 * @param response
	 * @param context
	 * @throws Exception
	 */
	public abstract void process(Context context) throws Exception;

}
