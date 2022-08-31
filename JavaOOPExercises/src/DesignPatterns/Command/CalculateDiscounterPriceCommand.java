package DesignPatterns.Command;

public class CalculateDiscounterPriceCommand implements Command{

    private final Product product;
    private final int discount;

    public CalculateDiscounterPriceCommand(Product product, int discount) {
        this.product = product;
        this.discount = discount;
    }

    @Override
    public String executeAction() {
        int oldPrice = product.getPrice();

        product.setPrice(oldPrice - (int)(oldPrice * (discount / 100.00)));

        int newPrice = product.getPrice();
        return String.format("Product price discounted from %d to %d", oldPrice, newPrice);
    }
}
