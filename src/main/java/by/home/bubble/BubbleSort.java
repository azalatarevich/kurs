package by.home.bubble;


public class BubbleSort
{
    private static int[] list = new int[100000];

    public static void main(String[] args)
    {
        System.out.println("Array before sorting");
        fill( );                // заполнение массива числами
        print( );               // вывод

        long start = System.currentTimeMillis();
        sortArray();            // sort list
        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Array after sorting");
        print( );               // print the result
        System.out.println();
        System.out.println("Taken time for sorting = " + (end - start));
    }


    /**
     Сортировка пузырьком выполняется посредством сравнения
     текущего элемента с предыдущим и если условие "больше" выполняется,
     то они меняются местами
     */
    private static void sortArray()
    {
        for(int i=0; i< list.length - 1; i++)
        {
            for (int j = 1; j < list.length; j++) {
                if (list[j] < list[j - 1]) {
                    swap(list, j, j-1);
                }
            }
        }
    }


    private static void print( )
    {
        int counter = 0;
        for(int i = 0; i < list.length; i++)
        {
            System.out.print(list[i] + " ");
            if(counter == 20)
            {
                System.out.println();
                counter = 0;
            }
            counter++;
        }
    }

    private static void fill()
    {
        for( int i = 0; i < list.length; i++ )
        {
            list[i] = (int) (Math.random() * 1000);
        }
    }


    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}