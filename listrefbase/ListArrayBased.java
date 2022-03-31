package listrefbase;

// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
public class ListArrayBased implements ListInterface
{

  private static final int MAX_LIST = 50;
  private TreeNode items[];  // an array of list items
  private int numItems;  // number of items in list
  private boolean end = false;

  public ListArrayBased()
  {
    items = new TreeNode[MAX_LIST];
    numItems = 0;
  }  // end default constructor

  public boolean isEmpty()
  {
    return (numItems == 0);
  } // end isEmpty

  public int size()
  {
    return numItems;
  }  // end size

  public void removeAll()
  {
    // Creates a new array; marks old array for
    // garbage collection.
    items = new TreeNode[MAX_LIST];
    numItems = 0;
  } // end removeAll
  public void add(int index, TreeNode item)
                  throws  ListIndexOutOfBoundsException
  {
    if (numItems > MAX_LIST)
    {
      throw new ListException("ListException on add");
    }  // end if
    if (index >= 1 && index <= numItems+1)
    {
      // make room for new element by shifting all items at
      // positions >= index toward the end of the
      // list (no shift if index == numItems+1)
      for (int pos = numItems; pos >= index; pos--)
      {
          items[translate(pos+1)] = items[translate(pos)];
      } // end for
      // insert new item
      items[translate(index)] = item;
      numItems++;
    }
    else
    {  // index out of range
      throw new ListIndexOutOfBoundsException(
       "ListIndexOutOfBoundsException on add");
    }  // end if
    sortarray();
  } //end add

  public TreeNode get(int index)
                    throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems)
    {
      return items[translate(index)];
    }
    else
    {  // index out of range
      throw new ListIndexOutOfBoundsException(
        "ListIndexOutOfBoundsException on get");
    }  // end if
  } // end get

  public TreeNode remove(int index)
                     throws ListIndexOutOfBoundsException
  {
    if(end == true){
      return null;
    }
    else if (index >= 1 && index <= numItems) {
      // delete item by shifting all items at
      // positions > index toward the beginning of the list
      // (no shift if index == size)
      TreeNode item = items[translate(index)];
      for (int pos = index+1; pos <= size(); pos++)
      {
        items[translate(pos-1)] = items[translate(pos)];
      }  // end for
      if (numItems == 1){
        end = true;
      }
      numItems--;
      return item;
    }
    else
    {  // index out of range
        throw new ListIndexOutOfBoundsException(
        "ListIndexOutOfBoundsException on remove");
    }  // end if

  } //end remove

  private int translate(int position)
  {
    return position - 1;
  }  // end translate

  public void display(){
    for(int i =1;i<numItems;i++){
      System.out.printf(" %c %d \n",get(i).getSymbol(),get(i).getFrequency());
    }
  }
  public void sortarray(){
    TreeNode hold;
    for(int i =0;i<numItems;i++){
      for(int j =0;j<numItems-1;j++){
        if(items[j].getFrequency() > items[j+1].getFrequency()){
          hold = items[j];
          items[j]= items[j+1];
          items[j+1] = hold;
        }
      }
    }
  }
}  // end ListArrayBased
