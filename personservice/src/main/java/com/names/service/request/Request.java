package com.names.service.request;

import com.google.gson.Gson;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Request<T> {

    public static final String AGIFY_IO_NAME_URL = "https://api.agify.io/";

    private String data;
    private Class<T> tClass;

    public Request(Class<T> tClass) {
        this.tClass = tClass;
    }

    public boolean sendRequest(String url, String params) {

        final CloseableHttpClient client = HttpClients.createDefault();
        final HttpUriRequest request = new HttpGet(url + params);

        try (final CloseableHttpResponse response = client.execute(request);) {

            this.data = EntityUtils.toString(response.getEntity());

        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public T fromJson() {
        return new Gson().fromJson( data, tClass);
    }
}
