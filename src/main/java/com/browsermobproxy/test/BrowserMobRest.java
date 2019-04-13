package com.browsermobproxy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 * BrowserMobRest
 */
public class BrowserMobRest {

    public void startProxy() {
        String browserMobUrl = "http://localhost:8080/proxy?port=3001&trustAllServers=true";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(browserMobUrl);

        /*
         * ArrayList<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
         * 
         * urlParameters.add(new BasicNameValuePair("trustAllServers", "true"));
         * urlParameters.add(new BasicNameValuePair("port", "3001"));
         */

        try {
            // post.setEntity(new UrlEncodedFormEntity(urlParameters));
            httpClient.execute(post);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createHarInstance() {

        String browserMobUrl = "http://localhost:8080/proxy/3001/har";

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPut put = new HttpPut(browserMobUrl);

        try {
            httpClient.execute(put);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addPageRef(String pageRef) {

        String browserMobUrl = "http://localhost:8080/proxy/3001/har/pageRef?pageRef=" + pageRef;

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPut put = new HttpPut(browserMobUrl);

        try {
            httpClient.execute(put);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void getHar() {

        String browserMoburl = "http://localhost:8080/proxy/3001/har";


        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet(browserMoburl);


        try {

            
            HttpResponse response = httpClient.execute(get);

           System.out.println(response.getStatusLine().getStatusCode());
           
           BufferedReader rd = new BufferedReader(
	       new InputStreamReader(response.getEntity().getContent()));

	    StringBuffer result = new StringBuffer();
	    String line = "";
	    while ((line = rd.readLine()) != null) {
		result.append(line);


        } 

        String final_result = result.toString();

        System.out.println("HAR Content :: -> ");
        System.out.println(final_result);
    } 
        catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


	}

}