package org.kamisama.ui.controler;

/**
 * ģ����ͼ�ڲ�����
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2007-11-23
 */
public class ActionException extends RuntimeException {

	static final long serialVersionUID = -1L;
	
	public ActionException(String message) {
		super(message);
	}

	public ActionException(String message, Throwable cause) {
		super(message, cause);
	}

}
