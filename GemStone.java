package org.example;

/**
 * Абстрактний клас GemStone. Визначає спільні поля для всіх каменів.
 */
public abstract class GemStone { // Оголошення абстрактного базового класу
    private final String name; // Поле для назви каменю
    private final double weight; // Поле для ваги в каратах
    private final double price; // Поле для вартості
    private final double transparency; // Поле для коефіцієнта прозорості

    /**
     * Конструктор для створення об'єкта GemStone.
     */
    public GemStone(String name, double weight, double price, double transparency) {
        // Перевірка вхідних параметрів
        if (weight <= 0 || transparency < 0 || transparency > 1) {
            throw new IllegalArgumentException("Параметри каменю поза допустимими межами.");
        }
        // Присвоєння значень внутрішнім полям класу
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.transparency = transparency;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public double getPrice() { return price; }
    public double getTransparency() { return transparency; }

    @Override
    public String toString() {
        return String.format("%s: Вага: %.2f к., Ціна: %.2f $, Прозорість: %.2f",
                name, weight, price, transparency);
    }
}