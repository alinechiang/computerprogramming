/*
 * Lab 1 Spring 2023
 * CST7284 Object Oriented Programming (Java)
 * Student name: Sijie Jiang
 * Lab Section: CST7284
 * Date: May 22, 2023
 * Lab Professor: Amandeep Kahlon
*/
import java.util.Scanner;
public class TelephoneOperator {
	
	//cc: country code, NPA:numbering plan areas, 
	//SN: subscriber number, mac: municipality area code
	public static void dialPhoneNumber(int phoneNumber) {
		if(phoneNumber>99 && phoneNumber<1000) {
			System.out.printf("Dialing special number %s...%n", phoneNumber);
		}else {
			System.out.println("Wrong phone number entered!");
		}
	}
	
	public static void dialPhoneNumber(int NPA, int SN) {
		
		if(NPA>99 && NPA<1000 &&SN >= 1000000 && SN < 20000000) {
			System.out.printf("Dialing local number %s %s-%s...%n", NPA, SN/10000, SN%10000);
		}else {
			System.out.println("Wrong local phone number entered!");
		}
	}
	
	public static void dialPhoneNumber(int cc, int NPA, int SN) {
		if(cc==1 && NPA>99 && NPA<1000 && SN/1000000!=0 && SN/1000000!=1) {
			System.out.printf("Dialing NA long distance phone number %s %s %s-%s...%n", cc,NPA,SN/10000, SN%10000);
		}else {
			System.out.println("Wrong NA long distance phone number entered!");
		}
	}
	
	public static void dialPhoneNumber(int ac, int cc, int mac, int SN) {
		if(ac==11 && cc>99 && cc<1000) {
			System.out.printf("Dialing overseas long distance number 0%s %s %s-%s...%n",ac,cc,mac,SN);
		}else {
			System.out.println("Wrong overseas long distance phone number entered!");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phoneNumber;
		do {
		    System.out.println("<Welcome message to the Telephone Operator program>\nPlease enter a telephone number or -1 to exit:");
		    Scanner scanner = new Scanner(System.in);
			phoneNumber = scanner .nextLine();

		    if (phoneNumber.equals("-1")) {
		        break;  // Exit the loop if -1 is entered
		    }

		    int SpN, NPA, SN, cc, ac, mac;

		    switch (phoneNumber.length()) {
		        case 3:
		            SpN = Integer.parseInt(phoneNumber);
		            dialPhoneNumber(SpN);
		            break;
		        case 10:
		            NPA = Integer.parseInt(phoneNumber.substring(0, 3));
		            SN = Integer.parseInt(phoneNumber.substring(3));
		            dialPhoneNumber(NPA, SN);
		            break;
		        case 11:
		            cc = Integer.parseInt(phoneNumber.substring(0, 1));
		            NPA = Integer.parseInt(phoneNumber.substring(1, 4));
		            SN = Integer.parseInt(phoneNumber.substring(4));
		            dialPhoneNumber(cc, NPA, SN);
		            break;
		        case 12:
		            ac = Integer.parseInt(phoneNumber.substring(0, 3));
		            cc = Integer.parseInt(phoneNumber.substring(3, 6));
		            mac = Integer.parseInt(phoneNumber.substring(6, 8));
		            SN = Integer.parseInt(phoneNumber.substring(8));
		            dialPhoneNumber(ac, cc, mac, SN);
		            break;
		        default:
		            System.out.println("Wrong phone number entered!");
		            break;
		    }
		} while (true);
		System.out.println("Exiting Telephone Operator program...");
	}

}
