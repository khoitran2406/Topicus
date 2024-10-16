package Models.PracticeForm;

public enum City {
    DELHI("Delhi"),
    GURGAON("Gurgaon"),
    NOIDA("Noida"),
    AGRA("Agra"),
    LUCKNOW("Lucknow"),
    MERRUT("Merrut"),
    KARNAL("Karnal"),
    PANIPAT("Panipat");

    public final String value;

    City(String value) {
        this.value = value;
    }
}
