package type;

/**
 * Created by Jakub on 2016-06-20.
 */
public class TTOM {
    int ratio;
    int qaTime;
    int commitTime ;
    int averageCommitTime ;
    int numOfQaCall;
    int numOfCommitCall;
    String specificClass;


    public TTOM(int averageCommitTime, int commitTime, int numOfCommitCall, int numOfQaCall, int qaTime, int ratio) {
        this.averageCommitTime = averageCommitTime;
        this.commitTime = commitTime;
        this.numOfCommitCall = numOfCommitCall;
        this.numOfQaCall = numOfQaCall;
        this.qaTime = qaTime;
        this.ratio = ratio;
    }
    public TTOM(int averageCommitTime, int commitTime, int numOfCommitCall, int numOfQaCall, int qaTime, int ratio,String specificClass) {
        this.averageCommitTime = averageCommitTime;
        this.commitTime = commitTime;
        this.numOfCommitCall = numOfCommitCall;
        this.numOfQaCall = numOfQaCall;
        this.qaTime = qaTime;
        this.ratio = ratio;
        this.specificClass = specificClass;
    }

    public double calculateEuclidesSimilarity(TTOM ttom) {
        double rat = Math.pow((this.ratio - ttom.getRatio()), 2);
        double qat = Math.pow((this.qaTime - ttom.getQaTime()), 2);
        double ct = Math.pow((this.commitTime - ttom.getCommitTime()), 2);
        double act = Math.pow((this.averageCommitTime - ttom.getAverageCommitTime()), 2);
        double nqc = Math.pow((this.numOfQaCall - ttom.getNumOfQaCall()), 2);
        double ncc = Math.pow((this.numOfCommitCall - ttom.getNumOfCommitCall()), 2);
        return Math.sqrt(round(rat,2)+round(qat,2)+round(ct,2)+round(act,2)+round(nqc,2)+round(ncc,2));
    }

    public double calculateTaxiSimilarity(TTOM ttom) {
        return Math.abs(this.ratio - ttom.getRatio()) + Math.abs(this.qaTime - ttom.getQaTime()) +
                Math.abs(this.commitTime - ttom.getCommitTime()) + Math.abs(this.averageCommitTime - ttom.getAverageCommitTime())
                + Math.abs(this.numOfQaCall - ttom.getNumOfQaCall()) + Math.abs(this.numOfCommitCall - ttom.getNumOfCommitCall());
    }
    public double calculateChebyshevSimilarity(TTOM ttom) {
        double rat = Math.abs(this.ratio - ttom.getRatio());
        double qat = Math.abs(this.qaTime - ttom.getQaTime());
        double ct = Math.abs(this.commitTime - ttom.getCommitTime());
        double act = Math.abs(this.averageCommitTime - ttom.getAverageCommitTime());
        double nqc = Math.abs(this.numOfQaCall - ttom.getNumOfQaCall());
        double ncc = Math.abs(this.numOfCommitCall - ttom.getNumOfCommitCall());
        return Math.max(Math.max(Math.max(Math.max(Math.max(ncc,nqc),act),ct),qat),rat);
    }

    public int getAverageCommitTime() {
        return averageCommitTime;
    }

    public int getCommitTime() {
        return commitTime;
    }

    public int getNumOfCommitCall() {
        return numOfCommitCall;
    }

    public int getNumOfQaCall() {
        return numOfQaCall;
    }

    public int getQaTime() {
        return qaTime;
    }

    public int getRatio() {
        return ratio;
    }

    public String getSpecificClass() {
        return specificClass;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
