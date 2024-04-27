package tmmscode.challengeCurrencyConverter.helpers;

import tmmscode.challengeCurrencyConverter.enums.Currencies;

public class MenuPrinter {
    public static void showTitle () {
        System.out.print("""
            =========================================================================
            |                          Conversor de Moedas                          |
            =========================================================================
            """);
    }
    public static void showMainMenuOptions () {
        System.out.print("""
            ♦♦♦♦♦ MENU PRINCIPAL ♦♦♦♦♦
            Escolha uma opção:
            
            1 - Conversão entre moedas
            2 - Log de consultas
            3 - Sair
            """);
    }
    public static void showExchangeOptions () {
        System.out.print("""
            ==========================================================================
            Conversões rápidas:
            
            1 - Converter Dólar => Real
            2 - Converter Real => Dólar
            3 - Converter Peso Argentino => Dólar
            4 - Converter Dólar => Peso Argentino
            -------------------
            5 - ♦ Converter entre moedas específicas ♦
            
            0 - Voltar para o menu principal
            """);
    }
    public static void showLogOptions () {
        System.out.print("""
            =========================================================================
            Log de consultas:
            
            1 - Visualizar consultas dessa sessão
            2 - Criar arquivo JSON com as consultas dessa sessão
            3 - Sair
            """);
    }
    public static void showIsoHints() {
        System.out.printf("""
            ==========================================================================
            Você pode digitar o código da moeda que desejar no formato "ISO 4217"
            As mais comuns são:\n
            """);
        Currencies.getIsoInfo("USD");
        Currencies.getIsoInfo("BRL");
        Currencies.getIsoInfo("ARS");
        Currencies.getIsoInfo("BOB");
        Currencies.getIsoInfo("CLP");
        Currencies.getIsoInfo("COP");
    }
    public static void showEndLine() {
        System.out.println("=========================================================================");
    }
}
