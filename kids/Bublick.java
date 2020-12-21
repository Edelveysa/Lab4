package kids;

import enums.Location;
import events.EventLibrary;

import java.util.Objects;

public final class Bublick extends Citizen {
    private String remembrance = " побывал в " + Location.ZMEEVKA.getLocation();

    public Bublick() {
        super("Бублик", Location.GREENTOWN);
    }

    public void driveWith(Kid[] passengers, EventLibrary eventLibrary){
        Mechanic vintik = (Mechanic) passengers[0];
        Mechanic shpuntik = (Mechanic) passengers[1];
        vintik.setLocation(Location.ZMEEVKA);
        shpuntik.setLocation(Location.ZMEEVKA);
        setLocation(Location.ZMEEVKA);
        vintik.find();
        shpuntik.find();
        eventLibrary.addEvent(vintik.getName() + getRemembrance());
        eventLibrary.addEvent(shpuntik.getName() + getRemembrance());
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
