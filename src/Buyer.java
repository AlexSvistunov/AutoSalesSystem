class Buyer {
    private String fullName;
    private int age;
    private char gender;

    public Buyer(String fullName, int age, char gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}