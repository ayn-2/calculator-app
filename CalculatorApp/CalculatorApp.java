import java.util.Scanner;
public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1つ目の数値入力
        System.out.print(" 1つ目の数値を入力してください。");
        double num1 = scanner.nextDouble();

        //演算子の入力
        String op;
        while (true) {
            System.out.print("演算子を入力してください(+, -, *, /)");
            op = scanner.next();

            if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                break;
            }
            System.out.print("エラー：正しい演算子を入力してください(+, -, *, /)");
        }

        //2つ目の数値入力
        System.out.print("2つ目の数値を入力してください。");
        double num2 = scanner.nextDouble();

        scanner.close();
     　 double result = calculate(num1, op, num2);

        if(Double.isNaN(result)) {
            System.out.println("エラー：不明な計算結果です。");
        } else {
            System.out.println("計算結果: " + result);
        }
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
            return Double.NaN;
            //エラーが出た時にreturn 0;と表示されるようになっているため、どう見せるか修正するか決める必要がある。
        }
    }
}
