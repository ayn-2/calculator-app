import java.util.Scanner;
public class CalculatorApp {
    
    //★三上★
    public static  String fullHalf(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            //全角数字
            if (c >= '０' && c <= '９') {
                sb.append((char) (c - '０' + '0'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    //★★★★★★★★
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = 0;
        double num2 = 0;
        String op;

        while (true) { 
            
            // 1つ目の数値入力
            while (true){
                System.out.print("1つ目の数値を入力してください: ");
                //一度文字列（String）で数字を受け取る。
                String input1 = scanner.nextLine();

                //★三上★
                input1 = fullHalf(input1);

                if(input1.trim().isEmpty()) {
                    System.out.println("エラー：不正な文字が入力されました");
                    continue;
                }
                //★★★★★★★★

                // 数字が13桁以上の場合はエラーを表示する
                if (input1.length() >= 13) {
                    System.out.println("エラー：数が大きすぎます！1つ目の数値を入力してください。");
                    continue;
                }
                //★三上★
                try {
                    num1 = Double.parseDouble(input1);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("エラー：不正な文字が入力されました");
                }
                //★★★★★★★★
            }

            // 演算子の入力
            while (true) {
                System.out.print("演算子を入力してください(+, -, *, /): ");
                op = scanner.next();
                //★三上
                scanner.nextLine();
                //★★★★★★

                if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                    break;
                }
                //★森本★三上
                System.out.println("エラー：不明な演算子です。");
                //★★★★★★
            }

            // 2つ目の数値入力
            while (true){
                System.out.print("2つ目の数値を入力してください: ");
                //一度文字列（String）で数字を受け取る。
                String input2 = scanner.nextLine();

                //★三上★
                input2 = fullHalf(input2);

                if(input2.trim().isEmpty()) {
                    System.out.println("エラー：不正な文字が入力されました");
                    continue;
                }
                //★★★★★★★★

                // 数字が13桁以上の場合はエラーを表示する
                if (input2.length() >= 13) {
                    System.out.println("エラー：数が大きすぎます！2つ目の数値を入力してください。");
                    continue;
                } 

                //★三上★
                try {
                    num2 = Double.parseDouble(input2);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("エラー：不正な文字が入力されました");
                }
                //★★★★★★★★
            } 

            double result = calculate(num1, op, num2);

            //計算結果が13桁以上の場合、または演算子が正しくない場合、エラー表示にする
            if (result >= 1000000000000.0){
                System.out.println("エラー:数が大きすぎます！");
            } else if (Double.isNaN(result)) {
                System.out.println("エラー：不明な計算結果です。");
            } else {
                System.out.println("計算結果: " + result);
                break;
            }
        }

        scanner.close();
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
