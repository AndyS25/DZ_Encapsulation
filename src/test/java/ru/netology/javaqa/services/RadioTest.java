package ru.netology.javaqa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void shouldSetNumberStation() { //проверка выставления заданного номера станции
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        int expected = 5;
        int actual = radio.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNumberStationAboveRange() { //проверка выставления номера станции выше диапазона номеров
        Radio radio = new Radio();
        radio.setCurrentStation(10);

        int expected = 0;
        int actual = radio.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNumberStationBelowRange() { //проверка выставления номера станции ниже диапазона номеров
        Radio radio = new Radio();
        radio.setCurrentStation(-1);

        int expected = 0;
        int actual = radio.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextNumberStation() { //проверка переключения на следующую станцию
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.nextStation();

        int expected = 1;
        int actual = radio.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextNumberStationOverMax() { //проверка переключения с последней станции на первую
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.nextStation();

        int expected = 0;
        int actual = radio.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrevNumberStation() { //проверка переключения на предыдущую станцию
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.prevStation();

        int expected = 8;
        int actual = radio.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrevNumberStationDownMin() { //проверка переключения с первой станции на последнюю
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prevStation();

        int expected = 9;
        int actual = radio.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldSetCurrentVolume() { //проверка выставления текущего уровня громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        int expected = 50;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetCurrentVolumeOverMax() { //проверка выставления уровня громкости выше максимума
        Radio radio = new Radio();
        radio.setCurrentVolume(101);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetCurrentVolumeDownMin() { //проверка выставления уровня громкости ниже минимума
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolume() { //проверка увеличения громкости на 1
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.increaseVolume();

        int expected = 51;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolumeOverMax() { //проверка увеличения громкости при достижении максимума
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolume() { //проверка уменьшения громкости на 1
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.decreaseVolume();

        int expected = 49;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolumeDownMin() { //проверка уменьшения громкости при достижении минимума
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}