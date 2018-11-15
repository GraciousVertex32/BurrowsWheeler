import java.util.Arrays;
public class CircularSuffixArray
{
    private Line[] lines;
    private int[] stringtoint;
    private int length;
    public CircularSuffixArray(String s)    // circular suffix array of s
    {
        if (s == null)
        {
            throw new java.lang.IllegalArgumentException();
        }
        char[] original;
        original = s.toCharArray();
        length = original.length;
        lines = new Line[length];

        stringtoint = new int[length];
        for (int j = 0; j < length; j++)
        {
            stringtoint[j] = (int) original[j];
            lines[j] = new Line(j);
        }
        Arrays.sort(lines);
    }
    public int length()                     // length of s
    {
        return length;
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
            if (o.index + layer < length)
            {
                currentcompare1 = o.index + layer;
            }
            else
            {
                currentcompare1 = o.index + layer - length;
            }
            if (this.index + layer < length)
            {
                currentcompare2 = this.index + layer;
            }
            else
            {
                currentcompare2 = this.index + layer - length;
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
