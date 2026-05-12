package org.example;

/**
 * Абстрактний клас, що представляє категорію напівкоштовного каміння.
 * Використовується в ієрархії для групування каменів середньої цінності (наприклад, Бурштин).
 * Забезпечує логічний поділ колекції згідно з технічним завданням.
 */
public abstract class SemipreciousStone extends GemStone {
    public SemipreciousStone(String name, double weight, double price, double transparency) { // Конструктор для створення
        super(name, weight, price, transparency);
    }

    /**
     * Перевизначення методу для ідентифікації категорії каменя.
     */
    @Override
    public String toString() {
        return "[Напівкоштовний] " + super.toString();
    }
}
