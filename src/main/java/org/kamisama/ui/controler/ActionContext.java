package org.kamisama.ui.controler;

import org.kamisama.cfg.model.ActionDef;
import org.kamisama.core.Component;
import org.kamisama.core.ComponentContext;
import org.kamisama.core.Context;

/**
 * Action�����ģ����Ի�ȡ��ǰAction��Ӧ��Component�����
 * ���������ͼ����������Ĺ�����͸���ģ���ͼ����Ҫ�Ļ������ݶ���ͨ��ActionContext��á�
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date  2007-12-14
 */
public interface ActionContext extends Context{

	
	/**
	 * �õ���ǰAction��Ӧ��Component������
	 * @return
	 */
	public Component getComponent();
	
	/**
	 * �õ�Action��Ӧ�������������
	 * @return
	 */
	public ComponentContext getComponentContext();

	public ActionDef getActionDefinition();
}
