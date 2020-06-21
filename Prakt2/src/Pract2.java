import java.util.regex.Pattern;

public class Pract2 {

	public static void main(String[] args) {
		System.out.println(boxSeq(6));
	}
	
	/**
	 * ����� ����������� ������ ������ � ������ n ���
	 * @param text ������������ ������
	 * @param n ���������� ���������� ������� �������
	 * @return ������ � ������� ������ �������� ������ ������������� n ���
	 */
	public static String repeat(String text, int n)
	{
		String ret = "";
		for(char chr : text.toCharArray())
		{
			for(int i = 0;i<n;i++)
			{
				ret+=chr;
			}
		}
		return ret;
	}

	/**
	 * ����� ������������ ������� ����� ����� ������� � ��������� ������
	 * � �������
	 * @param arr ������������ ������ �����
	 * @return ������� ����� �������
	 */
	public static int differenceMaxMin(int[] arr)
	{
		int max = arr[0];
		int min = arr[0];
		for(int val : arr)
		{
			if(val>max) max = val;
			if(val<min) min = val;
		}
		return max-min;
	}
	
	/**
	 * ����� �������� �������� �� ������� �������������� ������������
	 * ����� �����
	 * @param arr ������ ������������ �����
	 * @return true, ���� ������� �������������� �����. false �����.
	 */
	public static boolean isAvgWhole(int[] arr)
	{
		int sum = 0;
		for(int val : arr) sum+=val;
		return sum % arr.length == 0;
	}
	
	/**
	 * ����� ������������ ������, � ������� ������ �������
	 * �������� ������ ���� � ���������� ��������� ������������� �������
	 * @param arr ������������ ������
	 * @return ��������������� ������
	 */
	public static int[] cumulativeSum(int[] arr)
	{
		int sum = 0;
		int len = arr.length;
		int[] retArr = new int[len];
		for(int i = 0;i<len;i++)
		{
			sum+=arr[i];
			retArr[i] = sum;
		}
		return retArr;
	}
	
	/**
	 * ����� ������������ ����� ���������� ���� �� ������������� � ����
	 * ������ �����
	 * @param val ������, ���������� �����
	 * @return ����� ���������� ����
	 */
	public static int getDecimalPlaces(String val)
	{
		int ind = val.indexOf(".");
		if(ind==-1) return 0;
		else return val.length()-ind-1;
	}
	
	/**
	 * ����� ������� � ��� �������� ����� ���������� ���������������
	 * ����� ���������
	 * @param val ����� ����� ���������
	 * @return ����� ���������
	 */
	public static int Fibonacci(int val)
	{
		int ch1 = 1;
		int ch2 = 1;
		for(int i = 1;i<val;i++)
		{
			int temp = ch2;
			ch2 +=ch1;
			ch1 = temp;
		}
		return ch2;
	}
	
	/**
	 * ����� �������� �������� �� �������� ������ ��������������
	 * @param index ������ � ����������� ��������
	 * @return true, ���� ������ ��������������. ������ false.
	 */
	public static boolean isValid(String index)
	{
		String patt = "[0-9]{5}";
		return Pattern.matches(patt, index);
	}
	
	/**
	 * ����� �������� �������� �� ���������� ������ "�������� �����"
	 * "�������� ����" ������������� ��������� ��������:
	 * � ������ ����� 1-� ������ = ��������� ����� 2-� ������.
	 * � ��������� ����� 1-� ������ = ������ ����� 2-� ������
	 * @param val ������ ������
	 * @param val2 ������ ������
	 * @return true, ���� ���� ����� "��������". ����� false
	 */
	public static boolean isStrangePair(String val, String val2)
	{
		if (val.isEmpty()&&val2.isEmpty()) return true;
		if (val.isEmpty()||val2.isEmpty()) return false;
		int lastIndex1 = val.length()-1;
		int lastIndex2 = val2.length()-1;
		return ((val.charAt(0)==val2.charAt(lastIndex2))&&(val2.charAt(0)==val.charAt(lastIndex1)));
	}
	
	/**
	 * ����� ����������� ������� �� ������ �������� ��������� �������
	 * @param val ������ � ������� ����� ����������� �������
	 * @param val2 ������ �������� ��������������� �� "-"
	 * @return true, ���� val2 - ������� val. ����� false
	 */
	public static boolean isPrefix(String val, String val2)
	{
		val2 = val2.substring(0,val2.length()-1);
		return val.substring(0, val2.length()).equals(val2);
	}
	/**
	 * ����� ����������� ������� �� ������ �������� ��������� �������
	 * @param val ������ � ������� ����� ����������� �������
	 * @param val2 ������ �������� ������������� �� "-"
	 * @return true, ���� val2 - ������� val. ����� false
	 */
	public static boolean isSuffix(String val, String val2)
	{
		val2 = val2.substring(1);
		return val.substring(val.length()-val2.length()).equals(val2);
	}
	
	/**
	 * ����� ����������� �������� ��������� �� n ����, �������� ����� ���:
	 * ��� 0: ������� � 0
	 * ��� 1: �������� 3
	 * ��� 2: ������� 1
	 * ��������� ���� 1 � 2
	 */
	public static int boxSeq(int n)
	{
		if(n == 0) return 0;
		if(n%2 == 0) return n;
		else return n+2;
	}
}
