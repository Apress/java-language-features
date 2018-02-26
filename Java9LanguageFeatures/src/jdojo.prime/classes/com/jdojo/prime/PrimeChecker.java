// PrimeChecker.java
package com.jdojo.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.stream.Collectors;

public interface PrimeChecker {
    boolean isPrime(long n);

    static PrimeChecker newInstance() {
        // Return the default service provider
        String defaultSP = "com.jdojo.prime.impl.GenericPrimeChecker";
        return newInstance(defaultSP);
    }

    static PrimeChecker newInstance(String providerName) {
        Optional<Provider<PrimeChecker>> optional
                = ServiceLoader.load(PrimeChecker.class)
                        .stream()
                        .filter((Provider p) -> p.type().getName().equals(providerName))
                        .findFirst();

        PrimeChecker checker = null;
        if (optional.isPresent()) {
            Provider<PrimeChecker> provider = optional.get();
            checker = provider.get();
        }

        return checker;
    }

    static List<PrimeChecker> providers() {
        List<PrimeChecker> providers = new ArrayList<>();
        ServiceLoader<PrimeChecker> loader = ServiceLoader.load(PrimeChecker.class);

        for (PrimeChecker checker : loader) {
            providers.add(checker);
        }
        return providers;
    }

    static List<String> providerNames() {
        List<String> providers
                = ServiceLoader.load(PrimeChecker.class)
                        .stream()
                        .map((Provider p) -> p.type().getName())
                        .collect(Collectors.toList());
        return providers;
    }
}
