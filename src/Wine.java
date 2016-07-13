/**
 * Created by Jakub on 2016-06-15.
 */
public class Wine {
    String specificClass;
    double alcohol;
    double malicAcid;
    double ash;
    double alcalinityOfAsh  ;
    double magnesium;
    double totalPhenols;
    double flavanoids;
    double nonflavanoidPhenols;
    double proanthocyanins;
    double colorIntensity;
    double hue;
    double OD280OD315;
    double proline ;

    public Wine(double alcalinityOfAsh, double alcohol, double ash, double colorIntensity, double flavanoids, double hue, double magnesium, double malicAcid, double nonflavanoidPhenols, double OD280OD315, double proanthocyanins, double proline, double totalPhenols,String specificClass) {
        this.alcalinityOfAsh = alcalinityOfAsh;
        this.alcohol = alcohol;
        this.ash = ash;
        this.colorIntensity = colorIntensity;
        this.flavanoids = flavanoids;
        this.hue = hue;
        this.magnesium = magnesium;
        this.malicAcid = malicAcid;
        this.nonflavanoidPhenols = nonflavanoidPhenols;
        this.OD280OD315 = OD280OD315;
        this.proanthocyanins = proanthocyanins;
        this.proline = proline;
        this.totalPhenols = totalPhenols;
        this.specificClass = specificClass;
    }
    public Wine(double alcalinityOfAsh, double alcohol, double ash, double colorIntensity, double flavanoids, double hue, double magnesium, double malicAcid, double nonflavanoidPhenols, double OD280OD315, double proanthocyanins, double proline, double totalPhenols) {
        this.alcalinityOfAsh = alcalinityOfAsh;
        this.alcohol = alcohol;
        this.ash = ash;
        this.colorIntensity = colorIntensity;
        this.flavanoids = flavanoids;
        this.hue = hue;
        this.magnesium = magnesium;
        this.malicAcid = malicAcid;
        this.nonflavanoidPhenols = nonflavanoidPhenols;
        this.OD280OD315 = OD280OD315;
        this.proanthocyanins = proanthocyanins;
        this.proline = proline;
        this.totalPhenols = totalPhenols;
        this.specificClass = "";
    }

    public double calculateEuclidesSimilarity(Wine wine) {
        double alca = Math.pow((this.alcalinityOfAsh - wine.getAlcalinityOfAsh()),2);
        double alco = Math.pow((this.alcohol - wine.getAlcohol()),2);
        double ash = Math.pow((this.ash - wine.getAsh()),2);
        double col = Math.pow((this.colorIntensity - wine.getColorIntensity()),2);
        double flav = Math.pow((this.flavanoids - wine.getFlavanoids()),2);
        double hue = Math.pow((this.hue - wine.getHue()),2);
        double mag = Math.pow((this.magnesium - wine.getMagnesium()),2);
        double mal = Math.pow((this.malicAcid - wine.getMalicAcid()),2);
        double non = Math.pow((this.nonflavanoidPhenols - wine.getNonflavanoidPhenols()),2);
        double od = Math.pow((this.OD280OD315 - wine.getOD280OD315()),2);
        double proa = Math.pow((this.proanthocyanins - wine.getProanthocyanins()),2);
        double prol = Math.pow((this.proline - wine.getProline()),2);
        double tot = Math.pow((this.totalPhenols - wine.getTotalPhenols()),2);
        return Math.sqrt(round(alca,2)+round(alco,2)+round(ash,2)+round(col,2)+round(flav,2)+round(hue,2)+round(mag,2)+round(mal,2)+round(non,2)+round(od,2)+round(proa,2)+round(prol,2)+round(tot,2));
    }

    public double calculateTaxiSimilarity(Wine wine) {
        return Math.abs(this.alcalinityOfAsh - wine.getAlcalinityOfAsh()) + Math.abs(this.alcohol - wine.getAlcohol()) + Math.abs(this.ash - wine.getAsh()) +
                Math.abs(this.colorIntensity - wine.getColorIntensity()) + Math.abs(this.flavanoids - wine.getFlavanoids()) + Math.abs(this.hue - wine.getHue()) +
                Math.abs(this.magnesium - wine.getMagnesium()) + Math.abs(this.malicAcid - wine.getMalicAcid()) + Math.abs(this.nonflavanoidPhenols - wine.getNonflavanoidPhenols()) +
                Math.abs(this.OD280OD315 - wine.getOD280OD315()) + Math.abs(this.proanthocyanins - wine.getProanthocyanins()) + Math.abs(this.proline - wine.getProline()) +
                Math.abs(this.totalPhenols - wine.getTotalPhenols());
    }
    public double calculateChebyshevSimilarity(Wine wine) {
        double alca = Math.abs(this.alcalinityOfAsh - wine.getAlcalinityOfAsh());
        double alco = Math.abs(this.alcohol - wine.getAlcohol());
        double ash  = Math.abs(this.ash - wine.getAsh());
        double col = Math.abs(this.colorIntensity - wine.getColorIntensity());
        double flav = Math.abs(this.flavanoids - wine.getFlavanoids());
        double hue = Math.abs(this.hue - wine.getHue());
        double mag = Math.abs(this.magnesium - wine.getMagnesium());
        double mal = Math.abs(this.malicAcid - wine.getMalicAcid());
        double non = Math.abs(this.nonflavanoidPhenols - wine.getNonflavanoidPhenols());
        double od = Math.abs(this.OD280OD315 - wine.getOD280OD315());
        double proa = Math.abs(this.proanthocyanins - wine.getProanthocyanins());
        double prol = Math.abs(this.proline - wine.getProline());
        double tot = Math.abs(this.totalPhenols - wine.getTotalPhenols());
        return Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(tot,prol),proa),od),non),mal),mag),hue),flav),col),ash),alco),alca);
    }


    public double getAlcalinityOfAsh() {
        return alcalinityOfAsh;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public double getAsh() {
        return ash;
    }

    public double getColorIntensity() {
        return colorIntensity;
    }

    public double getFlavanoids() {
        return flavanoids;
    }

    public double getHue() {
        return hue;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public double getMalicAcid() {
        return malicAcid;
    }

    public double getNonflavanoidPhenols() {
        return nonflavanoidPhenols;
    }

    public double getOD280OD315() {
        return OD280OD315;
    }

    public double getProanthocyanins() {
        return proanthocyanins;
    }

    public double getProline() {
        return proline;
    }

    public String getSpecificClass() {
        return specificClass;
    }

    public double getTotalPhenols() {
        return totalPhenols;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
