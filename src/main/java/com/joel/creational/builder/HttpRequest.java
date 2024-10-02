package com.joel.creational.builder;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String path;
    private HttpMethods method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private Map<String, String> cookies;   
    private String body;
    private String protocolVersion;        
    private String host;                   
    private String userAgent;              
    private boolean secureConnection;      
    private int port;                      
    private long contentLength;            
    private String contentType;            
    
    private HttpRequest(
        String path, 
        HttpMethods method, 
        Map<String, String> headers, 
        Map<String, String> queryParams, 
        Map<String, String> cookies,
        String body,
        String protocolVersion, 
        String host, 
        String userAgent, 
        boolean secureConnection, 
        int port, 
        long contentLength, 
        String contentType
    ){
        this.path = path;
        this.method = method;
        this.headers = headers;
        this.queryParams = queryParams;
        this.body = body;
        this.protocolVersion = protocolVersion;
        this.host = host;
        this.userAgent = userAgent;
        this.secureConnection = secureConnection;
        this.port = port;
        this.contentLength = contentLength;
        this.contentType = contentType;
        this.cookies = cookies; 
    }

    public String getPath() { return path; }
    public HttpMethods getMethod() { return method; }
    public Map<String, String> getHeaders() { return headers; }
    public Map<String, String> getQueryParams() { return queryParams; }
    public String getBody() { return body; }
    public String getProtocolVersion() { return protocolVersion; }
    public String getHost() { return host; }
    public String getUserAgent() { return userAgent; }
    public boolean isSecureConnection() { return secureConnection; }
    public int getPort() { return port; }
    public long getContentLength() { return contentLength; }
    public String getContentType() { return contentType; }
    public Map<String, String> getCookies() { return cookies; }
    public String getFullUrl() {
        String protocol = secureConnection ? "https" : "http";
        StringBuilder fullUrl = new StringBuilder(protocol + "://" + host);
        if (port != 80 && port != 443) {
            fullUrl.append(":").append(port);
        }
        fullUrl.append(path);
        if (queryParams != null && !queryParams.isEmpty()) {
            fullUrl.append("?");
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                fullUrl.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            fullUrl.setLength(fullUrl.length() - 1); 
        }
        return fullUrl.toString();
    }

    @Override
    public String toString() {
        return "HttpRequest{" + "path='" + path + '\'' +
        ", method=" + method +
        ", headers=" + headers +
        ", queryParams=" + queryParams +
        ", body='" + body + '\'' +
        ", protocolVersion='" + protocolVersion + '\'' +
        ", host='" + host + '\'' +
        ", userAgent='" + userAgent + '\'' +
        ", secureConnection=" + secureConnection +
        ", port=" + port +
        ", contentLength=" + contentLength +
        ", contentType='" + contentType + '\'' +
        ", cookies=" + cookies + '}'; 
    }

    public static class Builder {
        private String path;
        private HttpMethods method;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private String body;
        private String protocolVersion;
        private String host;
        private String userAgent;
        private boolean secureConnection;
        private int port;
        private long contentLength;
        private String contentType;
        private Map<String, String> cookies = new HashMap<>();

        public Builder(){}
    
        public Builder setPath(String path) {
            this.path = path;
            return this;
        }
    
        public Builder setMethod(HttpMethods method) {
            this.method = method;
            return this;
        }
    
        public Builder setHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }
    
        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }
    
        public Builder setQueryParams(Map<String, String> queryParams) {
            this.queryParams = queryParams;
            return this;
        }
    
        public Builder addQueryParam(String key, String value) {
            this.queryParams.put(key, value);
            return this;
        }
    
        public Builder setBody(String body) {
            this.body = body;
            return this;
        }
    
        public Builder setProtocolVersion(String protocolVersion) {
            this.protocolVersion = protocolVersion;
            return this;
        }
    
        public Builder setHost(String host) {
            this.host = host;
            return this;
        }
    
        public Builder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }
    
        public Builder setSecureConnection(boolean secureConnection) {
            this.secureConnection = secureConnection;
            return this;
        }
    
        public Builder setPort(int port) {
            this.port = port;
            return this;
        }
    
        public Builder setContentLength(long contentLength) {
            this.contentLength = contentLength;
            return this;
        }
    
        public Builder setContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }
    
        public Builder setCookies(Map<String, String> cookies) {
            this.cookies = cookies;
            return this;
        }
    
        public Builder addCookie(String key, String value) {
            this.cookies.put(key, value);
            return this;
        }
    
        public HttpRequest build() {
            return new HttpRequest(
                path, method, 
                headers, queryParams, 
                cookies,body, protocolVersion,
                host,userAgent, secureConnection, port, 
                contentLength, contentType
            );
        }
    }    

    static enum HttpMethods {
        GET,
        POST,
        PUT,
        DELETE,
        PATCH,
        OPTIONS
    }
}