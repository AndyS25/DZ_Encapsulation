package ru.netology.javaqa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    //Тесты управления радиостанциями с конструктором
    Radio radio = new Radio(20);
    @Test
    public void shouldSetNumberStation() { //проверка выставления заданного номера станции
        radio.setCurrentStation(5);

        Assertions.assertEquals(5, radio.getNumberCurrentStation());
    }

    @Test
    public void shouldSetNumberStationAboveRange() { //проверка выставления номера станции выше диапазона номеров
        radio.setCurrentStation(radio.getMaxNumberStation() + 1);

        Assertions.assertEquals(radio.getMinNumberStation(), radio.getNumberCurrentStation());
    }

    @Test
    public void shouldSetNumberStationBelowRange() { //проверка выставления номера станции ниже диапазона номеров
        radio.setCurrentStation(radio.getMinNumberStation() - 1);

        Assertions.assertEquals(radio.getMinNumberStation(), radio.getNumberCurrentStation());
    }

    @Test
    public void shouldNextNumberStation() { //проверка переключения на следующую станцию
        radio.setCurrentStation(5);

        radio.nextStation();

        Assertions.assertEquals(6, radio.getNumberCurrentStation());
    }

    @Test
    public void shouldNextNumberPenultimateStation() { //проверка переключения с предпоследней на следующую станцию
        radio.setCurrentStation(radio.getMaxNumberStation() - 1);

        radio.nextStation();

        Assertions.assertEquals(radio.getMaxNumberStation(), radio.getNumberCurrentStation());
    }

    @Test
    public void shouldNextNumberStationOverMax() { //проверка переключения с последней станции на первую
        radio.setCurrentStation(radio.getMaxNumberStation());

        radio.nextStation();

        Assertions.assertEquals(radio.getMinNumberStation(), radio.getNumberCurrentStation());
    }

    @Test
    public void shouldPrevNumberStation() { //проверка переключения на предыдущую станцию
        radio.setCurrentStation(5);

        radio.prevStation();

        Assertions.assertEquals(4, radio.getNumberCurrentStation());
    }

    @Test
    public void shouldPrevNumberStationDownMin() { //проверка переключения с первой станции на последнюю
        radio.setCurrentStation(radio.getMinNumberStation());

        radio.prevStation();

        Assertions.assertEquals(radio.getMaxNumberStation(), radio.getNumberCurrentStation());
    }

    @Test
    public void shouldPrevNumberPreviousStation() { //проверка переключения с первой станции на нулевую
        radio.setCurrentStation(radio.getMinNumberStation() + 1);

        radio.prevStation();

        Assertions.assertEquals(radio.getMinNumberStation(), radio.getNumberCurrentStation());
    }

    //Тесты для проверки регулировки звука
    @Test
    public void shouldSetCurrentVolume() { //проверка выставления текущего уровня громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        Assertions.assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetCurrentVolumeOverMax() { //проверка выставления уровня громкости выше максимума
        Radio radio = new Radio();
        radio.setCurrentVolume(101);

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetCurrentVolumeDownMin() { //проверка выставления уровня громкости ниже минимума
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() { //проверка увеличения громкости на 1
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.increaseVolume();

        Assertions.assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeOverMax() { //проверка увеличения громкости при достижении максимума
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() { //проверка уменьшения громкости на 1
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.decreaseVolume();

        Assertions.assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolumeDownMin() { //проверка уменьшения громкости при достижении минимума
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
}