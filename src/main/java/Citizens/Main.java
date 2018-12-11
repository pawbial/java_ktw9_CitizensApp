package Citizens;

import Citizens.Model.CitizenApplication;
import Citizens.Model.Person;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        PersonReader personReader = new PersonReader();
        CitizenApplication citizenApplication = new CitizenApplication();


        Map<String, List<Person>> stringListMap = citizenApplication.countFirstNames(personReader.readPersonListFromCSV());

    }


}
