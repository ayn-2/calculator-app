import java.util.Scanner;
public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1つ目の数値入力
        System.out.print(" 1つ目の数値を入力してください。");
        double num1 = scanner.nextDouble();

        //演算子の入力
        System.out.print("演算子を入力してください");
        String op = scanner.next();

        //2つ目の数値入力
        System.out.print("2つ目の数値を入力してください。");
        double num2 = scanner.nextDouble();

        scanner.close();

        System.out.println("計算結果: " + calculate(num1, op, num2));
    }

    //計算結果の表示
    public static double calculate(double num1, String op, double num2){
        if (op .equals ("+")){
            return(num1 + num2);
        } else if(op .equals ("-")){
            return(num1 - num2);
        }else if(op .equals ("*")){
            return(num1 * num2);
        }else if(op .equals ("/")){
            return(num1 / num2);
        } else {
            System.out.println("不明な演算子です。");
            return 0;
            //エラーが出た時にreturn 0;と表示されるようになっているため、どう見せるか修正するか決める必要がある。
        }
    }
}
