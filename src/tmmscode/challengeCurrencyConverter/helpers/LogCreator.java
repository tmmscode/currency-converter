package tmmscode.challengeCurrencyConverter.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tmmscode.challengeCurrencyConverter.models.LogRegistry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LogCreator {
    private String outputFilePath;
    public static List<LogRegistry> LogList;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public LogCreator () {
        LogCreator.LogList = new ArrayList<>();

        Properties env = new Properties();
        try (FileInputStream inputFile = new FileInputStream("src/tmmscode/challengeCurrencyConverter/resources/config.properties")){
            env.load(inputFile);
            this.outputFilePath = env.getProperty("LOG_OUTPUT_DIRECTORY");
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public static void addToLogList(String baseISO, String convertISO, double convertionRate , double convertionValue) {
        LogRegistry newRegistry = new LogRegistry(baseISO, convertISO, convertionRate, convertionValue);
        LogCreator.LogList.add(newRegistry);
    }

    public void generateLogFile (String filename) {
        try {
            String fileNameTrim = filename.trim().replace(" ","_") + ".json";
            String saveFile = this.getOutputFilePath() + fileNameTrim;
            File listOfRequests = new File(saveFile);
            FileWriter editorTexto = new FileWriter(listOfRequests);

            editorTexto.write(this.gson.toJson(LogCreator.LogList));
            editorTexto.close();

            System.out.println("Seu arquivo foi gerado no caminho: " + saveFile);
        } catch (IOException e) {
            System.out.println("A lista não pode ser gerada: " + e);
        }
    }

    public static void showLogListToString() {
        System.out.println(LogList);
    }
    }
