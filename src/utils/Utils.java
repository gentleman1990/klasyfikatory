package utils;

import type.Iris;
import type.TTOM;
import type.TTOMGrafana;
import type.Wine;
import Similarity;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.rmi.NoSuchObjectException;
import java.util.*;

/**
 * Created by Jakub on 2016-06-13.
 */
public class Utils {

    public static double numberOfSample = 0;
    public static double numberOfIncorrectResult = 0;

    public static Collection<Object> shuffleCollection(Collection<Object> objectCollection){
        Collection<Object> shuffledCollection = new ArrayList<>();
        List listObjectsCollection = new ArrayList(objectCollection);
        int newRandom;
        for(int i = 0; i<objectCollection.size();i++){
            if(listObjectsCollection.size() !=1){
                Random generator = new Random();
                newRandom = generator.nextInt(listObjectsCollection.size()-1);
                shuffledCollection.add(listObjectsCollection.get(newRandom));
                listObjectsCollection.remove(newRandom);
            }
            else{
                shuffledCollection.add(listObjectsCollection.get(0));
            }

        }
        System.out.println("Object collection size: " + objectCollection.size() + "\nShuffled Col size: " + shuffledCollection.size());
        return shuffledCollection;
    }

    public static void KFoldCrossValidation2(Collection<Object> shuffledObjectTestCollection,int specificAlgorithm) throws NoSuchObjectException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        Collection<Object> KFoldTestCollection = new ArrayList<>();
        List listOfObjectCollection = new ArrayList(shuffledObjectTestCollection);

        for(int i = 0;i<listOfObjectCollection.size();i++){
            KFoldTestCollection.add(listOfObjectCollection.get(i));
            if(KFoldTestCollection.size() == 5 || i == listOfObjectCollection.size()-1){
                listOfObjectCollection.removeAll(KFoldTestCollection);
                calculateKFoldForSpecificCollection(listOfObjectCollection,KFoldTestCollection,specificAlgorithm);
                KFoldTestCollection.clear();
                listOfObjectCollection = new ArrayList(shuffledObjectTestCollection);
            }
        }

        System.out.println("Number of sample: " +numberOfSample +"\nNumber of Incorrect result: "+ numberOfIncorrectResult +"\nError rate: " + round(numberOfIncorrectResult/numberOfSample*100,2));
    }

    private static void calculateKFoldForSpecificCollection(Collection<Object> objectTestCollection, Collection<Object> sampleCollection,int specificAlgorithm) throws NoSuchObjectException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        for (Object object : sampleCollection) {
            numberOfSample = numberOfSample + 1;
            if (object instanceof Iris) {
                Iris iris = (Iris) object;
                String irisTypeTypedByAlgorithmForFirstCollection = new Similarity().calculateSimilarity(objectTestCollection, iris, specificAlgorithm);

                if (!irisTypeTypedByAlgorithmForFirstCollection.equals(iris.getSpecificClass())) {
                    numberOfIncorrectResult++;
                }
            } else if (object instanceof Wine) {
                Wine wine = (Wine) object;
                String wineTypeTypedByAlgorithmForFirstCollection = new Similarity().calculateSimilarity(objectTestCollection, wine, specificAlgorithm);

                if (!wineTypeTypedByAlgorithmForFirstCollection.equals(wine.getSpecificClass())) {
                    //System.out.println("Expect: " + wine.getSpecificClass() + "; Received: "+ wineTypeTypedByAlgorithmForFirstCollection + " typical params " + wine.getOD280OD315() + "," +wine.getProline());
                    System.out.println("Expect: " + wine.getSpecificClass() + " Received: "+ wineTypeTypedByAlgorithmForFirstCollection + " typical params; " + wine.getOD280OD315() + ";" +wine.getProline());
                    numberOfIncorrectResult++;
                }
            }else if (object instanceof TTOM) {
                TTOM ttom = (TTOM) object;
                String ttomTypeTypedByAlgorithmForFirstCollection = new Similarity().calculateSimilarity(objectTestCollection, ttom, specificAlgorithm);

                if (!ttomTypeTypedByAlgorithmForFirstCollection.equals(ttom.getSpecificClass())) {
                    numberOfIncorrectResult++;
                }
            }
            else if (object instanceof TTOMGrafana) {
                TTOMGrafana ttom = (TTOMGrafana) object;
                String ttomTypeTypedByAlgorithmForFirstCollection = new Similarity().calculateSimilarity(objectTestCollection, ttom, specificAlgorithm);

                if (!ttomTypeTypedByAlgorithmForFirstCollection.equals(ttom.getSpecificClass())) {
                    numberOfIncorrectResult++;
                }
            }
            else {
                throw new NoSuchObjectException("We don't support that type of object !\n Please implement missing functionality for object: " + object.getClass());
            }
        }
        //System.out.println("Number of sample: " + numberOfSample +"\nNumber of incorrect result: " + numberOfIncorrectResult);
    }

    public List<main.java.root.Similarity> quicksort(List<main.java.root.Similarity> input) {

        if (input.size() <= 1) {
            return input;
        }

        int middle = (int) Math.ceil((double) input.size() / 2);
        double pivot = input.get(middle).getSimilarity();

        List<main.java.root.Similarity> less = new ArrayList<>();
        List<main.java.root.Similarity> greater = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).getSimilarity() <= pivot) {
                if (i == middle) {
                    continue;
                }
                less.add(input.get(i));
            } else {
                greater.add(input.get(i));
            }
        }
        return concatenate(quicksort(less), input.get(middle), quicksort(greater));
    }

    private List<main.java.root.Similarity> concatenate(List<main.java.root.Similarity> less, main.java.root.Similarity pivot, List<main.java.root.Similarity> greater) {

        List<main.java.root.Similarity> list = new ArrayList<>();

        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }
        list.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }
        return list;
    }

    public Collection<Object> standardizationValue(Collection<Object> objectCollection) throws IllegalAccessException {

        //Collection<Object> standardizationIrisCollection = new HashSet<>();
        List<FieldNameAndValue> ussdList = calculateUnbiasedSampleStandardDeviation(objectCollection);
        List<FieldNameAndValue> arythmeticAverageList = calculateArythmeticAverage(objectCollection);
//        double ussdForSW = calculateUnbiasedSampleStandardDeviation(irisCollection,"SW");
//        double ussdForSL = calculateUnbiasedSampleStandardDeviation(irisCollection,"SL");
//        double ussdForPW = calculateUnbiasedSampleStandardDeviation(irisCollection,"PW");
//        double ussdForPL = calculateUnbiasedSampleStandardDeviation(irisCollection,"PL");
//
//        double arithmeticAverageForSW = calculateArythmeticAverage(irisCollection,"SW");
//        double arithmeticAverageForSL = calculateArythmeticAverage(irisCollection,"SL");
//        double arithmeticAverageForPW = calculateArythmeticAverage(irisCollection,"PW");
//        double arithmeticAverageForPL = calculateArythmeticAverage(irisCollection,"PL");

        for (Field f : objectCollection.iterator().next().getClass().getDeclaredFields()) {
            f.setAccessible(true);
            int indexOfUssd = 0;
            int indexOfArythmeticAverage = 0;

            for (int i = ussdList.size(); i == 0; i--) {
                if (ussdList.get(i).getFieldName().equals(f)) {
                    indexOfUssd = i;
                }
                if (arythmeticAverageList.get(i).getFieldName().equals(f)) {
                    indexOfArythmeticAverage = i;
                }
            }

            if (!f.getName().equals("specificClass")) {
                for (Object object : objectCollection) {
                    double fieldValue = (f.getDouble(object) - arythmeticAverageList.get(indexOfArythmeticAverage).getValue()) / ussdList.get(indexOfUssd).getValue();
                    f.setDouble(object, fieldValue);
                }
            }
        }
        return objectCollection;
    }

    public List<FieldNameAndValue> calculateUnbiasedSampleStandardDeviation(Collection<Object> objectsCollection) throws IllegalAccessException {

        try {
            List<FieldNameAndValue> fieldNameAndUUSDsList = new ArrayList<>();
            for (Field f : objectsCollection.iterator().next().getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (!f.getName().equals("specificClass")) {
                    double sumSquare = 0;
                    double sum = 0;
                    for (Object object : objectsCollection) {
                        double fieldValue = f.getDouble(object);
                        sumSquare = sumSquare + (Math.pow(fieldValue, 2));
                        sum = sum + fieldValue;
                    }

                    double ussd = Math.sqrt((objectsCollection.size() / (objectsCollection.size() - 1)) * ((sumSquare / objectsCollection.size()) - (Math.pow((sum / objectsCollection.size()), 2))));
                    System.out.println("Ussd: " + ussd + "Field name: " + f.getName());
                    fieldNameAndUUSDsList.add(new FieldNameAndValue(f.getName(), ussd));
                }
            }
            return fieldNameAndUUSDsList;
        } catch (IllegalAccessException iae) {
            throw new IllegalAccessException("Coś nie pykło :D" + iae);
        }
    }

    public List<FieldNameAndValue> calculateArythmeticAverage(Collection<Object> objectsCollection) throws IllegalAccessException {
        List<FieldNameAndValue> fieldNameAndUUSDsList = new ArrayList<>();
        for (Field f : objectsCollection.iterator().next().getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (!f.getName().equals("specificClass")) {
                double sum = 0;
                for (Object object : objectsCollection) {
                    sum = sum + f.getDouble(object);
                }
                fieldNameAndUUSDsList.add(new FieldNameAndValue(f.getName(), sum / objectsCollection.size()));
            }
        }
        return fieldNameAndUUSDsList;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public void prepareMapWithTypeAndCount(int numberOfNeighbours, List<Similarity> quicksort, Map<String, Integer> map) {
        for (int i = 0; i < numberOfNeighbours; i++) {
            String specificType = quicksort.get(i).getSpecificType();
            if (!map.containsKey(specificType))
                map.put(specificType, 0);
            else
                map.put(specificType, map.get(specificType) + 1);
        }
    }

    public String getMaxEntryInMap(Map<String, Integer> map) {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    public double getValueForStringInList(List<FieldNameAndValue> fieldNameAndWeight,String fieldName){
        for(FieldNameAndValue fnav: fieldNameAndWeight){
            if(fnav.getFieldName().equals(fieldName)){
                return fnav.getValue();
            }
        }
        return 0;
    }
//
//    public class utils.FieldNameAndValue {
//
//    }
}
