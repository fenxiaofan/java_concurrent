package com.fan.java_concurrent.publish;

import com.fan.java_concurrent.annotations.NotRecommend;
import com.fan.java_concurrent.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象逸出
 *
 * 在对象没有完全被创建好之前，不能把对象发布出去
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape () {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
