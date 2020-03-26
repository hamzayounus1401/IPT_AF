package com.example.ipt_aa.data;

public class Marks {
    String testName;
    String obtained;
    String total;
    String weitage;
    String average;
    String standardDeviation;
    String min;
    String max;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getObtained() {
        return obtained;
    }

    public void setObtained(String obtained) {
        this.obtained = obtained;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getWeitage() {
        return weitage;
    }

    public void setWeitage(String weitage) {
        this.weitage = weitage;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(String standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public Marks() {
    }

    public Marks(String testName, String obtained, String total, String weitage, String average, String standardDeviation, String min, String max) {
        this.testName = testName;
        this.obtained = obtained;
        this.total = total;
        this.weitage = weitage;
        this.average = average;
        this.standardDeviation = standardDeviation;
        this.min = min;
        this.max = max;
    }
}
