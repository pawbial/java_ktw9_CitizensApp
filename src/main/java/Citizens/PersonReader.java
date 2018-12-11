package Citizens;

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

public class PersonReader {

    private String fileLocation = "C:\\Users\\Użytkownik\\Desktop\\source\\Zadania dodatkowe\\CitizenApp\\src\\main\\resources\\person.csv";


    public List<Person> readPersonListFromCSV() {
        List<Person> personList = new ArrayList<Person>();
        CSVReader reader = null;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            reader = reader = new CSVReader(new FileReader(fileLocation), ',');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String[] nextLine;
            while ((nextLine = Objects.requireNonNull(reader).readNext()) != null) {
                Date date = simpleDateFormat.parse(nextLine[4]);
                Person person = new Person();
                person.setId(Integer.parseInt(nextLine[0]));
                person.setName(nextLine[1]);
                person.setLastName(nextLine[2]);
                person.setSex(nextLine[3]);
                person.setBirthDate(date);
                personList.add(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return personList;
    }

}

