package org.kamisama.ui.template;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kamisama.util.BeanUtil;

/**
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2007-11-23
 */
public class EngineFactory {
	private static final Log log = LogFactory.getLog(EngineFactory.class);

	private static Map engines = new HashMap();

	// CommonTemplate����
	public final static Object COMMON_TEMPLATE = new Object();

	// Velocity����
	public final static Object VELOCITY = new Object();

	static {
		// Velocity

		// CommonTemplate
		initialize(COMMON_TEMPLATE,"org.jwebap.ui.template.commontemplate.CTLTemplateEngine");
	}

	public static void initialize(Object key,String className){
		try {
			engines.put(key,BeanUtil.newInstance(className));
		} catch (Exception e) {
			log.error("ģ������󶨴���.",e);
		}
		
	}
	
	public static TemplateEngine getEngine(Object key) {
		if (key == null) {
			return null;
		}
		return (TemplateEngine) engines.get(key);
	}

}
