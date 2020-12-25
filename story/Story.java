package story;

import enums.Location;
import events.EventLibrary;
import exceptions.BadEndException;
import interfaces.AbleToCreateLegend;
import interfaces.AbleToUpdate;
import kids.*;

public class Story {

    public void start() throws BadEndException {
        Mechanic vintik = new Mechanic("Винтик", Location.FLOWERTOWN);
        Mechanic shpuntik = new Mechanic("Шпунтик", Location.FLOWERTOWN);
        Citizen citizen = new Citizen();
        Znayka znayka = new Znayka();
        AbleToUpdate ableToUpdate = event -> {
            znayka.update(event);
            znayka.update(vintik);
            znayka.update(shpuntik);
        };
        Bublick bublick = new Bublick();
        AbleToCreateLegend ableToCreateLegend = () -> {
            if(citizen.believeInLegend(new Gvozdik())){
                Legend legend = new Legend();
                return legend;
            }else {
                return new Legend("Бесполезная легенда.");
            }
        };
        Kid[] witnesses = {vintik, shpuntik, citizen, bublick, znayka};
        EventLibrary eventLibrary = new EventLibrary(witnesses);
        citizen.update(ableToCreateLegend.createLegend());
        OnceStoryObject balloon = new OnceStoryObject(){
            @Override
            public Object getRemembrance(){
                return new OnceStoryObject.Balloon();
            }
        };
        ableToUpdate.update(balloon);
        eventLibrary.addEvent(balloon.getRemembrance());
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
