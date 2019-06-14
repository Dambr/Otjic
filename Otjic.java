
/*
	* Вынес в отдельный файл чисто методы
	* Да да, класс с громким названием метода,
	* которым тебе надо делать задание, внутри содержит
	* только статические методы,
	* чтобы не создавать объект этого класса
*/

public class Otjic{

	// Простая функция рандомизатор.
	// Получает на вход два числа, возвращает случайное число в диапазоне введенных чисел
	public static int random(int min, int max){
		max -= min;
		return (int) (Math.random() * ++max) + min;
	}

	// Функция подсчитывает, на сколько судачно уложены вещи в рюкзак, можно сказать, какой стоимостью обладает рюкзак, который укомплектован текущим образом
	public static int getValue(int [] vector, int [][] data){
		int s = 0;
		for (int i = 0; i < vector.length; i ++){
			s += data[vector[i]][i];
		}
		return s;
	}

	// Функция возвращает два неодинаковых числа. Используется для определения индексов элементов, которые будем менять местами в сформированном векторе.
	public static int [] getTwoRandomNumbers(int [] vector){
		int number1 = random(0, vector.length - 1);
		int number2 = random(0, vector.length - 1);
		while (number1 == number2)
			number2 = random(0, vector.length - 1);
		return new int [] {number1, number2};
	}

	// Функция по исходной матрице строит вектор первоначального распределения элементов в рюкзаке
	public static int [] getVector(int [][] data){
		int [] vector = new int [data[0].length];
		int    count  = data.length - 1;
		for (int i = 0; i < vector.length; i ++){
			vector[i] = random(0, count);
			count    -= vector[i];
		}
		return vector;
	}
}