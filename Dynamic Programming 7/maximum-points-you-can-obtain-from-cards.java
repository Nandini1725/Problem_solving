class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int first = 0;
        for (int i = 0; i < k; i++) {
            first += cardPoints[i];
        }

        int second = 0;
        int maxScore = first;

        int front = k - 1;
        int end = cardPoints.length - 1;
        while (front >= 0) {
            first -= cardPoints[front];
            second += cardPoints[end];
            maxScore = Math.max(maxScore, first + second);
            front--;
            end--;
        }
        return maxScore;
    }
}
