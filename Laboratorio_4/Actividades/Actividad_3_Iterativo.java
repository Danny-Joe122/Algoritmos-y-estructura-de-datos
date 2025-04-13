package BinarySearchIterativo;

public class BinarySearchIterativo {

    public int binarySearch(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1; // No encontrado
    }

    public static void main(String[] args) {
        BinarySearchIterativo ob = new BinarySearchIterativo();
        int[] arr = {1, 2, 3, 4, 5};
        int x = 3;
        int position = ob.binarySearch(arr, x);

        if (position == -1)
            System.out.println("Elemento no presente");
        else
            System.out.println("Elemento encontrado en el índice: " + position);
    }
}
