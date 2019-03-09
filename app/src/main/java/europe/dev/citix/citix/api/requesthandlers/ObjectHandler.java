package europe.dev.citix.citix.api.requesthandlers;

public interface ObjectHandler<T> {
    void handle(T response);
}
