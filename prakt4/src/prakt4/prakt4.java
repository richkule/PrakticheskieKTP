package prakt4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prakt4 {

	public static void main(String[] args) {

		System.out.println(   countUniqueBooks("ZZABCDEF", 'Z')     );

	}
	/**
	 * Метод преобразовывающий исходную строку таким образом,
	 * чтобы в каждой строчке было не более k символов без пробелов
	 * если введенное слово больше k, то оно будет единственное на этой строчке
	 * @param n Количество слов разделенных пробелом
	 * @param k Колиечество символов без пробелов на каждой из строк
	 * @param text Исходная строка
	 * @return Отформатированная многострочный текст
	 */
	public static String Bessie(int n, int k, String text)
	{
		String[] arr = text.split(" ");
		String ret = "";
		String temp = "";
		int countSymbol = 0;
		for(String val : arr)
		{
			if(val.length()>k)
			{
				if(countSymbol==0)
				{
					ret += val+"\n";
				}
				else
				{
					ret+=temp+"\n";
					ret += val+"\n";
					temp = "";
					countSymbol = 0;
				}
			}
			int valLen = val.length();
			if (countSymbol + valLen > k)
			{
				ret+=temp+"\n";
				temp = val;
				countSymbol = valLen;
			}
			else
			{
				if(countSymbol == 0) temp = val;
				else temp += " " + val;
				countSymbol+=valLen;
			}
		}
		ret+=temp;
		return ret;
	}
	
	/**
	 * Метод который группирует строку вкластер скобок.
	 * @param text Исходная строкая
	 * @return Массив кластеров скобок
	 */
	public static ArrayList<String> split(String text)
	{
		String temp = "";
		int count = 0;
		ArrayList<String> arr = new ArrayList<String>();
		for(char ch : text.toCharArray())
		{
			if(ch == '(') count++;
			else count--;
			temp+=ch;
			if(count == 0)
			{
				arr.add(temp);
				temp = "";
			}
		}
		return arr;
	}
	/**
	 * Метод преобразующий строку вида ab_bc_cd в строку вида abBcCd
	 * @param text Исходная строка
	 * @return Преобразованная строка
	 */
	public static String toCamelCase(String text)
	{
		String ret = "";
		for(String val : text.split("_"))
		{
			if(ret.isEmpty()) ret+=val;
			else
			{
				ret+= Character.toUpperCase(val.charAt(0))+val.substring(1);
			}
		}
		return ret;
	}
	/**
	 * Метод преобразования строки вида abBcCd в строку вида ab_bc_cd
	 * @param text Исходная строка
	 * @return Преобразованная строка
	 */
	public static String toSnakeCase(String text)
	{
		String ret = "";
		for(char ch : text.toCharArray())
		{
			 if (Character.isUpperCase(ch)) ret+="_"+Character.toLowerCase(ch);
			 else ret+=ch;
		}
		return ret;
	}
	
	/**
	 * Метод вычисляющий оплату связанную с сверхурочной работы
	 * 
	 */
	
	/**
	 * Метод вычисляющий оплату связанную с сверхурочной работы
	 * при условии, что время с 9 до 5 не входит в сверхурочные часы
	 * @param arr массив чисел в который передаются слева на право
	 * Начало рабочего дня, в десятичном формате
	 * Конец рабочего дня
	 * Почасовая ставка
	 * Множитель сверхурочых работ
	 * @return Строку с 
	 */
	public static String overTime(double[] arr)
	{
		double svSum = 0;;
		double Sum;
		if(arr[0]<9)
		{
			svSum+=9-arr[0];
		}
		if(arr[1]>17)
		{
			svSum+=arr[1]-17;
		}
		Sum = arr[1]-arr[0]-svSum;
		return "$"+Double.toString(svSum*arr[2]*arr[3] + Sum*arr[2]);
	}
	/**
	 * Метод который принимает вес и рост (в килограммах, фунтах,
	 * метрах или дюймах) и возвращать ИМТ и связанную с ним категорию. 
	 * @param weight Вес
	 * @param height Рост
	 * @return ИМТ округленный до десятой и связанная с ним категория
	 */
	public static String BMI(String stWeight, String stHeight)
	{
		double weight,height;
		String[] arWeight = stWeight.split(" ");
		if (arWeight[1].equals("pounds")) weight = Double.parseDouble(arWeight[0]) *0.45359;
		else weight = Double.parseDouble(arWeight[0]);
		String[] arHeight = stHeight.split(" ");
		if (arHeight[1].equals("inches")) height = Double.parseDouble(arHeight[0]) *0.0254;
		else height = Double.parseDouble(arHeight[0]);
		double BMI = weight/(height*height);
		BMI = Math.round(BMI*10)/10.0;
		if (BMI<18.5) return Double.toString(BMI) + " Underweight";
		if (BMI<25) return Double.toString(BMI) + " Normal weight";
		return Double.toString(BMI) + " Underweight";
	}
	/**
	 * Метод возвращающий мультипликативное постоянство
	 * @param n Число для которого производятся вычисления
	 * @return мультипликативное постоянство
	 */
	public static int bugger(int n)
	{
		int i = 0;
		while (n>9)
		{
			int temp = n;
			int newN = 1;
			while(temp>0)
			{
				newN = temp%10*newN;
				temp = temp/10;
			}
			n = newN;
			i++;
		}
		return i;
	}
	/**
	 * Метд преобразующий строку в свездную стенографию
	 * @param text Преобразуемая строка
	 * @return Преобразовання строка
	 */
	public static  String toStarShorthand(String text)
	{
		String ret = "";
		char elem = 0;
		int i = -1;
		for(char var : text.toCharArray())
		{
			if (i==-1) 
			{
				elem = var;
				i = 1;
				continue;
			}
			if (elem == var) i++;
			else 
			{
				if(i==1) ret+=elem;
				else ret+= elem + "*"+Integer.toString(i);
				i = 1;
				elem = var;
			}
		}
		if(i!=-1) 
		{
			if(i==1) ret+=elem;
			else ret+= elem + "*"+Integer.toString(i);
		}
		return ret;
	}
	/**
	 *  Метод, который определяет рифмуются ли строки
	 * @param text Первая строка
	 * @param text2 Вторая строка
	 * @return true, если строки рифмуются, иначе false
	 */
	public static boolean doesRhyme(String text, String text2)
	{
		String glas = "aeiouy";
		String word1 = text.split(" ")[text.split(" ").length-1];
		String word2 = text2.split(" ")[text2.split(" ").length-1];
		String glasWord1 = "";
		String glasWord2 = "";
		for (char var : word1.toCharArray())
		{
			char temp = Character.toLowerCase(var);
			if (glas.indexOf(temp) == -1) continue;
			glasWord1+= temp;
		}
		for (char var : word2.toCharArray())
		{
			char temp = Character.toLowerCase(var);
			if (glas.indexOf(temp) == -1) continue;
			glasWord2+= temp;
		}
		return glasWord1.equals(glasWord2);
	}
	
	/**
	 * Метод вычисляющий, что существует цифра повторяющиеся 3 раза в числе
	 * num и 2 раза в числе num2 
	 * @param num Первое число
	 * @param num2 Второе число
	 * @return true, если существует такая цифра, иначе false;
	 */
	public static boolean trouble(long num, long num2)
	{
		HashSet<Character> checkedChar = new HashSet<Character>();
		String n1 = Long.toString(num);
		String n2 = Long.toString(num2);
		char[] arrN1 = n1.toCharArray();
		char[] arrN2 = n2.toCharArray();
		for(char val : arrN1)
		{
			if (checkedChar.contains(val)) continue;
			else 
			{
				int i1 = 0;
				int i2 = 0;
				for (char val2 :arrN1)
				{
					if (val2==val) i1++;
				}
				if (i1 == 3)
				{
					for (char val2 :arrN2)
					{
						if (val2==val) i2++;
					}
					if (i2 == 2) return true;
					else checkedChar.add(val);
				}
				else checkedChar.add(val);
			}
		}
		return false;
	}
	/**
	 * Метод возврашаюший количество уникальных символов в строке
	 * text, находящихся между символами ch
	 * @param text Проверяемая строка
	 * @param ch Граничные символы
	 * @return
	 */
	public static int countUniqueBooks(String text, char ch)
	{
		HashSet<Character> unicChar = new HashSet<Character>();
		String temp;
		if (ch == '$' || ch == '^'|| ch == '?'|| ch == '*'|| ch == '+'|| ch == '\\')
			temp = "\\"+ch + ".*?" +"\\"+ch;
		else
			temp = ch + ".*?" +ch;
		
		Pattern p = Pattern.compile(temp);
		Matcher m = p.matcher(text);
		while(m.find())
		{
			for(int i = m.start()+1;i<m.end()-1;i++)
			{
				unicChar.add(text.charAt(i));
			}
		}
		return unicChar.size();
	}
}
