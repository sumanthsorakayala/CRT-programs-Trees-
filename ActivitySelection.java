import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start, end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelection {

    public static void selectActivities(List<Activity> activities) {
        // Sort by end time
        activities.sort(Comparator.comparingInt(a -> a.end));

        int lastEnd = 0;
        for (Activity act : activities) {
            if (act.start >= lastEnd) {
                System.out.println("Selected: (" + act.start + ", " + act.end + ")");
                lastEnd = act.end;
            }
        }
    }

    public static void main(String[] args) {
        List<Activity> activities = Arrays.asList(
            new Activity(1, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9),
            new Activity(5, 9)
        );
        selectActivities(activities);
    }
}