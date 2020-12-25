package kids;

import enums.Location;
import exceptions.InvalidParameterException;
import exceptions.NoLegendException;
import interfaces.AbleToUpdate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Kid implements AbleToUpdate{
    private String name;
    private Location location;
    private String[] memory;
    private ArrayList<Object> myMemory = new ArrayList<Object>();

    public Kid(String name, Location location)throws InvalidParameterException{
        if(name == null || name == ""){
            throw new InvalidParameterException("Вы забыли задать имя");
        }else{
            this.name = name;
        }
        if(location == Location.NONE){
            throw new InvalidParameterException("Вы забыли указать родной город");
        }else {
            this.location = location;
        }
    }

    @Override
    public void update(Object o) throws InvalidParameterException{
        if(o == null){
            throw new InvalidParameterException("Записываем в память пустоту...");
        }else {
            this.myMemory.add(o);
        }
    }


    public String getName() {
        return name;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        if(location == null) {
            this.location = Location.NONE;
        } else {
            this.location = location;
            System.out.println(getName() + " оказался в " + location.getLocation());
        }
    }

    public ArrayList<Object> getMyMemory() {
        return myMemory;
    }

    public String[] getAllMemory() {
        return memory;
    }

    public boolean believeInLegend(Kid kid) throws InvalidParameterException{
        if(kid == null){
            throw new InvalidParameterException("Нет человека для веры в легенду");
        }
        ArrayList<Object> temp = getMyMemory();
        Gvozdik gvozdik = (Gvozdik) kid;
        try{
            if(temp.contains(gvozdik)){
                return true;
            }else{
                throw new NoLegendException();
            }
        }catch(NoLegendException noLegendException){
            return false;
        }


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
