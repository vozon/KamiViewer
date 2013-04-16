package org.kamisama.ui.template;

import java.io.IOException;

/**
 * ģ������
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2007-11-23
 */
public interface TemplateEngine extends TemplateFactory, ContextFactory {

	/**
	 * ��ģ��
	 * 
	 * @param templateName
	 *            ģ������
	 * @param context
	 *            ������
	 * @throws MergeException
	 */
	public abstract void mergeTemplate(String templateName, Context context)
			throws MergeException,IOException;

	/**
	 * ��ģ��
	 * 
	 * @param templateName
	 *            ģ������
	 * @param encoding
	 *            ģ���ļ�����
	 * @param context
	 *            ������
	 * @throws MergeException
	 */
	public abstract void mergeTemplate(String templateName, String encoding,
			Context context) throws MergeException,IOException;

	/**
	 * ��ģ��
	 * 
	 * @param template
	 *            ģ��
	 * @param context
	 *            ������
	 * @throws MergeException
	 */
	public abstract void mergeTemplate(Template template, Context context)
			throws MergeException;

}
