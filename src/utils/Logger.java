package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String FILENAME = "src/historico/historico.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void logConversion(double originalAmount, double convertedAmount, String fromCurrency, String toCurrency) {
        try (FileWriter fw = new FileWriter(FILENAME, true);
             PrintWriter pw = new PrintWriter(fw)) {

            LocalDateTime dateTime = LocalDateTime.now();
            String formattedDateTime = dateTime.format(formatter);

            pw.println("Data e Hora: " + formattedDateTime);
            pw.println("Moeda de Origem: " + fromCurrency);
            pw.println("Valor de Origem: " + originalAmount);
            pw.println("Moeda de Destino: " + toCurrency);
            pw.println("Valor de Destino: " + convertedAmount);
            pw.println();

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de histórico: " + e.getMessage());
        }
    }
}

