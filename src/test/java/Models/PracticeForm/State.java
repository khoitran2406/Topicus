package Models.PracticeForm;

public enum State {
    NCR("NCR"),
    UTTAR_PRADESH("Uttar Pradesh"),
    Haryana("HARYANA"),
    Rajasthan("RAJASTHAN");

    public final String value;

    State(String value) {
        this.value = value;
    }
}
