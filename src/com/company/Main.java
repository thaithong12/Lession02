package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) {
	    //
        Scanner sc = new Scanner(System.in);
        Boolean check = true;
        String input;
        Product p;
        int id;
        Double price;
        int quantity;
        Cart cart = new Cart();
        while (check) {
            System.out.println("MENU");
            System.out.println("====================================");
            System.out.println("1. Enter Product");
            System.out.println("2. Exit");
            System.out.println("Pls enter your choose: ?");
            input = sc.next();
            switch (input) {
                case "1":
                    //1. ENTER INFO PRODUCT
                    System.out.println("Enter InFo Product");
                    System.out.println("1. ID: ");
                    id = sc.nextInt();
                    System.out.println("2. PRICE: ");
                    price = sc.nextDouble();
                    System.out.println("1. QUANTITY: ");
                    quantity = sc.nextInt();
                    p = new Product(id, price, quantity);

                    //2. Add Cart
                    // Check exist
                    var checkExist = isExistProductInCart(id, cart);

                    if (!checkExist) {
                        var listProduct = cart.getProducts();
                        listProduct.add(p);

                        cart.setProducts(listProduct);
                    } else {
                        int finalId = id;

                        var product = cart.getProducts().stream()
                                .filter(i -> i.getProductId() == finalId)
                                .findFirst()
                                .orElse(null);

                        product.setQuantity(product.getQuantity() + quantity);
                    }
                    //3. Update Cart
                    var listProduct = cart.getProducts();
                    AtomicReference<Double> totalPrice = new AtomicReference<>((double) 0);
                    listProduct.forEach(i -> totalPrice.updateAndGet(v -> new Double((double) (v + i.getQuantity() * i.getPrice()))));

                    cart.setTotalPrice(totalPrice.get());
                    //4. Print data
                    System.out.println(cart);

                    break;
                case "2":
                    check = false;
                    break;
                default:
                    break;
            }

        }
    }

    // INPUT : MSP
    // OUTPUT: NEU TON TAI ROI TRA VE TRUE, NGUOWC LAI FALSE
    // DKC: Cart
    private static boolean isExistProductInCart(int id, Cart cart) {
        if (cart.getProducts().isEmpty()) {
            return false;
        } else {
            var data = cart.getProducts();
            var existObj = data.stream()
                    .filter(i -> i.getProductId() == id)
                    .findFirst()
                    .orElse(null);
            if (Objects.isNull(existObj)) {
                return false;
            } else {
                return true;
            }
        }
    }
}
