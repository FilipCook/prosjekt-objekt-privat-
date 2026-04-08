package ProsjektObjekt;

import java.time.LocalDate;

public class StrengthWorkout implements Workout{
    private LocalDate date;
    private int duration;
    private String exerciseName;
    private int weightPerLift;
    private int reps;
    private int sets;


    public StrengthWorkout(LocalDate date, int duration, String exerciseName, int reps, int sets, int weightPerLift) {
        
        if(date == null){
            throw new IllegalArgumentException("dato kan ikke være null");
        }

        if(duration < 0){
            throw new IllegalArgumentException("duration må være mer enn 0");
        }

        if(exerciseName == null|| exerciseName.isBlank()){
            throw new IllegalArgumentException("Navnet på øvelsen kan ikke være null/blank");
        }
        if (reps <= 0) {
            throw new IllegalArgumentException("Reps må være større enn 0");
        }
        if (sets <= 0) {
            throw new IllegalArgumentException("Sets må være større enn 0");
        }
        if (weightPerLift < 0) {
            throw new IllegalArgumentException("Vekt kan ikke være negativ");
        }

        this.date = date;
        this.duration = duration;
        this.exerciseName = exerciseName;
        this.reps = reps;
        this.sets = sets;
        this.weightPerLift = weightPerLift;
    }


    @Override
    public int getDuration() {
        return duration;
    }


    public String getExerciseName() {
        return exerciseName;
    }


    public int getWeightPerLift() {
        return weightPerLift;
    }


    public int getReps() {
        return reps;
    }


    public int getSets() {
        return sets;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getType() {
        return "Styrke";
        
    }

    @Override
    public String getDisplayText() {
        return "Dato: " + date +
               ", Styrke, " +
               duration + " min, " +
               exerciseName +
               ", " + weightPerLift + " kg, " +
               reps + " reps, " +
               sets + " sets";
    }


    @Override
    public String toFileFormat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toFileFormat'");
    }

    
    

    


}
