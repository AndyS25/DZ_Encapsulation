package ru.netology.javaqa.services;
public class Radio {
    private int minNumberStation = 0;
    private int maxNumberStation = 9;
    private int numberCurrentStation = minNumberStation;
    private int currentVolume;

    public Radio() {
    }

    public Radio(int qualityStation) {
        this.maxNumberStation = qualityStation - 1;
    }

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

    public int getMinNumberStation() {
        return minNumberStation;
    }

    public int getMaxNumberStation() {
        return maxNumberStation;
    }

    public void setCurrentStation(int newNumberCurrentStation) { //выставление номера станции с проверкой разр. диапазона
        if (newNumberCurrentStation < minNumberStation) {
            return;
        }
        if (newNumberCurrentStation > maxNumberStation) {
            return;
        }
        numberCurrentStation = newNumberCurrentStation;
    }

    public void nextStation() {  //увеличение номера станции на 1
        if (numberCurrentStation == maxNumberStation) {
            numberCurrentStation = minNumberStation;
        } else {
            numberCurrentStation++;
        }
    }

    public void prevStation() {  //уменьшение номера станции на 1
        if (numberCurrentStation == minNumberStation) {
            numberCurrentStation = maxNumberStation;
        } else {
            numberCurrentStation--;
        }
    }
}