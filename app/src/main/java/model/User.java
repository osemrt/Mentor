package model;

public class User {
    private String prioritizedName;
    private double balance;
    private int age;
    private Blood blood;
    private Gender gender;
    private String name;
    private String surname;
    // Appointment[] appointments;
    // Review[] review;
    // VideoCall[] callHistory;
    // boolean isOnline;

    public User(){
        // Required
    }

    private User(String prioritizedName,
                 double balance,
                 int age,
                 Blood blood,
                 Gender gender,
                 String name,
                 String surname){
        this.prioritizedName = prioritizedName;
        this.balance = balance;
        this.age = age;
        this.blood = blood;
        this.gender = gender;
        this.name = name;
        this.surname = surname;
    }

    public static User userFactory(String prioritizedName,
                                   double balance,
                                   int age,
                                   String blood,
                                   String gender,
                                   String name,
                                   String surname){
        if( balance < 0.0 )
            balance = 0.0;

        if( age > 120 || age < 0)
            age = 0;


        return new User(prioritizedName,
                            balance,
                            age,
                            Blood.bloodFactory(blood),
                            Gender.genderFactory(gender),
                            name,
                            surname);
    }

    public static User userFactory(String prioritizedName,
                                   String balance,
                                   String age,
                                   String blood,
                                   String gender,
                                   String name,
                                   String surname){
        double userBalance;
        try {
            userBalance = Double.valueOf(balance);
            if( userBalance < 0.0 )
                userBalance = 0.0;
        }catch (NumberFormatException e){
            userBalance = 0.0;
        }

        int userAge;
        try {
            userAge = Integer.valueOf(age);
            if( userAge > 120 || userAge < 0)
                userAge = 0;
        }catch (NumberFormatException e){
            userAge = 0;
        }

        return new User(prioritizedName,
                userBalance,
                userAge,
                Blood.bloodFactory(blood),
                Gender.genderFactory(gender),
                name,
                surname);
    }

    public String getPrioritizedName() {
        return prioritizedName;
    }

    public void setPrioritizedName(String prioritizedName) {
        this.prioritizedName = prioritizedName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if( balance < 0.0)
            balance = 0.0;
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if( age > 120 || age < 0)
            age = 0;
        this.age = age;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}