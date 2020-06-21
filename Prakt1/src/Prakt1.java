
public class Prakt1 {

	public static void main(String[] args) {
		System.out.print(abcmath(42, 5, 10));
	}
	/**
	 * Метод который возвращает остаток от деления
	 * @param val -Делимое
	 * @param val2  Делитель
	 * @return  Целочисленный остаток от деления
	 */
	public static int remainder(int val, int val2)
	{
		return val%val2;
	}
	
	/**
	 * Метод, высчитывающий площадь треугольница
	 * @param base  Длина основания треугольница 
	 * @param height  Длина высоты треугольника
	 * @return Площадь треугольника
	 */
	public static double triArea(double base, double height)
	{
		return base*height/2;
	}
	
	/**
	 * Метод считающий общее количество ног у переданного количества
	 * определенных животных
	 * @param chick  Количетсво кур
	 * @param cows  Количество коров
	 * @param pigs  Количество свиней
	 * @return Общее количество ног
	 */
	public static int animals(int chick, int cows, int pigs)
	{
		return 2*chick+4*cows+4*pigs;
	}
	
	/**
	 * Метод высчитывающий является ли игра с вероятностным
	 * выйгрышем прибыльной
	 * @param prob  Вероятность победы
	 * @param prize  Получаемый приз
	 * @param pay  Стоимость игры
	 * @return  true, если игра прибыльная. Иначе false
	 */
	public static boolean profitableGamble(double prob, double prize, double pay)
	{
		return prob*prize>pay;
	}
	
	/**
	 * Метод вычисляющий необходимую операцию между двумя числами,
	 * Чтобы получить третье число
	 * @param n  Получаемое число
	 * @param a  Первое число с которым проводится математическая операция
	 * @param b  Второе число с которым проводится математическая операция
	 * @return Строка с названием необходимой операции, если такой операции нет
	 * то вывод "none"
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
	 * Метод возвращает значение ASCII переданного символа. 
	 * @param chr Передаваемый символ ASCII
	 * @return Номер символа в кодировке ASCII
	 */
	public static int ctoa(char chr)
	{
		return (int) chr;
	}
	
	/**
	 * Метод возвращающий арифмитической прогрессии от одного, до переданного
	 * параметра с шагом 1
	 * @param val Последний член алгебраической суммы
	 * @return Алгебраическая сумма
	 */
	public static int addUpTo(int val)
	{
		return (val + val*val)/2;
	}
	
	/**
	 * Метод, находяющий максимальную длинну третьего ребра
	 * @param val Длина первого ребра
	 * @param val2 Длина второго ребра
	 * @return Максимальная длина третьего ребра
	 */
	public static int nextEdge(int val, int val2)
	{
		return val+val2-1;
	}
	
	/**
	 * Метод возвращающий сумму кубов передаваемых чисел
	 * @param arr Массив чисев
	 * @return Сумма кубов
	 */
	public static int sumOfCubes(int[] arr)
	{
		int sum = 0;
		for(int val : arr) sum+=val*val*val;
		return sum;
	}
	
	/**
	 * Метод проверяющий делиться ли число умноженное на степень двойки
	 * На другое число
	 * @param a Умножаемое число
	 * @param b Необходимая степень 2 для умножения
	 * @param c Делитель
	 * @return true, если делиться. Иначе false
	 */
	public static boolean abcmath(int a, int b, int c)
	{
		return a*Math.pow(2, b) % c == 0;
	}
	
	
	
	
	
	
	
	
	
	
	
}
