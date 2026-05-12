package org.example;

import java.util.List;

/**
 * Точка входу в програму.
 * Використовується для демонстрації функціоналу створення намиста,
 * його сортування та пошуку каменів за заданими параметрами.
 */
public class Main {
    public static void main(String[] args) {
        Necklace necklace = new Necklace();

        // Ініціалізація об'єктів різних класів-нащадків
        necklace.addStone(new Diamond(1.5, 4500.0, 0.98));
        necklace.addStone(new Ruby(2.1, 2800.0, 0.85));
        necklace.addStone(new Amber(12.0, 400.0, 0.35));

        System.out.println("Початковий склад намиста");
        necklace.printInfo();
        // Розрахунок загальних показників
        System.out.println("\nЗагальна вага: " + necklace.calculateTotalWeight() + " к.");
        System.out.println("Загальна вартість: " + necklace.calculateTotalPrice() + "$");

        // Демонстрація сортування
        System.out.println("\nСортування за ціною");
        necklace.sortByValue();
        necklace.printInfo();
        // Визначаємо змінні для діапазону прозорості
        double minTransparency = 0.8;
        double maxTransparency = 1.0;

        // Виводимо задані параметри пошуку
        System.out.println("\nЗаданий діапазон прозорості: " + minTransparency + " - " + maxTransparency);
        System.out.println("Пошук каменів із заданою прозорістю");
        // Шукаємо камені, прозорість яких потрапляє в обраний діапазон
        var foundStones = necklace.findByTransparencyRange(minTransparency, maxTransparency);

        if (foundStones.isEmpty()) {
            System.out.println("Каменів із такою прозорістю не знайдено.");
        } else {
            foundStones.forEach(System.out::println);
        }
    }
}