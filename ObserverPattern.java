import java.util.ArrayList;
import java.util.List;

class NewspaperPublisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}


interface Subscriber {
    void update(String news);
}

class Subscriber1 implements Subscriber {
    @Override
    public void update(String news) {
        System.out.println("Subscriber 1 received news: " + news);
    }
}

class Subscriber2 implements Subscriber {
    @Override
    public void update(String news) {
        System.out.println("Subscriber 2 received news: " + news);
    }
}


public class ObserverPattern {
    public static void main(String[] args) {
        NewspaperPublisher publisher = new NewspaperPublisher();  // Subject

        Subscriber subscriber1 = new Subscriber1();  // Observer 1
        Subscriber subscriber2 = new Subscriber2();  // Observer 2

        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);

        publisher.notifySubscribers("New article published!");  // Subject notifies observers
    }
}
