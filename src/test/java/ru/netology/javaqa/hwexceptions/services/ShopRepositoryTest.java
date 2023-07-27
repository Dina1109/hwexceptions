package ru.netology.javaqa.hwexceptions.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveWhenProductExist() { // удаление существующего продукта
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(11, "компьютер", 85_000);
        Product product2 = new Product(22, "планшет", 8_000);
        Product product3 = new Product(33, "телефон", 35_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(33);
        Product[] actual = repository.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldRemoveWhenProductNotExist() { // удаление не существующего продукта
//        ShopRepository repository = new ShopRepository();
//        Product product1 = new Product(11, "компьютер", 85_000);
//        Product product2 = new Product(22, "планшет", 8_000);
//        Product product3 = new Product(33, "телефон", 35_000);
//
//        repository.add(product1);
//        repository.add(product2);
//        repository.add(product3);
//        repository.remove(133);
//        Product[] actual = repository.findAll();
//        Product[] expected = {product1, product2, product3};
//
//        Assertions.assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveWhenProductNotExist2() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(11, "компьютер", 85_000);
        Product product2 = new Product(22, "планшет", 8_000);
        Product product3 = new Product(33, "телефон", 35_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(123);
                });
    }
}
