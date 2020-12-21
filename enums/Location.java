package enums;

public enum Location {
    ZMEEVKA("Змеевка"),
    FLOWERTOWN("Цветочный город"),
    GREENTOWN("Зеленый город");

    private String location;

    Location(String location){
        this.location = location;
    }
    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location='" + location + '\'' +
                '}';
    }
}
