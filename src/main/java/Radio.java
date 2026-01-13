public class Radio {
    private int currentStation = 0;
    private int currentVolume = 0;
    private int stationCount = 10;

    public Radio() {
        this.stationCount = 10;
    }

    public Radio(int stationCount) {
        if (stationCount > 0) {
            this.stationCount = stationCount;
        } else {
            this.stationCount = 10;
        }
    }

    public void next() {
        if (currentStation < stationCount - 1) {
            currentStation++;
        } else {
            currentStation = 0;
        }
    }

    public void prev() {
        if (currentStation > 0) {
            currentStation--;
        } else {
            currentStation = stationCount - 1;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationCount) {
            this.currentStation = station;
        }
    }

    public void volumeUp() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void volumeDown() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            this.currentVolume = 0;
        } else if (volume > 100) {
            this.currentVolume = 100;
        } else {
            this.currentVolume = volume;
        }
    }

    public int getVolume() {
        return currentVolume;
    }
}