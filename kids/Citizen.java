package kids;

import enums.Location;
import interfaces.AbleToUpdate;
import interfaces.EventManage;
import story.Legend;
import story.OnceStoryObject;

import java.util.Arrays;
import java.util.Objects;

public class Citizen extends Kid{

    public Citizen() {
        super("Жители Змеевки", Location.ZMEEVKA);
    }
    public Citizen(String name, Location location){
        super(name, location);
        AbleToUpdate able = new AbleToUpdate() {
            @Override
            public void update(Object event) {
                if(event instanceof Mechanic || event instanceof OnceStoryObject.Balloon || event instanceof Legend || event instanceof Gvozdik) {
                    Citizen.this.getMyMemory().add(event);
                }
            }
        };
        EventManage.addSubscriber(able);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return getName().equals(citizen.getName()) &&
                getLocation() == citizen.getLocation();
    }

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
