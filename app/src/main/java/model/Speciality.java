package model;

import androidx.annotation.NonNull;

public enum Speciality{
    AUDIOLOGIST(0){
        @Override
        public String toString() {
            return "Audiologist";
        }
    },
    ALLERGIST(1) {
        @Override
        public String toString() {
            return "Allergist";
        }
    },
    CARDIOLOGIST(2) {
        @Override
        public String toString() {
            return "Cardiologist";
        }
    },
    ANESTHESIOLOGIST(3) {
        @Override
        public String toString() {
            return "Anesthesiologist";
        }
    },
    DENTIST(4) {
        @Override
        public String toString() {
            return "Dentist";
        }
    },
    DERMATOLOGIST(5) {
        @Override
        public String toString() {
            return "Dermatologist";
        }
    },
    ENDOCRINOLOGIST(6) {
        @Override
        public String toString() {
            return "Endocrinologist";
        }
    },
    EPIDEMIOLOGIST(7) {
        @Override
        public String toString() {
            return "Epidemiologist";
        }
    },
    NEUROLOGIST(8) {
        @Override
        public String toString() {
            return "Neurologist";
        }
    },
    ONCOLOGIST(9) {
        @Override
        public String toString() {
            return "Oncologist";
        }
    },
    PSYCHIATRIST(10) {
        @Override
        public String toString() {
            return "Psychiatrist";
        }
    },
    UROLOGIST(11) {
        @Override
        public String toString() {
            return "Urologist";
        }
    },
    VETERINARIAN(12) {
        @Override
        public String toString() {
            return "Veterinarian";
        }
    },
    UNDEFINED(-1){
        @Override
        public String toString(){
            return "---";
        }
    };
    private int intValue;
    public abstract String toString();
    private Speciality(int intValue ){
        this.intValue = intValue;
    }
    public int getIntValue() {
        return intValue;
    }

    @NonNull
    public static Speciality specialityFactory(int intValue){
        for( Speciality s : Speciality.values() )
            if(s.getIntValue() == intValue)
                return s;

        return UNDEFINED;
    }

    @NonNull
    public static Speciality specialityFactory(String speciality){
        if( speciality == null)
            return UNDEFINED;

        for( Speciality s : Speciality.values() )
            if( s.toString().compareToIgnoreCase(speciality) == 0)
                return s;
        return UNDEFINED;
    }

}
