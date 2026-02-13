package ru.netology.javaqa.services;

public class Radio {
    private int numberCurrentStation;
    private int currentVolume;

    public int getCurrentVolume() { //получение текущего уровня громкости
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) { //выставление уровня громкости с проверкой разр. диапазона
        if (newCurrentVolume < 0) {
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void increaseVolume() {  //увеличение уровня громкости на 1
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {  //уменьшение громкости на 1
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public int getNumberCurrentStation() { //получение текущего номера станции
        return numberCurrentStation;
    }

    public void setCurrentStation(int newNumberCurrentStation) { //выставление номера станции с проверкой разр. диапазона
        if (newNumberCurrentStation < 0) {
            return;
        }
        if (newNumberCurrentStation > 9) {
            return;
        }
        numberCurrentStation = newNumberCurrentStation;
    }

    public void nextStation() {  //увеличение номера станции на 1
        if (numberCurrentStation == 9) {
            numberCurrentStation = 0;
        } else {numberCurrentStation++;}
    }

    public void prevStation() {  //уменьшение номера станции на 1
        if (numberCurrentStation == 0) {
            numberCurrentStation = 9;
        } else {numberCurrentStation--;}
    }
}