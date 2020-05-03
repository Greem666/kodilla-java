package com.kodilla.good.patterns.challenges.productOrderServiceClasses;

import com.kodilla.good.patterns.challenges.interfaces.PurchaseSelector;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ProductPurchaseSelector implements PurchaseSelector {
    private Scanner scanner = new Scanner(System.in);
    private String chosenGoodsName = null;

    @Override
    public void listAndSelect(AvailableGoods availableGoods) {
        System.out.println("What would you like to buy?");

        int i = 1;
        for (Map.Entry<String, Double> goods: availableGoods.getGoodsPriceMapping().entrySet()) {
            System.out.println(String.format("\t%d) %s: %.2f", i, goods.getKey(), goods.getValue()));
            i++;
        }

        int listSize = availableGoods.getGoodsPriceMapping().keySet().size();

        while(true) {
            System.out.print("Your selection: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                if (choice > 0 && choice < listSize) {
                    this.chosenGoodsName = new ArrayList<>(
                            availableGoods.getGoodsPriceMapping().keySet()
                    ).get(choice - 1);
                    break;
                } else {
                    System.out.println(String.format("Incorrect selection. Please enter number in range %d - %d, or enter 'q' to exit.", 1, listSize));
                }

                scanner.nextLine();
            } else {
                if (scanner.hasNextLine()) {
                    if (scanner.nextLine().equals("q")) {
                        System.out.println("Exiting without selection...");
                        break;
                    } else {
                        System.out.println(String.format("Incorrect selection. Please enter number in range %d - %d, or enter 'q' to exit.", 1, listSize));
                    }
                    scanner.nextLine();
                }
            }
        }
    }

    public String getChosenGoodsName() {
        return chosenGoodsName;
    }
}
