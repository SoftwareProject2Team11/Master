package logic;

import java.util.Comparator;

public class SorteerOpTrainingId implements Comparator<TrainingRequest> {

	@Override
	public int compare(TrainingRequest o1, TrainingRequest o2) {
		
		return o1.getTrainingId() - o2.getTrainingId();
	}

}
