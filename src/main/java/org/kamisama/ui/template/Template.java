package org.kamisama.ui.template;


/**
 * ģ��
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date  2007-11-23
 */
public interface Template {
	
	/**
	 * ��������
	 * 
	 * @param context
	 * @throws MergeException
	 */
	public void merge(Context context)throws MergeException;
}
