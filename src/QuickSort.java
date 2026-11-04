package src;
import java.util.Arrays;
//퀵 정렬
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 90, 88};
        
        System.out.println("정렬 전: " + Arrays.toString(arr));
        
        // 배열의 처음(0)부터 끝(length - 1)까지 퀵 정렬 수행
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println("정렬 후: " + Arrays.toString(arr));
    }

    // 퀵 정렬 메인 메서드 (재귀 호출 사용)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partition 메서드를 통해 피벗(pivot)의 올바른 위치를 찾고 배열을 둘로 나눔
            int pivotIndex = partition(arr, low, high);

            // 피벗을 기준으로 왼쪽 부분 배열 정렬
            quickSort(arr, low, pivotIndex - 1);
            // 피벗을 기준으로 오른쪽 부분 배열 정렬
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 피벗을 기준으로 배열을 나누고(Partition) 피벗의 최종 위치를 반환하는 메서드
    public static int partition(int[] arr, int low, int high) {
        // 가장 오른쪽 값을 피벗으로 설정
        int pivot = arr[high]; 
        
        // i는 피벗보다 작은 값들이 들어갈 위치를 가리킴 (초기값은 범위의 밖)
        int i = (low - 1);

        // low부터 high-1까지 탐색하며 피벗과 비교
        for (int j = low; j < high; j++) {
            // 현재 원소가 피벗보다 작거나 같으면
            if (arr[j] <= pivot) {
                i++; // 작은 값이 들어갈 자리를 한 칸 늘리고
                
                // arr[i]와 arr[j]의 위치를 교환 (작은 값을 왼쪽으로 보냄)
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 탐색이 끝나면 피벗(arr[high])을 자기 자리(작은 값들 바로 다음인 i+1)로 이동
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 피벗이 위치하게 된 최종 인덱스 반환
    }
}