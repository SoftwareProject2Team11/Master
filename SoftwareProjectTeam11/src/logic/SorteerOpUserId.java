package logic;

import java.util.Comparator;

public class SorteerOpUserId implements Comparator<TrainingRequest> {

	@Override
	public int compare(TrainingRequest o1, TrainingRequest o2) {
		
		return o1.getUserId() - o2.getUserId();
	}
}
