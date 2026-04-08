package ProsjektObjekt;

import java.time.LocalDate;

public class RunWorkout implements Workout {

    private LocalDate date;
    private int duration;
    private double distance;

    public RunWorkout(LocalDate date, int duration, double distance){
        if(date == null){
            throw new IllegalArgumentException("dato kan ikke være null");
        }

        if(duration <= 0){
            throw new IllegalArgumentException("tid kan ikke være null eller mindre");
        }
        if(distance <= 0){
            throw new IllegalArgumentException("tid kan ikke være null eller mindre");
        }
        this.date = date;
        this.duration = duration;
        this.distance = distance;
        

    }

    @Override
    public LocalDate getDate(){
        return date;
    }

    @Override
    public int getDuration(){
        return duration;
    }
    
    
    public double getDistance(){
        return distance;
    }

    @Override
    public String getType(){
        return "Løping";
    }

    @Override
    public String getDisplayText(){
        return "Dato:" + date + " Løping:" + duration + "min  distanse:" + distance + "km ";
    }

    @Override
    public String toFileFormat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toFileFormat'");
    }
}
