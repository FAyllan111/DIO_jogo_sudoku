package sudokuDio.src.model;

public class GameStatusEnum {

    NON_STARTED("não iniciado"),
        INCOMPLETE("incompleto"),
            COMPLETE("completo");

    private String label;

    GameStatusEnum(final String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
