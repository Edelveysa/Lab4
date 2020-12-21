package kids;

import enums.Location;
import interfaces.AbleToUpdate;
import interfaces.EventManage;
import java.util.Arrays;
import java.util.Objects;

public abstract class Kid implements AbleToUpdate{
    private String name;
    private Location location;
    private String[] memory;

    public Kid(String name, Location location){
        this.name = name;
        this.location = location;
        this.memory = new String[EventManage.MEMORY_SIZE];
    }

    @Override
    public void update(String remembrance) {
            boolean addIn = false;
            for(int i = 0; i < memory.length; i++) {
                if (memory[i] == null) {
                    memory[i] = remembrance;
                    addIn = true;
                    break;
                }
            }
            if (addIn = false){
                System.out.println("Память заполнена");
            }

        }

    public String getName() {
        return name;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
        System.out.println(getName() + " оказался в " + location.getLocation());
    }

    public String[] getAllMemory() {
        return memory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kid kid = (Kid) o;
        return name.equals(kid.name) && location == kid.location && Arrays.equals(memory, kid.memory) ;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, location);
        result = 31 * result + Arrays.hashCode(memory);
        return result;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", memory=" + Arrays.toString(memory) +
                '}';
    }
}
