package biblioteca;

import java.util.ArrayList;
import java.util.List;

//Con gestor recursos podemos recorrer los recursos en una lista y agregarlos a ella
public class gestorRecursos {
    private List<recursoDigital> recursos;

    public gestorRecursos() {
        recursos = new ArrayList<>();
    }

    public void agregarRecurso(recursoDigital recurso) {
        recursos.add(recurso);
    }

    public List<recursoDigital> getRecursos() {
        return recursos;
    }
}
