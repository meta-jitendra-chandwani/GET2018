import java.util.ArrayList;
import java.util.List;

public class CricketProblem {

	CricketProblem(){}
	
	/**
	 * 
	 * @param numberOfBowler - total bowlers
	 * @param numberOfBalls - total balls left for virat
	 * @param bowlerQuota - bowlerQuota[i] - quota for i'th bowler,
	 *                       0 <= i < numberOfBowler
	 * @return - List of bowlers index choose by Captain 
	 */
	public int[] strategy(int numberOfBowler, int numberOfBalls, int quotaList[]) {
		
		Bowler bowlerQuota[] = new Bowler[numberOfBowler];
		for(int i=0; i<numberOfBowler; i++) {
			bowlerQuota[i] = new Bowler(i+1, quotaList[i]);
		}
		
		PriorityQueue pq = new MaxPriorityQueue(bowlerQuota.length);
		for(Bowler bowler: bowlerQuota) {
			pq.insert(bowler);
		}
		
		int viratBallsLeft = numberOfBalls;
		List<Integer> bowlerChoose = new ArrayList<Integer>();
		while(viratBallsLeft > 0 && !pq.isEmpty()) {
			Bowler b1 = pq.pop();
			viratBallsLeft = viratBallsLeft - ( b1.getQuota() - pq.peek().getQuota() + 1 );
			bowlerChoose.add(b1.getIndex());
			b1.setQuota(pq.peek().getQuota() - 1);
			pq.insert(b1);
		}
		int bowlerOrder[] = new int[bowlerChoose.size()];
		for(int i=0; i<bowlerChoose.size(); i++) {
			bowlerOrder[i] = bowlerChoose.get(i);
		}
		return bowlerOrder;
	}
}
