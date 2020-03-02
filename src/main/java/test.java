import java.util.Scanner;

//00707738
public class test {

	static int n, i, j;
	static int row = 1;

	public static void main(String[] args) {

		System.out.println("Enter rows");
		try (Scanner s = new Scanner(System.in)) {
			n = s.nextInt();
			// row = n - 1;
		}
		for (i = 0; i < n; i++) {
//when i=0 ,j=0 1star will be printed ,i=1 ,j=0,1 hence two stars will be printed and so on
//print space before printing star make one more loop

			for (j = 1; j < n - 1; j++) {
				System.out.print(" ");
			}

			for (j = 1; j <= 2 * i - 1; j++) {

				System.out.print("*");
				System.out.println();
			}

			// ending line after each row

		}

		for (i = row; i >= 0; i--) {
//when i=3,j=1,2,3 so three stars will be printed
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
