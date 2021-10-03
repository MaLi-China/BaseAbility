package ds01.array;

import org.junit.Test;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MT01_Array {
    private int[] iArr;
    private int cursor;

    public MT01_Array() {
        this.cursor = 0;
        this.iArr = new int[this.cursor];
    }


    //random get
    public int get(int index) {
        if (index < 0 && index >= iArr.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds...");
        }
        return iArr[index];
    }

    //update array element
    public void update(int index, int value) {
        if (index < 0 && index >= iArr.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds...");
        }
        iArr[index] = value;
    }

    //insert - 1, tail
    public void insertTail(int value) {
        if (this.cursor == iArr.length) {
            resize();
        }
        iArr[cursor++] = value;
    }

    //insert - 2, middle
    public int[] insertMiddle(int position, int value) {
        // 扩容
        if (this.cursor == iArr.length) {
            this.iArr = resize();
        }
        // 移动插入点后面的元素
        // 0,1,2,3,4,5,6,7,8,9
        // position = 0
        // cursor = 9
        System.out.println("cursor: " + this.cursor);
        for (int i = cursor; i >= position; i--) {
            iArr[i] = iArr[i - 1];
        }
        // 在插入点位置插入指定元素
        iArr[position] = value;
        // 更新当前角标
        cursor++;
        return iArr;
    }

    //insert - 3, resize insert

    //delete - 1, tail

    //delete - 2, middle

    //delete - 3, batch

    public int[] resize() {
        int[] newiArr = new int[iArr.length * 2];
        for (int i = 0; i < iArr.length; i++) {
            newiArr[i] = iArr[i];
        }
        this.iArr = newiArr;
        return iArr;
    }

    @Test
    public void mt02_insertMiddle() {
        MT01_Array array = new MT01_Array();
        for (int i = 0; i < array.iArr.length; i++) {
            array.insertTail(i);
        }
        System.out.println("Before insert...");
        for (int i = 0; i < array.iArr.length; i++) {
            System.out.print(array.iArr[i] + " ");
        }
        int[] ints = array.insertMiddle(1, 100);
        System.out.println("\r\nAfter insert...");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    /**
     * Test API: System.arraycopy()
     */
    @Test
    public void mt01() {
        int[] iArray = new int[10];
        for (int i = 0; i < iArray.length; i++) {
            iArray[i] = i;
        }
        int[] iNewArray = new int[iArray.length * 2];
        System.arraycopy(iArray, 0, iNewArray, 0, iArray.length);
        for (int i : iNewArray) {
            System.out.print(i + " ");
        }
    }
}
