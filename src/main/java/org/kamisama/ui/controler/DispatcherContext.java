package org.kamisama.ui.controler;

import org.kamisama.core.Context;
import org.kamisama.util.ParameterMap;

/**
 * 分发器上下文
 * <p>
 * 在Dispatcher初始化时使用的上下文
 * </p>
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date  2007-12-4
 * @see org.kamisama.ui.controler.Dispatcher
 */
public interface DispatcherContext extends ParameterMap,Context{
	
	public String getDispatcherPath();
	
}
