import java.util.ArrayList;

//Name: Sorawit Ongsiriporn
//ID: 6288030
//Section: 3


public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	private ArrayList<Double> num=new ArrayList<Double>(); // collect data to 'num' array
	private ArrayList<Double> sort=new ArrayList<Double>();
	private double sum,avg,sD,min,max; // sD=standard deviation
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********

		//**************************************
	}

	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		num.add(number);
		//**************************************
	}

	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(num.size()>0) {
			num.remove(0);
		}
		//**************************************
	}

	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(num.size()>0) {
			num.remove(num.size()-1);
		}
		//**************************************
	}

	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		sum=0;
		if(num.size()>0) {
			for(int i=0;i<num.size();i++) {
				sum+=num.get(i);
			}
		}
		return sum;
		//**************************************
	}

	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		if(num.size()>0) {
			avg=sum/num.size();
			return avg;
		}
		return 0;
		//**************************************
	}

	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		sD=0;
		if(num.size()>1) {
			for(double a: num) {
				sD += Math.pow(a - avg, 2);
			}
			sD = Math.sqrt(sD/(num.size()-1));
		}
		return sD;
		//**************************************
	}

	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		if(num.size()>0) {
			max=num.get(0);
			for(int i=1;i<num.size();i++) {
				if(max<num.get(i)) {
					max=num.get(i);
				}
			}
			return max;
		}
		return 0;
		//**************************************
	}

	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		if(num.size()>0) {
			min=num.get(0);
			for(int i=1;i<num.size();i++) {
				if(min>num.get(i)) {
					min=num.get(i);
				}
			}
			return min;
		}
		return 0;
		//**************************************
	}

	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		if(num.size()>=k) {
			sorter();
			double[] maxk=new double[k];
			for(int i=0;i<k;i++) {
				maxk[i]=sort.get(sort.size()-1-i);
			}
			return maxk;
		}
		return null;
		//**************************************
	}

	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		if(num.size()>=k) {
			sorter();
			double[] mink=new double[k];
			for(int i=0;i<k;i++) {
				mink[i]=sort.get(i);
			}
			return mink;
		}
		return null;
		//**************************************
	}

	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		System.out.println("DATA["+num.size()+"]:"+num.toString());

		//**************************************
	}

	
	// new method(my own), use to sort array
	public void sorter() {
		Double temp;
		sort = (ArrayList)num.clone(); // copy elements to another array
		for(int i=0;i<sort.size()-1;i++) { // bubble sort
			for(int j=0;j<sort.size()-i-1;j++) {
				if(sort.get(j)>sort.get(j+1)) {
					temp=sort.get(j);
					sort.set(j, sort.get(j+1));
					sort.set(j+1, temp);
				}
			}
		}
	}

}