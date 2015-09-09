/*
 * Name: Joseph Godfrey
 * Date: 24/March/2015
 * Course: CSC 212
 * Program: Program Ch7B
 * 
 * Description:
 * This program takes the array of an image and manipulates
 * it in several ways, like translating it, mirroring it,
 * flipping it, making it negative etc. and prints these 
 *changes side by side next to the original.
 * 
 */

import java.awt.*;
import java.util.Arrays;

import javax.imageio.*;
import javax.swing.*;

public class ImageManipulation {
	public static final int OFF_SET = 25;
	public static final int MAX_COLOR_NUM = 255;

	public static void main(String args[]) throws Exception {

		// Read the image from the file.
		Image img = new Image("seesaw.jpg");

		// Create a frame to display the image.
		JFrame frame = new JFrame("My Image Manipulations");
		int imageWidth = img.getWidth();
		int imageHeight = img.getHeight();
		frame.setSize(3 * imageWidth, 2 * imageHeight + OFF_SET);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Store the 2D array from the picture to manipulate
		int[][] imageArray = img.get2DArray();

		// Set up for displaying the image
		Graphics g = frame.getGraphics();
		Thread.sleep(250);

		// Display the original image.
		img.draw(g, 0, OFF_SET);

		int[][] mirrorArray = rightMirror(imageArray);
		img.set2DArray(mirrorArray);
		img.draw(g, imageWidth, OFF_SET);

		int[][] flipArray = horizFlip(imageArray);
		img.set2DArray(flipArray);
		img.draw(g, 2 * imageWidth, OFF_SET);

		int[][] sobelArray = edgesArray(imageArray);
		img.set2DArray(sobelArray);
		img.draw(g, 0, imageHeight + OFF_SET);

		int[][] movedArray = translateArray(imageArray, 100);
		img.set2DArray(movedArray);
		img.draw(g, imageWidth, imageHeight + OFF_SET);

		int[][] negArray = negativeArray(imageArray);
		img.set2DArray(negArray);
		img.draw(g, 2 * imageWidth, imageHeight + OFF_SET);

	}

	// mirrors the right side of the pic onto the left
	public static int[][] rightMirror(int[][] array) {
		int[][] mirrorArray = new int[array.length][array[0].length];
		for (int col = 0; col < mirrorArray.length; col++) {
			for (int row = 0; row < mirrorArray[0].length; row++) {
				if (row < mirrorArray[0].length / 2) {
					mirrorArray[col][row] = array[col][array[0].length - row
							- 1];
				} else {
					mirrorArray[col][row] = array[col][row];
				}
			}
		}
		return mirrorArray;
	}

	// flips the picture across a vertical axis (not mirrors)
	public static int[][] horizFlip(int[][] array) {
		int[][] flipArray = new int[array.length][array[0].length];
		for (int col = 0; col < flipArray.length; col++) {
			for (int row = 0; row < flipArray[0].length; row++) {
				flipArray[col][row] = array[array.length - 1 - col][row];
			}
		}
		return flipArray;
	}

	// translates the pic an int left and tacks what it pushed off onto the
	// right
	public static int[][] translateArray(int[][] array, int pixels) {
		int[][] transArray = new int[array.length][array[0].length];
		for (int col = 0; col < transArray.length; col++) {
			for (int row = 0; row < transArray[0].length; row++) {
				if (row - pixels > 0) {
					transArray[col][row - pixels - 1] = array[col][row];
				} else {
					transArray[col][(row - pixels) + array[0].length - 1] = array[col][row];
				}

			}
		}
		return transArray;
	}

	// makes a negative image of the pic (black>white)
	public static int[][] negativeArray(int[][] array) {
		int[][] negateArray = new int[array.length][array[0].length];
		for (int col = 0; col < negateArray.length; col++) {
			for (int row = 0; row < negateArray[0].length; row++) {
				negateArray[col][row] = 255 - array[col][row];

			}
		}
		return negateArray;

	}

	// clearly defines the edges of the image, where the greatest contrast is
	public static int[][] edgesArray(int[][] array) {
		int[][] edgeArray = new int[array.length][array[0].length];
		int maxLength = (int) (Math
				.sqrt(((4 * MAX_COLOR_NUM) * (4 * MAX_COLOR_NUM))
						+ ((4 * MAX_COLOR_NUM) * (4 * MAX_COLOR_NUM))));
		for (int col = 0; col < edgeArray.length; col++) {
			for (int row = 0; row < edgeArray[0].length; row++) {
				if (col < 1 || col > array.length - 2 || row < 1
						|| row > array[0].length - 2) {
					edgeArray[col][row] = array[col][row];
				} else {

					int xGradient = (-1 * array[col - 1][row - 1])
							+ (-2 * array[col][row - 1])
							+ (-1 * array[col + 1][row - 1])
							+ (1 * array[col + 1][row + 1])
							+ (2 * array[col][row + 1])
							+ (1 * array[col - 1][row + 1]);
					int yGradient = (1 * array[col - 1][row - 1])
							+ (2 * array[col + 1][row])
							+ (-1 * array[col + 1][row - 1])
							+ (1 * array[col + 1][row + 1])
							+ (-2 * array[col - 1][row])
							+ (-1 * array[col - 1][row + 1]);
					double gradientMag = Math.sqrt((xGradient * xGradient)
							+ (yGradient * yGradient));
					int newColor = (int) ((gradientMag / maxLength) * 255);

					edgeArray[col][row] = newColor;
				}

			}
		}
		return edgeArray;
	}

}
