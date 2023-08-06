package DZ4;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();

        Customer customer1 = new Customer("Будко Сергей Владимирович", 31, "+7-904-834-52-23");
        Customer customer2 = new Customer("Зимкина Мария Владимеровна", 26, "+7-914-823-12-53");
        shop.addCustomer(customer1);
        shop.addCustomer(customer2);

        Product product1 = new Product("Item 1", 10.0);
        Product product2 = new Product("Item 2", 20.0);
        Product product3 = new Product("Item 3", 15.0);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        try {
            shop.makePurchase(customer1, product1, 2);
            shop.makePurchase(customer2, product2, 1);
            shop.makePurchase(customer1, product3, 3);
        } catch (CustomerException | ProductException | AmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        shop.printOrders();
    }
}

