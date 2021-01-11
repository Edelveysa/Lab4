package interfaces;

import exceptions.InvalidParameterException;
import java.util.ArrayList;

public interface EventManage {
    ArrayList<AbleToUpdate> subs = new ArrayList<AbleToUpdate>();

    static void addEvent(Object event) {
        if (event == null){
            throw new InvalidParameterException("Попытка добавить новый объект.");
        }
        subs.forEach(sub -> sub.update(event));

    }
    static void addSubscriber(AbleToUpdate able){
        if (able == null){
            throw new InvalidParameterException("Добавление несуществующего подписчика.");
        }
        subs.add(able);
    }



}
