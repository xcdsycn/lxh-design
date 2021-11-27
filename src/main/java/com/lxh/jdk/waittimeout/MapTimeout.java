package com.lxh.jdk.waittimeout;

import java.util.HashSet;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/8/6 19:44
 **/
public class MapTimeout {
    public static class DependencyList extends HashSet<SSMDependency> {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        boolean isDone() {
            boolean isDone = true;
            for (SSMDependency ssm : this) {
                isDone &= ssm.isDone();
            }

            return isDone;
        }

        public int getOrder() {
            return size() > 0? this.iterator().next().getOrder() : 0;
        }
    }
}
