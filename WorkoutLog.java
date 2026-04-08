package ProsjektObjekt;

import java.util.ArrayList;
import java.util.List;

public class WorkoutLog{

    private final List<Workout> workouts;

    public WorkoutLog(){
        this.workouts = new ArrayList<>();
    }

    
    public void addWorkout(Workout workout){
        if(workout == null){
            throw new IllegalArgumentException("Workout kan ikke være null");
        }
        workouts.add(workout);
    }

    public List<Workout> getWorkouts(){
        return workouts;

    }
    public int getTotalDuration(){
        int total = 0;

        for(Workout w : workouts){
            total += w.getDuration();
        }

        return total;
    }

    public double getTotalRunningDistance(){
        double total = 0;

        for(Workout w : workouts){
            if(w instanceof RunWorkout runWorkout){
                total += runWorkout.getDistance();
            }
        }
        return total;

    }
    public int getWorkoutCount(){
        return workouts.size();

    }

    public int getStrengthWorkoutCount(){
        int count = 0;

        for(Workout w : workouts){
            if(w instanceof StrengthWorkout){
                count++;
            }
        }
        return count;

    }


    
        
}