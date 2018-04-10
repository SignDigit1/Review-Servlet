package utils;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

/**
 * servlet工具类
 * 
 * @author admin
 *
 */
public class ServletUtils {

	/**
	 * 请求参数转为JsonObject
	 * 
	 * @param request
	 * @return
	 */
	public static JSONObject getAjaxPostJsonParam(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = request.getReader();) {
			char[] buff = new char[1024];
			int len;
			while ((len = reader.read(buff)) != -1) {
				sb.append(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String jsonStr = sb.toString();
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		return jsonObject;
	}

}
