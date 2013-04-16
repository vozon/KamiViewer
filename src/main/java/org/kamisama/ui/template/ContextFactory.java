package org.kamisama.ui.template;

import java.io.Writer;
import java.util.Locale;
import java.util.TimeZone;

public interface ContextFactory {
	
	/**
	 * �����µ�ģ��������
	 * 
	 * @param out
	 *            ����ӿ�
	 * @return �µ�ģ��������
	 */
	public Context createContext(Writer out);
	/**
	 * �����µ�ģ�������� ͨ��Locale������Ӧ��TimeZone(�Ե��������׶�Ϊ׼)
	 * 
	 * @param out
	 *            ����ӿ�
	 * @param locale
	 *            ���ʻ�����
	 * @return �µ�ģ��������
	 */
	public Context createContext(Writer out,Locale locale);

	/**
	 * �����µ�ģ��������
	 * 
	 * @param out
	 *            ����ӿ�
	 * @param locale
	 *            ���ʻ�����
	 * @param timeZone
	 *            ʱ��
	 * @return �µ�ģ��������
	 */
	public Context createContext(Writer out,Locale locale, TimeZone timeZone);

}
