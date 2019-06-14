
/*
	* У меня код с коментами на русском не запускается.
	* Кидаю такую версию, чтобы ты прочитала, что тут вообще происходит.
*/

public class Main{
	public static void main(String[] args){

		// Дано
		final int [][] data = {
			{0, 0, 0, 0, 0},
			{1, 2, 1, 2, 1},
			{2, 3, 2, 3, 2},
			{3, 4, 3, 4, 3},
			{4, 5, 4, 5, 4}
		};
		double T = 100;
		double alpha = 0.95;

		// Вывод исходной матрицы
		for (int i = 0; i < data.length; i ++){
			System.out.println();
			for (int j = 0; j < data[i].length; j ++){
				System.out.print(data[i][j] + " ");
			}
		}
		System.out.println();
		System.out.println();

		// Инициализация первого случайного вектора расстановки
		int [] vector0 = Otjic.getVector(data);
		while(true){
			// Подсчет выгоды первого распределения
			int l0 = Otjic.getValue(vector0, data);

			// Инициализация копии первого вектора
			int [] vector1 = Arrays.copyOf(vector0, vector0.length);

			// Генерация двух чисел в диапазоне длины одной строки двумерной исходной матрицы
			int [] twoNumbers = Otjic.getTwoRandomNumbers(vector1);

			// Пока элементы по этим индексам одинаковые, изменяем индексы
			while(vector1[twoNumbers[0]] == vector1[twoNumbers[1]])
				twoNumbers = Otjic.getTwoRandomNumbers(vector1);

			// Меняем местами элементы, находящиеся на этих двух позициях в векторе-копии
			vector1[twoNumbers[0]] = vector1[twoNumbers[0]] + vector1[twoNumbers[1]] - (vector1[twoNumbers[1]] = vector1[twoNumbers[0]]);

			// Подсчет выгоды полученного расположения
			int l1 = Otjic.getValue(vector1, data);

			// Уменьшение "температуры"
			T *= alpha;

			// Проверка условия окончания расчетов
			if (l1 < l0){

				// Вывод результата
				for (int i = 0; i < vector0.length; i ++){
					System.out.print(vector0[i] + " ");
				}
				break;
			}

			// Даем "шанс" полученному вектору, который не проходит проверку всеравно продолжить участие в дальнейших расчетах
			else{

				// Вычисление вероятности, с которой следует ему продолжать учавствовать в рассчетах
				int dS = l0 - l1;
				double P = T * Math.exp(-dS / T);

				// Если больше случайного числа в заданном диапазоне, то вектор берется за опорный и цикл продолжается
				if (P > Otjic.random(1, 100))
					vector0 = vector1;

				// Иначе расчеты завершены
				else{

					// Вывод ответа
					for (int i = 0; i < vector0.length; i ++){
						System.out.print(vector0[i] + " ");
					}
					break;
				}
			}
		}
	}
}