import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CircularSuffixArray
{
    private char[] original;
    private Line[] lines;
    int[] stringtoint;
    public CircularSuffixArray(String s)    // circular suffix array of s
    {
        original = s.toCharArray();
        lines = new Line[original.length];
        for (int j = 0; j < original.length; j++)
        {
            stringtoint[j] = (int) original[j];
            lines[j] = new Line(j);
        }
        Arrays.sort(lines);
    }
    public int length()                     // length of s
    {
        return original.length;
    }
    public int index(int i)                 // returns index of ith sorted suffix
    {
        return lines[i].getIndex();
    }
    public static void main(String[] args)  // unit testing (required)
    {

    }
    private class Line implements Comparable<Line>
    {
        private final int index;
        public Line(int row)
        {
            index = row;
        }
        public int getIndex()
        {
            return index;
        }
        @Override
        public int compareTo(Line o)
        {
            return Compare(o,0);
        }
        private int Compare(Line o, int layer)
        {
            int currentcompare1;
            int currentcompare2;
            if (o.index + layer < stringtoint.length)
            {
                currentcompare1 = o.index + layer;
            }
            else
            {
                currentcompare1 = o.index + layer - stringtoint.length;
            }
            if (this.index + layer < stringtoint.length)
            {
                currentcompare2 = this.index + layer;
            }
            else
            {
                currentcompare2 = this.index + layer - stringtoint.length;
            }
            //====================================
            if (stringtoint[currentcompare1] > stringtoint[currentcompare2])
            {
                return -1;
            }
            else if (stringtoint[currentcompare1] < stringtoint[currentcompare2])
            {
                return 1;
            }
            else
            {
                layer ++;
                return Compare(o,layer);
            }
        }
    }
}
