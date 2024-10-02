import java.util.HashMap;
import java.util.Map;

public class HttpRequestBuilder {
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
    private String referrer;
    private Map<String, String> cookies = new HashMap<>();

    public HttpRequestBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public HttpRequestBuilder setMethod(HttpMethods method) {
        this.method = method;
        return this;
    }

    public HttpRequestBuilder setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public HttpRequestBuilder addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public HttpRequestBuilder setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
        return this;
    }

    public HttpRequestBuilder addQueryParam(String key, String value) {
        this.queryParams.put(key, value);
        return this;
    }

    public HttpRequestBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public HttpRequestBuilder setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
        return this;
    }

    public HttpRequestBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public HttpRequestBuilder setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public HttpRequestBuilder setSecureConnection(boolean secureConnection) {
        this.secureConnection = secureConnection;
        return this;
    }

    public HttpRequestBuilder setPort(int port) {
        this.port = port;
        return this;
    }

    public HttpRequestBuilder setContentLength(long contentLength) {
        this.contentLength = contentLength;
        return this;
    }

    public HttpRequestBuilder setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public HttpRequestBuilder setReferrer(String referrer) {
        this.referrer = referrer;
        return this;
    }

    public HttpRequestBuilder setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
        return this;
    }

    public HttpRequestBuilder addCookie(String key, String value) {
        this.cookies.put(key, value);
        return this;
    }

    public HttpRequest build() {
        return new HttpRequest(
            path, 
            method, 
            headers, 
            queryParams, 
            body, 
            protocolVersion, 
            host, 
            userAgent, 
            secureConnection, 
            port, 
            contentLength, 
            contentType, 
            referrer, 
            cookies
        );
    }
    
 private class HttpRequest {
    private String path;
    private HttpMethods method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private String protocolVersion;        
    private String host;                   
    private String userAgent;              
    private boolean secureConnection;      
    private int port;                      
    private long contentLength;            
    private String contentType;            
    private String referrer;               
    private Map<String, String> cookies;   

    
    public HttpRequest(
        String path, 
        HttpMethods method, 
        Map<String, String> headers, 
        Map<String, String> queryParams, 
        String body, String protocolVersion, 
        String host, 
        String userAgent, 
        boolean secureConnection, 
        int port, 
        long contentLength, 
        String contentType, 
        String referrer, 
        Map<String, String> cookies) {
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
            this.referrer = referrer; 
            this.cookies = cookies; 
        }

    
        public void setPath(String path) { this.path = path; }
        public void setMethod(HttpMethods method) { this.method = method; }
        public void setHeaders(Map<String, String> headers) { this.headers = headers; }
        public void setQueryParams(Map<String, String> queryParams) { this.queryParams = queryParams; }
        public void setBody(String body) { this.body = body; }
        public void setProtocolVersion(String protocolVersion) { this.protocolVersion = protocolVersion; }
        public void setHost(String host) { this.host = host; }
        public void setUserAgent(String userAgent) { this.userAgent = userAgent; }
        public void setSecureConnection(boolean secureConnection) { this.secureConnection = secureConnection; }
        public void setPort(int port) { this.port = port; }
        public void setContentLength(long contentLength) { this.contentLength = contentLength; }
        public void setContentType(String contentType) { this.contentType = contentType; }
        public void setReferrer(String referrer) { this.referrer = referrer; }
        public void setCookies(Map<String, String> cookies) { this.cookies = cookies; }
    
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
        public String getReferrer() { return referrer; }
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
        return "HttpRequest{" +
            "path='" + path + '\'' +
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
            ", referrer='" + referrer + '\'' +
            ", cookies=" + cookies + '}'; 
    }
}

    enum HttpMethods {
        GET,
        POST,
        PUT,
        DELETE,
        PATCH,
        OPTIONS
    }
}
