package tmmscode.challengeCurrencyConverter.helpers;

import tmmscode.challengeCurrencyConverter.api.ExchangeRateService;
import tmmscode.challengeCurrencyConverter.enums.Currencies;
import tmmscode.challengeCurrencyConverter.models.ExchangeRateDTO;

public class ExchangeCalc {
    ExchangeRateService exchangeAPI;

    public ExchangeCalc() {
        try {
            this.exchangeAPI = new ExchangeRateService();
        } catch (Exception e) {
            System.out.println("Erro ao instanciar a calculadora de valores, verificar: " + e);
        }

    }

    public void customConversion (String baseCurrency, String currencyToConvert, double value) {
        Currencies baseCoin = Currencies.getIsoObject(baseCurrency);
        Currencies convertTo = Currencies.getIsoObject(currencyToConvert);

        if (baseCoin != null || convertTo != null) {
            ExchangeRateDTO exchangeRates = exchangeAPI.getUpdatedExchangeRates(baseCurrency);
            double conversionRate = exchangeRates.conversion_rates().get(currencyToConvert.toUpperCase());
            double result = value * conversionRate;

            System.out.printf("A taxa de conversão atual de %s pra %s está: " + conversionRate + "\n", baseCoin.name(), convertTo.name());
            System.out.printf("O valor convertido é: %.2f %s", result, convertTo.getCurrencyName() + "\n");

            LogCreator.addToLogList(baseCoin.name(), convertTo.name(), conversionRate, value);

        } else {
            System.out.println("Uma das ISOs não constam na base de conversões suportadas, tente novamente");
        }
    }
}
