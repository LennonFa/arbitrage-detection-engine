void main() {
    double USD2EUR = 0.92;
    double EUR2GBP = 0.86;
    double GBP2USD = 1.28;



    double capitalUSD = 100;
    double capitalEUR = capitalUSD * USD2EUR;
    double capitalGBP = capitalEUR * EUR2GBP;
    double finalUSD =  capitalGBP * GBP2USD;

    System.out.println("started with: " + capitalUSD + " USD");

    System.out.println("Convert USD to EUR: " + capitalEUR + " EUR");
    System.out.println("Convert EUR to GBP: " + capitalGBP + " GBP");
    System.out.println("Convert GBP to USD: " + finalUSD + " USD");

    System.out.println("Ended with: " + finalUSD + " USD");

    System.out.println("USD: " + capitalUSD + "    " + "EUR: " + capitalEUR + "    " + "GBP:" + capitalGBP);
}

