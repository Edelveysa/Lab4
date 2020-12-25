package interfaces;

public interface EventManage {
    int MEMORY_SIZE = 10;

    void addEvent(Object event);
    boolean checkEventIn(Object event, Object witnesses);

}
