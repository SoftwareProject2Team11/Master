package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import db.TrainingRequestDAO;
import db.UserDAO;
import odata.EmployeeOdata;

public class Statistics {

	public TrainingRequest mostFollowed() {
		List<TrainingRequest> list = new TrainingRequestDAO().getAllRequestsForStats();

		int index = -1;
		int count = 0;
		int max = 0;
		Collections.sort(list, new SorteerOpTrainingId());

		for (int i = 0; i < list.size(); i++) {

			if (i != list.size() - 1) {

				if (list.get(i).getTrainingId() == list.get(i + 1).getTrainingId()) {

					count = count + 1;
				}
				if (count > max) {
					index = i;
					max = count;
					count = 0;
				}
			}
		}
		return list.get(index+1);
	}
	
	
	public String mostFollowing()
	{
		List<TrainingRequest> list = new TrainingRequestDAO().getAllRequestsForStats();

		int index = -1;
		int count = 0;
		int max = 0;
		Collections.sort(list, new SorteerOpTrainingId());

		for (int i = 0; i < list.size(); i++) {

			if (i != list.size() - 1) {

				if (list.get(i).getUserId() == list.get(i + 1).getUserId()) {

					count = count + 1;
				}
				if (count > max) {
					index = i;
					max = count;
					count = 0;
				}
			}
		}
		
		String emp = new EmployeeOdata().getEmployeeCorrectNameById(list.get(index+1).getUserId());
		
		return emp;
	}
	
	public List<String> allFollowing()
	{
				
		List<TrainingRequest> list = new TrainingRequestDAO().getAllFollowing();
		List<Integer> diff = new ArrayList<Integer>();
		List<String> emps = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			diff.add(list.get(i).getUserId());
		}
		
		for (int i = 0; i < diff.size(); i++) {
			emps.add(new UserDAO().getAllFollowing(diff.get(i)));
		}
		
		return emps;
	}
	
	

	
	
	
	

}
