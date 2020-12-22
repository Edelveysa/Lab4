package events;

import interfaces.EventManage;
import kids.*;


public class EventLibrary implements EventManage {
    private Kid[] witnesses;
    private String[] events;

    public EventLibrary(Kid[] witnesses){
        this.events = new String[MEMORY_SIZE];
        this.witnesses = witnesses;
    }

    public String[] getEvents() {
        return events;
    }

    public Kid[] getWitnesses() {
        return witnesses;
    }

    @Override
    public void addEvent(String remembrance) {
        boolean addIn = false;
        for(int i = 0; i<MEMORY_SIZE; i++) {
            if (events[i] == null) {
                events[i] = remembrance;
                addIn = true;
                System.out.println("Добавлено новое воспоминание: " + remembrance);
                notifyEvent(remembrance, this.witnesses);
                break;
            }
        }
        if (addIn == false){
            System.out.println("Память заполнена");
        }
    }

    @Override
    public boolean checkInEvents(String remembrance) {
        for (int i = 0; i<MEMORY_SIZE; i++){
            if(events[i] != null && events[i].equals(remembrance)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void notifyEvent(String remembrance, Kid[] witnesses) {
        if(remembrance.equals("Шар разбился в Зеленый город")) {
            for (int i = 0; i < witnesses.length; i++) {
                if (witnesses[i] instanceof Citizen) {
                    Citizen citizen = (Citizen) witnesses[i];
                    citizen.update(remembrance);
                }
                if (witnesses[i] instanceof Znayka) {
                    Znayka znayka = (Znayka) witnesses[i];
                    znayka.update(remembrance);
                }
            }
        }
        if(remembrance.equals("Винтик побывал в Змеевка") || remembrance.equals("Шпунтик побывал в Змеевка")){
                for(int i = 0; i<witnesses.length; i++){
                    if (witnesses[i] instanceof Citizen){
                        Citizen citizen = (Citizen)witnesses[i];
                        citizen.update(remembrance);
                    }   
                    if(witnesses[i] instanceof Mechanic){
                        Mechanic mechanic = (Mechanic)witnesses[i];
                        mechanic.update(remembrance);
                    }
                }
        }
        if(remembrance.equals("Дракон Стоголовый решил съесть малышей")){
            for(int i = 0; i<witnesses.length; i++){
                if (witnesses[i] instanceof Citizen){
                    Citizen citizen = (Citizen)witnesses[i];
                    citizen.update(remembrance);
                }
            }
        }


    }


}
