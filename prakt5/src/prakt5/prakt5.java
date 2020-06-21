package prakt5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;

public class prakt5 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println( hexLattice(37)     );
	}
	/**
	 * ����� ������������ �������������� ��������� �� ��������, ��� ������
	 * ������� ������� - �������� ������������� �������, ��������� ��������
	 * ������� ����� ���������
	 * @param text ���������� ������
	 * @return �������������� ������ � ���� ������� �����
	 */
	public static int[] encrypt(String text)
	{
		int[] ret = new int[text.length()];
		ret[0] = text.charAt(0);
		for(int i = 1;i<text.length();i++)
		{

			ret[i] = text.charAt(i)-text.charAt(i-1);
		}
		return ret;
	}
	/**
	 * ����� ������������ �������������� ���������, ������� ���� ������������
	 * �� ��������, ��� ������ ������� ������� - �������� ������������� �������,
	 * ��������� �������� ������� ����� ���������
	 * @param arr ������ �����, � ������ �������� �������������� ���������
	 * @return ��������������� ������
	 */
	public static String decrypt(int[] arr)
	{
		String ret = "";
		ret+= (char) arr[0];
		char temp = (char) arr[0];
		for(int i = 1;i<arr.length;i++)
		{
			temp = (char) (temp + arr[i]);
			ret+=temp;
		}
		return ret;
	}
	/**
	 * ����� ����������� ����� �� ������ � ��������� ���������� � fig
	 * ������������ � ���������� coor1 � ���������� coor2
	 * @param fig �������� ������  - "�����", "����", "����", "�����", "�����", " ������". 
	 * @param coor1 ���������� ����������
	 * @param coor2 ���������� �����������
	 * @return true, ���� ������ ����� ��� ���������, ����� false
	 */
	public static boolean canMove(String fig, String coor1, String coor2)
	{
		int x1 = coor1.charAt(0);
		int y1 = coor1.charAt(1);
		int x2 = coor2.charAt(0);
		int y2 = coor2.charAt(1);
		
		if(fig.equals("�����"))
		{
			if (x1==x2 && y2-y1 == 1) return true;
			else return false;
		}
		if(fig.equals("����"))
		{
			if ( (Math.abs(x2-x1) == 1 && Math.abs(y2-y1) == 2) ||(Math.abs(x2-x1) == 2 && Math.abs(y2-y1) == 1))
				return true;
			else return false;
		}
		if(fig.equals("����"))
		{
			if(Math.abs(x2-x1) == Math.abs(y2-y1)) return true;
			else return false;
		}
		if(fig.equals("�����"))
		{
			if(Math.abs(x2-x1) == Math.abs(y2-y1)) return true;
			if(x1==x2 || y1==y2) return true;
			return false;
		}
		if(fig.equals("�����"))
		{
			if(x1==x2 || y1==y2) return true;
			return false;
		}
		if(fig.equals("������"))
		{
			if(Math.abs(x2-x1)<2 && Math.abs(y2-y1)<2) return true;
			else return false;
		}
		return false;
	}
	/**
	 * ����� ����������� ����� �� ������ text ���� ��������� �� ������
	 * text2 ����������� ����
	 * @param text ����������� ������
	 * @param text2 ����������� ������
	 * @return true, ���� �����, ����� false
	 */
	public static boolean canComplete(String text, String text2)
	{
		int len = text2.length();
		int i2 = 0;
		for(int i = 0;i<text.length();i++)
		{
			char temp = text.charAt(i);
			boolean flag = true;
			for(;i2<len;i2++)
			{
				char test = text2.charAt(i2);
				if(temp == test)
				{
					flag = false;
					i2++;
					break;
				}
			}
			if(flag) return false;
		}
		return true;
	}
	/**
	 * �����, ������� 
	 * @param num
	 * @param num2
	 * @return
	 */
	public static int sumDigProd(int ... num)
	{
		int sum = 0;
		for(int val : num) sum+=val;
		while(sum>9)
		{
			int temp = 1;
			while(sum>0)
			{
				temp*=sum%10;
				sum = sum/10;
			}
			sum = temp;
		}
		return sum;
	}
	/**
	 * ����� ������������ ����� ������� �� �� ������� � ����� ������� �/��� ����������
	 * ��� � ������ �����, ������� ������ �����
	 * @param arrText ������� ������
	 * @return ������, ���������� �����, ��������������� �������
	 */
	public static ArrayList<String> sameVowelGroup(String[] arrText)
	{
		HashSet<Character> glasInWord = new HashSet<Character>();
		String glas = "aeiouy";
		ArrayList<String> ret = new ArrayList<String>();
		for(char val : arrText[0].toCharArray())
		{
			if(glas.indexOf(val)!= -1) glasInWord.add(val);
		}
		ret.add(arrText[0]);
		for(int i = 1;i<arrText.length;i++)
		{
			String str = arrText[i];
			boolean flag = true;
			for(char val : glasInWord)
			{
				if(str.indexOf(val)== -1)
				{
					flag = false;
					break;
				}
			}
			if (flag)
			{
				ret.add(str);
			}
		}
		return ret;
	}
	/**
	 * ����� �������� ���������������� ������ ��������� �����
	 * @param num ������� ����� ��������� �����
	 * @return true, ���� ����� ��������������, ����� false
	 */
	public static boolean validateCard(long num)
	{
		String stNum = Long.toString(num);
		char controlNum = stNum.charAt(stNum.length()-1);
		stNum = stNum.substring(0,stNum.length()-1);
		// ��������� ������
		stNum = new StringBuilder(stNum).reverse().toString();
		char[] arrNum = stNum.toCharArray();
		for(int i = 0;i<arrNum.length;i=i+2)
		{
			int temp = arrNum[i] - '0';
			temp = temp*2;
			if(temp>9)
			{
				temp = temp%10+((temp/10)%10);
			}
			arrNum[i] = (char) (temp + '0');
		}
		int sum = 0;
		for(char val : arrNum) sum+= (int) (val-'0');
		return 10 - sum%10 == (int)(controlNum-'0');
	}
	/**
	 * ����� ������������ �������� ������������� ����� �� 999 �� ����������
	 * @param val ������� �����
	 * @return ��� �������� �� ����������
	 */
	public static String numToEng(int val)
	{
		String[] st9 = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		String[] st19 = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String[] st99 = {"twenty","thirty","fourty","fivety","fifty","sixty","seventy","eighty","ninety"};
		
		if (val == 0) return "zero";
		String ret ="";
		int hun = val/100;
		int dec = (val-100*hun)/10;
		int fir = (val-100*hun-10*dec);
		if(hun >0) ret+= st9[hun] + " hundred ";
		if (dec>1) ret+= st99[dec-2] + " ";
		if (dec == 1)
		{
			ret+=st19[fir];
			return ret;
		}
		if(fir>0)
		{
			ret+= st9[fir];
			return ret;
		}
		else return ret.substring(0,ret.length()-1);
	}
	/**
	 * ����� ������������ ��� �� SHA-256 ������������ ������
	 * @param text ������������ ������
	 * @return ��� � ���� ����������������� �����
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getSha256Hash(String text) throws NoSuchAlgorithmException
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
	}
	/**
	 * ����� ������� ��������� ������ � ���������� ������ � ����������
	 * ��������� ��� ���������� �������� � ����� "���� ���������"
	 * @param text ��������� � ������������ ���������� ��������
	 * @return ������������ ���������
	 */
	public static String correctTitle(String text)
	{
		String ret = "";
		String[] arrText = text.split(" ");
		for(String val : arrText)
		{
			for (String val2 : val.split("-"))
			{
				String temp = val2.toLowerCase();
				if (temp.equals("and")||temp.equals("the")||temp.equals("of")||temp.equals("in"))
					ret+= temp + " ";
				else ret+= Character.toUpperCase(temp.charAt(0)) + temp.substring(1) + " ";
			}
		}
		return ret.substring(0,ret.length()-1);
	}
	/**
	 * ����� ��������� ����� ����� n � ���������� "������������", ����
	 *n �� �������� �������������� ������������� ������ ��� ��� ������������ � ����
	 *������������� ������������� ������ � ��������� ������.
	 * @param num ������������ �����
	 * @return Invalid ���� ����� �����������, ����� ������������� �����������
	 */
	public static String hexLattice(int num)
	{
		// ����� �����, ���� ��������� 3a^2-3a+1=num ����� ������������� �������
		if (num == 1) return " o ";
		double disc = Math.sqrt(9 + 12*(num-1));
		// ���������� ����� � ������� �������
		double st = (3+disc)/6;
		if (st%1 != 0) return "Invalid";
		int ist = (int) st;
		String ret = "";
		int lesCol = ist-1;
		for(int i = 0;i<lesCol+1;i++)
		{
			ret+= " ";
			for(int i2 = 0;i2<lesCol-i;i2++) ret+= " ";
			for(int i2 = 0;i2<ist+i;i2++) ret+= "o ";
			ret+= "\n";
		}
		for(int i = 0;i<lesCol;i++)
		{
			ret+= " ";
			for(int i2 = 0;i2<i+1;i2++) ret+= " ";
			for(int i2 = 0;i2<ist*2-2-i;i2++) ret+= "o ";
			ret+= "\n";
		}
		return ret;
	}
}
