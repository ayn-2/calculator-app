import java.util.Scanner;
public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = 0;
        double num2 = 0;

        // 1つ目の数値入力
        System.out.print("1つ目の数値を入力してください: ");
        //一度文字列（String）で数字を受け取る。
        String input1 = scanner.next();

        // 数字が13桁以上の場合はエラーを表示する
        if (input1.length() >= 13) {
            System.out.println("エラー：数が大きすぎます！1つ目の数値を入力してください。");
        } else {
            //文字から数字（Stringからdoubleに変換）してnum1に保存する。
            num1 = Double.parseDouble(input1);
        }

        // 演算子の入力
        String op;
        while (true) {
            System.out.print("演算子を入力してください(+, -, *, /): ");
            op = scanner.next();

            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                break;
            }
            System.out.println("エラー：正しい演算子を入力してください(+, -, *, /)");
        }

        // 2つ目の数値入力
        System.out.print("2つ目の数値を入力してください: ");
        //一度文字列（String）で数字を受け取る。
        String input2 = scanner.next();

        // 数字が13桁以上の場合はエラーを表示する
        if (input2.length() >= 13) {
            System.out.println("エラー：数が大きすぎます！2つ目の数値を入力してください。");
        } else {
            //文字から数字（Stringからdoubleに変換）してnum2に保存する。
            num2 = Double.parseDouble(input2);
        }

        scanner.close();
        double result = calculate(num1, op, num2);

        if (Double.isNaN(result)) {
            System.out.println("エラー：不明な計算結果です。");
        } else {
            System.out.println("計算結果: " + result);
        }
    }

    // 計算結果の表示
    public static double calculate(double num1, String op, double num2) {
        if (op.equals("+")) {
            return (num1 + num2);
        } else if (op.equals("-")) {
            return (num1 - num2);
        } else if (op.equals("*")) {
            return (num1 * num2);
        } else if (op.equals("/")) {
            return (num1 / num2);
        } else {
            return Double.NaN;
            //エラーが出た時にreturn 0;と表示されるようになっているため、どう見せるか修正するか決める必要がある。
        }
    }
}
