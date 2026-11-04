package src;
import java.util.Arrays;

//병합 정렬 (margeSort)
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 90, 88};
        
        System.out.println("정렬 전: " + Arrays.toString(arr));
        
        // 배열을 담을 임시 배열(temp)을 하나 만듦 (병합할 때 사용)
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        
        System.out.println("정렬 후: " + Arrays.toString(arr));
    }

    // 배열을 반씩 쪼개는 메서드 (재귀 호출)
    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        // 쪼갤 수 있는 구간이 남아있을 때만 실행
        if (left < right) {
            int mid = left + (right - left) / 2; // 중간 지점 계산

            // 1. 왼쪽 절반 쪼개기
            mergeSort(arr, temp, left, mid);
            // 2. 오른쪽 절반 쪼개기
            mergeSort(arr, temp, mid + 1, right);
            
            // 3. 쪼개진 두 배열을 하나로 병합(Merge)하며 정렬
            merge(arr, temp, left, mid, right);
        }
    }

    // 두 개의 정렬된 부분 배열을 하나로 합치는 메서드
    public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      // 왼쪽 배열의 시작 인덱스
        int j = mid + 1;   // 오른쪽 배열의 시작 인덱스
        int k = left;      // 임시 배열(temp)에 값을 채워넣을 인덱스

        // 양쪽 배열 모두 원소가 남아있는 동안 크기를 비교하며 temp에 복사
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++]; // 왼쪽 배열 값이 작거나 같으면 temp에 넣고 인덱스 증가
            } else {
                temp[k++] = arr[j++]; // 오른쪽 배열 값이 작으면 temp에 넣고 인덱스 증가
            }
        }

        // 위 반복문이 끝나고 왼쪽 배열에 원소가 남았다면 그대로 다 털어넣기
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        // 오른쪽 배열에 원소가 남았다면 그대로 다 털어넣기
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 정렬이 완료된 임시 배열(temp)의 값을 다시 원본 배열(arr)로 덮어씌움
        for (int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }
}