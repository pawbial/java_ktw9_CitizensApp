package Citizens;

import Citizens.Model.Person;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PersonReader {

    private String fileLocation = "C:\\Users\\Użytkownik\\Desktop\\scource\\Zadania dodatkowe\\CitizenApp\\src\\main\\resources\\person.csv";


    public List<Person> readPersonSetFromCSV() {
        List<Person> personList = new ArrayList<Person>();
        CSVReader reader = null;
        try {
            reader = reader = new CSVReader(new FileReader(fileLocation), ',');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String[] nextLine;
            while ((nextLine = Objects.requireNonNull(reader).readNext()) != null) {
                Person person = new Person();
                person.setId(Integer.parseInt(nextLine[0]));
                person.setName(nextLine[1]);
                person.setLastName(nextLine[2]);
                person.setSex(nextLine[3]);
                person.setBirthDate(new Date(String.valueOf(new SimpleDateFormat("yyyy-MM-dd"))));
                personList.add(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
    }

}

