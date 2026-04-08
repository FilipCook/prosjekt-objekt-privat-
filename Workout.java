package ProsjektObjekt;

import java.time.LocalDate;

public interface Workout {
    LocalDate getDate();
    String getType();
    int getDuration();
    String getDisplayText();
    String toFileFormat();
}