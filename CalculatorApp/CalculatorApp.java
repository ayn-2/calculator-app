import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
public class CalculatorApp {
    
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = BigDecimal.ZERO;
        String op;

        while (true) { 
            
            // 1つ目の数値入力
            while (true){
                System.out.print("1つ目の数値を入力してください: ");
                //一度文字列（String）で数字を受け取る。
                String input1 = scanner.nextLine();


                input1 = fullHalf(input1);

                if(input1.trim().isEmpty()) {
                    System.out.println("エラー：不正な文字が入力されました");
                    continue;
                }


                // 数字が13桁以上の場合はエラーを表示する
                if (input1.length() >= 13) {
                    System.out.println("エラー：数が大きすぎます！1つ目の数値を入力してください。");
                    continue;
                }

                try {
                    num1 = new BigDecimal(input1);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("エラー：不正な文字が入力されました");
                }
            }

            // 演算子の入力
            while (true) {
                System.out.print("演算子を入力してください(+, -, *, /): ");
                op = scanner.nextLine();

                if (op.equals("+") || op.equals("＋") 
                    || op.equals("-") || op.equals("ー")  
                    || op.equals("*") || op.equals("＊")  
                    || op.equals("/") || op.equals("／") ) {
                    break;
                }
                
                System.out.println("エラー：不明な演算子です。");
                
            }

            // 2つ目の数値入力
            while (true){
                System.out.print("2つ目の数値を入力してください: ");
                //一度文字列（String）で数字を受け取る。
                String input2 = scanner.nextLine();


                input2 = fullHalf(input2);

                if(input2.trim().isEmpty()) {
                    System.out.println("エラー：不正な文字が入力されました");
                    continue;
                }


                // 数字が13桁以上の場合はエラーを表示する
                if (input2.length() >= 13) {
                    System.out.println("エラー：数が大きすぎます！2つ目の数値を入力してください。");
                    continue;
                } 


                try {
                    num2 = new BigDecimal(input2);

                    if((op.equals("/") || op.equals("／")) && num2.compareTo(BigDecimal.ZERO) == 0) {
                        System.out.println("エラー：不正な値が入力されました");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("エラー：不正な文字が入力されました");
                }
            } 

            BigDecimal result = calculate(num1, op, num2);

            //計算結果が13桁以上の場合、または演算子が正しくない場合、エラー表示にする
            if (result == null) {
                System.out.println("エラー：不明な計算結果です。");
            } else if (result.compareTo(new BigDecimal("1000000000000")) >= 0){
                System.out.println("エラー:数が大きすぎます！");
            } else {
                DecimalFormat df = new DecimalFormat("#,###.###############");
                System.out.println("計算結果: " + df.format(result));
                break;
            }
        }

        scanner.close();
    }

    // 計算結果の表示
    public static BigDecimal calculate(BigDecimal num1, String op, BigDecimal num2) {
        if (op.equals("+") || op.equals("＋")) {
            return num1.add(num2);
        } else if (op.equals("-")  || op.equals("ー")) {
            return num1.subtract(num2);
        } else if (op.equals("*")  || op.equals("＊")) {
            return num1.multiply(num2);
        } else if (op.equals("/")  || op.equals("／")) {
            return num1.divide(num2, 15, RoundingMode.HALF_UP);
        } else {
            return null;
        }
    }
}
