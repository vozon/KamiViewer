package org.kamisama.ui.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kamisama.util.FactorySetter;

/**
 * ��׼Action����ַ��� ����Action��Mapping���ã��ַ������Action���д������е�Action���̳���Action��
 * <p>
 * public abstract class Action {
 * 
 * public abstract void process(HttpServletRequest request, HttpServletResponse
 * response); }
 * </p>
 * 
 * ���Ƕ��ڲ�ͬ�Ĵ�������Action�ַ�:ģ����ͼ����Action,��̬ͼƬ����Action,�ȵ�,����Action
 * ͨ��Support�����֧�֣���TemplateActionSupport��
 * 
 * public abstract class TemplateActionSupport extends Action {
 * 
 * public void process(HttpServletRequest request, HttpServletResponse response)
 * throws Exception {
 * 
 * TemplateEngine engine = EngineFactory.getEngine(); Writer out =
 * response.getWriter(); Context context = getContext(); Template template =
 * getTempalte();
 * 
 * //����ģ�� process(request,response,context);
 * 
 * //��ʾģ�� template.merge(templateContext); }
 * 
 * //���е�ģ�洦��Action��ʵ�ָ÷��� public abstract void process(HttpServletRequest
 * request, HttpServletResponse response, Context context) throws Exception;
 *  }
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2007-12-18
 * @see Action
 * @see TemplateActionSupport
 * @see PicActionSupport
 */
public class ActionDispatcher extends AbstractDispatcher {

	private ActionProcesser processer;

	public ActionDispatcher() {
		processer = new ActionProcesser(FactorySetter.getActionFactory());
	}

	

	public void dispatch(HttpServletRequest request,
			HttpServletResponse response, DispatcherChain chain)
			throws Exception {

		processer.process(getSubPath(request),request, response);

		chain.doChain(request, response);
	}

}
