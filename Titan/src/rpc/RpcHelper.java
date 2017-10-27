package rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RpcHelper {
	// Parses a JSONObject from http request.
	public static JSONObject readJsonObject(HttpServletRequest request) throws IOException, JSONException {
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		
		return new JSONObject(sb.toString());
	}

	
    // Writes a JSONObject to http response.
public static void writeJsonObject(HttpServletResponse response, JSONObject obj) throws IOException {
	response.setContentType("application/json");
	response.addHeader("Access-Control-Allow-Origin", "*");
	PrintWriter out = response.getWriter();
	out.print(obj);
	out.flush();
	out.close();
}

// Writes a JSONArray to http response.
public static void writeJsonArray(HttpServletResponse response, JSONArray array) throws IOException {
	response.setContentType("application/json");
	response.addHeader("Access-Control-Allow-Origin", "*");
	PrintWriter out = response.getWriter();
	out.print(array);
	out.flush();
	out.close();
}
	

}
