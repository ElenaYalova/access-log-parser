public class UserAgent {
    private final String operatingSystem;
    private final String browser;

    public UserAgent(String userAgentString) {
        if (userAgentString.contains("Windows")) {
            this.operatingSystem = "Windows";
        } else if (userAgentString.contains("Mac OS X")) {
            this.operatingSystem = "macOS";
        } else if (userAgentString.contains("Linux")) {
            this.operatingSystem = "Linux";
        } else {
            this.operatingSystem = "Unknown";
        }

        if (userAgentString.contains("Edge")) {
            this.browser = "Edge";
        } else if (userAgentString.contains("Firefox")) {
            this.browser = "Firefox";
        } else if (userAgentString.contains("Chrome")) {
            this.browser = "Chrome";
        } else if (userAgentString.contains("Opera")) {
            this.browser = "Opera";
        } else {
            this.browser = "Other";
        }
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getBrowser() {
        return browser;
    }

}
