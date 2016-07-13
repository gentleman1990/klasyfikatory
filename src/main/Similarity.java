package main;

import type.Iris;
import type.TTOM;
import type.TTOMGrafana;
import type.Wine;
import utils.FieldNameAndValue;
import utils.Utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.rmi.NoSuchObjectException;
import java.util.*;

/**
 * Created by Jakub on 2016-06-14.
 */
public class Similarity implements Comparable<Similarity> {


    private double similarity;
    private String specificType;

    public Similarity() {
        this.similarity = 10000000;
        this.specificType = "";
    }

    public Similarity(double similarity, String specificType) {
        this.similarity = similarity;
        this.specificType = specificType;
    }

    public double getSimilarity() {
        return similarity;
    }

    public String getSpecificType() {
        return specificType;
    }

    @Override
    public int compareTo(Similarity o) {
        if (similarity > o.similarity)
            return 0;
        else
            return 1;
    }

    public String calculateSimilarity(Collection<Object> objectCollection, Object researchFacility, int typeOfClassificator) throws NoSuchObjectException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String objectType = "";
        double similarity = 10000000;
        double currentSim = 0;
        //List<FieldNameAndValue> calculatedFieldWeight = new Similarity().calculateFieldWeight(objectCollection);
        for (Object object : objectCollection) {
            if (object instanceof Iris) {
                Iris iris = (Iris) object;
                Iris rf = (Iris) researchFacility;
                switch (typeOfClassificator) {
                    case 0:
                        currentSim = rf.calculateEuclidesSimilarity(iris);
                        break;
                    case 1:
                        currentSim = rf.calculateTaxiSimilarity(iris);
                        break;
                    case 2:
                        currentSim = rf.calculateChebyshevSimilarity(iris);
                        break;
                    default:
                        currentSim = rf.calculateEuclidesSimilarity(iris);
                        break;
                }
                if (currentSim <= similarity) {
                    objectType = iris.getSpecificClass();
                    similarity = currentSim;
                }
            } else if (object instanceof Wine) {
                Wine wine = (Wine) object;
                Wine rf = (Wine) researchFacility;
                switch (typeOfClassificator) {
                    case 0:
                        //currentSim = rf.calculateEuclidesSimilarityWithWeight(wine,calculatedFieldWeight);
                        currentSim = rf.calculateEuclidesSimilarity(wine);
                        //System.out.println(currentSim + ";" + rf.getSpecificClass() + ";" + wine.getSpecificClass());
                        break;
                    case 1:
                        currentSim = rf.calculateTaxiSimilarity(wine);
                        break;
                    case 2:
                        currentSim = rf.calculateChebyshevSimilarity(wine);
                        break;
                    default:
                        currentSim = rf.calculateEuclidesSimilarity(wine);
                        break;
                }
                if (currentSim <= similarity) {
                    objectType = wine.getSpecificClass();
                    similarity = currentSim;
                }
            } else if (object instanceof TTOM) {
                TTOM ttom = (TTOM) object;
                TTOM rf = (TTOM) researchFacility;
                switch (typeOfClassificator) {
                    case 0:
                        currentSim = rf.calculateEuclidesSimilarity(ttom);
                        break;
                    case 1:
                        currentSim = rf.calculateTaxiSimilarity(ttom);
                        break;
                    case 2:
                        currentSim = rf.calculateChebyshevSimilarity(ttom);
                        break;
                    default:
                        currentSim = rf.calculateEuclidesSimilarity(ttom);
                        break;
                }

                if (currentSim <= similarity) {
                    objectType = ttom.getSpecificClass();
                    similarity = currentSim;
                }

            } else if (object instanceof TTOMGrafana) {
                TTOMGrafana ttom = (TTOMGrafana) object;
                TTOMGrafana rf = (TTOMGrafana) researchFacility;
                switch (typeOfClassificator) {
                    case 0:
                        currentSim = rf.calculateEuclidesSimilarity(ttom);
                        //System.out.println(currentSim);
                        break;
                    case 1:
                        currentSim = rf.calculateTaxiSimilarity(ttom);
                        break;
                    case 2:
                        currentSim = rf.calculateChebyshevSimilarity(ttom);
                        break;
                    default:
                        currentSim = rf.calculateEuclidesSimilarity(ttom);
                        break;
                }

                if (currentSim <= similarity) {
                    objectType = ttom.getSpecificClass();
                    similarity = currentSim;
                }

            }
            else {
                throw new NoSuchObjectException("We don't support that type of object !\n Please implement missing functionality for object: " + object.getClass());
            }
        }
        return objectType;
    }

    public String calculateSimilarityKNeighbors(Collection<Object> objectCollection, Object researchFacility, int typeOfClassificator, int numberOfNeighbours) throws NoSuchObjectException {
        List<Similarity> similarityList = new ArrayList<>();
        for (Object object : objectCollection) {
            if (object instanceof Iris) {
                Iris iris = (Iris) object;
                Iris rs = (Iris) researchFacility;
                switch (typeOfClassificator) {
                    case 0:
                        similarityList.add(new Similarity(rs.calculateEuclidesSimilarity(iris), iris.getSpecificClass()));
                        break;
                    case 1:
                        similarityList.add(new Similarity(rs.calculateTaxiSimilarity(iris), iris.getSpecificClass()));
                        break;
                    case 2:
                        similarityList.add(new Similarity(rs.calculateChebyshevSimilarity(iris), iris.getSpecificClass()));
                        break;
                    default:
                        similarityList.add(new Similarity(rs.calculateEuclidesSimilarity(iris), iris.getSpecificClass()));
                        break;
                }
            } else if (object instanceof Wine) {
                Wine wine = (Wine) object;
                Wine rs = (Wine) researchFacility;
                switch (typeOfClassificator) {
                    case 0:
                        similarityList.add(new Similarity(rs.calculateEuclidesSimilarity(wine), wine.getSpecificClass()));
                        break;
                    case 1:
                        similarityList.add(new Similarity(rs.calculateTaxiSimilarity(wine), wine.getSpecificClass()));
                        break;
                    case 2:
                        similarityList.add(new Similarity(rs.calculateChebyshevSimilarity(wine), wine.getSpecificClass()));
                        break;
                    default:
                        similarityList.add(new Similarity(rs.calculateEuclidesSimilarity(wine), wine.getSpecificClass()));
                        break;
                }
            } else if (object instanceof TTOM) {
                TTOM ttom = (TTOM) object;
                TTOM rs = (TTOM) researchFacility;
                switch (typeOfClassificator) {
                    case 0:
                        similarityList.add(new Similarity(rs.calculateEuclidesSimilarity(ttom), ttom.getSpecificClass()));
                        break;
                    case 1:
                        similarityList.add(new Similarity(rs.calculateTaxiSimilarity(ttom), ttom.getSpecificClass()));
                        break;
                    case 2:
                        similarityList.add(new Similarity(rs.calculateChebyshevSimilarity(ttom), ttom.getSpecificClass()));
                        break;
                    default:
                        similarityList.add(new Similarity(rs.calculateEuclidesSimilarity(ttom), ttom.getSpecificClass()));
                        break;
                }
            }
            else if (object instanceof TTOMGrafana) {
                TTOMGrafana ttom = (TTOMGrafana) object;
                TTOMGrafana rs = (TTOMGrafana) researchFacility;
                switch (typeOfClassificator) {
                    case 0:
                        similarityList.add(new Similarity(rs.calculateEuclidesSimilarity(ttom), ttom.getSpecificClass()));
                        break;
                    case 1:
                        similarityList.add(new Similarity(rs.calculateTaxiSimilarity(ttom), ttom.getSpecificClass()));
                        break;
                    case 2:
                        similarityList.add(new Similarity(rs.calculateChebyshevSimilarity(ttom), ttom.getSpecificClass()));
                        break;
                    default:
                        similarityList.add(new Similarity(rs.calculateEuclidesSimilarity(ttom), ttom.getSpecificClass()));
                        break;
                }
            }
            else {
                throw new NoSuchObjectException("We don't support that type of object !\n Please implement missing functionality for object: " + object.getClass());
            }
        }

        List<main.Similarity> quicksort = new Utils().quicksort(similarityList);
        Map<String, Integer> map = new HashMap<String, Integer>();
        try {
            if (numberOfNeighbours == 1) {
                return quicksort.get(0).getSpecificType();
            } else {
                new Utils().prepareMapWithTypeAndCount(numberOfNeighbours, quicksort, map);
                return new Utils().getMaxEntryInMap(map);
            }
        } catch (Exception exception) {
            System.out.println("Nice try !! Number of neighbours must be between 1 and maximum quantity of data !!!\n\n" + exception);
        }
        return "";
    }

    public List<FieldNameAndValue> calculateFieldWeight(Collection<Object> objectCollection) throws NoSuchObjectException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        List<Double> valuesForSingleField = new ArrayList<>();
        List<FieldNameAndValue> arythmeticAverageForFields = new Utils().calculateArythmeticAverage(objectCollection);
        List<FieldNameAndValue> fieldNameAndPercentages = new ArrayList<>();
        Double sumAllFieldsValue = 0.0;
        for (Field f : objectCollection.iterator().next().getClass().getDeclaredFields()) {
            f.setAccessible(true);
            for (Object object: objectCollection) {
                if(!f.getName().equals("specificClass")) {
                    if(object instanceof Iris){
                        Object invoke = new PropertyDescriptor(f.getName(), Iris.class).getReadMethod().invoke(object);
                        valuesForSingleField.add(Double.parseDouble(invoke.toString()));
                    }
                    else if(object instanceof Wine) {
                        Object invoke = new PropertyDescriptor(f.getName(), Wine.class).getReadMethod().invoke(object);
                        valuesForSingleField.add(Double.parseDouble(invoke.toString()));
                    }
                    else if(object instanceof TTOMGrafana) {
                        Object invoke = new PropertyDescriptor(f.getName(), TTOMGrafana.class).getReadMethod().invoke(object);
                        valuesForSingleField.add(Double.parseDouble(invoke.toString()));
                    }
                    else {
                        throw new NoSuchObjectException("We don't support that type of object !\n Please implement missing functionality for object: " + object.getClass());
                    }
                }
            }
            if(!f.getName().equals("specificClass")) {
                Double max = Collections.max(valuesForSingleField);
                Double min = Collections.min(valuesForSingleField);
                Double avg = 0.0;
                for (FieldNameAndValue fnav : arythmeticAverageForFields) {
                    if (fnav.getFieldName().equals(f.getName())) {
                        avg = fnav.getValue();
                    }
                }
                Double percentage = ((max - avg) / avg);
                sumAllFieldsValue = sumAllFieldsValue + percentage;
                fieldNameAndPercentages.add(new FieldNameAndValue(f.getName(), percentage));
            }
            valuesForSingleField.clear();
        }
        List<FieldNameAndValue> fieldNameAndWeight= new ArrayList<>();
        for(FieldNameAndValue fnav : fieldNameAndPercentages){
            fieldNameAndWeight.add(new FieldNameAndValue(fnav.getFieldName(),fnav.getValue()/sumAllFieldsValue));
        }

        return fieldNameAndWeight;
    }


}
