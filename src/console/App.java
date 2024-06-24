package console;

import engine.Converter;
import engine.RateAPI;
import utils.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> rates = new HashMap<>();

        try {
            rates = RateAPI.getRates();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao obter taxas de câmbio: " + e.getMessage());
            return;
        }

        System.out.println("\n---------------------------------------------");
        System.out.println("\nSeja Bem-vindo (a) ao Conversor de Moedas  :]");
        System.out.println("\n---------------------------------------------");


        while (true) {
            System.out.println("\nOpções de conversão:");
            System.out.println("1. Dólar Americano -> Real Brasileiro");
            System.out.println("2. Dólar Americano -> Euro");
            System.out.println("3. Dólar Americano -> Peso Argentino");
            System.out.println("4. Dólar Americano -> Boliviano Boliviano");
            System.out.println("5. Dólar Americano -> Peso Chileno");
            System.out.println("6. Real Brasileiro -> Dólar Americano");
            System.out.println("7. Euro -> Dólar Americano");
            System.out.println("8. Peso Argentino -> Dólar Americano");
            System.out.println("9. Boliviano Boliviano -> Dólar Americano");
            System.out.println("10. Peso Chileno -> Dólar Americano");
            System.out.println("11. Sair");

            System.out.println("\nDigite a opção desejada:");
            int option = scanner.nextInt();

            if (option == 11) {
                System.out.println("Obrigado por usar o Conversor de Moedas. Até mais!");
                break;
            }

            if (option < 1 || option > 11) {
                System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 11.");
                continue;
            }

            System.out.println("\nDigite o valor a ser convertido:");
            double amount = scanner.nextDouble();
            double result = 0;
            String fromCurrency = "";
            String toCurrency = "";

            switch (option) {
                case 1:
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 2:
                    fromCurrency = "USD";
                    toCurrency = "EUR";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 3:
                    fromCurrency = "USD";
                    toCurrency = "ARS";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 4:
                    fromCurrency = "USD";
                    toCurrency = "BOB";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 5:
                    fromCurrency = "USD";
                    toCurrency = "CLP";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 6:
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 7:
                    fromCurrency = "EUR";
                    toCurrency = "USD";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 8:
                    fromCurrency = "ARS";
                    toCurrency = "USD";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 9:
                    fromCurrency = "BOB";
                    toCurrency = "USD";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                case 10:
                    fromCurrency = "CLP";
                    toCurrency = "USD";
                    result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
                    break;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }

            System.out.println("Resultado: " + result);
            Logger.logConversion(amount, result, fromCurrency, toCurrency);
        }

        scanner.close();
    }
}
