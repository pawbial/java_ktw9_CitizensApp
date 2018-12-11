package Citizens.Model;

import Citizens.PersonReader;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CitizenApplication {

    private PersonReader personReader = new PersonReader();


    public Map<String, Long> countLastNames(List<Person> people) {
        people = personReader.readPersonListFromCSV();
        Map<String, Long> countLastNames = new HashMap<>();
        for (Person person : people) {
            String lastName = person.getLastName();
            Long sameLastNameCount = countLastNames.getOrDefault(lastName, 0L);
            sameLastNameCount++;
            countLastNames.put(lastName, sameLastNameCount);

        }

        return countLastNames;
    }


    public Map <String, List <Person>> countFirstNames(List<Person> people) {
        Map<String, List<Person>> personsCountedByFirstName = new HashMap<>();
        Object[] firstNames = people.stream().map(Person::getName).map(String::toString).distinct().toArray();
        for (int i = 0; i < firstNames.length; i++) {
            int finalI = i;
            List<Person> personList = people.stream().filter(x -> x.getName().equals(firstNames[finalI])).collect(Collectors.toList());
            personsCountedByFirstName.put(String.valueOf(firstNames[finalI]),personList);
        }

        return personsCountedByFirstName;
    }
//                  :D Behold the mighty 5 min algorithm :D
//    public Map<String, List<Person>> countFirstNames(List<Person> people) {
//        Map<String, List<Person>> countedByFirstName = new HashMap<>();
//        List<Person> lastNames;
//        people = personReader.readPersonListFromCSV();
//        for (Person person : people) {
//            String firstName = person.getName();
//            if (countedByFirstName.containsKey(firstName)) {
//                countedByFirstName.get(firstName).add(person);
//            }
//            lastNames = new ArrayList<>();
//            for (Person person1 : people) {
//                String currName = person1.getName();
//                if (currName.equals(firstName)) {
//                    lastNames.add(person1);
//                }
//
//            }
//            countedByFirstName.put(firstName, lastNames);
//        }
//
//        return countedByFirstName;
//    }

    public Long sortByAge(List<Person> people) {
        people = personReader.readPersonListFromCSV();  // get all Persons method
        String pattern = "yyyy-MM-dd";
        LocalDate older = LocalDate.now().minusYears(55L);
        LocalDate younger = LocalDate.now().minusYears(35L);
        Date oldetThan = java.sql.Date.valueOf(older);
        Date youngerThan = java.sql.Date.valueOf(younger);

        return people.stream()
                .filter(x -> x.getBirthDate().after(oldetThan))
                .filter(x -> x.getBirthDate().before(youngerThan))
                .count();
    }


    public void getRandomDate(List<Person> people) {
        people = personReader.readPersonListFromCSV();
        String pattern = "yyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for (int i = 0; i < 10; i++) {
            Person person = people.get(i);
            System.out.print(person.getLastName() + "\t");
            System.out.println(simpleDateFormat.format(person.getBirthDate()) + "\t");
        }


    }
}
