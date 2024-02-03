import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MeetingRoomProblem {
	static class mycomparator implements Comparator<meeting> {
		@Override
		public int compare(meeting o1, meeting o2) {
			if (o1.start < o2.start) {
				return -1;
			} else if (o1.start > o2.start)
				return 1;

			return 0;
		}
	}
	
	static class mycomparator1 implements Comparator<meeting> {
		@Override
		public int compare(meeting o1, meeting o2) {
			if (o1.end < o2.end) {
				return -1;
			} else if (o1.end > o2.end)
				return 1;

			return 0;
		}
	}

	static class meeting {
		int start;
		int end;

		meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		int s[] = {3, 0, 5, 8, 5, 1 };
		int f[] = {4, 6, 7, 9, 9, 2 };

		ArrayList<meeting> meet = new ArrayList<>();
		for (int i = 0; i < s.length; i++)
			meet.add(new meeting(s[i], f[i]));

		Collections.sort(meet, new mycomparator());
		Collections.sort(meet, new mycomparator1());
		ArrayList<meeting> result = new ArrayList<>();
		result.add(meet.get(0));
		for(int i = 1; i<meet.size(); i++) {
			if(meet.get(i).start>=meet.get(i-1).end) {
				result.add(meet.get(i));
			}else {
				meet.get(i).end = meet.get(i-1).end;
			}
		}
		for(int i = 0; i<result.size(); i++)
			System.out.println(result.get(i).start + "  "+result.get(i).end);
	}
}