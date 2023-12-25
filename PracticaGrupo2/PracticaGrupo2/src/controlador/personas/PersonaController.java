
package controlador.personas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import java.util.EmptyStackException;
import modelo.Persona;


public class PersonaController extends DataAccessObject<Persona>{
    
    //Objectos
    private Persona persona = new Persona();
    private LinkedList<Persona> listaPersona = new LinkedList<>();
    private Integer index = -1; //Index para el Update

    //Constructor
    public PersonaController() {
        super(Persona.class);
    }
    
    
    //Metodos
    
    public boolean save(){
        persona.setId(generated_id());//BDD Esto desaparece
        return save(persona);
    }
    
    public boolean update(Integer index){
        return update(persona,index);
    }
    
    
    
    //Getter and Setter

    public Persona getPersona() {
        
        if(persona == null){
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListaPersona() {
        
        if(listaPersona.isEmpty()){
            listaPersona = listAll();
            
        }
        return listaPersona;
    }

    public void setListaPersona(LinkedList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
    //ORDENAMIENTO SELECCION
    public LinkedList<Persona> ordenarSeleccion(Integer type, String field, LinkedList<Persona> lista) throws EmptyStackException, Exception {

        Integer n = lista.getSize();//Tamaño de la lista
        Persona[] m = lista.toArray();//Transformo la lista a arreglo
        Field faux = Utilidades.getField(Persona.class, field);

        if (faux != null) {
            int iteraciones = 0; // Contador de iteraciones
            for (int i = 0; i < n - 1; i++) {
                int k = i;
                Persona t = m[i];
                for (int j = i + 1; j < n; j++) {
                    Persona mj = m[j];
                    if (mj.compareTo(t, field, type)) {
                        t = mj;
                        k = j;
                    }
                    iteraciones++;
                }
                m[k] = m[i];
                m[i] = t;
            }
            lista = lista.toList(m);
            System.out.println("Iteraciones realizadas: " + iteraciones);
        } else {
            throw new Exception("No existe ese criterio de busqueda");
        }
        return lista;
    }

    //ORDENAMIENTO MergeSort
    public LinkedList<Persona> ordenarMergeSort(LinkedList<Persona> lista, Integer type, String field) {
        int[] contador = {0}; // Contador de iteraciones
        mergeSort(lista, 0, lista.getSize() - 1, type, field, contador);
        System.out.println("Iteraciones totales realizadas: " + contador[0]);

        return lista;
    }

    public void mergeSort(LinkedList<Persona> lista, int ini, int fin, Integer type, String field, int[] contador) {
        int m = 0;
        if (ini < fin) {
            m = (ini + fin) / 2;
            mergeSort(lista, ini, m, type, field, contador);
            mergeSort(lista, m + 1, fin, type, field, contador);
            merge(lista, ini, m, fin, type, field, contador);
        }
    }

    public void merge(LinkedList<Persona> lista, int ini, int m, int fin, Integer type, String field, int[] contador) {
        Persona[] array = lista.toArray(); // Transformo la lista a arreglo
        Field faux = Utilidades.getField(Persona.class, field);

        int k = 0;
        int i = ini;
        int j = m + 1;
        int n = fin - ini + 1;
        Persona b[] = new Persona[n];

        if (faux != null) {
            while (i <= m && j <= fin) {
                if (array[i].compareTo(array[j], field, type)) {
                    b[k] = array[i];
                    i++;
                    k++;
                } else {
                    b[k] = array[j];
                    j++;
                    k++;
                }
                contador[0]++;
            }

            while (i <= m) {
                b[k] = array[i];
                i++;
                k++;
                contador[0]++;
            }

            while (j <= fin) {
                b[k] = array[j];
                j++;
                k++;
                contador[0]++;
            }

            for (k = 0; k < n; k++) {
                array[ini + k] = b[k];
            }
            lista = lista.toList(array);
        }

    }

    //ORDENAMIENTO QUICKSORT
    public LinkedList<Persona> ordenarQuickSort(LinkedList<Persona> lista, Integer type, String field) throws VacioExcepcion {
        int[] contador = {0};
        lista = quickSort(lista, 0, lista.getSize() - 1, type, field, contador);
        System.out.println("Iteraciones totales realizadas: " + contador[0]);
        return lista;
    }

    public LinkedList<Persona> quickSort(LinkedList<Persona> lista, int izq, int der, Integer type, String field, int[] contador) throws VacioExcepcion {
        Persona[] m = lista.toArray(); // Transformo la lista a arreglo
        Field faux = Utilidades.getField(Persona.class, field);

        if (faux != null && izq < der) {
            int i = izq;
            int j = der;

            // Obtén el pivote
            Persona pivote = m[(izq + der) / 2];

            // Realiza el particionamiento
            while (i <= j) {
                while (m[i].compareQuickSort(pivote, type, field) < 0) {
                    i++;
                    contador[0]++;
                }

                while (m[j].compareQuickSort(pivote, type, field) > 0) {
                    j--;
                    contador[0]++;
                }

                if (i <= j) {
                    // Intercambia los elementos
                    Persona temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                    i++;
                    j--;
                }
            }
            lista = lista.toList(m);
            quickSort(lista, izq, j, type, field, contador); // Ordena la parte izquierda
            quickSort(lista, i, der, type, field, contador); // Ordena la parte derecha
        }
        return lista;
    }
   
    public static void mostrarArreglo(int arreglo[]){
       
       for(int i=0; i < arreglo.length; i++){
           System.out.print(arreglo[i] + "_");
       }
       System.out.println("");
    }
   
    public static void mostrarLista(Persona persona[]){
       for(Persona a: persona){
           System.out.println(a);
       }
    }
   

    //COmpruebo Funcionamiento de la lista
    public static void main(String[] args){
       PersonaController pc = new PersonaController();
      
       
       try {
           //ORDENAR SELECCION
            System.out.println("Probando Ordenamiento SELECCION");
            System.out.println(pc.ordenarSeleccion(0, "apellidos", pc.getListaPersona()).imprimir());

            //LISTA ANTES DE ORDENAR
            System.out.println("Lista antes de ordenar:");
            System.out.println(pc.getListaPersona().imprimir());
            
            //ORDENAR MERGESORT
            System.out.println("Ordenar Merge Sort");
            System.out.println(pc.ordenarMergeSort(pc.getListaPersona(), 0, "apellidos").imprimir());
            
            //ORDENARQUICKSORT
            System.out.println("Ordenamieto por QuickSort");
            System.out.println(pc.ordenarQuickSort(pc.getListaPersona(), 0, "apellidos").imprimir());
            
           
            
           /*
             Object resp = Utilidades.getData(pc.getPersona(), "nombres");
            if (resp != null) {
                System.out.println("OK->" + resp.toString());
                
            } else {
                System.out.println("No hay como ");
            }
            */
            
        } catch (Exception e) {
        }
        
    }
    
}
