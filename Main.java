package ProsjektObjekt;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        
        RunWorkout run = new RunWorkout(LocalDate.now(), 30, 5.0);

        System.out.println(run.getDisplayText());

        StrengthWorkout strength = new StrengthWorkout(
            LocalDate.now(), 60, "Benkpress", 
            80, 8, 4
        );
        System.out.println(strength.getDisplayText());


        WorkoutLog log = new WorkoutLog();

        log.addWorkout(new RunWorkout(LocalDate.now(),10, 10));
        log.addWorkout(new StrengthWorkout(LocalDate.now(),10, "benk", 10, 10, 100));

        for(Workout w : log.getWorkouts()){
            System.out.println(w.getDisplayText());
        }

        System.out.println("Total varighet: " + log.getTotalDuration());
        System.out.println("Total distanse: " + log.getTotalRunningDistance());
        System.out.println("Antall økter: " + log.getWorkoutCount());
        System.out.println("Styrkeøkter: " + log.getStrengthWorkoutCount());


        WorkoutLog log1 = new WorkoutLog();

        log1.addWorkout(new StrengthWorkout(LocalDate.now(), 10,"squats", 10,5,100));

        WorkoutFileHandler handler = new WorkoutFileHandler();

        handler.saveToFile("workouts.txt", log);

        WorkoutLog loaded = handler.loadFromFile("workouts.txt");

        for (Workout w : loaded.getWorkouts()) {
            System.out.println(w.getDisplayText());





    }

        

    }
}

    

