package before.Models;

import java.util.ArrayList;

public class LinkedList <E>{

  private ArrayList<E> al = new ArrayList<E>();

  public void add(E ob){
    al.add(ob);
  }
  public void remove(E ob){
    al.remove(ob);
  }
  public E get(int x){
    return al.get(x);
  }

}
