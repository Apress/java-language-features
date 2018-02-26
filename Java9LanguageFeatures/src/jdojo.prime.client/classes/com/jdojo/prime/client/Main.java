// Main.java
package com.jdojo.prime.client;

import com.jdojo.prime.PrimeChecker;

public class Main {
    public static void main(String[] args) {
        // Numbers to be checked for prime
        long[] numbers = {3, 4, 121, 977};

        // Use the default service provider
        PrimeChecker checker = PrimeChecker.newInstance();
        System.out.println("Using default service provider:");
        checkPrimes(checker, numbers);

        // Try faster prime service provider
        String fasterProviderName = "com.jdojo.prime.faster.FasterPrimeChecker";
        PrimeChecker fasterChecker = PrimeChecker.newInstance(fasterProviderName);
        if (fasterChecker == null) {
            System.out.println("\nFaster service provider is not available.");
        } else {
            System.out.println("\nUsing faster service provider:");
            checkPrimes(fasterChecker, numbers);
        }

        // Try probable prime service provider
        String probableProviderName = "com.jdojo.prime.probable.ProbablePrimeChecker";
        PrimeChecker probableChecker = PrimeChecker.newInstance(probableProviderName);
        if (probableChecker == null) {
            System.out.println("\nProbable service provider is not available.");
        } else {
            System.out.println("\nUsing probable service provider:");
            checkPrimes(probableChecker, numbers);
        }
    }

    public static void checkPrimes(PrimeChecker checker, long... numbers) {
        for (long n : numbers) {
            if (checker.isPrime(n)) {
                System.out.printf("%d is a prime.%n", n);
            } else {
                System.out.printf("%d is not a prime.%n", n);
            }
        }
    }
}
