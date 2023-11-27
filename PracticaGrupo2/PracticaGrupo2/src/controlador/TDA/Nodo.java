
package controlador.TDA;

public class Nodo<E> {
    
    private E data;//Data
    private Nodo<E> next;//Apuntador
    
    //Constructores 
    //Me permite crear un objeto, no necesitara de argumentos
    public Nodo(){
        next = null;
    }
    public Nodo(E data){
        this.data = data;
        this.next = null; //Si me regresa next como null, me indica que ya no hay un siguiente Nodo
    }
    
    public Nodo(E data, Nodo<E> next){
        this.data = data;
        this.next = next;
    }
    
    
    /*
    Método enlazar, como parametro de tipo Nodo, next será igual a ese Nodo
    public void enlazarNext(Nodo next){
        this.next = next;
    }
    */
   

    //Getter and Setter
    //Método get, me regresara el data del siguiente Nodo
    
    public Nodo<E> getNext(){
        return next;
    }
    public void setNext(Nodo<E> next) {
        this.next = next;
    }

    //Método get, regresar la data
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
    
    
}
