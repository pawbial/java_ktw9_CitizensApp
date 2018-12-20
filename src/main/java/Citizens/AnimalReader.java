package Citizens;

import Citizens.Model.Animal;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalReader {

    private String fileLocation = "C:\\Users\\Użytkownik\\Desktop\\source\\Zadania dodatkowe\\CitizenApp\\src\\main\\resources\\animal.csv";


    public List<Animal> readAnimalListFromCSV () {
        List <Animal> animals = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(fileLocation), ',')) {
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Animal.Builder builder = new Animal.Builder();
                builder.id(Integer.parseInt(nextLine[0]));
                builder.name(nextLine[1]);
                builder.type(nextLine[2]);
                Animal animal = builder.build();
                animals.add(animal);

            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println("IO Exception!");
        }
        return animals;
    }
}
