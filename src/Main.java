void main() {

    double[][] rates = { //0: USD 1: EUR 2: GBP 3: JPY
            {1, 0.92, 0.7813, 150},
            {1.087, 1, 0.86, 163},
            {1.28, 1.1628, 1, 191},
            {0.00666666, 0.006134969, 0.00523560209, 1}
    };
    String[] currencies = {"USD", "EUR", "GBP", "JPY"};
    double currentRateProduct;
    int[] bestCycle = findBestTriangularArbitrage(rates);
    double bestRateProduct = calculateCycleProduct(rates, bestCycle);
    int checksedCycles = 0;



    if (bestRateProduct > 1) {
        System.out.println("cycles checked: " + checksedCycles);
        System.out.println("Arbitrage detected! " + bestRateProduct);
        for (int i = 0; i < bestCycle.length; i++){
            System.out.print(currencies[bestCycle[i]]);
            if (i == bestCycle.length - 1){
                System.out.println(" ");
            } else {
                System.out.print(" --> ");
            }
        }
    } else if (bestRateProduct == 1) {
        System.out.println("No arbitrage detected!" + bestRateProduct);
    } else {
        System.out.println("No arbitrage detected!" + bestRateProduct);
    }

    if (bestRateProduct > 1) {
        System.out.println("Percentage: " + (bestRateProduct - 1) * 100 + "%");
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

int[] findBestTriangularArbitrage(double[][] rates) {
    double currentRateProduct = 1;
    int checkedCycles = 0;
    double bestRateProduct = 0;
    int[] bestCycle = null;

    for (int i = 0; i < rates.length; i++) {
        for (int j = 0; j < rates.length; j++){
            if (i == j || i > j) {
                continue;
            }
            for (int k = 0; k < rates.length; k++){
                if (i == k || j == k || i > k) {
                    continue;
                }
                int [] cycle = {i, j, k, i};

                currentRateProduct = calculateCycleProduct(rates, cycle);

                checkedCycles++;

                if (currentRateProduct > bestRateProduct){
                    bestRateProduct = currentRateProduct;
                    bestCycle = cycle;
                }
            }
        }
    }
    return bestCycle;
}

