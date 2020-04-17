package com.ruoyi.common.httpClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;

public class CreateHttpClientSSL {

    TrustAnyTrustManager trustAnyTrustManager = new TrustAnyTrustManager();

    public static HttpClient createHttpClient() throws Exception {
        try{
            CreateHttpClientSSL client = new CreateHttpClientSSL();
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] {client.trustAnyTrustManager}, null);
            SSLConnectionSocketFactory sslConnectionSocketFactory =
                    new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
            HttpClient httpClient =
                    HttpClients.custom().disableCookieManagement().setSSLSocketFactory(
                            sslConnectionSocketFactory).setMaxConnPerRoute(50).setDefaultRequestConfig(
                            RequestConfig.custom().setConnectionRequestTimeout(60000).setConnectTimeout(60000).setSocketTimeout(60000).build())
                    .build();
            return httpClient;
        }catch (Exception e){
            throw new Exception(e);
        }
    }


    public class TrustAnySSLSocketFactory extends SSLSocketFactory {
        private SSLSocketFactory factory;
        public TrustAnySSLSocketFactory() {
            try {
                SSLContext sc = SSLContext.getInstance("TLS");
                sc.init(null, new TrustManager[] {new TrustAnyTrustManager() }, null);
                this.factory = sc.getSocketFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        @Override
        public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
            return this.factory.createSocket();
        }
        @Override
        public String[] getDefaultCipherSuites() {
            return this.factory.getDefaultCipherSuites();
        }
        @Override
        public String[] getSupportedCipherSuites() {
            return this.factory.getSupportedCipherSuites();
        }
        @Override
        public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
            return this.factory.createSocket(host, port);
        }
        @Override
        public Socket createSocket(InetAddress host, int port) throws IOException {
            return this.factory.createSocket(host, port);
        }
        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
                throws IOException, UnknownHostException {
            return this.factory.createSocket(host, port, localHost, localPort);
        }
        @Override
        public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
            return this.factory.createSocket(address, port, localAddress, localPort);
        }
    }

    public class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}