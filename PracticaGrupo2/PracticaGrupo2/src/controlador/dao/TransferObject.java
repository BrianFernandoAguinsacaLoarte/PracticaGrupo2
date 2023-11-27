
package controlador.dao;

import controlador.TDA.listas.LinkedList;


public interface TransferObject<T> {
    
    //Estructura para todo
    public boolean save(T data);
    public boolean update(T data, Integer index);
    public LinkedList<T> listAll();
    public T find(Integer id);
    
        
}
