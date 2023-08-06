package DZ4;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

    public Shop() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // Добавление покупателя в магазин
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Добавление товара в магазин
    public void addProduct(Product product) {
        products.add(product);
    }

    // Создание заказа и добавление его в магазин
    public void makePurchase(Customer customer, Product product, int quantity) throws CustomerException, ProductException, AmountException {
        if (!customers.contains(customer)) {
            throw new CustomerException("Invalid customer: " + customer.getFullName());
        }

        if (!products.contains(product)) {
            throw new ProductException("Invalid product: " + product.getName());
        }

        if (quantity <= 0 || quantity > 100) {
            throw new AmountException("Invalid quantity: " + quantity);
        }


        Order order = new Order(customer, product, quantity);
        orders.add(order);
    }

    // Вывод информации о каждом заказе
    public void printOrders() {
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            Product product = order.getProduct();
            int quantity = order.getQuantity();
            double totalPrice = order.getTotalPrice();

            System.out.println("Order Information:");
            System.out.println("Customer: " + customer.getFullName());
            System.out.println("Product: " + product.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: $" + totalPrice);
            System.out.println("--------------------");
        }
    }

}
