package type;

import static utils.Utils.round;

public class TTOMGrafana {

    String specificClass;
    double asyncBackendCommitTime;
    double asyncCommitQueueTimeBaseline;
    double asyncCommitQueueTimeCurrent;
    double asyncCommitResponseTimeBaseline;
    double asyncCommitResponseTimeCurrent;
    double asyncCommitThroughputBaseline;
    double asyncCommitThroughputCurrent;
    double asyncCommitThroughputOverallAsynchronous;
    double asyncCommitThroughputOverallSynchronous;
    double liveCommitThroughputBaseline;
    double liveCommitThroughputCurrent;
    double syncBackendCommitTime;
    double syncCommitQueueTimeBaseline;
    double syncCommitQueueTimeCurrent;
    double syncCommitResponseTimeBaseline;
    double syncCommitResponseTimeCurrent;
    double syncCommitSuccessRateAsynchronous;
    double syncCommitSuccessRateSynchronous;
    double syncCommitThroughputBaseline;
    double syncCommitThroughputCurrent;

    public TTOMGrafana(final double asyncBackendCommitTime, final double asyncCommitQueueTimeBaseline, final double asyncCommitQueueTimeCurrent, final double asyncCommitResponseTimeBaseline, final double asyncCommitResponseTimeCurrent, final double asyncCommitThroughputBaseline, final double asyncCommitThroughputCurrent, final double asyncCommitThroughputOverallAsynchronous, final double asyncCommitThroughputOverallSynchronous, final double liveCommitThroughputBaseline, final double liveCommitThroughputCurrent, final double syncBackendCommitTime, final double syncCommitQueueTimeBaseline, final double syncCommitQueueTimeCurrent, final double syncCommitResponseTimeBaseline, final double syncCommitResponseTimeCurrent, final double syncCommitSuccessRateAsynchronous, final double syncCommitSuccessRateSynchronous, final double syncCommitThroughputBaseline, final double syncCommitThroughputCurrent,final String specificClass) {
        this.specificClass = specificClass;
        this.asyncBackendCommitTime = asyncBackendCommitTime;
        this.asyncCommitQueueTimeBaseline = asyncCommitQueueTimeBaseline;
        this.asyncCommitQueueTimeCurrent = asyncCommitQueueTimeCurrent;
        this.asyncCommitResponseTimeBaseline = asyncCommitResponseTimeBaseline;
        this.asyncCommitResponseTimeCurrent = asyncCommitResponseTimeCurrent;
        this.asyncCommitThroughputBaseline = asyncCommitThroughputBaseline;
        this.asyncCommitThroughputCurrent = asyncCommitThroughputCurrent;
        this.asyncCommitThroughputOverallAsynchronous = asyncCommitThroughputOverallAsynchronous;
        this.asyncCommitThroughputOverallSynchronous = asyncCommitThroughputOverallSynchronous;
        this.liveCommitThroughputBaseline = liveCommitThroughputBaseline;
        this.liveCommitThroughputCurrent = liveCommitThroughputCurrent;
        this.syncBackendCommitTime = syncBackendCommitTime;
        this.syncCommitQueueTimeBaseline = syncCommitQueueTimeBaseline;
        this.syncCommitQueueTimeCurrent = syncCommitQueueTimeCurrent;
        this.syncCommitResponseTimeBaseline = syncCommitResponseTimeBaseline;
        this.syncCommitResponseTimeCurrent = syncCommitResponseTimeCurrent;
        this.syncCommitSuccessRateAsynchronous = syncCommitSuccessRateAsynchronous;
        this.syncCommitSuccessRateSynchronous = syncCommitSuccessRateSynchronous;
        this.syncCommitThroughputBaseline = syncCommitThroughputBaseline;
        this.syncCommitThroughputCurrent = syncCommitThroughputCurrent;
    }

    public TTOMGrafana(final double asyncBackendCommitTime, final double asyncCommitQueueTimeBaseline, final double asyncCommitQueueTimeCurrent, final double asyncCommitResponseTimeBaseline, final double asyncCommitResponseTimeCurrent, final double asyncCommitThroughputBaseline, final double asyncCommitThroughputCurrent, final double asyncCommitThroughputOverallAsynchronous, final double asyncCommitThroughputOverallSynchronous, final double liveCommitThroughputBaseline, final double liveCommitThroughputCurrent, final double syncBackendCommitTime, final double syncCommitQueueTimeBaseline, final double syncCommitQueueTimeCurrent, final double syncCommitResponseTimeBaseline, final double syncCommitResponseTimeCurrent, final double syncCommitSuccessRateAsynchronous, final double syncCommitSuccessRateSynchronous, final double syncCommitThroughputBaseline, final double syncCommitThroughputCurrent) {
        this.asyncBackendCommitTime = asyncBackendCommitTime;
        this.asyncCommitQueueTimeBaseline = asyncCommitQueueTimeBaseline;
        this.asyncCommitQueueTimeCurrent = asyncCommitQueueTimeCurrent;
        this.asyncCommitResponseTimeBaseline = asyncCommitResponseTimeBaseline;
        this.asyncCommitResponseTimeCurrent = asyncCommitResponseTimeCurrent;
        this.asyncCommitThroughputBaseline = asyncCommitThroughputBaseline;
        this.asyncCommitThroughputCurrent = asyncCommitThroughputCurrent;
        this.asyncCommitThroughputOverallAsynchronous = asyncCommitThroughputOverallAsynchronous;
        this.asyncCommitThroughputOverallSynchronous = asyncCommitThroughputOverallSynchronous;
        this.liveCommitThroughputBaseline = liveCommitThroughputBaseline;
        this.liveCommitThroughputCurrent = liveCommitThroughputCurrent;
        this.syncBackendCommitTime = syncBackendCommitTime;
        this.syncCommitQueueTimeBaseline = syncCommitQueueTimeBaseline;
        this.syncCommitQueueTimeCurrent = syncCommitQueueTimeCurrent;
        this.syncCommitResponseTimeBaseline = syncCommitResponseTimeBaseline;
        this.syncCommitResponseTimeCurrent = syncCommitResponseTimeCurrent;
        this.syncCommitSuccessRateAsynchronous = syncCommitSuccessRateAsynchronous;
        this.syncCommitSuccessRateSynchronous = syncCommitSuccessRateSynchronous;
        this.syncCommitThroughputBaseline = syncCommitThroughputBaseline;
        this.syncCommitThroughputCurrent = syncCommitThroughputCurrent;
    }

    public double calculateEuclidesSimilarity(TTOMGrafana ttom) {
        double asbct = Math.pow((this.asyncBackendCommitTime - ttom.getAsyncBackendCommitTime()), 2);
        double acqtb = Math.pow((this.asyncCommitQueueTimeBaseline - ttom.getAsyncCommitQueueTimeBaseline()), 2);
        double acqtc = Math.pow((this.asyncCommitQueueTimeCurrent - ttom.getAsyncCommitQueueTimeCurrent()), 2);
        double acrtb = Math.pow((this.asyncCommitResponseTimeBaseline - ttom.getAsyncCommitResponseTimeBaseline()), 2);
        double acrtc = Math.pow((this.asyncCommitResponseTimeCurrent - ttom.getAsyncCommitResponseTimeCurrent()), 2);
        double actb = Math.pow((this.asyncCommitThroughputBaseline - ttom.getAsyncCommitThroughputBaseline()), 2);
        double actc = Math.pow((this.asyncCommitThroughputCurrent - ttom.getAsyncCommitThroughputCurrent()), 2);
        double actoa = Math.pow((this.asyncCommitThroughputOverallAsynchronous - ttom.getAsyncCommitThroughputOverallAsynchronous()), 2);
        double actos = Math.pow((this.asyncCommitThroughputOverallSynchronous - ttom.getAsyncCommitThroughputOverallSynchronous()), 2);
        double lctb = Math.pow((this.liveCommitThroughputBaseline - ttom.getLiveCommitThroughputBaseline()), 2);
        double lctc = Math.pow((this.liveCommitThroughputCurrent - ttom.getLiveCommitThroughputCurrent()), 2);
        double sbct = Math.pow((this.syncBackendCommitTime - ttom.getSyncBackendCommitTime()), 2);
        double scqtb = Math.pow((this.syncCommitQueueTimeBaseline - ttom.getSyncCommitQueueTimeBaseline()), 2);
        double scqtc = Math.pow((this.syncCommitQueueTimeCurrent - ttom.getSyncCommitQueueTimeCurrent()), 2);
        double scrtb = Math.pow((this.syncCommitResponseTimeBaseline - ttom.getSyncCommitResponseTimeBaseline()), 2);
        double scrtc = Math.pow((this.syncCommitResponseTimeCurrent - ttom.getSyncCommitResponseTimeCurrent()), 2);
        double scsra = Math.pow((this.syncCommitSuccessRateAsynchronous - ttom.getSyncCommitSuccessRateAsynchronous()), 2);
        double scsrs = Math.pow((this.syncCommitSuccessRateSynchronous - ttom.getSyncCommitSuccessRateSynchronous()), 2);
        double sctb = Math.pow((this.syncCommitThroughputBaseline - ttom.getSyncCommitThroughputBaseline()), 2);
        double sctc = Math.pow((this.syncCommitThroughputCurrent - ttom.getSyncCommitThroughputCurrent()), 2);
        return Math.sqrt(round(asbct, 2) + round(acqtb, 2) + round(acqtc, 2) + round(acrtb, 2) + round(acrtc, 2) + round(actb, 2) + round(actc, 2) + round(actoa, 2) + round(actos, 2) + round(lctb, 2) + round(lctc, 2) + round(sbct, 2) + round(scqtb, 2) + round(scqtc, 2) + round(scrtb, 2) + round(scrtc, 2) + round(scsra, 2) + round(scsrs, 2) + round(sctb, 2) + round(sctc, 2));
    }

    public double calculateTaxiSimilarity(TTOMGrafana ttom) {
        return (Math.abs(this.asyncBackendCommitTime - ttom.getAsyncBackendCommitTime()) +
                Math.abs(this.asyncCommitQueueTimeBaseline - ttom.getAsyncCommitQueueTimeBaseline()) +
                Math.abs(this.asyncCommitQueueTimeCurrent - ttom.getAsyncCommitQueueTimeCurrent()) +
                Math.abs(this.asyncCommitResponseTimeBaseline - ttom.getAsyncCommitResponseTimeBaseline()) +
                Math.abs(this.asyncCommitResponseTimeCurrent - ttom.getAsyncCommitResponseTimeCurrent()) +
                Math.abs(this.asyncCommitThroughputBaseline - ttom.getAsyncCommitThroughputBaseline()) +
                Math.abs(this.asyncCommitThroughputCurrent - ttom.getAsyncCommitThroughputCurrent()) +
                Math.abs(this.asyncCommitThroughputOverallAsynchronous - ttom.getAsyncCommitThroughputOverallAsynchronous()) +
                Math.abs(this.asyncCommitThroughputOverallSynchronous - ttom.getAsyncCommitThroughputOverallSynchronous()) +
                Math.abs(this.liveCommitThroughputBaseline - ttom.getLiveCommitThroughputBaseline()) +
                Math.abs(this.liveCommitThroughputCurrent - ttom.getLiveCommitThroughputCurrent()) +
                Math.abs(this.syncBackendCommitTime - ttom.getSyncBackendCommitTime()) +
                Math.abs(this.syncCommitQueueTimeBaseline - ttom.getSyncCommitQueueTimeBaseline()) +
                Math.abs(this.syncCommitQueueTimeCurrent - ttom.getSyncCommitQueueTimeCurrent()) +
                Math.abs(this.syncCommitResponseTimeBaseline - ttom.getSyncCommitResponseTimeBaseline()) +
                Math.abs(this.syncCommitResponseTimeCurrent - ttom.getSyncCommitResponseTimeCurrent()) +
                Math.abs(this.syncCommitSuccessRateAsynchronous - ttom.getSyncCommitSuccessRateAsynchronous()) +
                Math.abs(this.syncCommitSuccessRateSynchronous - ttom.getSyncCommitSuccessRateSynchronous()) +
                Math.abs(this.syncCommitThroughputBaseline - ttom.getSyncCommitThroughputBaseline()) +
                Math.abs(this.syncCommitThroughputCurrent - ttom.getSyncCommitThroughputCurrent()));
    }
    public double calculateChebyshevSimilarity(TTOMGrafana ttom) {
        double asbct = Math.abs(this.asyncBackendCommitTime - ttom.getAsyncBackendCommitTime());
        double acqtb = Math.abs(this.asyncCommitQueueTimeBaseline - ttom.getAsyncCommitQueueTimeBaseline());
        double acqtc = Math.abs(this.asyncCommitQueueTimeCurrent - ttom.getAsyncCommitQueueTimeCurrent());
        double acrtb = Math.abs(this.asyncCommitResponseTimeBaseline - ttom.getAsyncCommitResponseTimeBaseline());
        double acrtc = Math.abs(this.asyncCommitResponseTimeCurrent - ttom.getAsyncCommitResponseTimeCurrent());
        double actb = Math.abs(this.asyncCommitThroughputBaseline - ttom.getAsyncCommitThroughputBaseline());
        double actc = Math.abs(this.asyncCommitThroughputCurrent - ttom.getAsyncCommitThroughputCurrent());
        double actoa = Math.abs(this.asyncCommitThroughputOverallAsynchronous - ttom.getAsyncCommitThroughputOverallAsynchronous());
        double actos = Math.abs(this.asyncCommitThroughputOverallSynchronous - ttom.getAsyncCommitThroughputOverallSynchronous());
        double lctb = Math.abs(this.liveCommitThroughputBaseline - ttom.getLiveCommitThroughputBaseline());
        double lctc = Math.abs(this.liveCommitThroughputCurrent - ttom.getLiveCommitThroughputCurrent());
        double sbct = Math.abs(this.syncBackendCommitTime - ttom.getSyncBackendCommitTime());
        double scqtb = Math.abs(this.syncCommitQueueTimeBaseline - ttom.getSyncCommitQueueTimeBaseline());
        double scqtc = Math.abs(this.syncCommitQueueTimeCurrent - ttom.getSyncCommitQueueTimeCurrent());
        double scrtb = Math.abs(this.syncCommitResponseTimeBaseline - ttom.getSyncCommitResponseTimeBaseline());
        double scrtc = Math.abs(this.syncCommitResponseTimeCurrent - ttom.getSyncCommitResponseTimeCurrent());
        double scsra = Math.abs(this.syncCommitSuccessRateAsynchronous - ttom.getSyncCommitSuccessRateAsynchronous());
        double scsrs = Math.abs(this.syncCommitSuccessRateSynchronous - ttom.getSyncCommitSuccessRateSynchronous());
        double sctb = Math.abs(this.syncCommitThroughputBaseline - ttom.getSyncCommitThroughputBaseline());
        double sctc = Math.abs(this.syncCommitThroughputCurrent - ttom.getSyncCommitThroughputCurrent());
        return Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(
                Math.max(sctc,sctb),scsrs),scsra),scrtc),scrtb),lctb),lctc),sbct),scqtb),scqtc),actos),actoa),actc),actb),acrtc),acqtc),acrtb),acqtb),asbct);
    }

    public String getSpecificClass() {
        return specificClass;
    }

    public void setSpecificClass(final String specificClass) {
        this.specificClass = specificClass;
    }

    public double getAsyncBackendCommitTime() {
        return asyncBackendCommitTime;
    }

    public void setAsyncBackendCommitTime(final double asyncBackendCommitTime) {
        this.asyncBackendCommitTime = asyncBackendCommitTime;
    }

    public double getAsyncCommitQueueTimeBaseline() {
        return asyncCommitQueueTimeBaseline;
    }

    public void setAsyncCommitQueueTimeBaseline(final double asyncCommitQueueTimeBaseline) {
        this.asyncCommitQueueTimeBaseline = asyncCommitQueueTimeBaseline;
    }

    public double getAsyncCommitQueueTimeCurrent() {
        return asyncCommitQueueTimeCurrent;
    }

    public void setAsyncCommitQueueTimeCurrent(final double asyncCommitQueueTimeCurrent) {
        this.asyncCommitQueueTimeCurrent = asyncCommitQueueTimeCurrent;
    }

    public double getAsyncCommitResponseTimeBaseline() {
        return asyncCommitResponseTimeBaseline;
    }

    public void setAsyncCommitResponseTimeBaseline(final double asyncCommitResponseTimeBaseline) {
        this.asyncCommitResponseTimeBaseline = asyncCommitResponseTimeBaseline;
    }

    public double getAsyncCommitResponseTimeCurrent() {
        return asyncCommitResponseTimeCurrent;
    }

    public void setAsyncCommitResponseTimeCurrent(final double asyncCommitResponseTimeCurrent) {
        this.asyncCommitResponseTimeCurrent = asyncCommitResponseTimeCurrent;
    }

    public double getAsyncCommitThroughputBaseline() {
        return asyncCommitThroughputBaseline;
    }

    public void setAsyncCommitThroughputBaseline(final double asyncCommitThroughputBaseline) {
        this.asyncCommitThroughputBaseline = asyncCommitThroughputBaseline;
    }

    public double getAsyncCommitThroughputCurrent() {
        return asyncCommitThroughputCurrent;
    }

    public void setAsyncCommitThroughputCurrent(final double asyncCommitThroughputCurrent) {
        this.asyncCommitThroughputCurrent = asyncCommitThroughputCurrent;
    }

    public double getAsyncCommitThroughputOverallAsynchronous() {
        return asyncCommitThroughputOverallAsynchronous;
    }

    public void setAsyncCommitThroughputOverallAsynchronous(final double asyncCommitThroughputOverallAsynchronous) {
        this.asyncCommitThroughputOverallAsynchronous = asyncCommitThroughputOverallAsynchronous;
    }

    public double getAsyncCommitThroughputOverallSynchronous() {
        return asyncCommitThroughputOverallSynchronous;
    }

    public void setAsyncCommitThroughputOverallSynchronous(final double asyncCommitThroughputOverallSynchronous) {
        this.asyncCommitThroughputOverallSynchronous = asyncCommitThroughputOverallSynchronous;
    }

    public double getLiveCommitThroughputBaseline() {
        return liveCommitThroughputBaseline;
    }

    public void setLiveCommitThroughputBaseline(final double liveCommitThroughputBaseline) {
        this.liveCommitThroughputBaseline = liveCommitThroughputBaseline;
    }

    public double getLiveCommitThroughputCurrent() {
        return liveCommitThroughputCurrent;
    }

    public void setLiveCommitThroughputCurrent(final double liveCommitThroughputCurrent) {
        this.liveCommitThroughputCurrent = liveCommitThroughputCurrent;
    }

    public double getSyncBackendCommitTime() {
        return syncBackendCommitTime;
    }

    public void setSyncBackendCommitTime(final double syncBackendCommitTime) {
        this.syncBackendCommitTime = syncBackendCommitTime;
    }

    public double getSyncCommitQueueTimeBaseline() {
        return syncCommitQueueTimeBaseline;
    }

    public void setSyncCommitQueueTimeBaseline(final double syncCommitQueueTimeBaseline) {
        this.syncCommitQueueTimeBaseline = syncCommitQueueTimeBaseline;
    }

    public double getSyncCommitQueueTimeCurrent() {
        return syncCommitQueueTimeCurrent;
    }

    public void setSyncCommitQueueTimeCurrent(final double syncCommitQueueTimeCurrent) {
        this.syncCommitQueueTimeCurrent = syncCommitQueueTimeCurrent;
    }

    public double getSyncCommitResponseTimeBaseline() {
        return syncCommitResponseTimeBaseline;
    }

    public void setSyncCommitResponseTimeBaseline(final double syncCommitResponseTimeBaseline) {
        this.syncCommitResponseTimeBaseline = syncCommitResponseTimeBaseline;
    }

    public double getSyncCommitResponseTimeCurrent() {
        return syncCommitResponseTimeCurrent;
    }

    public void setSyncCommitResponseTimeCurrent(final double syncCommitResponseTimeCurrent) {
        this.syncCommitResponseTimeCurrent = syncCommitResponseTimeCurrent;
    }

    public double getSyncCommitSuccessRateAsynchronous() {
        return syncCommitSuccessRateAsynchronous;
    }

    public void setSyncCommitSuccessRateAsynchronous(final double syncCommitSuccessRateAsynchronous) {
        this.syncCommitSuccessRateAsynchronous = syncCommitSuccessRateAsynchronous;
    }

    public double getSyncCommitSuccessRateSynchronous() {
        return syncCommitSuccessRateSynchronous;
    }

    public void setSyncCommitSuccessRateSynchronous(final double syncCommitSuccessRateSynchronous) {
        this.syncCommitSuccessRateSynchronous = syncCommitSuccessRateSynchronous;
    }

    public double getSyncCommitThroughputBaseline() {
        return syncCommitThroughputBaseline;
    }

    public void setSyncCommitThroughputBaseline(final double syncCommitThroughputBaseline) {
        this.syncCommitThroughputBaseline = syncCommitThroughputBaseline;
    }

    public double getSyncCommitThroughputCurrent() {
        return syncCommitThroughputCurrent;
    }

    public void setSyncCommitThroughputCurrent(final double syncCommitThroughputCurrent) {
        this.syncCommitThroughputCurrent = syncCommitThroughputCurrent;
    }
}
