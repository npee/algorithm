package programmers.kakao.blind_recruitment_2021._3_;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
    
        solution(info, query);
    }

    private static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[][] infoArr = new String[info.length][5];
        String[][] queryArr = new String[query.length][5];

        for (int i = 0; i < info.length; i++) {
            infoArr[i] = info[i].split(" ");
        }

        for (int i = 0; i < query.length; i++) {
            queryArr[i] = query[i].replace(" and ", " ").split(" ");
        }



        InfoTable infoTable = new InfoTable();
        for (String[] infos: infoArr)
            infoTable.insert(infos);

        System.out.println(infoTable.root.childNodes.entrySet().toString());


        for (int i = 0; i < queryArr.length; i++) {
            answer[i] = infoTable.getCount(queryArr[i]);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }



//        for (int i = 0; i < queryArr.length; i++) {
//            for (int j = 0; j < infoArr.length; j++) {
//                boolean isValidate = true;
//                for (int k = 0; k < 4; k++) {
//                    if (!queryArr[i][k].equals(infoArr[j][k]) && !queryArr[i][k].equals("-")) {
//                        isValidate = false;
//                    }
//                }
//                if (Integer.parseInt(infoArr[j][4]) >= Integer.parseInt(queryArr[i][4]) && isValidate) {
//                    answer[i]++;
//                }
//            }
//        }

        return answer;
    }
}

class Node {
    Map<String, Node> childNodes;
    List<Integer> scoreList;

    Node() {
        childNodes = new HashMap<>();
        scoreList = new ArrayList<>();
    }

    Map<String, Node> getChildNodes() {
        return this.childNodes;
    }

    @Override
    public String toString() {
        return this.childNodes.entrySet().toString();
    }
}

class InfoTable {
    Node root;

    InfoTable() {
        root = new Node();
    }

    void insert(String[] infos) {
        Node currentNode = root;

        for (int i = 0; i < infos.length; i++) {
            currentNode = currentNode.getChildNodes().computeIfAbsent(infos[i], info -> new Node());
        }

    }

    int getCount(String[] queries) {
        Node currentNode = this.root;

        for (int i = 0; i < queries.length - 1; i++) {
            String query = queries[i];
            if (!currentNode.getChildNodes().containsKey(query)) {
                return 0;
            }
            currentNode = currentNode.getChildNodes().get(query);
        }
        System.out.println(currentNode.getChildNodes().entrySet());

        return 1;
    }

}
