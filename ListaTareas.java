import java.util.ArrayList;

public class ListaTareas
{
    private ArrayList<String> listaDeTareas;

    public ListaTareas()
    {
        listaDeTareas = new ArrayList<String>();
    }
    
    /**
     * Imprime por pantalla todas las tareas guardadas.
     */
    
    public void verTareas()
    {
        System.out.println(listaDeTareas);
    }
    
    /**
     * Permite añadir una nueva tarea.
     */
    
    public void addTarea(String nuevaTarea)
    {
        listaDeTareas.add(nuevaTarea);
    }
    
    /**
     * Devuelve el número de tareas existentes.
     */
    
    public int getNumeroTareas()
    {
        return listaDeTareas.size();
    }
    
    /**
     * Eliminar la tarea que ocupa la posición indicada.
     * Si la posición indicada no es válida, no hace nada.
     */
    
    public void eliminaTarea(int posicion)
    {
        if (esValidoElIndice(posicion))
        {
            listaDeTareas.remove(posicion);
        }
    }
        
    /**
     * Método que comprueba si un índice es válido y devuelve true
     * en caso afirmativo o false en otro caso
     */
    
    public boolean esValidoElIndice(int indice)
    {
        boolean indiceValido = false;
        if(indice >= 0 && indice < listaDeTareas.size())
        {
            indiceValido = true;
        }
        return indiceValido;
    }
}
