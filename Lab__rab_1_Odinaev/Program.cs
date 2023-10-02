///////////////// Лабораторная работа 1 задание 1
//Console.Write("Введите значение x:");
//double x = double.Parse(Console.ReadLine());
//Console.Write("Введите значение y:");
//double y = double.Parse(Console.ReadLine());
//Console.Write("Введите значение a:");
//double a = double.Parse(Console.ReadLine());
//double numerator = Math.Cos((Math.Pow(x, 3)) + 6) - Math.Sin(y - a);
//double denominator = Math.Log(Math.Pow(x, 4)) - 2 * Math.Pow(Math.Sin(x), 5);
//double D = numerator / denominator;
//Console.WriteLine($"D = {D}");

////////////// Лабораторная работа 1 задание 2
//Console.Write("Введите координату a1:");
//double a1 = double.Parse(Console.ReadLine());
//Console.Write("Введите координату a2:");
//double a2 = double.Parse(Console.ReadLine());
//Console.Write("Введите координату b1:");
//double b1 = double.Parse(Console.ReadLine());
//Console.Write("Введите координату b2:");
//double b2 = double.Parse(Console.ReadLine());
//double numerator = (a1*b1)+(a2*b2);
//double denominator = Math.Sqrt((Math.Pow(a1,2)+Math.Pow(a2,2)))*Math.Sqrt(Math.Pow(b1,2)+Math.Pow(b2,2));
//Double Cos_alpha = numerator/denominator;
//Console.WriteLine($"Cos_alpha = {Cos_alpha}");


//////////////////////// Лабораторная работа 1 задание 3
Console.Write("Введите номер места товара: ");
int a = int.Parse(Console.ReadLine());
 int level = (a / 120) + 1;
int section = (a % 120 / 15) + 1;
Console.WriteLine($"Ярус: {level}, Секция: {section}");









