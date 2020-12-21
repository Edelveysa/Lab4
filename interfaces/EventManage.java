package interfaces;

import kids.Kid;

public interface EventManage {
    int MEMORY_SIZE = 10;

    void addEvent(String remembrance);
    boolean checkInEvents(String remembrance);
    void notifyEvent(String remembrance, Kid[] witnesses);

}
