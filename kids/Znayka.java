package kids;

import enums.Location;
import events.EventLibrary;
import exceptions.BadEndException;
import interfaces.AbleToFind;
import story.Legend;

import java.util.Arrays;
import java.util.Objects;

public final class Znayka extends Kid implements AbleToFind {

    public Znayka() {
        super("Знайка", Location.FLOWERTOWN);
    }

    @Override
    public void find() {
        System.out.println(getName() + " решил найти своих улетевших товарищей");
        setLocation(Location.ZMEEVKA);

    }

    public void findResult(boolean[] memoryFind) throws BadEndException {
        int temp = 0;
        for (int i = 0; i<memoryFind.length; i++){
            if(memoryFind[i] == true){
                temp++;
            }
        }
        try{
            if(temp == 3){
                System.out.println("Поиски увенчались успехом!");
            }else{
                throw new BadEndException();
            }

        }catch (BadEndException e){
            System.out.println("...их не нашли.");
        }

    }

    public void find(Citizen citizen, EventLibrary eventLibrary) throws BadEndException, NullPointerException {

        find();
        boolean[] memoryFind = {false, false, false};
        int j = 0;
        Object[] temp = getMyMemory().toArray();
        for(int i = 0; i< temp.length; i++){
            try{
            if(eventLibrary.checkEventIn(temp[i], citizen)){
                memoryFind[j]=true;
                j++;
            }
            }catch (NullPointerException nullPointerException){
                if(eventLibrary.checkEventIn(new Legend(), citizen)){
                    memoryFind[j]=true;
                    j++;
                }
            }
        }
        findResult(memoryFind);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Znayka z = (Znayka) o;
        return getName().equals(z.getName()) &&
                getLocation() == z.getLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation());
    }

    @Override
    public String toString() {
        return "Znayka{" +
                "name='" + getName() + '\'' +
                ", location=" + getLocation() +
                ", memory=" + Arrays.toString(getAllMemory()) +
                '}';
    }
}
