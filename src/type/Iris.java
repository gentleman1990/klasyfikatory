package type;

/**
 * Created by Jakub on 2016-06-13.
 */
public class Iris{
    double sepalLength = 0;
    double sepalWidth = 0;
    double petaLength = 0;
    double petalWidth = 0;
    String specificClass = "";

    public Iris(double sepalLength, double sepalWidth, double petaLength, double petalWidth, String specificClass) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petaLength = petaLength;
        this.petalWidth = petalWidth;
        this.specificClass = specificClass;
    }
    public Iris(double sepalLength, double sepalWidth, double petaLength, double petalWidth) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petaLength = petaLength;
        this.petalWidth = petalWidth;
        this.specificClass = "";
    }

    public Iris() {
        this.sepalLength = 5.1;
        this.sepalWidth = 3.5;
        this.petalWidth = 1.4;
        this.petaLength = 0.2;
        this.specificClass = "type.Iris-setosa";
    }


//    public String calculateSimilarity(Collection<Object> objectCollection, int typeOfClassificator) {
//        String objectType = "";
//        double similarity = 1000;
//        double currentSim = 0;
//        for (Object object : objectCollection) {
//            if(object instanceof type.Iris) {
//                type.Iris iris = (type.Iris)object;
//                switch (typeOfClassificator) {
//                    case 0:
//                        currentSim = calculateEuclidesSimilarity(iris);
//                    case 1:
//                        currentSim = calculateTaxiSimilarity(iris);
//                    case 2:
//                        currentSim = calculateChebyshevSimilarity(iris);
//                    default:
//                        currentSim = calculateEuclidesSimilarity(iris);
//                }
//                if (currentSim <= similarity) {
//                    objectType = iris.getSpecificClass();
//                    similarity = currentSim;
//                }
//            }
//        }
//        return objectType;
//    }

//    public String calculateSimilarityKNeighbors(Collection<Object> irisCollection, int typeOfClassificator, int numberOfNeighbours) {
//        List<Similarity> similarityList = new ArrayList<>();
//        for (type.Iris iris : irisCollection) {
//            switch(typeOfClassificator) {
//                case 0: similarityList.add(new Similarity(calculateEuclidesSimilarity(iris),iris.getSpecificClass()));break;
//                case 1: similarityList.add(new Similarity(calculateTaxiSimilarity(iris),iris.getSpecificClass()));break;
//                case 2: similarityList.add(new Similarity(calculateChebyshevSimilarity(iris),iris.getSpecificClass()));break;
//                default: similarityList.add(new Similarity(calculateEuclidesSimilarity(iris),iris.getSpecificClass()));break;
//            }
//        }
//
//        List<Similarity> quicksort = new utils.Utils().quicksort(similarityList);
//        Map <String,Integer> map = new HashMap <String,Integer> ();
//        try {
//            if (numberOfNeighbours == 1) {
//                return quicksort.get(0).getSpecificClass();
//            } else {
//                new utils.Utils().prepareMapWithTypeAndCount(numberOfNeighbours, quicksort, map);
//                return new utils.Utils().getMaxEntryInMap(map);
//            }
//        }
//        catch (Exception exception) {
//            System.out.println("Nice try !! Number of neighbours must be between 1 and maximum quantity of data !!!\n\n" + exception);
//        }
//        return "";
//    }

//    private void prepareMapWithTypeAndCount(int numberOfNeighbours, List<Similarity> quicksort, Map<String, Integer> map) {
//        for (int i = 0; i < numberOfNeighbours; i++) {
//            String specificClass = quicksort.get(i).getSpecificClass();
//            if(!map.containsKey(specificClass))
//                map.put(specificClass,0);
//            else
//                map.put(specificClass,map.get(specificClass)+1);
//        }
//    }
//
//    private String getMaxEntryInMap(Map<String, Integer> map) {
//        Map.Entry<String,Integer> maxEntry = null;
//        for (Map.Entry<String,Integer> entry : map.entrySet())
//        {
//            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
//            {
//                maxEntry = entry;
//            }
//        }
//        return maxEntry.getKey();
//    }

    public double calculateEuclidesSimilarity(Iris iris) {
        double sl = Math.pow((this.sepalLength - iris.getSepalLength()), 2);
        double sw = Math.pow((this.sepalWidth - iris.getSepalWidth()), 2);
        double pl = Math.pow((this.petaLength - iris.getPetaLength()), 2);
        double pw = Math.pow((this.petalWidth - iris.getPetalWidth()), 2);
        return Math.sqrt(round(sl,2)+round(sw,2)+round(pl,2)+round(pw,2));
    }

    public double calculateTaxiSimilarity(Iris iris) {
        return Math.abs(this.sepalLength - iris.getSepalLength()) + Math.abs(this.sepalWidth - iris.getSepalWidth()) +
                Math.abs(this.petaLength - iris.getPetaLength()) + Math.abs(this.petalWidth - iris.getPetalWidth());
    }
    public double calculateChebyshevSimilarity(Iris iris) {
        double sl = Math.abs(this.sepalLength - iris.getSepalLength());
        double sw = Math.abs(this.sepalWidth - iris.getSepalWidth());
        double pl = Math.abs(this.petaLength - iris.getPetaLength());
        double pw = Math.abs(this.petalWidth - iris.getPetalWidth());
        return Math.max(Math.max(Math.max(sl,sw),pl),pw);
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public double getPetaLength() {
        return petaLength;
    }

    public void setPetaLength(double petaLength) {
        this.petaLength = petaLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
    }

    public String getSpecificClass() {
        return specificClass;
    }

    public void setSpecificClass(String specificClass) {
        this.specificClass = specificClass;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
