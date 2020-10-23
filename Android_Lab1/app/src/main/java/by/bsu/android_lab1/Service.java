package by.bsu.android_lab1;

public class Service {

    public static Integer calcSum(String nmb1, String nmb2) throws NullPointerException, IllegalArgumentException {
        if ((nmb1 == null) || (nmb2 == null)) {
            throw new NullPointerException();
        }
        if ((nmb1.equals("")) || (nmb2.equals(""))) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(nmb1) + Integer.parseInt(nmb2);
    }
}
