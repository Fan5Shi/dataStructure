/** Represents an array of integers each in the range -8..7.
 *  Such integers may be represented in 4 bits (called nybbles).
 *  @author Jilin He
 */
public class Nybbles {

    /** Maximum positive value of a Nybble. */
    public static final int MAX_VALUE = 7;

    /** Return an array of size N. 
    * DON'T CHANGE THIS.*/
    public Nybbles(int N) {
        _data = new int[(N + 7) / 8];
        _n = N;
    }

    /** Return the size of THIS. */
    public int size() {
        return _n;
    }

    /** Return the Kth integer in THIS array, numbering from 0.
     *  Assumes 0 <= K < N. */
    public int get(int k) {
        if (k < 0 || k >= _n) {
            throw new IndexOutOfBoundsException();
        } else {
            int temp1 = k / 8;
            int temp2 = 0;
            if (temp1 == 0) {
                temp2 = k;
            } else {
                temp2 = k % 8;
            }
            int temp3 = (_data[temp1] >> ((temp2) * 4)) & 15;
            if (temp3 < 8) {
                return temp3;
            } else {
                return -((temp3 ^ 15) + 1);
            }
        }
    }

    /** Set the Kth integer in THIS array to VAL.  Assumes
     *  0 <= K < N and -8 <= VAL < 8. */
    public void set(int k, int val) {
        if (k < 0 || k >= _n) {
            throw new IndexOutOfBoundsException();
        } else if (val < (-MAX_VALUE - 1) || val > MAX_VALUE) {
            throw new IllegalArgumentException();
        } else {
            int temp1 = k / 8;
            int temp2 = 0;
            if (temp1 == 0) {
                temp2 = k;
            } else {
                temp2 = k % 8;
            }
            val = val & 15;
            int mask = val << ((temp2) * 4);
            _data[temp1] = _data[temp1] + mask;
        }
    }

    /** DON'T CHANGE OR ADD TO THESE.*/
    /** Size of current array (in nybbles). */
    private int _n;
    /** The array data, packed 8 nybbles to an int. */
    private int[] _data;
}
