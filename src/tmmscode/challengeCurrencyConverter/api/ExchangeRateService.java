package tmmscode.challengeCurrencyConverter.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tmmscode.challengeCurrencyConverter.models.ExchangeRateDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExchangeRateService {
    private String address;
    private APIRequest httpRequester = new APIRequest();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ExchangeRateService() throws FileNotFoundException {
        Properties env = new Properties();
        try (FileInputStream inputFile = new FileInputStream("src/tmmscode/challengeCurrencyConverter/resources/config.properties")){
            env.load(inputFile);
            String apiKey = env.getProperty("MY_API_KEY");
            this.address = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

    // =================================================
    // =============== Internal methods ================

    private ExchangeRateDTO getObjectFromResponseJSON(String json) {
        try {
            return gson.fromJson(json, ExchangeRateDTO.class);
        } catch (Exception e) {
            System.out.println("Não foi possível converter o JSON: " + e);
            return null;
        }
    }

    private ExchangeRateDTO getObjectFromHttpRequest(String address) {
        String jsonToParse = httpRequester.getJsonResponseFromHttpRequest(address);
        ExchangeRateDTO convertedObject = this.getObjectFromResponseJSON(jsonToParse);
        return convertedObject;
    }

    // =================================================
    // ================ Public methods =================

    public ExchangeRateDTO getUpdatedExchangeRates(String currencyBase) {
        String selectedCurrencyURI = this.address + currencyBase;
        ExchangeRateDTO responseObject = this.getObjectFromHttpRequest(selectedCurrencyURI);
        return responseObject;
    }

}
