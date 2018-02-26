// module-info.java
module jdojo.prime.faster {
    requires jdojo.prime;

    provides com.jdojo.prime.PrimeChecker
        with com.jdojo.prime.faster.FasterPrimeChecker;
}
