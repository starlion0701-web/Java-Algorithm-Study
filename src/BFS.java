package src;

/*
BFS - 너비 우선 탐색 : 시작점에서 가까운 곳부터 물결이 퍼져나가듯 탐색, 최단 거리를
찾을 때 주로 사용되며, 먼저 발견한 노드를 먼저 방문해야 하므로 큐(Queue) 자료구조를 사용
*/
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static boolean[] visited;
    static int[][] graph = {
        {},
        {2, 3, 8},
        {1, 7},
        {1, 4, 5},
        {3, 5},
        {3, 4},
        {7},
        {2, 6, 8},
        {1, 7}
    };

    public static void main(String[] args) {
        visited = new boolean[9];
        
        System.out.print("BFS 탐색 순서: ");
        bfs(1); // 1번 노드부터 시작
    }

    // BFS 메서드 (큐 사용)
    public static void bfs(int startNode) {
        // 1. 탐색을 대기할 큐(Queue) 생성
        Queue<Integer> queue = new LinkedList<>();

        // 2. 시작 노드를 큐에 넣고 방문 처리
        queue.offer(startNode);
        visited[startNode] = true;

        // 3. 큐가 빌 때까지(더 이상 탐색할 노드가 없을 때까지) 반복
        while (!queue.isEmpty()) {
            // 큐에서 가장 먼저 들어온 노드를 꺼냄
            int currentNode = queue.poll();
            System.out.print(currentNode + " -> ");

            // 꺼낸 노드와 연결된 인접 노드들을 순회
            for (int linkedNode : graph[currentNode]) {
                // 아직 방문하지 않은 인접 노드라면
                if (!visited[linkedNode]) {
                    // 큐에 대기열로 밀어넣고 방문 처리 (미리 도장을 찍어 중복 대기를 방지)
                    queue.offer(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }
    }
}