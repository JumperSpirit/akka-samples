package actors.comands;

import java.util.UUID;

public abstract class AbstractCommand {
    private final UUID comandId;

    public  AbstractCommand(){
        this.comandId = UUID.randomUUID();
    }

    public UUID getComandId() {
        return comandId;
    }
}
