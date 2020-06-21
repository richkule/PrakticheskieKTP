package prakt6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prakt6 {

	public static void main(String[] args) {
		System.out.println(  palindromeDescendant(3456)      );
	}
	/**
	 * Вспомагательный метод, для метода белла.
	 * Число стирлинга возвращает количество неуполрядоченных
	 * разбиений н-элементарного множества на k непустых множест
	 * @param n Число элементов множества
	 * @param k Число разбиений
	 * @return
	 */
	public static int stir(int n, int k)
	{
		if(n==0&&k==0) return 1;
		if(k==0) return 0;
		if(k>n) return 0;
		return stir(n-1,k-1)+k*stir(n-1,k);
	}
	/**
	 * Метод возвращаются число белла из num элементов
	 * @param num Количество элементов массива
	 * @return Число белла
	 */
	public static int bell(int num)
	{
		int sum = 0;
		for(int i = 0;i<=num;i++)
		{
			sum+=stir(num,i);
		}
		return sum;
	
	}
	/**
	 * Метод преобразующий входной text в "свинский латинский"
	 * @param text Исходный текс
	 * @return Текст на "свинском латинском"
	 */
	public static String translateWord(String text)
	{
		String vowel = "aeouiy";
		if (text.isEmpty()) return "";
		if (vowel.indexOf(Character.toLowerCase(text.charAt(0)))!=-1) return text + "yay";
		int ind = 0;
		for (int i = 0;i<text.length();i++)
		{
			if (vowel.indexOf(Character.toLowerCase(text.charAt(i)))!=-1)
			{
				ind = i;
				break;
			}
		}
		String temp = text.substring(0,ind);
		text = text.substring(ind);
		text+=temp + "ay";
		return text;
	}
	/**
	 * Метод, возвращающий предложение преобразованное в "свинский латинский"
	 * @param text Исходное предложение
	 * @return Преобразованное предложение
	 */
	public static String translateSentence(String text)
	{
		String ret = "";
		String temp = "[a-zA-Z]+";
		Pattern p = Pattern.compile(temp);
		Matcher m = p.matcher(text);
		int ind = 0;
		while(m.find())
		{
			ret+= text.substring(ind,m.start());
			String svWord = translateWord(text.substring(m.start(),m.end()));
			if(ind == 0)
			{
				svWord = svWord.toLowerCase();
				svWord = Character.toUpperCase(svWord.charAt(0))+svWord.substring(1);
			}
			ret+=svWord;
			ind = m.end();
		}
		ret+= text.substring(ind);

		return ret;
	}
	/**
	 * Метод проеряющий, являются ли допустимыми
	 * принимаемые значения RGB и RGBA	 
	 * @param text Входная строка с параметрыми RGB или RGBA 
	 * @return true, если допустимые, иначе false
	 */
	public static boolean validColor(String text)
	{
		String tr = "^rgb\\(\\d+,\\d+,\\d+\\)$";
		String tra = "^rgba\\(\\d+,\\d+,\\d+,[.0-9]+\\)$";
		if(Pattern.matches(tra, text))
		{
			String temp = text.substring(5,text.length()-1);
			String[] arrTemp = temp.split(",");
			for(int i = 0;i<3;i++)
			{
				int num = Integer.parseInt(arrTemp[i]);
				if(num>255 || num<0) return false;
			}
			double dnum = Double.parseDouble(arrTemp[3]);
			if(dnum<0||dnum>1) return false;
			return true;
			
		}
		if(Pattern.matches(tr, text))
		{
			String temp = text.substring(4,text.length()-1);
			String[] arrTemp = temp.split(",");
			for(int i = 0;i<3;i++)
			{
				int num = Integer.parseInt(arrTemp[i]);
				if(num>255 || num<0) return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Метод удаляющий дублирующиеся параметры запроса
	 * @param text Передавая URL
	 * @return URL без дублирующихся запросов
	 */
	public static String stripUrlParams(String text)
	{
		String ret = "";
		String key = "";
		String value = "";
		HashMap<String,String> pMap = new HashMap<String,String>();
		int ind = text.indexOf('?');
		if(ind == -1) return text;
		ret+=text.substring(0,ind+1);
		ind++;
		for(int i = ind;i<text.length();i++)
		{
			char tempCh = text.charAt(i);
			if(tempCh == '=')
			{
				key = text.substring(ind,i);
				ind = i+1;
			}
			if(tempCh == '&')
			{
				value = text.substring(ind,i);
				ind = i+1;
				pMap.put(key, value);
			}
		}
		if(!key.isEmpty())
		{
			value = text.substring(ind);
			pMap.put(key, value);
		}
		for(Map.Entry<String, String> val : pMap.entrySet())
		{
			ret+= val.getKey() + "=" + val.getValue()+"&";
		}
		ret = ret.substring(0,ret.length()-1);
		return ret;
	}
	/**
	 * Метод удаляющий дублирующиеся и параметры перечисленные в массиве param
	 * @param text Передавая URL
	 * @param param Массив запрещенных параметров
	 * @return Обработанная URL
	 */
	public static String stripUrlParams(String text, String[] param)
	{
		String ret = "";
		String key = "";
		String value = "";
		HashMap<String,String> pMap = new HashMap<String,String>();
		int ind = text.indexOf('?');
		if(ind == -1) return text;
		ret+=text.substring(0,ind+1);
		ind++;
		for(int i = ind;i<text.length();i++)
		{
			char tempCh = text.charAt(i);
			if(tempCh == '=')
			{
				key = text.substring(ind,i);
				ind = i+1;
			}
			if(tempCh == '&')
			{
				value = text.substring(ind,i);
				ind = i+1;
				boolean flag = true;
				for(String val : param)
				{
					if (val.equals(key))
					{
						flag = false;
						break;
					}
				}
				if(flag) pMap.put(key, value);
			}
		}
		if(!key.isEmpty())
		{
			value = text.substring(ind);
			boolean flag = true;
			for(String val : param)
			{
				if (val.equals(key))
				{
					flag = false;
					break;
				}
			}
			if(flag) pMap.put(key, value);
		}
		for(Map.Entry<String, String> val : pMap.entrySet())
		{
			ret+= val.getKey() + "=" + val.getValue()+"&";
		}
		ret = ret.substring(0,ret.length()-1);
		return ret;
	}
	/**
	 * Метод извлекающий 3 хэштега
	 * @param text Исходный текст
	 * @return Массив хэштегов
	 */
	public static String[] getHashTags(String text)
	{
		int max1 = -1;
		int max2 = -1;
		int max3 = -1;
		String[] ret = new String[3];
		String[] temp = text.split(" ");
		if (temp.length<4)
		{
			String template = "[a-zA-Z]+";
			Pattern p = Pattern.compile(template);
			
			for(int i = 0;i<temp.length;i++)
			{
				Matcher m = p.matcher(temp[i]);
				m.find();
				temp[i] = temp[i].substring(m.start(),m.end());
				temp[i] = "#" + temp[i].toLowerCase();
			}
			
			
		}
		for(String val : temp)
		{
			String template = "[a-zA-Z]+";
			Pattern p = Pattern.compile(template);
			Matcher m = p.matcher(val);
			m.find();
			val = val.substring(m.start(),m.end());
			if(val.length()>max3)
			{
				max1 = max2;
				ret[0] = ret[1];
				max2 = max3;
				ret[1] = ret[2];
				max3 = val.length();
				ret[2] = val;
				continue;
			}
			if(val.length()>max2)
			{
				max1 = max2;
				ret[0] = ret[1];
				max2 = val.length();
				ret[1] = val;
				continue;
			}
			if(val.length()>max1)
			{
				max1 = val.length();
				ret[0] = val;
				continue;
			}
		}
		for(int i = 0;i<3;i++)
		{
			ret[i] = "#" +ret[i].toLowerCase();
		}
		return ret;
	}
	/**
	 * Метод возвращающий n член последовательности улана
	 * @param n Номер члена последовательности
	 * @return n член последовательности
	 */
	public static int ulam(int n)
	{
		if(n<3) return n;
		ArrayList<Integer> ul = new ArrayList<Integer>();
		ul.add(1);
		ul.add(2);
		int num = 3;
		while(true)
		{
			int l = 1;
			int r = num-1;
			boolean flag = false;
			while(l<r)
			{
				if(ul.indexOf(l)!=-1&&ul.indexOf(r)!=-1)
				{
					if (flag)
					{
						flag = false;
						break;
					}
					else flag = true;
				}
				l++;
				r--;
			}
			if (flag)
			{
				ul.add(num);
				if(ul.size() == n) return ul.get(ul.size()-1);
			}
			num++;
		}
	}
	/**
	 * Метод возвращающий самую длинную неповторяющуюся подстроку 
	 * @param text Исходная строка
	 * @return Самая длинна неповторяющаяся подстрока
	 */
	public static String longestNonrepeatingSubstring(String text)
	{
		String temp = "";
		String maxSt = "";
		for(char val : text.toCharArray())
		{
			if(temp.indexOf(val)==-1)
			{
				temp+=val;
				if (temp.length()>maxSt.length()) maxSt=temp;
			}
			else temp = "" + val;
		}
		return maxSt;
	}
	/**
	 * Метод преобразующий числа до 3999 в римское представление
	 * @param num Входное число
	 * @return Число в римском представлении 
	 */
	public static String convertToRoman(int num)
	{
		int[] ch = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] rCh = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		String ret = "";
		int i = 0;
		while(num>0)
		{
			if(num>=ch[i])
			{
				ret+=rCh[i];
				num-=ch[i];
			}
			else i++;
		}
		return ret;
	}
	/**
	 * Метод возвращающий является ли переданное уравнение верным
	 * @param text Уравнение
	 * @return true, если уравнение верное, иначе false
	 */
	public static boolean formula(String text)
	{
		String[] tempArr = text.split("=");
		int j = 0;
		for(String val : tempArr)
		{
			ArrayList<String> equ = new ArrayList<String>(Arrays.asList(val.split(" ")));
			if(equ.get(0).isEmpty()) equ.remove(0);
			int ind;
			while (true)
			{
				boolean flag = true;
				boolean isMul = false;
				for(ind = 0;ind<equ.size();ind++)
				{
					if(equ.get(ind).equals("*"))
					{
						isMul = true;
						flag = false;
						break;
					}
					if(equ.get(ind).equals("/"))
					{
						isMul = false;
						flag = false;
						break;
					}
				}
				if(flag) break;
				if (isMul)
				{
					double num1 = Double.parseDouble(equ.get(ind-1));
					double num2 = Double.parseDouble(equ.get(ind+1));
					equ.set(ind-1, Double.toString(num1*num2));
					equ.remove(ind);
					equ.remove(ind);	
				}
				else
				{
					double num1 = Double.parseDouble(equ.get(ind-1));
					double num2 = Double.parseDouble(equ.get(ind+1));
					equ.set(ind-1, Double.toString(num1/num2));
					equ.remove(ind);
					equ.remove(ind);	
					
				}
			}
			while (true)
			{
				boolean flag = true;
				boolean isPlus = false;
				for(ind = 0;ind<equ.size();ind++)
				{
					if(equ.get(ind).equals("+"))
					{
						isPlus = true;
						flag = false;
						break;
					}
					if(equ.get(ind).equals("-"))
					{
						isPlus = false;
						flag = false;
						break;
					}
				}
				if(flag) break;
				if (isPlus)
				{
					double num1 = Double.parseDouble(equ.get(ind-1));
					double num2 = Double.parseDouble(equ.get(ind+1));
					equ.set(ind-1, Double.toString(num1+num2));
					equ.remove(ind);
					equ.remove(ind);	
				}
				else
				{
					double num1 = Double.parseDouble(equ.get(ind-1));
					double num2 = Double.parseDouble(equ.get(ind+1));
					equ.set(ind-1, Double.toString(num1-num2));
					equ.remove(ind);
					equ.remove(ind);	
				}
			}
			tempArr[j] = equ.get(0);
			j++;
		}
		String temp = tempArr[0];
		for(int z = 0;z<tempArr.length;z++)
		{
			tempArr[z] = Double.toString(Double.parseDouble(tempArr[z]));
		}
		for(String val : tempArr)
		{
			if (!val.equals(temp)) return false;
		}
		return true;
	}
	/**
	 * Вспомогательный метод для palindromeDescendant
	 * Метод возвращающий перевернутую строку
	 * @param text Исходная строка
	 * @return Перевернутая строка
	 */
	 public static String reverseString(String text)
	 {
		 String reverse = "";
		 for(int i = text.length()-1;i>=0;i--)
		 {
			 reverse+=text.charAt(i);
		 }
		 return reverse;
	 }
	 /**
	  * Вспомогательный метод для palindromeDescendant
	  * Метод определяющий является ли строка палиндромом
	  * @param num Передаваемое число
	  * @return true, если число палиндром, иначе false
	  */
	 public static boolean isPalindrome(String s )
	 {
		 String rs = reverseString(s);
		 return s.equals(rs);
	 }
	 /**
	  * Метод проверяющий является ли число или один из его потомков вплоть до 2 цифр палиндромом
	  * @param num Входное число
	  * @return true, если является, иначе false
	  */
	 public static boolean palindromeDescendant(int num)
	 {
		 String sNum = Integer.toString(num);
		 while(sNum.length()>1)
		 {
			 if (isPalindrome(sNum)) return true;
			 if(sNum.length()%2 == 0)
			 {
				 String temp = "";
				 for(int i = 0;i<sNum.length();i = i+2)
				 {
					 int num1 = sNum.charAt(i) - '0';
					 int num2 = sNum.charAt(i+1) - '0';
					 temp+= Integer.toString(num1+num2);
				 }
				 sNum = temp;
			 }
			 else
			 {
				 String temp = "";
				 for(int i = 0;i<sNum.length()-1;i = i+2)
				 {
					 int num1 = sNum.charAt(i) - '0';
					 int num2 = sNum.charAt(i+1) - '0';
					 temp+= Integer.toString(num1+num2);
				 }
				 temp+=sNum.charAt(sNum.length()-1);
				 sNum = temp;
			 } 
		 }
		 return false;
	 }
		
}
