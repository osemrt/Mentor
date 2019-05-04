package model;

import androidx.annotation.NonNull;

public enum Blood{
    ZERO_POSITIVE(0){
        @Override
        public String toString(){
            return "0+";
        }
    },
    ZERO_NEGATIVE(4){
        @Override
        public String toString(){
            return "0-";
        }
    },
    A_POSITIVE(1){
        @Override
        public String toString(){
            return "A+";
        }
    },
    A_NEGATIVE(5){
        @Override
        public String toString(){
            return "A-";
        }
    },
    B_POSITIVE(2){
        @Override
        public String toString(){
            return "B+";
        }
    },
    B_NEGATIVE(6){
        @Override
        public String toString(){
            return "B-";
        }
    },
    AB_POSITIVE(3){
        @Override
        public String toString(){
            return "AB+";
        }
    },
    AB_NEGATIVE(7){
        @Override
        public String toString(){
            return "AB-";
        }
    },
    UNDEFINED(-1){
        @Override
        public String toString(){
            return "---";
        }
    };

    private int intValue;
    private Blood(int intValue){
        this.intValue = intValue;
    }

    @NonNull
    public static Blood bloodFactory(int intValue){
        for( Blood b : Blood.values() )
            if(b.getIntValue() == intValue)
                return b;

        return UNDEFINED;
    }

    @NonNull
    public static Blood bloodFactory(String blood){
        if( blood == null)
            return UNDEFINED;

        for( Blood b : Blood.values() )
            if( b.toString().compareToIgnoreCase(blood) == 0)
                return b;
        return UNDEFINED;
    }

    public static boolean isValid(String blood){
        return bloodFactory(blood) != UNDEFINED;
    }

    public static boolean isValid(int intValue){
        return bloodFactory(intValue) != UNDEFINED;
    }

    public int getIntValue() {
        return intValue;
    }

    public abstract String toString();
}