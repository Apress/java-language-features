// module-info.java
module jdojo.prime.probable {
    requires jdojo.prime;

    provides com.jdojo.prime.PrimeChecker
        with com.jdojo.prime.probable.ProbablePrimeChecker;
}
