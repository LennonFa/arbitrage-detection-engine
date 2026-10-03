void main() {

    double[][] rates = { //0: USD 1: EUR 2: GBP
            {1,0.92,0.7813},
            {1.087,1,0.86},
            {1.28,1.1628,1}
    };
    String[] currencies = {"USD", "EUR", "GBP"};
    int[] cycle = {0,1,2,0};

    double exchangeRateProduct = calculateCycleProduct(rates, cycle);

    if (exchangeRateProduct > 1) {
        System.out.println("Arbitrage detected! " + exchangeRateProduct);
        for (int i : cycle){
            System.out.print(currencies[i]);
            if (i >= cycle.length-2){
                System.out.println(" ");
                break;
            } else {
                System.out.print("-->");
            }
        }
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

double calculateCycleProduct (double[][] rates, int[] cycle) {
    double product = 1.0;
    for (int i = 0; i < cycle.length-1; i++){
        product *= rates[cycle[i]][cycle[i+1]];
    }
    return product;
}

