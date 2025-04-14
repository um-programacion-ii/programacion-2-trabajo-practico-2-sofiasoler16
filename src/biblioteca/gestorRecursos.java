package biblioteca;

import java.util.ArrayList;
import java.util.List;

//Con gestor recursos podemos recorrer los recursos en una lista y agregarlos a ella
public class gestorRecursos {
    private List<recursoDigitalBase> recursos;

    public gestorRecursos() {
        recursos = new ArrayList<>();
    }

    public void agregarRecurso(recursoDigitalBase recurso) {
        recursos.add(recurso);
    }

    public List<recursoDigitalBase> getRecursos() {
        return recursos;
    }
}
