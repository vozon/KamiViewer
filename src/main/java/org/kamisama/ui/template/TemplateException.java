package org.kamisama.ui.template;

/**
 * ģ�������ڲ�����
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2007-11-23
 */
public class TemplateException extends RuntimeException {

	static final long serialVersionUID = -19811222L;
	
	public TemplateException(String message) {
		super(message);
	}

	public TemplateException(String message, Throwable cause) {
		super(message, cause);
	}

}
