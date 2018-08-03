package Assignment2;

import java.io.*;
import java.util.Scanner;

class CircularQueue {
	int Queue[] = new int[100];
	int number, front, rear;
	static Scanner br = new Scanner(System.in);

	public CircularQueue(int size) {
		number = size;
		front = rear = 0;
	}

	public void add(int item) {
		if ((rear + 1) % number != front) {
			rear = (rear + 1) % number;
			Queue[rear] = item;
		} else
			System.out.println("Queue is full !");
	}

	public int del() {
		int item;
		if (front != rear) {
			front = (front + 1) % number;
			item = Queue[front];
			return item;
		} else
			return -1;
	}

	

	public static void main(String args[]) throws IOException {
		System.out.print("Enter the size of the queue : ");
		int size = br.nextInt();
		CircularQueue call = new CircularQueue(size);
		int choice;
		boolean exit = false;
		while (!exit) {
			System.out.print("\n1 : Add\n2 : Delete\n3 : Display\n4 : Exit\n\nYour Choice : ");
			choice = br.nextInt();
			switch (choice) {
			case 1:
				System.out.print("\nEnter number to be added : ");
				int num = br.nextInt();
				call.add(num);
				break;
			case 2:
				int popped = call.del();
				if (popped != -1)
					System.out.println("\nDeleted : " + popped);
				else
					System.out.println("\nQueue is empty !");
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("\nWrong Choice !");
				break;
			}
		}
	}
}
