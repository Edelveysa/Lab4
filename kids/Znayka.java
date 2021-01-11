package kids;

import enums.Location;
import exceptions.BadEndException;
import interfaces.AbleToFind;
import interfaces.AbleToUpdate;
import interfaces.EventManage;
import story.OnceStoryObject;

import java.util.Arrays;
import java.util.Objects;

public final class Znayka extends Kid implements AbleToFind {

    public Znayka() {
        super("Знайка", Location.FLOWERTOWN);
        AbleToUpdate able = new AbleToUpdate(){
            @Override
            public void update(Object event) {
                if(event instanceof Mechanic || event instanceof OnceStoryObject.Balloon){
                    Znayka.this.getMyMemory().add(event);
                }
            }
        };
        EventManage.addSubscriber(able);

    }

    @Override
    public void find() {
        System.out.println(getName() + " решил найти своих улетевших товарищей");
        setLocation(Location.ZMEEVKA);

    }

    public void find(Citizen citizen) throws BadEndException {
        find();
        boolean[] check = checkMemoryZnayka(citizen);
        int temp = 0;
        for(int i = 0; i<check.length; i++){
            try {
                if (check[i]){
                    throw new BadEndException();
                } else{
                    temp++;
                }
            } catch (BadEndException badEndException){
                System.out.println("Их не могут найти...");
            }

            if (temp == 3){
                System.out.println("Поиски увенчались успехом!");
            }

        }
    }

    boolean[] checkMemoryZnayka(Citizen citizen){
        boolean[] temp = {false, false, false};
        int j = 0;
        for (int i = 0; i<getMyMemory().size(); i++){
                    if(citizen.getMyMemory().indexOf(getMyMemory().get(i)) != -1){
                        temp[j] = true;
                        j++;
                    }
                };
        return temp;
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
