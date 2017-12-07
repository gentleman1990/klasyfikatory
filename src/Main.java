import static utils.Utils.KFoldCrossValidation2;

import type.TTOMGrafana;
import utils.Utils;
import java.beans.IntrospectionException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.NoSuchObjectException;
import java.util.Collection;


/**
 * Created by Jakub on 2016-06-13.
 */
public class Main {


    public static void main(String args[]) throws IllegalAccessException, NoSuchObjectException, IntrospectionException, InvocationTargetException {
//      Check that list of arguments are correct
        if (args.length <= 0) {
            System.out.println("Correct number and type of parameters as an input: \n" +
                    "1: Path to learning set of data AS STRING\n" +
                    "2: File name of learning set AS STRING|CSV\n" +
                    "3: Algorithm type AS INT \n0 - Euclidesse\n1 - Taxi\n2 - Chebyshev\n" +
                    "4: Path to file with fresh data - starting from path to learning set of data");
            throw new IllegalArgumentException("Incorrect number of parameters");
        }

        String potentiallyObject = "";

//        Collection<Object> testobjectCollection = new ImportData().importToCollection("C:\\Users\\socha\\Documents\\DaneTestowe\\", "ttom_data_grafana.csv");
        Collection<Object> testObjectCollection = new ImportData().importToCollection(args[0], args[1]);

        Collection<Object> shuffleCollection = Utils.shuffleCollection(testObjectCollection);
        KFoldCrossValidation2(shuffleCollection, Integer.parseInt(args[2]));


        Collection<Object> freshObjectCollection = new ImportData().importToCollection(args[0], args[3]);
        switch (freshObjectCollection.size()){
            case 0: potentiallyObject = "notEnoughData\nnotEnoughData\nnotEnoughData";break;
            case 1: potentiallyObject = "notEnoughData\nnotEnoughData";break;
            case 2: potentiallyObject = "notEnoughData";break;
            default: potentiallyObject = "";break;
        }
        for (Object foc:freshObjectCollection)
        {
            if(foc instanceof TTOMGrafana){
                TTOMGrafana testTTOMObject = (TTOMGrafana)foc;
                //TTOMGrafana testTTOMObject = new TTOMGrafana(137.49, 1.13, 1.15, 487.28, 137.49, 290.67, 368.00, 296.00, 92.00, 570.67, 388.00, 412.09, 0.68, 0.21, 75.45, 412.30, 16.90, 100.00, 280.00, 92.00);
                potentiallyObject = potentiallyObject + "\n"+new Similarity().calculateSimilarity(testObjectCollection, testTTOMObject, 0);
                //System.out.println(potentiallyObject);
            }

        }


        try {
            File file = new File("result.csv");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(potentiallyObject);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//
//        new Similarity().calculateFieldWeight(testobjectCollection);
//        new utils.Utils().test(shuffleCollection,0);

    //Calculate similarity expect as a second parameter classifier:
    //0 - Euclidesse
    //1 - Taxi metric
    //2 - Chebyshev distance
//        Iris testIrisObject = new Iris(5.5,2.5,3.7,1.0);
//        String potentiallyFlower = new Similarity().calculateSimilarity(testobjectCollection,testIrisObject,1);
//        System.out.println("Type of the flower: " + potentiallyFlower);
//        String potentiallyFlowerAfterStandarization = new Similarity().calculateSimilarity(testIrisCollectionWithStandarization,testIrisObject,1);
//        System.out.println("Type of the flower after Standarization: " + potentiallyFlowerAfterStandarization);

//        type.Wine testWineObject = new type.Wine(12.99,1.67,2.6,30,139,3.3,2.89,.21,1.96,3.35,1.31,3.5,985,"2");
//        String potentiallyWine = new Similarity().calculateSimilarity(testobjectCollection,testWineObject,0);
//        System.out.println("Type of the wine: " + potentiallyWine);

    //K-fold cross-validation for Taxi

//        utils.Utils ut = new utils.Utils();
//        ut.shuffleAndDivideCollention(testobjectCollection);
//        ut.calculateUnbiasedSampleStandardDeviation(testobjectCollection);
//        ut.KFoldCrossValidation(1);
//
//        type.Iris testObject2 = new type.Iris(6.8,3.0,5.4,2.0);
//        String potentiallyFlower2 = testObject2.calculateSimilarityKNeighbors(testIrisCollection,0,7);
//        System.out.println("Type of the flower: " + potentiallyFlower2);

    //Euclidesse with standarization for 3 neighbour
    // Method calculateSimilarityKNeighbors parameters - collection of test data, test object, type of algorithm, number of neighbours
//        Iris testObject3 = new Iris(6.8,3.0,5.4,2.0);
//        String potentiallyFlower3 = new Similarity().calculateSimilarityKNeighbors(testIrisCollectionWithStandarization,testObject3,0,3);
//        System.out.println("Type of the flower: " + potentiallyFlower3);

    //K-fold cross-validation with standarization for Chebyshev

//        utils.Utils ut2 = new utils.Utils();
//        ut2.shuffleAndDivideCollention(testIrisCollectionWithStandarization);
//        ut2.KFoldCrossValidation(1);
}
