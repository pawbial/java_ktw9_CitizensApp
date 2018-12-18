package Citizens.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private Integer id;
    private String name;
    private String lastName;
    private String sex;
    private Date birthDate;


    public Person(Integer id, String name, String lastName, String sex, Date birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public Person () {

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


    @Override
    public String toString() {

        return name + " " + lastName + " " + "ID: " + id;
    }
}
