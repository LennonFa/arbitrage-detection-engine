void main() {

    double[][] rates = { //0: USD 1: EUR 2: GBP 3: JPY
            {1,0.92,0.7813,150},
            {1.087,1,0.86,163},
            {1.28,1.1628,1,191},
            {0.00666666,0.006134969,0.00523560209}
    };
    String[] currencies = {"USD", "EUR", "GBP", "JPY"};
    double bestRateProduct = 0;
    double currentRateProduct;
    int[] bestCycle = {0,1};

    for (int i = 0; i < currencies.length; i++){
        for (int j = 0; j < currencies.length; j++){
            if (i == j || i > j){
                continue;
            }
            for (int k = 0; k < currencies.length; k++){
                if (i == k || j == k || i > k){
                    continue;
                }
                int[] cycle = {i ,j ,k ,i};

                currentRateProduct = calculateCycleProduct(rates, cycle);

                if (currentRateProduct > bestRateProduct){
                    bestRateProduct = currentRateProduct;
                    bestCycle = cycle;
                }
                for (int f : cycle){
                    System.out.print(f);
                }
                System.out.println(" ");

            }
        }
    }


    if (bestRateProduct > 1) {
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

