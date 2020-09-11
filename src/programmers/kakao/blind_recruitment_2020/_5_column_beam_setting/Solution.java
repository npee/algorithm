package programmers.kakao.blind_recruitment_2020._5_column_beam_setting;

class Solution {
    public static void main(String[] args) {
        int[][] input1 = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        // 기대값: [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
        int[][] input2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        // 기대값: [[0,0,0],[0,1,1],[1,1,1],[2,1,1],[3,1,1],[4,0,0]]

        print(solution(5, input1));
        print(solution(5, input2));
    }

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = new int[build_frame.length][3];
        int works = 0;

        int[][] wall = new int[n + 1][n + 1];
        for (int i = 0; i < wall.length; i++) {
            wall[0][i] = 1;
        }

        printWall(wall);

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0]; // x좌표
            int y = build_frame[i][1]; // y좌표
            int a = build_frame[i][2]; // 구조물
            int b = build_frame[i][3]; // 작업 종류

            /*
            // 벽 벗어나는 경우
            // 기둥의 x값은 0 미만 n 초과, 보의 x값은 0 미만 n 이상
            // 기둥의 y값은 0 미만 n 이상, 보의 y값은 0 이하 n 초과
            if (a == 0) { // 기둥일 때
                if (x < 0 || x > n || y < 0 || y >= n) {
                    break;
                }
            } else {
                if (x < 0 || x >= n || y <= 0 || y > n) {
                    break;
                }
            }

            // 중복 작업
            for (int j = 0; j < works; j++) {
                if (answer[j][0] == x && answer[j][1] == y && answer[j][2] == a && answer[j][3] == b) {
                    break;
                }
            }
             */
            // 불가능한 경우

            if (b == 0) { // 삭제
                if (a == 0) { // 기둥

                } else { // 보

                }
            } else { // 설치
                if (a == 0) { // 기둥
                    // 조건 - 바닥, 보의 끝, 다른 기둥 위
                    if (/*y == 0*/ wall[y][x] == 1) { // 바닥(기둥위)
                        answer[works][0] = x;
                        answer[works][1] = y;
                        answer[works][2] = a;
                        wall[y + 1][x] = 1;
                        printWall(wall);
                        works++;
                    }

                } else { // 보

                }

            }

        }

        // 정렬

        return answer;
    }

    public static void printWall(int[][] wall) {
        System.out.print("┌");
        for (int top = 0; top < wall.length * 2 - 1; top++) {
            System.out.print("─");
        }
        System.out.println("┐");

        for (int i = wall.length - 1; i >= 0; i--) {
            for (int j = 0; j < wall[0].length; j++) {
                if (j == 0) {
                    System.out.print("│");
                }
                if (j == wall[0].length - 1) {
                    System.out.println(wall[i][j] + "│");
                } else {
                    System.out.print(wall[i][j] + " ");
                }
            }
        }

        System.out.print("└");
        for (int top = 0; top < wall.length * 2 - 1; top++) {
            System.out.print("─");
        }
        System.out.println("┘");

    }


    public static void print(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[0].length; j++) {
                if (j == arr[0].length - 1) {
                    System.out.print(arr[i][j]);
                    break;
                }
                System.out.print(arr[i][j] + ",");
            }
            if (i == arr.length - 1) {
                System.out.print("]");
                break;
            }
            System.out.print("],");
        }
        System.out.println("]");
    }
}
