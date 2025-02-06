package sudokuDio.src.model;


import java.util.Collection;
import java.util.List;

import static sudokuDio.src.model.GameStatusEnum.COMPLETE;
import static sudokuDio.src.model.GameStatusEnum.INCOMPLETE;
import static sudokuDio.src.model.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public class Board {
    private final List<List<Space>> spaces;

    public Board(final List<List>Space>> spaces){
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces(){
        return spaces;
    }

    public GameStatusEnum getStatus(){
        if (spaces.stream().flatMap(Collection::stream).nomeMatch(s_>!s.isFixed() && nonNull(s.getActual()))){
            return NON_STARTED;
        }
        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getActual())) ? INCOMPLETE : COMPLETE;
    }

    public boolean changeValue(final int col, final int row, final int value){
        var space = spaces.get(col).get(row);
        if (space.isFixed()){
            return false;
        }
        space.setActual(value);
        return true;
    }

    public booleanclearValue(final int col,final int row){
        var space = spaces.get(col).get(row);
        if (space.isFixed()){
            return false;
        }
        space.clearSpace();
        return true;
    }

    public void reset(){
        spaces.forEach(c-> c.forEach(Space::clearSpace));
    }

    public boolean gameIsFinished(){
        return !hasErrors() && getStatus().equals(COMPLETE);
    }
}
