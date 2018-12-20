package Citizens.Model;

public class Animal {


    private Integer id;
    private String name;
    private String type;

    private Animal (Builder builder) {

        id = builder.id;
        name = builder.name;
        type = builder.type;
    }


    public static Builder builder () {

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{ID: " + id + ", Name: " + name + ", Type: " + type + "}";
    }

    public static class Builder {

        private Integer id;
        private String name;
        private String type;

        public Animal build () {

            return new Animal(this);
        }

        public Builder id (Integer id) {

            this.id = id;

            return this;
        }

        public Builder name (String name) {

            this.name = name;

            return this;
        }

        public Builder type (String type) {

            this.type = type;

            return this;
        }


    }
}
