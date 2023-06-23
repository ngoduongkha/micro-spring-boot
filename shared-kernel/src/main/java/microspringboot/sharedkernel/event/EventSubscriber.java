package microspringboot.sharedkernel.event;

public interface EventSubscriber {
    <E extends ApplicationEvent> void onEvent(E event);
}
