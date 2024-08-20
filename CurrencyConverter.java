package javafile;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    
    // Predefined exchange rates (for simplicity)
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    
    static {
        // Exchange rates relative to USD
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("AUD", 1.35);
        // Add more currencies as needed
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Allow the user to choose the base currency and the target currency
        System.out.println("Available currencies: USD, EUR, GBP, INR, JPY, AUD");
        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        
        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.nextLine().toUpperCase();
        
        // Step 2: Take input from the user for the amount they want to convert
        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();
        
        // Step 3: Currency Conversion
        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
        
        // Step 4: Display Result
        if (convertedAmount != -1) {
            System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Invalid currency selection.");
        }
        
        scanner.close();
    }
    
    // Function to convert currency using predefined exchange rates
    private static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double baseRate = exchangeRates.get(baseCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            return amount * (targetRate / baseRate);
        } else {
            return -1; // Error flag for invalid currencies
        }
    }
}
