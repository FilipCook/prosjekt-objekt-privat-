package ProsjektObjekt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class WorkoutFileHandler {
    

    public void saveToFile(String filename, WorkoutLog log) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for(Workout w : log.getWorkouts()){
            writer.write(convertWorkoutToString(w));
            writer.newLine();
        }
        writer.close();
        

        
    }

    private String convertWorkoutToString(Workout w){
        if(w instanceof RunWorkout run){
            return "RUN" + run.getDate() +":"+ 
                           run.getDuration()+":"+
                           run.getDistance();

        }
        else if(w instanceof StrengthWorkout s){
            return "STRENGTH;" +
                s.getDate() + ";" +
                s.getDuration() + ";" +
                s.getExerciseName() + ";" +
                s.getWeightPerLift() + ";" +
                s.getReps() + ";" +
                s.getSets();
    }

    return "";
    }

    public WorkoutLog loadFromFile(String filename) throws IOException {
    WorkoutLog log = new WorkoutLog();

    BufferedReader reader = new BufferedReader(new FileReader(filename));

    String line;

    while ((line = reader.readLine()) != null) {
        Workout w = convertStringToWorkout(line);
        log.addWorkout(w);
    }

    reader.close();

    return log;
}

    public Workout convertStringToWorkout(String line){
        String[] parts = line.split(";");

        String type = parts[0];

        if (type.equals("RUN")) {
        LocalDate date = LocalDate.parse(parts[1]);
        int duration = Integer.parseInt(parts[2]);
        double distance = Double.parseDouble(parts[3]);

        return new RunWorkout(date, duration, distance);

    } else if (type.equals("STRENGTH")) {
        LocalDate date = LocalDate.parse(parts[1]);
        int duration = Integer.parseInt(parts[2]);
        String exercise = parts[3];
        int weight = Integer.parseInt(parts[4]);
        int reps = Integer.parseInt(parts[5]);
        int sets = Integer.parseInt(parts[6]);

        return new StrengthWorkout(date, duration, exercise, weight, reps, sets);
    }

    throw new IllegalArgumentException("Ukjent format i fil");
    }


    }
    
    

    
    




