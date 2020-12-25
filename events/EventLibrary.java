package events;

import interfaces.EventManage;
import kids.*;
import story.OnceStoryObject;
import java.util.ArrayList;


public class EventLibrary implements EventManage {
    private ArrayList<Kid> subscribers = new ArrayList<Kid>();

    public EventLibrary(Kid[] witnesses){
        for(int i = 0; i< witnesses.length; i++){
            subscribers.add(witnesses[i]);
        }
    }

    @Override
    public void addEvent(Object o){
        if (o instanceof OnceStoryObject.Balloon){
            subscribers
                    .stream()
                    .filter(kid -> ((kid instanceof Citizen) || (kid instanceof Znayka) || (kid instanceof Mechanic)))
                    .forEach(sub -> sub.update(o));
        }
        if (o instanceof Mechanic){
            subscribers
                    .stream()
                    .filter(kid -> kid instanceof Citizen)
                    .forEach(sub -> sub.update(o));
        }
    }

    @Override
    public boolean checkEventIn(Object event, Object witness){
            if (witness instanceof Citizen && event instanceof Mechanic){
                Citizen citizen = (Citizen) witness;
                Mechanic mechanic = (Mechanic) event;
                if(citizen.getMyMemory().indexOf(mechanic) != -1){
                    return true;
                };
            }
            if (witness instanceof Citizen && event instanceof OnceStoryObject.Balloon){
                Citizen citizen = (Citizen) witness;
                OnceStoryObject.Balloon balloon = (OnceStoryObject.Balloon) event;
                if(citizen.getMyMemory().indexOf(balloon) != -1){
                    return true;
                }
            }

        return false;
    }
}
