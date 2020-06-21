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
	 * Метод возвращающий количетсво решений квадратного уравнения
	 * вида ax^2 + bx + c = 0
	 * @param a Число соответствующие параметру а в квадратном уравнении
	 * @param b Число соответствующие параметру b в квадратном уравнении
	 * @param c Число соответствующие параметру с в квадратном уравнении
	 * @return количество решений
	 */
	public static int solutions(int a, int b, int c)
	{
		int disc = b*b - 4*a*c;
		if (disc>0) return 2;
		else if(disc == 0) return 1;
		else return 0;
	}
	
	/**
	 * Метод возвращающий индекс второго вхождения подстроки "zip"
	 * @param text Входная строка
	 * @return Индекс второго вхождения, если оно существует или -1
	 * в обратном случае
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
	 * Метод проверки является ли число "совершенным"
	 * @param val Проверяемое число
	 * @return true, если число "совершенно". Иначе false
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
	 * Метод возвращающий новую строк с заменой ее первого и последнего
	 * @param text Передаваемая строка
	 * @return Строку с измененными местами первыми двумя символами
	 * "Incompatible" - если строка состоит менее чем из 2 символов
	 * "Two's a pair." - если первый и последний символ строки одинаковые
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
	 * Метод проверки является ли строка допустимым шестнадцатеричным кодом
	 * @param code Шестнадцатеричным код начинающийся с "#"
	 * @return true, если код допустим. Иначе false
	 */
	public static boolean isValidHexCode(String code)
	{
		String pat = "#([a-fA-F0-9]){6}";
		return Pattern.matches(pat, code);
	}
	
	/**
	 * Метод проверки одинаковое ли количество уникальных элементов
	 * в массивах
	 * @param arr Первый массив
	 * @param arr2 Второй массив
	 * @return true, если количество уникальных элементов совпадает. false иначе.
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
	 * Метод проверяющий является ли переданное число - числом Капрекара
	 * @param val Проверяемое число 
	 * @return true, если число является числом Капрекара. Иначе false
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
	 * Метод возвращающий самую длинную подстроку состояющую из нулей
	 * @param text Исходная подстрока
	 * @return Длиннейшая подстрока состоящая из 0
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
	 * Метод возвращает близжайшее простое число которое больше или равно
	 * переданному аргументу
	 * @param n 
	 * @return Простое число
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
	 * Метод проверяющий могут ли переданные стороны треугольника являться сторонами
	 * прямоугольного треугольника
	 * @param a Первая сторона треугольника
	 * @param b Вторая сторона треугольника
	 * @param c Третья сторона треугольника
	 * @return true, если стороны являются сторонами прямоугльного треугольника. Иначе false
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
