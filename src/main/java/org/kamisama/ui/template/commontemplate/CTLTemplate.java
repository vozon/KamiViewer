package org.kamisama.ui.template.commontemplate;

import org.commontemplate.core.Template;
import org.kamisama.ui.template.Context;
import org.kamisama.ui.template.MergeException;
import org.kamisama.util.Assert;

/**
 * Common Template Template Adapter
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date  2007-11-26
 */
public class CTLTemplate implements org.kamisama.ui.template.Template {
	
	private Template _template=null;
	
	public CTLTemplate(Template template){
		_template=template;
	}
	
	public void merge(Context context) throws MergeException {
		Assert.assertNotNull(_template,"CommonTemplateģ��Ϊ��!");
		
		try{
			CTLContext ctlContext=(CTLContext)context;
			org.commontemplate.core.Context delegate=(org.commontemplate.core.Context)ctlContext.getDelegate();
			_template.render(delegate);
		}catch(ClassCastException e){
			throw new ClassCastException("���ܰ�CommonTemplate����������Ķ���!");
		}
	}

}
