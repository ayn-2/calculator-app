public class Test2 {
    // 定数
    static final int TAX = 10;

    public static void main(String[] args) throws Exception {
        // 商品の値段
        int apple = 130;
        System.out.println("りんごの代金：" + (apple * (100 + TAX) / 100) + "円");
    }
}
