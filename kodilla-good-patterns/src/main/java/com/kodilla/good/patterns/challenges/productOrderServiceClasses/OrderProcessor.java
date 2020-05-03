package com.kodilla.good.patterns.challenges.productOrderServiceClasses;

public class OrderProcessor {
    private UserGreeter userGreeter;
    private ProductPurchaseReceiver productPurchaseReceiver;
    private ProductPurchaseInformer productPurchaseInformer;
    private ProductPurchaseRepository productPurchaseSaver;

    public OrderProcessor(UserGreeter userGreeter,
                          ProductPurchaseReceiver productPurchaseReceiver,
                          ProductPurchaseInformer productPurchaseInformer,
                          ProductPurchaseRepository productPurchaseSaver) {
        this.userGreeter = userGreeter;
        this.productPurchaseReceiver = productPurchaseReceiver;
        this.productPurchaseInformer = productPurchaseInformer;
        this.productPurchaseSaver = productPurchaseSaver;
    }

    public void process() {
        userGreeter.greet();

        PurchasedProduct purchasedProduct = productPurchaseReceiver.receive();
        boolean purchaseOccurred = (purchasedProduct != null);

        productPurchaseInformer.inform(purchasedProduct);

        productPurchaseSaver.save(purchasedProduct);
    }
}
