void main() {

    double[][] rates = { //1:USD 2:EUR 3:GBP
            {1,0.92,0.7813},
            {1.087,1,0.86},
            {1.28,1.1628,1}
    };

    double exchangeRateProduct = calculateCycleProduct(rates);

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

