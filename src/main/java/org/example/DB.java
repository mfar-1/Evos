package org.example;

import java.util.*;

public interface DB {
    List<Category> CATEGORIES = new ArrayList<>(List.of(
            new Category(1, "Lavash", null),
            new Category(2, "Burger", null),
            new Category(3, "Set", null),
            new Category(4, "Pizza", null),
            new Category(5, "Drinkings/Ichimliklar", null),

            new Category(8, "Big", 1),
            new Category(9, "Small", 1),
            new Category(10, "Middle", 1),

            new Category(11, "Cheese", 2),
            new Category(12, "Big", 2),
            new Category(13, "Small", 2),

            new Category(14, "Middle Cheese", 11),
            new Category(15, "Big Cheese", 11),
            new Category(16, "Small Cheese", 11),

            new Category(17, "Kids", 3),
            new Category(18, "50%", 3),
            new Category(19, "Super 45", 3),

            new Category(20, "Big kids ", 17),
            new Category(21, "Middle kids", 17),
            new Category(22, "Small kids", 17),

            new Category(23, "Big offer ", 18),
            new Category(24, "Middle offer", 18),
            new Category(25, "Small offer", 18),

            new Category(26, " Super Big ", 19),
            new Category(27, " Super Middle", 19),
            new Category(28, "Super Small ", 19),


            new Category(29, "Cheese", 4),
            new Category(30, "Peperoni", 4),
            new Category(31, "Super mix", 4),

            new Category(32, "Big cheese", 23),
            new Category(33, "Middle cheese", 23),
            new Category(34, "Small cheese", 23),

            new Category(35, "Big peperoni", 24),
            new Category(36, "Middle peperoni", 24),
            new Category(37, "Small peperoni", 24),

            new Category(38, "Big super mix", 25),
            new Category(39, "middle super mix", 25),
            new Category(40, "Small super mix", 25),

            new Category(47, "Sugary", 5),
            new Category(48, "Coffee", 5),

            new Category(50, "Coke", 41),
            new Category(51, "Fanta", 41),
            new Category(52, "Mineral water", 41),

            new Category(53, "Simple", 42),
            new Category(54, "Milk", 42),
            new Category(55, "Mix", 42)

    ));

    List<Product> PRODUCTS = new ArrayList<>(List.of(
            new Product(1, "Big beef lavash", 36_000, 8),
            new Product(2, "Big chicken lavash", 34_000, 8),
            new Product(3, "Big mix lavash", 40_000, 8),

            new Product(4, "Middle beef lavash", 30_000, 9),
            new Product(5, "Middle chicken lavash", 26_000, 9),
            new Product(6, "Middle mix lavash", 36_000, 9),

            new Product(7, "Small beef lavash", 26_000, 10),
            new Product(8, "Small chicken lavash", 22_000, 10),
            new Product(9, "Small mix lavash", 32_000, 10),

            new Product(10, "Middle cheese burger", 22_000, 14),
            new Product(11, "Big cheese burger", 26_000, 15),
            new Product(12, "Small cheese burger", 20_000, 16),

            new Product(13, "Big beef burger", 32_000, 12),
            new Product(14, "Big chicken burger", 31_000, 12),
            new Product(15, "Big mix burger", 37_000, 12),

            new Product(16, "Small beef burger", 24_000, 13),
            new Product(17, "Small chicken burger", 20_000, 13),
            new Product(18, "Small mix burger", 30_000, 13),

            new Product(19, "Big beef set kids", 36_000, 20),
            new Product(20, "Big chicken set kids", 34_000, 20),
            new Product(21, "Big mix set kids", 40_000, 20),

            new Product(25, "Middle beef set kids", 30_000, 21),
            new Product(26, "Middle chicken set kids", 26_000, 21),
            new Product(27, "Middle mix set kids", 36_000, 21),

            new Product(28, "Small beef set kids", 26_000, 22),
            new Product(29, "Small chicken set kids", 22_000, 22),
            new Product(30, "Small mix set kids", 32_000, 22),

            new Product(31, "Big beef offer", 36_000, 23),
            new Product(32, "Big chicken offer", 34_000, 23),
            new Product(33, "Big mix offer", 40_000, 23),

            new Product(34, "Middle beef offer", 30_000, 24),
            new Product(35, "Middle chicken offer", 26_000, 24),
            new Product(36, "Middle mix offer", 36_000, 24),

            new Product(37, "Small beef offer", 26_000, 25),
            new Product(38, "Small chicken offer", 22_000, 25),
            new Product(39, "Small mix offer", 32_000, 25),

            new Product(40, "Big beef Super", 45_000, 26),
            new Product(41, "Big chicken Super", 40_000, 26),
            new Product(42, "Big mix Super", 55_000, 27),

            new Product(43, "Middle beef Super", 43_000, 28),
            new Product(44, "Middle chicken Super", 37_000, 28),
            new Product(45, "Middle mix Super", 45_000, 28),

            new Product(46, "Small beef Super", 34_000, 29),
            new Product(47, "Small chicken Super", 32_000, 29),
            new Product(48, "Small mix Super", 36_000, 29),

            new Product(49, "Big cheese pizza", 36_000, 32),
            new Product(50, "Big cheese pizza", 34_000, 32),
            new Product(51, "Big cheese pizza", 40_000, 32),

            new Product(52, "Middle cheese pizza", 30_000, 33),
            new Product(53, "Middle cheese pizza", 26_000, 33),
            new Product(54, "Middle cheese pizza", 36_000, 33),

            new Product(55, "Small cheese pizza", 26_000, 34),
            new Product(56, "Small cheese pizza", 22_000, 34),
            new Product(57, "Small cheese pizza", 32_000, 34),

            new Product(58, "Big peperoni pizza", 36_000, 35),
            new Product(59, "Big peperoni pizza", 34_000, 35),
            new Product(60, "Big peperoni pizza", 40_000, 35),

            new Product(61, "Middle peperoni pizza", 30_000, 36),
            new Product(62, "Middle peperoni pizza", 26_000, 36),
            new Product(63, "Middle peperoni pizza", 36_000, 36),

            new Product(64, "Small peperoni pizza", 26_000, 37),
            new Product(65, "Small peperoni pizza", 22_000, 37),
            new Product(66, "Small peperoni pizza", 32_000, 37),

            new Product(67, "Big peperoni pizza", 36_000, 38),
            new Product(68, "Big peperoni pizza", 34_000, 38),
            new Product(69, "Big peperoni pizza", 40_000, 38),

            new Product(70, "Middle peperoni pizza", 30_000, 39),
            new Product(71, "Middle peperoni pizza", 26_000, 39),
            new Product(72, "Middle peperoni pizza", 36_000, 39),

            new Product(73, "Small peperoni pizza", 26_000, 40),
            new Product(74, "Small peperoni pizza", 22_000, 40),
            new Product(75, "Small peperoni pizza", 32_000, 40),

            new Product(76, "2l coke", 18_000, 50),
            new Product(77, "1.5l coke", 16_000, 50),
            new Product(78, "1l coke", 12_000, 50),

            new Product(79, "2l fanta", 18_000, 51),
            new Product(80, "1.5l fanta", 16_000, 51),
            new Product(81, "1l fanta", 12_000, 52),

            new Product(82, "2l water", 12_000, 52),
            new Product(83, "1.5l water", 10_000, 52),
            new Product(84, "1l water", 8_000, 52),

            new Product(85, "1l simple coffee", 18_000, 53),
            new Product(86, "0,5 simple coffee", 16_000, 53),
            new Product(87, "small simple coffee", 12_000, 53),

            new Product(88, "1l milk", 18_000, 54),
            new Product(89, "1.5l milk", 16_000, 54),
            new Product(90, "1l milk", 12_000, 54),

            new Product(91, "2l mix", 12_000, 55),
            new Product(92, "1.5l mix", 10_000, 55),
            new Product(93, "1l mix", 8_000, 55)
    ));
    ArrayList<Order> orders = new ArrayList<>();

}
