package event;

public interface EventChange<T> {
    void send(String exchange, String rotingKey, DomainEvent<T> domainEvent);
}
