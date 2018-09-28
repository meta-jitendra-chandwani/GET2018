package com.metacube.training.SpringEx.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Triangle {
	private List<Points> pointsList;
	private Map<Integer, Points> map;
	private Set<Points> pointsSet;

	/**
	 * 
	 * @return the pointsList
	 */
	public List<Points> getPointsList() {
		return pointsList;
	}

	public void setPointsList(List<Points> pointsList) {
		this.pointsList = pointsList;
	}

	/**
	 * @return the pointsMap
	 */
	public Map<Integer, Points> getPointsMap() {
		return map;
	}

	/**
	 * @param pointsMap
	 *            the pointsMap to set
	 */
	public void setPointsMap(Map<Integer, Points> map) {
		this.map = map;
	}

	/**
	 * @return the pointsSet
	 */
	public Set<Points> getPointsSet() {
		return pointsSet;
	}

	/**
	 * @param pointsSet
	 *            the pointsSet to set
	 */
	public void setPointsSet(Set<Points> pointsSet) {
		this.pointsSet = pointsSet;
	}

	/**
	 * draw the point of functions
	 */
	public void draw() {
		System.out.println("List Item");
		for (Points point : pointsList) {
			System.out.println("Point = (" + point.getX() + "," + point.getY()
					+ ")");
		}

		System.out.println("Map Item");
		for (int key : map.keySet()) {
			System.out.println("Point = (" + map.get(key).getX() + ","
					+ map.get(key).getY() + ")");
		}

		System.out.println("Set Item");
		for (Points point : pointsSet) {
			System.out.println("Point = (" + point.getX() + "," + point.getY()
					+ ")");
		}
	}

}
