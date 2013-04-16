package org.kamisama.ui.controler;


/**
 * Http����ӳ����� ֧��ͨ���'*',mapping���ʽ��������: 1)ͨ���'*'���������ַ� 2)'/'����WebModule��Ŀ¼
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2007-12-18
 */
public class Mapper {

	/**
	 * Mapping���ʽ,����'view/*',�ñ��ʽ�������JwebapServlet��Mapping·������
	 */
	private String urlPattern;

	public Mapper(String mapping) {
		assertPatternValidate(mapping);
		urlPattern = mapping;
	}

	private void assertPatternValidate(String pattern)
			throws IllegalArgumentException {
		if (pattern.indexOf(".") < 0) {
			if (pattern.indexOf("*") < 0) {
				return;
			}

			if (pattern.indexOf("/*") == pattern.length() - 2) {
				return;
			}
		}

		throw new IllegalArgumentException("invalid mapping:" + pattern);

	}

	/**
	 * ����Mapper�ĸ�Ŀ¼
	 * <p>
	 * ����mapping=/view/*,��ômappingPath=/view
	 * </p>
	 * <p>
	 * ����mapping=/view,��ômappingPath=/view
	 * </p>
	 * 
	 * @param request
	 * @param path
	 *            ���ڵ�ǰurlPattern�����·����'/'����ǰurlPattern�ĸ�·��
	 * @return
	 */
	public String getMappingPath() {
		String path = urlPattern;
		if (urlPattern.endsWith("/*")) {
			path = urlPattern.substring(0, urlPattern.length() - 2);
		}
		return path;

	}
}
