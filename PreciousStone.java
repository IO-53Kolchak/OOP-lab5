package org.example;

/**
 * Абстрактний клас, що представляє категорію дорогоцінного каміння.
 * До цієї категорії відносяться камені з високою вартістю (в нашому випадку це діамант та рубін).
 */
public abstract class PreciousStone extends GemStone {
    public PreciousStone(String name, double weight, double price, double transparency) { // Конструктор для створення
        super(name, weight, price, transparency);
    }

    /**
     * Перевизначення методу для ідентифікації категорії каменя.
     */
    @Override
    public String toString() {
        return "[Коштовний] " + super.toString();
    }
}
