import java.util.ArrayList;

public class ListaTareas
{
    private ArrayList<String> listaDeTareas;
    private ArrayList<Boolean> tareaTerminada;
    
    public ListaTareas()
    {
        listaDeTareas = new ArrayList<String>();
        tareaTerminada = new ArrayList<Boolean>();
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
        tareaTerminada.add(false);
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
     * El método supone que un valor de 1 en el parámetro indica
     * la primera tarea, 2 la segunda, etc.
     */
    
    public void eliminaTarea(int posicion)
    {
        posicion = posicion - 1;
        if (esValidoElIndice(posicion))
        {
            listaDeTareas.remove(posicion);
            tareaTerminada.remove(posicion);
        }
    }
        
    /**
     * Método que comprueba si un índice es válido y devuelve true
     * en caso afirmativo o false en otro caso
     * un valor de 0 cuando hay una tarea es un valor de índice válido
     * pero un valor de 1 si solo hay una tarea no es válido
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
    
    /**
     * Método que devuelve true en caso de que haya tareas por hacer, false
     * en otro caso
     */
    
    public boolean hayTareasPendientes()
    {
        boolean tareasPendientes = false;
        if (getNumeroTareas() > 0)
        {
            tareasPendientes = true;
        }
        return tareasPendientes;
    }
    
    /**
     * Método que imprime todas las tareas existentes, una por línea.
     * El método imprime el número de posición de la tarea antes del
     * nombre de la tarea.
     */
    
    public void mostrarTareas()
    {
        int posicion = 1;
        for (String tarea : listaDeTareas) 
        {
            String textoAMostrar = "";
            textoAMostrar = textoAMostrar + posicion + ". ";
            if (tareaTerminada.get(posicion - 1) == true)
            {
                textoAMostrar = textoAMostrar + "HECHO. ";
            }
            textoAMostrar = textoAMostrar + tarea;
            System.out.println(textoAMostrar);
            posicion = posicion + 1;
        }
    }
    
    /**
     * Muestra todas las tareas (una por línea) que contengan un determinado texto pasado
     * como parámetro con su numeración asociada correcta. Si no hay ninguna
     * tarea que contenga el texto indicado, se muestra un mensaje de error (SOLO UNO!!!!!)
     * si hay tareas coincidentes, tras la lista, se muestra el múmero de tareas coincidentes.
     */
    
    public void mostrarTareasCoincidentes(String texto)
    {
        int posicion = 1;
        int numeroCoincidencias = 0;
        for (String tarea : listaDeTareas) 
        {
            if (tarea.contains(texto))
            {
                System.out.println(posicion + ". " + tarea);
                numeroCoincidencias = numeroCoincidencias + 1;
            }
            posicion = posicion + 1;
        }
        
        if( numeroCoincidencias == 0)
        {
            System.out.println("Error");
        }
        else
        {
            System.out.println(numeroCoincidencias + " tareas encontradas  en el texto " + texto);
        }
    }
    
    /**
     * Muestra todas las tareas existentes (usando un bucle while)
     */
    
    public void mostrarTareas2()
    {
        int indice = 0;
        while (indice < getNumeroTareas()) 
        {
            System.out.println((indice + 1) + ". " + listaDeTareas.get(indice));
            indice++;
        }
    }
    
    /**
     * Muestra por pantalla las primeras n tareas indicadas como parámetro. En caso de que haya
     * menos de n tareas se muestran todas.
     */
    
    public void mostrarPrimerasTareas(int numeroTareasAMostrar)
    {
        int indice = 0;
        while (indice < numeroTareasAMostrar && indice < listaDeTareas.size())
        {
            System.out.println((indice + 1) + ". " + listaDeTareas.get(indice));
            indice++;
        }
    }
    
    /**
     * Devuelve true o false si hay al menos una tarea que contiene el texto indicado
     * como parámetro. -1 en caso contrario. NO MUESTRA NADA POR PANTALLA.
     */
    
    public int hayTareasCoincidentes(String textoABuscar)
    {
        boolean coincidencia = false;
        int posicion = 0;
        int valorDevolver = -1;        
        while(posicion < listaDeTareas.size() && !coincidencia)
        {
            if(listaDeTareas.get(posicion).contains(textoABuscar))
            {
                coincidencia = true;
                valorDevolver = posicion;
            }
            posicion++;
        }
        return valorDevolver;
    }
    
    /**
     * Método que marca una tarea como completada.
     * Método a prueba de errores.
     * - numeroTarea es el número de la tarea empezando en 1
     */
    public void marcarComoCompletada (int numeroTarea)
    {
        if (numeroTarea > 0 && numeroTarea < listaDeTareas.size())
        {
            tareaTerminada.set(numeroTarea - 1, true);
        }
    }
}
