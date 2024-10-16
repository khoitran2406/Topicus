package Models.PracticeForm;

public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    public final int value;

    Gender(int value) {
        this.value = value;
    }
}
