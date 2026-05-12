package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Тестовий клас для перевірки функціональності класу Necklace.
 */
public class NecklaceTest {
    private Necklace necklace;

    /**
     * Метод, що ініціалізує об'єкт намиста та наповнює його тестовими даними.
     */
    @BeforeEach
    void setUp() {
        necklace = new Necklace();
        necklace.addStone(new Diamond(1.0, 5000.0, 0.95)); // Вага 1, Ціна 5000, Прозорість 0.95
        necklace.addStone(new Ruby(2.0, 3000.0, 0.80));    // Вага 2, Ціна 3000, Прозорість 0.80
        necklace.addStone(new Amber(5.0, 500.0, 0.40));    // Вага 5, Ціна 500, Прозорість 0.40
    }

    /**
     * Перевіряє правильність розрахунку загальної ваги намиста.
     */
    @Test
    @DisplayName("Розрахунок загальної ваги каміння в намисті")
    void testCalculateTotalWeight() {
        double expectedWeight = 1.0 + 2.0 + 5.0;
        assertEquals(expectedWeight, necklace.calculateTotalWeight(), 1,
                "Загальна вага розрахована неправильно.");
    }

    /**
     * Перевіряє правильність розрахунку загальної вартості намиста.
     */
    @Test
    @DisplayName("Розрахунок сумарної вартості всіх компонентів")
    void testCalculateTotalPrice() {
        double expectedPrice = 5000.0 + 3000.0 + 500.0;
        assertEquals(expectedPrice, necklace.calculateTotalPrice(), 1,
                "Загальна вартість розрахована неправильно.");
    }

    /**
     * Перевіряє роботу фільтра за діапазоном прозорості.
     */
    @Test
    @DisplayName("Пошук каміння за заданим діапазоном прозорості")
    void testFindByTransparencyRange() {
        // Шукаємо каміння з прозорістю від 0.8 до 1.0 (мають знайтися Діамант і Рубін)
        List<GemStone> result = necklace.findByTransparencyRange(0.8, 1.0);

        assertEquals(2, result.size(), "Кількість знайдених каменів має бути 2.");
        assertTrue(result.stream().anyMatch(s -> s.getName().equals("Діамант")), "Діамант має бути у списку.");
        assertTrue(result.stream().anyMatch(s -> s.getName().equals("Рубін")), "Рубін має бути у списку.");
    }

    /**
     * Перевіряє валідацію вхідних даних у конструкторі.
     * Очікується викидання IllegalArgumentException при некоректних параметрах.
     */
    @Test
    @DisplayName("Перевірка валідації вхідних даних")
    void testInvalidGemStoneParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Diamond(-1.0, 1000.0, 0.5); // Від'ємна вага
        }, "Мало бути викинуто IllegalArgumentException через некоректну вагу.");
    }
}