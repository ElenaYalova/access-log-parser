import java.time.LocalDateTime;

public class Statistics {
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;

    public Statistics() {
        this.totalTraffic = 0;
        this.minTime = LocalDateTime.MAX;
        this.maxTime = LocalDateTime.MIN;
    }

    public void addEntry(LogEntry entry) {
        this.totalTraffic += entry.getDataSize();
        LocalDateTime entryTime = entry.getDateTime();
        if (entryTime.isBefore(minTime)) {
            minTime = entryTime;
        }
        if (entryTime.isAfter(maxTime)) {
            maxTime = entryTime;
        }
    }

    public double getTrafficRate() {
        double hours = java.time.Duration.between(minTime, maxTime).toHours();
        return totalTraffic / hours;
    }
}