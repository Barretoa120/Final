import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.HashMap;
public final class MyMap<K,V> implements Map<K,V> {


  private Node<Character,V> root = null;


  /*v value;
  some boolean that lets you know whether is the last node or not -boolean terminal
  conceptually same as linked list except value and several nexts */
  //set to store nodes
  //only return key at terminal node

  private class Node<Character,V>{
    private V val; //number
    private K key; //the letter
    private boolean isTerminal = false;
    HashMap<Character,Node<Character,V>> nexts=new HashMap<>();

    /**
    @return val returns val, imput value is set to int val
    @param val imput value
    */
    public void setVal(V val){
      this.val=val;
    }
    //returns val
    public V getVal(){
      return val; //nexts.get(key); //why doesn't this work


    }
    //to returns next
    public Node<Character,V> getNext(Character nextkey){ //change K to character? i did, lets see how bad it is?
      return nexts.get(nextkey);
    }
    /**
    set the next link in the list
    @param next node next
    */
    public void setNext(Character key, V value){
      Node<Character,V> next = new Node<Character,V>();
      next.setVal(value);
      nexts.put(key,next);
      //this.key = key; //make sure this is correct
      this.val = value;
    }

    public boolean isTerminal(){
     if (isTerminal == true){
       return true;
     }
       else return false;
    }
    /*
    public boolean iskeyinmap(K character){
      if (nexts.get(character)!=null){
        return true;
      }
      else return false;
    }

    public Node<Character,V> getNode(K character){
      return nexts.get(character);
    }
    */
  }


  public Set<Entry<K,V>> entries = new LinkedHashSet<Entry<K,V>>(); //ask about this
  int size;
    //how a map works in java
/*
treemap<string,integer>map = new treemap<>();
map.put("book",1);
map.put("books",2);
map.put("axis",2); //have key and a value
system.out.println(map.get("book"));->should print one. when use key, should get integer value
//values can be the same they are independant

//with strings
treemap<string,string>map = new treemap<>();
map.put("book","something you read");
map.put("books","somethings you read");
map.put("axis","something you read!"); //have key and a value
system.out.println(map.get("book"));->should print something that you read-if you know the key,
//you can get the gvalue
//values can be the same they are independant
//second value can be a list if need be

can use k,v as strings, which would make sense I think
*/
  public int size() {
	     return this.size;
  }
//to get full credit implement everything. if running out of time, write size, write clear, remove, put, get, containskey, isEmpty
//DO THOSE FIRST
//be able to insert word take out word view all words in tree
  public Set<Entry<K, V>> entrySet() { //iterate thtough all entires-have key and value. value will be the String
      //key would be "apple"the value can be the string itself . key is the string we are looking for
      //returns the key value pairs and the Map as a set
      //

	return entries;
    }

  public Set<K> keySet() { //return a set of keys. a set is like a list but no order. just call add on
        //whatever you want to add to the set. returning an arraylist that is being viewed by a collection?
        //key is

  	Set<K> keys = new LinkedHashSet<>();
  	for(Entry<K,V> entry: entries) {
  	    keys.add(entry.getKey());
	     }
	      return keys;
    }

  public void clear() {

  }

  public Collection<V> values() {
  	Collection<V> vals = new ArrayList<V>();
  	for(Entry<K,V> entry : entries) {
  	    vals.add(entry.getValue());
	     }
	      return vals;
    }

    public void putAll(final Map<? extends K, ? extends V> map) {//there are maps
      //putall puts everything that is in that map and adds it to another map
      //call, assuming it workds, entryset and add all entries to current map...i guess
      //a little confused about maps...
    }

    public V remove(final Object key) { //does it remove just one letter or everything after that letter

	     return null;
    }

    public V put(final K key, final V value) { //cannot change k to character here! //returns old value after insertion v value

      String keystring = key.toString();
      int index = 0;
      Node<Character,V> temp = new Node<Character,V>();
      temp = root;

      //at the end of this loop temp should not have anything letter connected to it that is part of the word
      //index should be the index of the next character in the word
        while(temp.getNext(keystring.charAt(index))!=null){
          temp = temp.getNext(keystring.charAt(index)); //update temp so now it is the node with the value attached to the current i
          index++; //update i since now we are moving onto the next character in the string
        }
        for(int j = index; j<keystring.length(); j++){
          temp.setNext(keystring.charAt(j),value); //set next node after temp to be the letter of the word we are on and arbitrary value 1
          size ++; //update the set
          temp = temp.getNext(keystring.charAt(j)); //now set temp to be the node we just created
        }
        //may need to add another thing because ends before reaches the full length maybe...
        //add terminal thingy!!!
        return null;
     }



      //Is there a next node for each next character in the strings
      //start at the root, keep calling getNext on each successive character if it exists
      //If exists, follow; else add, then follow
      //set last node to value, terminal



	     //return null;


    public V get(final Object key) { //how to track index with multiple nodes ask
      /*
      Node temp = null;
      temp = head;
      for (int i = 0; i<= index; i++){
        temp = temp.next;
      }
      //at index get the value
      return temp.getVal(); */

	     return null;
    }

    public boolean containsValue(Object value) { //this might not work
/*
      if (Node<Character,V>.nexts.get(value)!=null);{
        return true;
      }
	    else return false;
      */
      return false;
    }

    public boolean containsKey(Object key) {
/*
      if (iskeyinmap(key)==true){
        return true;
      }
      else return false;
    }
*/
      return false;
    }

    public boolean isEmpty() {
      if (size == 0){
        return true;
      }
	     else return false;
    }

}
//.contains apple return true/ return true
/*
add certain things and check if they work
can have any number of next nodes
can store them in a List
node{
node next;
for binary tree have a node left and node left
arraylist <nodes> nexts -can have any number of nodes, have to check all to see if the character
youre looking for is in other
boolean terminal-asks if it is the end of some valid word, otherwise return false
checking for specific words, adding specific words
root may not have anything else
to remove apples, remove the s, dont need to necessarily remove everything?
to remove "books" set boolean to false so no longer books
}

node{
v value (if use v it can be any type). value at every node.
should have value, boolean value, and next nodes (arraylist for this).
}

collection<integers> al = new arraylist<>();
collection<integers> ll = new LinkedList<>();

we need to create a node class!!!!!
list or array of nextnodes, a value just like ll, need an arraylist or linked list to do this...

node{
v value;
arraylist<node>..
some boolean that lets you know whether is the last node or not -boolean terminal
conceptually same as linked list except value and several nexts

for java it is possible to use one file if use a private class but could also use two
for the node file

constructor? create root, node, root should contain a bunch of next stuff i guess

better to use a set rather than an arraylist for the node class
}
*/

