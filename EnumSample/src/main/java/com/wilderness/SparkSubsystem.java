package com.wilderness;

/**
 * Created by wilderness on 11/28/2014.
 */
public enum SparkSubsystem implements Writable, Readable{
    INSTANCE("local"){
        private NutritionFacts age = null;
        @Override
        public  synchronized void write(NutritionFacts value) {
            if (age == null)
                age = value;
        }

        @Override
        public synchronized NutritionFacts read () {
            return age;
        }
    };
    private String system;

    SparkSubsystem(String system){
       this.system = system;
    }
}
