package write;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:\\Users\\S1-06\\Desktop\\fruit.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Peach, 100, 1000");
			pw.println("Pear, 10, 1500");
			pw.println("Shine muscat, 20, 3000");
			pw.close();
			System.out.println("完了");
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
