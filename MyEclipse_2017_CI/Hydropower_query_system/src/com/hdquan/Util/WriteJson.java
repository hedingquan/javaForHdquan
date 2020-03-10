package com.hdquan.Util;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJson{
	public static String getJsonString(Object o)
	{
		ObjectMapper om=new ObjectMapper();
		StringWriter sw=new StringWriter();
		try {
			JsonGenerator jg=new JsonFactory().createJsonGenerator(sw);
			om.writeValue(jg, o);
			jg.close();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}
	public static void writeJson(Object o,HttpServletResponse response)
	{
		String json=getJsonString(o);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
