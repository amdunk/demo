package com.book.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Http {
	
	// 日志接口
	private static Logger logger = LoggerFactory.getLogger(Http.class.getName());
	
	public static String  get(String path){
		HttpURLConnection connection = null;
		try{
			logger.info("Http.get url:" + path.toString());
			
			URL url = new URL(path.toString());
			connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			InputStream is = connection.getInputStream();
			Reader reader = new InputStreamReader(is, "utf-8");
			
			StringWriter writer = new StringWriter();
			pipe(reader, writer);

			String json = writer.toString();	
			
			logger.info("Http.get result:" + json);
			
			return json;
			
		}catch(Exception e){
			logger.error("get" ,e);
			return null;
		}finally{
			if(connection!=null){
				try{
					connection.disconnect();
				}catch(Exception e){
					logger.error("get",e);
				}
			}
		}	
	}
	
	public static InputStream download(String path){
		URL url = null;
		InputStream is = null;
		try {
			url = new URL(path);
			is = url.openStream();
			return is;
		} catch (Exception e) {
			logger.error("download", e);
			return null;
		}
	}
	
	public static String post(String path,Map<String,Object> map){
		StringBuffer sb=new StringBuffer();
		int i=0;
		for(Map.Entry<String, Object> entry:map.entrySet()){
			if(i>0){
				sb.append("&");
			}
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			i++;
		}
		return post(path, sb.toString(),false,null);
	}
	
	public static String  post(String path,String data){
		return post(path, data,true,null);
	}
	
	public static String post(String path,String data,Map<String,String> header){
		return post(path, data,false,header);
	}
	
	public static String  post(String path,String data,boolean isjson,Map<String,String> headers){
		HttpURLConnection connection = null;
		try{
	
			URL url = new URL(path.toString());
			connection = (HttpURLConnection) url.openConnection();
			connection.setReadTimeout(5000);
			connection.setConnectTimeout(5000);
			connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
          
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); 
            if(isjson){
            	connection.setRequestProperty("Content-Type", "application/json"); 
            }
            if(headers!=null){
            	for(Map.Entry<String, String> entry:headers.entrySet()){
            		connection.addRequestProperty(entry.getKey(), entry.getValue());
            	}
            }
			connection.connect();
			//post
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
			logger.info("Http.post data:"+data);
			out.append(data);  
		    out.flush();  
		    out.close();  
		
			InputStream is = connection.getInputStream();
			Reader reader = new InputStreamReader(is, "utf-8");
			
			StringWriter writer = new StringWriter();
			pipe(reader, writer);

			String json = writer.toString();		
			logger.info("Http.post result:"+json);
			return json;
			
		}catch(Exception e){
			logger.error("post", e);
			return null;
		}finally{
			if(connection!=null){
				try{
					connection.disconnect();
				}catch(Exception e){
					logger.error("post", e);
				}
			}
		}	
	}
	
	private static void pipe(Reader reader, Writer writer) throws IOException {
		char[] buf = new char[1024];
		int read = 0;
		while ((read = reader.read(buf)) >= 0) {
			writer.write(buf, 0, read);
		}

		writer.flush();
	}
	
	
}
