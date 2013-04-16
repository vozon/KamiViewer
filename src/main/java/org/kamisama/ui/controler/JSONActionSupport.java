package org.kamisama.ui.controler;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Json������Action֧����
 * 
 * ���Actionֻ��Ҫ����Json������ô���Լ̳и���ʵ��Action JSONActionSupport������ɵ�Json�����ı�(@see
 * http://www.json.org/) �����http��Ӧ��
 * 
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date 2008-1-29
 */
public abstract class JSONActionSupport extends Action {

	public void process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject json =processJson(request,response);
		
		if (json != null) {
			String cb = request.getParameter("callback");
			if (cb != null) { 
			    response.setContentType("text/javascript; charset=utf-8");
			} else {
			    response.setContentType("application/x-json; charset=utf-8");
			}

			PrintWriter out = response.getWriter();
			out.print(json.toString());
			
		}

	}

	public abstract JSONObject processJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
