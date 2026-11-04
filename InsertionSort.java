import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        
        System.out.println("정렬 전: " + Arrays.toString(arr));
        System.out.println("------------------------------------");
        
        insertionSort(arr);
        
        System.out.println("------------------------------------");
        System.out.println("정렬 후: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // 1. 외부 루프: 0번 인덱스는 이미 정렬되어 있다고 가정하고, 1번 인덱스의 원소부터 정렬을 시작합니다.
        for (int i = 1; i < n; i++) {
            
            int target = arr[i]; // 현재 정렬할 대상(타겟) 값을 따로 변수에 저장해 둡니다.
            int j = i - 1;       // 타겟 바로 앞(왼쪽) 인덱스부터 비교를 시작합니다.

            // 2. 내부 루프(while):
            // - 비교할 인덱스(j)가 범위(0 이상) 내에 있고
            // - 왼쪽 원소(arr[j])가 현재 타겟(target)보다 크다면 계속 반복합니다.
            while (j >= 0 && arr[j] > target) {
                arr[j + 1] = arr[j]; // 타겟보다 큰 값은 오른쪽으로 한 칸 밀어냅니다.
                j--;                 // 그 다음 왼쪽 원소와 비교하기 위해 인덱스를 줄입니다.
            }

            // 3. 위치 확정: 자신보다 큰 값들을 다 밀어내고 남은 빈자리(j + 1)에 타겟 값을 넣습니다.
            arr[j + 1] = target;

            // [공부용] 현재 회전이 끝난 후 배열의 상태를 출력해 과정을 확인합니다.
            System.out.println(i + "회전 후 (타겟값 " + target + " 삽입 완료): " + Arrays.toString(arr));
        }
    }
}