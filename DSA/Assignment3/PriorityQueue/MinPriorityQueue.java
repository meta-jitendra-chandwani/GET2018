
public class MinPriorityQueue implements PriorityQueue{

	private int queue[];
	private int lastIndex;
	
	MinPriorityQueue(int sizeOfQueue){
		this.queue = new int[sizeOfQueue+1];
		this.lastIndex = 0;
	}
	
	@Override
	public void insert(int value) {
		try {
			if(this.lastIndex == this.queue.length-1) {
				throw new ArrayIndexOutOfBoundsException("Queue if full!");
			}
			this.lastIndex ++;
			this.queue[this.lastIndex] = Integer.MAX_VALUE;
			this.increaseKey(this.lastIndex, value);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

	@Override
	public int peek() {
		return this.queue[1];
	}

	@Override
	public int pop() {
		try {
			if(this.isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("Queue is Empty!");
			}
			int min = this.queue[1];
			this.queue[1] = this.queue[this.lastIndex];
			this.lastIndex --;
			this.minHeapify(1);
			return min;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return 0;
		}
	}

	@Override
	public void increaseKey(int index, int newValue) {
		try {
			if(newValue > this.queue[index]) {
				throw new ArrayIndexOutOfBoundsException("New Value is smaller than Current Value");
			}
			this.queue[index] = newValue;
			while(index > 1 && this.queue[index/2] > this.queue[index]) {
				int temp = this.queue[index];
				this.queue[index] = this.queue[index/2];
				this.queue[index/2] = temp;
				index = index / 2;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public boolean isEmpty() {
		return this.lastIndex == 0;
	}
	
	/**
	 * Maintain heap 
	 * @param index - index of value
	 */
	public void minHeapify(int index) {
		int left = 2 * index ;
		int right = 2 * index + 1;
		int minimum = index;
		if(left <= this.lastIndex && this.queue[left] < this.queue[minimum]) {
			minimum = left;
		}
		if(right <= this.lastIndex && this.queue[right] < this.queue[minimum]) {
			minimum = right;
		}
		if(minimum != index) {
			int temp = this.queue[index];
			this.queue[index] = this.queue[minimum];
			this.queue[minimum] = temp;
			this.minHeapify(minimum);
		}
	}
	
}
