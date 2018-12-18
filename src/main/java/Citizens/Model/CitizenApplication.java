package Citizens.Model;

import Citizens.PersonReader;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CitizenApplication {

    private PersonReader personReader = new PersonReader();



    public void execute () {

        Long start = System.currentTimeMillis();

        List<Person> people = personReader.readPersonListFromCSV();


        Map<String, Long> countLastNames = countLastNames(people);

        for (Map.Entry<String, Long> nameCount : countLastNames.entrySet()) {
           System.out.println("There are " + nameCount.getValue() + " persons with last name " + nameCount.getKey());
       }

       Long stop = System.currentTimeMillis() - start;
        System.out.println("countLastNames time is: " + stop);

        System.out.println("===========================================");


        Map<String, List<Person>> firstNames = countFirstNames(people);

        for (Map.Entry<String, List<Person>> names : firstNames.entrySet()) {
            System.out.println("This is a complete list of all persons with name: " + names.getKey() + "   LIST { " + names.getValue() + " }"  );
        }

        Long stop2 = System.currentTimeMillis() - start;
        System.out.println("countFirstNames time is: " + stop2);

        System.out.println("===========================================");

        Long result = sortByAge(people);
        System.out.println("There are " + result + " people between 35 and 55 years age");

        Long stop3 = System.currentTimeMillis() - start;
        System.out.println("sortByAge time is: " + stop3);

        System.out.println("===========================================");
    }




// return listOfString.stream().filter(x -> x.startsWith("Level")).collect(Collectors.groupingBy(x -> Long.valueOf(x.charAt(6))));


    public Map<String, Long> countLastNames(List<Person> people) {
        people = personReader.readPersonListFromCSV();
        Map<String, Long> countedLastNames = new HashMap<>();

        List<String> lastNames = people.stream().map(Person::getLastName).distinct().collect(Collectors.toList());

        for (int i = 0; i < lastNames.size(); i++) {
            int finalI = i;
            Long count = people.stream().filter(x -> x.getLastName().equals(lastNames.get(finalI))).count();
            countedLastNames.put(lastNames.get(finalI),count);
        }
        return countedLastNames;
    }
//              Twój jest szybszy o 0.8 sek :/
//
//        for (Person person : people) {
//            String name = person.getName();
//            Long peopleWithTheSameNameCount = countedLastNames.getOrDefault(name, 0L);
//            peopleWithTheSameNameCount++;
//            countedLastNames.put(name, peopleWithTheSameNameCount);
//        }
//        return countedLastNames;
//
//    }


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
        Date olderThan = java.sql.Date.valueOf(older);
        Date youngerThan = java.sql.Date.valueOf(younger);

        return people.stream()
                .filter(x -> x.getBirthDate().after(olderThan))
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
