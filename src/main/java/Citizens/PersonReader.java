package Citizens;

import Citizens.Model.Animal;
import Citizens.Model.Person;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonReader {

    private String fileLocation = "C:\\Users\\Użytkownik\\Desktop\\source\\Zadania dodatkowe\\CitizenApp\\src\\main\\resources\\person.csv";


    public List<Person> readPersonListFromCSV() {
        List<Animal> animals = getAnimals();
        List<Person> personList = new ArrayList<>();
        CSVReader reader = null;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            reader = new CSVReader(new FileReader(fileLocation), ',');
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
        try {
            String[] nextLine;
            while ((nextLine = Objects.requireNonNull(reader).readNext()) != null) {
                Date date = simpleDateFormat.parse(nextLine[4]);
                Person.Builder builder = new Person.Builder();
                builder.id(Integer.parseInt(nextLine[0]));
                builder.name(nextLine[1]);
                builder.lastName(nextLine[2]);
                builder.sex(nextLine[3]);
                builder.birthDate(date);
                builder.pets(petIdMatch(Integer.parseInt(nextLine[0]),animals));
                Person person = builder.build();
                personList.add(person);
            }

        } catch (IOException e) {
            System.out.println("IO Exception!");
        } catch (ParseException e) {
            System.out.println("Parse Exception!");
        }
        return personList;
    }

    private List<Animal> getAnimals() {
        AnimalReader animalReader = new AnimalReader();
        return animalReader.readAnimalListFromCSV();
    }

    private List<Animal> petIdMatch(Integer id, List<Animal> animals) {

        return animals.stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList());
    }

}

