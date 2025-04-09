package hw4;

import java.util.Comparator;

class WeightComparator implements Comparator<Orders> {


	public int compare(Orders o1, Orders o2) {
		double weight1 = (o1.getExecTime() - (o1.getTimeReqDel() - Kitchen.getTimeNow())) / (double) o1.getExecTime();
		double weight2 = (o2.getExecTime() - (o2.getTimeReqDel() - Kitchen.getTimeNow())) / (double) o2.getExecTime();

		int max = 0;
		// Compare based on your conditions
		if ((max < weight1) && o1.isAvailable()) {
			if ((max < weight2) && o2.isAvailable()) {
				return 0; // Both satisfy condition
			} else {
				return -1; // o1 satisfies condition, but o2 doesn't
			}
		} else {
			if ((max < weight2) && o2.isAvailable()) {
				return 1; // o2 satisfies condition, but o1 doesn't
			} else {
				return 0; // Neither satisfy condition
			}
		}

	}
}
