
public class Prakt1 {

	public static void main(String[] args) {
		System.out.print(abcmath(42, 5, 10));
	}
	/**
	 * ����� ������� ���������� ������� �� �������
	 * @param val -�������
	 * @param val2  ��������
	 * @return  ������������� ������� �� �������
	 */
	public static int remainder(int val, int val2)
	{
		return val%val2;
	}
	
	/**
	 * �����, ������������� ������� ������������
	 * @param base  ����� ��������� ������������ 
	 * @param height  ����� ������ ������������
	 * @return ������� ������������
	 */
	public static double triArea(double base, double height)
	{
		return base*height/2;
	}
	
	/**
	 * ����� ��������� ����� ���������� ��� � ����������� ����������
	 * ������������ ��������
	 * @param chick  ���������� ���
	 * @param cows  ���������� �����
	 * @param pigs  ���������� ������
	 * @return ����� ���������� ���
	 */
	public static int animals(int chick, int cows, int pigs)
	{
		return 2*chick+4*cows+4*pigs;
	}
	
	/**
	 * ����� ������������� �������� �� ���� � �������������
	 * ��������� ����������
	 * @param prob  ����������� ������
	 * @param prize  ���������� ����
	 * @param pay  ��������� ����
	 * @return  true, ���� ���� ����������. ����� false
	 */
	public static boolean profitableGamble(double prob, double prize, double pay)
	{
		return prob*prize>pay;
	}
	
	/**
	 * ����� ����������� ����������� �������� ����� ����� �������,
	 * ����� �������� ������ �����
	 * @param n  ���������� �����
	 * @param a  ������ ����� � ������� ���������� �������������� ��������
	 * @param b  ������ ����� � ������� ���������� �������������� ��������
	 * @return ������ � ��������� ����������� ��������, ���� ����� �������� ���
	 * �� ����� "none"
	 */
	public static String operation(int n, int a, int b)
	{
		if (a+b==n) return "added";
		if (a*b == n) return "multiply";
		if (a-b==n) return "subtracted";
		if (a/b==n) return "devide";
		return "none";
	}
	
	/**
	 * ����� ���������� �������� ASCII ����������� �������. 
	 * @param chr ������������ ������ ASCII
	 * @return ����� ������� � ��������� ASCII
	 */
	public static int ctoa(char chr)
	{
		return (int) chr;
	}
	
	/**
	 * ����� ������������ �������������� ���������� �� ������, �� �����������
	 * ��������� � ����� 1
	 * @param val ��������� ���� �������������� �����
	 * @return �������������� �����
	 */
	public static int addUpTo(int val)
	{
		return (val + val*val)/2;
	}
	
	/**
	 * �����, ���������� ������������ ������ �������� �����
	 * @param val ����� ������� �����
	 * @param val2 ����� ������� �����
	 * @return ������������ ����� �������� �����
	 */
	public static int nextEdge(int val, int val2)
	{
		return val+val2-1;
	}
	
	/**
	 * ����� ������������ ����� ����� ������������ �����
	 * @param arr ������ �����
	 * @return ����� �����
	 */
	public static int sumOfCubes(int[] arr)
	{
		int sum = 0;
		for(int val : arr) sum+=val*val*val;
		return sum;
	}
	
	/**
	 * ����� ����������� �������� �� ����� ���������� �� ������� ������
	 * �� ������ �����
	 * @param a ���������� �����
	 * @param b ����������� ������� 2 ��� ���������
	 * @param c ��������
	 * @return true, ���� ��������. ����� false
	 */
	public static boolean abcmath(int a, int b, int c)
	{
		return a*Math.pow(2, b) % c == 0;
	}
	
	
	
	
	
	
	
	
	
	
	
}
