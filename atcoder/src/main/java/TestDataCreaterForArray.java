import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TestDataCreaterForArray {

    public static void main(String[] args) {

        // 入力
        System.out.println("作成したいテストデータの番号を入力してください。");
        System.out.println("1: 数字nから数字mまでの連番");
        System.out.println("2: 文字列sの繰り返しをn個");

        Scanner sc = new Scanner(System.in);
        int command = Integer.parseInt(sc.next());

        String text = null;
        if (command == 1) {
            System.out.println("連番を開始する数と連番を終了する数を、スペース区切りで入力してください。");
            System.out.println("例：\"1 5\"と入力すると、\"1 2 3 4 5\"が出力されます。");
            long start = Long.parseLong(sc.next());
            long end = Long.parseLong(sc.next());
            text = createConsecutiveNumber(start, end);

        } else if (command == 2) {
            System.out.println("テストデータとその繰り返し回数をスペース区切りで入力してください。");
            System.out.println("例：\"1 3\"と入力すると、\"1 1 1\"が出力されます。");
            String str = sc.next();
            long repeat = Long.parseLong(sc.next());
            text = createRepeatString(str, repeat);
        }
        sc.close();

        // テキストファイルに出力する
        if (text == null) {
            System.out.println("テストデータを作成せずに終了します。");
        } else {
            String path = new File(".").getAbsoluteFile().getParent() + "/testdata.txt";
            try {
                outputTextFile(path, text);
                System.out.println("テストデータを作成しました。 -> " + path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 連番テストデータ生成。<br>
     * startからendまでの連番をスペース区切りにした文字列を生成する。
     * 
     * @param start 連番を開始する数
     * @param end   連番を終了する数
     * @return テストデータ
     */
    public static String createConsecutiveNumber(long start, long end) {
        StringBuilder sb = new StringBuilder();
        if (start <= end) {
            for (long i = start; i < end; i++) {
                sb.append(Long.toString(i) + " ");
            }
        } else {
            for (long i = start; end < i; i--) {
                sb.append(Long.toString(i) + " ");
            }
        }
        sb.append(Long.toString(end));
        return sb.toString();
    }

    /**
     * 繰り返しテストデータ生成<br>
     * 文字列strをスペース区切りで任意の回数繰り返した文字列を生成する。
     * 
     * @param str    繰り返したい文字列
     * @param repeat 繰り返したい回数
     * @return テストデータ
     */
    public static String createRepeatString(String str, long repeat) {
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < repeat - 1; i++) {
            sb.append(str + " ");
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * テキストファイル出力<br>
     * 文字列をテキストファイルに出力する。
     * 
     * @param path 出力するテキストファイルのフルパス
     * @param text ファイルに書き込む文字列
     */
    public static void outputTextFile(String path, String text) throws Exception {
        File f = new File(path);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(text);
        bw.newLine();
        bw.close();
    }
}