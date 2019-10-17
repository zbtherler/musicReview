package com.music.review;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * http请求工具类
 * @author user
 *
 */
public class HttpUtil {
	
	//连接超时时间  
    private static final int CONNECTION_TIMEOUT = 3000;  
    //读取超时时间  
    private static final int READ_TIMEOUT = 5000;  
    //参数编码  
    private static final String ENCODE_CHARSET = "utf-8";  
  
    /** 
     * 发送HTTP_POST请求 
     *  
     * @see 本方法默认的连接和读取超时均为30秒 
     * @param reqURL 
     *            请求地址 
     * @param params 
     *            发送到远程主机的正文数据[a:1,b:2] 
     * @return String 
     */  
    public static String postRequest(String reqURL, String params) {  
        StringBuilder resultData = new StringBuilder();  
        URL url = null;  
        try {  
  
            url = new URL(reqURL);  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        }  
        HttpURLConnection urlConn = null;  
        InputStreamReader in = null;  
        BufferedReader buffer = null;  
        String inputLine = null;  
        DataOutputStream out = null;  
        if (url != null) {  
            try {  
                urlConn = (HttpURLConnection) url.openConnection();  
                urlConn.setDoInput(true);// 设置输入流采用字节流  
                urlConn.setDoOutput(true);// 设置输出流采用字节流  
                urlConn.setRequestMethod("POST");  
                urlConn.setUseCaches(false); // POST请求不能使用缓存  
                urlConn.setInstanceFollowRedirects(true);  
                urlConn.setConnectTimeout(CONNECTION_TIMEOUT);// 设置连接超时  
                urlConn.setReadTimeout(READ_TIMEOUT); // 设置读取超时  
                // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的  
//                urlConn.setRequestProperty("Content-Type",  "application/x-www-form-urlencoded");  
                urlConn.setRequestProperty("Content-Type",  "application/json");  
                urlConn.setRequestProperty("Charset", ENCODE_CHARSET);
//                String param = sendPostParams(params);  
                String param = params;  
                urlConn.setRequestProperty("Content-Length",  
                        param.getBytes().length + "");//  
                // urlConn.setRequestProperty("Connection", "Keep-Alive");  
                // //设置长连接  
                urlConn.connect();// 连接服务器发送消息  
                if (!"".equals(param)) {  
                    out = new DataOutputStream(urlConn.getOutputStream());  
                    // 将要上传的内容写入流中  
                    out.writeBytes(param);  
                    // 刷新、关闭  
                    out.flush();  
                    out.close();  
  
                }  
                in = new InputStreamReader(urlConn.getInputStream(),  
                        HttpUtil.ENCODE_CHARSET);  
                buffer = new BufferedReader(in);  
                if (urlConn.getResponseCode() == 200) {  
                    while ((inputLine = buffer.readLine()) != null) {  
                        resultData.append(inputLine);  
                    }  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            } finally {  
                try {  
                    if (buffer != null) {  
                        buffer.close();  
                    }  
  
                    if (in != null) {  
                        in.close();  
                    }  
  
                    if (urlConn != null) {  
                        urlConn.disconnect();  
                    }  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return resultData.toString();  
    }  
  
    /** 
     * 发送HTTP_GET请求 
     *  
     * @see 本方法默认的连接和读取超时均为30秒 
     * @param httpUrl 
     *            请求地址 
     * @param map 
     *            发送到远程主机的正文数据[a:1,b:2] 
     * @return String 
     */  
    public static String getRequest(String httpUrl, String... params) {  
        StringBuilder resultData = new StringBuilder();  
        URL url = null;  
        try {  
  
            String paramurl = sendGetParams(httpUrl, params);  
            url = new URL(paramurl);  
  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        }  
        HttpURLConnection urlConn = null;  
        InputStreamReader in = null;  
        BufferedReader buffer = null;  
        String inputLine = null;  
        if (url != null) {  
            try {  
                urlConn = (HttpURLConnection) url.openConnection();  
                urlConn.setRequestMethod("GET");  
                urlConn.setConnectTimeout(CONNECTION_TIMEOUT);  
                in = new InputStreamReader(urlConn.getInputStream(),  
                        HttpUtil.ENCODE_CHARSET);  
                buffer = new BufferedReader(in);  
                if (urlConn.getResponseCode() == 200) {  
                    while ((inputLine = buffer.readLine()) != null) {  
                        resultData.append(inputLine);  
                    }  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            } finally {  
                try {  
                    if (buffer != null) {  
                        buffer.close();  
                    }  
  
                    if (in != null) {  
                        in.close();  
                    }  
  
                    if (urlConn != null) {  
                        urlConn.disconnect();  
                    }  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
  
        return resultData.toString();  
    }  
  
    /** 
     * Post追加参数 
     *  
     * @see <code>params</code> 
     * @param reqURL 
     *            请求地址 
     * @param params 
     *            发送到远程主机的正文数据[a:1,b:2] 
     * @return 
     */  
    private static String sendPostParams(String... params) {  
        StringBuilder sbd = new StringBuilder("");  
        if (params != null && params.length > 0) {  
            for (int i = 0; i < params.length; i++) {  
                String[] temp = params[i].split(":");  
                sbd.append(temp[0]);  
                sbd.append("=");  
                sbd.append(urlEncode(temp[1]));  
                sbd.append("&");  
  
            }  
            sbd.setLength(sbd.length() - 1);// 删掉最后一个  
        }  
        return sbd.toString();  
    }  
  
    /** 
     * Get追加参数 
     *  
     * @see <code>params</code> 
     * @param reqURL 
     *            请求地址 
     * @param params 
     *            发送到远程主机的正文数据[a:1,b:2] 
     * @return 
     */  
    private static String sendGetParams(String reqURL, String... params) {  
        StringBuilder sbd = new StringBuilder(reqURL);  
        if (params != null && params.length > 0) {  
            if (isexist(reqURL, "?")) {// 存在?  
                sbd.append("&");  
            } else {  
                sbd.append("?");  
            }  
            for (int i = 0; i < params.length; i++) {  
                String[] temp = params[i].split(":");  
                sbd.append(temp[0]);  
                sbd.append("=");  
                sbd.append(urlEncode(temp[1]));  
                sbd.append("&");  
  
            }  
            sbd.setLength(sbd.length() - 1);// 删掉最后一个  
        }  
        return sbd.toString();  
    }  
    
    
    public static String doPost(String url, Map<String, Object> paramMap) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        // 封装post请求参数
        if (null != paramMap && paramMap.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            // 通过map集成entrySet方法获取entity
            Set<Entry<String, Object>> entrySet = paramMap.entrySet();
            // 循环遍历，获取迭代器
            Iterator<Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> mapEntry = iterator.next();
                nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
            }

            // 为httpPost设置封装好的请求参数
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
  
    // 查找某个字符串是否存在  
    private static boolean isexist(String str, String fstr) {  
        return str.indexOf(fstr) == -1 ? false : true;  
    }  
  
    /** 
     * 编码 
     *  
     * @param source 
     * @return 
     */  
    private static String urlEncode(String source) {  
        String result = source;  
        try {  
            result = java.net.URLEncoder  
                    .encode(source, HttpUtil.ENCODE_CHARSET);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
    
    
	public static void main(String[] args){
		String data1 = "[{\"macAddress\":\"dd5414200353\",\"brushTeethTime\":\"2010-09-18 12:15:47\",\"brushTeethDuration\":61,\"outLeftUpXBrushCount\":4,\"outLeftUpYBrushCount\":0,\"outLeftUp45DegreeCount\":5,\"outLeftUpWhiskCount\":0,\"outLeftUpBrushTime\":4,\"outLeftDownXBrushCount\":4,\"outLeftDownYBrushCount\":0,\"outLeftDown45DegreeCount\":0,\"outLeftDownWhiskCount\":0,\"outLeftDownBrushTime\":1,\"outCenterUpXBrushCount\":0,\"outCenterUpYBrushCount\":0,\"outCenterUp45DegreeBrushCount\":7,\"outCenterUpWhiskCount\":0,\"outCenterUpBrushTime\":1,\"outCenterDownXBrushCount\":0,\"outCenterDownYBrushCount\":0,\"outCenterDown45DegreeBrushCount\":0,\"outCenterDownWhiskCount\":0,\"outCenterDownBrushTime\":0,\"outRightUpXBrushCount\":1,\"outRightUpYBrushCount\":1,\"outRightUp45DegreeBrushCount\":0,\"outRightUpWhiskCount\":1,\"outRightUpBrushTime\":2,\"outRightDownXBrushCount\":1,\"outRightDownYBrushCount\":1,\"outRightDown45DegreeBrushCount\":0,\"outRightDownWhiskCount\":1,\"outRightDownBrushTime\":1,\"innerLeftUpBrushCount\":6,\"innerLeftUpWhiskCount\":0,\"innerLeftUpBrushTime\":2,\"innerLeftDownBrushCount\":0,\"innerLeftDownWhiskCount\":0,\"innerLeftDownBrushTime\":0,\"innerCenterUpBrushCount\":0,\"innerCenterUpWhiskCount\":0,\"innerCenterUpBrushTime\":0,\"innerCenterDownBrushCount\":0,\"innerCenterDownWhiskCount\":0,\"innerCenterDownBrushTime\":0,\"innerRightUpBrushCount\":2,\"innerRightUpWhiskCount\":0,\"innerRightUpBrushTime\":1,\"innerRightDownBrushCount\":0,\"innerRightDownWhiskCount\":0,\"innerRightDownBrushTime\":0,\"upLeftBrushCount\":11,\"upLeftBrushTime\":0,\"downLeftBrushCount\":7,\"downLeftBrushTime\":0,\"upRightBrushCount\":16,\"upRightBrushTime\":0,\"downRightBrushCount\":0,\"downRightBrushTime\":0}]";
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("data", data1);
		HttpUtil.doPost("http://os.32teeth.cn/api/block/uploadRepeaterRecord",requestMap);
	}
}
