package kids;

import enums.Location;
import exceptions.InvalidParameterException;
import interfaces.AbleToUpdate;
import interfaces.EventManage;

import java.util.Objects;
import java.util.stream.Stream;

public final class Bublick extends Citizen {
    private String remembrance = " побывал в " + Location.ZMEEVKA.getLocation();

    public Bublick() {
        super("Бублик", Location.GREENTOWN);
        AbleToUpdate able = new AbleToUpdate() {
            @Override
            public void update(Object event) {
                if(event instanceof Mechanic){
                    Bublick.this.getMyMemory().add(event);
                }
            }
        };
        EventManage.addSubscriber(able);
    }

    public void driveWith(Kid[] passengers)throws InvalidParameterException{
        setLocation(Location.ZMEEVKA);
        Stream.of(passengers)
                .forEach(pass -> {
                    if(pass == null){throw new InvalidParameterException("Попытка отвезти несуществующего пассажира.");
                    };
                });

        Stream.of(passengers)
                .forEach(mech -> {
                    Mechanic mechanic = (Mechanic) mech;
                    mechanic.setLocation(Location.ZMEEVKA);
                    mechanic.find();
                    EventManage.addEvent(mechanic);
                });

    }

    public String getRemembrance() {
        return this.remembrance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bublick bublick = (Bublick) o;
        return remembrance.equals(bublick.remembrance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), remembrance);
    }

    @Override
    public String toString() {
        return "Bublick{" +
                "remembrance='" + remembrance + '\'' +
                '}';
    }
}
