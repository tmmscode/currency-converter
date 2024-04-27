package tmmscode.challengeCurrencyConverter.models;

import java.util.Map;

public record ExchangeRateDTO(String base_code, Map<String, Double> conversion_rates) {
}
