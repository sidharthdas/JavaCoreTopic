package Externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MainClass implements Externalizable {

	String s;
	int i, j;

	public MainClass() {

		System.out.println("1");
	}

	public static void main(String[] args) {

	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub

		out.writeObject(s);
		out.writeInt(i);

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}
}
