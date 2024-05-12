import Converter.Converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите выражение из двух чисел от 1 до 10 или от I до X, оператор +, -, /, *:  ");
        String exp = scn.nextLine();
        int lenExpr = exp.split(" ").length;
        if (lenExpr == 3) {

        }
        else {
            throw new Exception("Введите выражение из двух чисел  формата 3 + 2 или III + II");
        }

        //Определяем арифметическое действие:
        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }

        }
        //Если не нашли арифметического действия, завершаем программу
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);
        String[] data0 = exp.split(" ");
        for (String word : data0) {
        }
        //Определяем, находятся ли числа в одном формате (оба римские или оба арабские)
        if(converter.isRoman(data0[0]) == converter.isRoman(data0[2])){
            int a, b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman){
                a = converter.romanToInt(data0[0]);
                b = converter.romanToInt(data0[2]);

            }
            else {


                //конвертируем арабские числа из строки в число

                a = Integer.parseInt(data0[0]);
                b = Integer.parseInt(data0[2]);
            }
            if (a<=10 && b<=10) {
            }
            else {
                throw new Exception("Введите значения от 0 до 10 или  от I до X");

            }
            //выполняем с числами арифметическое действие
            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRoman){
                System.out.println("Результат: "+converter.intToRoman(result));
            }
            else {
                //если числа были арабские, возвращаем результат в арабском числе
                System.out.println("Результат: "+result);
            }}

        else{
            throw new Exception("Числа должны быть в одном формате");
        }
    }




}