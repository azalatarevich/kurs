package by.home.quick;

public class QuickSort
{

    private static int[] list;

    public static void main(String[] args)
    {

        System.out.println("Array before sorting");
        fill( 100000 );                // заполнение массива числами
        print( );               // вывод

        long start = System.currentTimeMillis();
        quickSort(list, 0, list.length -1  );            // sort list
        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Array after sorting");
        print( );               // print the result
        System.out.println();
        System.out.println("Taken time for sorting = " + (end - start));
    }

    /**
     * Быстрая сортировка или сортировка Хоара
     * алгоритмическую сложность равна O(n log n)
     */
    private static void quickSort(int[] source, int leftBorder, int rightBorder)
    {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
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
}