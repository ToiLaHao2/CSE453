package main;

public class EncryptMessage {

	public String Encryption(String message) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		char currentChar, nextChar;
		int length = message.length();
		for (int i = 0; i < length - 1; i = i + 2) {
			currentChar = message.charAt(i);
			nextChar = message.charAt(i + 1);
			sb1.append(nextChar);
			sb1.append(currentChar);
		}
		if (length % 2 != 0) // Bug fixed here
		{
			sb1.append(message.charAt(length - 1));
		}

		for (int i = 0; i < sb1.length(); i++) {
			currentChar = sb1.charAt(i);
			if (currentChar < 'a' || currentChar > 'z')// Bug fixed here
				return "invalid";
			else {
				currentChar = (char) ('z' - (currentChar - 'a')); // Bug fixed here
				sb2.append(currentChar);
			}
		}
		return sb2.toString();

	}

}
