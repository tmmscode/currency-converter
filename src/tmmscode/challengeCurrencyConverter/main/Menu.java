package tmmscode.challengeCurrencyConverter.main;

import tmmscode.challengeCurrencyConverter.enums.Currencies;
import tmmscode.challengeCurrencyConverter.helpers.ExchangeCalc;
import tmmscode.challengeCurrencyConverter.helpers.LogCreator;
import tmmscode.challengeCurrencyConverter.helpers.MenuPrinter;

import java.util.Scanner;

public class Menu {
    Scanner keyboardInput = new Scanner(System.in);
    LogCreator logCreator = new LogCreator();

    public void startMenu() {

        MenuPrinter.showTitle();

        while (true){
            MenuPrinter.showMainMenuOptions();

            int validOption;
            String selectedOption = keyboardInput.nextLine();
            while (!isInt(selectedOption)){
                System.out.println("Opção invalida");
                selectedOption = keyboardInput.nextLine();
            }
            validOption = Integer.parseInt(selectedOption);


            switch (validOption) {
                case 1 : exchangeMenu();
                    break;
                case 2 : logMenu();
                    break;
                case 3 :
                    System.out.println("Aplicação feita por Thiago de Melo Marçal da Silva, como desafio da formação \"Oracle Next Education\" (Especialização Back-End)");
                    System.out.println("https://github.com/tmmscode/currency-converter");
                    System.out.println("Obrigado por usar esta aplicação! ♥");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    private void exchangeMenu () {
        ExchangeCalc calculator = new ExchangeCalc();
        boolean exchangeMenuActive = true;

        while (exchangeMenuActive) {
            MenuPrinter.showExchangeOptions();

            String valueToConvert;
            int validOption;
            String selectedOption = keyboardInput.nextLine();
            while (!isInt(selectedOption)){
                System.out.println("Opção invalida");
                selectedOption = keyboardInput.nextLine();
            }
            validOption = Integer.parseInt(selectedOption);
            switch (validOption) {
                case 1 :
                    keyboardInput.nextLine();
                    System.out.println("=== Convertendo USD para BRL ===");
                    System.out.println("Digite o valor pra converter: ");
                    valueToConvert = keyboardInput.nextLine();

                    while(!isDouble(valueToConvert)) {
                        System.out.println("O valor precisa ser em números e a fração separada por ponto \".\" (Exemplo: 210.2)");
                    valueToConvert =  keyboardInput.nextLine();
                    }

                    calculator.customConversion("USD", "BRL", Double.parseDouble(valueToConvert));
                    MenuPrinter.showEndLine();
                    exchangeMenuActive = continueConfirmation();
                    break;
                case 2 :
                    System.out.println("=== Convertendo BRL para USD ===");
                    System.out.println("Digite o valor pra converter: ");
                    valueToConvert = keyboardInput.nextLine();

                    while(!isDouble(valueToConvert)) {
                        System.out.println("O valor precisa ser em números e a fração separada por ponto \".\" (Exemplo: 210.2)");
                        valueToConvert =  keyboardInput.nextLine();
                    }

                    calculator.customConversion("BRL", "USD", Double.parseDouble(valueToConvert));
                    MenuPrinter.showEndLine();
                    exchangeMenuActive = continueConfirmation();
                    break;
                case 3 :
                    System.out.println("=== Convertendo ARS para USD ===");
                    System.out.println("Digite o valor pra converter: ");
                    valueToConvert = keyboardInput.nextLine();

                    while(!isDouble(valueToConvert)) {
                        System.out.println("O valor precisa ser em números e a fração separada por ponto \".\" (Exemplo: 210.2)");
                        valueToConvert =  keyboardInput.nextLine();
                    }

                    calculator.customConversion("ARS", "USD", Double.parseDouble(valueToConvert));
                    MenuPrinter.showEndLine();
                    exchangeMenuActive = continueConfirmation();
                    break;
                case 4 :
                    System.out.println("=== Convertendo USD para ARS ===");
                    System.out.println("Digite o valor pra converter: ");
                    valueToConvert = keyboardInput.nextLine();

                    while(!isDouble(valueToConvert)) {
                        System.out.println("O valor precisa ser em números e a fração separada por ponto \".\" (Exemplo: 210.2)");
                        valueToConvert =  keyboardInput.nextLine();
                    }

                    calculator.customConversion("USD", "ARS", Double.parseDouble(valueToConvert));
                    MenuPrinter.showEndLine();
                    exchangeMenuActive = continueConfirmation();
                    break;
                case 5 :
                    keyboardInput.nextLine();
                    MenuPrinter.showIsoHints();
                    System.out.println("Digite o código da moeda base: ");
                    String iso1 = keyboardInput.nextLine();
                    Currencies iso1Object = Currencies.getIsoObject(iso1);

                    while (iso1Object == null) {
                        System.out.println("Esse código não consta na lista de conversões, tente novamente");
                        iso1 = keyboardInput.nextLine();
                        iso1Object = Currencies.getIsoObject(iso1);
                    }
                    System.out.println("Moeda base selecionada: " + iso1Object.name() + " (" +iso1Object.getCurrencyName() + ")");

                    System.out.println("Digite a moeda para conversão: ");
                    String iso2 = keyboardInput.nextLine();

                    Currencies iso2Object = Currencies.getIsoObject(iso2);

                    while (iso2Object == null) {
                        System.out.println("Esse código não consta na lista de conversões, tente novamente");
                        iso2 = keyboardInput.nextLine();
                        iso2Object = Currencies.getIsoObject(iso2);
                    }
                    System.out.println("Moeda para conversão selecionada: " + iso2Object.name() + " (" +iso2Object.getCurrencyName() + ")");

                    System.out.println("Digite o valor pra converter: ");
                    valueToConvert = keyboardInput.nextLine();

                    while(!isDouble(valueToConvert)) {
                        System.out.println("O valor precisa ser em números e a fração separada por ponto \".\" (Exemplo: 210.2)");
                        valueToConvert =  keyboardInput.nextLine();
                    }

                    calculator.customConversion(iso1, iso2, Double.parseDouble(valueToConvert));
                    MenuPrinter.showEndLine();
                    exchangeMenuActive = continueConfirmation();
                    break;
                case 0 :
                    exchangeMenuActive = false;
                    System.out.println("Voltando para o menu principal...");
                    MenuPrinter.showEndLine();
                    keyboardInput.nextLine();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            if (!exchangeMenuActive) {
                break;
            }
        }
    }
    private void logMenu () {
        boolean logMenuActive = true;

        while (logMenuActive) {
            MenuPrinter.showLogOptions();

            int validOption;
            String selectedOption = keyboardInput.nextLine();
            while (!isInt(selectedOption)){
                System.out.println("Opção invalida");
                selectedOption = keyboardInput.nextLine();
            }
            validOption = Integer.parseInt(selectedOption);

            switch (validOption){
                case 1 :
                    if(LogCreator.LogList.isEmpty()) {
                        System.out.println("Não foram realizadas consultas nessa sessão");
                    } else {
                        LogCreator.showLogListToString();
                    }
                    break;
                case 2 :
                    if(LogCreator.LogList.isEmpty()) {
                        System.out.println("Não foram realizadas consultas nessa sessão");
                    } else {
                        keyboardInput.nextLine();
                        System.out.println("Criando arquivo de consultas...");
                        System.out.println("Digite o nome que deseja salvar o arquivo (O arquivo será salvo no diretório informado nas configurações do aplicativo):");
                        String filename = keyboardInput.nextLine();

                        while (filename.isBlank()){
                            System.out.println("Informe o nome do arquivo");
                            filename = keyboardInput.nextLine();
                        }

                        logCreator.generateLogFile(filename);
                    }
                    break;
                case 3 :
                    logMenuActive = false;
                    System.out.println("Voltando para o menu principal...");
                    MenuPrinter.showEndLine();
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
            if (!logMenuActive){
                break;
            }
        }
    }

    private boolean continueConfirmation () {
        String confirmation ="";

        while (!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")) {
            System.out.println("Gostaria de continuar (Y) ou voltar (N)?");
            confirmation = keyboardInput.nextLine();
        }

        if (confirmation.equalsIgnoreCase("Y")) {
            return true;
        } else if (confirmation.equalsIgnoreCase("N")) {
            return false;
        }
        return true;
    }
    private boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
