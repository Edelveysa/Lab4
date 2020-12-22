package story;

import enums.Location;
import events.EventLibrary;
import exceptions.BadEndException;
import interfaces.AbleToCreateLegend;
import kids.*;

public class Story {

    public void start() throws BadEndException {
        Mechanic vintik = new Mechanic("Винтик", Location.FLOWERTOWN);
        Mechanic shpuntik = new Mechanic("Шпунтик", Location.FLOWERTOWN);
        Citizen citizen = new Citizen();
        Znayka znayka = new Znayka();
        Bublick bublick = new Bublick();
        AbleToCreateLegend able = () -> {
            if(citizen.believeInLegend()){
                Legend legend = new Legend();
                return legend.getRemembrance();
            }else {
                return null;
            }
        };
        Kid[] witnesses = {vintik, shpuntik, citizen, bublick, znayka};
        EventLibrary eventLibrary = new EventLibrary(witnesses);
        citizen.update(able.createLegend());
        OnceStoryObject balloon = new OnceStoryObject(){
            @Override
            public void doRemembrance() {
                super.setRemembrance("Шар разбился в " + Location.GREENTOWN.getLocation());
                eventLibrary.addEvent(super.getRemembrance());
                znayka.update("Прыжок веры!");
            }

        };

        balloon.doRemembrance();
        vintik.setLocation(Location.GREENTOWN);
        shpuntik.setLocation(Location.GREENTOWN);
        Kid[] passengers = {vintik, shpuntik};
        bublick.driveWith(passengers, eventLibrary);
        znayka.find(citizen, eventLibrary);

    }



    public static class PlotTwist {
        public static int random(){
            return (int)(Math.round(Math.random()*100));
        }
    }


}
