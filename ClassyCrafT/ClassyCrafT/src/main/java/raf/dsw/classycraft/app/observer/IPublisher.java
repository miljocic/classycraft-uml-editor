package raf.dsw.classycraft.app.observer;

public interface IPublisher {

    void addSubscriber(ISubscriber sub);
    @SuppressWarnings("unused")
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification);

}
