package tmmscode.challengeCurrencyConverter.models;

import java.time.Instant;

public class LogRegistry {
    private String requestedAt;
    private String baseISO;
    private String convertISO;
    private double convertionRate;
    private double convertionValue;

    public LogRegistry (String baseISO, String convertISO, double convertionRate ,double convertionValue) {
        this.requestedAt = Instant.now().toString();
        this.baseISO = baseISO;
        this.convertISO = convertISO;
        this.convertionRate = convertionRate;
        this.convertionValue = convertionValue;
    }

    public String getRequestedAt() {
        return String.valueOf(this.requestedAt);
    }

    public String getBaseISO() {
        return baseISO;
    }

    public String getConvertISO() {
        return convertISO;
    }

    public double getConvertionRate() {
        return convertionRate;
    }

    public double getConvertionValue() {
        return convertionValue;
    }

    @Override
    public String toString() {
        return  "\n" + getRequestedAt() + " : Exchange rate from " + getBaseISO() + " to " + getConvertISO() + " was " + getConvertionRate() + ". The base value of "
                + getConvertionValue() + " " + getBaseISO() + " was converted to " + String.format("%.2f", (getConvertionValue() * getConvertionRate())) + " " + getConvertISO();
    }
}
