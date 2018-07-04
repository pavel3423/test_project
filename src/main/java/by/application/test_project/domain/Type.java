package by.application.test_project.domain;

import by.application.test_project.utils.ThreadUtil;

public enum Type {

    PRINT,
    RANDOM {
        @Override
        public void run() {
            ThreadUtil.sleep(1000);
        }
    }, COMPLETED {
        @Override
        public void run() {
            ThreadUtil.sleep(1000);
        }
    }, DELAYED {
        @Override
        public void run() {
            ThreadUtil.sleep(10000);
        }
    };

    public void run() {
    }
}
