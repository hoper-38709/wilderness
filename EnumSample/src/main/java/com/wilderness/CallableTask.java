package com.wilderness;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Callable;

/**
 * Created by wilderness on 11/28/2014.
 */
public class CallableTask implements Callable<Integer> {
    private Integer startInteger;
    private static NutritionFacts cocaCola =null;
    private static Properties properties = null;

    static {
        InputStream inputStream  = CallableClient.class.getClassLoader().getResourceAsStream("file.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException ex){
            ;
        } finally {
            try {
                inputStream.close();
            }catch (IOException ex){
                ;
            }
        }

    }
    CallableTask (Integer startInteger){
        this.startInteger = startInteger;
    }
    @Override
    public Integer call() throws Exception {
        NutritionFacts age;
        //synchronized(CallableTask.class)
        // {

        //int calories = Integer.valueOf(properties.getProperty("nutrition.calories"));
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).
                calories(100).sodium(startInteger).carbohydrate(27).build();

        SparkSubsystem.INSTANCE.write(cocaCola);
        age = SparkSubsystem.INSTANCE.read();
        //}
        return age.getSodium();
    }
}

