import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prakt3 {

	public static void main(String[] args) {

		System.out.print(  rightTriangle(70, 130, 110)    );

	}
	
	/**
	 * ����� ������������ ���������� ������� ����������� ���������
	 * ���� ax^2 + bx + c = 0
	 * @param a ����� ��������������� ��������� � � ���������� ���������
	 * @param b ����� ��������������� ��������� b � ���������� ���������
	 * @param c ����� ��������������� ��������� � � ���������� ���������
	 * @return ���������� �������
	 */
	public static int solutions(int a, int b, int c)
	{
		int disc = b*b - 4*a*c;
		if (disc>0) return 2;
		else if(disc == 0) return 1;
		else return 0;
	}
	
	/**
	 * ����� ������������ ������ ������� ��������� ��������� "zip"
	 * @param text ������� ������
	 * @return ������ ������� ���������, ���� ��� ���������� ��� -1
	 * � �������� ������
	 */
	public static int findZip(String text)
	{
		String pat = "(zip)";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(text);
		m.find();
		if(m.find()) return m.start();
		else return -1;
	}
	
	/**
	 * ����� �������� �������� �� ����� "�����������"
	 * @param val ����������� �����
	 * @return true, ���� ����� "����������". ����� false
	 */
	public static boolean checkPerfect(int val)
	{
		int sum = 1;
		for(int i = 2;i<=Math.sqrt(val);i++)
		{
			if (val % i == 0) 
			{
				sum+= i;
				sum+= val/i;
			}
		}
		return val==sum;
	}
	
	/**
	 * ����� ������������ ����� ����� � ������� �� ������� � ����������
	 * @param text ������������ ������
	 * @return ������ � ����������� ������� ������� ����� ���������
	 * "Incompatible" - ���� ������ ������� ����� ��� �� 2 ��������
	 * "Two's a pair." - ���� ������ � ��������� ������ ������ ����������
	 */
	public static String flipEndChars(String text)
	{
		int len = text.length();
		if(len<2) return "Incompatible";
		char begin = text.charAt(0);
		char end = text.charAt(len-1);
		if(begin==end) return "Two's a pair.";
		return end+text.substring(1,len-1)+begin;
	}
	
	/**
	 * ����� �������� �������� �� ������ ���������� ����������������� �����
	 * @param code ����������������� ��� ������������ � "#"
	 * @return true, ���� ��� ��������. ����� false
	 */
	public static boolean isValidHexCode(String code)
	{
		String pat = "#([a-fA-F0-9]){6}";
		return Pattern.matches(pat, code);
	}
	
	/**
	 * ����� �������� ���������� �� ���������� ���������� ���������
	 * � ��������
	 * @param arr ������ ������
	 * @param arr2 ������ ������
	 * @return true, ���� ���������� ���������� ��������� ���������. false �����.
	 */
	public static boolean same(int[]arr,int[]arr2)
	{
		Set<Integer> mySet = new HashSet<Integer>();
		Set<Integer> mySet2 = new HashSet<Integer>();
		for(int var : arr) mySet.add(var);
		for(int var : arr2) mySet2.add(var);
		return mySet.size()==mySet2.size();
	}
	
	/**
	 * ����� ����������� �������� �� ���������� ����� - ������ ���������
	 * @param val ����������� ����� 
	 * @return true, ���� ����� �������� ������ ���������. ����� false
	 */
	public static boolean isKaprekar(int val)
	{
		int squadVal = val*val;
		if (squadVal<10) return val==squadVal;
		String textSquadVal = Integer.toString(squadVal);
		int medium = textSquadVal.length()/2;
		String left = textSquadVal.substring(0,medium);
		String right = textSquadVal.substring(medium);
		return Integer.parseInt(left) + Integer.parseInt(right) == val;
	}
	
	/**
	 * ����� ������������ ����� ������� ��������� ���������� �� �����
	 * @param text �������� ���������
	 * @return ���������� ��������� ��������� �� 0
	 */
	public static String longestZero(String text)
	{
		int max = 0;
		int count = 0;
		for(char ch : text.toCharArray())
		{
			if(ch == '0')
			{
				count++;
				if(count>max) max = count;
			}
			else
			{
				count = 0;
			}
		}
		String ret = "";
		for(int i = 0;i<max;i++)
		{
			ret+="0";
		}
		return ret;
	}
	
	/**
	 * ����� ���������� ���������� ������� ����� ������� ������ ��� �����
	 * ����������� ���������
	 * @param n 
	 * @return ������� �����
	 */
	public static int nextPrime(int n)
	{
		while (true)
		{
			boolean flag = true;
			for (int i = 2;i<=Math.sqrt(n);i++)
			{
				if(n%i==0)
				{
					n++;
					flag = false;
					break;
				}
			}
			if (flag) break;
		}
		return n;
	}
	
	/**
	 * ����� ����������� ����� �� ���������� ������� ������������ �������� ���������
	 * �������������� ������������
	 * @param a ������ ������� ������������
	 * @param b ������ ������� ������������
	 * @param c ������ ������� ������������
	 * @return true, ���� ������� �������� ��������� ������������� ������������. ����� false
	 */
	public static boolean rightTriangle(int a, int b, int c)
	{
		if (a>b)
		{
			if(a>c)
			{
				return a*a==b*b+c*c;
			}
			else
			{
				return c*c==b*b+a*a;
			}
		}
		else
		{
			if(b>c)
			{
				return b*b==c*c+a*a;
			}
			else
			{
				return c*c==b*b+a*a;
			}
		}
	}
}
