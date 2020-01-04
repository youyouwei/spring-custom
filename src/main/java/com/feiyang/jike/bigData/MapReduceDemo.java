package com.feiyang.jike.bigData;

/**
 * @Description: MapReduce编程模型将大数据计算过程切分成Map和Reduce两个阶段
 * 原理：为每个数据块分配一个Map计算任务，然后将所有map输出的Key相同的进行合并，然后把这些合并后的key和value发送给同一个Reduce任务处理
 *
 * 大数据计算的核心是：移动计算比移动数据更划算，因此大数据计算使用了一种叫作MapReduce的编程模型，以便实现移动计算
 * 移动计算是把计算分发到不同的数据块中得到计算Map，然后把结果统一发送到Reduce统计结果（移动计算通过传统的计算模型很难实现）
 * MapReduce是一种计算模型也是一个计算框架
 *
 * @Author: jiahuiyang
 * @Date: Created in 11:43 2019/12/23
 */
public class MapReduceDemo {


}
