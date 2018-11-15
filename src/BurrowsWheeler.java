import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.Arrays;

public class BurrowsWheeler
{
    // apply Burrows-Wheeler transform, reading from standard input and writing to standard output
    public static void transform()
    {
        String s = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(s);
        int start = 0   ;
        char[] original = s.toCharArray();
        char[] lastcol = new char[csa.length()];
        for (int i = 0; i < csa.length(); i++)
        {
            if (csa.index(i) == 0)
            {
                start = i;
                lastcol[0] = original[original.length - 1];
            }
            else
            {
                lastcol[csa.index(i)] = original[csa.index(i) - 1];
            }
        }
        BinaryStdOut.write(start);
        BinaryStdOut.write(new String(lastcol));
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
    public static void inverseTransform()
    {
        int start = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();
        int length = s.length();// string length
        char[] lastcol = s.toCharArray();
        char[] firstcol = Arrays.copyOf(lastcol,length);
        Arrays.sort(firstcol);
        int[] next = new int[length];
        // construct next[]
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (lastcol[j] == firstcol[i])
                {
                    next[i] = j;
                }
            }
        }
        char[] original = new char[length];
        original[0] = firstcol[start];
        for (int i = 1; i < length; i++)
        {
            original[i] = firstcol[next[start]];
            start = next[start];
        }
        BinaryStdOut.write(new String(original));
        BinaryStdOut.close();
    }

    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args)
    {
        if (args[0].equals("-"))
        {
            transform();
        }
        if (args[0].equals("+"))
        {
            inverseTransform();
        }
    }
}
