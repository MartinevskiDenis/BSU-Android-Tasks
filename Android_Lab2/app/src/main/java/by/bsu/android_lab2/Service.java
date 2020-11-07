package by.bsu.android_lab2;

public class Service {

    public static Integer calcSum(String nmb1, String nmb2) throws NullPointerException, IllegalArgumentException {
        return Integer.parseInt(nmb1) + Integer.parseInt(nmb2);
    }

}