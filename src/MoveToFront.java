import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.SET;

import java.util.LinkedList;
public class MoveToFront
{
    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode()
    {
        LinkedList<Character> ascii = new LinkedList<>();
        for (int i = 0; i < ascii.size(); i++)
        {
            ascii.add((char) i);
        }
        while (!BinaryStdIn.isEmpty())
        {
            char c = BinaryStdIn.readChar();
            ascii.remove((int) c);
            ascii.addFirst( c );
            BinaryStdOut.write((int) c);
        }
        BinaryStdOut.flush();
        BinaryStdOut.close();
    }
    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode()
    {

    }
    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args)
    {

    }
}
