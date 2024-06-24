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
        HashMap<String, Double> rates;

        try {
            rates = RateAPI.getRates();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao obter taxas de câmbio: " + e.getMessage());
            return;
        }

        System.out.println("\n---------------------------------------------");
        System.out.println("\nSeja Bem-vindo (a) ao Conversor de Moedas  :)");
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
            double result;
            String fromCurrency;
            String toCurrency = switch (option) {
                case 1 -> {
                    fromCurrency = "USD";
                    yield "BRL";
                }
                case 2 -> {
                    fromCurrency = "USD";
                    yield "EUR";
                }
                case 3 -> {
                    fromCurrency = "USD";
                    yield "ARS";
                }
                case 4 -> {
                    fromCurrency = "USD";
                    yield "BOB";
                }
                case 5 -> {
                    fromCurrency = "USD";
                    yield "CLP";
                }
                case 6 -> {
                    fromCurrency = "BRL";
                    yield "USD";
                }
                case 7 -> {
                    fromCurrency = "EUR";
                    yield "USD";
                }
                case 8 -> {
                    fromCurrency = "ARS";
                    yield "USD";
                }
                case 9 -> {
                    fromCurrency = "BOB";
                    yield "USD";
                }
                case 10 -> {
                    fromCurrency = "CLP";
                    yield "USD";
                }
                default -> throw new IllegalStateException("Unexpected value: " + option);
            };

            result = Converter.convert(amount, rates.get(fromCurrency), rates.get(toCurrency));
            System.out.println("Resultado: " + result);
            Logger.logConversion(amount, result, fromCurrency, toCurrency);
        }

        scanner.close();
    }
}
