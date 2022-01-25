import java.util.*;
public class Main {
	public static void main(String args[])
	{
		System.out.println("Enter the reciever e-mail:");
		Scanner sc=new Scanner(System.in);
		String recevier=sc.nextLine();
		javasendmail.sendmail(recevier);
	}
}
