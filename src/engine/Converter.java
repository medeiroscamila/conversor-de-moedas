package engine;

public class Converter {
    public static double convert(double amount, double fromRate, double toRate) {
        return amount * (toRate / fromRate);
    }
}
