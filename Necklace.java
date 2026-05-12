package org.example;

import java.util.*;

/**
 * Клас для управління колекцією каменів у намисті.
 */
public class Necklace {
    private final List<GemStone> stones = new ArrayList<>(); // Список для зберігання об'єктів GemStone

    /**
     * Додає новий камінь до колекції.
     * @param s Об'єкт типу GemStone.
     */
    public void addStone(GemStone s) { // Метод додавання каменю
        if (s != null) {
            stones.add(s);
        }
    }

    /**
     * Розраховує загальну вагу всіх каменів у намисті.
     */
    public double calculateTotalWeight() {
        return stones.stream() // Перетворення списку в потік даних
                .mapToDouble(GemStone::getWeight).sum();
    }

    /**
     * Розраховує загальну вартість намиста.
     * @return Сумарна ціна.
     */
    public double calculateTotalPrice() {
        return stones.stream().mapToDouble(GemStone::getPrice).sum();
    }

    /**
     * Сортує камені за вартістю у порядку спадання.
     */
    public void sortByValue() {
        stones.sort(Comparator.comparingDouble(GemStone::getPrice).reversed());
    }

    /**
     * Шукає камені, рівень прозорості яких входить у заданий діапазон.
     *
     * @param min Мінімальне значення прозорості.
     * @param max Максимальне значення прозорості.
     * @return Список знайдених каменів.
     */
    public List<GemStone> findByTransparencyRange(double min, double max) {
        return stones.stream()
                .filter(s -> s.getTransparency() >= min && s.getTransparency() <= max) // Фільтрація за діапазоном
                .toList();
    }

    /**
     * Виводить інформацію про всі камені.
     */
    public void printInfo() {
        for (GemStone s : stones) {
            System.out.println(s);
        }
    }
}
