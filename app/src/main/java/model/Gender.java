package model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public enum Gender{
    MALE(0){
        @Override
        public String toString(){
            return "Male";
        }
    }, FEMALE(1){
        @Override
        public String toString(){
            return "Female";
        }
    },UNDEFINED(-1){
        @Override
        public String toString(){
            return "----";
        }
    };

    private final int intValue;
    private Gender(int intValue){
        this.intValue = intValue;
    }

    @NonNull
    public static Gender genderFactory(int intValue){
        for( Gender g : Gender.values() )
            if(g.getIntValue() == intValue)
                return g;
        return Gender.UNDEFINED;
    }

    public static boolean isValid(int intValue){
        return genderFactory(intValue) != Gender.UNDEFINED;
    }

    @NonNull
    public static Gender genderFactory(String gender){
        if( gender == null)
            return Gender.UNDEFINED;
        for( Gender g : Gender.values() )
            if( g.toString().compareToIgnoreCase(gender) == 0 )
                return g;
        return Gender.UNDEFINED;
    }

    public static boolean isValid(String gender){
        return genderFactory(gender) != Gender.UNDEFINED;
    }

    public int getIntValue() {
        return intValue;
    }
    public abstract String toString();
}