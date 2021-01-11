package kids;

import enums.Location;
import interfaces.EventManage;

public class Gvozdik extends Kid{

    public Gvozdik(){
        super("Гвоздик", Location.ZMEEVKA);
        EventManage.addEvent(this);
    }

}
