import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(courses[i]))
                return false;
        }
        return true;
    }

    private boolean isCyclic(Course cur) {
        if (cur.tested == true)
            return false;
        if (cur.visited == true)
            return true;
        cur.visited = true;
        for (Course c : cur.pre) {
            if (isCyclic(c)) {
                return true;
            }
        }
        cur.tested = true;
        return false;
    }

    class Course {
        boolean visited = false;
        boolean tested = false;
        List<Course> pre = new ArrayList<Course>();

        public void add(Course c) {
            pre.add(c);
        }
    }

    public static void main(String[] agrs) {
        Problem2 problem2 = new Problem2();

        // Test case 1
        int numberOfCourses = 2;
        int[][] prerequisites1 = { { 1, 0 } };
        boolean canFinish = problem2.canFinish(numberOfCourses, prerequisites1);
        System.out.println("Can Finish? " + canFinish);

        // Test case 2
        numberOfCourses = 2;
        int[][] prerequisites2 = { { 1, 0 }, { 0, 1 } };
        canFinish = problem2.canFinish(numberOfCourses, prerequisites2);
        System.out.println("Can Finish? " + canFinish);
    }
}
