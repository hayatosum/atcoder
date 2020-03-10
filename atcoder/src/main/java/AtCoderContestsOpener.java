import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class AtCoderContestsOpener {

    public static void main(String[] args) {

        // 入力
        System.out.println("対象のコンテストIDを入力してください。");
        Scanner sc = new Scanner(System.in);
        String contestName = sc.next();
        sc.close();

        // URLの生成
        String baseUrl = "https://atcoder.jp/contests/" + contestName + "/tasks";
        String[] urlList = new String[6];
        for (int i = 0; i < urlList.length; i++) {
            char rank = (char) ('a' + i);
            urlList[i] = baseUrl + "/" + contestName + "_" + rank;
        }

        // ブラウザを開く
        Desktop desktop = Desktop.getDesktop();
        for (String url : urlList) {
            try {
                URI uri = new URI(url);
                desktop.browse(uri);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}