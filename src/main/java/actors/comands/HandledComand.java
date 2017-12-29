package actors.comands;

public class HandledComand extends AbstractCommand{

    private String comandName;

    public  HandledComand(){
        super();
        this.comandName = "HANDLED_COMAND";
    }

    public HandledComand(String comandName) {
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
