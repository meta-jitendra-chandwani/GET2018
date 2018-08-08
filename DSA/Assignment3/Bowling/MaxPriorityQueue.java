
public class MaxPriorityQueue implements PriorityQueue{

	private Bowler queue[];
	private int lastIndex;
	
	MaxPriorityQueue(int sizeOfQueue){
		this.queue = new Bowler[sizeOfQueue+1];
		this.lastIndex = 0;
	}
	
	public void insert(Bowler bowler) {
		try {
			if(this.lastIndex == this.queue.length-1) {
				throw new ArrayIndexOutOfBoundsException("Queue if full!");
			}
			this.lastIndex ++;
			int index = this.lastIndex;
			this.queue[index] = bowler;
			while(index > 1 && this.queue[index/2].getQuota() < this.queue[index].getQuota()) {
				Bowler temp = this.queue[index];
				this.queue[index] = this.queue[index/2];
				this.queue[index/2] = temp;
				index = index / 2;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

	/**
	 * peek() - 
	 */
	public Bowler peek() {
		return this.queue[1];
	}

	public Bowler pop() {
		try {
			if(this.isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("Queue is Empty!");
			}
			Bowler maxQuotaBowler = this.queue[1];
			this.queue[1] = this.queue[this.lastIndex];
			this.lastIndex --;
			this.maxHeapify(1);
			return maxQuotaBowler;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean isEmpty() {
		return this.lastIndex == 0;
	}
	
	/**
	 * Maintain heap 
	 * @param index - index of value
	 */
	public void maxHeapify(int index) {
		int left = 2 * index ;
		int right = 2 * index + 1;
		int maximum = index;
		if(left <= this.lastIndex && this.queue[left].getQuota() > this.queue[maximum].getQuota()) {
			maximum = left;
		}
		if(right <= this.lastIndex && this.queue[right].getQuota() > this.queue[maximum].getQuota()) {
			maximum = right;
		}
		if(maximum != index) {
			Bowler temp = this.queue[index];
			this.queue[index] = this.queue[maximum];
			this.queue[maximum] = temp;
			this.maxHeapify(maximum);
		}
	}
	
}
