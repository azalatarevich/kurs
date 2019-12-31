package by.home.shuttle;

public class ShuttleSort
{
    private static int[] list;


    public static void main(String[] args)
    {
        System.out.println("Array before sorting");
        fill( 100000 );                // заполнение массива числами
        print( );                            // вывод

        long start = System.currentTimeMillis();
        shuttleSort( );                      // sort list
        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Array after sorting");
        print( );                            // print the result
        System.out.println();
        System.out.println("Taken time for sorting = " + (end - start));
    }

    private static void shuttleSort( )
    {
        for (int i = 1; i < list.length; i++)
        {
            if (list[i] < list[i - 1])
            {
                swap(list, i, i - 1);

                for (int z = i - 1; (z - 1) >= 0; z--)
                {
                    if (list[z] < list[z - 1])
                    {
                        swap(list, z, z - 1);
                    }
                    else
                    {
                        break;
                    }
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


    private static void fill( int size )
    {
        list = new int[size];

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