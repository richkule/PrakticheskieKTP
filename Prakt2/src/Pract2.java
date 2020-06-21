import java.util.regex.Pattern;

public class Pract2 {

	public static void main(String[] args) {
		System.out.println(boxSeq(6));
	}
	
	/**
	 * Метод повторяющий каждый символ в строке n раз
	 * @param text Передаваемая строка
	 * @param n Количество повторения каждого символа
	 * @return Строка в которой каждый исходный символ продублирован n раз
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
	 * Метод возвращающий разницу между самым большим и маленьким числом
	 * в массиве
	 * @param arr Передаваемый массив чисел
	 * @return Разница между числами
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
	 * Метод проверки является ли среднее арифмитическое передаваемых
	 * чисел целым
	 * @param arr Массив передаваемых чисел
	 * @return true, если среднее арифмитическое целое. false иначе.
	 */
	public static boolean isAvgWhole(int[] arr)
	{
		int sum = 0;
		for(int val : arr) sum+=val;
		return sum % arr.length == 0;
	}
	
	/**
	 * Метод возвращающий массив, в котором каждый элемент
	 * является суммой себя и предыдущих элементов передаваемого массива
	 * @param arr Передаваемый массив
	 * @return Преобразованный массив
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
	 * Метод возвращающий число десятичных цифр из передаваемого в виде
	 * строки числа
	 * @param val Строка, содержащая число
	 * @return Число десятичных цифр
	 */
	public static int getDecimalPlaces(String val)
	{
		int ind = val.indexOf(".");
		if(ind==-1) return 0;
		else return val.length()-ind-1;
	}
	
	/**
	 * Метод который я при заданном числе возвращает соответствующее
	 * число Фибоначчи
	 * @param val Номер числа Фибоначчи
	 * @return Число Фибоначчи
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
	 * Метод проверки является ли почтовый индекс действительным
	 * @param index Строка с проверяемым индексом
	 * @return true, если индекс действительный. Иначае false.
	 */
	public static boolean isValid(String index)
	{
		String patt = "[0-9]{5}";
		return Pattern.matches(patt, index);
	}
	
	/**
	 * Метод проверки являются ли переданные строки "странной парой"
	 * "странная пара" соответствует следующим условиям:
	 * – Первая буква 1-й строки = последняя буква 2-й строки.
	 * – Последняя буква 1-й строки = первая буква 2-й строки
	 * @param val Первая строка
	 * @param val2 Вторая строка
	 * @return true, если пара строк "странная". Иначе false
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
	 * Метод проверяющий явлется ли второй аргумент префиксом первого
	 * @param val Строка в которой может содержаться префикс
	 * @param val2 Строка префикса заканчивающаяся на "-"
	 * @return true, если val2 - префикс val. Иначе false
	 */
	public static boolean isPrefix(String val, String val2)
	{
		val2 = val2.substring(0,val2.length()-1);
		return val.substring(0, val2.length()).equals(val2);
	}
	/**
	 * Метод проверяющий явлется ли второй аргумент суффиксом первого
	 * @param val Строка в которой может содержаться суффикс
	 * @param val2 Строка суффикса начинающегося на "-"
	 * @return true, если val2 - суффикс val. Иначе false
	 */
	public static boolean isSuffix(String val, String val2)
	{
		val2 = val2.substring(1);
		return val.substring(val.length()-val2.length()).equals(val2);
	}
	
	/**
	 * Метод вычисляющий значения алгоритма на n шаге, алгоритм имеет вид:
	 * Шаг 0: начните с 0
	 * Шаг 1: Добавьте 3
	 * Шаг 2: Вычтите 1
	 * Повторите Шаги 1 И 2
	 */
	public static int boxSeq(int n)
	{
		if(n == 0) return 0;
		if(n%2 == 0) return n;
		else return n+2;
	}
}
