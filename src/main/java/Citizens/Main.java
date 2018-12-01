package Citizens;

import Citizens.Model.CitizenApplication;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        PersonReader personReader = new PersonReader();
        CitizenApplication citizenApplication = new CitizenApplication();

//        try {
//            citizenApplication.countLastNames(personReader.readPersonSetFromCSV());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        citizenApplication.getRandomDate(personReader.readPersonSetFromCSV());
    }


}
