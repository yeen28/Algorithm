class Solution {
    public int solution(int n, int w, int num) {
        int answer = -1;
        int[][] boxMap = loadBox(n, w);
        
        for (int i = 0; i < boxMap.length; i++) {
            for (int j = 0; j < boxMap[i].length; j++) {
                if (boxMap[i][j] == num) {
                    if (boxMap[0][j] == 0) {
                        return i;
                    } else {
                        return i + 1;
                    }
                }
            }
        }
        
        return answer;
    }
    
    /**
     * 박스 쌓기
     */
    private int[][] loadBox(int n, int w) {
        int layer = n / w + 1;
        int[][] boxMap = new int[layer][w];
        int boxIdx = 1;
        
        for (int i = layer - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                for (int j = 0; j < w; j++) {
                    if (boxIdx > n) {
                        return boxMap;
                    }
                    
                    boxMap[i][j] = boxIdx;
                    boxIdx++;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    if (boxIdx > n) {
                        return boxMap;
                    }
                    
                    boxMap[i][j] = boxIdx;
                    boxIdx++;
                }
            }
        }
        
        return boxMap;
    }
}