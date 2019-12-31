package by.home.shell;

public class ShellSort
{

    private static int[] array;

    public static void main(String[] args)
    {
        System.out.println("Array before sorting");
        fill( 100000 );                // заполнение массива числами
        print( );                            // вывод

        long start = System.currentTimeMillis();
        shellSort( );                      // sort list
        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Array after sorting");
        print( );                            // print the result
        System.out.println();
        System.out.println("Taken time for sorting = " + (end - start));
    }

    private static void shellSort()
    {
        int gap = array.length / 2;
        // Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array[c] > array[c + gap]) {
                        swap(array, c, c + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
    }


    private static void print( )
    {
        int counter = 0;
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
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
        array = new int[size];

        for( int i = 0; i < array.length; i++ )
        {
            array[i] = (int) (Math.random() * 1000);
        }
    }


    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
