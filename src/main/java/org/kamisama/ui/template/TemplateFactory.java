package org.kamisama.ui.template;

import java.io.IOException;


public interface TemplateFactory {
	/**
	 * ͨ�����ƻ�ȡģ��. ʹ��Ĭ�ϱ������
	 * 
	 * @param name
	 *            ģ������
	 * @return ģ��
	 * @throws TemplateException
	 *             ģ���������ʱ�׳�
	 */
	public Template getTemplate(String name) throws IOException,
			TemplateException;

	/**
	 * ͨ�����ƻ�ȡģ��. ��ָ�����ر���
	 * 
	 * @param name
	 *            ģ������
	 * @param encoding
	 *            ģ�����
	 * @return ģ��
	 * @throws TemplateException
	 *             ģ���������ʱ�׳�
	 */
	public Template getTemplate(String name, String encoding)
			throws IOException, TemplateException;
}
