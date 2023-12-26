
package controlador.personas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;
import modelo.DetalleCenso;
import modelo.Persona;

public class DetalleController<T> extends DataAccessObject<DetalleCenso> {
    
    //Objectos
    private DetalleCenso dt = new DetalleCenso();
    private LinkedList<DetalleCenso> detalles = new LinkedList<>();
    private Integer index = -1;
    
    //Constructor
    public DetalleController() {
        super(DetalleCenso.class);
    }
    
    //Metodos
    
    public boolean save(){
        dt.setId(generated_id());//BDD Esto desaparece
        return save(dt);
    }
    
    public boolean update(Integer index){
        return update(dt,index);
    }
    
    //Getter and Setter

    public DetalleCenso getDt() {
        if(dt == null){
            dt = new DetalleCenso();
        }
        return dt;
    }

    public void setDt(DetalleCenso dt) {
        this.dt = dt;
    }

    public LinkedList<DetalleCenso> getDetalles() {
        if(detalles.isEmpty()){
            detalles = listAll();
        }
        return detalles;
    }

    public void setDetalles(LinkedList<DetalleCenso> detalles) {
        this.detalles = detalles;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
      //ORDENAMIENTO SELECCION
    public LinkedList<DetalleCenso> ordenarSeleccion(Integer type, String field, LinkedList<DetalleCenso> lista) throws EmptyStackException, Exception {

        Integer n = lista.getSize();//Tamaño de la lista
        DetalleCenso[] m = lista.toArray();//Transformo la lista a arreglo
        Field faux = Utilidades.getField(DetalleCenso.class, field);

        if (faux != null) {
            int iteraciones = 0; // Contador de iteraciones
            for (int i = 0; i < n - 1; i++) {
                int k = i;
                DetalleCenso t = m[i];
                for (int j = i + 1; j < n; j++) {
                    DetalleCenso mj = m[j];
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
    public LinkedList<DetalleCenso> ordenarMergeSort(LinkedList<DetalleCenso> lista, Integer type, String field) {
        int[] contador = {0}; // Contador de iteraciones
        mergeSort(lista, 0, lista.getSize() - 1, type, field, contador);
        System.out.println("Iteraciones totales realizadas: " + contador[0]);

        return lista;
    }

    public void mergeSort(LinkedList<DetalleCenso> lista, int ini, int fin, Integer type, String field, int[] contador) {
        int m = 0;
        if (ini < fin) {
            m = (ini + fin) / 2;
            mergeSort(lista, ini, m, type, field, contador);
            mergeSort(lista, m + 1, fin, type, field, contador);
            merge(lista, ini, m, fin, type, field, contador);
        }
    }

    public void merge(LinkedList<DetalleCenso> lista, int ini, int m, int fin, Integer type, String field, int[] contador) {
        DetalleCenso[] array = lista.toArray(); // Transformo la lista a arreglo
        Field faux = Utilidades.getField(DetalleCenso.class, field);

        int k = 0;
        int i = ini;
        int j = m + 1;
        int n = fin - ini + 1;
        DetalleCenso b[] = new DetalleCenso[n];

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
    public LinkedList<DetalleCenso> ordenarQuickSort(LinkedList<DetalleCenso> lista, Integer type, String field) throws VacioExcepcion {
        int[] contador = {0};
        lista = quickSort(lista, 0, lista.getSize() - 1, type, field, contador);
        System.out.println("Iteraciones totales realizadas: " + contador[0]);
        return lista;
    }

    public LinkedList<DetalleCenso> quickSort(LinkedList<DetalleCenso> lista, int izq, int der, Integer type, String field, int[] contador) throws VacioExcepcion {
        DetalleCenso[] m = lista.toArray(); // Transformo la lista a arreglo
        Field faux = Utilidades.getField(DetalleCenso.class, field);

        if (faux != null && izq < der) {
            int i = izq;
            int j = der;

            // Obtén el pivote
            DetalleCenso pivote = m[(izq + der) / 2];

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
                    DetalleCenso temp = m[i];
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
   
    //Compruebo Funciomamiento de la Lista
    public static void main(String[] args){
        DetalleController dtc = new DetalleController();
        try {
           //ORDENAR SELECCION
            System.out.println("Probando Ordenamiento SELECCION");
            System.out.println(dtc.ordenarSeleccion(0, "fechaDivorcio", dtc.getDetalles()).imprimir());

            //LISTA ANTES DE ORDENAR
            System.out.println("Lista antes de ordenar:");
            System.out.println(dtc.getDetalles().imprimir());
            
            //ORDENAR MERGESORT
            System.out.println("Ordenar Merge Sort");
            System.out.println(dtc.ordenarMergeSort(dtc.getDetalles(), 0, "fechaDivorcio").imprimir());
            
            //ORDENARQUICKSORT
            System.out.println("Ordenamieto por QuickSort");
            System.out.println(dtc.ordenarQuickSort(dtc.getDetalles(), 0, "fechaDivorcio").imprimir());
            
            
        } catch (Exception e) {
        }
    }
    
}
