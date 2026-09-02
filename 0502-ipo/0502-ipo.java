class Solution {
    public int findMaximizedCapital(int numProjects, int initialCapital, int[] profits, int[] capital) {
        int projectIndex = 0;
        int totalProjects = profits.length;
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < totalProjects; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }
        projects.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int currentProject = 0; currentProject < numProjects; currentProject++) {
            while (projectIndex < totalProjects && projects.get(projectIndex)[0] <= initialCapital) {
                maxProfitHeap.add(projects.get(projectIndex)[1]);
                projectIndex++;
            }
            if (maxProfitHeap.isEmpty()) {
                return initialCapital;
            }
            initialCapital += maxProfitHeap.poll();
        }
        return initialCapital;
    }
}