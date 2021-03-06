package org.zeromq.czmq;

public class ZFrame implements AutoCloseable {

    long pointer;

    public ZFrame() {
        pointer = __init();
    }

    public ZFrame(long address) {
        pointer = address;
    }

    native static long __init();

    native static long __init(byte[] buf, long size);

    native static void __destroy(long pointer);

    @Override
    public void close() {
        __destroy(pointer);
        pointer = 0;
    }
}
