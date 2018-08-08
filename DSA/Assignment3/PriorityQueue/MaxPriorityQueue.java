
public class MaxPriorityQueue implements PriorityQueue{

	private int queue[];
	private int lastIndex;
	
	MaxPriorityQueue(int sizeOfQueue){
		this.queue = new int[sizeOfQueue + 1];
		this.lastIndex = 0;
	}
	
	@Override
	public void insert(int value) {
		try {
			if(this.lastIndex == this.queue.length-1) {
				throw new ArrayIndexOutOfBoundsException("Queue if full!");
			}
			this.lastIndex ++;
			this.queue[this.lastIndex] = Integer.MAX_VALUE*(-1);
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
	public int pop() throws ArrayIndexOutOfBoundsException{
		if(this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty!");
		}
		int max = this.queue[1];
		this.queue[1] = this.queue[this.lastIndex];
		this.lastIndex --;
		this.maxHeapify(1);
		return max;
	}

	@Override
	public void increaseKey(int index, int newValue) {
		try {
			if(newValue < this.queue[index]) {
				throw new ArrayIndexOutOfBoundsException("New Value is smaller than Current Value");
			}
			this.queue[index] = newValue;
			while(index > 1 && this.queue[index/2] < this.queue[index]) {
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
	private void maxHeapify(int index) {
		int left = 2 * index ;
		int right = 2 * index + 1;
		int largest = index;
		if(left <= this.lastIndex && this.queue[left] > this.queue[largest]) {
			largest = left;
		}
		if(right <= this.lastIndex && this.queue[right] > this.queue[largest]) {
			largest = right;
		}
		if(largest != index) {
			int temp = this.queue[index];
			this.queue[index] = this.queue[largest];
			this.queue[largest] = temp;
			this.maxHeapify(largest);
		}
	}
	
}
