package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Matrix implements Iterable {
   private List elements;
   private int countRows;
   private int countColumns;
   private int countElements;
   private int[] indexes;
   public Matrix(int countRows, int countColumns){
       this.countRows = countRows;
       this.countColumns = countColumns;
       elements = new ArrayList<Object>();
       matrix_create();
   }

   private void matrix_create(){
       for (int i = 0; i < countRows; i++)
           for (int j = 0; j < countColumns; j++){
               if (i+j+1>countRows-1)// &&

                   {
                   countElements++;
               }
           }

       indexes = new int[countElements];

       Random rand = new Random();

       for (int i = 0, z = 0; i < countRows; i++)
           for (int j = 0; j < countColumns; j++){
               if (i+j+1>countRows-1) //&&
                   {
                   elements.add(rand.nextInt(9));
                   indexes[z] = i * countColumns + j;
                   z++;
               }
           }
   }

        public Object search(int row, int column){

        for (int i = 0; i < countElements; i++){
            if (indexes[i] == row * countColumns + column && elements.get(i) != null)
                return elements.get(i);
        }

        return null;
    }

    public void set(Object object, int row, int column) throws NullPlaceException{

        for (int i = 0; i < countElements; i++){
            if (row * countColumns + column == indexes[i]){
                elements.set(i, object);
                return;
            }
        }

        throw new NullPlaceException();

    }
    public String getSize(){
        return countRows + " x " + countColumns;
    }
    public int notNullPlaces(){
        return countElements;
    }

    public int nullPlaces(){
        int count = 0;

        for (int i = 0; i < countElements; i++){
            if (elements.get(i) == null)
                count++;
        }

        return (countRows * countColumns - countElements) + count;
    }


    public int notNullPlacesInColumn(int column)
    {
        int count = 0;

        for (int i = 0; i < countElements; i++){
            if (indexes[i] % countColumns == column)
                count++;
        }

        return count;
    }

    public void show()
    {
        for (int i = 0, k = 0; i < countRows; i++)
        {
            for (int j = 0; j < countColumns; j++)
            {
                if (i+j+1>countRows-1)// &&
                {
                    System.out.print(elements.get(k) + " ");
                    k++;
                }
                else System.out.print("N ");
            }

            System.out.println();
        }
    }


    public int notNullPlacesInRow(int row)
    {
        int count = 0;

        for (int i = 0; i < countElements; i++){
            if (indexes[i]/countColumns == row)
                count++;
        }

        return count;
    }



    @Override
        public Iterator iterator(){
        Iterator iterator = new Iterator(){
            int currentIndex = 0;

            @Override
            public boolean hasNext()
            {
                return currentIndex < countElements;
            }

            @Override
            public Object next(){
                return elements.get(currentIndex++);
            }
        };

        return iterator;
    }
}
