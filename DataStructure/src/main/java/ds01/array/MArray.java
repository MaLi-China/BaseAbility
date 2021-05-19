package ds01.array;

/**
 * 功能说明：优化数组的插入与删除
 * 删除操作:
 * <p>
 * 开发人员：@Author MaLi
 */
public class MArray {
    private int[] arr;
    //新增则加一, 删除则减一
    private int capacity = 0;
    private int[] toDeleteIndexs;
    private int tdiCapacity = 0;
    private int time = 1;
    private int defaultLength = 10;

    public MArray() {
        this.arr = new int[defaultLength];
        this.toDeleteIndexs = new int[defaultLength];
    }

    public MArray(int length) {
        this.arr = new int[length];
        this.toDeleteIndexs = new int[length];
    }

    public MArray(int length, int time) {
        this(length);
        this.time = time;
    }

    public void delete(int index) {
        //根据要删除的元素是否达到toDeleteIndexs个数, 执行真正的删除, 还是记录要删除的位置
        if (time == 1) {
            // 执行删除
//            如何移动, 效率最合理

        } else if (toDeleteIndexs.length < time) {
            // 执行记录
            toDeleteIndexs[tdiCapacity] = index;
            tdiCapacity++;
        } else {
            // 执行删除


        }
    }

    public void insert(int index, int element) {

    }
}
