package org.kamisama.ui.template;

import java.io.Writer;
import java.util.Map;

/**
 * ģ������������
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date  2007-11-26
 */
public interface Context {
	public void clear();
	
	/**
	 * ��ȡ��ǰ�����ĵ������
	 * 
	 * @return �����
	 */
	public abstract Writer getOut();
	
	/**
	 * ��ȡ��������
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key);
	
	/**
	 * ��ȡ���в���
	 * @return
	 */
	public Map getAll();
	
	/**
	 * �󶨻�������
	 * 
	 * @return
	 */
	public void put(String key,Object value);
	
	/**
	 * �����л�������
	 * 
	 * @return
	 */
	public void putAll(Map values);
}
