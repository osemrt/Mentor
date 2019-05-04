package model;

public class Doctor extends User {
    private Speciality speciality;
    private double hourlyRate;
    private String about;

    public Doctor(){
        // Required
    }

    private Doctor(Speciality speciality, double hourlyRate, String about) {
        this.speciality = speciality;
        this.hourlyRate = hourlyRate;
        this.about = about;
    }

    public static Doctor doctorFactory(Speciality speciality, double hourlyRate, String about){
        if( hourlyRate < 0 )
            hourlyRate = 0;

        if(about == null)
            about = "";

        return new Doctor(speciality,hourlyRate,about);
    }

    public static Doctor doctorFactory(String speciality, double hourlyRate, String about){
        return doctorFactory( Speciality.specialityFactory(speciality),hourlyRate,about);
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}

