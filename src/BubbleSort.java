package src; // 현재 파일이 속한 폴더(패키지) 위치를 명시

import java.util.Arrays; // 배열의 내용을 쉽게 출력하기 위해 Arrays 클래스 가져오기

// 버블 정렬 클래스
public class BubbleSort {
    public static void main(String[] args) {
        // 정렬할 초기 배열
        int[] arr = {64, 25, 12, 22, 11};
        
        System.out.println("정렬 전: " + Arrays.toString(arr));
        
        // 정렬 메서드 실행
        bubbleSort(arr);
        
        System.out.println("정렬 후: " + Arrays.toString(arr));
    }

    // 실제 버블 정렬을 수행하는 메서드
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // n은 배열의 전체 길이(크기)를 의미
        
        // 1. 외부 루프: 배열을 처음부터 끝까지 훑는 '회전 수'를 제어
        // 배열 크기가 5라면, 제일 큰 숫자 4개를 뒤로 보내면 나머지 1개는 자동으로 정렬되므로 (n - 1)번만 반복함
        for (int i = 0; i < n - 1; i++) {
            
            // 2. 내부 루프: 실제로 인접한 두 원소를 짝지어 비교하는 부분
            // (n - 1 - i)인 이유: 1회전이 끝날 때마다 가장 큰 값이 맨 뒤에 하나씩 확정되어 고정됨.
            // 따라서 이미 정렬이 완료된 맨 뒷부분은 굳이 다시 비교할 필요가 없게 '- i'를 붙여 범위를 줄임
            for (int j = 0; j < n - 1 - i; j++) {
                
                // 3. 조건문: 앞의 숫자(arr[j])가 뒤의 숫자(arr[j + 1])보다 크다면 자리를 바꿔야 함 (오름차순 기준)
                if (arr[j] > arr[j + 1]) {
                    
                    // 값 교환(Swap): 두 컵의 내용물을 바꾸려면 빈 컵이 하나 더 필요한 것과 같은 원리
                    int temp = arr[j];       // 빈 컵(temp)에 앞의 숫자를 잠시 담아둠
                    arr[j] = arr[j + 1];     // 비어있는 앞 자리에 뒤의 숫자를 옮겨 적음
                    arr[j + 1] = temp;       // 뒤의 자리에 아까 담아둔 앞의 숫자를 넣음
                }
            }
        }
    }
}
