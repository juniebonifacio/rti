/**
 * 
 */
package com.customer.rti.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;


/**
 * @author junie.bonifacio
 *
 */
@SuppressWarnings("deprecation")
@Component
public class HttpClientUtilImpl implements HttpClientUtil {


	public String callHttpPost(String uri, String xmlGovTalkMessage) {
		String strResEntity = null;
		System.out.println("callHttpPost uri: " + uri);
		System.out.println("xmlGovTalkMessage: " + xmlGovTalkMessage);
		CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
		HttpPost httppost = new HttpPost(uri);

		HttpResponse httpresponse = null;
		HttpEntity resEntity = null;
		try {
			StringEntity se = new StringEntity(xmlGovTalkMessage, HTTP.UTF_8);
			se.setContentType("text/xml");
			httppost.setEntity(se);

			httpresponse = closeableHttpClient.execute(httppost);
			resEntity = httpresponse.getEntity();
			strResEntity = EntityUtils.toString(resEntity);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != resEntity) {
				try {
					resEntity.consumeContent();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(null != httppost) {
					httppost.abort();
				}
			}
			if (null != closeableHttpClient) {
				ClientConnectionManager connectionManager = closeableHttpClient.getConnectionManager();
				if (null != connectionManager) {
					connectionManager.closeExpiredConnections();
					connectionManager.shutdown();
				}
				try {
					closeableHttpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		return strResEntity;
	}
	
}
