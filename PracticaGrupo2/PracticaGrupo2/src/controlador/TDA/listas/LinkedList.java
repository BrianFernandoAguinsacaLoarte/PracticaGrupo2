
package controlador.TDA.listas;

import controlador.TDA.Nodo;
import controlador.Excepcion.VacioExcepcion;


public class LinkedList<E> {
    
    //Atributos
    private Nodo<E> head;
    private Nodo<E> last;
    private Integer size;
    
    //Constructor
    public LinkedList(){
        this.head = null;
        this.last = null;
        this.size = 0;
    }
    
    //Getter and Setter
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
    
    //Métodos
    
    //Metodo si esta vacio
    public boolean isEmpty(){
        //Si head es verdadera regresa true caso contrario false
        return (head == null || getSize() == 0);
    }
   
    //Agregar data a la primera posicion, HEAD
    protected void addFirst(E data){
        if(isEmpty()){
            Nodo<E> aux = new Nodo<>(data,null);
            head = aux;
            last = aux;
            
        }else{
            Nodo<E> temp = head;
            Nodo<E> nuevo = new Nodo<>(data,temp);
            head = nuevo;
        }
        size++;
    }
    
    //Metodo para añadir al ultimo de la lista
    protected void addLast(E data){
        if(isEmpty()){
            addFirst(data);
        }else{
            Nodo<E> nuevo = new Nodo<>(data, null);
            last.setNext(nuevo);
            last = nuevo;
            size++;
        }
    }
    //Metodo para obtener el primer dato
    
    public E getFirst() throws VacioExcepcion{
        if(isEmpty()){
            throw new VacioExcepcion("Lista Vacia");
        }else{
            return head.getData();
        }
    }
    
    //Metodo para obtener el ultimo dato
    public E getLast() throws VacioExcepcion{
        if(isEmpty()){
            throw new VacioExcepcion("Lista vacia");
        }else{
            return last.getData();
        }
    }
    
    //Método para obtener un Nodo
    public Nodo<E> getNode(Integer pos) throws VacioExcepcion{
        if(isEmpty()){
            throw new VacioExcepcion("Error, La lista esta vacia");
        }else if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("Error, Esta fuera de los limites de la lista");
        }else if(pos == 0){
            return head;
        }else if(pos == (size -1)){
            return last;
        }else{
            Nodo<E> search = head;
            Integer cont = 0;
            while(cont < pos){
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }


    //Metodo para obtener posicion
    public E get(Integer index) throws VacioExcepcion{
        if(isEmpty()){
            throw new VacioExcepcion("La lista esta vacia");
        }else if (index.intValue() < 0 || index.intValue() >= getSize()){
            throw new VacioExcepcion("Esta fuera del rango");
        }else if(index.intValue() == 0){
            return getFirst();
        }else if(index.intValue() == (size - 1)){
             return getLast();
        }else{
            Nodo<E> search = getNode(index);
            return search.getData();
        }
    }
    
    public void add(E data){
        addLast(data);
    }
    
    //Metodo para agregar data y una posicion especifica
    public void add(E data, Integer pos) throws VacioExcepcion{
        if(pos == 0){
            addFirst(data);
        }else if(pos.intValue() == (size.intValue())){
            addLast(data);
        }else{
            Nodo<E> search_preview = getNode(pos - 1);
            Nodo<E> search = getNode(pos);
            Nodo<E> aux = new Nodo<>(data, search);//*
            search_preview.setNext(aux);
            size++;
        }
    }
    
    //Metodo para IMprimir
    
    public String imprimir(){
        StringBuilder sb = new StringBuilder();
        
        if(isEmpty()){
            sb.append("Lista Vacia");
        }else{
            Nodo<E> aux = head;
            while(aux != null){
                sb.append(aux.getData().toString()).append("\n");
                aux = aux.getNext();
            }
        }
        return sb.toString();
    }
    
    public void update(E data,Integer pos) throws VacioExcepcion{
        if(isEmpty()){
            throw new VacioExcepcion("Error, La lista esta vacia");
        }else if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("Error, Esta fuera de los limites de la lista");
        }else if(pos == 0){
            head.setData(data); //Si modifico la cabecera setData y le asigno data
        }else if(pos == (size -1)){
            last.setData(data);//Si modifico el last setData y le asigno data
            
        }else{
            Nodo<E> search = head;
            Integer cont = 0;
            while(cont < pos){
                cont++;
                search = search.getNext();
            }
            search.setData(data);
        }
    }
    
    public void clear(){
        head = null;
        last = null;
        size = 0;
    }
    
}
