package biblioteca;

import java.util.ArrayList;
import java.util.List;

//Con gestor recursos podemos recorrer los recursos en una lista y agregarlos a ella
public class GestorRecursos {
    private List<RecursoDigitalBase> recursos;

    public GestorRecursos() {
        recursos = new ArrayList<>();
    }

    public void agregarRecurso(RecursoDigitalBase recurso) {
        recursos.add(recurso);
    }

    public List<RecursoDigitalBase> getRecursos() {
        return recursos;
    }
}
