package Citizens.Model;

import Citizens.PersonReader;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CitizenApplication {

    private PersonReader personReader = new PersonReader();


    public Map<String, Long> countLastNames(List<Person> people) {
        people = personReader.readPersonSetFromCSV();
        Map<String, Long> countLastNames = new HashMap<>();
        for (Person person : people) {
            String lastName = person.getLastName();
            Long sameLastNameCount = countLastNames.getOrDefault(lastName, 0L);
            sameLastNameCount++;
            countLastNames.put(lastName, sameLastNameCount);

        }
        for (Map.Entry<String, Long> names : countLastNames.entrySet()) {
            System.out.println(names.getKey() + " " + names.getValue());
        }
        return countLastNames;
    }

//    public Map <String, List <Person>> countFirstNames (List <Person> people) {
//        try {
//            people = personReader.readPersonSetFromCSV();
//        } catch (FileNotFoundException e) {
//            System.out.println("Encountered file problem");
//        }
//        Map <String, List<Person>> countFirstNames = new HashMap<>();
//        for (Person person : people) {
//            String firstName = person.getName();
//            people.stream().sorted(Comparator.comparing(
//        }
//    }
//
//    public Long sortByAge (List <Person> people) {
//        try {
//            people = personReader.readPersonSetFromCSV();
//        } catch (FileNotFoundException e) {
//            System.out.println("Encountered file problem");
//        }
//        String older = "1983-01-01";
//        String younger = "1963-01-01";
//        try {
//            Date olderThan = new SimpleDateFormat("yyyy-MM-dd").parse(older);
//            Date youngerThan = new SimpleDateFormat("yyyy-MM-dd").parse(younger);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        people.stream().filter(x -> x.getBirthDate()>)
//
//    }


    public void getRandomDate(List<Person> people) {
        people = personReader.readPersonSetFromCSV();
        for (int i = 0; i < 10; i++) {
            Person person = people.get(i);
            System.out.print(person.getLastName()+ "\t");
            System.out.println(person.getBirthDate() +"\t");
        }


    }


}
