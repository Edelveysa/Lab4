package story;

import enums.Location;
import exceptions.BadEndException;
import interfaces.AbleToCreateLegend;
import events.EventManage;
import kids.*;

public class Story {

    public void start() throws BadEndException {
        Mechanic vintik = new Mechanic("Винтик", Location.FLOWERTOWN);
        Mechanic shpuntik = new Mechanic("Шпунтик", Location.FLOWERTOWN);
        Citizen citizen = new Citizen();
        Znayka znayka = new Znayka();
        Bublick bublick = new Bublick();
        AbleToCreateLegend ableToCreateLegend = () -> {
            if(citizen.believeInLegend(new Gvozdik())){
                EventManage.addEvent(new Legend());
            }
        };
        ableToCreateLegend.createLegend();
        OnceStoryObject balloon = new OnceStoryObject(){
            @Override
            public Object getRemembrance(){
                return new OnceStoryObject.Balloon();
            }
        };
        EventManage.addEvent(balloon.getRemembrance());
        vintik.setLocation(Location.GREENTOWN);
        shpuntik.setLocation(Location.GREENTOWN);
        Kid[] passengers = {vintik, shpuntik};
        bublick.driveWith(passengers);
        znayka.find(citizen);

    }



    public static class PlotTwist {
        public static int random(){
            return (int)(Math.round(Math.random()*100));
        }
    }


}
