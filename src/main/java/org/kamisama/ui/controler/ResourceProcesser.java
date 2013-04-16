package org.kamisama.ui.controler;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ȡ��̬��Դ������
 * @author leadyu(yu-lead@163.com)
 * @since Jwebap 0.5
 * @date  2008-1-10
 * @see ResourceDispatcher
 */
public class ResourceProcesser {
	public void process(String path, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String resName="resources"+(path.startsWith("/")?path:"/"+path);
		
		//�ӵ�ǰapplication�����ļ��ز㼶��Ѱ����Դ,������this.getClass().getClassLoader()
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		InputStream in=loader.getResourceAsStream(resName);
		
		
		OutputStream out=response.getOutputStream();
		if(in!=null){
			try{
				
				//�趨buffer��С
				int n = 512;
				byte buffer[] = new byte[n];
				// ��ȡ�ļ�������
				while (n > 0) {
					int t=in.read(buffer, 0, n);
					if(t<=-1){
						break;
					}
					out.write(buffer,0,t);
				}
				
			}finally{
				//response.flushBuffer();
				out.close();
				in.close();
			}
		}
	}
}
