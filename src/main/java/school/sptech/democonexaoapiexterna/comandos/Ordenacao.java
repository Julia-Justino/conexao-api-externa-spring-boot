package school.sptech.democonexaoapiexterna.comandos;

public class Ordenacao {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid); // Ordena a metade esquerda
            mergeSort(arr, temp, mid + 1, right); // Ordena a metade direita
            merge(arr, temp, left, mid, right); // Combina as duas metades ordenadas
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copia os elementos para o array temporário
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Índice inicial da metade esquerda
        int j = mid + 1; // Índice inicial da metade direita
        int k = left; // Índice inicial do array final

        // Mescla as duas metades ordenadas
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copia os elementos restantes da metade esquerda, se houver
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
///////////////////////////
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Encontra o índice do pivô após a partição
            quickSort(arr, low, pivotIndex - 1); // Recursivamente ordena os elementos menores que o pivô
            quickSort(arr, pivotIndex + 1, high); // Recursivamente ordena os elementos maiores que o pivô
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Escolhe o último elemento como pivô
        int i = low - 1; // Índice do menor elemento

        for (int j = low; j < high; j++) {
            // Se o elemento atual for menor ou igual ao pivô, troca com o próximo elemento do menor índice
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Coloca o pivô na posição correta
        return i + 1; // Retorna o índice do pivô
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
//////////////
    public static int pesquisaBinaria(int[] arr, int t) {
        int esq = 0;
        int dir = arr.length - 1;

        while (esq <= dir) {
            int media = esq + (dir - esq) / 2;
            if (arr[media] == t) {
                return media;
            }
            if (arr[media] > t) {
                dir = media - 1;
            }
            else {
                esq = media + 1;
            }
        }
        return -1;
    }
}
