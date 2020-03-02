import java.util.Scanner;

public class test2 {
	static int n, i, j;
	static int row = 1;

	public static void main(String[] args) {

		System.out.println("Enter rows");
		try (Scanner s = new Scanner(System.in)) {
			n = s.nextInt();

			if (n % 2 == 0) {
				System.out.println("Please enter an odd number");

			} else {

				for (int i = 1; i <= n; i++) {
					// Print space,for i=1,j=1,2,3,4 so 4 spaces will be printed
					for (int j = i; j < n; j++) {
						System.out.print(' ');
					}
					// when i=1,k=1(less than 2) only 1 star will be printed at first iteration
					// when i=2 ,k=1,2,3 so 3 stars will be printed on second iteration
					// Print '*'
					for (int k = 1; k < 2 * i; k++) {
						System.out.print('*');
					}

					// Move to the next line
					System.out.println();
				}

				// Print lower half
				for (int i = n - 1; i >= 1; i--) {
					// Print space

					// i=2,j=3 one iteration only
					// i=1,j=2,3 so two spaces will printed

					for (int j = n; j > i; j--) {
						System.out.print(' ');
					}

					// Print '*'
					for (int k = 1; k < i * 2; k++) {
						System.out.print('*');
					}

					// Move to the next line
					System.out.println();
				}
			}

		}

	}

}
