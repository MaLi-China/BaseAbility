package Base_05;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class SortedDynamicArray extends DynamicArray {
    @Override
    public void add(Integer e) {
        ensureCapacity();
        // 排序逻辑: 逆序
        int i = 0;
        for (i = size - 1; i >= 0; i--) {
            if (e > elements[i]) {
                elements[i + 1] = elements[i];
            } else {
                break;
            }
        }
        elements[i + 1] = e;
        size++;
    }
}

class Example {
    public static void test(DynamicArray dynamicArray) {
        dynamicArray.add(1);
        dynamicArray.add(3);
        dynamicArray.add(5);
        for (int i = 0; i < dynamicArray.size; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    public static void main(String[] args) {
        DynamicArray array = new SortedDynamicArray();
        test(array);
    }
}
