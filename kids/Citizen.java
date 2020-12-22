package kids;

import enums.Location;
import exceptions.NoLegendException;
import java.util.Arrays;
import java.util.Objects;

public class Citizen extends Kid {

    public Citizen() {
        super("Жители Змеевки", Location.ZMEEVKA);
    }
    public Citizen(String name, Location location){
        super(name, location);
    }

    public boolean believeInLegend(){
        String[] tmp = getAllMemory();
        try {
            for(int i = 0; i<tmp.length; i++){
                String s = tmp[i];
                if (s == "Гвоздик побывал в Змеевка") {
                    throw new NoLegendException();
                }

            }
            return true;

        }catch (NoLegendException noLegendException){
            return false;
        }
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return getName().equals(citizen.getName()) &&
                getLocation() == citizen.getLocation();    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation());
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + getName() + '\'' +
                ", location=" + getLocation() +
                ", memory=" + Arrays.toString(getAllMemory()) +
                '}';
    }



}
