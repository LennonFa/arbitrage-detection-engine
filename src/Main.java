void main() {

    double[][] rates = { //0: USD 1: EUR 2: GBP
            {1,0.92,0.7813},
            {1.087,1,0.86},
            {1.28,1.1628,1}
    };
    String[] currencies = {"USD", "EUR", "GBP"};
    double[] cycle = { rates[0][1],rates[1][2],rates[2][0] };

    double exchangeRateProduct = calculateCycleProduct(cycle);

    if (exchangeRateProduct > 1) {
        System.out.println("Arbitrage detected! " + exchangeRateProduct);
    } else if (exchangeRateProduct == 1) {
        System.out.println("No arbitrage detected!" + exchangeRateProduct);
    } else {
        System.out.println("No arbitrage detected!" + exchangeRateProduct);
    }

    if (exchangeRateProduct > 1) {
        System.out.println("Percentage: " + (exchangeRateProduct-1)*100 + "%");
    } else {
        System.out.println("no arbitrage opportunity");
    }
}

double calculateCycleProduct (double[] rates) {
    double product = 1.0;
    for (double rate : rates){
        product *= rate;
    }
    return product;
}

