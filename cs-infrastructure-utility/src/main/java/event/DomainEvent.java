package event;

import lombok.Data;

@Data
public class DomainEvent<T> extends BaseEvent{

//    private String exchange;
//
//    private String routingKey;

    private Operation operation;

    private T message;

}
