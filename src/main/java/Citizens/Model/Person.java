package Citizens.Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Person {

    private Integer id;
    private String name;
    private String lastName;
    private String sex;
    private Date birthDate;
    private List<Animal> pets;


    private Person (Builder builder) {

        id = builder.id;
        name = builder.name;
        lastName = builder.lastName;
        sex = builder.sex;
        birthDate = builder.birthDate;
        pets = builder.pets;
    }

    public static Builder builder (String name, String lastName, String sex, Date birthDate ){

        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Name must have at least 2 characters");
        }
        if (lastName == null || lastName.length()<2)
            throw new IllegalArgumentException("Last name must have at least 2 characters");
        if (!(sex.equals("M") || sex.equals("F"))) {
            throw new IllegalArgumentException("Sex must be defined");
        }
        LocalDate now = LocalDate.now();
        Date present = java.sql.Date.valueOf(now);
        LocalDate grownUp = LocalDate.now().minusYears(18L);
        Date adult = java.sql.Date.valueOf(grownUp);
        if (birthDate.after(present) || birthDate.after(adult)){
            throw new IllegalArgumentException("Person must be over 18 years old");
        }
        return new Builder();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        this.sex = sex;
    }

    public Date getBirthDate() {

        return birthDate;
    }

    public void setBirthDate(Date birthDate) {

        this.birthDate = birthDate;
    }

    public List<Animal> getPets() {
        return pets;
    }

    @Override
    public String toString() {

        return "{" + name + ",  " + lastName + ",  " + "ID: " + id + "}";
    }

    public static class Builder {


        private Integer id;
        private String name;
        private String lastName;
        private String sex;
        private Date birthDate;
        private List<Animal> pets;


        public Person build () {

            return new Person(this);
        }

        public Builder id (Integer id) {

            this.id = id;

            return this;
        }

        public Builder name (String name){

            this.name = name;

            return this;
        }

        public Builder lastName (String lastName) {

            this.lastName = lastName;

            return this;
        }

        public Builder sex (String sex) {

            this.sex = sex;

            return this;
        }

        public Builder birthDate (Date birthDate) {

            this.birthDate = birthDate;

            return this;
        }

        public Builder pets (List<Animal> pets) {

            this.pets = pets;
            return this;
        }

    }
}
