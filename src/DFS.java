package src;

/*dfs- 깊이 우선 탐색 : 미로를 찾을 때 갈림김이 나오면 한쪽 길로 끝까지 파고들어 가보고,
 더 이상 갈 곳이 없으면 방금 전 갈림길로 돌아와 다른 길을 찾는 방식. 보통 재귀함수를 사용하여 직관적으로 구현
*/
 public class DFS {
    // 방문 처리를 위한 boolean 배열 (기본값 false)
    static boolean[] visited;
    
    // 그래프 연결 상태를 표현한 2차원 배열 (인접 리스트 방식)
    // 인덱스 번호가 노드 번호를 의미하며, 배열 안의 숫자들은 연결된 노드를 뜻함
    static int[][] graph = {
        {},         // 0번 노드는 비워둠 (직관적으로 1번부터 사용하기 위함)
        {2, 3, 8},  // 1번 노드와 연결된 노드들
        {1, 7},     // 2번 노드와 연결된 노드들
        {1, 4, 5},  // 3번 노드...
        {3, 5},
        {3, 4},
        {7},
        {2, 6, 8},
        {1, 7}
    };

    public static void main(String[] args) {
        // 노드가 총 8개이므로, 인덱스 8까지 쓰기 위해 크기를 9로 설정
        visited = new boolean[9];
        
        System.out.print("DFS 탐색 순서: ");
        dfs(1); // 1번 노드부터 탐색 시작
    }

    // DFS 메서드 (재귀 함수)
    public static void dfs(int nodeIndex) {
        // 1. 현재 노드를 방문 처리하고 출력
        visited[nodeIndex] = true;
        System.out.print(nodeIndex + " -> ");

        // 2. 현재 노드와 연결된 다른 노드들을 순회
        for (int linkedNode : graph[nodeIndex]) {
            // 3. 연결된 노드 중 아직 방문하지 않은 노드가 있다면
            if (!visited[linkedNode]) {
                // 그 노드로 더 깊이 파고들어감 (재귀 호출)
                dfs(linkedNode); 
            }
        }
    }
}