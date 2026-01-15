import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadioTest {


    @Test
    void testNext_station_normal() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testNext_station_wrap() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }


    @Test
    void testPrev_station_normal() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testPrev_station_wrap() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }


    @Test
    void testSetCurrentStation_invalid_low() {
        Radio radio = new Radio();
        radio.setCurrentStation(-5);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testSetCurrentStation_invalid_high() {
        Radio radio = new Radio();
        radio.setCurrentStation(15);
        assertEquals(0, radio.getCurrentStation());
    }


    @Test
    void testSetCurrentStation_valid() {
        Radio radio = new Radio();
        radio.setCurrentStation(7);
        assertEquals(7, radio.getCurrentStation());
    }


    @Test
    public void testSwitchStationsCycle() {
        Radio radio = new Radio(3); // 3 станции: 0,1,2

        radio.setCurrentStation(2);
        radio.next(); // должен стать 0
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(0);
        radio.prev(); // должен стать 2
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    public void testVolumeLimits() {
        Radio radio = new Radio();

        radio.setVolume(150);
        assertEquals(100, radio.getVolume());

        radio.setVolume(-10);
        assertEquals(0, radio.getVolume());

        radio.setVolume(50);
        assertEquals(50, radio.getVolume());
    }

    @Test
    public void testVolumeUpDownLimits() {
        Radio radio = new Radio();
        // Установим громкость на максимум
        radio.setVolume(100);
        radio.volumeUp();
        assertEquals(100, radio.getVolume());

        // Установка на минимум
        radio.setVolume(0);
        radio.volumeDown();
        assertEquals(0, radio.getVolume());
    }
}




