package actors.comands;

public class BadCommand extends AbstractCommand{

    private String comandName;

    public BadCommand(){
        super();
        this.comandName = "BAD_COMAND";
    }

    public BadCommand(String comandName) {
        super();
        this.comandName = comandName;
    }

    public String getComandName() {
        return comandName;
    }

    public void setComandName(String comandName) {
        this.comandName = comandName;
    }
}
