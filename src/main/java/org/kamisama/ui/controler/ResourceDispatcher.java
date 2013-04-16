package org.kamisama.ui.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��̬�ļ�����ķַ�����������Դ�Ĳ������Լ���Ҫ��
 * <p>
 * 1)��Դλ��resources.*���Լ��Ӱ��� 2)��Dispatcher��SubPathΪ�Ӱ�����ȡ�ļ�
 * </p>
 * ��������·��:http://domain/detect/resources/js/a.js,Disaptcher�ַ��ĸ�·��:/resources/*
 * ��ô,SubPath:/js/a.js,�����������Դ��:resources/js/a.js
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2008-1-10
 */
public class ResourceDispatcher extends AbstractDispatcher {

	private ResourceProcesser processer;

	public ResourceDispatcher() {
		processer = new ResourceProcesser();
	}

	public void dispatch(HttpServletRequest request,
			HttpServletResponse response, DispatcherChain chain)
			throws Exception {
		String path = this.getSubPath(request);
		int doat = path.lastIndexOf(".");
		String mime = doat > -1 && doat < path.length() - 1 ? path
				.substring(doat + 1) : "";

		if (path.indexOf("/images/") > -1 || path.indexOf("/image/") > -1
				|| "|jpg|jpeg|bmp|gif|png|tng|".indexOf(mime) > -1) {
			response.setContentType("image/jpeg;");
		} else if ("css".equals(mime)) {
			response.setContentType("text/css;");
		} else if ("xml".equals(mime)) {
			response.setContentType("text/xml;");
		} else if ("".equals(mime) || "html".equals(mime) || "htm".equals(mime)) {
			response.setContentType("text/html;");
		} else {
			response.setContentType("text/" + mime + ";");
		}

		processer.process(path, request, response);
	}

}
