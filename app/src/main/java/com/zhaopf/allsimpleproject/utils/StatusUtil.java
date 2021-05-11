package com.zhaopf.allsimpleproject.utils;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/5/11 17:16
 * @Github https://github.com/zhao-pf
 * https://juejin.cn/post/6844903879155384333
 * Android 十六进制状态管理 工具类
 */
public class StatusUtil {

    public static final int STATUS_1 = 0x0001;
    public static final int STATUS_2 = 0x0002;
    public static final int STATUS_3 = 0x0004;
    public static final int STATUS_4 = 0x0008;
    public static final int STATUS_5 = 0x0010;
    public static final int STATUS_6 = 0x0020;
    public static final int STATUS_7 = 0x0040;
    public static final int STATUS_8 = 0x0080;

    /**
     * 状态名称      十六进制     二进制
     * STATUS_1      0001       0010
     * STATUS_2      0002       0001
     * 第一次位或结果              0011
     * STATUS_3      0004       0100
     * 第二次位或结果              0111
     */
    public static final int MODE_A = STATUS_1 | STATUS_2 | STATUS_3;

    /**
     * 状态名称      十六进制     二进制
     * STATUS_1      0001       0010
     * STATUS_2      0002       0001
     * 第一次位或结果              0011
     */
    public static final int MODE_B = STATUS_1 | STATUS_2;
    public static final int MODE_C = STATUS_1 | STATUS_4 | STATUS_5 | STATUS_6 | STATUS_8;
    public static final int MODE_D = STATUS_6 | STATUS_7 | STATUS_8;
    public static final int MODE_E = STATUS_1 | STATUS_7 | STATUS_8;
    public static final int MODE_F = STATUS_3 | STATUS_6 | STATUS_8 | STATUS_5;




    /**
     * 当我们需要从状态集中移除状态时，就通过取反运算。
     * statuses & ~status
     * <p>
     * deleteStatus(MODE_A,STATUS_3) // 从MODE_A中删除STATUS_3
     */
    public static int deleteStatus(int statuses, int status) {
        /**
         * statuses二进制      status二进制
         *   0111               0100
         * 首先进行取反 0100 -> 1011
         * 然后进行与运算
         * 0111
         * 1011
         * 0011
         */
        return statuses & ~status;
    }

    /**
     * statuses二进制      status二进制
     *   0011               0100
     * 然后进行或运算
     *  0011
     *  0100
     *  0111
     */
    public static int addStatus(int statuses, int status) {
        return statuses | status;
    }


    /**
     * isStatusEnable(MODE_A,STATUS_3)
     * MODE_A 是否包含 STATUS_3
     * statuses二进制      status二进制
     *   0111               0100
     * 然后进行与运算
     *  0111
     *  0100
     *  0100 !=0 所以存在
     *
     *  isStatusEnable(MODE_A,STATUS_4)
     *  statuses二进制      status二进制
     *     0111               1000
     *
     *  与运算
     *  0111
     *  1000
     *  0000 ==0 所以不存在
     *
     */
    public static boolean isStatusEnable(int statuses, int status) {
        return (statuses & status) != 0;
    }



}
