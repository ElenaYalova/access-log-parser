import java.time.LocalDateTime;

public class LogEntry {
    private final String ipAddress;
    private final LocalDateTime dateTime;
    private final HttpMethod method;;
    private final String path;
    private final int responseCode;
    private final long dataSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String[] parts) {
        this.ipAddress = parts[0];
        this.dateTime = LocalDateTime.parse(parts[3].substring(1, parts[3].length() - 1));
        this.method = HttpMethod.valueOf(parts[5].substring(1));
        this.path = parts[6];
        this.responseCode = Integer.parseInt(parts[8]);
        this.dataSize = Long.parseLong(parts[9]);
        this.referer = parts[10].substring(1, parts[10].length() - 1);
        this.userAgent = new UserAgent(parts[10]);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public long getDataSize() {
        return dataSize;
    }

    public String getReferer() {
        return referer;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }
}

enum HttpMethod {
    GET, POST, PUT, DELETE
}