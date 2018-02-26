// ProbablePrimeChecker.java
package com.jdojo.prime.probable;

import com.jdojo.prime.PrimeChecker;
import java.math.BigInteger;

public interface ProbablePrimeChecker extends PrimeChecker {
    // A provider method
    public static ProbablePrimeChecker provider() {
        int certainty = 1000;
        ProbablePrimeChecker checker = n -> BigInteger.valueOf(n).isProbablePrime(certainty);
        return checker;
    }
}
