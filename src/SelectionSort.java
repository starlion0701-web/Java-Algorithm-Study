import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        
        System.out.println("정렬 전: " + Arrays.toString(arr));
        System.out.println("------------------------------------");
        
        selectionSort(arr);
        
        System.out.println("------------------------------------");
        System.out.println("정렬 후: " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // 1. 외부 루프: 정렬할 위치(i)를 지정합니다.
        // n-1 개가 정렬되고 나면 마지막 1개는 자동으로 가장 큰 값이 되므로 (n - 1)까지만 반복합니다.
        for (int i = 0; i < n - 1; i++) {
            
            // 현재 위치(i)를 일단 최솟값이 위치한 인덱스로 가정한 후 시작합니다.
            int minIndex = i;

            // 2. 내부 루프: i의 다음 칸(i + 1)부터 배열 끝(n - 1)까지 탐색하며 진짜 최솟값을 찾습니다.
            for (int j = i + 1; j < n; j++) {
                // 현재 알고 있는 최솟값(arr[minIndex])보다 더 작은 값을 발견하면
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 최솟값의 위치(인덱스)를 새로 발견한 위치로 갱신합니다.
                }
            }

            // 3. 값 교환(Swap): 진짜 최솟값의 인덱스(minIndex)를 찾았으므로 현재 정렬 위치(i)의 값과 자리를 바꿉니다.
            // (자기 자신이 최솟값이라면 굳이 자리를 바꾸지 않습니다)
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

            // [공부용] 현재 회전이 끝난 후 배열의 상태를 출력해 과정을 확인합니다.
            System.out.println((i + 1) + "회전 후 (인덱스 " + i + "에 최솟값 " + arr[i] + " 확정): " + Arrays.toString(arr));
        }
    }
}